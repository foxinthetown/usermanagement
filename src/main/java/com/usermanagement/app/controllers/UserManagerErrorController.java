package com.usermanagement.app.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserManagerErrorController implements ErrorController {

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String updateUser() {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
