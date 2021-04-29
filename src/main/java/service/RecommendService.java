package service;

import org.springframework.stereotype.Service;
import pojo.Local;
import pojo.Weather;
import result.Result;


public interface RecommendService {

    public Result<Local> getLocal();

    public Result<Weather> getWeather();

}
