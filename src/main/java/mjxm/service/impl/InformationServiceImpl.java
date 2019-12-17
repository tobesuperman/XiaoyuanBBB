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
    public int add(Information information) {
        return informationMapper.insertSelective(information);
    }

    @Override
    public int modify(Information information) {
        return informationMapper.updateByPrimaryKeySelective(information);
    }

    @Override
    public Information findByUser(Integer userId) {
        return informationMapper.selectByUser(userId);
    }

    @Override
    public int deleteByUser(Integer userId) {
        return informationMapper.deleteByUser(userId);
    }
}
