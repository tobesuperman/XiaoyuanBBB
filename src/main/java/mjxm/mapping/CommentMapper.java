package mjxm.mapping;

import mjxm.pojo.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    Comment selectCommentJoinUserAndRequirement(Integer commentId);

    List<Comment> selectUserAllComment(Integer userId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}