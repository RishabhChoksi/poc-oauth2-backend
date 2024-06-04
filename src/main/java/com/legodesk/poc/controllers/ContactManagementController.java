package com.legodesk.poc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactManagementController {

    @GetMapping("/manage")
    public String contactsManagement() {
        return "These returns all contacts privately!";
    }
}
