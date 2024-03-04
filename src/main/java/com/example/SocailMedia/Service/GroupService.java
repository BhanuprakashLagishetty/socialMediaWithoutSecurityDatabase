package com.example.SocailMedia.Service;

import com.example.SocailMedia.Entity.Freinds;
import com.example.SocailMedia.Entity.User;
import com.example.SocailMedia.Entity.UserProfile;
import com.example.SocailMedia.Models.FriendModel;
import com.example.SocailMedia.Models.UserModel;
import com.example.SocailMedia.Models.UserProfileModel;
import com.example.SocailMedia.Repository.Friends_Repo;
import com.example.SocailMedia.Repository.Post_Repo;
import com.example.SocailMedia.Repository.User_Repo;
import com.example.SocailMedia.Repository.userProfile_Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GroupService {
    @Autowired
    User_Repo userRepo;
    @Autowired
    Post_Repo post;
    @Autowired
    Friends_Repo friends;
    @Autowired
    userProfile_Repository userprofile;
    public String createGroup(FriendModel friendModel)
    {
        Freinds fr=new Freinds();
        BeanUtils.copyProperties(friendModel,fr);
        friends.save(fr);
        return "Successfully saved";

    }
    public List<FriendModel> viewAllGroups()
    {
        List<Freinds>fr=friends.findAll();
        List<FriendModel>frm=new ArrayList<>();
        fr.stream().forEach((e)->{
            FriendModel friendModel=new FriendModel();
            Set<UserModel>userModelSet=new HashSet<>();
            e.getMembers().stream().forEach((e1)->{
                UserProfileModel userProfileModel=new UserProfileModel();
                BeanUtils.copyProperties(e1.getUserProfile(),userProfileModel);
                UserModel userModel=new UserModel();
                BeanUtils.copyProperties(e1,userModel);
                userModel.setUserProfileModel(userProfileModel);
                userModelSet.add(userModel);
            });
            friendModel.setMembers(userModelSet);
            BeanUtils.copyProperties(e,friendModel);
            frm.add(friendModel);
        });
        System.out.println(frm);
        return frm;

    }
    public Set<UserModel> viewGroupMembers(int groupId)
    {
        Freinds fr=friends.findById(groupId).orElse(null);
        FriendModel friendModel=new FriendModel();
        Set<User>user =fr.getMembers();
        Set<UserModel>userModelSet=new HashSet<>();
        user.stream().forEach((e)->{
            UserModel userModel=new UserModel();
            BeanUtils.copyProperties(e,userModel);
            userModelSet.add(userModel);
        });
        return userModelSet;

    }
    public String addUserToGroup(int userId,int groupId)
    {

        System.out.println("Method called");
        User user = userRepo.findById(userId).orElse(null);
        Freinds group = friends.findById(groupId).orElse(null);
        System.out.println("this is proifle"+user.getUserProfile());
        System.out.println(user);
        System.out.println(group);

        if (user != null && group != null) {
            Set<Freinds> userGroups = user.getFriends();
            Set<User> groupMembers = group.getMembers();
            System.out.println("if statemetn");


            if (!userGroups.contains(group)) {
                userGroups.add(group);
                user.setFriends(userGroups);
            }


            if (!groupMembers.contains(user)) {
                groupMembers.add(user);
                group.setMembers(groupMembers);
            }
            System.out.println("THIS AFTER IF"+user);
            System.out.println("THis kjahsdf"+group);
            userRepo.save(user);
            friends.save(group);

            return "Successfully Added";
        } else {
            return "User or Group not found";
        }




    }
    public String removeGroup(int groupId)
    {
        Freinds fri=friends.findById(groupId).orElse(null);
        if(fri!=null)
        {
            Set<User> user=fri.getMembers();
            for(User user1:user)
            {
                Set<Freinds>fr=user1.getFriends();
                if(fr.contains(fri))
                {
                    fr.remove(fr);
                    user1.setFriends(fr);
                    userRepo.save(user1);
                }
            }
            fri.setMembers(new HashSet<>());
            friends.deleteById(groupId);
            return "Deleted succesfully";
        }
        else{
            return "Unable to find users";
        }


    }

    public String removeMember(int eid,int groupId)
    {
        System.out.println("THIS IS MY GROUP Id: "+groupId);
        User user=userRepo.findById(eid).orElse(null);
        Freinds fri=friends.findById(groupId).orElse(null);
        Set<User>user1=fri.getMembers();


        //removing user from the group
        if(user1.contains(user))
        {

            user1.remove(user);
            fri.setMembers(user1);
            Set<Freinds>fr=user.getFriends();
            if(fr.contains(fri))
            {
                fr.remove(fri);
                user.setFriends(fr);
            }


            userRepo.save(user);
            friends.save(fri);
        }
        return "Succesfully Deleted";

    }
}
