/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.dao;

import com.clans.models.EmployeeModel;
import com.clans.models.TopUserModel;
import com.clans.models.UserModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public TopUserModel getTopCustomer() throws SQLException, ClassNotFoundException {
        ResultSet rs = dbs.getQuery("top_customer");
        TopUserModel tum = new TopUserModel();
        rs.next();
        tum.setUserId(rs.getInt("UserId"));
        tum.setFirstName(rs.getString("FirstName"));
        tum.setLastName(rs.getString("LastName"));
        tum.setTotalRevenue(rs.getDouble("TotalRevenue"));
        return tum;
    }

    public TopUserModel getTopEmployee() throws SQLException, ClassNotFoundException {
        ResultSet rs = dbs.getQuery("top_employee");
        TopUserModel tum = new TopUserModel();
        rs.next();
        tum.setUserId(rs.getInt("UserId"));
        tum.setFirstName(rs.getString("FirstName"));
        tum.setLastName(rs.getString("LastName"));
        tum.setTotalRevenue(rs.getDouble("TotalRevenue"));
        return tum;
    }

    public EmployeeModel getEmployeeModelById(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = dbs.getPreparedStatement("call get_employees(?,?,?,?)");
        ps.setInt(1, id);
        ps.setString(2, null);
        ps.setString(3, null);
        ps.setString(4, null);
        ResultSet rs = ps.executeQuery();
        rs.next();
        EmployeeModel em = new EmployeeModel();
        em.setUserId(rs.getInt("UserId"));
        em.setFirstName(rs.getString("FirstName"));
        em.setLastName(rs.getString("LastName"));
        em.setPassword(rs.getString("Pass"));
        em.setPhoneNum(rs.getString("PhoneNum"));
        em.setStreet(rs.getString("Street"));
        em.setCity(rs.getString("City"));
        em.setZipcode(rs.getInt("ZipCode"));
        em.setState(rs.getString("State"));
        em.setCountry(rs.getString("Country"));
        em.setEmail(rs.getString("Email"));
        em.setSignedIn(rs.getBoolean("SignedIn"));
        em.setIsEmployee(rs.getBoolean("IsEmployee"));
        em.setSex(rs.getString("Sex"));
        em.setSocial(rs.getInt("Social"));
        em.setStartDate(rs.getDate("StartDate"));
        em.setHourlyWage(rs.getDouble("HourlyWage"));
        em.setIsManager(rs.getBoolean("IsManager"));
        return em;
    }

    public ArrayList<UserModel> getMailingList() throws SQLException, ClassNotFoundException {
        /*Prepare sql statements*/
        return getMailingListArray(dbs.getQuery("call get_mailing_list()"));
    }

    private ArrayList<UserModel> getMailingListArray(ResultSet rs) throws SQLException {
        /*BUILDS THE ARRAY LIST TO RETURN*/
        ArrayList<UserModel> al = new ArrayList<UserModel>();
        while (rs.next()) {
            UserModel um = new UserModel();
            um.setFirstName(rs.getString("FirstName"));
            um.setLastName(rs.getString("LastName"));
            um.setStreet(rs.getString("Street"));
            um.setCity(rs.getString("City"));
            um.setZipcode(rs.getInt("ZipCode"));
            um.setState(rs.getString("State"));
            um.setCountry(rs.getString("Country"));
            um.setEmail(rs.getString("email"));
            al.add(um);
        }
        return al;
    }
}
