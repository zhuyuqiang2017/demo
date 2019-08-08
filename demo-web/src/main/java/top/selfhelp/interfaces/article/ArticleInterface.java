package top.selfhelp.interfaces.article;

import top.selfhelp.common.param.CommonPageParam;
import top.selfhelp.common.result.CommonPageResult;
import top.selfhelp.common.result.CommonResult;
import top.selfhelp.interfaces.result.ArticleResult;

import java.util.List;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public interface ArticleInterface {

    /**
     * 随机获取数据库中的一篇博文
     * @return 博文记录
     */
    CommonResult<ArticleResult> getRandomOneArticle();

    /**
     * 分页获取博文信息
     * @param pageParam 分页参数
     * @return 返回分页查询结果集
     */
    CommonResult<CommonPageResult<ArticleResult>> queryArticleByPage(CommonPageParam pageParam);
}
