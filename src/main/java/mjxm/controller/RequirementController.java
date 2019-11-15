package mjxm.controller;

import com.carrotsearch.sizeof.RamUsageEstimator;
import mjxm.pojo.Requirement;
import mjxm.pojo.User;
import mjxm.service.RequirementService;
import mjxm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "requirement")
public class RequirementController {
    @Autowired
    private RequirementService requirementService;
    @Autowired
    private UserService userService;

    /**
     * 用户发布需求
     * @param userId 用户id
     * @param title 需求标题
     * @param type 需求类型（代取快递/代取外卖/代打饭/其他）
     * @param content 需求内容
     * @param address 需求地址
     * @param visible 需求是否可见
     * @return 提示信息
     */
    @RequestMapping(value = "release", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> release(@RequestParam("userId") String userId, @RequestParam("title") String title,
                                @RequestParam("type") String type, @RequestParam("content") String content,
                                @RequestParam("address") String address, @RequestParam("visible") String visible) {
        User user = userService.find(Integer.parseInt(userId));
        Map<String, String> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到用户
        if (RamUsageEstimator.sizeOf(user) != 0) {
            Requirement requirement = new Requirement();
            requirement.setTitle(title);
            requirement.setType(Integer.parseInt(type));
            requirement.setContent(content);
            requirement.setAddress(address);
            requirement.setVisible(Integer.parseInt(visible));
            requirement.setStatus(1);
            requirement.setUserId(Integer.parseInt(userId));
            requirementService.release(requirement);
            map.put("result", "success");
            return map;
        }
        map.put("result", "error");
        return map;
    }

    /**
     * 用户查看已发布的需求
     * @param userId 用户id
     * @return 需求
     */
    @RequestMapping(value = "all", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, List<Requirement>> all(@RequestParam("user_id") String userId) {
        User user = userService.find(Integer.parseInt(userId));
        Map<String, List<Requirement>> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到用户
        if (RamUsageEstimator.sizeOf(user) != 0) {
            List<Requirement> list = requirementService.findUserAllRequirement(Integer.parseInt(userId));
            if (list.size() != 0) {
                map.put("result", list);
                return map;
            }
        }
        map.put("result", null);
        return map;
    }
}
