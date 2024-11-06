package clubProyect.model;



public class Guest {
private long id;
private User userId; // Id del usuario
private Partner partnerId; //id del socio que invita
private boolean statusActive;


public Guest() {}


public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}


public User getUserId() {
    return userId;
}

public void setUserId(User userId) {
    this.userId = userId;
}


public Partner getPartnerId() {
    return partnerId;
}

public void setPartnerId(Partner partnerId) {
    this.partnerId = partnerId;
}

public boolean isStatusActive() {
    return statusActive;
}

public void setStatusActive(boolean statusActive) {
    this.statusActive = statusActive;
}





}



