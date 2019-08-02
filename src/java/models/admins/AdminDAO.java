/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.admins;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.DBUtils;

/**
 *
 * @author oVTuan
 */
public class AdminDAO implements Serializable {

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stm;

    public AdminDAO() {
    }

    public void closeConn() throws Exception {

        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }

    }

    public boolean checkLogin(String username, String password) throws Exception {
        try {
            String sql = "Select * from Admin Where username = ? and password = ?";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if (rs.next()) {
               return true;
            }
        } finally {
            closeConn();
        }
        return false;
    }

    public String getFullname(String username) throws Exception {
        String fullname = null;
        try {
            String sql = "Select fullname from Admin Where username = ?";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            if (rs.next()) {
                fullname = rs.getString("fullname");
            }
        } finally {
            closeConn();
        }
        return fullname;
    }

    public AdminDTO getByIdAdmin(String username) throws Exception {
        AdminDTO admin = null;
        String fullname;
        String role;
        try {
            String sql = "Select * from Admin Where username = ?";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            if (rs.next()) {
                fullname = rs.getString("fullname");
                role = rs.getString("role");
                admin = new AdminDTO(username, fullname, role);
            }
        } finally {
            closeConn();
        }
        return admin;
    }

}
