package pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Download {
    private Integer downloadId;

    private String downloadName;

    private Integer downloadType;

    private Date createTime;

    private Date updateTime;

    public Integer getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(Integer downloadId) {
        this.downloadId = downloadId;
    }

    public String getDownloadName() {
        return downloadName;
    }

    public void setDownloadName(String downloadName) {
        this.downloadName = downloadName == null ? null : downloadName.trim();
    }

    public Integer getDownloadType() {
        return downloadType;
    }

    public void setDownloadType(Integer downloadType) {
        this.downloadType = downloadType;
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