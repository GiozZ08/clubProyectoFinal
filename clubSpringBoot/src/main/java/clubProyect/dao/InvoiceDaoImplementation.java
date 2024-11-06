
package clubProyect.dao;

import clubProyect.dao.repository.InvoiceRepository;
import clubProyect.dto.InvoiceDto;
import clubProyect.helper.Helper;
import clubProyect.model.Invoice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import clubProyect.dao.interfaces.InvoiceDao;
import clubProyect.dao.interfaces.InvoiceDao;
import clubProyect.dao.repository.InvoiceRepository;


@Getter
@Setter
@NoArgsConstructor
@Service
public class InvoiceDaoImplementation implements InvoiceDao{
    @Autowired
    public InvoiceRepository invoiceRepository;
    
    
    
    public void createInvoice(InvoiceDto invoiceDto) throws Exception{
        Invoice invoice = Helper.parse(invoiceDto);
        invoiceRepository.save(invoice);
        invoiceDto.setIdInvoice(invoice.getIdInvoice());
    }
    
}
