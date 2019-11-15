package mjxm.mapping;

import mjxm.pojo.Requirement;

import java.util.List;

public interface RequirementMapper {
    int deleteByPrimaryKey(Integer requirementId);

    int insert(Requirement record);

    int insertSelective(Requirement record);

    Requirement selectByPrimaryKey(Integer requirementId);

    Requirement selectRequirementJoinUser(Integer requirementId);

    List<Requirement> selectUserAllRequirement(Integer userId);

    int updateByPrimaryKeySelective(Requirement record);

    int updateByPrimaryKeyWithBLOBs(Requirement record);

    int updateByPrimaryKey(Requirement record);
}