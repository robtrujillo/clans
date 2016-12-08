/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.controllers;

import com.clans.dao.PagesDAO;
import com.clans.dao.UsersDAO;
import com.clans.models.PageModel;
import com.clans.models.UserModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Chuntak
 */
@Controller
public class UserController {

    @RequestMapping(value = "/userModel", method = RequestMethod.GET)
    public ModelAndView userModel() {
        return new ModelAndView("userModel", "command", new UserModel());
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ModelAttribute("ClansWebApp") UserModel user,
            ModelMap model) {
        try {
           
            if(user.getEmail().equals("") || user.getPassword().equals("")){
                model.put("user", user);
                return "index";
            }
            /* CHECK IF USER EXISTS */
            ArrayList<UserModel> ums = new UsersDAO().getUsers(user);
            if(ums.isEmpty()){
                model.put("user", user);
                return "index";
            }
            /* GET THE USER LOGGING IN */
            UserModel loggedUser = ums.get(0);
            /* USER LOGGED IN. RETURN THEIR PAGE DATA */
            PageModel userPage = new PagesDAO().getUserPage(loggedUser);
            model.put("page", userPage);
            return "user_page";
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("ClansWebApp") UserModel user,
            ModelMap model){
        try{
            if(!user.hasValues()){
                model.put("user",user);
                return "register";
            }
            new UsersDAO().updateUser(user);
            PageModel userPage = new PagesDAO().getUserPage(user);
            model.put("page", userPage);
            return "user_page";
        }
        catch(Exception ex){
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
        
    }
    
    @RequestMapping(value = "/updateUsers", method = RequestMethod.POST)
    public void updateUsers(@ModelAttribute("ClansWebApp") UserModel user){
        
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public String getUsers(@ModelAttribute("ClansWebApp") UserModel user,
            ModelMap model) {
        try {
            ArrayList<UserModel> listUsers = new UsersDAO().getUsers(user);
            model.put("listUsersV", listUsers);
            return "viewUsers";
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }

    public ModelAndView listUsers(ModelAndView model, @ModelAttribute UserModel user) throws SQLException, IOException {
        try {
            user = new UserModel();
            List<UserModel> listUsers = new UsersDAO().getUsers(user);
            model.addObject("listUsers", listUsers);
            model.setViewName("index");
            return model;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
