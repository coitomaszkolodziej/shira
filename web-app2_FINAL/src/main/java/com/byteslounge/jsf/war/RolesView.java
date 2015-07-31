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
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import java.util.*;
import java.sql.SQLException;
@ViewScoped
@ManagedBean
public class RolesView implements Serializable{
	private String userName;
	private int userId;
	private int roleId;
	private int permissionId;
	private String roleName;
	private String permissionName;
	private Map<String, Integer> usersMap;
	private Map<String, Integer> rolesMap;
	private Map<String, Integer> permissionsMap;
	private Map<String, Map<String, Integer> >UsersRolesMap;
	private Map<String, Map<String, Integer> >RolesPermissionsMap;
	private UsersBean usersBean;
	private RolesBean rolesBean;
	private PermissionsBean permissionsBean;
	private LinkedList<Permission> permissionsList;
	private String username;
	
	public RolesView(){
		this.usersBean = new UsersBean();
		this.rolesBean = new RolesBean();
		this.permissionsBean = new PermissionsBean();

	}
	@PostConstruct
	public void init() {
		

		LinkedList<User> users = null;
		usersMap = new HashMap<String, Integer>();
		try {
		users = usersBean.getUsers();
		}catch(SQLException e){
			
		}catch(ClassNotFoundException e){
			
		}
		if( users != null)
		for( User user : users){
			usersMap.put(user.getUserName(), user.getUserId());
		}

	}
	public void onUserChanged(){
		rolesMap = new HashMap<String, Integer>();
		rolesMap.put("Wszystkie", -1);
		LinkedList<Role> ls = null;
		try{
		 ls = rolesBean.getRolesByUserId(this.userId);
		}catch(SQLException e){
					Messages.showWarningMessage(e.toString());

		}catch(ClassNotFoundException e){}
		if(ls != null)
		for(Role role : ls){

			rolesMap.put(role.getRoleName(), role.getRoleId());
		}
		permissionsList = null;
	}
	
	
		public void onRoleChanged(){
		if( roleId == -1 ){
			// show all permissions 
			
			try{
			permissionsList = permissionsBean.getPermissionsByUserId( this.userId);		}catch(SQLException e){
			
		}catch(ClassNotFoundException e){}

		
		}else{
		permissionsList = new LinkedList<Permission>();

		LinkedList<Permission> ls = null;
		try{
		 permissionsList = permissionsBean.getPermissionsByRoleId(this.roleId);
		}catch(SQLException e){
			
		}catch(ClassNotFoundException e){}

		}
	}
	
	
	public String getUserName(){
		return userName;
	}
	public void setUserName(String name){
		this.userName = name;
	}
	public Map<String, Integer> getUsersMap(){
		return this.usersMap;
	}
	public int getUserId(){
		return this.userId;
	}
	public void setUserId(int id){
		this.userId = id;
	}
	public Map<String, Integer> getRolesMap(){
		return this.rolesMap;
	}
	public Map<String, Integer> getPermissionsMap(){
		return this.permissionsMap;
	}
	public void setRoleName(String name){
		this.roleName = name;
	}
	public String getRoleName(){
		return this.roleName;
	}
	public String getPermissionName(){
		return this.permissionName;
	}
	public void setPermissionName(String name){
		this.permissionName = name;
	}
	public int getRoleId(){
		return this.roleId;
	}
	public void setRoleId(int id){
		this.roleId = id;
	}
	public int getPermissionId(){
		return this.permissionId;
	}
	public void setPermissionId( int id){
		 this.permissionId = id;
	}
	public LinkedList<Permission> getPermissionsList(){
		return this.permissionsList;
	}
	public void setUsername(String name){
		this.userName = name;
	}
	public String getUsername(){
		return this.username;
	}
}