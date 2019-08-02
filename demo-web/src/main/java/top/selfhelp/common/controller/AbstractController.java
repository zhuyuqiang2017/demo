package top.selfhelp.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @author zhuyuqiang2015@outlook.com
 */
public class AbstractController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageSource messageSource;

    protected String getValidMessage(String messageCode){
        String message = "";
        try {
            message = messageSource.getMessage(messageCode,null, LocaleContextHolder.getLocale());
        }catch (Exception e){
            logger.error("当前code的描述信息不存在,messageCode:{}",messageCode);
        }
        return message;
    }
}
