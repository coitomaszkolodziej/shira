package com.mycompany.app;


import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.config.IniSecurityManagerFactory;


public class App 
{
    
    public static void main( String[] args )
    { 
        Auth auth = Auth.getInstance();            
        
        auth.login("radek", "radek");    
        
        try{
                 
        System.out.println(Math.multiply(7,1));
        System.out.println(Math.add(7,1));
        System.out.println(Math.divide(7,1));
        }catch(AccessDenied ac){
            System.out.println(ac);
        }
        
   
    }
}
