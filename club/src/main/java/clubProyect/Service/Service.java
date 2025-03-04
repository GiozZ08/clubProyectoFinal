package clubProyect.Service;

import clubProyect.controller.Utils;
import clubProyect.dao.GuestDaoImplementation;
import clubProyect.dao.PartnerDaoImplementation;
import clubProyect.dao.PersonDaoImplementation;
import clubProyect.dao.UserDaoImplementation;
import clubProyect.dao.interfaces.GuestDao;
import clubProyect.dao.interfaces.PartnerDao;
import clubProyect.dao.interfaces.PersonDao;
import clubProyect.dao.interfaces.UserDao;
import clubProyect.dto.GuestDto;
import clubProyect.dto.PartnerDto;
import clubProyect.dto.PersonDto;
import clubProyect.dto.UserDto;
import clubProyect.Service.interfaces.AdminService;
import clubProyect.Service.interfaces.LoginService;
import clubProyect.Service.interfaces.PartnerService;

public class Service implements LoginService, AdminService, PartnerService {

    private UserDao userDao;
    private PersonDao personDao;
    private PartnerDao partnerDao;
    private GuestDao guestDao;
    public static UserDto user;
    
    public Service(){
        this.userDao = new UserDaoImplementation();
        this.personDao = new PersonDaoImplementation();
        this.partnerDao = new PartnerDaoImplementation();
        this.guestDao = new GuestDaoImplementation();
    }
    
    
    public void login(UserDto userDto) throws Exception {
        UserDto validateDto = userDao.findByUserName(userDto);
        if (validateDto == null) {
            throw new Exception("no existe usuario registrado");
        }
	if (!userDto.getPassword().equals(validateDto.getPassword())) {
            throw new Exception("usuario o contraseña incorrecto");
	}
	userDto.setRole(validateDto.getRole());
	user = validateDto;
    }

    @Override
    public void logout() {
        user = null;
        System.out.println("Se ha cerrado session");
    }

    @Override
    public void createPartner(PartnerDto partnerDto) throws Exception {
        this.createUser(partnerDto.getUserId());
        partnerDto.setUserId(userDao.findByUserName(partnerDto.getUserId()));
        if(partnerDto.getIncreaseFunds() < 50000){
            this.userDao.deleteUser(partnerDto.getUserId());
            throw  new Exception("El monto inical tiene que ser minimo 50000");  
        }
        this.partnerDao.createPartner(partnerDto);
        
        
    }

    @Override
    public void createGuest(GuestDto GuestDto) throws Exception {
        this.createUser(GuestDto.getUserId());
        //GuestDto.setUserId(userDao.findByUserName(GuestDto.getUserId()));
        this.guestDao.createGuest(GuestDto);
        
    }
    
    private void createUser(UserDto userDto) throws Exception{
        this.createPerson(userDto.getPersonId());
        userDto.setPersonId(personDao.findByDocument(userDto.getPersonId()));
	if(this.userDao.existsByUserName(userDto)) {
            this.personDao.deletePerson(userDto.getPersonId());
            throw new Exception("ya existe un usuario con ese user name");
        }
        this.userDao.createUser(userDto);
            
    }
   
    private void createPerson(PersonDto personDto)throws Exception{
	if(this.personDao.existsByDocument(personDto)) {
            throw new Exception("ya existe una persona con ese documento");
	}
        this.personDao.createPerson(personDto);
    }

  
    @Override
    public void promotiontovip(PersonDto personDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void disableGuest(long document) throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto.setStatusActive(false);
    }



}


















    

