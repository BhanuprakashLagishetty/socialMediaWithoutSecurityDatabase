package com.example.SocailMedia.Controller;

import com.example.SocailMedia.Entity.Post;
import com.example.SocailMedia.Entity.User;
import com.example.SocailMedia.Entity.UserProfile;
import com.example.SocailMedia.Models.*;
import com.example.SocailMedia.Service.UserService;
import com.example.SocailMedia.validator.GroupValidator;
import com.example.SocailMedia.validator.UserValidator;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class HomeController {
    public int UserId1=0;
    public int GroupId1=0;
    public int G_UserId=0;
    public String userName1;
    public String Password1;
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;

    @Autowired
    private GroupValidator groupValidator;
    @RequestMapping("/")
    public String home(){
        return "homepage";
    }


    @RequestMapping("/Register")
    public String Register()
    {
        return "addUser";
    }
    @RequestMapping("/login")
    public String Login()
    {
        return "login";
    }

    @RequestMapping("/CheckLogin")

    public String CheckLogin(String userName,String Password, Model model)
    {

        int result=userService.CheckLogin(userName,Password);
        System.out.println(result);
        if(result!=0)
        {
            userName1=userName;
            G_UserId=result;
            System.out.println("USER ID IS"+G_UserId);
            return "index";
        }
        else{
            String message="PLEASE LOGIN CORRECTLY";
            model.addAttribute("message",message);
            return "ShowLoginResults";
        }
    }

    //adding user
    @RequestMapping("/addUser")
    public String addUser()
    {
        return "addUser";
    }
    @PostMapping("/SaveUser")
    public ResponseEntity<UserModel> SaveUser(@RequestBody @Valid UserModel userModel)
    {
        userService.addUser(userModel);
        List<User>u=userService.display();
        System.out.println("USER IloginD IS"+G_UserId);
        return ResponseEntity.ok(userModel);
    }
    @GetMapping(value = {"/viewUsers" }, produces = "application/json")
    public List<User> viewUsers()
    {
        List<User>u=userService.display();
        System.out.println(u);
        return u;

    }
    @DeleteMapping("/removeemployee/{eid}")
    public String removeemployee(@PathVariable int eid)
    {
        userService.remove(eid);
        return "Deleted successfully";
    }
    @GetMapping("/SearchEmployee/{eid}")
    public User SearchEmployee(@PathVariable int eid)
    {

        System.out.println(eid);
        User e2=userService.userProfile(eid);

        return e2;
    }
    @RequestMapping("/Addposts")
    public String Addposts(int userId)
    {
        UserId1=userId;
        return "addPost";
    }

    @PostMapping( "/SavePost/{userId}")
    public String SavePost(@RequestBody @Valid Post post,@PathVariable int userId)
    {
        userService.savepost(post,userId);
        List<User>u=userService.display();
        return "post added successfully";
    }

    @GetMapping("/ViewPosts/{userId}")
    public List<Post> ViewPosts(@PathVariable int userId,Model model)
    {
        UserId1=userId;
        List<Post>postList=userService.viewPost(userId);
        return postList;
    }
    @GetMapping("/ViewAllPosts")
    public List<PostModel>viewAllPost()
    {
        return userService.viewAllPosts();
    }











}
