package clubProyect.dao;


import clubProyect.config.MySQLConnection;
import clubProyect.dao.interfaces.UserDao;
import clubProyect.dto.PersonDto;
import clubProyect.dto.UserDto;
import clubProyect.helper.Helper;
import clubProyect.model.Person;
import clubProyect.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImplementation implements UserDao{   
	
    @Override
    public UserDto findByUserName(UserDto userDto) throws Exception {     
        String query = "SELECT ID,USERNAME,PASSWORD,ROLE,PERSONID FROM USER WHERE USERNAME = ?";
        PreparedStatement preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, userDto.getUserName());
        ResultSet resulSet = preparedStatement.executeQuery();
        if (resulSet.next()) {
            User user = new User();
            user.setId(resulSet.getLong("ID"));
            user.setUserName(resulSet.getString("USERNAME"));
            user.setPassword(resulSet.getString("PASSWORD"));
            user.setRole(resulSet.getString("ROLE"));
            Person person = new Person();
            person.setIdentification(resulSet.getLong("PERSONID"));
            user.setPersonId(person);
            resulSet.close();
            preparedStatement.close();
            return Helper.parse(user);
        }
        resulSet.close();
        preparedStatement.close();
            
        // user admin :D    
        UserDto validateDto = new UserDto();
        if(userDto.getUserName().equals("admin")) {
            validateDto.setUserName(userDto.getUserName());
            validateDto.setRole(userDto.getUserName());
            validateDto.setPassword("admin");
            return validateDto;
        }
        return null;
         
	}

    @Override
    public boolean existsByUserName(UserDto userDto) throws Exception {
        String query = "SELECT 1 FROM USER WHERE USERNAME = ?";
        PreparedStatement preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, userDto.getUserName());
        ResultSet resulSet = preparedStatement.executeQuery();
        boolean exists = resulSet.next();
        resulSet.close();
        preparedStatement.close();
        return exists; 
    }

    @Override
    public void createUser(UserDto userDto) throws Exception {
        User user = Helper.parse(userDto);
        String query = "INSERT INTO USER(USERNAME,PASSWORD,PERSONID,ROLE) VALUES (?,?,?,?) ";
        PreparedStatement preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setLong(3,user.getPersonId().getId());
        preparedStatement.setString(4, user.getRole());
        preparedStatement.execute();
        preparedStatement.close();
    }

    @Override
    public void deleteUser(UserDto userDto) throws Exception {
        User user = Helper.parse(userDto);
	String query = "DELETE FROM USER WHERE USERNAME = ?";
	PreparedStatement preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
	preparedStatement.setString(1,user.getUserName());
	preparedStatement.execute();
	preparedStatement.close();
    }
}