package com.byteslounge.jsf.war;
 
import java.util.logging.Logger;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

 
@Model
@ManagedBean
public class LoginController {
 
    String username;
    String password;
    boolean rememberMe = false;
 
    private static final Logger log = Logger.getLogger(LoginController.class.getName());
 
	private void showInfoMessage(String m){
	FacesContext.getCurrentInstance().addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, m, username));
	}
	private void showWarningMessage(String m){
			FacesContext.getCurrentInstance().addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_WARN, m, username));
	}
    public String authenticate() {
 
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
         token.setRememberMe(rememberMe);
         Subject currentUser = SecurityUtils.getSubject();
 
        log.info("Submitting login with username of " + username + " and password of " + password);
 
        try {
            currentUser.login(token);
        } catch (AuthenticationException e) {
            log.warning(e.getMessage());
            showWarningMessage("Bledne haslo lub nazwa uzytkownika");
            return "";
        }
        return "protected?faces-redirect=true";
     }
 
    public String logout() {
 
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.logout();
        } catch (Exception e) {
            log.warning(e.toString());
        }
        return "index";
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public boolean getRememberMe() {
        return rememberMe;
    }
 
    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
 
}