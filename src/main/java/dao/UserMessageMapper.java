package dao;

import pojo.UserMessage;

public interface UserMessageMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserMessage record);

    int insertSelective(UserMessage record);

    UserMessage selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserMessage record);

    int updateByPrimaryKey(UserMessage record);
}