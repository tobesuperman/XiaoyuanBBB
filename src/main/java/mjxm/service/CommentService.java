package mjxm.service;

import mjxm.pojo.Comment;

import java.util.List;

public interface CommentService {
    public void release(Comment comment);

    public Comment findById(Integer commentId);

    public List<Comment> findUserAllComment(Integer userId);
}
