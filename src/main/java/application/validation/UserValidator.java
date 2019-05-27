package application.validation;

import application.model.User;
import application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
 @Autowired
    private UserService userService;

    //@Override
    //public boolean supports(Class<?> aClass) {
      //  return User.class.equals(aClass);
    //}

    public boolean supports(Class clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");
        if (user.getFirstname().length() < 6 || user.getFirstname().length() > 32) {
            errors.rejectValue("firstname", "Size.userForm.firstname");
        }

        if (user.getLastname().length() < 6 || user.getLastname().length() > 32) {
            errors.rejectValue("lastname", "Size.userForm.lastname");
        }
        if (userService.findUserByEmail(user.getEmail()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.email");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

       /* if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }*/
    }
}
