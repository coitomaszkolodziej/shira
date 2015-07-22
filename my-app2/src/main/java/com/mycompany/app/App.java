package com.mycompany.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.aop.AnnotationHandler;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.guice.aop.ShiroAopModule;
import org.apache.shiro.session.Session;
import static java.lang.Math.log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    public static void main(String[] args) {
     
        MyShiroModule ms = new MyShiroModule();
        ms.
       Injector injector = Guice.createInjector( ms );
        SecurityManager securityManager = injector.getInstance(SecurityManager.class);
        SecurityUtils.setSecurityManager( securityManager);
/*
        Subject currentUser = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("radek", "radek");
        token.setRememberMe(true);
*/
        System.out.println(Math.add(7, 1));

    }

}
