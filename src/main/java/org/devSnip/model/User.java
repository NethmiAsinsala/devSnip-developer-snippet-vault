package org.devSnip.model;

import jakarta.persistence.*;
import lombok.*;
import org.devSnip.util.Role;

@Getter
@Setter
public class User {

    private Integer id;
    private String name;
    private String email;
    private String password;

    private Role role;




}