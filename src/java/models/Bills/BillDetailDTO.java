/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Bills;

import java.io.Serializable;
import models.products.ProductDTO;

/**
 *
 * @author oVTuan
 */
public class BillDetailDTO implements Serializable {

    private String idProduct;
    private int idBill;
    private int quantity;
 

    public BillDetailDTO() {
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BillDetailDTO(String idProduct, int idBill, int quantity) {
        this.idProduct = idProduct;
        this.idBill = idBill;
        this.quantity = quantity;
    }

   
   
}
