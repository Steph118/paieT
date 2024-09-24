/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apps;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.enterprise.inject.spi.InterceptionFactory;
import jakarta.faces.annotation.FacesConfig;
import jakarta.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import jakarta.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanismWrapper;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.security.enterprise.authentication.mechanism.http.RememberMe;
import jakarta.ws.rs.Produces;
import java.util.stream.Collectors;

/**
 *
 * @author steph18
 */
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/login.xhtml",
                useForwardToLogin = true,
                errorPage = ""
        )
)
//@DatabaseIdentityStoreDefinition(
//        dataSourceLookup = "${'java:app/jdbc/paie'}",
//        callerQuery = "select password from users where username = ?",
//        groupsQuery = "select label from roles where id IN (select role_id from users_roles where user_id = (select id from users where username = ? ))",
//        priority = 100,
//        hashAlgorithmParameters = {
//            "Pbkdf2PasswordHash.Iterations=3072",
//            "Pbkdf2PasswordHash.Algorithm=PBKDF2WithHmacSHA512",
//            "Pbkdf2PasswordHash.SaltSizeBytes=64"
//        }
//)
@ApplicationScoped
@FacesConfig
@Alternative
@Priority(500)
public class ApplicationConfig {

    @Produces
    public HttpAuthenticationMechanism produceAuthenticationMechanism(
            InterceptionFactory<HttpAuthenticationMechanismWrapper> interceptionFactory,
            BeanManager beanManager) {

        @RememberMe(
                cookieMaxAgeSeconds = 10
        )
        class RememberMeClass {
        }

        interceptionFactory.configure().add(RememberMeClass.class.getAnnotation(RememberMe.class));
        return interceptionFactory.createInterceptedInstance(
                new HttpAuthenticationMechanismWrapper(
                        (HttpAuthenticationMechanism) beanManager
                                .getReference(
                                        beanManager.resolve(
                                                beanManager.getBeans(HttpAuthenticationMechanism.class).stream()
                                                        .filter(b -> b.getBeanClass() != ApplicationConfig.class)
                                                        .collect(Collectors.toSet())
                                        ),
                                        HttpAuthenticationMechanism.class,
                                        beanManager.createCreationalContext(null))));

    }

    public String[] getHash() {
        return new String[]{
            "Pbkdf2PasswordHash.Algorithm=PBKDF2WithHmacSHA512",
            "Pbkdf2PasswordHash.SaltSizeBytes=64"};
    }

}
