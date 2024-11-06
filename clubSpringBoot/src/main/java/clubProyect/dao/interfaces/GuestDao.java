package clubProyect.dao.interfaces;

import clubProyect.dto.GuestDto;
import clubProyect.dto.UserDto;

public interface GuestDao  {
    public void createGuest(GuestDto guestDto) throws Exception;
    public void disableGuest(GuestDto guestDto) throws Exception;
    public void enableGuest(GuestDto guestDto) throws Exception;
    public GuestDto findByUserId(UserDto userDto) throws Exception;
    public void deleteGuest(GuestDto guestDto) throws Exception;
    
}
