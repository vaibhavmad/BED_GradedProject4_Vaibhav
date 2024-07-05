package com.greatlearning.emr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

  @GetMapping("/welcome")
  public String displayWelcomeMessage() {
    return "Welcome to the Employee Management REST API";
  }
  
  @GetMapping("/")
  public String defaultApplicationHomePage() {
      return "redirect:/api/employees/list";
  }  
}
