package com.legodesk.poc.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "")
@RestController
public class PublicController {

    @GetMapping("/advertisement")
    public String advertiseCars() {
        return "This is a public endpoint!";
    }
}
