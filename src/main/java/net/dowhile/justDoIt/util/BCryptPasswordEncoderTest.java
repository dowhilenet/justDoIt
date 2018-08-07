package net.dowhile.justDoIt.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    private final static Logger logger = LoggerFactory.getLogger(BCryptPasswordEncoderTest.class);
    public static void main(String[] args) {
        String password = bCryptPasswordEncoder.encode("admin");
        logger.info("pass word is {}",password);
    }
}
