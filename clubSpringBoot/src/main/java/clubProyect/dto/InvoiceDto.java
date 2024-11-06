package clubProyect.dto;

import java.sql.Date;



public class InvoiceDto {
private long idInvoice;
private PersonDto personId;
private PartnerDto partnerId;
private Date dateGeneration;
private double amountTotal;
private boolean statusInvoice;


public InvoiceDto() {}

public long getIdInvoice() {
    return idInvoice;
}

public void setIdInvoice(long idInvoice) {
    this.idInvoice = idInvoice;
}

public PersonDto getPersonId() {
    return personId;
}

public void setPersonId(PersonDto personId) {
    this.personId = personId;
}

public PartnerDto getPartnerId() {
    return partnerId;
}

public void setPartnerId(PartnerDto partnerId) {
    this.partnerId = partnerId;
}

public Date getDateGeneration() {
    return dateGeneration;
}

public void setDateGeneration(Date dateGeneration) {
    this.dateGeneration = dateGeneration;
}

public double getAmountTotal() {
    return amountTotal;
}

public void setAmountTotal(double amountTotal) {
    this.amountTotal = amountTotal;
}

public boolean getStatusInvoice() {
    return statusInvoice;
}

public void setStatusInvoice(boolean statusInvoice) {
    this.statusInvoice = statusInvoice;
}




}
