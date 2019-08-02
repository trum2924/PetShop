/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions.guest;

import models.Brands.BrandDAO;
import models.Brands.BrandDTO;
import models.Cates.CateDAO;
import models.Cates.CateDTO;
import models.Pets.PetDAO;
import models.Pets.PetDTO;
import models.products.ProductDAO;
import models.products.ProductDTO;

/**
 *
 * @author oVTuan
 */
public class ViewDetailProductAction {

    private String SKU;
    private String brand;
    private String cate;
    private String pet;
    private ProductDTO dto;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public ProductDTO getDto() {
        return dto;
    }

    public void setDto(ProductDTO dto) {
        this.dto = dto;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public ViewDetailProductAction() {
    }

    public String execute() throws Exception {
        dto = new ProductDAO().getByIdProduct(SKU);
        BrandDTO brandDTO = new BrandDAO().getById(dto.getIdBrand());
        CateDTO cateDTO = new CateDAO().getById(dto.getIdCate());
        PetDTO petDTO = new PetDAO().getById(dto.getIdPet());
        brand = brandDTO.getName();
        cate = cateDTO.getName();
        pet = petDTO.getName();
        return "success";
    }
}
