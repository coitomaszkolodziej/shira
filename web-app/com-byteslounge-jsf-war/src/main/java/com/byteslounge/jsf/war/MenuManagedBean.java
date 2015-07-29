package com.byteslounge.jsf.war;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSeparator;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import java.io.IOException;

 
@ManagedBean
@SessionScoped
public class MenuManagedBean  {
    private MenuModel menu = new DefaultMenuModel();

    public MenuManagedBean (){
		System.err.println ("IndexView c");
        DefaultSubMenu subMenu = new DefaultSubMenu("Menu");
        DefaultMenuItem mathPanelItem = new DefaultMenuItem("Panel matematyczny");
        mathPanelItem.setCommand("#{menuManagedBean.mathPanelAction}");
		subMenu.addElement(mathPanelItem);
        menu.addElement(subMenu);
    }
	
	public void mathPanelAction () throws IOException{
		System.out.println ("rediurectToLogin");
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/protected.xhtml");
	}
	
    public MenuModel getMenu() {
        return menu;
    }
 
    public void setMenu(MenuModel menu) {
        this.menu = menu;
    }
}