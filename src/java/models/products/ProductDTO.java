/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.products;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author oVTuan
 */
public class ProductDTO implements Serializable {

    private String SKU;
    private String name;
    private String image;
    private String detail;
    private int quantity;
    private int price;
    private String idPet;
    private String idCate;
    private String idBrand;

    public ProductDTO() {
    }

    public ProductDTO(String SKU, String name, String image, String detail, int quantity, int price, String idPet, String idCate, String idBrand) {
        this.SKU = SKU;
        this.name = name;
        this.image = image;
        this.detail = detail;
        this.quantity = quantity;
        this.price = price;
        this.idPet = idPet;
        this.idCate = idCate;
        this.idBrand = idBrand;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIdPet() {
        return idPet;
    }

    public void setIdPet(String idPet) {
        this.idPet = idPet;
    }

    public String getIdCate() {
        return idCate;
    }

    public void setIdCate(String idCate) {
        this.idCate = idCate;
    }

    public String getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(String idBrand) {
        this.idBrand = idBrand;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (SKU != null) ? SKU.hashCode() : 0;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ProductDTO)) {
            return false;
        }

        ProductDTO other = (ProductDTO) obj;
        if ((this.SKU == null && other.SKU != null) || (this.SKU != null && !this.SKU.equals(other.SKU))) {
            return false;
        }
        return true;
    }
}
