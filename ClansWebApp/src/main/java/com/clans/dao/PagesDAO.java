/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.dao;

import com.clans.models.GroupModel;
import com.clans.models.PageModel;
import com.clans.models.UserModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rvtru
 */
public class PagesDAO {

    DBSingleton dbs;

    public PagesDAO() throws SQLException, ClassNotFoundException {
        dbs = DBSingleton.getSingleton();
    }

    public PageModel getUserPage(UserModel user) throws SQLException, ClassNotFoundException {

        /* CHECK IF NEED USERID (WOULD BE IF USER WAS JUST INSERTED) */
        if (user.getUserId() == 0) {
            user.setUserId(new UsersDAO().getUsers(user).get(0).getUserId());
        }
        /* EXECUTE QUERY FOR USER PAGE */
        PreparedStatement ps = dbs.getPreparedStatement("call get_pages(?,?)");
        ps.setInt(1, 0);
        ps.setInt(2, user.getUserId());
        ResultSet rs = ps.executeQuery();
        /* GET DATA */
        rs.next();
        /* MAP DATA */
        PageModel pm = new PageModel();
        UserModel um = new UserModel();
        pm.setPageId(rs.getInt("PageId"));
        pm.setPostCount(rs.getInt("PostCount"));
        if (rs.getInt("UserId") > 0) {
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
        }
        pm.setUser(um);
        /* RETURN DATA */
        return pm;
    }

    public PageModel getGroupPage(GroupModel group) throws SQLException, ClassNotFoundException {

        /* EXECUTE QUERY FOR GROUP PAGE */
        PreparedStatement ps = dbs.getPreparedStatement("call get_pages(?,?)");
        ps.setInt(1, group.getGroupId());
        ps.setInt(2, 0);
        ResultSet rs = ps.executeQuery();
        /* GET DATA */
        rs.next();
        /* MAP DATA */
        PageModel pm = new PageModel();
        GroupModel um = new GroupModel();
        pm.setPageId(rs.getInt("PageId"));
        pm.setPostCount(rs.getInt("PostCount"));

        um.setUserId(rs.getInt("OwnerId"));
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
        /* GET GROUP DATA */
        um.setGroupId(rs.getInt("GroupId"));
        um.setGroupName(rs.getString("GroupName"));

        pm.setGroup(um);
        /* RETURN DATA */
        return pm;
    }

}
