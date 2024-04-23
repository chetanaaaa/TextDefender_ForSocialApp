package com.ooad.twitwit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String username;
    private String password;
    private String email;

    // Private constructor to prevent instantiation from outside
    private Admin() {
    }

    public static class Builder {
        private Long adminId;
        private String username;
        private String password;
        private String email;

        public Builder() {
        }

        public Builder adminId(Long adminId) {
            this.adminId = adminId;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Admin build() {
            Admin admin = new Admin();
            admin.adminId = this.adminId;
            admin.username = this.username;
            admin.password = this.password;
            admin.email = this.email;
            return admin;
        }
    }

    // Getters and setters

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}