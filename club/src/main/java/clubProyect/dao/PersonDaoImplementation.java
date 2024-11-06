package clubProyect.dao;

import clubProyect.config.MySQLConnection;
import clubProyect.dao.interfaces.PersonDao;
import clubProyect.dto.PersonDto;
import clubProyect.helper.Helper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import clubProyect.model.Person;

public class PersonDaoImplementation implements PersonDao {
    @Override
    public boolean existsByDocument(PersonDto personDto) throws Exception {
        String query = "SELECT 1 FROM PERSON WHERE DOCUMENT = ?";
	PreparedStatement preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
	preparedStatement.setLong(1, personDto.getIdentification());
	ResultSet resulSet = preparedStatement.executeQuery();
	boolean exists = resulSet.next();
	resulSet.close();
	preparedStatement.close();
	return exists;
    }

    @Override
    public void createPerson(PersonDto personDto) throws Exception {
        Person person = Helper.parse(personDto);
	String query = "INSERT INTO PERSON(NAME,DOCUMENT,CELLPHONE) VALUES (?,?,?) ";
	PreparedStatement preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
	preparedStatement.setString(1, person.getName());
	preparedStatement.setLong(2,person.getIdentification());
	preparedStatement.setLong(3, person.getPhoneNumber());
	preparedStatement.execute();
	preparedStatement.close();
    }

    @Override
    public void deletePerson(PersonDto personDto)throws Exception {     
        Person person = Helper.parse(personDto);
	String query = "DELETE FROM PERSON WHERE DOCUMENT = ?";
	PreparedStatement preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
	preparedStatement.setLong(1,person.getIdentification());
	preparedStatement.execute();
	preparedStatement.close();
    }

    @Override
    public PersonDto findByDocument(PersonDto personDto) throws Exception {
        String query = "SELECT ID,NAME,DOCUMENT,CELLPHONE FROM PERSON WHERE DOCUMENT = ?";
	PreparedStatement preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
	preparedStatement.setLong(1, personDto.getIdentification());
	ResultSet resulSet = preparedStatement.executeQuery();
	if (resulSet.next()) {
            Person person = new Person();
            person.setId(resulSet.getLong("ID"));
            person.setName(resulSet.getString("NAME"));
            person.setIdentification(resulSet.getLong("DOCUMENT"));
            person.setPhoneNumber(resulSet.getLong("CELLPHONE"));
            resulSet.close();
            preparedStatement.close();
            return Helper.parse(person);
	}
	resulSet.close();
	preparedStatement.close();
	return null;
    }

}