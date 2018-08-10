package net.dowhile.justDoIt.config;

import net.dowhile.justDoIt.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUserService customUserService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http
				// 开始请求权限配置
				.authorizeRequests()
				// 我们指定任何用户都可以访问多个URL的模式。
				// 任何用户都可以访问以"/resources/","/signup", 或者 "/about"开头的URL。
				.antMatchers("/resources/**", "/signup", "/about").permitAll()
				// 请求匹配 /admin/** 只拥有 ROLE_ADMIN 角色的用户可以访问
				.antMatchers("/admin/**").hasRole("ADMIN")
				// 请求匹配 /user/** 拥有 ROLE_ADMIN 和 ROLE_USER 的角色用户都可以访问
				.antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
				// 任何以"/db/" 开头的URL需要同时具有 "ROLE_ADMIN" 和 "ROLE_DBA"权限的用户才可以访问。
				// 和上面一样我们的 hasRole 方法也没有使用 "ROLE_" 前缀。
				// .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
				// 其余所有的请求都需要认证后才可以访问
				.anyRequest().authenticated().and().formLogin()
				// 登陆界面；默认登陆成功后的界面(不起作用)；默认登陆失败的界面;表单提交地址
				.loginPage("/login").defaultSuccessUrl("/index.html").failureUrl("/login?error=true")
				// 默认用户名键值，默认密码键值
				.usernameParameter("username").passwordParameter("password").permitAll().and().rememberMe()
				.tokenValiditySeconds(1209600).key("rememberme");
//                .and()
//                .logout().logoutUrl("").logoutSuccessUrl("/index.html").permitAll();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
//        在内存中添加用用户，并给用户指定角色权限
// 自定义一个认证方法，该方法必须实现 UserDetailsService 这个接口
//  密码使用BCryptPasswordEncoder() 方法验证，在注册用户时接收前台的明文密码之后也需要使用 BCryptPasswordEncoder().encode(明文密码)进行加密
		auth.userDetailsService(customUserService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

}
