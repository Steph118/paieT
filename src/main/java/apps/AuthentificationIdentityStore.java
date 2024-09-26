package apps;

import classutils.UserPrincipal;
import entities.Role;
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
import java.util.Set;
import java.util.stream.Collectors;

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
            Set<String> roles = userService.findRolesForUser(user);
            return new CredentialValidationResult(
                    user.getUserName(),
                    roles
            );
        }

        return CredentialValidationResult.INVALID_RESULT;
    }

}
