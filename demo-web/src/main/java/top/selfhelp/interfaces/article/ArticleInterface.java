package top.selfhelp.interfaces.article;

import top.selfhelp.common.result.CommonResult;
import top.selfhelp.interfaces.result.ArticleResult;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public interface ArticleInterface {

    /**
     * 随机获取数据库中的一篇博文
     * @return 博文记录
     */
    CommonResult<ArticleResult> getRandomOneArticle();
}
