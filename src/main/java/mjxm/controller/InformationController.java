package mjxm.controller;

import com.carrotsearch.sizeof.RamUsageEstimator;
import mjxm.pojo.Information;
import mjxm.pojo.User;
import mjxm.service.InformationService;
import mjxm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("information")
public class InformationController {
    @Autowired
    private InformationService informationService;
    @Autowired
    private UserService userService;

    /**
     * 用户添加联系方式
     *
     * @param userId      用户id
     * @param phoneNumber 用户手机号码
     * @param address     用户地址
     * @param defaults    是否为默认联系方式
     * @return 提示信息
     */
    @RequestMapping("add")
    public @ResponseBody
    Map<String, String> add(@RequestParam("userId") String userId, @RequestParam("phoneNumber") String phoneNumber,
                            @RequestParam("address") String address, @RequestParam("defaults") String defaults) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, String> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到用户
        if (RamUsageEstimator.sizeOf(user) != 0) {
            Information information = new Information();
            information.setUserId(Integer.parseInt(userId));
            information.setPhoneNumber(phoneNumber);
            information.setAddress(address);
            information.setDefaults(Integer.parseInt(defaults));
            informationService.add(information);
            map.put("result", "success");
            return map;
        }
        map.put("result", "success");
        return map;
    }

    /**
     * 用户查看已添加的联系方式
     *
     * @param userId 用户id
     * @return 联系方式
     */
    @RequestMapping("all")
    public @ResponseBody
    Map<String, List<Information>> all(@RequestParam("userId") String userId) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, List<Information>> map = new HashMap<>();
        if (RamUsageEstimator.sizeOf(user) != 0) {
            List<Information> list = informationService.findUserAllInformation(Integer.parseInt(userId));
            map.put("result", list);
            return map;
        }
        map.put("result", null);
        return map;
    }

    /**
     * 用户修改联系方式
     *
     * @param informationId 联系方式id
     * @param userId        用户id
     * @param phoneNumber   用户手机号码
     * @param address       用户地址
     * @param defaults      是否为默认联系方式
     * @return 提示信息
     */
    @RequestMapping("modify")
    public @ResponseBody
    Map<String, String> modify(@RequestParam("informationId") String informationId, @RequestParam("userId") String userId,
                               @RequestParam("phoneNumber") String phoneNumber, @RequestParam("address") String address,
                               @RequestParam("defaults") String defaults) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, String> map = new HashMap<>();
        if (RamUsageEstimator.sizeOf(user) != 0) {
            Information information = informationService.findById(Integer.parseInt(informationId));
            if (RamUsageEstimator.sizeOf(information) != 0) {
                information.setPhoneNumber(phoneNumber);
                information.setAddress(address);
                information.setDefaults(Integer.parseInt(defaults));
                if (informationService.modify(information) == 1) {
                    map.put("result", "success");
                    return map;
                }
            }
        }
        map.put("result", "error");
        return map;
    }

    /**
     * 用户删除联系方式
     *
     * @param informationId 联系方式id
     * @param userId        用户id
     * @return 提示信息
     */
    @RequestMapping("delete")
    public @ResponseBody
    Map<String, String> delete(@RequestParam("informationId") String informationId, @RequestParam("userId") String userId) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, String> map = new HashMap<>();
        if (RamUsageEstimator.sizeOf(user) != 0) {
            if (informationService.deleteById(Integer.parseInt(informationId)) == 1) {
                map.put("result", "error");
                return map;
            }
        }
        map.put("result", "error");
        return map;
    }

    /**
     * 用户删除所有联系方式
     *
     * @param userId 用户id
     * @return 提示信息
     */
    @RequestMapping("deleteAll")
    public @ResponseBody
    Map<String, String> deleteAll(@RequestParam("userId") String userId) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, String> map = new HashMap<>();
        if (RamUsageEstimator.sizeOf(user) != 0) {
            if (informationService.deleteAllInformation(Integer.parseInt(userId)) > 0) {
                map.put("result", "success");
                return map;
            }
        }
        map.put("result", "error");
        return map;
    }
}
