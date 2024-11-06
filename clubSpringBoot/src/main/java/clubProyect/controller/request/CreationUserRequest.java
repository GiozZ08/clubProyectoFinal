
package clubProyect.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CreationUserRequest {
    private String name;
    private String identification;
    private String phoneNumber;
    private String userName;
    private String password;
    private String increaseFunds;
   
}