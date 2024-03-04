package com.example.SocailMedia.Models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginModel {
    @Valid
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
