/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.dao;

import com.clans.models.AccountModel;
import com.clans.models.AdModel;
import com.clans.models.EmployeeModel;
import com.clans.models.ModelList;
import com.clans.models.SaleModel;
import com.clans.models.UserModel;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Chuntak
 */
public class SalesDAO {
    DBSingleton dbs;
    public SalesDAO() throws SQLException, ClassNotFoundException {
        dbs = DBSingleton.getSingleton();
    }

    public void updateSales(SaleModel sm) throws SQLException, ClassNotFoundException {
        /*PREPARE*/
        PreparedStatement ps = dbs.getPreparedStatement("call update_sales(?,?,?,?)");
        ps.setInt(1, sm.getSaleId());
        ps.setInt(2, sm.getAd().getAdId());
        ps.setInt(3,sm.getAccount().getAccountId());
        ps.setInt(4,sm.getNumUnits());
        /*EXECUTE*/
        ps.executeQuery();
    }

    public boolean deleteSales(SaleModel sm) throws SQLException, ClassNotFoundException {
        /*PREPARE*/
        PreparedStatement ps = dbs.getPreparedStatement("call delete_sale(?)");
        ps.setInt(1, sm.getSaleId());
        /*EXECUTE*/
        ps.executeQuery();
        return true;
    }

    public ArrayList<ModelList> getSales(SaleModel sm, EmployeeModel em, Date startDate, Date endDate) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = dbs.getPreparedStatement("call get_sales(?,?,?,?,?,?)");
        ps.setInt(1, sm.getSaleId());
        ps.setInt(2, sm.getAccount().getAccountId());
        ps.setInt(3, em.getUserId());
        ps.setString(4, sm.getAd().getItemName());
        ps.setDate(5, startDate);
        ps.setDate(6, endDate);
        return getSalesArray(ps.executeQuery());
    }

    private ArrayList<ModelList> getSalesArray(ResultSet rs) throws SQLException {
        ArrayList<ModelList> mll = new ArrayList<ModelList>();
        while (rs.next()) {
            SaleModel sm = new SaleModel();
            sm.setSaleId(rs.getInt("SaleId"));
            AdModel am = new AdModel();
            am.setAdId(rs.getInt("AdvertisementId"));
            sm.setAd(am);
            AccountModel acm = new AccountModel();
            acm.setAccountId(rs.getInt("AccountId"));
            sm.setAccount(acm);
            sm.setNumUnits(rs.getInt("NumUnits"));
            sm.setDate(rs.getDate("SaleDate"));
            UserModel um = new UserModel();
            um.setFirstName(rs.getString("FirstName"));
            um.setLastName(rs.getString("LastName"));
            ModelList ml = new ModelList();
            ml.add(sm);
            ml.add(um);            
            mll.add(ml);
        }
        return mll;
    }
}
