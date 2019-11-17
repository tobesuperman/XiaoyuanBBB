package mjxm.service;

import mjxm.pojo.Requirement;
import mjxm.pojo.User;

import java.util.List;

public interface RequirementService {
    public void release(Requirement requirement);

    public Requirement findById(Integer requirementId);

    public List<Requirement> findUserAllRequirement(Integer userId);

    public List<Requirement> findAllRequirement(String title, Integer type, String content, String address);

    public int updateRequirementStatus(Integer requirementId, Integer status);
}
