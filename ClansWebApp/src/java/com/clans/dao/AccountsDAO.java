/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.dao;

import com.clans.config.DBSingleton;
import java.sql.SQLException;

/**
 *
 * @author Chuntak
 */
public class AccountsDAO {
    DBSingleton dbs;
    public AccountsDAO() throws SQLException, ClassNotFoundException {
        dbs = DBSingleton.getSingleton();
    }
}
