package mjxm.controller;

import mjxm.pojo.User;
import mjxm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by linziyu
 * On 6/17/2018.16:28 PM
 */
@Controller
@RequestMapping("/mybatistest")
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "insertoneuser")
    public @ResponseBody
    String insertOneUser() {
        User user = new User();
        user.setUserId(2);
        user.setUserName("邹超");
        user.setPassword("123456");
        user.setGender("男");
        user.setWxName("超仔仔");
        user.setWxImg("https://image.baidu.com/");
        user.setType(1);
        user.setIdentified(2);
        userService.insert(user);
        return "success";
    }
}
