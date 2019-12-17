package mjxm.controller;

import com.carrotsearch.sizeof.RamUsageEstimator;
import mjxm.pojo.Comment;
import mjxm.pojo.User;
import mjxm.service.CommentService;
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
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

    /**
     * 用户发布评论
     *
     * @param userId  用户id
     * @param content 评论内容
     * @return 提示信息
     */
    @RequestMapping(value = "release", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> release(@RequestParam("userId") String userId, @RequestParam("content") String content) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, String> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到用户和需求
        if (RamUsageEstimator.sizeOf(user) != 0) {
            Comment comment = new Comment();
            comment.setUserId(Integer.parseInt(userId));
            comment.setContent(content);
            commentService.release(comment);
            map.put("result", "success");
            return map;
        }
        map.put("result", "success");
        return map;
    }

    /**
     * 用户查看指定评论
     *
     * @param userId    用户id
     * @param commentId 评论id
     * @return 提示信息
     */
    @RequestMapping(value = "content", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Comment> content(@RequestParam("userId") String userId, @RequestParam("commentId") String commentId) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, Comment> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到用户和需求
        if (RamUsageEstimator.sizeOf(user) != 0) {
            map.put("result", commentService.findById(Integer.parseInt(commentId)));
            return map;
        }
        map.put("result", null);
        return map;
    }

    /**
     * 用户查看已发布的评论
     *
     * @param userId 用户id
     * @return 评论和对应的需求
     */
    @RequestMapping(value = "all", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, List<Comment>> all(@RequestParam("userId") String userId) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, List<Comment>> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到用户和需求
        if (RamUsageEstimator.sizeOf(user) != 0) {
            List<Comment> list = commentService.findUserAllComment(Integer.parseInt(userId));
            map.put("result", list);
            return map;
        }
        map.put("result", null);
        return map;
    }
}
