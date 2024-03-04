package com.example.SocailMedia.Repository;

import com.example.SocailMedia.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userProfile_Repository extends JpaRepository<UserProfile,Integer> {
}
