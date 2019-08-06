package top.selfhelp.service.article;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.selfhelp.common.result.CommonResult;
import top.selfhelp.common.service.AbstractService;
import top.selfhelp.data.entity.Article;
import top.selfhelp.data.mapper.ArticleMapper;
import top.selfhelp.interfaces.article.ArticleInterface;
import top.selfhelp.interfaces.result.ArticleResult;

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
        Article article = articleMapper.selectRandomOne();
        ArticleResult articleResult = new ArticleResult();
        BeanUtils.copyProperties(article,articleResult);
        CommonResult<ArticleResult> result = new CommonResult<>();
        result.setCode(SUCCESS_CODE);
        result.setMessage(getMessageByCode(SUCCESS_CODE));
        result.setData(articleResult);
        return result;
    }
}