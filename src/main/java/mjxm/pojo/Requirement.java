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

    private Integer releaserId;

    private Integer receiverId;

    private String content;


    public Requirement(Integer requirementId, String title, Integer type, String address, Date time, Integer visible, Integer status, Integer releaserId, String content) {
        this.requirementId = requirementId;
        this.title = title;
        this.type = type;
        this.address = address;
        this.time = time;
        this.visible = visible;
        this.status = status;
        this.releaserId = releaserId;
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

    public Integer getReleaserId() {
        return releaserId;
    }

    public void setReleaserId(Integer releaserId) {
        this.releaserId = releaserId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

}