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
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private InformationService informationService;

    /**
     * 用户登录
     *
     * @param wxName     用户微信名
     * @param wxImg      用户微信头像（url）
     * @param gender     用户性别
     * @param number     用户学号/教工号
     * @param name       用户姓名
     * @param department 用户学院
     * @param school     用户学校
     * @param type       用户类型
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Integer> login(@RequestParam("wxName") String wxName, @RequestParam("wxImg") String wxImg,
                               @RequestParam("gender") String gender, @RequestParam("number") String number,
                               @RequestParam("name") String name, @RequestParam("wxImg") String department,
                               @RequestParam(value = "wxImg", required = false) String school,
                               @RequestParam(value = "type", required = false) Integer type) {
        Student student = new Student();
        student.setNumber(number);
        student.setName(name);
        student.setDepartment(department);
        student.setSchool(school == null ? null : "华南理工大学");
        int studentId = studentService.identify(student);
        Map<String, Integer> map = new HashMap<>();
        if (studentId != 0) {
            User user = new User();
            user.setWxName(wxName);
            user.setWxImg(wxImg);
            user.setGender(gender);
            user.setType(type == null ? null : 1);
            user.setStudentId(studentId);
            map.put("result", userService.login(user));
            return map;
        }
        map.put("result", 0);
        return map;
    }

    /**
     * 用户注销
     *
     * @param userId 用户id
     * @return 提示信息
     */
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Integer> logout(@RequestParam("userId") String userId) {
        Map<String, Integer> map = new HashMap<>();
        int result1 = userService.logout(Integer.parseInt(userId));
        int result2 = informationService.deleteByUser(Integer.parseInt(userId));
        map.put("result", result1 & result2);
        return map;
    }
}
