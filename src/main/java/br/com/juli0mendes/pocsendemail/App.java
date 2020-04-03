package br.com.juli0mendes.pocsendemail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.juli0mendes.pocsendemail.core.EmailCore;

@SpringBootApplication
public class App implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	@Autowired
	private EmailCore emailCore;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("sending email");
		
		try {
			this.emailCore.sendEmail();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("sent");
	}
}