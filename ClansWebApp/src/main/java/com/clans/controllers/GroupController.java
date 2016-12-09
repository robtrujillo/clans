/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.controllers;

import com.clans.dao.GroupDAO;
import com.clans.dao.MessagesDAO;
import com.clans.models.GroupModel;
import com.clans.models.MessageModel;
import com.clans.models.UserModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rvtru
 */
@Controller
public class GroupController {
    
    @RequestMapping(value = "/groupModel", method = RequestMethod.GET)
    public ModelAndView groupModel() {
        return new ModelAndView("groupModel", "command", new GroupModel());
    }
    
    @RequestMapping(value = "/getGroups", method = RequestMethod.GET)
    public @ResponseBody ArrayList<GroupModel> getGroups(@ModelAttribute("ClansWebApp") GroupModel group){
        try{
            
            return new GroupDAO().getGroups(group);
            
            
        }
        catch(SQLException | ClassNotFoundException e){
            Logger.getLogger(GroupController.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    @RequestMapping(value = "/saveGroup", method = RequestMethod.GET)
    public @ResponseBody boolean updateGroups(@ModelAttribute("ClansWebApp") GroupModel group){
        try{
            
            new GroupDAO().updateGroup(group);
            return true;
            
        }
        catch(SQLException | ClassNotFoundException e){
            Logger.getLogger(GroupController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    @RequestMapping(value = "/byeGroup", method = RequestMethod.GET)
    public @ResponseBody boolean deleteGroup(@ModelAttribute("ClansWebApp") GroupModel group){
        try{
            
             new GroupDAO().deleteGroup(group);
             return true;
        }
        catch(SQLException | ClassNotFoundException e){
            Logger.getLogger(GroupController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
