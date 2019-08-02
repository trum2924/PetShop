/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Bills;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.admins.AdminDAO;
import utils.DBUtils;

/**
 *
 * @author oVTuan
 */
public class BillDAO implements Serializable {

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stm;
    AdminDAO adDao = new AdminDAO();

    public BillDAO() {
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
 public BillDTO getByIdBill(int id) throws Exception {
        BillDTO bill = null;
        String idAdmin;
        int totalPrice;
        String date;
        int status;
        String info;
        try {
            String sql = "select * from Bill where id = ?";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                idAdmin = rs.getString("idAdmin");
                totalPrice = rs.getInt("totalPrice");
                date = rs.getString("date");
                status = rs.getInt("status");
                info = rs.getString("info");
              bill = new BillDTO(id, idAdmin, totalPrice, date, status,info);
            }  
        } finally {
            closeConn();
        }
        return bill;
    }
 public BillDTO getLastBill() throws Exception {
        BillDTO bill = null;
        int id;
        String idAdmin;
        int totalPrice;
        String date;
        int status;
        String info;
        try {
            String sql = "select TOP 1* from Bill order by date desc";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
                idAdmin = rs.getString("idAdmin");
                totalPrice = rs.getInt("totalPrice");
                date = rs.getString("date");
                status = rs.getInt("status");
                info = rs.getString("info");
              bill = new BillDTO(id, idAdmin, totalPrice, date, status,info);
            }  
        } finally {
            closeConn();
        }
        return bill;
    }
    public List<BillDTO> getAll() throws Exception {
        List<BillDTO> result = null;

        int id;
        String idAdmin;
        int totalPrice;
        String date;
        int status;
        String info;
        try {
            String sql = "select * from Bill";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
                idAdmin = rs.getString("idAdmin");
                totalPrice = rs.getInt("totalPrice");
                date = rs.getString("date");
                status = rs.getInt("status");
                info = rs.getString("info");
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(new BillDTO(id, idAdmin, totalPrice, date, status,info));
            }
        } finally {
            closeConn();
        }
        return result;
    }

    public List<BillDTO> getAll(int stt) throws Exception {
        List<BillDTO> result = null;
        int id;
        String idAdmin;
        int totalPrice;
        String date;
        int status;
        String info;
        try {
            String sql = "select * from Bill where status = ?";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, stt);
            rs = stm.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
                idAdmin = rs.getString("idAdmin");
                totalPrice = rs.getInt("totalPrice");
                date = rs.getString("date");
                status = rs.getInt("status");
                info = rs.getString("info");
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(new BillDTO(id, idAdmin, totalPrice, date, status,info));
            }
        } finally {
            closeConn();
        }
        return result;
    }


   

    public boolean delete(int id) throws Exception {
        try {
            String sql = "update Bill set status = 0 where id = ? ;update Product set quantity = p.quantity + b.quantity \n" +
"from BillDetail as b,Product as p \n" +
"  where  idBill = ? and  b.idProduct = p.SKU";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setInt(2, id);
            if (stm.executeUpdate() > 0) {
                return true;
            }
        } finally {
            closeConn();
        }
        return false;
    }

    public boolean aprove(int id, String idAdmin) throws Exception {
        try {
            String sql = "update Bill set status = 2, idAdmin = ? where id = ?";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, idAdmin);
            stm.setInt(2, id);
            if (stm.executeUpdate() > 0) {
                return true;
            }
        } finally {
            closeConn();
        }
        return false;
    }

    public boolean add(BillDTO bill) throws Exception {
        try {
            String sql = "Insert into Bill (totalPrice,date,info) values (?,?,?)";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, bill.getTotalPrice());
            stm.setString(2, bill.getDate());
            stm.setString(3, bill.getInfo());
            if (stm.executeUpdate() > 0) {
                return true;
            }
        } finally {
            closeConn();
        }
        return false;
    }

}
