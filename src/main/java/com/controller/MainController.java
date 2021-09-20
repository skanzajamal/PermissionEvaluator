package com.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/permission/{userName}")
    @PreAuthorize("#permissions.canRead(#userName)")
    public boolean getPermissionRead(@PathVariable @P("userName") String userName){
        return userName.equals("admin");
    }

    @RequestMapping("/permission/{userName}")
    @PreAuthorize("#permissions.canWrite(#userName)")
    public boolean getPermissionWrite(@PathVariable @P("userName") String userName){
        return userName.equals("admin");
    }

}
