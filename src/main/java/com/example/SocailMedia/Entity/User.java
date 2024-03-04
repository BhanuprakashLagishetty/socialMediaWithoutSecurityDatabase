package com.example.SocailMedia.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EnableWebMvc
public class User {
    @Valid
    @Id
    @GeneratedValue
    private int userId;

    private String userName;
    private String Password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
//    @JsonManagedReference
    private UserProfile userProfile;

    //one to many connection
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private List<Post> posts = new ArrayList<>();

    //many to many connection
    @ManyToMany
    @JoinTable(name = "user_friends",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "friendsId"))
//    @JsonManagedReference
    private Set<Freinds> friends = new HashSet<>();

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
