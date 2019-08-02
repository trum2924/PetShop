/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Cates;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author oVTuan
 */
public class CateDAO implements Serializable {

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stm;

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

    public List<CateDTO> getAll() throws Exception {
        List<CateDTO> result = new ArrayList<>();
        String id, name;
        try {
            String sql = "Select id,name from Category where status = 1";
            conn = DBUtils.getConnection();

            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                result.add(new CateDTO(id, name));
            }
        } finally {
            closeConn();
        }
        return result;
    }
    public CateDTO getById(String id) throws Exception {
        String  name;
        try {
            String sql = "Select id,name from Category where status = 1";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                return  new CateDTO(id, name);
            }
        } finally {
            closeConn();
        }
        return null;
    }
     public boolean deActive(String id) throws Exception {
        String sql = "update Product set status = 0 where idCate = ?;update Category set status = 0 where id = ?";
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            if (stm.executeUpdate() > 0) {
                return true;
            }
        } finally {
            closeConn();
        }
        return false;
    }

    public boolean Active(String id) throws Exception {
        String sql = "update Product set status = 1 where idCate = ?;update Category set status = 1 where id = ?";
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            if (stm.executeUpdate() > 0) {
                return true;
            }
        } finally {
            closeConn();
        }
        return false;
    }
}
