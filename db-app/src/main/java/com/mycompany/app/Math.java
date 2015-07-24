/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app;

import java.nio.file.AccessDeniedException;

/**
 *
 * @author Praktyki
 */
public class Math {
    public int add(int a, int b, boolean isPermitted) throws AccessDeniedException{
        if (b == 1 && !isPermitted){
            throw new AccessDeniedException("incrementation: Access Denied");
        }
        if (!isPermitted){
            throw new AccessDeniedException("add: Access Denied");
        }
        return a + b;
    }
    public int substract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b, boolean isPermitted) throws AccessDeniedException{
        if (!isPermitted){
            throw new AccessDeniedException("multiply: Access Denied");
        }
        return a * b;
    }
    public int divide(int a, int b) {
        return a / b;
    }
}
