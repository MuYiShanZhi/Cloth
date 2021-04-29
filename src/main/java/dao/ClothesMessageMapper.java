package dao;

import pojo.ClothesMessage;

public interface ClothesMessageMapper {
    int deleteByPrimaryKey(Integer clothesId);

    int insert(ClothesMessage record);

    int insertSelective(ClothesMessage record);

    ClothesMessage selectByPrimaryKey(Integer clothesId);

    int updateByPrimaryKeySelective(ClothesMessage record);

    int updateByPrimaryKey(ClothesMessage record);
}