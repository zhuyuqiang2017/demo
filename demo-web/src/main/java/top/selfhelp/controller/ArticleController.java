package top.selfhelp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.selfhelp.common.controller.AbstractController;
import top.selfhelp.common.result.CommonResult;
import top.selfhelp.interfaces.article.ArticleInterface;
import top.selfhelp.interfaces.result.ArticleResult;

/**
 * @author zhuyuqiang2015@outlook.com
 */
@RestController
@RequestMapping(value = "/article")
public class ArticleController extends AbstractController {

    @Autowired
    private ArticleInterface articleInterface;

    @RequestMapping(value = "/random/one", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult<ArticleResult> getRandomOneArticle() {
        return articleInterface.getRandomOneArticle();
    }
}
