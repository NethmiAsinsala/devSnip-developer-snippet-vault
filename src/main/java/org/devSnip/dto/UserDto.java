package org.devSnip.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.devSnip.util.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer user_id;
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
