/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;

/**
 *
 * @author Praktyki
 */
public class Math {

    static public int add(int a, int b) throws AccessDenied {
        if ((Auth.getInstance().myCheckPermission("dodawanie_2_3") && a == 2 && b == 2)
                || Auth.getInstance().myCheckPermission("dodawanie")) {
            return a + b;
        } else {
            throw new AccessDenied();
        }
    }

    static public int substract(int a, int b) throws AccessDenied {
        if (Auth.getInstance().myCheckPermission("odejmowanie")) {
            return a - b;
        } else {
            throw new AccessDenied();
        }
    }

    static public int multiply(int a, int b) throws AccessDenied {
        if (Auth.getInstance().myCheckPermission("mnozenie")) {
            return a * b;
        } else {
            throw new AccessDenied();
        }
    }
    static public int divide(int a, int b) throws AccessDenied{
          if (Auth.getInstance().myCheckPermission("dzielenie")) {
            return a * b;
        } else {
            throw new AccessDenied();
        }
    }
}
