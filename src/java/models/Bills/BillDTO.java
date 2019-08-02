/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Bills;

import java.io.Serializable;


/**
 *
 * @author oVTuan
 */
public class BillDTO implements Serializable{
    private int id;
    private String idAdmin;
    private int totalPrice;
    private String date;
    private int status;
// 0.xoa ; 1.not approve ; 2.approved
   // private List<BillDetailDTO> listBillDetail;
    private String info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public BillDTO(int totalPrice, String date, String info) {
        this.totalPrice = totalPrice;
        this.date = date;
        this.info = info;
    }

    public BillDTO(int id, String idAdmin, int totalPrice, String date, int status, String info) {
        this.id = id;
        this.idAdmin = idAdmin;
        this.totalPrice = totalPrice;
        this.date = date;
        this.status = status;
        this.info = info;
    }

    public BillDTO() {
    }

   

   
}