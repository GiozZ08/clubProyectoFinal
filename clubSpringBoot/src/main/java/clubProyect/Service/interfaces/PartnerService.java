
package clubProyect.Service.interfaces;


import clubProyect.dto.GuestDto;
import clubProyect.dto.InvoiceDetailDto;
import clubProyect.dto.InvoiceDto;
import clubProyect.dto.PartnerDto;

public interface PartnerService {
    public void createGuest (GuestDto guestDto) throws Exception;
    public void disableGuest(long document) throws Exception;
    public void enableGuest(long document) throws Exception;
    public void incrementAmount(PartnerDto partnerDto) throws Exception;
    public void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception;
    public void createInvoice(InvoiceDto invoiceDto) throws Exception;
}
