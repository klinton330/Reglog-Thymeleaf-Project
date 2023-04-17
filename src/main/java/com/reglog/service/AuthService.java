package com.reglog.service;

import com.reglog.entity.RegisterUser;
import com.reglog.payload.RegisterUserDTO;

public interface AuthService {

    public String saveuser(RegisterUserDTO registerUserdto);

    public RegisterUser getRegisterUser(String userEmail);
}
