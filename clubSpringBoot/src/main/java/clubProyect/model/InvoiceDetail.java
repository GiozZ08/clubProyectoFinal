package clubProyect.model;

import clubProyect.dto.InvoiceDto;
import jakarta.persistence.Column;
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
@Table(name = "invoicedetail")
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRegister")
    private long idRegister;
    @JoinColumn(name = "idInvoice")
    @OneToOne
    private Invoice idInvoice;
    @Column(name = "item")
    private int item;
    @Column(name = "description")
    private String description;
    @Column(name = "amountTotal")
    private double amountTotal;
   



    
    
    
}
