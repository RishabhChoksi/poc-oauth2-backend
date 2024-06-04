package com.legodesk.poc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/campaigns")
public class CampaignManagementController {

    @GetMapping("/manage")
    public String campaignsManagement() {
        return "These returns all campaigns privately!";
    }
}
