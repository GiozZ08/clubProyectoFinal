package clubProyect.helper;

import clubProyect.dto.GuestDto;
import clubProyect.dto.InvoiceDetailDto;
import clubProyect.dto.InvoiceDto;
import clubProyect.dto.PartnerDto;
import clubProyect.dto.PersonDto;
import clubProyect.dto.UserDto;
import clubProyect.model.Guest;
import clubProyect.model.Invoice;
import clubProyect.model.InvoiceDetail;
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
        if (userDto.getPersonId() != null) {
            user.setPersonId(parse(userDto.getPersonId()));
        }
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
        partnerDto.setAffiliationDate(partner.getAffiliationDate());
        return partnerDto;
    }

    public static Partner parse(PartnerDto partnerDto) {
        Partner partner = new Partner();
        partner.setId(partnerDto.getId());
        if (partnerDto.getUserId() != null) {
            partner.setUserId(parse(partnerDto.getUserId()));
        }
        partner.setIncreaseFunds(partnerDto.getIncreaseFunds());
        partner.setType(partnerDto.isType());
        partner.setAffiliationDate( (Date) partnerDto.getAffiliationDate());
        return partner;
    }

    public static GuestDto parse(Guest guest) {
        GuestDto guestDto = new GuestDto();
        guestDto.setId(guest.getId());
        guestDto.setPartnerId(parse(guest.getPartnerId()));
        guestDto.setStatusActive(guest.isStatusActive());
        guestDto.setUserId(parse(guest.getUserId()));
        return guestDto;
    }

    public static Guest parse(GuestDto guestDto) {
        Guest guest = new Guest();
        guest.setId(guestDto.getId());
        if (guestDto.getPartnerId() != null) {
            guest.setPartnerId(parse(guestDto.getPartnerId()));
        }
        guest.setStatusActive(guestDto.isStatusActive());
        if (guestDto.getUserId() != null) {
            guest.setUserId(parse(guestDto.getUserId()));
        }
        return guest;
    }
    
    public static InvoiceDto parse(Invoice invoice){
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setIdInvoice(invoice.getIdInvoice());
        invoiceDto.setPersonId(parse(invoice.getPersonId()));
        invoiceDto.setPartnerId(parse(invoice.getPartnerId()));
        invoiceDto.setDateGeneration(invoice.getDateGeneration());
        invoiceDto.setAmountTotal(invoice.getAmountTotal());
        invoiceDto.setStatusInvoice(invoice.getStatusInvoice());
        return invoiceDto;
    }
    
    public static Invoice parse(InvoiceDto invoiceDto){
        Invoice invoice = new Invoice();
        invoice.setIdInvoice(invoiceDto.getIdInvoice());
        if(invoiceDto.getPersonId()!= null){
            invoice.setPersonId(parse(invoiceDto.getPersonId()));
        }
        if(invoiceDto.getPartnerId()!= null){
            invoice.setPartnerId(parse(invoiceDto.getPartnerId()));
        }
        invoice.setDateGeneration((Date) invoiceDto.getDateGeneration());
        invoice.setAmountTotal(invoiceDto.getAmountTotal());
        invoice.setStatusInvoice(invoiceDto.getStatusInvoice());
        return invoice;
    }
    
    
    public static InvoiceDetailDto parse(InvoiceDetail invoiceDetail ){
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        invoiceDetailDto.setIdRegister(invoiceDetail.getIdRegister());
        if(invoiceDetailDto.getIdInvoice() != null){    
            invoiceDetailDto.setIdInvoice(parse(invoiceDetail.getIdInvoice()));
        }
        invoiceDetailDto.setItem(invoiceDetail.getItem());
        invoiceDetailDto.setDescription(invoiceDetail.getDescription());
        invoiceDetailDto.setAmountTotal(invoiceDetail.getAmountTotal());
        return  invoiceDetailDto;
    }
    
    public static InvoiceDetail parse(InvoiceDetailDto invoiceDetailDto ){
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        invoiceDetail.setIdRegister(invoiceDetailDto.getIdRegister());
        invoiceDetail.setIdInvoice(parse(invoiceDetailDto.getIdInvoice()));
        invoiceDetail.setItem(invoiceDetailDto.getItem());
        invoiceDetail.setDescription(invoiceDetailDto.getDescription());
        invoiceDetail.setAmountTotal(invoiceDetailDto.getAmountTotal());
        return  invoiceDetail;
    }
}
