package top.selfhelp.common.result;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public class CommonResult<T> {

    private String message;

    private String code;

    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
