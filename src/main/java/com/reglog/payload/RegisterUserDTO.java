package com.reglog.payload;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RegisterUserDTO {
    private String name;

    private String email;
    private String password;

    private String mobileNo;

    public  String toString()
    {
        return "NAME:"+name+" "+"EMAIL:"+email+" "+"MOBILE NO:"+mobileNo;
    }
}
