package clubProyect.controller;

import clubProyect.controller.validator.InvoiceValidator;
import clubProyect.dto.InvoiceDetailDto;
import clubProyect.dto.InvoiceDto;
import clubProyect.dto.PartnerDto;
import clubProyect.dto.PersonDto;
import clubProyect.dto.UserDto;
import clubProyect.Service.interfaces.GuestService;
import clubProyect.controller.request.CreationGuestRequest;
import clubProyect.controller.request.CreationInvoiceRequest;
import clubProyect.controller.request.CreationUserRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@NoArgsConstructor
@Setter
@Getter
@RestController
public class GuestController implements ControllerInterface {

    @Autowired
    private InvoiceValidator invoiceValidator;
    @Autowired
    private GuestService service;

    // Endpoint para crear una factura
    @PostMapping("/create-invoice")
    private ResponseEntity CreateInvoice(@RequestBody CreationInvoiceRequest request)throws Exception {
        try {
            // Validaciones de entrada
            int item = invoiceValidator.validItem(String.valueOf(request.getItem()));
            invoiceValidator.validDescription(request.getDescription());
            String description = request.getDescription();  // Guarda la descripción después de validarla
            double amountTotal = invoiceValidator.validAmountTotal(String.valueOf(request.getAmountTotal()));

            // Creación de los objetos DTO
            InvoiceDto invoiceDto = new InvoiceDto();
            invoiceDto.setPersonId(new PersonDto()); // Asigna el PersonDto según corresponda
            invoiceDto.setPartnerId(new PartnerDto()); // Asigna el PartnerDto según corresponda
            invoiceDto.setStatusInvoice(false);
            invoiceDto.setAmountTotal(amountTotal);
            invoiceDto.setDateGeneration(Utils.getDate());

            InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
            invoiceDetailDto.setIdInvoice(invoiceDto);
            invoiceDetailDto.setItem(item);
            invoiceDetailDto.setDescription(description);
            invoiceDetailDto.setAmountTotal(amountTotal);

            // Llamada al servicio para crear el detalle de la factura
            service.createInvoiceDetail(invoiceDetailDto);

            return new ResponseEntity<>("Factura creada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint para convertir un invitado a socio
    @PostMapping("/guest")
    public ResponseEntity<String> convertPartner(@RequestBody CreationUserRequest request) {
        try {
            PartnerDto partnerDto = new PartnerDto();
            UserDto userDto = new UserDto();
            
            // Asignación y validación de datos
            double amountTotal = invoiceValidator.validAmountTotal(String.valueOf(request.getIncreaseFunds()));
            partnerDto.setUserId(userDto);
            partnerDto.setIncreaseFunds(amountTotal);
            partnerDto.setType(true);
            partnerDto.setAffiliationDate(Utils.getDate());

            // Llamada al servicio para convertir el invitado a socio
            service.convertPartner(partnerDto);

            return new ResponseEntity<>("Se ha convertido en socio exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void session() throws Exception {
    }
}
