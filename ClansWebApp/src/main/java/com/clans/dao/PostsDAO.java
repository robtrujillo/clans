/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.dao;

import com.clans.models.PageModel;
import com.clans.models.PostModel;
import com.clans.models.UserModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Chuntak
 */
public class PostsDAO {

    DBSingleton dbs;

    public PostsDAO() throws SQLException, ClassNotFoundException {
        dbs = DBSingleton.getSingleton();
    }

    public void updatePosts(PostModel pm) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = dbs.getPreparedStatement("call update_posts(?,?,?,?,?,?)");
        ps.setInt(1, pm.getPostId());
        ps.setInt(2, pm.getPageId());
        ps.setInt(3, pm.getUserId());
        ps.setString(4, pm.getContent());
        ps.setInt(5, pm.getCommentCount());
        ps.setInt(6, pm.getLikeCount());
        ps.executeQuery();
    }
    
    public boolean removePosts(PostModel pm) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = dbs.getPreparedStatement("call delete_post(?)");
        ps.setInt(1, pm.getPostId());
        ps.executeQuery();
        return true;
    }

    public ArrayList<PostModel> getPosts(PageModel pm) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = dbs.getPreparedStatement("call get_posts(?,?)");
        ps.setInt(1, 0);
        ps.setInt(2, pm.getPageId());
        return getPostsArray(ps.executeQuery());        
    }
    
    private ArrayList<PostModel> getPostsArray(ResultSet rs) throws SQLException{
        ArrayList<PostModel> al = new ArrayList<PostModel>();
        while (rs.next()) {
            PostModel pm = new PostModel();
            pm.setCommentCount(rs.getInt("CommentCount"));
            pm.setLikeCount(rs.getInt("LikeCount"));
            pm.setContent(rs.getString("Content"));
            pm.setDate(rs.getDate("DateCreated"));
            pm.setPageId(rs.getInt("PageId"));
            pm.setPostId(rs.getInt("PostId"));
            //UserModel author = new UserModel();
            pm.setUserId(rs.getInt("UserId"));
            pm.setFirstName(rs.getString("FirstName"));
            pm.setLastName(rs.getString("LastName"));
            //pm.setAuthor(author);
            al.add(pm);
        }
        return al;
    }
}
