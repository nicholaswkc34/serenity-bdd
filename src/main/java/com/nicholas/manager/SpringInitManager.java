package com.nicholas.manager;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInitManager {

    private ClassPathXmlApplicationContext ctx;

    // ===============================================================================================
    public SpringInitManager() {
    }
    // ===============================================================================================
    public void init() {// "classpath:applicationContext.xml"
        setCtx(new ClassPathXmlApplicationContext("classpath:applicationContext.xml"));
    }
    // ===============================================================================================
    public ClassPathXmlApplicationContext getCtx() {
        return ctx;
    }
    // ===============================================================================================
    public void setCtx(ClassPathXmlApplicationContext ctx) {
        this.ctx = ctx;
    }


}
