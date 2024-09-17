/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apps;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

/**
 *
 * @author steph18
 */
@DataSourceDefinition(
        name = "java:global/paie/paieDatasource",
        className = "org.postgresql.jdbc2.optional.SimpleDataSource",
        serverName = "localhost",
        databaseName = "paie",
        user = "steph18",
        password = "Etuh9dvwpfsp"
)
@Singleton
@Startup
public class LoadDatabase {

    @Resource(lookup = "java:global/paie/paieDatasource")
    private DataSource dataSource;

    @Inject
    private Pbkdf2PasswordHash passwordHash;

    @PostConstruct
    public void init() {
        System.err.println("444444444444444444444");
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Pbkdf2PasswordHash.Iterations", "3072");
        parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
        parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        passwordHash.initialize(parameters);
        executeUpdate(dataSource, """
                          
                          """);
        executeUpdate(dataSource, """
                                  lllll
                          """);
        executeUpdate(dataSource, """
                                  kkkkk
                          """);
    }

    private void executeUpdate(DataSource dataSource, String query) {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.executeUpdate();
            }
        } catch (Exception e) {
        }

    }

    @PreDestroy
    public void destroy() {
        try {
            executeUpdate(dataSource, "DROP TABLE IF EXISTS users");
            executeUpdate(dataSource, "DROP TABLE IF EXISTS roles");
        } catch (Exception e) {

        }
    }

}
