package top.selfhelp.data.mapper;

import top.selfhelp.data.entity.AuthorDetail;

public interface AuthorDetailMapper {
    int deleteByPrimaryKey(String authorName);

    int insert(AuthorDetail record);

    int insertSelective(AuthorDetail record);

    AuthorDetail selectByPrimaryKey(String authorName);

    int updateByPrimaryKeySelective(AuthorDetail record);

    int updateByPrimaryKey(AuthorDetail record);
}