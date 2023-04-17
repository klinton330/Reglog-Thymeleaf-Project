package com.reglog.service.imple;

import com.reglog.entity.RegisterUser;
import com.reglog.entity.UserRole;
import com.reglog.payload.RegisterUserDTO;
import com.reglog.repository.AuthRepository;
import com.reglog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AuthRepository authRepository;
    @Override
    public String saveuser(RegisterUserDTO registerUserdto){
        RegisterUser registerUser=new RegisterUser();
        registerUser.setName(registerUserdto.getName());
        registerUser.setEmail(registerUserdto.getEmail());
        registerUser.setPassword(bCryptPasswordEncoder.encode(registerUserdto.getPassword()));
        registerUser.setMobileNo(registerUserdto.getMobileNo());
        registerUser.setRoles(Arrays.asList(new UserRole("ROLE_USER")));
        authRepository.save(registerUser);
        return "Stored Successfully";
    }

    @Override
    public RegisterUser getRegisterUser(String userEmail)
    {
        return authRepository.findByEmail(userEmail);
    }
}
