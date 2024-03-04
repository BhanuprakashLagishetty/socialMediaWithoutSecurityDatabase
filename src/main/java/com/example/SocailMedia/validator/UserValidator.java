package com.example.SocailMedia.validator;

import com.example.SocailMedia.Models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserModel.class.equals(clazz);
    }
    public void validate(Object target, Errors errors) {
        UserModel userModel = (UserModel) target;

        if (!userModel.getUserName().isEmpty()) {
            if (!userModel.getUserName().startsWith("A")) {
                errors.rejectValue("userName", "userName");
            }
        }
        else {
            ValidationUtils.rejectIfEmpty(errors, "userName", "userNameEmpty");
        }

        if(userModel.getUserProfileModel().getFullName().isEmpty())
        {
            ValidationUtils.rejectIfEmpty(errors,"userProfileModel.fullName","FullNameMessage","HFFFHGFHGF");
        }


        if(userModel.getPassword().isEmpty())
        {
            ValidationUtils.rejectIfEmpty(errors,"password","passwordMessage","password should not be null");

        }
        else {
            if(userModel.getPassword().length()<6)
            {
                errors.rejectValue("password","passwordvalidator");
            }
        }
        if(userModel.getUserProfileModel().getEmailId().isEmpty())
        {
            ValidationUtils.rejectIfEmpty(errors,"userProfileModel.EmailId","emailMessage");
        }
        else {
            if(!userModel.getUserProfileModel().getEmailId().endsWith("@gmail.com")){
                errors.rejectValue("userProfileModel.EmailId","emailValidator");
            }
        }
    }

}
