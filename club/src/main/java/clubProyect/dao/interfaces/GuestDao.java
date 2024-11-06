
package clubProyect.dao.interfaces;

import clubProyect.dto.GuestDto;
import clubProyect.dto.PartnerDto;


public interface GuestDao {
   public void createGuest(GuestDto guestDto) throws Exception;
    public PartnerDto findPartnerWhitUserId(PartnerDto partnerDto) throws Exception;
    public void disableGuest(GuestDto guestDto) throws Exception;
    public void enableGuest(GuestDto guestDto) throws Exception;
    
}