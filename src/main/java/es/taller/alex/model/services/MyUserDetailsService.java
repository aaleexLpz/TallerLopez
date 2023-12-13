package es.taller.alex.model.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if ("user".equals(username)) {
            return User.withUsername("user").password("{noop}user").roles("USER").build();
        } else if ("admin".equals(username)) {
            return User.withUsername("admin").password("{noop}admin").roles("ADMIN").build();
        } else if ("guest".equals(username)) {
            return User.withUsername("guest").password("{noop}guest").roles("GUEST").build();
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
    }
}

