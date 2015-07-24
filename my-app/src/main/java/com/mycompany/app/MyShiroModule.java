/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app;

import com.google.inject.Provides;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.config.Ini;
import org.apache.shiro.guice.ShiroModule;
import org.apache.shiro.guice.aop.ShiroAopModule;
import org.apache.shiro.realm.text.IniRealm;

/**
 *
 * @author radek
 */
public class MyShiroModule extends ShiroAopModule {


    @RequiresRoles( "radek3" )
    static public int add(int a, int b) {
        return a + b;
    }
    @RequiresRoles( "radek4" )
    static public int substract(int a, int b) {
        return a + b;
    }
    @RequiresRoles( "radek" )
    static public int multiply(int a, int b) {
        return a * b;
    }
    @RequiresRoles( "radek" )
    static public int divide(int a, int b) {
        return a / b;
    }
    @Provides
    Ini loadShiroIni() {
        return Ini.fromResourcePath("/home/radek/Pulpit/shira/my-app/shiro.ini");
    }
}
