package pojo;

import lombok.Data;

@Data
public class Weather {

    int status;
    int count;
    String info;
    String infocode;
    WeatherLives lives;
}
