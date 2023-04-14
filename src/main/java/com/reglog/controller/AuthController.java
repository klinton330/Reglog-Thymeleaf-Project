package com.reglog.controller;

import com.reglog.entity.RegisterUser;
import com.reglog.payload.RegisterUserDTO;
import com.reglog.service.AuthService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;
    Logger logger=Logger.getLogger(AuthController.class);
    @GetMapping("/")
    public String getHomePage()
    {
        logger.info("Calling Homepage");
        return "home";
    }
    @GetMapping("/register")
    public String getRegistrationPage(Model model)
    {
        logger.info("calling register.html");
        RegisterUserDTO registerUserDTO=new RegisterUserDTO();
        model.addAttribute("registerUser",registerUserDTO);
        return "register";
    }

    @PostMapping("/register")
    public String storeUser(@ModelAttribute("registerUser") RegisterUserDTO registerUserdto, Model model)
    {
        logger.info("calling Store UserMethod:Data going to Store-"+registerUserdto);
        String result= authService.saveuser(registerUserdto);
        logger.info(result);
         return "login";
    }

    @GetMapping("/login")
    public String loginUser()
    {
        logger.info("calling Login user ");
        return "login";
    }
}
