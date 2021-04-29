package vo;

import lombok.Data;

@Data
public class UserVo {

    private Long userId;
    private Long userPhone;
    private String userPassword;

    public UserVo(Long userId, String userPassword) {
    }

}

