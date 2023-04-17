package com.reglog.security;

import com.reglog.entity.RegisterUser;
import com.reglog.entity.UserRole;
import com.reglog.repository.AuthRepository;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
@Service
public class CustomUserDetails implements UserDetailsService {

    Logger logger= Logger.getLogger(CustomUserDetails.class);
    @Autowired
    private AuthRepository authRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        RegisterUser registerUser=authRepository.findByEmail(username);
        if(registerUser==null) {
            logger.error("Invalid username or password");
            throw new UsernameNotFoundException("Invalid Username or Password");
        }
        else {
            logger.info("Login Credential Valid");
            return new org.springframework.security.core.userdetails.User(registerUser.getEmail(), registerUser.getPassword(), mapRolesToAuthorities(registerUser.getRoles()));
        }
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<UserRole> roles) {
        return roles.stream().map(role-> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }

}
