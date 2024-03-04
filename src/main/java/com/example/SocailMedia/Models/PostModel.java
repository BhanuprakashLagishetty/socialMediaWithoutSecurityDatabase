package com.example.SocailMedia.Models;

import com.example.SocailMedia.Entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PostModel {
    @Valid
    private int postId;
    @NotBlank
    private String Tittle;
    @Length(min = 50,max = 250,message = "content should have minimum characters 50 and maximum characters 250")
    private String content;
    private User user;
}
