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
     *
     * @param userId  用户id
     * @param title   需求标题
     * @param type    需求类型（代取快递/代取外卖/代打饭/其他）
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
        User user = userService.findById(Integer.parseInt(userId));
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
            requirement.setReleaserId(Integer.parseInt(userId));
            requirementService.release(requirement);
            map.put("result", "success");
            return map;
        }
        map.put("result", "error");
        return map;
    }

    /**
     * 用户（作为发布者）查看已发布的需求
     *
     * @param userId 用户id
     * @return 需求
     */
    @RequestMapping(value = "userAllReleased", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, List<Requirement>> userAllReleased(@RequestParam("userId") String userId) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, List<Requirement>> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到用户
        if (RamUsageEstimator.sizeOf(user) != 0) {
            List<Requirement> list = requirementService.findUserAllReleasedRequirement(Integer.parseInt(userId));
            if (list.size() != 0) {
                map.put("result", list);
                return map;
            }
        }
        map.put("result", null);
        return map;
    }

    /**
     * 用户（作为接受者）查看已接受的需求
     *
     * @param userId 用户id
     * @return 需求
     */
    @RequestMapping(value = "userAllReceived", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, List<Requirement>> userAllReceived(@RequestParam("userId") String userId) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, List<Requirement>> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到用户
        if (RamUsageEstimator.sizeOf(user) != 0) {
            List<Requirement> list = requirementService.findUserAllReceivedRequirement(Integer.parseInt(userId));
            if (list.size() != 0) {
                map.put("result", list);
                return map;
            }
        }
        map.put("result", null);
        return map;
    }

    /**
     * 用户查看指定需求
     *
     * @param userId        用户id
     * @param requirementId 需求id
     * @return 需求
     */
    @RequestMapping(value = "content", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Requirement> content(@RequestParam("userId") String userId, @RequestParam("requirementId") String requirementId) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, Requirement> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到用户
        if (RamUsageEstimator.sizeOf(user) != 0) {
            map.put("result", requirementService.findById(Integer.parseInt(requirementId)));
        }
        map.put("result", null);
        return map;
    }

    /**
     * 用户搜索需求
     *
     * @param userId  用户id
     * @param title   需求标题
     * @param type    需求类型
     * @param content 需求内容
     * @param address 需求地址
     * @return 符合条件的需求
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, List<Requirement>> search(@RequestParam("userId") String userId, @RequestParam(value = "title", required = false) String title,
                                          @RequestParam(value = "type", required = false) String type, @RequestParam(value = "content", required = false) String content,
                                          @RequestParam(value = "address", required = false) String address) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, List<Requirement>> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到用户
        if (RamUsageEstimator.sizeOf(user) != 0) {
            List<Requirement> list = requirementService.findAllRequirement(title, type == null ? null : Integer.parseInt(type), content, address);
            if (list.size() != 0) {
                map.put("result", list);
                return map;
            }
        }
        map.put("result", null);
        return map;
    }

    /**
     * 用户接受需求
     *
     * @param requirementId 需求id
     * @return 提示信息
     */
    @RequestMapping(value = "process", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> process(@RequestParam("userId") String userId, @RequestParam("requirementId") String requirementId) {
        User user = userService.findById(Integer.parseInt(userId));
        Requirement requirement = requirementService.findById(Integer.parseInt(requirementId));
        Map<String, String> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到需求
        if (RamUsageEstimator.sizeOf(user) != 0 && RamUsageEstimator.sizeOf(requirement) != 0) {
            if (requirementService.updateRequirementToProcessing(Integer.parseInt(userId), Integer.parseInt(requirementId)) == 1) {
                map.put("result", "success");
                return map;
            }
        }
        map.put("result", "error");
        return map;
    }

    /**
     * 需求完成
     *
     * @param requirementId 需求id
     * @return 提示信息
     */
    @RequestMapping(value = "complete", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> complete(@RequestParam("requirementId") String requirementId) {
        Requirement requirement = requirementService.findById(Integer.parseInt(requirementId));
        Map<String, String> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到需求
        if (RamUsageEstimator.sizeOf(requirement) != 0) {
            if (requirementService.updateRequirementToCompleted(Integer.parseInt(requirementId)) == 1) {
                map.put("result", "success");
                return map;
            }
        }
        map.put("result", "error");
        return map;
    }

    /**
     * 用户取消需求
     *
     * @param userId        用户id
     * @param requirementId 需求id
     * @return 提示信息
     */
    @RequestMapping(value = "cancel", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> cancel(@RequestParam("userId") String userId, @RequestParam("requirementId") String requirementId) {
        User user = userService.findById(Integer.parseInt(userId));
        Requirement requirement = requirementService.findById(Integer.parseInt(requirementId));
        Map<String, String> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到需求
        if (RamUsageEstimator.sizeOf(user) != 0 && RamUsageEstimator.sizeOf(requirement) != 0) {
            if (requirementService.updateRequirementToCancelled(Integer.parseInt(requirementId)) == 1) {
                map.put("result", "success");
                return map;
            }
        }
        map.put("result", "error");
        return map;
    }
}
