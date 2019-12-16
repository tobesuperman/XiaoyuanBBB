package mjxm.controller;

import com.carrotsearch.sizeof.RamUsageEstimator;
import mjxm.pojo.User;
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

    /**
     * 用户注册
     *
     * @param userName     用户名
     * @param password     用户密码
     * @param gender       用户性别
     * @param type         用户类型（学生/教师）
     * @param identified   用户是否认证
     * @param introduction 用户简介
     * @return 用户id
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Integer> register(@RequestParam("userName") String userName, @RequestParam("password") String password,
                                  @RequestParam("gender") String gender, @RequestParam("type") String type,
                                  @RequestParam("identified") String identified, @RequestParam("introduction") String introduction) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setGender(gender);
        if (type.equals("学生")) user.setType(1);
        else user.setType(2);
        if (identified.equals("是")) user.setIdentified(1);
        else user.setIdentified(2);
        if (introduction.equals("")) user.setIntroduction("这个人很懒，什么都没留下~");
        else user.setIntroduction(introduction);
        userService.register(user);
        Map<String, Integer> map = new HashMap<>();
        map.put("result", user.getUserId());
        return map;
    }

    /**
     * 检查用户名是否可用
     *
     * @param userName 用户名
     * @return 提示信息
     */
    @RequestMapping(value = "checkUserName", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Integer> checkUserName(@RequestParam("userName") String userName) {
        Map<String, Integer> map = new HashMap<>();
        map.put("result", userService.checkUserName(userName));
        return map;
    }

    /**
     * 用户登录
     *
     * @param userName 用户名
     * @param password 用户密码
     * @return 提示信息
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Integer> login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        Map<String, Integer> map = new HashMap<>();
        map.put("result", userService.login(userName, password));
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
        map.put("result", userService.logout(Integer.parseInt(userId)));
        return map;
    }

    /**
     * 用户绑定微信
     *
     * @param userId 用户id
     * @param wxName 用户微信名
     * @param wxImg  用户微信头像
     * @return 提示信息
     */
    @RequestMapping(value = "weixinBinding", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Integer> weixinBinding(@RequestParam("userId") String userId, @RequestParam("wxName") String wxName,
                                       @RequestParam("wxImg") String wxImg) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, Integer> map = new HashMap<>();
        if (RamUsageEstimator.sizeOf(user) != 0) {
            map.put("result", userService.weixinBinding(Integer.parseInt(userId), wxName, wxImg));
            return map;
        }
        map.put("result", 0);
        return map;
    }

    /**
     * 用户认证
     *
     * @param userId 用户id
     * @param type   用户类型
     * @param number 用户学号/教工号
     * @return 提示信息
     */
    @RequestMapping(value = "identify", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Integer> identify(@RequestParam("userId") String userId, @RequestParam("type") String type,
                                  @RequestParam("number") String number) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, Integer> map = new HashMap<>();
        if (RamUsageEstimator.sizeOf(user) != 0) {
            /*
            调用接口验证用户
            */
            map.put("result", userService.identify(Integer.parseInt(userId), number));
            return map;
        }
        map.put("result", 0);
        return map;
    }
}
