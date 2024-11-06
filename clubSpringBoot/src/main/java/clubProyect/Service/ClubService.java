package clubProyect.Service;



import clubProyect.dao.interfaces.GuestDao;
import clubProyect.dao.interfaces.PartnerDao;
import clubProyect.dao.interfaces.PersonDao;
import clubProyect.dao.interfaces.UserDao;
import clubProyect.dto.GuestDto;
import clubProyect.dto.InvoiceDetailDto;
import clubProyect.dto.InvoiceDto;
import clubProyect.dto.PartnerDto;
import clubProyect.dto.PersonDto;
import clubProyect.dto.UserDto;
import clubProyect.Service.interfaces.AdminService;
import clubProyect.Service.interfaces.LoginService;
import clubProyect.Service.interfaces.PartnerService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import clubProyect.dao.interfaces.InvoiceDao;
import clubProyect.dao.interfaces.InvoiceDetailDao;
import clubProyect.Service.interfaces.GuestService;


@Getter
@Setter
@NoArgsConstructor
@Service
public class ClubService implements LoginService, AdminService, PartnerService, GuestService {
    
    @Autowired
    private UserDao userDao;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private PartnerDao partnerDao;
    @Autowired
    private GuestDao guestDao;
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private InvoiceDetailDao invoideDetailDao;
    public static UserDto user;
    
    
    
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
        this.partnerDao.createPartner(partnerDto);
        
        
    }

    @Override
    public void createGuest(GuestDto guestDto) throws Exception {
        this.createUser(guestDto.getUserId());
        guestDto.setPartnerId(partnerDao.findByUserId(user));  
        this.guestDao.createGuest(guestDto);
        
    }
    
    private void createUser(UserDto userDto) throws Exception{
        this.createPerson(userDto.getPersonId());
	if(this.userDao.existsByUserName(userDto)) {
            this.personDao.deletePerson(userDto.getPersonId());
            throw new Exception("ya existe un usuario con ese user name");
        }
        this.userDao.createUser(userDto);
            
    }
   
    private void createPerson(PersonDto personDto)throws Exception{
	if(this.personDao.existsByIdentification(personDto)) {
            throw new Exception("ya existe una persona con ese documento");
	}
        this.personDao.createPerson(personDto);
    }
    @Override
    public void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception {
      this.createInvoice(invoiceDetailDto.getIdInvoice());
      this.invoideDetailDao.createInvoiceDetail(invoiceDetailDto);
    }
    
    @Override
    public void createInvoice(InvoiceDto InvoiceDto) throws Exception {
        GuestDto guestDto = new GuestDto();
        guestDto = this.guestDao.findByUserId(user);
        InvoiceDto.setPartnerId(guestDto.getPartnerId());  
        InvoiceDto.setPersonId(user.getPersonId());
        this.invoiceDao.createInvoice(InvoiceDto);
    }

    @Override
    public void promotiontovip(PersonDto personDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void disableGuest(long document) throws Exception {
        PersonDto personDto = new PersonDto();
        personDto.setIdentification(document);
        personDto = this.personDao.findByIdentification(personDto);
        UserDto userDto = new UserDto();
        userDto = this.userDao.findByPersonId(personDto);
        GuestDto guestDto = new GuestDto();
        guestDto = this.guestDao.findByUserId(userDto);
        this.guestDao.disableGuest(guestDto);
    }

    @Override
    public void enableGuest(long identification) throws Exception {
        
        PersonDto personDto = new PersonDto();
        personDto.setIdentification(identification);
        if(this.personDao.existsByIdentification(personDto) == false) {
            throw new Exception("no existe una persona con ese documento");
	}
        personDto = this.personDao.findByIdentification(personDto);
        UserDto userDto = new UserDto();
        userDto = this.userDao.findByPersonId(personDto);
        GuestDto guestDto = new GuestDto();
        guestDto = this.guestDao.findByUserId(userDto);
        this.guestDao.enableGuest(guestDto);
    }

    @Override
    public void convertPartner(PartnerDto partnerDto) throws Exception {
        this.userDao.convertPartner(user);
        GuestDto guestDto = new GuestDto();
        guestDto = this.guestDao.findByUserId(user);
        partnerDto.setUserId(user);
        this.partnerDao.createPartner(partnerDto);
        this.guestDao.deleteGuest(guestDto);
        
        
    }

    @Override
    public void incrementAmount(PartnerDto partnerDto) throws Exception {
        PartnerDto partner = new PartnerDto();
        partner = this.partnerDao.findByUserId(user);
        partner.setIncreaseFunds(partner.getIncreaseFunds() + partnerDto.getIncreaseFunds());
        if(partner.getIncreaseFunds() > 1000000 && partner.isType()){
            throw  new Exception("El tope maximo para socios regulares es de 1 Millon");
        }else if(partner.getIncreaseFunds() > 5000000 && !partner.isType()) {
            throw  new Exception("El tope maximo para socios vips es de 5 Millon");
        }
        
        this.partnerDao.incrementAmount(partner);
        System.out.println("valor actual del fondo del socio: " + partner.getIncreaseFunds());
    }

}













    

