package com.reglog;

import com.reglog.controller.AuthController;
import lombok.extern.flogger.Flogger;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.SQLOutput;


@SpringBootApplication(scanBasePackages = {"com.reglog."})
@EnableJpaRepositories("com.reglog.repository.")
@EntityScan("com.reglog.entity.")
public class RegLogThymleafApplication {
	public static Logger logger=Logger.getLogger(RegLogThymleafApplication.class);
	public static void main(String[] args) {
		logger.info("Starting RegLog Application");
		SpringApplication.run(RegLogThymleafApplication.class, args);
		System.out.println();
	}

}
