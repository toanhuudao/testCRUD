package com.daotoan.controller;
import com.daotoan.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    @GetMapping("/")
    public ModelAndView home(){
        return new ModelAndView("home","user",new User());
    }

    @PostMapping("/them-user")
    public ModelAndView addUser(@ModelAttribute ("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(user);
        modelAndView.setViewName("display");

        File newFile=new File("D:\\gitproject\\saveFile\\"+user.getAvatar().getOriginalFilename());
        try (FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {
          fileOutputStream.write(user.getAvatar().getBytes());
          fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return modelAndView;
    }

    @GetMapping("/up-load")
    public ModelAndView upload(){

        return new ModelAndView("upload");
    }

    @PostMapping("/upload-file")
    public ModelAndView upload(@RequestParam(name = "file")MultipartFile file){
        ModelAndView modelAndView=new  ModelAndView("viewFile","file",file);
        //save file
        File newFile=new File("D:\\gitproject\\saveFile\\"+file.getOriginalFilename());
        try (FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {
          fileOutputStream.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return modelAndView;

    }


}
