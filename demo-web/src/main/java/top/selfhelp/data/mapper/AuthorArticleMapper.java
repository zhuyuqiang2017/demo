package top.selfhelp.data.mapper;

import top.selfhelp.data.entity.AuthorArticle;

public interface AuthorArticleMapper {
    int insert(AuthorArticle record);

    int insertSelective(AuthorArticle record);
}