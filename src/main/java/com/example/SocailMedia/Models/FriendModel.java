package com.example.SocailMedia.Models;

import com.example.SocailMedia.Entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FriendModel {
    @Valid
    private int friendsId;
    @NotBlank
    private String fname;
    private Set<UserModel> members=new HashSet<>();
}
