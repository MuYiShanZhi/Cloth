package pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Top {
    private Integer topId;

    private String topName;

    private Integer topType;

    private Date createTime;

    private Date updateTime;

    public Integer getTopId() {
        return topId;
    }

    public void setTopId(Integer topId) {
        this.topId = topId;
    }

    public String getTopName() {
        return topName;
    }

    public void setTopName(String topName) {
        this.topName = topName == null ? null : topName.trim();
    }

    public Integer getTopType() {
        return topType;
    }

    public void setTopType(Integer topType) {
        this.topType = topType;
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