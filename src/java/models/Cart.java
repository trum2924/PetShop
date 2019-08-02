/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import models.products.ProductDTO;

/**
 *
 * @author oVTuan
 */
public class Cart implements Serializable {

    private int guestNumber;
    private Map<ProductDTO, Integer> cart;

    public Cart() {
        guestNumber = new Random().nextInt(9999);
        cart = new HashMap<>();
    }

    public Map<ProductDTO, Integer> getCart() {
        return cart;
    }

    public int getGuestnumber() {
        return guestNumber;
    }

    public void addCart(ProductDTO dto) throws Exception {
        if(cart == null) cart = new HashMap<>();
        int quantity = 1;
        if (this.cart.containsKey(dto)) {
            quantity = this.cart.get(dto) + 1;
        }
        this.cart.put(dto, quantity);
    }

    public void removeCart(ProductDTO dto) {
        if (this.cart.containsKey(dto)) {
            this.cart.remove(dto);
        }
    }
}
