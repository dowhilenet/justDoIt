package net.dowhile.justDoIt.dao;

import net.dowhile.justDoIt.model.Role;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

/*
* 
* gen by beetlsql mapper 2018-08-07
*/
public interface RoleDao extends BaseMapper<Role> {
	List<Role> findByUserID(@Param("id") Long id);
}
