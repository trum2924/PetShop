/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions.admins.bills;

import models.Bills.BillDAO;

/**
 *
 * @author oVTuan
 */
public class DeleteBillAction {
    private int idBill;
    private String cbx;

    public String getCbx() {
        return cbx;
    }

    public void setCbx(String cbx) {
        this.cbx = cbx;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }
    public DeleteBillAction() {
    }
    
    public String execute() throws Exception {
        System.out.println(idBill);
         new BillDAO().delete(idBill);
         return "success";
    }
    
}
