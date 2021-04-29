package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.UserMessage;
import result.Result;
import service.UserMessageService;
import vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserMessageService userMessageService;

    @RequestMapping("/page")
    public String login(){
        return "Login";
    }
    @RequestMapping("/dologin")
    @ResponseBody
    public Result<Boolean> dologin(HttpServletRequest request){

        String vali_user = request.getParameter("ValiImage");
        String vali_sys =  request.getAttribute("Valicode").toString();
        Result<Boolean> result = null;
        System.out.println("vali_sys:"+vali_sys);
        System.out.println("vali_user:"+vali_user);
        if(vali_sys.equals(vali_user)){
            System.out.println("true");
        }
        return Result.success(true);

    }

    @PostMapping("/do_login")
    @ResponseBody
    public Result<Boolean> do_login(HttpServletRequest request, @RequestParam(value = "userId") Long userId, @RequestParam(value = "userPassword") String userPassword){
        HttpSession session = request.getSession();
        String vali_user = request.getParameter("ValiImage");
        String vali_sys =  session.getAttribute("Valicode").toString();

        System.out.println("vali_user:"+vali_user);
        System.out.println("vali_sys:"+vali_sys);

        if(vali_sys.equals(vali_user)){
            System.out.println("true");
            System.out.println("id:"+userId);
        }
        UserVo userVo = new UserVo(userId,userPassword);
        userVo.setUserId(userId);
        userVo.setUserPassword(userPassword);
        return userMessageService.checkUser(userVo);

    }
}
