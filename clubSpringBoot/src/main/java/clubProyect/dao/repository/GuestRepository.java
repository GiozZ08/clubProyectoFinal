package clubProyect.dao.repository;

import clubProyect.model.Guest;
import clubProyect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,Long>{

    public Guest findByUserId(User user);
}
