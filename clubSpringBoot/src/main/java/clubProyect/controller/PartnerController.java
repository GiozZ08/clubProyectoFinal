package clubProyect.controller;

import clubProyect.controller.validator.InvoiceValidator;
import clubProyect.controller.validator.PartnerValidator;
import clubProyect.controller.validator.PersonValidator;
import clubProyect.controller.validator.UserValidator;
import clubProyect.dto.GuestDto;
import clubProyect.dto.InvoiceDetailDto;
import clubProyect.dto.InvoiceDto;
import clubProyect.dto.PartnerDto;
import clubProyect.dto.PersonDto;
import clubProyect.dto.UserDto;
import clubProyect.Service.ClubService;
import clubProyect.Service.interfaces.PartnerService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@NoArgsConstructor
@Setter
@Getter
@Controller
public class PartnerController implements ControllerInterface  {
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private PartnerValidator partnerValidator;
    @Autowired
    private InvoiceValidator invoiceValidator;
    @Autowired
    private PartnerService service;
    
    private static final String MENU = "ingrese la opcion que desea realizar "
        + "\n 1. Crear invitado"
        + "\n 2. habilitar invitado"
        + "\n 3. deshabilitar invitado"
        + "\n 4. incremento de fondo"
        + "\n 5. hacer consumo"
        + "\n 6. solicitud a VIP"
        + "\n 7. cerrar sesion";

   

    public void session() throws Exception {
       
	}


    
    private void CreateGuest() throws Exception{
        System.out.println("ingrese el nombre del invitado");
        String name = Utils.getReader().nextLine();
        personValidator.validName(name);
        System.out.println("ingrese la cedula del invitado");
        long Identification = personValidator.validIdentification(Utils.getReader().nextLine());
        System.out.println("ingrese el numero de ceular del invitado");
        long PhoneNumber = personValidator.validPhoneNumber(Utils.getReader().nextLine());
        System.out.println("ingrese el nombre de usuario del invitado");
        String userName = Utils.getReader().nextLine();
        userValidator.validUserName(userName);
        System.out.println("ingrese la contraseña del invitado");
        String password = Utils.getReader().nextLine();
        userValidator.validPassword(password);
        PersonDto personDto = new PersonDto();
        personDto.setName(name);
        personDto.setIdentification(Identification);
        personDto.setPhoneNumber(PhoneNumber);
        UserDto userDto = new UserDto();
        userDto.setPersonId(personDto);
        userDto.setUserName(userName);
        userDto.setPassword(password);
        userDto.setRole("guest");
        PartnerDto partnerDto = new PartnerDto();
        GuestDto guestDto = new GuestDto();
        guestDto.setUserId(userDto);
        guestDto.setPartnerId(partnerDto);
        guestDto.setStatusActive(true);
        this.service.createGuest(guestDto);
        System.out.println("se ha creado el usuario exitosamente");
    }
    private void createInvoice() throws Exception {
        System.out.println("ingrese el item de la factura");  
        int item = invoiceValidator.validItem(Utils.getReader().nextLine());
        System.out.println("ingrese la descripcion de la factura");  
        String description = Utils.getReader().nextLine();
        invoiceValidator.validDescription(description);
        System.out.println("ingrese el valor de la factura");  
        double AmountTotal = invoiceValidator.validAmountTotal(Utils.getReader().nextLine());
        
        PersonDto personDto = new PersonDto();
        PartnerDto partnerDto = new PartnerDto();
        //
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setPersonId(personDto);
        invoiceDto.setPartnerId(partnerDto);
        invoiceDto.setStatusInvoice(false);
        invoiceDto.setAmountTotal(AmountTotal);
        invoiceDto.setDateGeneration(Utils.getDate()); 
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        invoiceDetailDto.setIdInvoice(invoiceDto);
        invoiceDetailDto.setItem(item);
        invoiceDetailDto.setDescription(description);
        invoiceDetailDto.setAmountTotal(AmountTotal);
        this.service.createInvoiceDetail(invoiceDetailDto);
        System.out.println("se ha creado la factura exitosamente");
        
    }
    private void incrementAmount() throws Exception{
        System.out.println("Ingrese el monto que desea aumentar");
        double IncreaseFunds = partnerValidator.validIncreaseFunds(Utils.getReader().nextLine());   
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setIncreaseFunds(IncreaseFunds);
        this.service.incrementAmount(partnerDto);
    }
    private void vipPromotion() throws Exception{
        System.out.println("Ascender socio regular a VIP");    
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setType(true);
    }
    private void disableGuest()throws Exception{
        System.out.println("desactivar invitado");
        System.out.println("numero de cedula del invitado");
        long Identification= personValidator.validIdentification(Utils.getReader().nextLine());
        this.service.disableGuest(Identification);
        System.out.println("usuario desactivado");
    }
    private void enableGuest()throws Exception{
        System.out.println("activar invitado");
        System.out.println("numero de cedula del invitado");
        long Identification = personValidator.validIdentification(Utils.getReader().nextLine());
        this.service.enableGuest(Identification);
        System.out.println("usuario activado");
    }
    
}
