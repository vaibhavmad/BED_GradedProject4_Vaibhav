package com.greatlearning.emr.security.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.greatlearning.emr.security.service.impl.EmrUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class EmrSecurityConfiguration {

    @Bean
    public UserDetailsService userDetailsService() {
        return new EmrUserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/employees/add", "/api/employees/delete/**", "/api/employees/update").hasAuthority("ADMIN_USER")
            .antMatchers("/api/employees/**").authenticated()
            .antMatchers("/api/roles/**", "/api/users/**").permitAll()
            .and()
            .httpBasic();
        return http.build();
    }

    @Bean
    public AuthenticationManagerBuilder configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        return auth;
    }
}
