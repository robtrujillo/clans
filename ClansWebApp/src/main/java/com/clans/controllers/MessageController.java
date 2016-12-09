/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.controllers;

import com.clans.dao.MessagesDAO;
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
public class MessageController {
    
    @RequestMapping(value = "/messageModel", method = RequestMethod.GET)
    public ModelAndView messageModel() {
        return new ModelAndView("messageModel", "command", new MessageModel());
    }
    
    @RequestMapping(value = "/saveMessage", method = RequestMethod.GET)
    public @ResponseBody boolean updateMessage(@ModelAttribute("ClansWebApp") MessageModel message){
        try{
            if(message.getContent() == null && message.getContent().equals("")){
                return true;
            }
            new MessagesDAO().updateMessages(message);
            return true;
            
        }
        catch(SQLException | ClassNotFoundException e){
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    @RequestMapping(value = "/getMessages", method = RequestMethod.GET)
    public @ResponseBody ArrayList<UserModel> getMessages(@ModelAttribute("ClansWebApp") UserModel user){
        try{
            
            return new MessagesDAO().getMessagees(user);
            
            
        }
        catch(SQLException | ClassNotFoundException e){
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    @RequestMapping(value = "/getConvos", method = RequestMethod.GET)
    public @ResponseBody ArrayList<MessageModel> getConversation(@ModelAttribute("ClansWebApp") MessageModel message){
        try{
            
            return new MessagesDAO().getConversation(message);
           
        }
        catch(SQLException | ClassNotFoundException e){
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    @RequestMapping(value = "/byeMessage", method = RequestMethod.GET)
    public @ResponseBody boolean deleteMessage(@ModelAttribute("ClansWebApp") MessageModel message){
        try{
            
             new MessagesDAO().deleteMessage(message);
             return true;
        }
        catch(SQLException | ClassNotFoundException e){
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
