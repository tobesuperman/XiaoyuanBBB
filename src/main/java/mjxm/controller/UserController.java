package mjxm.controller;

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
     * @param username     用户名
     * @param password     用户密码
     * @param gender       用户性别
     * @param wxName       用户微信名
     * @param wxImg        用户微信头像（url）
     * @param type         用户类型（学生/教师）
     * @param identified   用户是否认证
     * @param number       用户学号/教工号
     * @param introduction 用户简介
     * @return 提示信息
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> register(@RequestParam("userName") String username, @RequestParam("password") String password,
                                 @RequestParam("gender") String gender, @RequestParam("wxName") String wxName,
                                 @RequestParam("wxImg") String wxImg, @RequestParam("type") String type,
                                 @RequestParam("identified") String identified, @RequestParam("number") String number,
                                 @RequestParam("introduction") String introduction) {
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setGender(gender);
        user.setWxName(wxName);
        user.setWxImg(wxImg);
        if (type.equals("学生")) user.setType(1);
        else user.setType(2);
        if (identified.equals("是")) user.setIdentified(1);
        else user.setIdentified(2);
        if (!number.equals("")) user.setNumber(number);
        if (introduction.equals("")) user.setIntroduction("这个人很懒，什么都没留下~");
        else user.setIntroduction(introduction);
        userService.register(user);
        Map<String, String> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }
}
