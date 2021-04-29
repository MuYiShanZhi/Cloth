package pojo;

import lombok.Data;

@Data
public class SiteMessage {
    int status;
    String info;
    int infocode;
    String province;
    String city;
    String adcode;
    String rectangle;
}
