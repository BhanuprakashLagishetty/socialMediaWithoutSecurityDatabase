package com.example.SocailMedia.Models;

import com.example.SocailMedia.Entity.Freinds;
import com.example.SocailMedia.Entity.Post;
import com.example.SocailMedia.Entity.UserProfile;
import com.example.SocailMedia.validator.Password;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.message.Message;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserModel {
@Valid


    private int userId;
    @NotBlank(message = "arguments should not be null")
    private String userName;
//    @Length(min=5, max = 10, message = "password should more than 5 characters and less than 10 characters")
    @Password
    @NotBlank
    private String password;

    private UserProfileModel userProfileModel;

    private List<PostModel> postsModel;

    private Set<FriendModel> friendModel ;

}
