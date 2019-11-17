package mjxm.controller;

import com.carrotsearch.sizeof.RamUsageEstimator;
import mjxm.pojo.Comment;
import mjxm.pojo.Requirement;
import mjxm.pojo.User;
import mjxm.service.CommentService;
import mjxm.service.RequirementService;
import mjxm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private RequirementService requirementService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

    /**
     * 用户发布评论
     * @param userId 用户id
     * @param requirementId 评论针对的需求id
     * @param content 评论内容
     * @param aboutRequirementId 评论针对的评论（如果有）id
     * @return 提示信息
     */
    @RequestMapping(value = "release", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> release(@RequestParam("userId") String userId, @RequestParam("requirementId") String requirementId,
                                @RequestParam("content") String content, @RequestParam("aboutRequirementId") String aboutRequirementId) {
        User user = userService.findById(Integer.parseInt(userId));
        Requirement requirement = requirementService.findById(Integer.parseInt(requirementId));
        Map<String, String> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到用户和需求
        if (RamUsageEstimator.sizeOf(user) != 0 && RamUsageEstimator.sizeOf(requirement) != 0) {
            Comment comment = new Comment();
            comment.setUserId(Integer.parseInt(userId));
            comment.setRequirementId(Integer.parseInt(requirementId));
            comment.setContent(content);
            if (!aboutRequirementId.equals("0")) {
                comment.setAboutCommentId(Integer.parseInt(aboutRequirementId));
            }
            commentService.release(comment);
            map.put("result", "success");
            return map;
        }
        map.put("result", "success");
        return map;
    }

    /**
     * 用户查看已发布的评论
     * @param userId 用户id
     * @return 评论和对应的需求
     */
    @RequestMapping(value = "all", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Map<Comment, Requirement>> all(@RequestParam("userId") String userId) {
        User user = userService.findById(Integer.parseInt(userId));
        Map<String, Map<Comment, Requirement>> map = new HashMap<>();
        // 计算查询结果占用内存大小以判断是否查询到用户和需求
        if (RamUsageEstimator.sizeOf(user) != 0) {
            Map<Comment, Requirement> resultMap = commentService.findUserAllComment(Integer.parseInt(userId));
            map.put("result", resultMap);
            return map;
        }
        map.put("result", null);
        return map;
    }
}
