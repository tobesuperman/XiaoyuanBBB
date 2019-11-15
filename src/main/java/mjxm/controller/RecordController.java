package mjxm.controller;

import com.carrotsearch.sizeof.RamUsageEstimator;
import mjxm.pojo.Requirement;
import mjxm.pojo.User;
import mjxm.service.RequirementService;
import mjxm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("record")
public class RecordController {
    @Autowired
    private RequirementService requirementService;
    @Autowired
    private UserService userService;

    @RequestMapping("browse")
    @ResponseBody
    Map<String, String> add(@RequestParam("userId") String userId, @RequestParam("requirementId") String requirementId,
                            @RequestParam("address") String address, @RequestParam("defaults") String defaults) {
        User user = userService.find(Integer.parseInt(userId));
        Requirement requirement = requirementService.findById(Integer.parseInt(requirementId));
        Map<String, String> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到用户和需求
        if (RamUsageEstimator.sizeOf(user) != 0 && RamUsageEstimator.sizeOf(requirementId) != 0) {
//            Information information = new Information();
//            information.setUserId(Integer.parseInt(userId));
//            information.setPhoneNumber(phoneNumber);
//            information.setAddress(address);
//            information.setDefaults(Integer.parseInt(defaults));
            map.put("result", "增加信息成功！");
            return map;
        }
        map.put("result", "增加信息失败，用户不存在！");
        return map;
    }
}
