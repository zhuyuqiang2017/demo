package top.selfhelp.data.mapper;

import org.springframework.stereotype.Repository;
import top.selfhelp.data.entity.Author;

/**
 * @author zhuyuqiang2015@outlook.com
 */
@Repository
public interface AuthorMapper {
    int deleteByPrimaryKey(String userName);

    int insert(Author record);

    int insertSelective(Author record);

    Author selectByPrimaryKey(String userName);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);
}