package com.maximalus;

import com.maximalus.model.Credential;
import com.maximalus.model.Role;
import com.maximalus.service.impl.CredentialServiceImpl;
import com.maximalus.service.impl.RoleServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
        public static void main(String[] args) {
			ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
			CredentialServiceImpl credentialServiceImpl =
					context.getBean("credentialServiceImpl", CredentialServiceImpl.class);

			RoleServiceImpl roleServiceImpl =
					context.getBean("roleServiceImpl", RoleServiceImpl.class);

			Credential credential = new Credential();
			credential.setUsername("maximalys@gmail.com");
			credential.setPassword("1");
			Role administrator = roleServiceImpl.findByName("ADMINISTRATOR");
			credential.setRole(administrator);
			credential.setDeleted(false);
			credentialServiceImpl.save(credential);
		}
}
