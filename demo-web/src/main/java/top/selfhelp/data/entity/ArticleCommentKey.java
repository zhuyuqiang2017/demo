package top.selfhelp.data.entity;

public class ArticleCommentKey {
    private String authorName;

    private Integer authorArticleId;

    private String articleCommentator;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public Integer getAuthorArticleId() {
        return authorArticleId;
    }

    public void setAuthorArticleId(Integer authorArticleId) {
        this.authorArticleId = authorArticleId;
    }

    public String getArticleCommentator() {
        return articleCommentator;
    }

    public void setArticleCommentator(String articleCommentator) {
        this.articleCommentator = articleCommentator == null ? null : articleCommentator.trim();
    }
}