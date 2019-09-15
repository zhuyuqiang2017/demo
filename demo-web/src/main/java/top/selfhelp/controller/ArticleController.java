package top.selfhelp.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.selfhelp.annotations.CountLimit;
import top.selfhelp.annotations.PerTimeCountLimit;
import top.selfhelp.annotations.RateLimit;
import top.selfhelp.common.controller.AbstractController;
import top.selfhelp.common.param.CommonPageParam;
import top.selfhelp.common.result.CommonPageResult;
import top.selfhelp.common.result.CommonResult;
import top.selfhelp.interfaces.article.ArticleInterface;
import top.selfhelp.interfaces.result.ArticleResult;

import java.util.concurrent.TimeUnit;

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
        logger.info("随机获取一篇博文的信息");
        return articleInterface.getRandomOneArticle();
    }

    @CountLimit(name = "/article/query/page",count = 2,timeout = 1)
    @RequestMapping(value = "/query/page", method = {RequestMethod.GET, RequestMethod.POST})
    public CommonResult<CommonPageResult<ArticleResult>> queryArticleByPage(@RequestBody CommonPageParam pageParam) {
        logger.info("分页查询博文的信息，查询参数：{}", JSONObject.toJSONString(pageParam));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return articleInterface.queryArticleByPage(pageParam);
    }

//    @CountLimit(name = "/article/limit/test",count = 2)
//    @RateLimit(name = "/article/limit/test",permitsPerSecond = 1,warmupMode = false)
//    @PerTimeCountLimit(name = "/article/limit/test",duration = 1,timeUnit = TimeUnit.SECONDS,permits = 2)
    @RequestMapping(value = "/limit/test")
    public CommonResult limit(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CommonResult<String> result = new CommonResult();
        result.setData("请求成功");
        return result;
    }
}
