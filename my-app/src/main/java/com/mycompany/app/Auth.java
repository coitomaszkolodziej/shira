package com.mycompany.app;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
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
        factory = new IniSecurityManagerFactory("C:\\Users\\Praktyki\\Desktop\\my-app\\shiro.ini");
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
    private SecurityManager securityManager;
    private static transient Logger log;

    public void logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();

    }

    public void login(String login, String pass) throws UnknownAccountException, IncorrectCredentialsException,
            LockedAccountException, AuthenticationException {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(login, pass);
            token.setRememberMe(true);
            currentUser.login(token);
            log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");
        }

    }

}
