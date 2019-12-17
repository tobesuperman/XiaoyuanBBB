package mjxm.service.impl;

import mjxm.mapping.CommentMapper;
import mjxm.pojo.Comment;
import mjxm.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void release(Comment comment) {
        commentMapper.insert(comment);
    }

    @Override
    public Comment findById(Integer commentId) {
        return commentMapper.selectCommentJoinUserAndRequirement(commentId);
    }

    @Override
    public List<Comment> findUserAllComment(Integer userId) {
        return commentMapper.selectUserAllComment(userId);
    }
}
