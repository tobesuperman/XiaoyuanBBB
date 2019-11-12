package mjxm.service.impl;

import mjxm.mapping.CommentMapper;
import mjxm.pojo.Comment;
import mjxm.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void release(Comment comment) {
        commentMapper.insert(comment);
    }
}
