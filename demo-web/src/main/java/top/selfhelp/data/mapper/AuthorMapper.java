package top.selfhelp.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.selfhelp.data.entity.Author;

/**
 * @author zhuyuqiang2015@outlook.com
 */
@Mapper
public interface AuthorMapper {
    int deleteByPrimaryKey(String userName);

    int insert(Author record);

    int insertSelective(Author record);

    Author selectByPrimaryKey(String userName);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);
}