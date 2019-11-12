package mjxm.service.impl;

import mjxm.mapping.InformationMapper;
import mjxm.pojo.Information;
import mjxm.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;

public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;

    @Override
    public void add(Information information) {
        informationMapper.insert(information);
    }
}
