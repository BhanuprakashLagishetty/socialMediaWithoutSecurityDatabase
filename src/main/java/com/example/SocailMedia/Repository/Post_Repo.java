package com.example.SocailMedia.Repository;

import com.example.SocailMedia.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Post_Repo extends JpaRepository<Post,Integer> {
}
