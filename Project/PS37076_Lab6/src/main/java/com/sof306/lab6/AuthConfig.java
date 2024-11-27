package com.sof306.lab6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AuthConfig {

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder passwordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user1").password(passwordEncoder.encode("123")).roles("GUEST").build());
        manager.createUser(User.withUsername("user2").password(passwordEncoder.encode("123")).roles("USER", "GUEST").build());
        manager.createUser(User.withUsername("user3").password(passwordEncoder.encode("123")).roles("ADMIN", "USER", "GUEST").build());
        return manager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry ->
//                        registry.requestMatchers("/home/admins").hasRole("ADMIN")
//                                .requestMatchers("/home/users").hasAnyRole("ADMIN", "USER")
//                                .requestMatchers("/home/authenticated").authenticated()
//                                .anyRequest().permitAll())
                        registry.anyRequest().permitAll())
                .exceptionHandling(exception ->
                        exception.accessDeniedPage("/auth/access/denied"))
                .formLogin(login ->
                        login.loginPage("/auth/login/form")
                                .loginProcessingUrl("/auth/login")
                                .defaultSuccessUrl("/home/index", true)
                                .failureUrl("/auth/login/error")
                                .usernameParameter("username").passwordParameter("password"))
                .rememberMe(remember -> remember.rememberMeParameter("remember"))
                .logout(logout ->
                        logout.logoutUrl("/auth/logout")
                                .logoutSuccessUrl("/auth/logout/success"))
                .build();
    }

}
