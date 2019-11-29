package mjxm.controller;

import com.carrotsearch.sizeof.RamUsageEstimator;
import mjxm.pojo.Record;
import mjxm.pojo.Requirement;
import mjxm.pojo.User;
import mjxm.service.RecordService;
import mjxm.service.RequirementService;
import mjxm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("record")
public class RecordController {
    @Autowired
    private RequirementService requirementService;
    @Autowired
    private UserService userService;
    @Autowired
    private RecordService recordService;

    /**
     * 增加/更新用户的需求浏览记录
     *
     * @param userId        用户id
     * @param requirementId 用户浏览的需求id
     * @return 提示信息
     */
    @RequestMapping("add")
    public @ResponseBody
    Map<String, String> add(@RequestParam("userId") String userId, @RequestParam("requirementId") String requirementId) {
        User user = userService.findById(Integer.parseInt(userId));
        Requirement requirement = requirementService.findById(Integer.parseInt(requirementId));
        Map<String, String> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到用户和需求
        if (RamUsageEstimator.sizeOf(user) != 0 && RamUsageEstimator.sizeOf(requirement) != 0) {
            Record record = recordService.findByUserAndRequirement(Integer.parseInt(userId), Integer.parseInt(requirementId));
            if (RamUsageEstimator.sizeOf(record) != 0) {
                // 浏览记录存在则更新时间
                record.setTime(new Date());
                if (recordService.update(record) == 1) {
                    map.put("result", "success");
                    return map;
                }
            } else {
                // 浏览记录不存在则新增
                record = new Record();
                record.setUserId(Integer.parseInt(userId));
                record.setRequirementId(Integer.parseInt(requirementId));
                recordService.add(record);
                map.put("result", "success");
                return map;
            }
        }
        map.put("result", "error");
        return map;
    }

    /**
     * 用户查看需求浏览记录
     *
     * @param userId 用户id
     * @return 需求浏览记录
     */
    @RequestMapping("all")
    public @ResponseBody
    Map<String, List<Record>> all(@RequestParam("userId") String userId) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, List<Record>> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到用户和需求
        if (RamUsageEstimator.sizeOf(user) != 0) {
            List<Record> list = recordService.findUserAllRecord(Integer.parseInt(userId));
            map.put("result", list);
            return map;
        }
        map.put("result", null);
        return map;
    }
}
