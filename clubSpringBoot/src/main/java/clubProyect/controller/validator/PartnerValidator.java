package clubProyect.controller.validator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;



@Getter
@Setter
@NoArgsConstructor
@Component
public class PartnerValidator extends CommonsValidator{
    public double validIncreaseFunds(String increaseFunds) throws Exception{
        return super.isValidDouble("La cantidad del socio", increaseFunds);
    }
    
}
