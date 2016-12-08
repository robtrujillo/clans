/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.dao;

import com.clans.models.GroupModel;
import com.clans.models.ModelList;
import com.clans.models.UserModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Chuntak
 */
public class GroupDAO {

    DBSingleton dbs;

    public GroupDAO() throws SQLException, ClassNotFoundException {
        dbs = DBSingleton.getSingleton();
    }

    public void updateGroup(GroupModel gm) throws SQLException, ClassNotFoundException {
        /*PREPARE*/
        PreparedStatement ps = dbs.getPreparedStatement("call update_group(?,?,?)");
        ps.setInt(1, gm.getGroupId());
        ps.setInt(2, gm.getOwner().getUserId());
        ps.setString(3, gm.getGroupName());
        /*EXECUTE*/
        ps.executeQuery();
    }

    public boolean deleteGroup(GroupModel gm) throws SQLException, ClassNotFoundException {
        /*PREPARE*/
        PreparedStatement ps = dbs.getPreparedStatement("call delete_group(?)");
        ps.setInt(1, gm.getGroupId());
        /*EXECUTE*/
        ps.executeQuery();
        return true;
    }

    public ArrayList<GroupModel> getGroup(GroupModel gm) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = dbs.getPreparedStatement("call get_group(?,?)");
        ps.setInt(1, gm.getOwner().getUserId());
        ps.setString(2, gm.getGroupName());
        return getGroupArray(ps.executeQuery());
    }

    private ArrayList<GroupModel> getGroupArray(ResultSet rs) throws SQLException {
        ArrayList<GroupModel> gml = new ArrayList<GroupModel>();
        while (rs.next()) {
            GroupModel gm = new GroupModel();
            gm.setGroupId(rs.getInt("GroupId"));
            gm.setGroupName(rs.getString("GroupName"));
            UserModel um = new UserModel();
            um.setUserId(rs.getInt("UserId"));
            um.setFirstName(rs.getString("FirstName"));
            um.setLastName(rs.getString("LastName"));
            gm.setOwner(um);
            gml.add(gm);
        }
        return gml;
    }

    public void updateGroupRequest(UserModel um, GroupModel gm, boolean fromGroup) throws SQLException, ClassNotFoundException {
        /*PREPARE*/
        PreparedStatement ps = dbs.getPreparedStatement("call update_group_requests(?,?,?)");
        ps.setInt(1, um.getUserId());
        ps.setInt(2, gm.getGroupId());
        ps.setBoolean(3, fromGroup);
        /*EXECUTE*/
        ps.executeQuery();
    }

    public boolean deleteGroupRequest(UserModel um, GroupModel gm) throws SQLException, ClassNotFoundException {
        /*PREPARE*/
        PreparedStatement ps = dbs.getPreparedStatement("call delete_group_request(?,?)");
        ps.setInt(1, um.getUserId());
        ps.setInt(2, gm.getGroupId());
        /*EXECUTE*/
        ps.executeQuery();
        return true;
    }

    public ArrayList<ModelList> getGroupRequest(UserModel um, GroupModel gm) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = dbs.getPreparedStatement("call get_group_request(?,?)");
        ps.setInt(1, um.getUserId());
        ps.setInt(2, gm.getGroupId());
        return getGroupRequestArray(ps.executeQuery());
    }

    private ArrayList<ModelList> getGroupRequestArray(ResultSet rs) throws SQLException {
        ArrayList<ModelList> mll = new ArrayList<ModelList>();
        while (rs.next()) {
            GroupModel gm = new GroupModel();
            gm.setGroupId(rs.getInt("GroupId"));
            gm.setGroupName(rs.getString("GroupName"));
            UserModel um = new UserModel();
            um.setUserId(rs.getInt("UserID"));
            um.setFirstName(rs.getString("FirstName"));
            um.setLastName(rs.getString("LastName"));
            ModelList ml = new ModelList();
            ml.add(gm);
            ml.add(um);
            mll.add(ml);
        }
        return mll;
    }

    public void updateMembers(GroupModel gm, UserModel um) throws SQLException, ClassNotFoundException {
        /*PREPARE*/
        PreparedStatement ps = dbs.getPreparedStatement("call update_members(?,?)");
        ps.setInt(1, gm.getGroupId());
        ps.setInt(2, um.getUserId());
        /*EXECUTE*/
        ps.executeQuery();
    }

    public boolean deleteMembers(GroupModel gm, UserModel um) throws SQLException, ClassNotFoundException {
        /*PREPARE*/
        PreparedStatement ps = dbs.getPreparedStatement("call delete_member(?,?)");
        ps.setInt(1, gm.getGroupId());
        ps.setInt(2, um.getUserId());
        /*EXECUTE*/
        ps.executeQuery();
        return true;
    }

    public ArrayList<ModelList> getMembers(GroupModel gm, UserModel um) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = dbs.getPreparedStatement("call get_members(?,?)");
        ps.setInt(1, gm.getGroupId());
        ps.setInt(2, um.getUserId());
        return getMembersArray(ps.executeQuery());
    }

    private ArrayList<ModelList> getMembersArray(ResultSet rs) throws SQLException {
        ArrayList<ModelList> mll = new ArrayList<ModelList>();
        while (rs.next()) {
            GroupModel gm = new GroupModel();
            gm.setGroupId(rs.getInt("GroupId"));
            gm.setGroupName(rs.getString("GroupName"));
            UserModel um = new UserModel();
            um.setUserId(rs.getInt("UserID"));
            um.setFirstName(rs.getString("FirstName"));
            um.setLastName(rs.getString("LastName"));
            ModelList ml = new ModelList();
            ml.add(gm);
            ml.add(um);
            mll.add(ml);
        }
        return mll;
    }

}
