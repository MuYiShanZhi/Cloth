package dao;

import pojo.Top;

public interface TopMapper {
    int deleteByPrimaryKey(Integer topId);

    int insert(Top record);

    int insertSelective(Top record);

    Top selectByPrimaryKey(Integer topId);

    int updateByPrimaryKeySelective(Top record);

    int updateByPrimaryKey(Top record);
}