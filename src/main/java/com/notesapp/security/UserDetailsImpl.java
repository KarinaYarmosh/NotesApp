package com.notesapp.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    private UserDetailsImpl() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public static class UserDetailsBuilder{

        private String username;
        private String password;
        private Collection<? extends GrantedAuthority> authorities;
        private boolean accountNonExpired = true;
        private boolean accountNonLocked = true;
        private boolean credentialsNonExpired = true;
        private boolean enabled = true;

        public UserDetailsBuilder() {
        }

        public UserDetailsBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserDetailsBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserDetailsBuilder setAuthorities(Collection<? extends GrantedAuthority> authorities) {
            this.authorities = authorities;
            return this;
        }

        public UserDetailsBuilder setAccountNonExpired(boolean accountNonExpired) {
            this.accountNonExpired = accountNonExpired;
            return this;
        }

        public UserDetailsBuilder setAccountNonLocked(boolean accountNonLocked) {
            this.accountNonLocked = accountNonLocked;
            return this;
        }

        public UserDetailsBuilder setCredentialsNonExpired(boolean credentialsNonExpired) {
            this.credentialsNonExpired = credentialsNonExpired;
            return this;
        }

        public UserDetailsBuilder setEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public UserDetailsImpl build(){
            UserDetailsImpl userDetails = new UserDetailsImpl();
            userDetails.username = this.username;
            userDetails.password = this.password;
            userDetails.authorities = this.authorities;
            userDetails.accountNonExpired = this.accountNonExpired;
            userDetails.accountNonLocked = this.accountNonLocked;
            userDetails.credentialsNonExpired = this.credentialsNonExpired;
            userDetails.enabled = this.enabled;
            return userDetails;
        }

    }
}
