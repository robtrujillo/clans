/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.dao;

import com.clans.models.EmployeeModel;
import com.clans.models.UserModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Chuntak
 */
public class EmployeesDAO {
    DBSingleton dbs;
    public EmployeesDAO() throws SQLException, ClassNotFoundException {
        dbs = DBSingleton.getSingleton();
    }
    
    
    public void updateEmployee(EmployeeModel employee) throws SQLException, ClassNotFoundException {
        /*Prepare SQL statements*/
        PreparedStatement ps = dbs.getPreparedStatement("call update_users(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, employee.getUserId());
        ps.setString(2, employee.getFirstName());
        ps.setString(3, employee.getLastName());
        ps.setString(4, employee.getSex());
        ps.setString(5, employee.getEmail());
        ps.setString(6, employee.getPassword());
        ps.setString(7, employee.getPhoneNum());
        ps.setString(8, employee.getStreet());
        ps.setString(9, employee.getCity());
        ps.setInt(10, employee.getZipcode());
        ps.setString(11, employee.getState());
        ps.setString(12, employee.getCountry());
        ps.setBoolean(13, true);
        ps.setBoolean(14, employee.isSignedIn());
        ps.setInt(15, 0);
        ps.setInt(16, employee.getSocial());
        ps.setDate(17, employee.getStartDate());
        ps.setBoolean(18, employee.isIsManager());
    }
}
