package com.example.SocailMedia.Repository;

import com.example.SocailMedia.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Repo extends JpaRepository<User,Integer> {
}
