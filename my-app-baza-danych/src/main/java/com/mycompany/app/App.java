package com.mycompany.app;


import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App 
{
    
    public static void main( String[] args )
    { 
       // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 

        Auth auth = Auth.getInstance();            
        
        auth.login("radek", "radek");    
        System.out.println(Math.multiply(7,1));
        System.out.println(Math.add(7,1));
    }
}
