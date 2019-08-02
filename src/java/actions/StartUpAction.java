/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.util.List;
import javax.servlet.ServletContext;
import models.Brands.BrandDAO;
import models.Brands.BrandDTO;
import models.Cates.CateDAO;
import models.Cates.CateDTO;
import models.Pets.PetDAO;
import models.Pets.PetDTO;
import models.products.ProductDAO;
import models.products.ProductDTO;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author oVTuan
 */
public class StartUpAction {

    private List<ProductDTO> CacheProduct;
    private List<ProductDTO> CacheProductAds;
    private List<PetDTO> CachePet;
    private List<BrandDTO> CacheBrand;
    private List<CateDTO> CacheCate;

    public StartUpAction() {
    }

    public String execute() throws Exception {
        ProductDAO pDAO = new ProductDAO();
        PetDAO petDAO = new PetDAO();
        BrandDAO bDAO = new BrandDAO();
        CateDAO cDAO = new CateDAO();
        ServletContext sc = ServletActionContext.getServletContext();

        if (sc.getAttribute("CacheProductAds") == null || sc.getAttribute("CacheProduct") == null || sc.getAttribute("CachePet") == null || sc.getAttribute("CacheBrand") == null || sc.getAttribute("CacheCate") == null) {
            sc.setAttribute("CacheProduct", pDAO.getCache());
            sc.setAttribute("CacheProductAds", pDAO.getCacheAds());
            sc.setAttribute("CachePet", petDAO.getAll());
            sc.setAttribute("CacheBrand", bDAO.getAll());
            sc.setAttribute("CacheCate", cDAO.getAll());
        } 
        CacheProduct = (List<ProductDTO>) sc.getAttribute("CacheProduct");
        CacheProductAds = (List<ProductDTO>) sc.getAttribute("CacheProductAds");
        CachePet = (List<PetDTO>) sc.getAttribute("CachePet");
        CacheBrand = (List<BrandDTO>) sc.getAttribute("CacheBrand");
        CacheCate = (List<CateDTO>) sc.getAttribute("CacheCate");
        return "success";
    }

    public List<ProductDTO> getCacheProduct() {
        return CacheProduct;
    }

    public void setCacheProduct(List<ProductDTO> CacheProduct) {
        this.CacheProduct = CacheProduct;
    }

    public List<PetDTO> getCachePet() {
        return CachePet;
    }

    public void setCachePet(List<PetDTO> CachePet) {
        this.CachePet = CachePet;
    }

    public List<BrandDTO> getCacheBrand() {
        return CacheBrand;
    }

    public void setCacheBrand(List<BrandDTO> CacheBrand) {
        this.CacheBrand = CacheBrand;
    }

    public List<CateDTO> getCacheCate() {
        return CacheCate;
    }

    public void setCacheCate(List<CateDTO> CacheCate) {
        this.CacheCate = CacheCate;
    }
 public List<ProductDTO> getCacheProductAds() {
        return CacheProductAds;
    }

    public void setCacheProductAds(List<ProductDTO> CacheProductAds) {
        this.CacheProductAds = CacheProductAds;
    }
}
