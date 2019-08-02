package top.selfhelp.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.selfhelp.data.entity.ArticleCommentKey;

/**
 * @author zhuyuqiang2015@outlook.com
 */
@Mapper
public interface ArticleCommentMapper {

    int deleteByPrimaryKey(ArticleCommentKey key);

    int insert(ArticleCommentKey record);

    int insertSelective(ArticleCommentKey record);
}