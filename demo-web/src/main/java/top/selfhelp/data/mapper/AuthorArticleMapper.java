package top.selfhelp.data.mapper;

import org.springframework.stereotype.Repository;
import top.selfhelp.data.entity.AuthorArticle;

/**
 * @author zhuyuqiang2015@outlook.com
 */
@Repository
public interface AuthorArticleMapper {
    int insert(AuthorArticle record);

    int insertSelective(AuthorArticle record);
}