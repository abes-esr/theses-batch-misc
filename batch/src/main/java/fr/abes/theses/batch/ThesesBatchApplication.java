package fr.abes.theses.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"fr.abes.theses.*"})
public class ThesesBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThesesBatchApplication.class, args);
	}

}
