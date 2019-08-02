/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions.admins.products;

import java.util.List;
import models.products.ProductDAO;
import models.products.ProductDTO;

/**
 *
 * @author oVTuan
 */
public class SearchProductAction {

    private String searchValue;
    private List<ProductDTO> listProduct;

    public List<ProductDTO> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductDTO> listProduct) {
        this.listProduct = listProduct;
    }

    public SearchProductAction() {
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String execute() throws Exception {
        ProductDAO dao = new ProductDAO();
        listProduct = dao.getByIdAndName(searchValue);
        return "success";
    }

}
