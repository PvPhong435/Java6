package com.sof306.lab7.service;

import com.sof306.lab7.dao.AccountDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final AccountDAO accountDAO;
    private final BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountDAO.findById(username).map(account -> {
            String[] roles = account.getAuthorities().stream()
                    .map(authority -> "ROLE_" + authority.getRole().getId()).toArray(String[]::new);
            return User.withUsername(account.getUsername()).password(encoder.encode(account.getPassword())).authorities(roles).build();
        }).orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
    }

    public void loginFormOAuth2(OAuth2AuthenticationToken oauth) {
        String email = oauth.getPrincipal().getAttribute("email");
        String password = Long.toHexString(System.currentTimeMillis());

        UserDetails userDetails = User.withUsername(email).password(encoder.encode(password)).roles("GUEST").build();
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
