package top.selfhelp.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.selfhelp.data.entity.AuthorArticle;

/**
 * @author zhuyuqiang2015@outlook.com
 */
@Mapper
public interface AuthorArticleMapper {
    int insert(AuthorArticle record);

    int insertSelective(AuthorArticle record);
}