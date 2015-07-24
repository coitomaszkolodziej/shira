package com.mycompany.app;

import org.apache.shiro.authz.annotation.RequiresPermissions;
/**
 *
 * @author Praktyki
 */
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

    
}
