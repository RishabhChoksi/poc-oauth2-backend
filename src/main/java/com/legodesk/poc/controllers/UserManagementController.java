package com.legodesk.poc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserManagementController {

    @GetMapping("/manage")
    public String userManagement() {
        return "These returns all users privately!";
    }
}
