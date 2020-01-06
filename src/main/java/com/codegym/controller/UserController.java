package com.codegym.controller;

import com.codegym.model.Users;
import com.codegym.model.UsersForm;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Controller
@PropertySource("classpath:global_config_app.properties")
@RequestMapping("users/")

public class UserController {
    @Autowired
    Environment env;

  @Autowired
  IUserService userService;

    @RequestMapping("/list")
    public ModelAndView getAllProduct() {

        List<Users> users = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("/users/list");
        modelAndView.addObject("users", users);

        return modelAndView;
    }

    @PostMapping("/login-invalid")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
        List<Users> users = userService.findAll();
        boolean check = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(username) && users.get(i).getPhone().equals(password)) {
                check = true;
            }
        }
        if (check == true) {
            ModelAndView modelAndView = new ModelAndView("/users/list");
            modelAndView.addObject("users", users);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/users/home");
            modelAndView.addObject("loginFailed", "Email or your Phone Number was incorrect");
            return modelAndView;
        }
    }

    @RequestMapping("/login-home")
    public ModelAndView showHome() {
        ModelAndView modelAndView = new ModelAndView("/users/home");
        modelAndView.addObject("users", new Users());
        return modelAndView;
    }
    @RequestMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/users/create");
        modelAndView.addObject("usersForm", new UsersForm());
        return modelAndView;
    }

    @RequestMapping("save-product")
    public ModelAndView saveProduct(@ModelAttribute("usersForm") UsersForm usersForm, BindingResult result) {
        MultipartFile multipartFile = usersForm.getImg();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();

        try {
            FileCopyUtils.copy(usersForm.getImg().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Users users1 = new Users(usersForm.getName(),usersForm.getEmail(),usersForm.getAddress(),usersForm.getDoB(),usersForm.getPhone(),fileName);
        userService.add(users1);
        ModelAndView modelAndView = new ModelAndView("/users/create");
        modelAndView.addObject("message", "create user successfully");
        modelAndView.addObject("users", new Users());
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewPhoneDetail(@PathVariable("id") int id) {
        Users users = userService.findById(id);

        ModelAndView modelAndView = new ModelAndView("/users/view");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeletePhoneForm(@PathVariable("id") int id) {
            Users users = userService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/users/delete");
            modelAndView.addObject("users", users);
            return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deletedPhone(@ModelAttribute("users") Users users) {
        userService.remove(users.getId());

        ModelAndView modelAndView = new ModelAndView("/users/delete");
        modelAndView.addObject("users", users);
        modelAndView.addObject("message", "book delete successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Users users = userService.findById(id);
        if (users != null) {
            UsersForm usersForm = new UsersForm(users.getName(),users.getEmail(),users.getAddress(),users.getDoB(),users.getPhone(),null);
            ModelAndView modelAndView = new ModelAndView("/users/edit");
            modelAndView.addObject("usersForm", usersForm);
            modelAndView.addObject("users", users);

            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/users/errorLogin");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView saveEdited( @ModelAttribute("usersForm") UsersForm usersForm) {

        MultipartFile multipartFile = usersForm.getImg();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();

        try {
            FileCopyUtils.copy(usersForm.getImg().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Users users = new Users(usersForm.getName(), usersForm.getEmail(), usersForm.getAddress(),
                usersForm.getDoB(), usersForm.getPhone(), fileName);

        userService.editUsers(users.getId(),users);

        ModelAndView modelAndView = new ModelAndView("/users/edit");
        modelAndView.addObject("usersForm", usersForm);
        modelAndView.addObject("message", "users updated successfully");
        return modelAndView;
    }




}
