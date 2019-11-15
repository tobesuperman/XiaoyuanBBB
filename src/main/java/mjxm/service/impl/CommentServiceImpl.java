package mjxm.service.impl;

import mjxm.mapping.CommentMapper;
import mjxm.mapping.RequirementMapper;
import mjxm.pojo.Comment;
import mjxm.pojo.Requirement;
import mjxm.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private RequirementMapper requirementMapper;

    @Override
    public void release(Comment comment) {
        commentMapper.insert(comment);
    }

    @Override
    public Comment findById(Integer commentId) {
        return commentMapper.selectCommentJoinUserAndRequirement(commentId);
    }

    @Override
    public Map<Comment, Requirement> findUserAllComment(Integer userId) {
        Map<Comment, Requirement> map = new HashMap<>();
        List<Comment> list = commentMapper.selectUserAllComment(userId);
        for (Comment comment : list) {
            Requirement requirement = requirementMapper.selectRequirementJoinUser(comment.getRequirementId());
            map.put(comment, requirement);
        }
        return map;
    }
}
