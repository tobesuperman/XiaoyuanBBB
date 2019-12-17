package mjxm.pojo;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private Date time;

    private Integer userId;

    private String content;

    public Comment(Integer commentId, Date time, Integer userId, String content) {
        this.commentId = commentId;
        this.time = time;
        this.userId = userId;
        this.content = content;
    }

    public Comment() {
        super();
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}