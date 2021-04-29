package pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Dress {
    private Integer dressId;

    private String dressName;

    private Integer dressType;

    private Date createTime;

    private Date updateTime;

    public Integer getDressId() {
        return dressId;
    }

    public void setDressId(Integer dressId) {
        this.dressId = dressId;
    }

    public String getDressName() {
        return dressName;
    }

    public void setDressName(String dressName) {
        this.dressName = dressName == null ? null : dressName.trim();
    }

    public Integer getDressType() {
        return dressType;
    }

    public void setDressType(Integer dressType) {
        this.dressType = dressType;
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