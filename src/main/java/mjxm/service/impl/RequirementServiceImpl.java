package mjxm.service.impl;

import mjxm.mapping.RequirementMapper;
import mjxm.pojo.Requirement;
import mjxm.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;

public class RequirementServiceImpl implements RequirementService {
    @Autowired
    private RequirementMapper requirementMapper;

    @Override
    public void release(Requirement requirement) {
        requirementMapper.insert(requirement);
    }
}
