package clubProyect.model;
import clubProyect.dto.PartnerDto;
import clubProyect.dto.PersonDto;
import jakarta.persistence.Column;
import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInvoice")
    private long idInvoice;
    @JoinColumn(name = "personid")
    @OneToOne
    private Person personId;
    @JoinColumn(name = "partnerid")
    @OneToOne
    private Partner partnerId;
    @Column(name = "dateGeneration")
    private Date dateGeneration;
    @Column(name = "amountTotal")
    private double amountTotal;
    @Column(name = "statusInvoice")
    private boolean statusInvoice;
    
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
    public Date getDateGeneration() {
    return dateGeneration;
}
    public double getAmountTotal() {
    return amountTotal;
}
public boolean getStatusInvoice() {
    return statusInvoice;
}
public void setDateGeneration(Date dateGeneration) {
    this.dateGeneration = dateGeneration;
}
public void setAmountTotal(double amountTotal) {
    this.amountTotal = amountTotal;
}
public void setStatusInvoice(boolean statusInvoice) {
    this.statusInvoice = statusInvoice;
}


   

}

