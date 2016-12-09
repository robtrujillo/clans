/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.controllers;

import com.clans.dao.AccountsDAO;
import com.clans.dao.AdDAO;
import com.clans.dao.EmployeesDAO;
import com.clans.dao.SalesDAO;
import com.clans.models.AccountModel;
import com.clans.models.AdModel;
import com.clans.models.EmployeeModel;
import com.clans.models.PageModel;
import com.clans.models.SaleModel;
import com.clans.models.UserModel;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
     @RequestMapping(value = "/createSales", method = RequestMethod.GET)
    public @ResponseBody
    boolean updateAd(@ModelAttribute("ClansWebApp") SaleModel sm,
            ModelMap model) {        
        try {
            new SalesDAO().updateSales(sm);
            return true;            
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
     @RequestMapping(value = "/changeAccount", method = RequestMethod.GET)
    public @ResponseBody
    boolean changeAccount(@ModelAttribute("ClansWebApp") AccountModel am) {        
        try {
            new AccountsDAO().updateAccounts(am);
            return true;            
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    @RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
    public @ResponseBody
    boolean deleteAccount(@ModelAttribute("ClansWebApp") AccountModel am) {        
        try {
            new AccountsDAO().deleteAccount(am);
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    
    
    
    @RequestMapping(value = "/byeAd", method = RequestMethod.GET)
    public @ResponseBody
    boolean deleteAd(@ModelAttribute("ClansWebApp") AdModel ad) {        
        try {
            new AdDAO().deleteAdvertisements(ad);
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }
    
    @RequestMapping(value = "/getMailingList", method = RequestMethod.GET)
    public @ResponseBody ArrayList<UserModel> getMailingList() {
        try {            
            return new EmployeesDAO().getMailingList();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @RequestMapping(value = "/getSuggestion", method = RequestMethod.GET)
    public @ResponseBody ArrayList<AdModel> getSuggestion(@ModelAttribute("ClansWebApp") AccountModel acm) {
        try {            
            return new AdDAO().getSuggestion(acm);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    @RequestMapping(value = "/getAllAds", method = RequestMethod.GET)
    public @ResponseBody ArrayList<AdModel> getAllAds() {
        try {
            ArrayList<AdModel> allAds = new AdDAO().getAllAd();
            return allAds;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    @RequestMapping(value = "/getAllAcct", method = RequestMethod.GET)
    public @ResponseBody ArrayList<AccountModel> getAllAcct() {
        try {
            ArrayList<AccountModel> allAcc = new AccountsDAO().getAllAccounts();
            return allAcc;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
