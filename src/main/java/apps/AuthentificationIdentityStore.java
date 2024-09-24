package apps;

import entities.User;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.authentication.mechanism.http.AutoApplySession;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import service.interfaces.UserServiceLocal;

import java.util.Optional;

@ApplicationScoped
@AutoApplySession
public class AuthentificationIdentityStore implements IdentityStore {

    @EJB
    private UserServiceLocal userService;

    @Override
    public CredentialValidationResult validate(Credential credential) {
        UsernamePasswordCredential login = (UsernamePasswordCredential) credential;
        Optional<User> optionalUser = userService.findByUsernameAndPassword(login.getCaller(), login.getPasswordAsString());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setRolesStr(userService.findRolesForUser(user));
            return new CredentialValidationResult(
                    user.getUserName(),
                    user.getRolesStr()
            );
        }

        return CredentialValidationResult.INVALID_RESULT;
    }

}
