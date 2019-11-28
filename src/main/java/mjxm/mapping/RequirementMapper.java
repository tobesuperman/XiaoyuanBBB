package mjxm.mapping;

import mjxm.pojo.Requirement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RequirementMapper {
    int deleteByPrimaryKey(Integer requirementId);

    int insert(Requirement record);

    int insertSelective(Requirement record);

    Requirement selectByPrimaryKey(Integer requirementId);

    Requirement selectRequirementJoinUser(Integer requirementId);

    List<Requirement> selectUserAllReleasedRequirement(Integer userId);

    List<Requirement> selectUserAllReceivedRequirement(Integer userId);

    List<Requirement> selectAllRequirement(@Param("title") String title, @Param("type") Integer type,
                                           @Param("content") String content, @Param("address") String address);

    int updateByPrimaryKeySelective(Requirement record);

    int updateByPrimaryKeyWithBLOBs(Requirement record);

    int updateByPrimaryKey(Requirement record);

    int updateRequirementStatusToProcessing(@Param("requirementId") Integer requirementId, @Param("recieverId") Integer recieverId);

    int updateRequirementStatusToCompleted(@Param("requirementId") Integer requirementId);

    int updateRequirementStatusToCancelled(@Param("requirementId") Integer requirementId);
}