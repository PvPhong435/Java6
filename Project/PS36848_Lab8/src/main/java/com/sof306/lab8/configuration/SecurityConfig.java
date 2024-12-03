package com.sof306.lab8.configuration;

import com.sof306.lab8.entity.Account;
import com.sof306.lab8.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    AccountService accountService;

    public SecurityConfig(AccountService accountService) {
        this.accountService = accountService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        return username -> {
            Account account = accountService.findById(username);
            if(account == null) {
                throw new UsernameNotFoundException(username);
            }
            String password = passwordEncoder.encode(account.getPassword());
            String[] roles = account.getAuthorities().stream()
                    .map(authority -> authority.getRole().getId())
                    .toArray(String[]::new);
            return User.withUsername(username).password(password).roles(roles).build();
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(registry ->
                registry.requestMatchers("/order/**").authenticated()
                        .requestMatchers("/admin/**").hasAnyRole("STAFF", "DIRE")
                        .requestMatchers("/rest/authorities").hasRole("DIRE")
                        .anyRequest().permitAll())
            .formLogin(config ->
                config.loginPage("/security/login/form")
                      .loginProcessingUrl("/security/login")
                      .defaultSuccessUrl("/security/login/success", false)
                      .failureUrl("/security/login/error"))
            .rememberMe(config -> config.tokenValiditySeconds(86400))
            .exceptionHandling(config -> config.accessDeniedPage("/security/unauthorized"))
            .logout(config ->
                config.logoutUrl("/security/logout")
                      .logoutSuccessUrl("/security/logout/success"));
        return http.build();
    }

}
