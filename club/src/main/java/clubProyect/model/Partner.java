package clubProyect.model;

import java.sql.Date;



public class Partner {
    private Long id;
    private User userId;
    private double increaseFunds;
    private boolean type;
    private Date affiliationDate;
    

    public Partner() {}


    public long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public User getUserId() {
        return userId;
    }


    public void setUserId(User userId) {
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


    

