package clubProyect.dao.repository;

import clubProyect.model.Person;
import clubProyect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{

    public boolean existsByIdentification(long identification);
    public Person findByIdentification(long identification);
}

