package me.lcc.carrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lcc
 * @version 2022/7/30
 */
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        new SpringApplication(WebApplication.class).run(args);
    }
}
