package dao;

import pojo.Dress;

public interface DressMapper {
    int deleteByPrimaryKey(Integer dressId);

    int insert(Dress record);

    int insertSelective(Dress record);

    Dress selectByPrimaryKey(Integer dressId);

    int updateByPrimaryKeySelective(Dress record);

    int updateByPrimaryKey(Dress record);
}