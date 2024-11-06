package clubProyect.dao.repository;


import clubProyect.model.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail,Long>{
    
}