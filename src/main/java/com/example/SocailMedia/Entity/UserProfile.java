package com.example.SocailMedia.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserProfile {
    @Id
    @GeneratedValue
    private int userProfileId;
    private String fullName;
    private String EmailId;
    @OneToOne(mappedBy = "userProfile")
    @JsonBackReference
    private User user;

    @Override
    public String toString() {
        return "UserProfile{" +
                "userProfileId=" + userProfileId +
                ", fullName='" + fullName + '\'' +
                ", EmailId='" + EmailId + '\'' +
                '}';
    }
}
