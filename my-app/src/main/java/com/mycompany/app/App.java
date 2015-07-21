package com.mycompany.app;


import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.aop.AnnotationHandler;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class App 
{
    public static void main( String[] args )
    {
        Auth auth = Auth.getInstance();
       
        auth.login("radek", "radek");
        
        System.out.println(Math.add(7,1));
        


    }
}
