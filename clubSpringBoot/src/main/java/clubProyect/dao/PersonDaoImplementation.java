package clubProyect.dao;

import clubProyect.dao.repository.PersonRepository;
import clubProyect.dao.interfaces.PersonDao;
import clubProyect.dto.PersonDto;
import clubProyect.dto.UserDto;
import clubProyect.helper.Helper;
import clubProyect.model.Person;
import clubProyect.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Getter
@Setter
@NoArgsConstructor
@Service
public class PersonDaoImplementation implements PersonDao {
    @Autowired
    public PersonRepository personRepository;
    @Override
    public boolean existsByIdentification(PersonDto personDto) throws Exception {
        return personRepository.existsByIdentification(personDto.getIdentification());
    }

    @Override
    public void createPerson(PersonDto personDto) throws Exception {
        Person person = Helper.parse(personDto);
	personRepository.save(person);
        personDto.setId(person.getId());
        
    }

    @Override
    public void deletePerson(PersonDto personDto)throws Exception {     
        Person person = Helper.parse(personDto);
        personRepository.delete(person);
    }

    @Override
    public PersonDto findByIdentification(PersonDto personDto) throws Exception {
       Person person = personRepository.findByIdentification(personDto.getIdentification());
       return Helper.parse(person);
    }



}