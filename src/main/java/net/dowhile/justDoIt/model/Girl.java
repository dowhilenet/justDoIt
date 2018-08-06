package net.dowhile.justDoIt.model;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/* 
* 
* gen by beetlsql 2018-08-06
*/
public class Girl  {
	
	private String id ;
	private Integer age ;
	private String cupSize ;
	
	public Girl() {
	}
	
	public String getId(){
		return  id;
	}
	public void setId(String id ){
		this.id = id;
	}
	
	public Integer getAge(){
		return  age;
	}
	public void setAge(Integer age ){
		this.age = age;
	}
	
	public String getCupSize(){
		return  cupSize;
	}
	public void setCupSize(String cupSize ){
		this.cupSize = cupSize;
	}
	

}
