package myweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class WebTinTucApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebTinTucApplication.class, args);
	}

}
