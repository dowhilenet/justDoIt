package net.dowhile.justDoIt.dao;

import net.dowhile.justDoIt.model.User;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

/*
* 
* gen by beetlsql mapper 2018-08-07
*/
public interface UserDao extends BaseMapper<User> {
	User findUserByName(@Param("name") String name);
}
