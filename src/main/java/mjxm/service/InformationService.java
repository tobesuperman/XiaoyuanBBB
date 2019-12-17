package mjxm.service;

import mjxm.pojo.Information;

import java.util.List;


public interface InformationService {
    public int add(Information information);

    public int modify(Information information);

    public Information findByUser(Integer userId);

    public int deleteByUser(Integer userId);
}
