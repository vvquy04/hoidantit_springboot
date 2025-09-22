package com.example.demo.service.validator;

import org.springframework.stereotype.Service;

import com.example.demo.domain.dto.RegisterDTO;
import com.example.demo.service.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Service
public class RegisterValidator implements ConstraintValidator<RegisterChecked, RegisterDTO> {

    private final UserService userService;
    public RegisterValidator(UserService userService){
        this.userService = userService;
    }
  @Override
  public boolean isValid(RegisterDTO user, ConstraintValidatorContext context) {
    boolean valid = true;
    if(!user.getPassword().equals(user.getConfirmPassword())){
        context.buildConstraintViolationWithTemplate("Passwords nhập không chính xác")
        .addPropertyNode("confirmPassword")
        .addConstraintViolation()
        .disableDefaultConstraintViolation();
        valid = false;
    }

    if(this.userService.checkEmailExits(user.getEmail())){
        context.buildConstraintViolationWithTemplate("Email đã tồn tại")
        .addPropertyNode("email")
        .addConstraintViolation()
        .disableDefaultConstraintViolation();
        valid = false;
    }
    return valid;
}

}
