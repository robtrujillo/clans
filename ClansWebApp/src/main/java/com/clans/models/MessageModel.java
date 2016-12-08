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
public class MessageModel extends Model{
    
    private int messageId;
    //private UserModel sender;
    /* NEED TO FLATTEN THE MODEL */
    private int senderId;
    private String senderFName;
    private String senderLName;
    /* NEED TO FLATTEN THE MODEL */
    private int receiverId;
    private String receiverFName;
    private String receiverLName;
    //private UserModel receiver;
    private Date date;
    private Time time;
    private String subject;
    private String content;
    
    public MessageModel(){
//        sender = new UserModel();
//        receiver = new UserModel();
    }

    /**
     * @return the messageId
     */
    public int getMessageId() {
        return messageId;
    }

    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    /**
     * @return the sender
     */
//    public UserModel getSender() {
//        return sender;
//    }
//
//    /**
//     * @param sender the sender to set
//     */
//    public void setSender(UserModel sender) {
//        this.sender = sender;
//    }
//
//    /**
//     * @return the receiver
//     */
//    public UserModel getReceiver() {
//        return receiver;
//    }
//
//    /**
//     * @param receiver the receiver to set
//     */
//    public void setReceiver(UserModel receiver) {
//        this.receiver = receiver;
//    }

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
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
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
     * @return the senderId
     */
    public int getSenderId() {
        return senderId;
    }

    /**
     * @param senderId the senderId to set
     */
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    /**
     * @return the senderFName
     */
    public String getSenderFName() {
        return senderFName;
    }

    /**
     * @param senderFName the senderFName to set
     */
    public void setSenderFName(String senderFName) {
        this.senderFName = senderFName;
    }

    /**
     * @return the senderLName
     */
    public String getSenderLName() {
        return senderLName;
    }

    /**
     * @param senderLName the senderLName to set
     */
    public void setSenderLName(String senderLName) {
        this.senderLName = senderLName;
    }

    /**
     * @return the receiverId
     */
    public int getReceiverId() {
        return receiverId;
    }

    /**
     * @param receiverId the receiverId to set
     */
    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    /**
     * @return the receiverFName
     */
    public String getReceiverFName() {
        return receiverFName;
    }

    /**
     * @param receiverFName the receiverFName to set
     */
    public void setReceiverFName(String receiverFName) {
        this.receiverFName = receiverFName;
    }

    /**
     * @return the receiverLName
     */
    public String getReceiverLName() {
        return receiverLName;
    }

    /**
     * @param receiverLName the receiverLName to set
     */
    public void setReceiverLName(String receiverLName) {
        this.receiverLName = receiverLName;
    }
    
    
    
    
}
