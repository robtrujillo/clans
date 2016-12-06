/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chuntak
 */
public class ClansServlet extends HttpServlet {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://clans.cwvpbqqn2dyf.us-east-1.rds.amazonaws.com:3306";

    static final String USER = "robtrujillo";
    static final String PASS = "clans123";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String table = "";
        try {
            table = this.getTable();
        } catch (SQLException e) {
            table = e.toString();
        } catch (ClassNotFoundException e) {
            table = e.toString();
        }
        out.println(
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n"
                + "<html> \n"
                + "<head> \n"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=ISO-8859-1\"> \n"
                + "<title> My first jsp  </title> \n"
                + "</head> \n"
                + "<body> \n"
                + table
                + "</font> \n"
                + "</body> \n"
                + "</html>"
        );
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String getTable() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();
        statement.executeQuery("use clans");
        ResultSet resultSet = statement.executeQuery("call get_users(null,null)");
        String table = new String("");
        for (int x = 1; x <= resultSet.getMetaData().getColumnCount(); x++) {
            table = table.concat(resultSet.getMetaData().getColumnName(x) + "\t\t");
        }
        table = table + "\n";
        while (resultSet.next()) {
            for (int x = 1; x <= resultSet.getMetaData().getColumnCount(); x++) {
                table = table + resultSet.getString(x) + "\t\t";
            }
            table = table + "\n";
        }
        return table;
    }
}