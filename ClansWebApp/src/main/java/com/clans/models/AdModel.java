/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.models;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author rvtru
 */
public class AdModel extends Model{
    
    private int adId;
    private EmployeeModel employee;
    private String itemType;
    private String itemName;
    private Date date;
    private Time time;
    private String company;
    private String content;
    private double unitPrice;
    private int numAvailable;

    public AdModel(){
        employee = new EmployeeModel();
    }
    
    /**
     * @return the adId
     */
    public int getAdId() {
        return adId;
    }

    /**
     * @param adId the adId to set
     */
    public void setAdId(int adId) {
        this.adId = adId;
    }

    /**
     * @return the employee
     */
    public EmployeeModel getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(EmployeeModel employee) {
        this.employee = employee;
    }

    /**
     * @return the itemType
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * @param itemType the itemType to set
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public Time getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Time time) {
        this.time = time;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the numAvailable
     */
    public int getNumAvailable() {
        return numAvailable;
    }

    /**
     * @param numAvailable the numAvailable to set
     */
    public void setNumAvailable(int numAvailable) {
        this.numAvailable = numAvailable;
    }
    
}
