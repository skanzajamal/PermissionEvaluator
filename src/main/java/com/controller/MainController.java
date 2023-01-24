package com.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/permission/read/{userName}")
    @PreAuthorize("#SecurityMethods.canRead(#userName)")
    public boolean readPermission(@PathVariable @P("userName") String userName){
        return userName.equals("admin");
    }

    @RequestMapping("/permission/write/{userName}")
    @PreAuthorize("#SecurityMethods.canWrite(#userName)")
    public boolean writePermission(@PathVariable @P("userName") String userName){
        return userName.equals("admin");
    }

}
