package clubProyect.dao.interfaces;

import clubProyect.dto.PartnerDto;
import clubProyect.dto.UserDto;

public interface PartnerDao {
    public void createPartner(PartnerDto partnerDto) throws Exception;
    public void deletePartner(PartnerDto partnerDto) throws Exception;
    public PartnerDto findByUserId(UserDto userDto) throws Exception;
    public void incrementAmount(PartnerDto partnerDto) throws Exception;
}
