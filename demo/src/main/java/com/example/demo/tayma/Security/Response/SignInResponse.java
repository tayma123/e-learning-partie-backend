package com.example.demo.tayma.Security.Response;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public  class SignInResponse {
    private String token;
    private String type = "Bearer";
    private String userName;
    private Collection<? extends GrantedAuthority> authorities;

    public SignInResponse(String accessToken, String userName, Collection<? extends GrantedAuthority> authorities) {
        this.token = accessToken;
        this.userName = userName;
        this.authorities = authorities;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}