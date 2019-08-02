package top.selfhelp.data.mapper;

import top.selfhelp.data.entity.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(String articleUrl);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(String articleUrl);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}