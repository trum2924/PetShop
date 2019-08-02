/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions.admins.bills;

import java.util.ArrayList;
import java.util.List;

import models.Bills.BillDAO;
import models.Bills.BillDTO;

/**
 *
 * @author oVTuan
 */
public class ViewListBillAction {

    private String cbx;
    private List<String> stt;

    public String getCbx() {
        return cbx;
    }

    public void setCbx(String cbx) {
        this.cbx = cbx;
    }

    public List<String> getStt() {
        return stt;
    }

    public void setStt(List<String> stt) {
        this.stt = stt;
    }

    private List<BillDTO> listBill;

    public ViewListBillAction() {
    }

    public String execute() throws Exception {
        stt = new ArrayList<>();
        stt.add("Not Approve");
        stt.add("Approved");
        stt.add("Deleted");
        stt.add("All");
        
        BillDAO dao = new BillDAO();
        System.out.println(cbx);
        if (cbx == null || cbx.equals("Not Approve")) {
            cbx = "Not Approve";
            listBill = dao.getAll(1);
        } else if (cbx.equals("All")) {
            listBill = dao.getAll();
        } else if (cbx.equals("Deleted")) {
            listBill = dao.getAll(0);
        } else if (cbx.equals("Approved")) {
            listBill = dao.getAll(2);
        }
        return "success";
    }

    public String getStatus() {
        return cbx;
    }

    public void setStatus(String cbx) {
        this.cbx = cbx;
    }

    public List<BillDTO> getListBill() {
        return listBill;
    }

    public void setListBill(List<BillDTO> listBill) {
        this.listBill = listBill;
    }

}
