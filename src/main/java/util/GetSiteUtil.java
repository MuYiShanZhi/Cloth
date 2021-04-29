package util;


import com.alibaba.fastjson.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.lang.StringUtils;
import pojo.Local;
import pojo.Weather;
import pojo.WeatherLives;


import java.util.HashMap;
import java.util.Map;

public class GetSiteUtil{

        // 高德地图key
        private static final String GDMAP_KEY = "2d783793e49dfb327b67c66358e1e003";

        /**
         * 获取当前Ip的地理位置，XX省XX市。没有参数，默认发出请求的ip地址
         * @param ip
         * @return resultLocal
         *
         */
        public static Local getPositionByIp(String ip){
            Local result = new Local();
            // 请求url
            String url = "https://restapi.amap.com/v3/ip";
            // 初始化请求参数
            Map<String,String> params = new HashMap<>();
            // 初始化结果集
            String temp = "";
            // 添加参数
            if(StringUtils.isNotBlank(ip)){
                params.put("ip",ip);
            }
            params.put("key",GDMAP_KEY);
            params.put("output","JSON");
            String resultStr = HttpClientUtils.doGet(url, params,null);
            JSONObject jsonObject = JSONObject.parseObject(resultStr);
            if("1".equals(jsonObject.getString("status"))){
                result.setStatus(1);
                if(StringUtils.isNotBlank(jsonObject.getString("province")) && !"[]".equals(jsonObject.getString("province"))){
                   result.setProvince(jsonObject.getString("province"));
                }
                if(StringUtils.isNotBlank(jsonObject.getString("city")) && !"[]".equals(jsonObject.getString("city"))){
                    result.setCity(jsonObject.getString("city"));
                }
                if(StringUtils.isNotBlank(jsonObject.getString("info")) && !"[]".equals(jsonObject.getString("info"))){
                    result.setInfo(jsonObject.getString("info"));
                }
                if(StringUtils.isNotBlank(jsonObject.getString("adcode")) && !"[]".equals(jsonObject.getString("adcode"))){
                    result.setAdcode(jsonObject.getString("adcode"));
                }
                if(StringUtils.isNotBlank(jsonObject.getString("infocode")) && !"[]".equals(jsonObject.getString("infocode"))){
                    result.setInfocode(jsonObject.getString("infocode"));
                }
                if(StringUtils.isNotBlank(jsonObject.getString("rectangle")) && !"[]".equals(jsonObject.getString("rectangle"))){
                    result.setRectangle(jsonObject.getString("rectangle"));
                }
            }else{
                result.setStatus(0);
            }
            return  result;
        }

        // 方法重载，无参数
        public static Local getPositionByIp(){
            return getPositionByIp("");
        }

