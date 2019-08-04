package top.selfhelp.data.mapper;

import org.springframework.stereotype.Repository;
import top.selfhelp.data.entity.AuthorDetail;

/**
 * @author zhuyuqiang2015@outlook.com
 */
@Repository
public interface AuthorDetailMapper {
    int deleteByPrimaryKey(String authorName);

    int insert(AuthorDetail record);

    int insertSelective(AuthorDetail record);

    AuthorDetail selectByPrimaryKey(String authorName);

    int updateByPrimaryKeySelective(AuthorDetail record);

    int updateByPrimaryKey(AuthorDetail record);
}