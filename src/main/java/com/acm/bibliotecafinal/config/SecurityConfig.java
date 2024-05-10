package com.acm.bibliotecafinal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.RequiredArgsConstructor;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authRequest -> 
                authRequest
                    .requestMatchers("/auth/**").permitAll()
                    .anyRequest().authenticated()
                )
            .formLogin(x->{
                x.successHandler(successHandler());
            })
            .sessionManagement(policy -> {
                policy.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .sessionFixation(fixation -> {
                    fixation.migrateSession();
                })
                .invalidSessionUrl("/login")
                .maximumSessions(1)
                .expiredUrl("/login");
            })
            .httpBasic(x->{})
            .build();
    }
    
    @Bean
    public SessionRegistry sessionRegistry(){
        return new SessionRegistryImpl();
    }

    @Bean
    public AuthenticationSuccessHandler successHandler(){
        return ((req, res, auth) -> {
            res.sendRedirect("/");
        });
    }
}
