
package clubProyect.dao;

import clubProyect.config.MySQLConnection;
import clubProyect.dao.interfaces.PartnerDao;
import clubProyect.dto.PartnerDto;
import clubProyect.dto.PersonDto;
import clubProyect.helper.Helper;
import clubProyect.model.Partner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import clubProyect.dao.interfaces.PartnerDao;
import clubProyect.helper.Helper;
import java.sql.Date;

public class PartnerDaoImplementation implements PartnerDao{
        
    @Override    
    public void createPartner(PartnerDto partnerDto) throws Exception{
        Partner partner = Helper.parse(partnerDto);
        String query = "INSERT INTO PARTNER(USERID,AMOUNT,TYPE,CREATIONDATE) VALUES (?,?,?,?) ";
        PreparedStatement preparedStatement = MySQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, partner.getUserId().getId());
        preparedStatement.setDouble(2, partner.getIncreaseFunds());
        preparedStatement.setBoolean(3, partner.isType());
        preparedStatement.setDate(4, (Date) partner.getAffiliationDate());
        preparedStatement.execute();
        preparedStatement.close();
        }

        @Override
        public void deletePartner(PartnerDto partnerDto) throws Exception {
            throw new UnsupportedOperationException("Not supported yet.");
        }
}
