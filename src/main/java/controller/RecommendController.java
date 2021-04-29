package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Local;
import pojo.Weather;
import result.Result;
import service.RecommendService;

@Controller
@RequestMapping("/recommend")
public class RecommendController {

    @Autowired
    RecommendService recommendService;

    @RequestMapping("/getLocal")
    @ResponseBody
    public Result<Local> getLocal(){
        return recommendService.getLocal();
    }

    @RequestMapping("/getWeather")
    @ResponseBody
    public Result<Weather> getWeather(){
        return recommendService.getWeather();
    }
}
