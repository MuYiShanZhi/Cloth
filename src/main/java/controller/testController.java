package controller;

import org.apache.ibatis.annotations.Param;
import org.codehaus.plexus.component.annotations.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.SiteMessage;
import pojo.UserMessage;
import result.Result;
import service.UserMessageService;
import util.QiniuUploadUtil;

@Controller
public class testController {

    @Autowired
    UserMessageService userMessageService;
    @GetMapping(value = "/select")
    @ResponseBody
    public UserMessage hello() {
        UserMessage userMessage = userMessageService.select(Long.valueOf(1));
        if(userMessage==null){
            return null;
        }
        else{
            return userMessage;
        }
    }

    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/test")
    public String test(){
        return "Login";
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

    @RequestMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping("/findSite")
    public String findSite(){
        return "findSite";
    }
    @RequestMapping("/qinu?url={url}&&name={name}")
    public Result<Boolean> upload(@PathVariable("url")String url, @PathVariable("name") String name){
        QiniuUploadUtil.UploadPic(url,name);
        return Result.success(true);
    }

    public static void main(String[] args) {
        String s=QiniuUploadUtil.UploadPic("C:\\Users\\yangqi\\notebookfiles\\cloth\\testing\\Coat","coat (83)");
        System.out.println(s);
    }

}
