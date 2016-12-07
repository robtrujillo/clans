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

/**
 *
 * @author Chuntak
 */
public class DBSingletonTests {

    static String query = "call get_users(null,null)";

    public static void main(String[] args) {
        try {
            UsersDAO ud = new UsersDAO();
            UserModel dummyModel = new UserModel();
            dummyModel.setFirstName("Robert");
            ArrayList<UserModel> uml = ud.getUsers(dummyModel);
            for(UserModel um : uml){
                System.out.print(um.getLastName());
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }
}
