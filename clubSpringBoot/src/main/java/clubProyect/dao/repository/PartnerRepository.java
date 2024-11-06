package clubProyect.dao.repository;

import clubProyect.model.Partner;
import clubProyect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PartnerRepository extends JpaRepository<Partner,Long> {

    public Partner findByUserId(User user);
    
}