package top.selfhelp.data.mapper;

import top.selfhelp.data.entity.ArticleCommentKey;

public interface ArticleCommentMapper {
    int deleteByPrimaryKey(ArticleCommentKey key);

    int insert(ArticleCommentKey record);

    int insertSelective(ArticleCommentKey record);
}