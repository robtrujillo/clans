/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clans.controllers;

import com.clans.models.PageModel;
import com.clans.models.PostModel;
import com.clans.dao.PostsDAO;
import com.clans.dao.CommentDAO;
import com.clans.models.CommentModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rvtru
 */
@Controller
public class PageController {

    @RequestMapping(value = "/pageModel", method = RequestMethod.GET)
    public ModelAndView pageModel() {
        return new ModelAndView("pageModel", "command", new PageModel());
    }

    @RequestMapping(value = "/getPosts", method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<PostModel> getPosts(@ModelAttribute("ClansWebApp") PageModel page) {
        try {
            ArrayList<PostModel> posts = new PostsDAO().getPosts(page);
            return posts;
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @RequestMapping(value = "/getComments", method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<CommentModel> getComments(@ModelAttribute("ClansWebApp") PostModel post) {
        try {
            ArrayList<CommentModel> comments = new CommentDAO().getComments(post);
            return comments;
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @RequestMapping(value = "/saveComment", method = RequestMethod.GET)
    public @ResponseBody boolean updateComment(@ModelAttribute("ClansWebApp")  CommentModel comment) {
        try {
            if (comment.getContent() == null || comment.getContent().equals("") ) {
                return true;
            }
            else{
                new CommentDAO().updateComment(comment);
                return true;
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
