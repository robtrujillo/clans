/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.dao;

import com.clans.models.CommentModel;
import com.clans.models.UserModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Chuntak
 */
public class CommentDAO {

    DBSingleton dbs;

    public CommentDAO() throws SQLException, ClassNotFoundException {
        dbs = DBSingleton.getSingleton();
    }

    public void updateComment(CommentModel cm) throws SQLException, ClassNotFoundException {
        /*PREPARE*/
        PreparedStatement ps = dbs.getPreparedStatement("call update_comments(?,?,?,?,?)");
        ps.setInt(1, cm.getCommentId());
        ps.setInt(2, cm.getPostId());
        ps.setInt(3, cm.getAuthor().getUserId());
        ps.setString(4, cm.getContent());
        ps.setInt(5, cm.getLikeCount());
        /*EXECUTE*/
        ps.executeQuery();
    }

    public boolean deleteComment(CommentModel cm) throws SQLException, ClassNotFoundException {
        /*PREPARE*/
        PreparedStatement ps = dbs.getPreparedStatement("call delete_comments(?,?,?)");
        ps.setInt(1, cm.getCommentId());
        ps.setInt(2, cm.getPostId());
        ps.setInt(3, cm.getAuthor().getUserId());
        /*EXECUTE*/
        ps.executeQuery();
        return true;
    }

    public ArrayList<CommentModel> getComments(CommentModel cm) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = dbs.getPreparedStatement("call get_comments(?)");
        ps.setInt(1, cm.getPostId());
        return getCommentsArray(ps.executeQuery());
    }

    private ArrayList<CommentModel> getCommentsArray(ResultSet rs) throws SQLException {
        ArrayList<CommentModel> cml = new ArrayList<CommentModel>();
        while (rs.next()) {
            CommentModel cm = new CommentModel();
            cm.setCommentId(rs.getInt("CommentId"));
            cm.setPostId(rs.getInt("PostId"));
            cm.setContent(rs.getString("Content"));
            cm.setDate(rs.getDate("DateCreated"));
            cm.setLikeCount(rs.getInt("LikeCount"));
            cm.setPageId(rs.getInt("PageId"));
            UserModel author = new UserModel();
            author.setUserId(rs.getInt("UserId"));
            author.setFirstName(rs.getString("FirstName"));
            author.setLastName(rs.getString("LastName"));
            cml.add(cm);
        }
        return cml;
    }
}
