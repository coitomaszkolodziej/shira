package com.mycompany.app;

import static java.lang.Math.log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.text.PropertiesRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 *
 * @author Praktyki
 */
public class Auth {

    private Auth() {
        factory = new IniSecurityManagerFactory("shiro.ini");
        securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);
        log = LoggerFactory.getLogger(Auth.class);

    }

    static public Auth getInstance() {

        if (instance == null) {
            instance = new Auth();
        }
        return instance;
    }
    static private Auth instance = null;
    private Factory<SecurityManager> factory;
    //private SecurityManager securityManager;
    private static transient Logger log;
    private SecurityManager securityManager;
    private Session session;        
    public void logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
    }
    public boolean login(String login, String pass) {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(login, pass);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
                return false;
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
                return false;
            } catch (LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked.  "
                        + "Please contact your administrator to unlock it.");
                return false;
            } catch (AuthenticationException ae) {
                log.info("AuthenticationException was thrown");
                return false;
            }
            log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");
            
        }
        return true;
    }
    
    boolean myCheckRole(String roleIdentifier)  throws AuthorizationException {
        try{
            Subject currentUser = SecurityUtils.getSubject();
            
        }catch (AuthorizationException ae){
            Subject currentUser = SecurityUtils.getSubject();
            log.info ("User [" + currentUser.getPrincipal() + "] has no role " + roleIdentifier);
            return false;
        }
        return true;
    }
    
}
