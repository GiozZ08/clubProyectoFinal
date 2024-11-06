package clubProyect.model;

public class InvoiceDetail {
private long idRegister;
private Invoice idInvoice;
private int item;
private String description;
private double valueItem;

public InvoiceDetail() {}

public long getIdRegister() {
    return idRegister;
}
public void setIdRegister(long idRegister) {
    this.idRegister = idRegister;
}
public Invoice getIdInvoice() {
    return idInvoice;
}
public void setIdInvoice(Invoice idInvoice) {
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
public double getValueItem() {
    return valueItem;
}
public void setValueItem(double valueItem) {
    this.valueItem = valueItem;
}

@Override
public String toString(){
    return     "DetailsInvoices{" +
               "id Register =" + idRegister +
               ", idInvoice =" + idInvoice +
               ", numberItem =" + item +
               ", description ='" + description + '\'' +
               ", valueItem =" + valueItem +
               '}';
}



}
