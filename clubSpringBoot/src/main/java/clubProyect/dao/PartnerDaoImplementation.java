package clubProyect.dao;
import clubProyect.dto.PartnerDto;
import clubProyect.helper.Helper;
import clubProyect.model.Partner;
import clubProyect.dao.interfaces.PartnerDao;
import clubProyect.dao.repository.PartnerRepository;
import clubProyect.dto.UserDto;
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
public class PartnerDaoImplementation implements PartnerDao{
    @Autowired
    public PartnerRepository partnerRepository;
        
    public void createPartner(PartnerDto partnerDto) throws Exception{
            Partner partner = Helper.parse(partnerDto);
            partnerRepository.save(partner);
        }

    @Override
    public void deletePartner(PartnerDto partnerDto) throws Exception {
            Partner partner = Helper.parse(partnerDto);
            partnerRepository.delete(partner);
        }

    @Override
    public PartnerDto findByUserId(UserDto userDto) throws Exception {
        User user = Helper.parse(userDto);
        Partner partner = partnerRepository.findByUserId(user);
        if (partner == null)
            return null;
        return Helper.parse(partner);
    }

    @Override
    public void incrementAmount(PartnerDto partnerDto) throws Exception {
        Partner partner = Helper.parse(partnerDto);
        partnerRepository.save(partner);
    }
}
