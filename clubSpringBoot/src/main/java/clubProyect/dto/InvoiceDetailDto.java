package clubProyect.dto;

public class InvoiceDetailDto {
    private long idRegister;
    private InvoiceDto idInvoice;
    private int item;
    private String description;
    private double amountTotal;


    public InvoiceDetailDto() {
    }


    public long getIdRegister() {
        return idRegister;
    }


    public void setIdRegister(long idRegister) {
        this.idRegister = idRegister;
    }


    public InvoiceDto getIdInvoice() {
        return idInvoice;
    }


    public void setIdInvoice(InvoiceDto idInvoice) {
        this.idInvoice = idInvoice;
    }


    public int getItem() {
        return item;
    }


    public void setItem(int item) {
        this.item = item;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public double getAmountTotal() {
        return amountTotal;
    }


    public void setAmountTotal(double amountTotal) {
        this.amountTotal = amountTotal;
    }

    @Override
public String toString(){
    return     "DetailsInvoices{" +
               "id Register =" + idRegister +
               ", idInvoice =" + idInvoice +
               ", numberItem =" + item +
               ", description ='" + description + '\'' +
               ", amountTotal =" + amountTotal +
               '}';
}

    public void setInvoiceId(PersonDto parse) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    
}