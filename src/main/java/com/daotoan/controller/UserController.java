package com.daotoan.controller;

import com.daotoan.dao.UserDao;
import com.daotoan.entity.UserDB;
import com.daotoan.model.User;
import com.daotoan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/danh-sach-khach-hang")
    public ModelAndView allList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listUsers", userService.getAllUser());
        modelAndView.setViewName("listUsers");
        return modelAndView;
    }

    @GetMapping("/detail/{userId}")
    public ModelAndView detailUser(@PathVariable(name = "userId") int id) {
        User user = userService.getUser(id);
        return new ModelAndView("detailUser", "user", user);

    }

    @GetMapping("/addUserPage")
    public ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/addUser");
       modelAndView.addObject("user", new User());
        return modelAndView;

    }

    @PostMapping("/addUser")
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/danh-sach-khach-hang");
        return modelAndView;
    }

    @GetMapping("update/{userId}")
    public ModelAndView updateUser(@PathVariable(value = "userId") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userService.getUser(id));
        modelAndView.setViewName("/updateUser");
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute(name = "user") User user) {

        userService.updateUser(user);
        return "redirect:/danh-sach-khach-hang";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        userService.deleteUser(id);
        return "redirect:/danh-sach-khach-hang";
    }


}
