/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions.admins.products;

import java.util.List;
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
public class InitSearchPageAction {

    private List<ProductDTO> listProduct;
    private List<ProductDTO> listProductAds;

    public List<ProductDTO> getListProductAds() {
        return listProductAds;
    }

    public void setListProductAds(List<ProductDTO> listProductAds) {
        this.listProductAds = listProductAds;
    }
    private List<PetDTO> listPet;
    private List<BrandDTO> listBrand;
    private List<CateDTO> listCate;

    public List<ProductDTO> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductDTO> listProduct) {
        this.listProduct = listProduct;
    }

    public List<PetDTO> getListPet() {
        return listPet;
    }

    public void setListPet(List<PetDTO> listPet) {
        this.listPet = listPet;
    }

    public List<BrandDTO> getListBrand() {
        return listBrand;
    }

    public void setListBrand(List<BrandDTO> listBrand) {
        this.listBrand = listBrand;
    }

    public List<CateDTO> getListCate() {
        return listCate;
    }

    public void setListCate(List<CateDTO> listCate) {
        this.listCate = listCate;
    }

    public InitSearchPageAction() {
    }

    public String execute() throws Exception {
        ProductDAO pDAO = new ProductDAO();
        PetDAO petDAO = new PetDAO();
        BrandDAO bDAO = new BrandDAO();
        CateDAO cDAO = new CateDAO();
        listBrand = bDAO.getAll();
        listPet = petDAO.getAll();
        listCate = cDAO.getAll();
        listProduct = pDAO.getAll();

        return "success";
    }

}
