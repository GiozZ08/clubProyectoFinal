package clubProyect.controller;

import clubProyect.controller.validator.PartnerValidator;
import clubProyect.controller.validator.PersonValidator;
import clubProyect.controller.validator.UserValidator;
import clubProyect.dto.PartnerDto;
import clubProyect.dto.PersonDto;
import clubProyect.dto.UserDto;
import clubProyect.Service.ClubService;
import clubProyect.Service.interfaces.AdminService;
import clubProyect.controller.request.CreationUserRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Getter
@Setter
@NoArgsConstructor
@RestController
public  class AdminController implements ControllerInterface{
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private PartnerValidator partnerValidator;
    @Autowired
    private AdminService service;
    private static final String MENU = "ingrese la opcion que desea realizar "
        + "\n 1. para crear Socio "
        + "\n 2. Historial de facturas"
        + "\n 3. promocion a VIP"
        + "\n 4. cerrar sesion";


    
    public void session() throws Exception {
	
	}

   
    @PostMapping("/club")
    private ResponseEntity CreatePartner(@RequestBody CreationUserRequest request) throws Exception{
        try{
        String name = request.getName();
	personValidator.validName(name);
        long Identification = personValidator.validIdentification(request.getIdentification());
	long PhoneNumber = personValidator.validPhoneNumber(request.getPhoneNumber());
	String userName = request.getUserName() ;
	userValidator.validUserName(userName);
	String password = request.getPassword();
	userValidator.validPassword(password);
        double IncreaseFunds = partnerValidator.validIncreaseFunds(request.getIncreaseFunds());
        
	PersonDto personDto = new PersonDto();
	personDto.setName(name);
	personDto.setIdentification(Identification);
	personDto.setPhoneNumber(PhoneNumber);
	UserDto userDto = new UserDto();
	userDto.setPersonId(personDto);
	userDto.setUserName(userName);
	userDto.setPassword(password);
	userDto.setRole("partner");          
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setUserId(userDto);
        partnerDto.setType(true);
        partnerDto.setIncreaseFunds(IncreaseFunds);
        partnerDto.setAffiliationDate(Utils.getDate());   
        this.service.createPartner(partnerDto);
	System.out.println("se ha creado el usuario exitosamente");
        return new ResponseEntity<>("se ha creado el usuario exitosamente",HttpStatus.OK);
    } catch(Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
    }
        
}
