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

    public ArrayList<UserModel> getUsers(UserModel user) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = dbs.getPreparedStatement("call get_users(?,?,?)");
        ps.setInt(1, user.getUserId());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getFirstName() != null ? user.getFirstName() : user.getLastName());
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
            al.add(um);
        }
        return al;
    }
}
