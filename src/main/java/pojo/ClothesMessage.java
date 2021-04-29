package pojo;

import lombok.Data;

import java.util.Date;
@Data
public class ClothesMessage {
    private Integer clothesId;

    private String clothesImg;

    private String clothesName;

    private Integer clothesType;

    private String clothesColor;

    private String clothesFabric;

    private String clothesLocation;

    private Date createTime;

    private Date updateTime;

    public Integer getClothesId() {
        return clothesId;
    }

    public void setClothesId(Integer clothesId) {
        this.clothesId = clothesId;
    }

    public String getClothesImg() {
        return clothesImg;
    }

    public void setClothesImg(String clothesImg) {
        this.clothesImg = clothesImg == null ? null : clothesImg.trim();
    }

    public String getClothesName() {
        return clothesName;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName == null ? null : clothesName.trim();
    }

    public Integer getClothesType() {
        return clothesType;
    }

    public void setClothesType(Integer clothesType) {
        this.clothesType = clothesType;
    }

    public String getClothesColor() {
        return clothesColor;
    }

    public void setClothesColor(String clothesColor) {
        this.clothesColor = clothesColor == null ? null : clothesColor.trim();
    }

    public String getClothesFabric() {
        return clothesFabric;
    }

    public void setClothesFabric(String clothesFabric) {
        this.clothesFabric = clothesFabric == null ? null : clothesFabric.trim();
    }

    public String getClothesLocation() {
        return clothesLocation;
    }

    public void setClothesLocation(String clothesLocation) {
        this.clothesLocation = clothesLocation == null ? null : clothesLocation.trim();
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