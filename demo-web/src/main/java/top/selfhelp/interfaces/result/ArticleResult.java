package top.selfhelp.interfaces.result;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public class ArticleResult {

    private String articleUrl;

    private String articleId;

    private String articleAuthor;

    private String articleIsRepeat;

    private String articleTitle;

    private String articleTime;

    private Integer articleReadNumber;

    private Integer articleLikeNumber;

    private Integer articleCommentNumber;

    private String articleTags;

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl == null ? null : articleUrl.trim();
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor == null ? null : articleAuthor.trim();
    }

    public String getArticleIsRepeat() {
        return articleIsRepeat;
    }

    public void setArticleIsRepeat(String articleIsRepeat) {
        this.articleIsRepeat = articleIsRepeat == null ? null : articleIsRepeat.trim();
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(String articleTime) {
        this.articleTime = articleTime == null ? null : articleTime.trim();
    }

    public Integer getArticleReadNumber() {
        return articleReadNumber;
    }

    public void setArticleReadNumber(Integer articleReadNumber) {
        this.articleReadNumber = articleReadNumber;
    }

    public Integer getArticleLikeNumber() {
        return articleLikeNumber;
    }

    public void setArticleLikeNumber(Integer articleLikeNumber) {
        this.articleLikeNumber = articleLikeNumber;
    }

    public Integer getArticleCommentNumber() {
        return articleCommentNumber;
    }

    public void setArticleCommentNumber(Integer articleCommentNumber) {
        this.articleCommentNumber = articleCommentNumber;
    }

    public String getArticleTags() {
        return articleTags;
    }

    public void setArticleTags(String articleTags) {
        this.articleTags = articleTags == null ? null : articleTags.trim();
    }
}
