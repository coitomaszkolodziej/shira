/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.aop.AnnotationHandler;


/**
 *
 * @author Praktyki
 */
public class Math {
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
}
