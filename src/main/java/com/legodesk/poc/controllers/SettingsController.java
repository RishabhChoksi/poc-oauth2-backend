package com.legodesk.poc.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/settings")
public class SettingsController {

    @GetMapping("/manage")
    public String settingsManagement() {
        return "These returns all settings privately!";
    }
}
