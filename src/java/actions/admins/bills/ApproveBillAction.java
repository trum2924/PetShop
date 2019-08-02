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
public class ApproveBillAction {

    private String idAdmin;
    private String cbx;
    private int idBill;

    public String getCbx() {
        return cbx;
    }

    public void setCbx(String cbx) {
        this.cbx = cbx;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public ApproveBillAction() {
    }

    public String execute() throws Exception {
        new BillDAO().aprove(idBill, idAdmin);
        return "success";
    }

}
