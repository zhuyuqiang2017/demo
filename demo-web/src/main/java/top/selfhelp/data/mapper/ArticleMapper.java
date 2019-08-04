package top.selfhelp.data.mapper;

import org.springframework.stereotype.Repository;
import top.selfhelp.data.entity.Article;

/**
 * @author zhuyuqiang2015@outlook.com
 */
@Repository
public interface ArticleMapper {
    int deleteByPrimaryKey(String articleUrl);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(String articleUrl);

    Article selectRandomOne();

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}