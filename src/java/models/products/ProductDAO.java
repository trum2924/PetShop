/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.products;

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
public class ProductDAO implements Serializable {

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stm;

    public ProductDAO() {
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

    public ProductDTO getByIdProduct(String SKU) throws Exception {
        ProductDTO product = null;

        String name;
        String image;
        String detail;
        int quantity;
        int price;
        String idPet;
        String idCate;
        String idBrand;
        try {
            String sql = "Select * from Product Where SKU = ?";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, SKU);
            rs = stm.executeQuery();
            if (rs.next()) {
                name = rs.getString("name");
                image = rs.getString("image");
                detail = rs.getString("detail");
                quantity = rs.getInt("quantity");
                price = rs.getInt("price");
                idPet = rs.getString("idPet");
                idCate = rs.getString("idCate");
                idBrand = rs.getString("idBrand");
                product = new ProductDTO(SKU, name, image, detail, quantity, price, idPet, idCate, idBrand);
            }
        } finally {
            closeConn();
        }
        return product;
    }

    public List<ProductDTO> getByIdAndName(String search) throws Exception {
        List result = new ArrayList();
        ProductDTO product = null;
        String SKU;
        String name;
        String image;
        String detail;
        int quantity;
        int price;
        String idPet;
        String idCate;
        String idBrand;
        try {
            String sql = "Select * from Product Where SKU = ?";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, search);
            rs = stm.executeQuery();
            while (rs.next()) {
                SKU = rs.getString("SKU");
                name = rs.getString("name");
                image = rs.getString("image");
                detail = rs.getString("detail");
                quantity = rs.getInt("quantity");
                price = rs.getInt("price");
                idPet = rs.getString("idPet");
                idCate = rs.getString("idCate");
                idBrand = rs.getString("idBrand");
                product = new ProductDTO(SKU, name, image, detail, quantity, price, idPet, idCate, idBrand);
                result.add(product);
            }
        } finally {
            closeConn();
        }
        return result;
    }

    public List<ProductDTO> getByPet(String searchValue) throws Exception {
        List<ProductDTO> result = null;
        try {
            String sql = "Select * from Product Where SKU like ? || name like ?";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + searchValue + "%");
            stm.setString(2, "%" + searchValue + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(new ProductDTO());
            }
        } finally {
            closeConn();
        }
        return result;
    }

    public List<ProductDTO> searchAll(int min, int max, String cateSearch, String brandSearch, String petSearch, String nameSearch) throws Exception {
        List<ProductDTO> result = null;
        String SKU;
        String name;
        String image;
        String detail;
        int quantity;
        int price;
        String idPet;
        String idCate;
        String idBrand;
        try {
            String sql = "select * from Product where price between ? and ? and idPet like ? and idBrand like ? and idCate like ? and name like ?";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, min);
            stm.setInt(2, max);
            stm.setString(3, petSearch);
            stm.setString(4, brandSearch);
            stm.setString(5, cateSearch);
            stm.setString(6, "%" + nameSearch + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                SKU = rs.getString("SKU");
                name = rs.getString("name");
                image = rs.getString("image");
                detail = rs.getString("detail");
                quantity = rs.getInt("quantity");
                price = rs.getInt("price");
                idPet = rs.getString("idPet");
                idCate = rs.getString("idCate");
                idBrand = rs.getString("idBrand");
                result.add(new ProductDTO(SKU, name, image, detail, quantity, price, idPet, idCate, idBrand));
            }
        } finally {
            closeConn();
        }
        return result;
    }

    public List<ProductDTO> getCache() throws Exception {
        List<ProductDTO> result = null;
        String SKU;
        String name;
        String image;
        String detail;
        int quantity;
        int price;
        String idPet;
        String idCate;
        String idBrand;

        try {
            String sql = "Select Top 9 * from Product where status = 1";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                SKU = rs.getString("SKU");
                name = rs.getString("name");
                image = rs.getString("image");
                detail = rs.getString("detail");
                quantity = rs.getInt("quantity");
                price = rs.getInt("price");
                idPet = rs.getString("idPet");
                idCate = rs.getString("idCate");
                idBrand = rs.getString("idBrand");
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(new ProductDTO(SKU, name, image, detail, quantity, price, idPet, idCate, idBrand));
            }
        } finally {
            closeConn();
        }
        return result;
    }
    public List<ProductDTO> getCacheAds() throws Exception {
        List<ProductDTO> result = null;
        String SKU;
        String name;
        String image;
        String detail;
        int quantity;
        int price;
        String idPet;
        String idCate;
        String idBrand;

        try {
            String sql = "Select Top 3 * from Product where status = 1 order by NEWID()";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                SKU = rs.getString("SKU");
                name = rs.getString("name");
                image = rs.getString("image");
                detail = rs.getString("detail");
                quantity = rs.getInt("quantity");
                price = rs.getInt("price");
                idPet = rs.getString("idPet");
                idCate = rs.getString("idCate");
                idBrand = rs.getString("idBrand");
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(new ProductDTO(SKU, name, image, detail, quantity, price, idPet, idCate, idBrand));
            }
        } finally {
            closeConn();
        }
        return result;
    }

    public List<ProductDTO> getAll() throws Exception {
        List<ProductDTO> result = null;
        String SKU;
        String name;
        String image;
        String detail;
        int quantity;
        int price;
        String idPet;
        String idCate;
        String idBrand;

        try {
            String sql = "Select * from Product where status = 1";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                SKU = rs.getString("SKU");
                name = rs.getString("name");
                image = rs.getString("image");
                detail = rs.getString("detail");
                quantity = rs.getInt("quantity");
                price = rs.getInt("price");
                idPet = rs.getString("idPet");
                idCate = rs.getString("idCate");
                idBrand = rs.getString("idBrand");
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(new ProductDTO(SKU, name, image, detail, quantity, price, idPet, idCate, idBrand));
            }
        } finally {
            closeConn();
        }
        return result;
    }
    public List<ProductDTO> getByPagin(int page) throws Exception {
        List<ProductDTO> result = null;
        String SKU;
        String name;
        String image;
        String detail;
        int quantity;
        int price;
        String idPet;
        String idCate;
        String idBrand;

        try {
            String sql = "select * from Product order by SKU OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY;";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, page);
            rs = stm.executeQuery();
            while (rs.next()) {
                SKU = rs.getString("SKU");
                name = rs.getString("name");
                image = rs.getString("image");
                detail = rs.getString("detail");
                quantity = rs.getInt("quantity");
                price = rs.getInt("price");
                idPet = rs.getString("idPet");
                idCate = rs.getString("idCate");
                idBrand = rs.getString("idBrand");
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(new ProductDTO(SKU, name, image, detail, quantity, price, idPet, idCate, idBrand));
            }
        } finally {
            closeConn();
        }
        return result;
    }

    public boolean add(String SKU, String name, String image, String detail, int quantity, int price, String idCate, String idPet, String idBrand) throws Exception {
        try {
            String sql = "Insert into Product values(?,?,?,?,?,?,?) ";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, SKU);
            stm.setString(2, name);
            stm.setString(3, image);
            stm.setString(4, detail);
            stm.setInt(5, quantity);
            stm.setInt(6, price);
            stm.setString(7, idPet);
            stm.setString(8, idCate);
            stm.setString(9, idBrand);
            if (stm.executeUpdate() > 0) {
                return true;
            }
        } finally {
            closeConn();
        }
        return false;
    }

    public boolean updateQuantity(ProductDTO dto) throws Exception {
        try {
            String sql = "update Product set quantity = ? where SKU = ?";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setInt(1, dto.getQuantity());
            stm.setString(2, dto.getSKU());
            if (stm.executeUpdate() > 0) {
                return true;
            }
        } finally {
            closeConn();
        }
        return false;
    }
    public boolean delete(ProductDTO dto) throws Exception {
        try {
            String sql = "update Product set status = 0 where SKU = ?";
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getSKU());
            if (stm.executeUpdate() > 0) {
                return true;
            }
        } finally {
            closeConn();
        }
        return false;
    }
}
