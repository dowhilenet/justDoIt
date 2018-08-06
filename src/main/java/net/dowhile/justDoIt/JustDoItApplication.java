package net.dowhile.justDoIt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JustDoItApplication {

	private final static Logger logger = LoggerFactory.getLogger(JustDoItApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(JustDoItApplication.class, args);
		logger.debug("debug 成功了");
		logger.info("info 成功了");
		logger.warn("warn 成功了");
		logger.error("error 成功了");

	}
}
