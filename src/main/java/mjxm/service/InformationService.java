package mjxm.service;

import mjxm.pojo.Information;

import java.util.List;


public interface InformationService {
    public void add(Information information);

    public Information findById(Integer informationId);

    public List<Information> findUserAllInformation(Integer userId);
}
