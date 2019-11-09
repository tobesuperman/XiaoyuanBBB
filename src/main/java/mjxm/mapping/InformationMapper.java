package mjxm.mapping;

import mjxm.pojo.Information;

public interface InformationMapper {
    int deleteByPrimaryKey(Integer informationId);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer informationId);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
}