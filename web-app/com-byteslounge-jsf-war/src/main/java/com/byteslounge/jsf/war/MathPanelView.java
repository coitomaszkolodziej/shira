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
import javax.faces.event.ActionEvent;



@Model
@ManagedBean
public class MathPanelView{
	private int aplus;
	private int bplus;
	private int result; 
	private void showWarningMessage(String m){
			FacesContext.getCurrentInstance().addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_WARN, m, ""));
	}
	
	public void handleAddition( ActionEvent event ){
				showWarningMessage("Udalo sie");

		if( !SecurityUtils.getSubject().isPermitted("dodawanie")){
			showWarningMessage("Nie masz uprawnien!");
			return;
		}
		showWarningMessage("Udalo sie");
		result = aplus + bplus;
	
	}
	
	
	//public void setAplus( int a){
	//	this.aplus = a;
	//}
//	public void setAplusI*
	
}