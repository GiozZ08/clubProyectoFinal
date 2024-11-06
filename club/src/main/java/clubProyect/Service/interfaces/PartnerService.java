
package clubProyect.Service.interfaces;

import clubProyect.dto.GuestDto;



public interface PartnerService {
    
      public void createGuest (GuestDto guestDto) throws Exception;
    public void disableGuest(long document) throws Exception;
}
