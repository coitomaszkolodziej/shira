package com.mycompany.app;

import java.nio.file.AccessDeniedException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    
    /*
        przyklad jest taki:
        radek jest super_userem, wiec moze wszystko (dodawac, mnozyc, inkrementowac)
        marek jest inkementatorem (moze tylko inkrementowac)
        lukasz jest inkremenatorem i mnoznikiem (moze mnozyc i inkrementowac)
    
     */

    public static void main(String[] args) {
        Math math = new Math();
        Auth auth = Auth.getInstance();
        Logger log = LoggerFactory.getLogger(Auth.class);

        try {
            auth.login("marek", "marek");
            auth.hasRole("inkrementator");
            auth.hasRole("super_user");
            math.add(7, 1, auth.isPermitted("inkrementacja"));
            math.add(7, 2, auth.isPermitted("dodawanie"));
            math.multiply(7, 8, auth.isPermitted("mnozenie"));      

        }catch (AccessDeniedException ade){
            log.info (ade.toString());
        }catch (UnknownAccountException uae) {
            log.info("There is no user with this username");
        } catch (IncorrectCredentialsException ice) {
             log.info("Password for account is incorrect!");
        } catch (LockedAccountException lae) {
            log.info("The account is locked");
        } catch (AuthenticationException ae) {
            log.info("AuthenticationException was thrown");
        } finally {
            auth.logout();
        }

        try {
            auth.login("lukasz", "lukasz");
            math.multiply(7, 8, auth.isPermitted("mnozenie"));
            math.add(7, 1, auth.isPermitted("inkrementacja"));
            math.add(7, 2, auth.isPermitted("dodawanie"));

        }catch (AccessDeniedException ade){
            log.info (ade.toString());
        }catch (UnknownAccountException uae) {
            log.info("There is no user with this username");
        } catch (IncorrectCredentialsException ice) {
             log.info("Password for account is incorrect!");
        } catch (LockedAccountException lae) {
            log.info("The account is locked");
        } catch (AuthenticationException ae) {
            log.info("AuthenticationException was thrown");
        } finally {
            auth.logout();
        }
    }
}
