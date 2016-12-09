/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.dao;

import com.clans.models.AccountModel;
import com.clans.models.AdModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Chuntak
 */
public class AccountsDAO { 
    DBSingleton dbs;
    public AccountsDAO() throws SQLException, ClassNotFoundException {
        dbs = DBSingleton.getSingleton();
    }
    
    public void updateAccounts(AccountModel am) throws SQLException, ClassNotFoundException{
        /*PREPARE*/
        PreparedStatement ps = dbs.getPreparedStatement("call update_accounts(?,?,?)");
        ps.setInt(1, am.getAccountId());
        ps.setInt(2, am.getUserId());
        ps.setString(3, am.getCreditCardNum());
        /*EXECUTE*/
        ps.executeQuery();
    }
    
    public boolean deleteAccount(AccountModel am) throws SQLException, ClassNotFoundException{
        /*PREPARE*/
        PreparedStatement ps = dbs.getPreparedStatement("call delete_accounts(?)");
        ps.setInt(1, am.getAccountId());
        /*EXECUTE*/
        ps.executeQuery();
        return true;    
    }
    
    public ArrayList<AccountModel> getAccounts(AdModel adm) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = dbs.getPreparedStatement("call get_accounts(?)");
        ps.setString(1, adm.getItemName());
        return getAccountArray(ps.executeQuery());
    }
    
   public ArrayList<AccountModel> getAllAccounts() throws SQLException, ClassNotFoundException{
        PreparedStatement ps = dbs.getPreparedStatement("call get_all_accounts()");
        return getAccountArray(ps.executeQuery());
    }

    private ArrayList<AccountModel> getAccountArray(ResultSet rs) throws SQLException {
        ArrayList<AccountModel> aml = new ArrayList<AccountModel>();
        while (rs.next()) {
            AccountModel am = new AccountModel();
            am.setAccountId(rs.getInt("AccountId"));
            am.setFirstName(rs.getString("FirstName"));
            am.setLastName(rs.getString("LastName"));
            am.setUserId(rs.getInt("CustomerId"));
            aml.add(am);
        }
        return aml;
    }
    
    
}
