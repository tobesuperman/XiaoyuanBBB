package mjxm.controller;

import com.carrotsearch.sizeof.RamUsageEstimator;
import mjxm.pojo.Information;
import mjxm.pojo.Student;
import mjxm.pojo.User;
import mjxm.service.InformationService;
import mjxm.service.StudentService;
import mjxm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("information")
public class InformationController {
    @Autowired
    private InformationService informationService;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;

    /**
     * 用户查看信息
     *
     * @param userId 用户id
     * @return 用户信息
     */
    @RequestMapping("all")
    public @ResponseBody
    Map<String, Information> all(@RequestParam("userId") String userId) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, Information> map = new HashMap<>();
        Information information;
        if (RamUsageEstimator.sizeOf(user) != 0) {
            information = informationService.findByUser(Integer.parseInt(userId));
            Student student = studentService.findByUser(Integer.parseInt(userId));
            if (RamUsageEstimator.sizeOf(information) == 0) {
                information.setNumber(student.getNumber());
                information.setName(student.getName());
                information.setDepartment(student.getDepartment());
                information.setSchool(student.getSchool());
            }
            map.put("result", information);
            return map;
        }
        map.put("result", null);
        return map;
    }

    /**
     * 用户修改信息
     *
     * @param userId      用户id
     * @param number      用户学号
     * @param name        用户姓名
     * @param department  用户学院
     * @param school      用户学校
     * @param address     用户地址
     * @param phoneNumber 用户手机号码
     * @return 提示信息
     */
    @RequestMapping("modify")
    public @ResponseBody
    Map<String, String> modify(@RequestParam("userId") String userId, @RequestParam("number") String number,
                               @RequestParam("name") String name, @RequestParam("department") String department,
                               @RequestParam("school") String school, @RequestParam("address") String address,
                               @RequestParam("phoneNumber") String phoneNumber) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, String> map = new HashMap<>();
        if (RamUsageEstimator.sizeOf(user) != 0) {
            Information information = informationService.findByUser(Integer.parseInt(userId));
            information.setPhoneNumber(phoneNumber);
            information.setAddress(address);
            if (RamUsageEstimator.sizeOf(information) != 0) {
                if (informationService.modify(information) == 1) {
                    map.put("result", "success");
                    return map;
                }
            } else {
                information.setNumber(number);
                information.setName(name);
                information.setDepartment(department);
                information.setSchool(school);
                if (informationService.add(information) == 1) {
                    map.put("result", "success");
                    return map;
                }
            }
        }
        map.put("result", "error");
        return map;
    }
}
