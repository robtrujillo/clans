/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.dao;

import com.clans.models.UserModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Chuntak
 */
public class UsersDAO {

    DBSingleton dbs;

    public UsersDAO() throws SQLException, ClassNotFoundException {
        dbs = DBSingleton.getSingleton();
    }
    
    public void updateUser(UserModel user) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = dbs.getPreparedStatement("call update_users(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, user.getUserId());
        ps.setString(2, user.getFirstName());
        ps.setString(3, user.getLastName());
        ps.setString(4, user.getSex());
        ps.setString(5, user.getEmail());
        ps.setString(6, user.getPassword());
        ps.setString(7, user.getPhoneNum());
        ps.setString(8, user.getStreet());
        ps.setString(9, user.getCity());
        ps.setInt(10, user.getZipcode());
        ps.setString(11, user.getState());
        ps.setString(12, user.getCountry());
        ps.setBoolean(13, false);
        ps.setBoolean(14, user.isSignedIn());
    }

    public ArrayList<UserModel> getUsers(UserModel user) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = dbs.getPreparedStatement("call get_users(?,?,?,?)");
        ps.setInt(1, user.getUserId());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getFirstName() != null ? user.getFirstName() : user.getLastName());
        return getUsersArray(ps.executeQuery());
    }

    private ArrayList<UserModel> getUsersArray(ResultSet rs) throws SQLException {
        ArrayList<UserModel> al = new ArrayList<UserModel>();
        while (rs.next()) {
            UserModel um = new UserModel();
            um.setUserId(rs.getInt("UserId"));
            um.setFirstName(rs.getString("FirstName"));
            um.setLastName(rs.getString("LastName"));
            um.setPassword(rs.getString("Pass"));
            um.setPhoneNum(rs.getString("PhoneNum"));
            um.setStreet(rs.getString("Street"));
            um.setCity(rs.getString("City"));
            um.setZipcode(rs.getInt("ZipCode"));
            um.setState(rs.getString("State"));
            um.setCountry(rs.getString("Country"));
            um.setEmail(rs.getString("email"));
            um.setSignedIn(rs.getBoolean("SignedIn"));
            um.setIsEmployee(rs.getBoolean("IsEmployee"));
            um.setSex(rs.getString("Sex"));
            al.add(um);
        }
        return al;
    }
}
