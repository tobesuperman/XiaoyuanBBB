package mjxm.controller;

import mjxm.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("requirement")
public class RequirementController {
    @Autowired
    private RequirementService requirementService;

    @RequestMapping("release")
    @ResponseBody
    public Map<String, String> release() {
        Map<String, String> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }
}
