package com.example.flower_web.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails admin = User.builder()
                .username("admin@example.com") // Почта вместо логина
                .password(new BCryptPasswordEncoder().encode("admin123")) // Пароль
                .roles("ADMIN") // Роль
                .build();
        return new InMemoryUserDetailsManager(admin);
    }
}
