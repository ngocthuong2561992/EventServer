package com.cd.stmty.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetail extends User{
    private static final long serialVersionUID = -3531439484732724601L;

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String fullName;
}
