package mjxm.mapping;

import mjxm.pojo.Information;

import java.util.List;

public interface InformationMapper {
    int deleteByPrimaryKey(Integer informationId);

    int deleteAllInformation(Integer userId);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer informationId);

    Information selectInformationJoinUser(Integer informationId);

    List<Information> selectUserAllInformation(Integer userId);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);

    int updateOtherInformation();
}