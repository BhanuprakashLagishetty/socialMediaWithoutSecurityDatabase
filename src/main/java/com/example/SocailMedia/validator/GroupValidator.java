package com.example.SocailMedia.validator;

import com.example.SocailMedia.Models.FriendModel;
import com.example.SocailMedia.Models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class GroupValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return FriendModel.class.equals(clazz);
    }
    public void validate(Object target, Errors errors) {
        FriendModel friendModel = (FriendModel) target;
        System.out.println(friendModel.getFname()+"this is the name");
        if(friendModel.getFname()==null || friendModel.getFname().isBlank())
        {
            System.out.println("This is the group validator");
            errors.rejectValue("fname","groupEmpty","please enter group name");
        }

    }


}
