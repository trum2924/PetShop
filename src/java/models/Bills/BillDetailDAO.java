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
import models.products.ProductDAO;
import utils.DBUtils;

/**
 *
 * @author oVTuan
 */
public class BillDetailDAO implements Serializable {

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stm;
    BillDAO bDao = new BillDAO();
    ProductDAO pDao = new ProductDAO();

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

    public BillDetailDAO() {
    }

    public List<BillDetailDTO> getAllbyIdBillDetail(int idBill) throws Exception {
        List<BillDetailDTO> result = null;
        String idProduct;
        int quantity;
       
        try {
            String sql = "select * from Bill where idBill = ? ";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, idBill);
            rs = stm.executeQuery();
            while (rs.next()) {
                idProduct = rs.getString("idProduct");
                quantity = rs.getInt("quantity");
               
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(new BillDetailDTO(idProduct, idBill, quantity));
            }
        } finally {
            closeConn();
        }
        return result;
    }

    public boolean add(BillDetailDTO billDetail) throws Exception {
        try {
            String sql = "Insert into BillDetail values (?,?,?)";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, billDetail.getIdProduct());
            stm.setInt(2, billDetail.getIdBill());
            stm.setInt(3, billDetail.getQuantity());
            if (stm.executeUpdate() > 0) {
                return true;
            }
        } finally {
            closeConn();
        }
        return false;
    }
}
