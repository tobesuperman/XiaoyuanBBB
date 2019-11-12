package mjxm.controller;

import mjxm.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("information")
public class InformationController {
    @Autowired
    private RequirementService requirementService;

    @RequestMapping("add")
    @ResponseBody
    public Map<String, String> release() {
        Map<String, String> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }
}
