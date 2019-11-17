package mjxm.service;

import mjxm.pojo.Information;

import java.util.List;


public interface InformationService {
    public void add(Information information);

    public int modify(Information information);

    public Information findById(Integer informationId);

    public List<Information> findUserAllInformation(Integer userId);

    public int deleteById(Integer informationId);

    public int deleteAllInformation(Integer userId);
}
