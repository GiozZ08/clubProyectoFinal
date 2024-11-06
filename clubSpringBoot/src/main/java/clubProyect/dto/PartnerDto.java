package clubProyect.dto;

import java.sql.Date;





public class PartnerDto {
    private Long id;
    private UserDto userId;
    private double increaseFunds;
    private Boolean type;
    private Date affiliationDate;
    

    public PartnerDto() {}


    public long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public UserDto getUserId() {
        return userId;
    }


    public void setUserId(UserDto userId) {
        this.userId = userId;
    }


    public double getIncreaseFunds() {
        return increaseFunds;
    }


    public void setIncreaseFunds(double increaseFunds) {
        this.increaseFunds = increaseFunds;
    }


    public Boolean isType() {
        return type;
    }


    public void setType(Boolean type) {
        this.type = type;
    }


    public Date getAffiliationDate() {
        return affiliationDate;
    }


    public void setAffiliationDate(Date affiliationDate) {
        this.affiliationDate = affiliationDate;
    }

 
   
}

