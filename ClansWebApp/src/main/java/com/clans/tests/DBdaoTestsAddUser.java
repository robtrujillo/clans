/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.tests;

import com.clans.dao.DBSingleton;
import com.clans.dao.UsersDAO;
import com.clans.models.UserModel;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chuntak
 */
public class DBdaoTestsAddUser {


    public static void main(String[] args) {
        UserModel um = new UserModel();
        um.setUserId(15);
//        um.setFirstName("Susan");
//        um.setLastName("Lin");
//        um.setCity("StonyBrook");
//        um.setCountry("United States");
        um.setEmail("Susan@gmail.com");
//        um.setPassword("1230");
//        um.setState("NY");
//        um.setZipcode(12345);
//        um.setStreet("999 Circle Road");
//        um.setSex("F");
//        um.setIsEmployee(false);
//        um.setPhoneNum("1234567890");
        try {
            new UsersDAO().updateUser(um);
            System.out.print("SUCCESS");
        } catch (SQLException ex) {
            Logger.getLogger(DBdaoTestsAddUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBdaoTestsAddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
