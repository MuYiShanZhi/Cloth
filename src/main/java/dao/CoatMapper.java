package dao;

import pojo.Coat;

public interface CoatMapper {
    int deleteByPrimaryKey(Integer coatId);

    int insert(Coat record);

    int insertSelective(Coat record);

    Coat selectByPrimaryKey(Integer coatId);

    int updateByPrimaryKeySelective(Coat record);

    int updateByPrimaryKey(Coat record);
}