package top.selfhelp.data.entity;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public class AuthorArticle {
    private String authorName;

    private String articleCategory;

    private String articleCategoryUrl;

    private Integer authorArticleId;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public String getArticleCategory() {
        return articleCategory;
    }

    public void setArticleCategory(String articleCategory) {
        this.articleCategory = articleCategory == null ? null : articleCategory.trim();
    }

    public String getArticleCategoryUrl() {
        return articleCategoryUrl;
    }

    public void setArticleCategoryUrl(String articleCategoryUrl) {
        this.articleCategoryUrl = articleCategoryUrl == null ? null : articleCategoryUrl.trim();
    }

    public Integer getAuthorArticleId() {
        return authorArticleId;
    }

    public void setAuthorArticleId(Integer authorArticleId) {
        this.authorArticleId = authorArticleId;
    }
}