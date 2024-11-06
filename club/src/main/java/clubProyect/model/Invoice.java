package clubProyect.model;

import java.sql.Date;




public class Invoice {
private long idInvoice;
private Person personId;
private Partner partnerId;
private Date dateGenaration;
private double amountTotal;
private Boolean statusInvoice;


public Invoice() {}

public long getIdInvoice() {
    return idInvoice;
}

public void setIdInvoice(long idInvoice) {
    this.idInvoice = idInvoice;
}

public Person getPersonId() {
    return personId;
}

public void setPersonId(Person personId) {
    this.personId = personId;
}

public Partner getPartnerId() {
    return partnerId;
}

public void setPartnerId(Partner partnerId) {
    this.partnerId = partnerId;
}

public Date getDateGenaration() {
    return dateGenaration;
}

public void setDateGenaration(Date dateGenaration) {
    this.dateGenaration = dateGenaration;
}

public double getAmountTotal() {
    return amountTotal;
}

public void setAmountTotal(double amountTotal) {
    this.amountTotal = amountTotal;
}

public boolean isStatusInvoice() {
    return statusInvoice;
}

public void setStatusInvoice(boolean statusInvoice) {
    this.statusInvoice = statusInvoice;
}



}








