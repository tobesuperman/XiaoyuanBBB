package mjxm.service.impl;

import mjxm.mapping.InformationMapper;
import mjxm.pojo.Information;
import mjxm.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;

    @Override
    public void add(Information information) {
        if (information.getDefaults() == 1) {
            informationMapper.updateOtherInformation();
        }
        informationMapper.insert(information);
    }

    @Override
    public int modify(Information information) {
        if (information.getDefaults() == 1) {
            informationMapper.updateOtherInformation();
        }
        return informationMapper.updateByPrimaryKey(information);
    }

    @Override
    public Information findById(Integer informationId) {
        return informationMapper.selectInformationJoinUser(informationId);
    }

    @Override
    public List<Information> findUserAllInformation(Integer userId) {
        return informationMapper.selectUserAllInformation(userId);
    }

    @Override
    public int deleteById(Integer informationId) {
        return informationMapper.deleteByPrimaryKey(informationId);
    }

    @Override
    public int deleteAllInformation(Integer userId) {
        return informationMapper.deleteAllInformation(userId);
    }
}
