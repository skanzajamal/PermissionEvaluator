package com.security;

import org.apache.maven.artifact.repository.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityMethods {


    Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
    String currentPrincipalName = authentication.getUsername();


    public boolean canRead(String currentPrincipalName) {
        return currentPrincipalName.equals("admin");
    }

    public boolean canWrite(String currentPrincipalName) {
        return currentPrincipalName.equals("admin");
    }

}
