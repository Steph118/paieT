/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import entities.User;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import service.interfaces.UserServiceLocal;

import java.util.Optional;
import java.util.ResourceBundle;

/**
 *
 * @author steph18
 */
@FacesValidator(value = "duplicateUsernameValidator", managed = true)
public class DuplicateUsernameValidator implements Validator<String> {

    @Inject
    private UserServiceLocal userService;

    public static String getMessage(FacesContext fc, String key) {
        return ResourceBundle.getBundle(fc.getApplication().getMessageBundle(),
                fc.getViewRoot().getLocale()).getString(key);
    }

    @Override
    public void validate(FacesContext fc, UIComponent uic, String t) throws ValidatorException {
        if (StringUtils.isEmpty(t)) {
            return;
        }

        Optional<User> u = userService.findByUsername(t);
        if (u.isPresent()) {
            throw new ValidatorException(new FacesMessage(getMessage(fc, "message.duplicateUsernameValidator")));

        }
    }
}
