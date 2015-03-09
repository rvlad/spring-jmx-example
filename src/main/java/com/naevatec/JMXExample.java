package com.naevatec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
@Import(JmxAutoConfiguration.class)
public class JMXExample {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JMXExample.class, args);
	}
}