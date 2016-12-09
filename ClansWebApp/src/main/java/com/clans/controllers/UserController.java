/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.controllers;

import com.clans.dao.EmployeesDAO;
import com.clans.dao.PagesDAO;
import com.clans.dao.UsersDAO;
import com.clans.models.EmployeeModel;
import com.clans.models.GroupModel;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

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
            ModelMap model, HttpSession session) {
        try {

            if (user.getEmail().equals("") || user.getPassword().equals("")) {
                model.put("user", user);
                return "index";
            }
            /* CHECK IF USER EXISTS */
            ArrayList<UserModel> ums = new UsersDAO().getUsers(user);
            if (ums.isEmpty()) {
                model.put("user", user);
                return "index";
            }
            /* GET THE USER LOGGING IN */
            UserModel loggedUser = ums.get(0);
            if (loggedUser.isIsEmployee()) {
                loggedUser = new EmployeesDAO().getEmployeeModelById(loggedUser.getUserId());
                model.put("employee", loggedUser);
                session.setAttribute("user_data", loggedUser);
                if (((EmployeeModel) loggedUser).isIsManager()) {
                    return "manager_page";
                }
                return "employee_page";
            } else {
                /* USER LOGGED IN. RETURN THEIR PAGE DATA */
                loggedUser.setSignedIn(true);
                new UsersDAO().updateUser(loggedUser);
                PageModel userPage = new PagesDAO().getUserPage(loggedUser);
                model.put("page", userPage);
                session.setAttribute("user_data", loggedUser);
                return "user_page";
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(@ModelAttribute("ClansWebApp") UserModel user, ModelMap model, HttpSession session) {
        try {

            /* UPDATE USER AND RETURN TO LOGIN PAGE */
            UserModel loggedOutUser = (UserModel)session.getAttribute("user_data");
            loggedOutUser.setSignedIn(false);
            new UsersDAO().updateUser(loggedOutUser);
            model.put("user", user);
            return "index";

        } catch (Exception e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
        }
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("ClansWebApp") UserModel user,
            ModelMap model) {
        try {
            if (!user.hasValues()) {
                model.put("user", user);
                return "register";
            }
            new UsersDAO().updateUser(user);
            PageModel userPage = new PagesDAO().getUserPage(user);
            model.put("page", userPage);
            return "user_page";
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";

    }

    @RequestMapping(value = "/saveUsers", method = RequestMethod.GET)
    public @ResponseBody
    boolean updateUsers(@ModelAttribute("ClansWebApp") UserModel user) {
        try {
            new UsersDAO().updateUser(user);
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
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

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<UserModel> getAllUsers(@ModelAttribute("ClansWebApp") UserModel user) {
        try {
            ArrayList<UserModel> listUsers = new UsersDAO().getUsers(user);
            return listUsers;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @RequestMapping(value = "/sessionVar", method = RequestMethod.GET)
    public @ResponseBody boolean sessionVar(@ModelAttribute("ClansWebApp") UserModel user,
            ModelMap model, HttpSession session) {
        try {
            
                session.setAttribute("other_user", user);
                return true;

        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @RequestMapping(value = "/switchUserPage", method = RequestMethod.GET)
    public String switchPage(@ModelAttribute("ClansWebApp") UserModel user, ModelMap model, HttpSession session) {
        try {
            UserModel me = (UserModel)session.getAttribute("user_data");
            UserModel other = (UserModel)session.getAttribute("other_user");
            /* CHECK IF SWITCHING TO OWN PAGE */
            if(me.getUserId()==other.getUserId()){
                model.put("user", me);
                PageModel userPage = new PagesDAO().getUserPage(me);
                model.put("page", userPage);
                return "user_page";
            }
            else{
                /* GOING TO OTHER USER'S PAGE */
                PageModel userPage = new PagesDAO().getUserPage(other);
                userPage.setGroup(new GroupModel());
                userPage.getGroup().setUserId(me.getUserId());
                model.put("page", userPage);
                return "other_user_page";
            }

        } catch (Exception e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
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
