/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.models;

/**
 *
 * @author Chuntak
 */
public class TopUserModel extends UserModel{
    private double totalRevenue;

    /**
     * @return the totalRevenue
     */
    public double getTotalRevenue() {
        return totalRevenue;
    }

    /**
     * @param totalRevenue the totalRevenue to set
     */
    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
    
}
