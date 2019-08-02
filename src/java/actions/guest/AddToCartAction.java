/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions.guest;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import models.Cart;
import models.products.ProductDAO;
import models.products.ProductDTO;


/**
 *
 * @author oVTuan
 */
public class AddToCartAction {

    private String SKU;

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public AddToCartAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        Cart cart = (Cart)session.get("CART");
        if(cart == null){
            cart = new Cart();
        }
        cart.addCart(new ProductDAO().getByIdProduct(SKU));
        session.put("CART",cart);
        Map<ProductDTO,Integer> map = cart.getCart();
        System.out.println(SKU);
        for (Map.Entry<ProductDTO,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey().getSKU()+":" + entry.getValue());
        }
        return "success";
    }

}
