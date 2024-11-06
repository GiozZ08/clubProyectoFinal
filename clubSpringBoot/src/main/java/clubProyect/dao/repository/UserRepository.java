package clubProyect.dao.repository;

import clubProyect.model.Person;
import clubProyect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUserName(String userName);
    public boolean existsByUserName(String userName);
    public User findByPersonId (Person Person);
    
}
