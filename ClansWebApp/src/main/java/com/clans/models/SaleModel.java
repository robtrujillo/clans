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
public class SaleModel extends AdModel{
    private int saleId;
    //private AdModel ad;
    //private AccountModel account;
    private int accountId;
    private Date dateCreated;
    private String creditCardNum;
    
    private int userId;
    private String firstName; 
    private String lastName;
    private String sex;
    private String email;
    private String password;
    private String phoneNum;
    private String street;
    private String city;
    private int zipcode;
    private String state;
    private String country;
    private boolean signedIn;
    private boolean isEmployee;
    
    private int numUnits;
    private Date date;
    private Time time;
    
    public SaleModel(){
        //ad = new AdModel();
        //account = new AccountModel();
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

//    /**
//     * @return the ad
//     */
//    public AdModel getAd() {
//        return ad;
//    }
//
//    /**
//     * @param ad the ad to set
//     */
//    public void setAd(AdModel ad) {
//        this.ad = ad;
//    }
//
//    /**
//     * @return the account
//     */
//    public AccountModel getAccount() {
//        return account;
//    }
//
//    /**
//     * @param account the account to set
//     */
//    public void setAccount(AccountModel account) {
//        this.account = account;
//    }

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

    /**
     * @return the accountId
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    /**
     * @return the dateCreated
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * @param dateCreated the dateCreated to set
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * @return the creditCardNum
     */
    public String getCreditCardNum() {
        return creditCardNum;
    }

    /**
     * @param creditCardNum the creditCardNum to set
     */
    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the phoneNum
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * @param phoneNum the phoneNum to set
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the zipcode
     */
    public int getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the signedIn
     */
    public boolean isSignedIn() {
        return signedIn;
    }

    /**
     * @param signedIn the signedIn to set
     */
    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }

    /**
     * @return the isEmployee
     */
    public boolean isIsEmployee() {
        return isEmployee;
    }

    /**
     * @param isEmployee the isEmployee to set
     */
    public void setIsEmployee(boolean isEmployee) {
        this.isEmployee = isEmployee;
    }
}
