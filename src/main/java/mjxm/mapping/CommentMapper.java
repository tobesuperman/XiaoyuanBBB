package mjxm.mapping;

import mjxm.pojo.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment comment);

    int insertSelective(Comment comment);

    Comment selectByPrimaryKey(Integer commentId);

    Comment selectCommentJoinUserAndRequirement(Integer commentId);

    List<Comment> selectUserAllComment(Integer userId);

    int updateByPrimaryKeySelective(Comment comment);

    int updateByPrimaryKeyWithBLOBs(Comment comment);

    int updateByPrimaryKey(Comment comment);
}