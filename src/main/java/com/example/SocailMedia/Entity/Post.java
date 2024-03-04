package com.example.SocailMedia.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
@JsonIgnore
    @Id
    @GeneratedValue
    private int postId;
    @NotBlank(message = "titile should not be null")
    private String Tittle;
    @NotBlank(message = "please enter content for better reach")
    @Length(min = 50,max = 250,message = "content should have minimum characters 50 and maximum characters 250")
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}
