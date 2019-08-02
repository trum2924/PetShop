/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions.guest;

import com.opensymphony.xwork2.ActionContext;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import models.Bills.BillDAO;
import models.Bills.BillDTO;
import models.Bills.BillDetailDAO;
import models.Bills.BillDetailDTO;
import models.Cart;
import models.products.ProductDAO;
import models.products.ProductDTO;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author oVTuan
 */
public class CheckoutAction {

    private String[] SKU;
    private int[] quantity;
    private int totalprice;
    private String name;
    private String sdt;
    private String adress;
    private String info;

    public String[] getSKU() {
        return SKU;
    }

    public void setSKU(String[] SKU) {
        this.SKU = SKU;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }

  
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public CheckoutAction() {
    }

    public String execute() throws Exception {
        this.info = "name: " + name + " ;\n sdt: " + sdt + " ;\n address: " + adress;
        System.out.println(info);
        HttpServletRequest request = ServletActionContext.getRequest();
        Map session = ActionContext.getContext().getSession();
        Cart cart = (Cart) session.get("CART");
        Map<ProductDTO, Integer> map = cart.getCart();
        
        for (int i = 0; i < SKU.length; i++) {
           map.put(new ProductDAO().getByIdProduct(SKU[i]), quantity[i]);
        }
        
        ProductDTO dtoTemp;
        for (Map.Entry<ProductDTO, Integer> entry : map.entrySet()) {
            dtoTemp = new ProductDAO().getByIdProduct(entry.getKey().getSKU());
            if (dtoTemp.getQuantity() < entry.getValue()) {
                System.out.println(dtoTemp.getQuantity());
                System.out.println(entry.getValue());
                request.setAttribute("ERROR", "Số lượng không đủ, trong kho chỉ còn: " + dtoTemp.getQuantity() + " sản phẩm " + dtoTemp.getName());
                return "error";
            }
        }
        new BillDAO().add(new BillDTO(totalprice, Timestamp.valueOf(LocalDateTime.now()).toString(), info));
        for (Map.Entry<ProductDTO, Integer> entry : map.entrySet()) {
            dtoTemp = new ProductDAO().getByIdProduct(entry.getKey().getSKU());
            dtoTemp.setQuantity(dtoTemp.getQuantity()-entry.getValue());
            new ProductDAO().updateQuantity(dtoTemp);
            BillDetailDTO billDetailTemp = new BillDetailDTO(dtoTemp.getSKU(), new BillDAO().getLastBill().getId(), entry.getValue());
            new BillDetailDAO().add(billDetailTemp);
        }
        session.remove("CART");

        return "success";
    }
}
