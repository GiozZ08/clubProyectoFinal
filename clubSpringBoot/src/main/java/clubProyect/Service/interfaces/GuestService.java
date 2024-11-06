
package clubProyect.Service.interfaces;

import clubProyect.dto.InvoiceDetailDto;
import clubProyect.dto.InvoiceDto;
import clubProyect.dto.PartnerDto;

public interface GuestService {
    public void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception;
    public void createInvoice(InvoiceDto invoiceDto) throws Exception;
    public void convertPartner(PartnerDto partnerDto) throws Exception;
}
