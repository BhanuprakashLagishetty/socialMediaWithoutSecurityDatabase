package com.example.SocailMedia.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class Passwords implements ConstraintValidator <Password,String> {


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s!=null)
        {
            if(s.length()<10 && s.length()>5)
            {
                return true;
            }
        }
        return false;
    }
}
