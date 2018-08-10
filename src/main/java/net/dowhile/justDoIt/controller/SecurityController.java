package net.dowhile.justDoIt.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@GetMapping("/login")
	public String login(String error) {
		return "login.html";
	}

	@GetMapping("/loginError.html")
	public String logerror(Model model) {
		model.addAttribute("error", "用户名或密码错误");
		return "error.html";
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("hello","Hi,Just Do It.");
		return "index.html";
	}
}
