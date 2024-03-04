package com.example.SocailMedia.Controller;

import com.example.SocailMedia.Entity.User;
import com.example.SocailMedia.Models.FriendModel;
import com.example.SocailMedia.Models.UserModel;
import com.example.SocailMedia.Service.GroupService;
import com.example.SocailMedia.Service.UserService;
import com.example.SocailMedia.validator.GroupValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;
    public int GroupId1=0;
    public int UserId1=0;
    @Autowired
    GroupValidator groupValidator;

    @Autowired
    UserService userService;
    @RequestMapping("/CreateGroup")
    public String CreateGroup()
    {
        System.out.println("Group Method is called");
        return "CreateGroup";
    }

    @PostMapping("/SaveGroup")
    public FriendModel SaveGroup(@RequestBody FriendModel friendModel){
//        System.out.println("this is the frindmodel name"+ friendModel.getFname());
//        groupValidator.validate(friendModel,bindingResult);
//        System.out.println(bindingResult);
//        if(bindingResult.hasErrors())
//        {
//            System.out.println("this is my page");
//            return "CreateGroup";
//        }
        groupService.createGroup(friendModel);
        return friendModel;
    }
    @GetMapping("/viewAllGroups")
    public List<FriendModel> viewAllGroups(Model model)
    {
        List<FriendModel> frm= groupService.viewAllGroups();
//        model.addAttribute("friends",frm);
        return frm;
    }
    @GetMapping("/viewGroupMembers")
    public Set<UserModel> viewGroupMembers(@RequestParam("groupId") int groupId)
    {
        GroupId1=groupId;
        Set<UserModel> um=groupService.viewGroupMembers(groupId);
        return um;
    }
    @GetMapping("/ShowallExistingUsers")
    public List<User> ShowallExistingUsers()
    {
//        GroupId1=groupId;
        List<User>u=userService.display();
        return u;
    }
    @PostMapping("/AddToGroup")
    public String AddToGroup(@RequestParam("userId") int userId,@RequestParam("groupId") int GroupId1)
    {
        UserId1=userId;
//        System.out.println("Group id"+GroupId1);
        groupService.addUserToGroup(userId,GroupId1);
        return "userAddedSuccessfully";
    }
    @DeleteMapping("/removeMember")
    public Set<UserModel> removeMember(@RequestParam("userId") int eid, @RequestParam("GroupId") int GroupId)
    {
        groupService.removeMember(eid,GroupId);
        Set<UserModel> um=groupService.viewGroupMembers(GroupId);
        return um;
    }
    @DeleteMapping("/removeGroup")
    public List<FriendModel> removeGroup(@RequestParam("GroupId") int GroupId)
    {
        groupService.removeGroup(GroupId);
        List<FriendModel> frm= groupService.viewAllGroups();
//        model.addAttribute("friends",frm);
        return frm;
    }
}
