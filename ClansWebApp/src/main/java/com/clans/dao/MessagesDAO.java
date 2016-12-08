/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.dao;

import com.clans.models.MessageModel;
import com.clans.models.UserModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Chuntak
 */
public class MessagesDAO {

    DBSingleton dbs;

    public MessagesDAO() throws SQLException, ClassNotFoundException {
        dbs = DBSingleton.getSingleton();
    }

    public void updateMessages(MessageModel mm) throws SQLException, ClassNotFoundException {
        /*PREPARE*/
        PreparedStatement ps = dbs.getPreparedStatement("call update_messages(?,?,?,?,?)");
        ps.setInt(1, mm.getMessageId());
        ps.setInt(2, mm.getSender().getUserId());
        ps.setInt(3, mm.getReceiver().getUserId());
        ps.setString(4, mm.getSubject());
        ps.setString(5, mm.getContent());
        /*EXECUTE*/
        ps.executeQuery();
    }
    
    public ArrayList<MessageModel> getConversation(UserModel um1, UserModel um2) throws SQLException, ClassNotFoundException{
        PreparedStatement ps = dbs.getPreparedStatement("call get_conversation(?, ?)");
        ps.setInt(1, um1.getUserId());
        ps.setInt(2, um2.getUserId());
        return getConversationArray(ps.executeQuery());
    }
    
    public ArrayList<UserModel> getMessagees(UserModel um) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = dbs.getPreparedStatement("call get_messages(?)");
        ps.setInt(1, um.getUserId());
        return getMessageesArray(ps.executeQuery());
    }        
    
    public boolean removeMessage(MessageModel mm) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = dbs.getPreparedStatement("call delete_messages(?)");
        ps.setInt(1,mm.getMessageId());
        ps.executeQuery();
        return true;
    }
    
    private ArrayList<MessageModel> getConversationArray(ResultSet rs) throws SQLException {
        ArrayList<MessageModel> ml = new ArrayList<MessageModel>();
        while(rs.next()) {
            MessageModel mm = new MessageModel();
            mm.setContent(rs.getString("Content"));
            mm.setSubject(rs.getString("MsgSubject"));
            mm.setDate(rs.getDate("DateSent"));
            UserModel sender = new UserModel();
            sender.setUserId(rs.getInt("SenderId"));
            sender.setFirstName(rs.getString("SenderFName"));
            sender.setLastName(rs.getString("SenderLName"));
            UserModel rec = new UserModel();
            rec.setUserId(rs.getInt("RecId"));
            rec.setFirstName(rs.getString("RecFName"));
            rec.setLastName(rs.getString("RecLName"));
            mm.setSender(sender);
            mm.setReceiver(rec);
            ml.add(mm);
        }
        return ml;
    }
    
    private ArrayList<UserModel> getMessageesArray(ResultSet rs) throws SQLException {
        ArrayList<UserModel> uml = new ArrayList<UserModel>();
        while(rs.next()) {
            UserModel um = new UserModel();
            um.setUserId(rs.getInt("UserId"));
            um.setFirstName(rs.getString("FirstName"));
            um.setLastName(rs.getString("LastName"));
            uml.add(um);
        }
        return uml;
    }
    
    
}
