/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.controllers;

import com.clans.dao.UsersDAO;
import com.clans.models.UserModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author john
 */
@Controller
public class DefaultController {
    
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String index(ModelMap map) {
        try {
            UserModel user = new UserModel();
            ArrayList<UserModel> listUsers = new UsersDAO().getUsers(user);
            map.put("listUsers", listUsers);
            map.put("msg", "Hello Spring 4 Web MVC!");
        } catch (Exception e) {
            map.put("msg", e.toString());
        }
       return "index";
   }
    
}
