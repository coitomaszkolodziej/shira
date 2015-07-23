package com.mycompany.app;


import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.guice.aop.ShiroAopModule;
import org.apache.shiro.mgt.SecurityManager;


public class App {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new ShiroAopModule(), new MyShiroModule());

        SecurityManager securityManager = injector.getInstance(SecurityManager.class);
        SecurityUtils.setSecurityManager(securityManager);
        
        /*
         Subject currentUser = SecurityUtils.getSubject();

         UsernamePasswordToken token = new UsernamePasswordToken("radek", "radek");
         token.setRememberMe(true);
         */
        System.out.println(Math.add(7, 1));

    }

}
