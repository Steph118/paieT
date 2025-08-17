/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import enumeration.EmailProvider;
import jakarta.persistence.*;

import java.util.Objects;

/**
 *
 * @author steph18
 */
@Entity
@Table(name = "email_config")
@NamedQueries({
        @NamedQuery(name = "EmailConfig.findByActiveAndProvider",
                query = "SELECT e FROM EmailConfig e WHERE e.provider = :provider AND e.active = true"),
        @NamedQuery(name = "EmailConfig.findByProvider",
                query = "SELECT e FROM EmailConfig e WHERE e.provider = :provider")
})
public class EmailConfig extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "provider", unique = true)
    @Enumerated
    private EmailProvider provider;

    private String host;

    private int port;

    private String username;

    private String password;

    @Column(name = "default_from")
    private String defaultFrom;

    @Column(name = "auth_enabled")
    private boolean authEnabled;

    @Column(name = "ssl_emabled")
    private boolean sslEnabled;

    private boolean active;

    public EmailConfig() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmailProvider getProvider() {
        return provider;
    }

    public void setProvider(EmailProvider provider) {
        this.provider = provider;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDefaultFrom() {
        return defaultFrom;
    }

    public void setDefaultFrom(String defaultFrom) {
        this.defaultFrom = defaultFrom;
    }

    public boolean isAuthEnabled() {
        return authEnabled;
    }

    public void setAuthEnabled(boolean authEnabled) {
        this.authEnabled = authEnabled;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isSslEnabled() {
        return sslEnabled;
    }

    public void setSslEnabled(boolean sslEnabled) {
        this.sslEnabled = sslEnabled;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmailConfig other = (EmailConfig) obj;
        return Objects.equals(this.id, other.id);
    }

}
