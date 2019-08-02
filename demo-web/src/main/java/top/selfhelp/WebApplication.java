package top.selfhelp;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.selfhelp.common.starter.AbstractApplication;

/**
 * @author zhuyuqiang2015@outlook.com
 */

@SpringBootApplication
public class WebApplication extends AbstractApplication {

    private static Logger logger = LoggerFactory.getLogger(WebApplication.class);

    public static void main(String[] args){
        logger.debug("开始准备启动web应用，启动参数：{}", JSONObject.toJSONString(args));
        SpringApplication application = new SpringApplication(WebApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        logger.info("web应用启动成功");
    }

}
