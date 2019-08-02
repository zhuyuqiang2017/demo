package top.selfhelp.data.entity;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public class AuthorDetail {
    private String authorName;

    private String nickName;

    private String authorDesc;

    private String authorTags;

    private String authorLocation;

    private Integer accessNumber;

    private Integer originalUmber;

    private Integer forwardNumber;

    private Integer ranking;

    private Integer commentNumber;

    private Integer praisedNumber;

    private Integer fansNumber;

    private Integer followNumber;

    private Integer alreadyParserArticle;

    private Byte isProcessed;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getAuthorDesc() {
        return authorDesc;
    }

    public void setAuthorDesc(String authorDesc) {
        this.authorDesc = authorDesc == null ? null : authorDesc.trim();
    }

    public String getAuthorTags() {
        return authorTags;
    }

    public void setAuthorTags(String authorTags) {
        this.authorTags = authorTags == null ? null : authorTags.trim();
    }

    public String getAuthorLocation() {
        return authorLocation;
    }

    public void setAuthorLocation(String authorLocation) {
        this.authorLocation = authorLocation == null ? null : authorLocation.trim();
    }

    public Integer getAccessNumber() {
        return accessNumber;
    }

    public void setAccessNumber(Integer accessNumber) {
        this.accessNumber = accessNumber;
    }

    public Integer getOriginalUmber() {
        return originalUmber;
    }

    public void setOriginalUmber(Integer originalUmber) {
        this.originalUmber = originalUmber;
    }

    public Integer getForwardNumber() {
        return forwardNumber;
    }

    public void setForwardNumber(Integer forwardNumber) {
        this.forwardNumber = forwardNumber;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    public Integer getPraisedNumber() {
        return praisedNumber;
    }

    public void setPraisedNumber(Integer praisedNumber) {
        this.praisedNumber = praisedNumber;
    }

    public Integer getFansNumber() {
        return fansNumber;
    }

    public void setFansNumber(Integer fansNumber) {
        this.fansNumber = fansNumber;
    }

    public Integer getFollowNumber() {
        return followNumber;
    }

    public void setFollowNumber(Integer followNumber) {
        this.followNumber = followNumber;
    }

    public Integer getAlreadyParserArticle() {
        return alreadyParserArticle;
    }

    public void setAlreadyParserArticle(Integer alreadyParserArticle) {
        this.alreadyParserArticle = alreadyParserArticle;
    }

    public Byte getIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(Byte isProcessed) {
        this.isProcessed = isProcessed;
    }
}