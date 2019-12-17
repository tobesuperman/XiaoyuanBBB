package mjxm.mapping;

import mjxm.pojo.Information;

import java.util.List;

public interface InformationMapper {
    int deleteByPrimaryKey(Integer informationId);

    int deleteByUser(Integer userId);

    int insert(Information information);

    int insertSelective(Information information);

    Information selectByPrimaryKey(Integer informationId);

    Information selectByUser(Integer informationId);

    int updateByPrimaryKeySelective(Information information);

    int updateByPrimaryKey(Information information);
}