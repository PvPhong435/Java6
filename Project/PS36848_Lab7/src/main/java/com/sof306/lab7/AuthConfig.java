package com.sof306.lab7;

import com.sof306.lab7.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class AuthConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService(BCryptPasswordEncoder passwordEncoder) {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user1").password(passwordEncoder.encode("123")).roles("GUEST").build());
//        manager.createUser(User.withUsername("user2").password(passwordEncoder.encode("123")).roles("USER", "GUEST").build());
//        manager.createUser(User.withUsername("user3").password(passwordEncoder.encode("123")).roles("ADMIN", "USER", "GUEST").build());
//        return manager;
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry ->
                        registry.requestMatchers("/home/admins").hasRole("ADMIN")
                                .requestMatchers("/home/users").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/home/authenticated").authenticated()
//                                .requestMatchers("/rest/authorities", "/rest/authorities/**").hasAnyRole("ADMIN", "USER")
                                .anyRequest().permitAll())
                .exceptionHandling(exception ->
                        exception.accessDeniedPage("/auth/access/denied"))
                .formLogin(login ->
                        login.loginPage("/auth/login/form")
                                .loginProcessingUrl("/auth/login")
                                .defaultSuccessUrl("/auth/login/success", false)
                                .failureUrl("/auth/login/error")
                                .usernameParameter("username").passwordParameter("password"))
                .rememberMe(remember -> remember.rememberMeParameter("remember"))
                .logout(logout ->
                        logout.logoutUrl("/auth/logout")
                                .logoutSuccessUrl("/auth/logout/success"))
                .oauth2Login(oauth2login ->
                        oauth2login.loginPage("/auth/login/form")
                                .defaultSuccessUrl("/oauth2/login/success", true)
                                .failureUrl("/auth/login/error"))
                .build();
    }

}
