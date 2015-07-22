/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app;

import com.google.inject.Provides;
import org.apache.shiro.config.Ini;
import org.apache.shiro.guice.ShiroModule;
import org.apache.shiro.realm.text.IniRealm;

/**
 *
 * @author radek
 */
public class MyShiroModule extends ShiroModule {

    @Override
    protected void configureShiro() {
        try {
            bindRealm().toConstructor(IniRealm.class.getConstructor(Ini.class));
        } catch (NoSuchMethodException e) {
            addError(e);
        }
    }

    @Provides
    Ini loadShiroIni() {
        return Ini.fromResourcePath("/home/radek/Pulpit/shira/my-app/shiro.ini");
    }

}
