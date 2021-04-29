package pojo;

import lombok.Data;

import java.util.Date;
@Data
public class UserMessage {
    private Long userId;

    private String userImg;

    private Long userPhone;

    private String userPassword;

    private String userName;

    private Short userAge;

    private Byte userGender;

    private Date createTime;

    private Date updateTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg == null ? null : userImg.trim();
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Short getUserAge() {
        return userAge;
    }

    public void setUserAge(Short userAge) {
        this.userAge = userAge;
    }

    public Byte getUserGender() {
        return userGender;
    }

    public void setUserGender(Byte userGender) {
        this.userGender = userGender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}