package com.deng.order.common.exception;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alibaba.fastjson.JSONObject;

/** 

* @author 作者 lujunjie: 

* @version 创建时间：Nov 3, 2019 10:32:54 AM 

* 类说明 

*/
@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = BusinessException.class)
    public JSONObject BusinessExceptionHandler(BusinessException exception) throws IOException {
        logger.info(exception.toString());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", exception.getCode());
        jsonObject.put("message", exception.getMessage());
        return jsonObject;
    }

    @ExceptionHandler(value = Exception.class)
    public JSONObject OtherExceptionHandler(Exception e) throws IOException {
        logger.error(e.toString());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "300005");
        jsonObject.put("message", "系统异常");
        return jsonObject;
    }
}
