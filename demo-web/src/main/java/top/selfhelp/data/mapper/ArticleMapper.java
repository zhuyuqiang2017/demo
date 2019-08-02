package top.selfhelp.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.selfhelp.data.entity.Article;

/**
 * @author zhuyuqiang2015@outlook.com
 */
@Mapper
public interface ArticleMapper {
    int deleteByPrimaryKey(String articleUrl);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(String articleUrl);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}