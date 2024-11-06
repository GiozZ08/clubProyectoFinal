
package clubProyect.dao;


import clubProyect.config.MySQLConnection;
import clubProyect.dto.GuestDto;
import clubProyect.helper.Helper;
import clubProyect.model.Guest;
import java.sql.PreparedStatement;
import clubProyect.dao.interfaces.GuestDao;
import clubProyect.dto.PartnerDto;
import clubProyect.model.Partner;
import clubProyect.model.User;
import java.sql.ResultSet;

public class GuestDaoImplementation implements GuestDao{
        
    @Override
    public void createGuest(GuestDto guestDto) throws Exception{
        Guest guest = Helper.parse(guestDto);
        String query = "INSERT INTO GUEST(USERID, PARTNERID, STATUS) VALUES (?,?,?)";
        PreparedStatement preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, guest.getUserId().getId());
        preparedStatement.setLong(2, guest.getPartnerId().getId());
        preparedStatement.setBoolean(3, guest.isStatusActive());        
    }
        
    @Override
    public void disableGuest(GuestDto guestDto) throws Exception{
        throw new UnsupportedOperationException("Not supported yet.");
    }
        
    @Override
    public void enableGuest(GuestDto guestDto) throws Exception{
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PartnerDto findPartnerWhitUserId(PartnerDto partnerDto) throws Exception {
       String query = "SELECT ID,USERID,AMOUNT,TYPE,CREATIONDATE FROM PARTNER WHERE USERID = ?";
        PreparedStatement preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, partnerDto.getId());
        ResultSet resulSet = preparedStatement.executeQuery();
        if (resulSet.next()) {
            Partner partner = new Partner();
            partner.setId(resulSet.getLong("ID"));
            partner.setIncreaseFunds(resulSet.getDouble("AMOUNT"));
            partner.setType(resulSet.getBoolean("TYPE"));
            partner.setAffiliationDate(resulSet.getDate("CREATIONDATE"));    
            User user = new User();
            user.setId(resulSet.getLong("USERID"));
            partner.setUserId(user); 
            resulSet.close();
            preparedStatement.close();
            return Helper.parse(partner);
        }
        resulSet.close();
        preparedStatement.close();
        return null;
    }
}
