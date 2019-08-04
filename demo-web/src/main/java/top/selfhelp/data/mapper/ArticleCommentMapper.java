package top.selfhelp.data.mapper;

import org.springframework.stereotype.Repository;
import top.selfhelp.data.entity.ArticleCommentKey;

/**
 * @author zhuyuqiang2015@outlook.com
 */
@Repository
public interface ArticleCommentMapper {

    int deleteByPrimaryKey(ArticleCommentKey key);

    int insert(ArticleCommentKey record);

    int insertSelective(ArticleCommentKey record);
}