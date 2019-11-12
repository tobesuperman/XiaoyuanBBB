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

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> insertUser(@RequestParam("username") String username, @RequestParam("password") String password,
                          @RequestParam("gender") String gender, @RequestParam("wx_name") String wxName,
                          @RequestParam("wx_img") String wxImg, @RequestParam("type") String type,
                          @RequestParam("identified") String identified, @RequestParam("number") String number,
                          @RequestParam("introduction") String introduction) {
        System.out.println("---进入UserController---");
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
