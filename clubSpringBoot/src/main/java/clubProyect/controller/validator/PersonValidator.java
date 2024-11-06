package clubProyect.controller.validator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Setter
@NoArgsConstructor
@Component
public class PersonValidator extends CommonsValidator {
   
        public void validName(String name) throws Exception {
        super.isValidString("El nombre de la persona", name);
    }
    
    public long validIdentification(String identification) throws Exception{
        return super.isValidLong("La cedula de la persona", identification);
    }
    
    public long validPhoneNumber (String phoneNumber) throws Exception{
        return super.isValidLong("el numero de telefono de la persona", phoneNumber);
    }
    
}