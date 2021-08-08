package com.example.demo.tayma.Entities;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

public enum Role implements GrantedAuthority {
    APPRENANT,SUPERADMIN,ADMIN,FORMATEUR,ADMINISTRATIF;


    @Override
    public String getAuthority() {
        return null;
    }
}
