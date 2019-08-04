package top.selfhelp.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;

public abstract class AbstractService {

    @Autowired
    private MessageSource messageSource;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    protected String getMessageByCode(@NotNull String code){
        String message = "";
        try {
            message = messageSource.getMessage(code,null, LocaleContextHolder.getLocale());
        }catch (Exception e){
            logger.error("当前code的描述信息不存在,messageCode:{}",code);
        }
        return message;
    }
}
