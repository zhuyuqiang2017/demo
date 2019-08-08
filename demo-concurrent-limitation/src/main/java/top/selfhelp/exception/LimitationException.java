package top.selfhelp.exception;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public class LimitationException extends Exception {

    private String code;

    public LimitationException() {
    }

    public LimitationException(Throwable throwable) {
        super(throwable);
    }

    public LimitationException(String message) {
        super(message);
    }

    public LimitationException(String message, Throwable cause) {
        super(message, cause);
    }

    public LimitationException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
