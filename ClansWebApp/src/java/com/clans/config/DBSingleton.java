/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.config;

import java.sql.*;

/**
 *
 * @author Chuntak
 */
public class DBSingleton {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://clans.cwvpbqqn2dyf.us-east-1.rds.amazonaws.com:3306";

    static final String USER = "robtrujillo";
    static final String PASS = "clans123";
    static final String SCHEMA = "clans";
    
    private static DBSingleton dbs;
    private final Connection con;
    
    private DBSingleton() throws SQLException, ClassNotFoundException{
        Class.forName(JDBC_DRIVER);
        con = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = con.createStatement();
        statement.executeQuery("use " + SCHEMA);
    }
    
    public static DBSingleton getSingleton() throws SQLException, ClassNotFoundException { 
        if(dbs == null){
            dbs = new DBSingleton();
        } 
        return dbs;
    }
    
    public ResultSet getQuery(String Query) throws SQLException, ClassNotFoundException{
        return con.createStatement().executeQuery(Query);
    }
}
