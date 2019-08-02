package top.selfhelp.data.mapper;

import top.selfhelp.data.entity.Author;

public interface AuthorMapper {
    int deleteByPrimaryKey(String userName);

    int insert(Author record);

    int insertSelective(Author record);

    Author selectByPrimaryKey(String userName);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);
}