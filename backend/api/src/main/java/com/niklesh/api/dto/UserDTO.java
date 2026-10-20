package com.niklesh.api.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class UserDTO {

    private String fullname;

    private String email;

    private String password;

    private String role;

    private Date dob;

    private String profession;

    private String education;
}
