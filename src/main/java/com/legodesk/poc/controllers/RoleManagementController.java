package com.legodesk.poc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleManagementController {

    @GetMapping("/manage")
    public String rolesManagement() {
        return "These returns all roles privately!";
    }
}
