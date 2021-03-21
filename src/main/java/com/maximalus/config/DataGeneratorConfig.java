package com.maximalus.config;

import com.maximalus.model.Credential;
import com.maximalus.model.Role;
import com.maximalus.service.impl.CredentialServiceImpl;
import com.maximalus.service.impl.RoleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class DataGeneratorConfig implements InitializingBean {
    private final CredentialServiceImpl credentialService;
    private final RoleServiceImpl roleService;

    @Bean
    public Credential credential(){
        return new Credential();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Credential credential = new Credential();
        credential.setUsername("Maximalys");
        credential.setPassword("1");
        credential.setDeleted(false);
        Role administrator = roleService.findByName("ADMINISTRATOR");
        credential.setRole(administrator);
        credentialService.save(credential);
    }
}
