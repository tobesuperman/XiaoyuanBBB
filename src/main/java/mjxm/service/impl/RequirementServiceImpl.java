package mjxm.service.impl;

import mjxm.mapping.RequirementMapper;
import mjxm.pojo.Requirement;
import mjxm.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirementServiceImpl implements RequirementService {
    @Autowired
    private RequirementMapper requirementMapper;

    @Override
    public void release(Requirement requirement) {
        requirementMapper.insert(requirement);
    }

    @Override
    public Requirement findById(Integer requirementId) {
        // 联合requirement和user表进行查询
        return requirementMapper.selectRequirementJoinUser(requirementId);
        // 只查询requirement表
        //return requirementMapper.selectByPrimaryKey(requirementId);
    }

    @Override
    public List<Requirement> findUserAllRequirement(Integer userId) {
        return requirementMapper.selectUserAllRequirement(userId);
    }

    @Override
    public List<Requirement> findAllRequirement(String title, Integer type, String content, String address) {
        return requirementMapper.selectAllRequirement(title, type, content, address);
    }

    @Override
    public int updateRequirementStatus(Integer requirementId, Integer status) {
        return requirementMapper.updateRequirementStatus(requirementId, status);
    }
}
