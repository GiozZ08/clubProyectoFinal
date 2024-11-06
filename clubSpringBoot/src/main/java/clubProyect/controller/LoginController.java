package clubProyect.controller;

import clubProyect.controller.validator.UserValidator;
import clubProyect.dto.UserDto;
import clubProyect.Service.ClubService;
import clubProyect.Service.interfaces.LoginService;
import clubProyect.controller.request.CreationLoginRequest;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Setter
@Getter
@Controller
public class LoginController implements ControllerInterface{
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private LoginService service;
    
    private static final String MENU = " ingrese la opcion que desea: /n 1.inicar sesion/n 2. detener la ejecucion.  ";
    
    private Map<String, ControllerInterface> roles;    
    public LoginController(AdminController adminController, GuestController guestController, PartnerController partnerController){
        this.roles = new HashMap<String, ControllerInterface>();
        roles.put("admin",adminController);
        roles.put("guest",  guestController);
        roles.put("partner",partnerController);      
    }
    
    
    @Override
   public void session() throws Exception {
	
	}

   
    // Endpoint para manejar el login
    @PostMapping("/login")
    private ResponseEntity login(@RequestBody CreationLoginRequest request) throws Exception{
        try{
        String userName = request.getUserName();
        userValidator.validUserName(userName);
        String  password = request.getPassword();
        userValidator.validPassword(password);
        UserDto userDto = new UserDto();
        userDto.setPassword(password);
        userDto.setUserName(userName);
        
        this.service.login(userDto);
        if(roles.get(userDto.getRole()) == null){
            throw new Exception("Rol invalido");
        }
        roles.get(userDto.getRole()).session();
        return new ResponseEntity<>("se ha ingresado exitosamente",HttpStatus.OK);
    } catch(Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
    }
}
