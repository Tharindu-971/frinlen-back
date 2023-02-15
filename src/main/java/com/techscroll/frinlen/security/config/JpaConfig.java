package com.techscroll.frinlen.security.config;

import com.techscroll.frinlen.entity.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {

    private final AuditorAware<User> auditorAware;

    public JpaConfig(AuditorAware<User> auditorAware) {
        this.auditorAware = auditorAware;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public AuditorAware<User> auditorAware() {
        return auditorAware;
    }
}

