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
    @RequiresAuthentication
    static public int add(int a, int b) {
        return a + b;
    }
    @RequiresRoles( "radek" )
    static public int substract(int a, int b) {
        return a + b;
    }
    @RequiresRoles("schwartz") 
    static public int multiply(int a, int b) {
        return a * b;
    }
    @RequiresRoles( "radek" )
    static public int divide(int a, int b) {
        return a / b;
    }
}
