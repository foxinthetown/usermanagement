package com.usermanagement.app.controller;

import com.usermanagement.app.entiry.User;
import com.usermanagement.app.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/user/{user.id}/delete", method = RequestMethod
            .POST)
    public String deleteUser(@PathVariable("user.id") Long id,
                             final RedirectAttributes redirectAttributes) {
        logger.debug("deleteUser() : {}", id);
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/user/{id}/update", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "/updateuser";
    }

    @RequestMapping(value = "/user/{id}/update", method = RequestMethod.POST)
    public String updateUser(@PathVariable("id") Long id, HttpServletRequest
            parametersMap) {
        userService.updateUserInfoById(id, parametersMap.getParameter
                        ("email"),
                parametersMap.getParameter("phone"));
        return "/result";
    }

    @GetMapping("/")
    public String userForm(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping("/result")
    public String resultPage() {
        return "result";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody
    ModelAndView userSubmit(HttpServletRequest parametersMap) {
        User user = new User(parametersMap);
        userService.addUser(user);
        return new ModelAndView("redirect:/result");
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView workflowExceptionCaught(Exception ex,
                                                HttpServletRequest request,
                                                HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("code", response.getStatus());
        mav.addObject("exception", ex.getMessage());
        return mav;
    }
}

