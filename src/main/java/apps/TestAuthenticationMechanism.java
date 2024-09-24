package apps;

//import jakarta.enterprise.context.RequestScoped;
//import jakarta.inject.Inject;
//import jakarta.security.auth.message.AuthException;
//import jakarta.security.enterprise.AuthenticationException;
//import jakarta.security.enterprise.AuthenticationStatus;
//import jakarta.security.enterprise.authentication.mechanism.http.AutoApplySession;
//import jakarta.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
//import jakarta.security.enterprise.authentication.mechanism.http.HttpMessageContext;
//import jakarta.security.enterprise.credential.Password;
//import jakarta.security.enterprise.credential.UsernamePasswordCredential;
//import jakarta.security.enterprise.identitystore.CredentialValidationResult;
//import jakarta.security.enterprise.identitystore.IdentityStore;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import static jakarta.security.enterprise.identitystore.CredentialValidationResult.Status.VALID;
//@RequestScoped
//@AutoApplySession
public class TestAuthenticationMechanism /*implements HttpAuthenticationMechanism*/ {

//    @Inject
//    private IdentityStore identityStore;
//
//    @Override
//    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response,
//            HttpMessageContext httpMessageContext) throws AuthenticationException {
//        if (isAnyNull(request.getParameter("name"), request.getParameter("password"))) {
//            return httpMessageContext.doNothing();
//        }
//        String name = request.getParameter("name");
//        Password password = new Password(request.getParameter("password"));
//        CredentialValidationResult result = identityStore.validate(new UsernamePasswordCredential(name, password));
//        if (result.getStatus() != VALID) {
//            try {
//                throw new AuthException("Login failed");
//            } catch (AuthException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return httpMessageContext.notifyContainerAboutLogin(result.getCallerPrincipal(), result.getCallerGroups());
//    }
//
//    private boolean isAnyNull(Object... objects) {
//        for (Object object : objects) {
//            if (object == null) {
//                return true;
//            }
//        }
//        return false;
//    }
}
