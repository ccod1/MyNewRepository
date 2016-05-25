package com.project2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project2.model.UserDetail;
import com.project2.service.UserDetailService;



@Controller
public class UserRegisterationController {
    @Autowired
    private UserDetailService usersDetailService;
    /*
     * registerUser method is used to open user registration form
     */
    @RequestMapping("/Register")
    public String registerUser(Model model) {

    	UserDetail usersDetail = new UserDetail();
       

        model.addAttribute("usersDetail", usersDetail);

        return "Register";

    }
    /*
     * registerUserPost method is used to register user into  the system and to show registration related errors
     */
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public String registerUserPost(@Valid @ModelAttribute("usersDetail") UserDetail usersDetail, BindingResult result,
                                       Model model) {

        if (result.hasErrors()) {
            return "Register";
        }

        List<UserDetail> usersDetailList=usersDetailService.getAllUsers();

        for (int i=0; i< usersDetailList.size(); i++) {
            if(usersDetail.getUserEmail().equals(usersDetailList.get(i).getUserEmail())) {
                model.addAttribute("emailMsg", "Email already exists");

                return "Register";
            }

            if(usersDetail.getUsername().equals(usersDetailList.get(i).getUsername())) {
                model.addAttribute("usernameMsg", "Username already exists");

                return "Register";
            }
        }

     //   usersDetail.setEnabled(true);
        usersDetailService.addUser(usersDetail);

        return "AddUserSuccess";

    }
}

