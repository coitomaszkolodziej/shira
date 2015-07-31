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
public class MathPanelView{
	private int aplus, bplus, aminus, bminus, amnoz, bmnoz, wplus, wminus, wmnoz;
	
	
	public void handleAddition( ){
		
		if( !SecurityUtils.getSubject().isPermitted("dodawanie")){
			Messages.showWarningMessage("Nie masz uprawnien!");

			return;
		}
		wplus = aplus + bplus;
	}
		public void handleSubstraction( ){
		
		if( !SecurityUtils.getSubject().isPermitted("odejmowanie")){
			Messages.showWarningMessage("Nie masz uprawnien!");
			return;
		}
		wminus = aminus - bminus;
	}
		public void handleMultiplication(  ){
		
		if( !SecurityUtils.getSubject().isPermitted("mnozenie")){
		Messages.showWarningMessage("Nie masz uprawnien!");
		return;
		}
		wmnoz = amnoz *  bmnoz;
	}

	
		public int getAplus(){
		return aplus;
	}	public int getBplus(){
		return bplus;
	}	public int getWplus(){
		return wplus;
	}

	public int getAminus(){
		return aminus;
	}	public int getBminus(){
		return bminus;
	}	public int getWminus(){
		return wminus;
	}
	
	public int getAmnoz(){
		return amnoz;
	}	public int getBmnoz(){
		return bmnoz;
	}	public int getWmnoz(){
		return wmnoz;
	}
	 /* settery */
	 public void setAplus(int a){
		 this.aplus = a;
	 }public void setBplus(int b){
		 this.bplus = b;
	 }public void setWplus(int w){
		 this.wplus = w;
	 }
	  public void setAminus(int a){
		 this.aminus = a;
	 }public void setBminus(int b){
		 this.bminus = b;
	 }public void setWminus(int w){
		 this.wminus = w;
	 }
	  public void setAmnoz(int a){
		 this.amnoz = a;
	 }public void setBmnoz(int b){
		 this.bmnoz = b;
	 }public void setWmnoz(int w){
		 this.wmnoz = w;
	 }
	 
	
	
}