package myweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class WebTinTucApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(WebTinTucApplication.class, args);
	}
}
