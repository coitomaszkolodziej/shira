package com.mycompany.app;

<<<<<<< HEAD
import org.apache.shiro.authz.annotation.RequiresPermissions;
=======
import com.google.inject.Provides;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.aop.AnnotationHandler;
import org.apache.shiro.config.Ini;
import org.apache.shiro.guice.ShiroModule;
import org.apache.shiro.realm.text.IniRealm;

>>>>>>> cb818f4affff8107c58ec441a8f0f73c359f8fa9
/**
 *
 * @author Praktyki
 */
<<<<<<< HEAD
public class Math {
    public Math(){
        
    }
    @RequiresPermissions("dodawanie")
     public int add(int a, int b) {
        return a + b;
    }
    @RequiresPermissions("odejmowanie")
    public int substract(int a, int b) {
        return a + b;
    }
    @RequiresPermissions("mnozenie")
     public int multiply(int a, int b) {
        return a * b;
    }
    @RequiresPermissions("dzielenie")
     public int divide(int a, int b) {
        return a / b;
    }

    
=======
public class Math extends ShiroModule {

    @RequiresRoles("radek3")
    static public int add(int a, int b) {
        return a + b;
    }

    @RequiresRoles("radek4")
    static public int substract(int a, int b) {
        return a + b;
    }

    @RequiresRoles("radek")
    static public int multiply(int a, int b) {
        return a * b;
    }

    @RequiresRoles("radek")
    static public int divide(int a, int b) {
        return a / b;
    }

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
            return Ini.fromResourcePath("classpath:shiro.ini");
        }
>>>>>>> cb818f4affff8107c58ec441a8f0f73c359f8fa9
}
