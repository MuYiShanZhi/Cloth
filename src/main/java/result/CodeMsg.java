package result;

public class CodeMsg {
    private Integer code;
    private String msg;

    public static final CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static final CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务器异常");
    public static final CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");

    //登录模块
    public static final CodeMsg MESSAGECODE_ERROR = new CodeMsg(500200, "验证码错误");

    public static final CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static final CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
    public static final CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
    public static final CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static final CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
    public static final CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");
    public static final CodeMsg USER_NOT_EXIST = new CodeMsg(500216, "用户不存在");

    //注册
    public static final CodeMsg USER_EXISTED = new CodeMsg(500217, "用户已存在");
    public static final CodeMsg REGISTER_ERROR = new CodeMsg(500218, "注册失败");


    //推荐 5004xx
    public static final CodeMsg FAILED_TO_GET_LOCATION = new CodeMsg(500400, "获取位置失败");
    public static final CodeMsg FAILED_TO_GET_WEATHER = new CodeMsg(500401, "获取位置失败");


    //秒杀模块 5005xx
    public static final CodeMsg MIAO_SHA_OVER = new CodeMsg(500500, "商品已经秒杀完毕");
    public static final CodeMsg REPEATE_MIAOSHA = new CodeMsg(500501, "不能重复秒杀");

    public CodeMsg fillArgs(Object... args){
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    private CodeMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
