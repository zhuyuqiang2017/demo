package top.selfhelp.data.entity;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public class Author {
    private String userName;

    private Integer isProcessed;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(Integer isProcessed) {
        this.isProcessed = isProcessed;
    }
}