
package clubProyect.Service.interfaces;

import clubProyect.dto.UserDto;
public interface LoginService {
    public void login(UserDto userDto) throws Exception;
    public void logout();

}