/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.models;

/**
 *
 * @author rvtru
 */
public class PageModel extends Model{
    
    private int pageId;
    private UserModel user;
    private GroupModel group;
    private int postCount;
    
    public PageModel(){
        user = new UserModel();
        group = new GroupModel();
    }

    /**
     * @return the pageId
     */
    public int getPageId() {
        return pageId;
    }

    /**
     * @param pageId the pageId to set
     */
    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    /**
     * @return the user
     */
    public UserModel getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserModel user) {
        this.user = user;
    }

    /**
     * @return the group
     */
    public GroupModel getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(GroupModel group) {
        this.group = group;
    }

    /**
     * @return the postCount
     */
    public int getPostCount() {
        return postCount;
    }

    /**
     * @param postCount the postCount to set
     */
    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }
    
    
    
    
}
