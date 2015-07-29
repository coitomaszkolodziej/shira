package com.byteslounge.jsf.war;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import java.io.IOException;
 
@ManagedBean
public class IndexView  {
    private boolean isLogged;
	private String userName;
	public IndexView (){
		System.out.println("isLogged");
		Subject currentUser = SecurityUtils.getSubject();
        isLogged = currentUser.isAuthenticated();
		if (isLogged){
			userName = currentUser.getPrincipal().toString();
		}
		else{
			userName = "";
		}
	}
	public String getUserName(){
		return userName;
	}
	
	public boolean getIsLogged(){
		return isLogged;
	}
	
	public void redirectToLogin() throws IOException{
		System.out.println ("rediurectToLogin");
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
	}
	
}