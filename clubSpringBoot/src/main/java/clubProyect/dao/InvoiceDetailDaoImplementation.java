
package clubProyect.dao;

import clubProyect.dao.interfaces.InvoiceDetailDao;
import clubProyect.dao.repository.InvoiceDetailRepository;
import clubProyect.dto.InvoiceDetailDto;
import clubProyect.helper.Helper;
import clubProyect.model.InvoiceDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@Service
public class InvoiceDetailDaoImplementation implements InvoiceDetailDao{
    @Autowired
    public InvoiceDetailRepository invoiceDetailRepository;
    
     public void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception{
        InvoiceDetail invoiceDetail = Helper.parse(invoiceDetailDto);
        invoiceDetailRepository.save(invoiceDetail);
    }
    
    
}
