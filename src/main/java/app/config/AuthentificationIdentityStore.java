package app.config;

import entities.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.authentication.mechanism.http.AutoApplySession;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import service.interfaces.UserServiceLocal;

import java.util.Optional;
import java.util.Set;

@ApplicationScoped
@AutoApplySession
public class AuthentificationIdentityStore implements IdentityStore {

    @Inject
    private UserServiceLocal userService;

    @Override
    public CredentialValidationResult validate(Credential credential) {
        UsernamePasswordCredential login = (UsernamePasswordCredential) credential;
        //Optional<User> optionalUser = userService.findByUsernameAndPassword(login.getCaller(), login.getPasswordAsString());
        Optional<User> optionalUser = userService.FindByIdOpt(Integer.valueOf(login.getCaller()));
        if (optionalUser.isPresent()) {
            Set<String> perms = userService.findPermissionsForUser(optionalUser.get());
            perms.forEach(System.out::println);
            return new CredentialValidationResult(
                    optionalUser.get().getUserName(),
                    perms
            );
        }
        return CredentialValidationResult.INVALID_RESULT;
    }

}
