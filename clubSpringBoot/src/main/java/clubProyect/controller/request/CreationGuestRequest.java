package clubProyect.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CreationGuestRequest {
    private String name;
    private String identification;
    private String phoneNumber;
    private String guestCode; // Código específico del invitado si aplica
    
}
