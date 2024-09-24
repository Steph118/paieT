/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.RepositoryDao;
import dao.UserDao;
import entities.User;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import service.interfaces.UserServiceLocal;

/**
 * @author steph18
 */
@Stateless
public class UserService extends GenericServiceLocalImpl<User, Integer> implements UserServiceLocal {

    @EJB
    private UserDao dao;

    @Inject
    private Pbkdf2PasswordHash passwordHash;

    @Override
    protected RepositoryDao<User, Integer> getDAO() {
        return dao;
    }

    @Override
    public void save(User e) {
        e.setPassword(this.hashPassword(e.getPassword()));
        super.save(e);
    }

    @Override
    public User update(User e) {
        e.setPassword(this.hashPassword(e.getPassword()));
        return super.update(e);
    }

    @Override
    public String hashPassword(String password) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Pbkdf2PasswordHash.Iterations", "3072");
        parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
        parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        passwordHash.initialize(parameters);
        return passwordHash.generate(password.toCharArray());
    }

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        User user = dao.findByUsername(username);
        if (user == null) {
            return Optional.empty();
        }
        if (passwordHash.verify(password.toCharArray(), user.getPassword())) {
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public Set<String> findRolesForUser(User user) {
        return this.dao.findRolesForUser(user);
    }

    @Override
    public User findByUsername(String username) {
        return this.dao.findByUsername(username);
    }

}
