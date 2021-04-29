package controller;

import com.fasterxml.jackson.annotation.JsonFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.UserMessage;
import result.Result;
import service.UserMessageService;
import vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserMessageService userMessageService;
    UserVo userVo;

    @RequestMapping("/page")
    public String intoPage(){
        return "Register";
    }

    @RequestMapping("/submit_message")
    @ResponseBody
    public Result<Boolean> submit(HttpServletRequest request,HttpServletResponse response ){

        Result<Boolean> result = userMessageService.register(request,response);

        return result;
    }


}
