package mjxm.service;

import mjxm.pojo.Requirement;
import mjxm.pojo.User;

import java.util.List;

public interface RequirementService {
    public void release(Requirement requirement);

    public Requirement findById(Integer requirementId);

    public List<Requirement> findUserAllReleasedRequirement(Integer userId);

    public List<Requirement> findUserAllReceivedRequirement(Integer userId);

    public List<Requirement> findAllRequirement(String title, Integer type, String content, String address);

    public int updateRequirementToProcessing(Integer userId, Integer requirementId);

    public int updateRequirementToCompleted(Integer requirementId);

    public int updateRequirementToCancelled(Integer requirementId);
}
