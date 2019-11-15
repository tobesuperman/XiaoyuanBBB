package mjxm.service;

import mjxm.pojo.Comment;
import mjxm.pojo.Requirement;
import mjxm.pojo.User;

import java.util.Map;

public interface CommentService {
    public void release(Comment comment);

    public Comment findById(Integer commentId);

    public Map<Comment, Requirement> findUserAllComment(Integer userId);
}
