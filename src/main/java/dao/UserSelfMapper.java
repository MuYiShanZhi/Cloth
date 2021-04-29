package dao;

import pojo.UserSelf;

public interface UserSelfMapper {
    int deleteByPrimaryKey(Integer selfId);

    int insert(UserSelf record);

    int insertSelective(UserSelf record);

    UserSelf selectByPrimaryKey(Integer selfId);

    int updateByPrimaryKeySelective(UserSelf record);

    int updateByPrimaryKey(UserSelf record);
}