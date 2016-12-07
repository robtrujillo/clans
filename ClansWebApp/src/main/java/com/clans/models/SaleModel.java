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
public class SaleModel {
    private int saleId;
    private AdModel ad;
    private AccountModel account;
    private int numUnits;
    private Date date;
    private Time time;
    
    public SaleModel(){
        ad = new AdModel();
        account = new AccountModel();
    }

    /**
     * @return the saleId
     */
    public int getSaleId() {
        return saleId;
    }

    /**
     * @param saleId the saleId to set
     */
    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    /**
     * @return the ad
     */
    public AdModel getAd() {
        return ad;
    }

    /**
     * @param ad the ad to set
     */
    public void setAd(AdModel ad) {
        this.ad = ad;
    }

    /**
     * @return the account
     */
    public AccountModel getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(AccountModel account) {
        this.account = account;
    }

    /**
     * @return the numUnits
     */
    public int getNumUnits() {
        return numUnits;
    }

    /**
     * @param numUnits the numUnits to set
     */
    public void setNumUnits(int numUnits) {
        this.numUnits = numUnits;
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
}
