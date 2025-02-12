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
import jakarta.inject.Singleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        user = "mediasoft",
        password = "mediasoft"
)
@Singleton
@Startup
public class LoadDatabase {

    @Resource(lookup = "java:global/paie/paieDatasource")
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        System.err.println("LoadDatabase");
        this.executeUpdate("""
                           """);
    }

    private void executeUpdate(String query) {
        try (Connection connection = this.dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }

    @PreDestroy
    public void destroy() {
        try {
        } catch (Exception e) {

        }
    }

}
