package com.mycompany.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.guice.aop.ShiroAopModule;

public class App {

    public static void main(String[] args) {
        Auth auth = Auth.getInstance();
        try {
            auth.login("radek", "radek");
        } catch (UnknownAccountException uae) {
        } catch (IncorrectCredentialsException ice) {
        } catch (LockedAccountException lae) {
        } catch (AuthenticationException ae) {
        }

        Injector injector = Guice.createInjector(new ShiroAopModule());
        Math math = injector.getInstance(Math.class);

        System.out.println(math.add(1, 2));
       // System.out.println(math.multiply(1, 2));

    }

}
