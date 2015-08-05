package com.byteslounge.jsf.war;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
public class Messages{
	public Messages(){}
	
	public static void showInfoMessage(String m){
	FacesContext.getCurrentInstance().addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, m, ""));
	}
	public static void showWarningMessage(String m){
	FacesContext.getCurrentInstance().addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_WARN, m, ""));
	}
	
}