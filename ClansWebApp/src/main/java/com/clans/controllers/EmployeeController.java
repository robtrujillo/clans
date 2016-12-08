/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.controllers;

import com.clans.dao.AdDAO;
import com.clans.models.AdModel;
import com.clans.models.EmployeeModel;
import com.clans.models.PageModel;
import com.clans.models.UserModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Chuntak
 */
@Controller
public class EmployeeController {
    
    @RequestMapping(value = "/employeeModel", method = RequestMethod.GET)
    public ModelAndView employeeModel() {
        return new ModelAndView("employeeModel", "command", new EmployeeModel());
    }
    
    @RequestMapping(value = "/createAd", method = RequestMethod.GET)
    public @ResponseBody
    boolean updateAd(@ModelAttribute("ClansWebApp") AdModel ad,
            ModelMap model) {        
        try {
            if (ad.getContent() == null || ad.getContent().equals("")) {
                return true;
            } else {
                new AdDAO().updateAdvertisements(ad);
                return true;
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
}
