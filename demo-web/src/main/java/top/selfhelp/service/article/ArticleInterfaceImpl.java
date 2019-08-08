package top.selfhelp.service.article;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pagehelper.PageHelper;
import pagehelper.PageInfo;
import top.selfhelp.common.param.CommonPageParam;
import top.selfhelp.common.result.CommonPageResult;
import top.selfhelp.common.result.CommonResult;
import top.selfhelp.common.service.AbstractService;
import top.selfhelp.data.entity.Article;
import top.selfhelp.data.mapper.ArticleMapper;
import top.selfhelp.interfaces.article.ArticleInterface;
import top.selfhelp.interfaces.result.ArticleResult;

import java.util.List;

import static top.selfhelp.interfaces.constant.MessageCode.QUERY_ARTICLE_ERROR;
import static top.selfhelp.interfaces.constant.MessageCode.SUCCESS_CODE;

/**
 * @author zhuyuqiang2015@outlook.com
 */
@Service
public class ArticleInterfaceImpl extends AbstractService implements ArticleInterface {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public CommonResult<ArticleResult> getRandomOneArticle() {
        CommonResult<ArticleResult> result = new CommonResult<>();
        try {
            Article article = articleMapper.selectRandomOne();
            ArticleResult articleResult = new ArticleResult();
            BeanUtils.copyProperties(article,articleResult);
            result.setCode(SUCCESS_CODE);
            result.setMessage(getMessageByCode(SUCCESS_CODE));
            result.setData(articleResult);
        } catch (BeansException e) {
            logger.error("查询博文异常",e);
            result.setCode(QUERY_ARTICLE_ERROR);
            result.setMessage(getMessageByCode(QUERY_ARTICLE_ERROR));
        }
        return result;
    }

    @Override
    public CommonResult<CommonPageResult<ArticleResult>> queryArticleByPage(CommonPageParam pageParam) {
        CommonResult<CommonPageResult<ArticleResult>> result = new CommonResult<>();
        try {
            PageHelper.startPage(pageParam.getPageNumber(),pageParam.getPageSize());
            List<Article> articleList = articleMapper.pageArticle();
            PageInfo<Article> pageInfo = new PageInfo<>(articleList);
            List<ArticleResult> articleResults = JSONObject.parseArray(JSONObject.toJSONString(articleList),ArticleResult.class);
            logger.debug("当前页面显示记录数：{}",pageInfo.getList().size());
            logger.debug("分页信息：{}", JSONObject.toJSONString(pageInfo));
            PageHelper.clearPage();
            CommonPageResult<ArticleResult> pageResult = new CommonPageResult<ArticleResult>(articleResults,pageInfo);
            result.setData(pageResult);
            result.setCode(SUCCESS_CODE);
            result.setMessage(getMessageByCode(SUCCESS_CODE));
        } catch (Exception e) {
            logger.error("分页查询博文异常",e);
            result.setCode(QUERY_ARTICLE_ERROR);
            result.setMessage(getMessageByCode(QUERY_ARTICLE_ERROR));
        }
        return result;
    }
}
