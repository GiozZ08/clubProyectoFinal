package clubProyect.Service.interfaces;

import clubProyect.dto.PartnerDto;
import clubProyect.dto.GuestDto;
import clubProyect.dto.PersonDto;
import clubProyect.dto.UserDto;

public interface AdminService {
 public void createPartner(PartnerDto partnerDto) throws Exception;
        public void promotiontovip(PersonDto personDto) throws Exception;
}
 

