package mjxm.mapping;

import mjxm.pojo.Requirement;

public interface RequirementMapper {
    int deleteByPrimaryKey(Integer requirementId);

    int insert(Requirement record);

    int insertSelective(Requirement record);

    Requirement selectByPrimaryKey(Integer requirementId);

    int updateByPrimaryKeySelective(Requirement record);

    int updateByPrimaryKeyWithBLOBs(Requirement record);

    int updateByPrimaryKey(Requirement record);
}