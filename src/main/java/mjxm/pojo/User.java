package mjxm.pojo;

import java.util.Date;

public class User {
    private Integer userId;

    private String wxName;

    private String wxImg;

    private String gender;

    private Date time;

    private Integer type;

    private Integer studentId;

    public User(Integer userId, String gender, String wxName, String wxImg, Date time, Integer type, Integer studentId) {
        this.userId = userId;
        this.wxName = wxName;
        this.wxImg = wxImg;
        this.gender = gender;
        this.time = time;
        this.type = type;
        this.studentId = studentId;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName == null ? null : wxName.trim();
    }

    public String getWxImg() {
        return wxImg;
    }

    public void setWxImg(String wxImg) {
        this.wxImg = wxImg == null ? null : wxImg.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}