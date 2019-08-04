package top.selfhelp.interfaces.article;

import top.selfhelp.common.result.CommonResult;
import top.selfhelp.interfaces.result.ArticleResult;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public interface ArticleInterface {

    CommonResult<ArticleResult> getRandomOneArticle();
}
