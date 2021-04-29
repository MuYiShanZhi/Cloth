package service.impl;

import org.springframework.stereotype.Service;
import pojo.Local;
import pojo.Weather;
import result.CodeMsg;
import result.Result;
import service.RecommendService;
import util.GetSiteUtil;
@Service
public class RecommendServiceImpl implements RecommendService {
    @Override
    public Result<Local> getLocal() {
        Local result = GetSiteUtil.getPositionByIp();
        System.out.println("result_adcode:"+result.getAdcode());
        if (result.getStatus() == 0)
        {
            return Result.error(CodeMsg.FAILED_TO_GET_LOCATION);
        }
        return Result.success(result);
    }

    @Override
    public Result<Weather> getWeather() {
        Weather result = GetSiteUtil.getWeatherByAdcode(getLocal().getData().getAdcode());
        System.out.println("result_adcode:"+result.getInfocode());
        if (result.getStatus() == 0)
        {
            return Result.error(CodeMsg.FAILED_TO_GET_WEATHER);
        }
        return Result.success(result);
    }
}
