package pojo;

import lombok.Data;

import java.util.Date;
@Data
public class UserSelf {
    private Integer selfId;

    private String selfName;

    private String selfLabel;

    private Integer selfTop;

    private Integer selfDownload;

    private Integer selfDress;

    private Integer selfCoat;

    private Date createTime;

    private Date updateTime;

    public Integer getSelfId() {
        return selfId;
    }

    public void setSelfId(Integer selfId) {
        this.selfId = selfId;
    }

    public String getSelfName() {
        return selfName;
    }

    public void setSelfName(String selfName) {
        this.selfName = selfName == null ? null : selfName.trim();
    }

    public String getSelfLabel() {
        return selfLabel;
    }

    public void setSelfLabel(String selfLabel) {
        this.selfLabel = selfLabel == null ? null : selfLabel.trim();
    }

    public Integer getSelfTop() {
        return selfTop;
    }

    public void setSelfTop(Integer selfTop) {
        this.selfTop = selfTop;
    }

    public Integer getSelfDownload() {
        return selfDownload;
    }

    public void setSelfDownload(Integer selfDownload) {
        this.selfDownload = selfDownload;
    }

    public Integer getSelfDress() {
        return selfDress;
    }

    public void setSelfDress(Integer selfDress) {
        this.selfDress = selfDress;
    }

    public Integer getSelfCoat() {
        return selfCoat;
    }

    public void setSelfCoat(Integer selfCoat) {
        this.selfCoat = selfCoat;
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