/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apps;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author steph18
 */
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/login.xhtml",
                useForwardToLogin = false,
                errorPage = ""
        )
)
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "${'java:app/jdbc/paie'}",
        callerQuery = "select password from users where username = ?",
        groupsQuery = "select label from roles where id IN (select role_id from users_roles where user_id = (select id from users where username = ? ))",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 100,
        hashAlgorithmParameters = {
            "Pbkdf2PasswordHash.Iterations=3072",
            "Pbkdf2PasswordHash.Algorithm=PBKDF2WithHmacSHA512",
            "Pbkdf2PasswordHash.SaltSizeBytes=64"
        }
)
@ApplicationScoped
@FacesConfig
public class ApplicationConfig {

//    public String[] getHash() {
//        return new String[]{
//            "Pbkdf2PasswordHash.Algorithm=PBKDF2WithHmacSHA512",
//            "Pbkdf2PasswordHash.SaltSizeBytes=64"};
//    }

}
