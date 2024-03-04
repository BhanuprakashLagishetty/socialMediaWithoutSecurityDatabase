package com.example.SocailMedia.Service;

import com.example.SocailMedia.Entity.Freinds;
import com.example.SocailMedia.Entity.Post;
import com.example.SocailMedia.Entity.User;
import com.example.SocailMedia.Entity.UserProfile;
import com.example.SocailMedia.Models.FriendModel;
import com.example.SocailMedia.Models.PostModel;
import com.example.SocailMedia.Models.UserModel;
import com.example.SocailMedia.Models.UserProfileModel;
import com.example.SocailMedia.Repository.Friends_Repo;
import com.example.SocailMedia.Repository.Post_Repo;
import com.example.SocailMedia.Repository.User_Repo;
import com.example.SocailMedia.Repository.userProfile_Repository;
import com.oracle.wls.shaded.org.apache.bcel.generic.PUSH;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    User_Repo userRepo;
    @Autowired
    Post_Repo post;
    @Autowired
    Friends_Repo friends;
    @Autowired
    userProfile_Repository userprofile;
    public int  CheckLogin(String userName,String Password)
    {
        List<User>user=userRepo.findAll();
        System.out.println(user);
        for(User user1: user)
        {
            System.out.println("Successfully login");
            System.out.println(userName);
            System.out.println("THSIS LIST"+ user1.getUserName());
            if(user1.getUserName().equals(userName))
            {
                if(user1.getPassword().equals(Password))
                {
                    return user1.getUserId();
                }
            }

        }
        return 0;
    }
    public String addUser(UserModel userModel)
    {
        System.out.println(userModel+"this is usermodel");
        User user=new User();
        UserProfile userProfile=new UserProfile();
        UserProfileModel userProfileModel=userModel.getUserProfileModel();
        BeanUtils.copyProperties(userProfileModel,userProfile);
        BeanUtils.copyProperties(userModel,user);
        user.setUserProfile(userProfile);
      userRepo.save(user);
      return "Saved succesfully";
    }
    public List<User> display()
    {
        return userRepo.findAll();
    }
    public void remove(int id)
    {
        userRepo.deleteById(id);
    }
    public User userProfile(int id)
    {
        User user=userRepo.findById(id).orElse(null);
        return user;
    }
    public String savepost(Post post,int userId)
    {
      User user1=userRepo.findById(userId).orElse(null);
      List<Post> postList=user1.getPosts();
      postList.add(post);
      user1.setPosts(postList);
      post.setUser(user1);
      userRepo.save(user1);
      return "userentered succesfully";
    }
    public List<Post> viewPost(int userId)
    {
        User user1=userRepo.findById(userId).orElse(null);
        return user1.getPosts();
    }
    public List<PostModel> viewAllPosts()
    {
        List<Post>postList=post.findAll();
        List<PostModel>postModelList=new ArrayList<>();
        postList.stream().forEach((e)->{
            PostModel postModel=new PostModel();
            BeanUtils.copyProperties(e,postModel);
            postModelList.add(postModel);
        });
        return postModelList;
    }





}
