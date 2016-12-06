/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.models;

import java.sql.Date;

/**
 *
 * @author rvtru
 */
public class EmployeeModel extends UserModel {
    
    private int social;
    private Date startDate;
    private double hourlyWage;
    private boolean isManager;

    public EmployeeModel(){
        
    }

    /**
     * @return the social
     */
    public int getSocial() {
        return social;
    }

    /**
     * @param social the social to set
     */
    public void setSocial(int social) {
        this.social = social;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the hourlyWage
     */
    public double getHourlyWage() {
        return hourlyWage;
    }

    /**
     * @param hourlyWage the hourlyWage to set
     */
    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    /**
     * @return the isManager
     */
    public boolean isIsManager() {
        return isManager;
    }

    /**
     * @param isManager the isManager to set
     */
    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }
    
    
}
