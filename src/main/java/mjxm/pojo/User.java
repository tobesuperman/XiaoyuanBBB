package mjxm.pojo;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String gender;

    private String wxName;

    private String wxImg;

    private Date time;

    private Integer type;

    private Integer identified;

    private String number;

    private String introduction;

    public User(Integer userId, String userName, String password, String gender, String wxName, String wxImg, Date time, Integer type, Integer identified, String number, String introduction) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.wxName = wxName;
        this.wxImg = wxImg;
        this.time = time;
        this.type = type;
        this.identified = identified;
        this.number = number;
        this.introduction = introduction;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public String getWxImg() {
        return wxImg;
    }

    public void setWxImg(String wxImg) {
        this.wxImg = wxImg;
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

    public Integer getIdentified() {
        return identified;
    }

    public void setIdentified(Integer identified) {
        this.identified = identified;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}