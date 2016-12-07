/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.dao;

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
}
