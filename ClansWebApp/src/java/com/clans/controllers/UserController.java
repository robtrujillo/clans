/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.controllers;

import com.clans.dao.UsersDAO;
import com.clans.models.UserModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Chuntak
 */
@Controller
public class UserController {
    
    //@Autowired
    @RequestMapping(value="/")
    public ModelAndView listUsers(ModelAndView model, @ModelAttribute UserModel user) throws SQLException, IOException{
        try{
            user = new UserModel();
            List<UserModel> listUsers = new UsersDAO().getUsers(user);
            model.addObject("listUsers", listUsers);
            model.setViewName("index");
            return model;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
