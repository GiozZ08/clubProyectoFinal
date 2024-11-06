package clubProyect.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreationInvoiceRequest {
    private String item;
    private String description;
    private String amountTotal;
}
