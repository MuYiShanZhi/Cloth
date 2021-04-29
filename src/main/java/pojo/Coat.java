package pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Coat {
    private Integer coatId;

    private String coatName;

    private Integer coatType;

    private Date createTime;

    private Date updateTime;

    public Integer getCoatId() {
        return coatId;
    }

    public void setCoatId(Integer coatId) {
        this.coatId = coatId;
    }

    public String getCoatName() {
        return coatName;
    }

    public void setCoatName(String coatName) {
        this.coatName = coatName == null ? null : coatName.trim();
    }

    public Integer getCoatType() {
        return coatType;
    }

    public void setCoatType(Integer coatType) {
        this.coatType = coatType;
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