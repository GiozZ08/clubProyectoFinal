package clubProyect.dao.interfaces;

import clubProyect.dto.PersonDto;

public interface PersonDao {
public boolean existsByIdentification(PersonDto personDto) throws Exception;
    public void createPerson(PersonDto personDto) throws Exception;
    public void deletePerson(PersonDto personDto) throws Exception;
    public PersonDto findByIdentification(PersonDto personDto) throws Exception;
}
