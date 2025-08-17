/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 *
 * @author steph18
 */
//@DataSourceDefinition(
//        name = "java:global/paie/paieDatasource",
//        className = "org.postgresql.jdbc2.optional.SimpleDataSource",
//        serverName = "localhost",
//        databaseName = "paie",
//        user = "mediasoft",
//        password = "mediasoft"
//)
//@Singleton
//@Startup
//@ApplicationScoped
public class LoadDatabase {

//    @Resource(lookup = "java:global/paie/paieDatasource")
//    private DataSource dataSource;

//    @Inject
//    private UserServiceLocal userService;

    @PostConstruct
    public void init() {
        System.err.println("LoadDatabase");
//        this.executeUpdate("""
//                           """);
    }
//
//    private void executeUpdate(String query) {
//        try (Connection connection = this.dataSource.getConnection()) {
//            try (PreparedStatement statement = connection.prepareStatement(query)) {
//                statement.executeUpdate();
//            }
//        } catch (Exception e) {
//            e.getMessage();
//        }
//
//    }

    @PreDestroy
    public void destroy() {
        try {
        } catch (Exception e) {

        }
    }

}
