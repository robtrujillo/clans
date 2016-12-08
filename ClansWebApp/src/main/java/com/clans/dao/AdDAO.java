/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.dao;

import com.clans.models.AccountModel;
import com.clans.models.AdModel;
import com.clans.models.EmployeeModel;
import com.clans.models.UserModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Chuntak
 */
public class AdDAO {
        DBSingleton dbs;

    public AdDAO() throws SQLException, ClassNotFoundException {
        dbs = DBSingleton.getSingleton();
    }

    public void updateAdvertisements(AdModel am) throws SQLException, ClassNotFoundException {
        /*PREPARE*/
        PreparedStatement ps = dbs.getPreparedStatement("call update_advertisements(?,?,?,?,?,?,?,?)");
        ps.setInt(1, am.getAdId());
        ps.setInt(2, am.getEmployee().getUserId());
        ps.setString(3,am.getItemType());
        ps.setString(4, am.getCompany());
        ps.setString(5, am.getItemName());
        ps.setString(6, am.getContent());
        ps.setDouble(7, am.getUnitPrice());
        ps.setInt(8, am.getNumAvailable());
        /*EXECUTE*/
        ps.executeQuery();
    }

    public boolean deleteAdvertisements(AdModel am) throws SQLException, ClassNotFoundException {
        /*PREPARE*/
        PreparedStatement ps = dbs.getPreparedStatement("call delete_advertisements(?)");
        ps.setInt(1, am.getAdId());
        /*EXECUTE*/
        ps.executeQuery();
        return true;
    }

    public ArrayList<AdModel> getAd(AdModel am, UserModel um, AccountModel acm) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = dbs.getPreparedStatement("call get_advertisements(?,?,?,?,?)");
        ps.setInt(1, am.getAdId());
        ps.setInt(2, um.getUserId());
        ps.setInt(3, acm.getAccountId());
        ps.setString(4, am.getItemType());
        ps.setString(5, am.getCompany());
        return getAdArray(ps.executeQuery());
    }

    private ArrayList<AdModel> getAdArray(ResultSet rs) throws SQLException {
        ArrayList<AdModel> aml = new ArrayList<AdModel>();
        while (rs.next()) {
            AdModel am = new AdModel();
            am.setAdId(rs.getInt("AdvertisementId"));
            am.setItemType(rs.getString("ItemType"));
            am.setDate(rs.getDate("DateCreated"));
            am.setCompany(rs.getString("Company"));
            am.setContent(rs.getString("Content"));
            am.setUnitPrice(rs.getDouble("UnitPrice"));
            am.setNumAvailable(rs.getInt("NumAvailable"));
            EmployeeModel em = new EmployeeModel();
            em.setUserId(rs.getInt("EmployeeId"));
            am.setEmployee(em);
            aml.add(am);
        }
        return aml;
    }
}
