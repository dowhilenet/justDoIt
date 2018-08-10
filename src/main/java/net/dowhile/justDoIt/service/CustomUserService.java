package net.dowhile.justDoIt.service;

import net.dowhile.justDoIt.dao.RoleDao;
import net.dowhile.justDoIt.dao.UserDao;
import net.dowhile.justDoIt.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserService implements UserDetailsService {

	private final static Logger logger = LoggerFactory.getLogger(CustomUserService.class);

	@Autowired
	UserDao userDao;
	@Autowired
	RoleDao roleDao;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		logger.info("用户的用户名{}", name);
		// 根据用户名，查找到对应的密码，与权限
		net.dowhile.justDoIt.model.User sysUser = userDao.findUserByName(name);
		if (sysUser == null) {
			// 这里我们不抛出UsernameNotFoundException因为Security会把我们抛出的该异常捕捉并换掉；
			// 这里要明确Security抛出的异常无法被ControllerAdvice捕捉到，无法进行统一异常处理；
			// 而我们只需要打印正确的异常消息即可，Security自动把异常添加到HttpServletRequest或HttpSession中
			logger.warn("用户的用户名{}找不到", name);
			throw new UsernameNotFoundException(name);
		}
		List<Role> roles = roleDao.findByUserID(sysUser.getId());
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		// 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
		User user = new User(name, sysUser.getPassword(), authorities);

//        //2.从业务层获取用户权限并转为Authorities
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (Role role : user.getRoleList()) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));//设置权限
//            authorities.add(new SimpleGrantedAuthority(role_ + role.getName()));//设置角色
//        }
		return user;
	}
}