    /**
     * 获取当前Ip的地理位置，XX省XX市。没有参数，默认发出请求的ip地址
     * @param city
     * @return resultStr
     *
     */
    public static Weather getWeatherByAdcode(String city){
        // 初始化结果集
        Weather result = new Weather();
        WeatherLives temp = new WeatherLives();
        // 请求url
        String url = "https://restapi.amap.com/v3/weather/weatherInfo";
        // 初始化请求参数
        Map<String,String> params = new HashMap<>();


        // 添加参数
        if(StringUtils.isNotBlank(city)){
            params.put("city",city);
        }
        params.put("key",GDMAP_KEY);
        params.put("output","JSON");
        String resultStr = HttpClientUtils.doGet(url, params,null);//返回的json数据
        JSONObject jsonObject = JSONObject.parseObject(resultStr);//解析json
        JsonParser parser = new JsonParser();//
        JsonObject object = (JsonObject)parser.parse(resultStr);
        System.out.println("ready:");
        JsonArray array ;
        JsonObject jsonObjectL;
        System.out.println("OK:");
        if("1".equals(jsonObject.getString("status"))){
            result.setStatus(1);
            if(StringUtils.isNotBlank(jsonObject.getString("count")) && !"[]".equals(jsonObject.getString("count"))){
                result.setCount(Integer.valueOf(jsonObject.getString("count")));
            }

            if(StringUtils.isNotBlank(jsonObject.getString("info")) && !"[]".equals(jsonObject.getString("info"))){
                result.setInfo(jsonObject.getString("info"));
            }

            if(StringUtils.isNotBlank(jsonObject.getString("infocode")) && !"[]".equals(jsonObject.getString("infocode"))){
                result.setInfocode(jsonObject.getString("infocode"));
            }
            if (StringUtils.isNotBlank(jsonObject.getString("lives")) && !"[]".equals(jsonObject.getString("lives"))){
                System.out.println("this is lives:");
                array = object.get("lives").getAsJsonArray();
                for(int i=0;i<=result.getCount();i++)//lives是个数组，里面存储着count个WeatherLives对象
                {
                    jsonObjectL = array.get(0).getAsJsonObject();
                    temp.setProvince(jsonObjectL.get("province").getAsString());
                    temp.setCity(jsonObjectL.get("city").getAsString());
                    temp.setAdcode(jsonObjectL.get("adcode").getAsString());
                    temp.setWeather(jsonObjectL.get("weather").getAsString());
                    temp.setTemperature(jsonObjectL.get("temperature").getAsString());
                    temp.setWinddirection(jsonObjectL.get("winddirection").getAsString());
                    temp.setWindpower(jsonObjectL.get("windpower").getAsString());
                    temp.setHumidity(jsonObjectL.get("humidity").getAsString());
                    temp.setReporttime(jsonObjectL.get("reporttime").getAsString());
                    System.out.println("this is count: "+i);
                }

                System.out.println("this is end ");
            }
//            if(StringUtils.isNotBlank(jsonObjectL.getString("province")) && !"[]".equals(jsonObjectL.getString("province"))){
//                System.out.println("this is lives_province:");
//                temp.setProvince(jsonObjectL.getString("province"));
//                System.out.println(temp.getProvince());
//            }
//            if(StringUtils.isNotBlank(jsonObjectL.getString("city")) && !"[]".equals(jsonObjectL.getString("city"))){
//                temp.setCity(jsonObjectL.getString("city"));
//            }
//            if(StringUtils.isNotBlank(jsonObjectL.getString("adcode")) && !"[]".equals(jsonObjectL.getString("adcode"))){
//                temp.setAdcode(jsonObjectL.getString("adcode"));
//            }
//            if(StringUtils.isNotBlank(jsonObjectL.getString("weather")) && !"[]".equals(jsonObjectL.getString("weather"))){
//                temp.setWeather(jsonObjectL.getString("weather"));
//            }
//            if(StringUtils.isNotBlank(jsonObjectL.getString("temperature")) && !"[]".equals(jsonObjectL.getString("temperature"))){
//                temp.setTemperature(jsonObjectL.getString("temperature"));
//            }
//            if(StringUtils.isNotBlank(jsonObjectL.getString("winddirection")) && !"[]".equals(jsonObjectL.getString("winddirection"))){
//                temp.setWinddirection(jsonObjectL.getString("winddirection"));
//            }
//            if(StringUtils.isNotBlank(jsonObjectL.getString("windpower")) && !"[]".equals(jsonObjectL.getString("windpower"))){
//                temp.setWindpower(jsonObjectL.getString("windpower"));
//            }
//            if(StringUtils.isNotBlank(jsonObjectL.getString("humidity")) && !"[]".equals(jsonObjectL.getString("humidity"))){
//                temp.setHumidity(jsonObjectL.getString("humidity"));
//            }
//            if(StringUtils.isNotBlank(jsonObjectL.getString("reporttime")) && !"[]".equals(jsonObjectL.getString("reporttime"))){
//                temp.setReporttime(jsonObjectL.getString("reporttime"));
//            }
        }else{
            result.setStatus(0);
        }
        result.setLives(temp);
        return  result;
    }
}


