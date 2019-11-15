package mjxm.pojo;

import java.util.Date;

public class Requirement {
    private Integer requirementId;

    private String title;

    private Integer type;

    private String address;

    private Date time;

    private Integer visible;

    private Integer status;

    private Integer userId;

    private String content;

//    private User user;

    public Requirement(Integer requirementId, String title, Integer type, String address, Date time, Integer visible, Integer status, Integer userId, String content) {
        this.requirementId = requirementId;
        this.title = title;
        this.type = type;
        this.address = address;
        this.time = time;
        this.visible = visible;
        this.status = status;
        this.userId = userId;
        this.content = content;
    }

    public Requirement() {
        super();
    }

    public Integer getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Integer requirementId) {
        this.requirementId = requirementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

//    public void setUser(User user) {
//        this.user = user;
//    }
}