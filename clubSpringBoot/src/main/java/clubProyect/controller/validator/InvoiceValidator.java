package clubProyect.controller.validator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class InvoiceValidator extends CommonsValidator{
    public double validAmountTotal(String amountTotal) throws Exception{
        return super.isValidDouble("La valor de la factura", amountTotal);
    }
    public void validDescription(String description) throws Exception {
        super.isValidString("La descripcion de la factura", description);
    }
    
    public int validItem(String item) throws Exception{
        return super.isValidInteger("item item de la factura", item);
    }
}
