package net.dowhile.justDoIt.model;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/* 
* 
* gen by beetlsql 2018-08-07
*/
public class UserRole  {
	
	private Long roleId ;
	private Long userId ;
	
	public UserRole() {
	}
	
	public Long getRoleId(){
		return  roleId;
	}
	public void setRoleId(Long roleId ){
		this.roleId = roleId;
	}
	
	public Long getUserId(){
		return  userId;
	}
	public void setUserId(Long userId ){
		this.userId = userId;
	}
	

}
