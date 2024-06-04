package com.legodesk.poc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanAccountManagementController {

    @GetMapping("/manage")
    public String loanAccountManagement() {
        return "These returns all loan accounts privately!";
    }
}
