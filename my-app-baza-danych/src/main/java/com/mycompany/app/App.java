package com.mycompany.app;

import java.nio.file.AccessDeniedException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;

public class App {
    /*
     przyklad jest taki:
     radek jest super_userem, wiec moze wszystko (dodawac, mnozyc, inkrementowac)
     marek jest inkementatorem (moze tylko inkrementowac)
     lukasz jest inkremenatorem i mnoznikiem (moze dodawac i inkrementowac)
    
     */

    public static void main(String[] args) {
        Math math = new Math();
        Auth auth = Auth.getInstance();

        try {
            auth.login("marek", "marek");
            auth.hasRole("inkrementator");
            auth.hasRole("super_user");
            math.add(7, 1, auth.isPermitted("inkrementacja"));
            math.add(7, 2, auth.isPermitted("dodawanie"));
            math.multiply(7, 8, auth.isPermitted("mnozenie"));
            auth.logout();

        } catch (UnknownAccountException uae) {
           // log.info("There is no user with username of " + token.getPrincipal());
        } catch (IncorrectCredentialsException ice) {
            // log.info("Password for account " + token.getPrincipal() + " was incorrect!");
        } catch (LockedAccountException lae) {
            //log.info("The account for username " + token.getPrincipal() + " is locked.  "
            // + "Please contact your administrator to unlock it.");
        } catch (AuthenticationException ae) {
            // log.info("AuthenticationException was thrown");
        } catch (AccessDeniedException ade){
            System.err.println (ade);
        }

        try {
            auth.login("lukasz", "lukasz");
            math.add(7, 1, auth.isPermitted("inkrementacja"));
            math.add(7, 2, auth.isPermitted("dodawanie"));
            math.multiply(7, 8, auth.isPermitted("mnozenie"));
            auth.logout();

        } catch (UnknownAccountException uae) {
            //log.info("There is no user with username of " + token.getPrincipal());
        } catch (IncorrectCredentialsException ice) {
            // log.info("Password for account " + token.getPrincipal() + " was incorrect!");
        } catch (LockedAccountException lae) {
            //log.info("The account for username " + token.getPrincipal() + " is locked.  "
            // + "Please contact your administrator to unlock it.");
        } catch (AuthenticationException ae) {
            // log.info("AuthenticationException was thrown");
        } catch (AccessDeniedException ade){
            System.err.println (ade);
        }
    }
}
