package com.example.test.controller;

import com.example.test.model.AppUser;
import com.example.test.model.Login;
import com.example.test.service.user.IAppUserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IAppUserService appUserService;
    @GetMapping("")
    public ModelAndView showAll(){
        ModelAndView modelAndView = new ModelAndView("list");
        List<AppUser> appUserList = appUserService.showAll();
        modelAndView.addObject("list",appUserList);
        return modelAndView;
    }
//    public ResponseEntity<List<AppUser>> showAllUser(){
//        return new ResponseEntity<>(appUserService.showAll(), HttpStatus.OK);
//    }
    @GetMapping("/create")
    public ModelAndView requestCreateUser(){
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createUser(@RequestParam Long id, String username, String password, String avatar,String email){
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        AppUser appUser = new AppUser(id,username, password,email,avatar);
        appUserService.create(appUser);
        return modelAndView;
    }
//    public ResponseEntity<AppUser> createUser(@RequestBody AppUser user){
//        appUserService.create(user);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
