
package clubProyect.helper;



import clubProyect.dto.GuestDto;
import clubProyect.dto.PartnerDto;
import clubProyect.dto.PersonDto;
import clubProyect.dto.UserDto;
import clubProyect.model.Guest;
import clubProyect.model.Partner;
import clubProyect.model.Person;
import clubProyect.model.User;
import java.sql.Date;

public abstract interface Helper {
    public static PersonDto parse(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setIdentification(person.getIdentification());
        personDto.setName(person.getName());
        personDto.setPhoneNumber(person.getPhoneNumber());
        return personDto;
    }
	
    public static Person parse(PersonDto personDto) {
        Person person = new Person();
        person.setId(personDto.getId());
        person.setIdentification(personDto.getIdentification());
        person.setName(personDto.getName());
        person.setPhoneNumber(personDto.getPhoneNumber());
        return person;
    }
	
    public static UserDto parse(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setPassword(user.getPassword());
        userDto.setPersonId(parse(user.getPersonId()));
        userDto.setRole(user.getRole());
        return userDto;
    }
	
    public static User parse(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setPersonId(parse(userDto.getPersonId()));
        user.setRole(userDto.getRole());
        user.setUserName(userDto.getUserName());
        return user;
    }
    
    public static PartnerDto parse(Partner partner) {
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setId(partner.getId());
        partnerDto.setUserId(parse(partner.getUserId()));
        partnerDto.setIncreaseFunds(partner.getIncreaseFunds());
        partnerDto.setType(partner.isType());
        partnerDto.setAffiliationDate((Date) partner.getAffiliationDate());
        return partnerDto;
    }
    
    public static Partner parse(PartnerDto partnerDto) {
        Partner partner = new Partner();
        partner.setId(partnerDto.getId());
        partner.setUserId(parse(partnerDto.getUserId()));
        partner.setIncreaseFunds(partnerDto.getIncreaseFunds());
        partner.setType(partnerDto.isType());
        partner.setAffiliationDate(partnerDto.getAffiliationDate());
        return partner;
    }
    
    public static GuestDto parse(Guest guest) {
        GuestDto guestDto = new GuestDto();
        guestDto.setId(guest.getId());
        guestDto.setPartnerId(parse(guest.getPartnerId())); //solo funciona con ese parse
        guestDto.setStatusActive(guest.isStatusActive());
        return guestDto;
    }
    
    public static Guest parse(GuestDto guestDto) {
        Guest guest = new Guest();
        guest.setId(guestDto.getId());
        guest.setPartnerId(parse(guestDto.getPartnerId()));
        guest.setStatusActive(guestDto.isStatusActive());
        return guest;
    }
}
  

