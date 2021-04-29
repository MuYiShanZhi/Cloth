package service;

import pojo.UserMessage;
import result.Result;
import vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserMessageService {
    public UserMessage select(Long userId);

    public Result<Boolean> register(HttpServletRequest request, HttpServletResponse response);

    public Result<Boolean> checkUser(UserVo userVo);
}
