/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions.guest;

import java.util.List;
import models.products.ProductDAO;

/**
 *
 * @author oVTuan
 */
public class SearchProductAction {

    private String nameSearch;
    private String cateSearch;
    private String brandSearch;
    private String petSearch;
    private int priceB;
    private int priceE;
    private List result;

    public String getNameSearch() {
        return nameSearch;
    }

    public void setNameSearch(String nameSearch) {
        this.nameSearch = nameSearch;
    }

    public String getCateSearch() {
        return cateSearch;
    }

    public void setCateSearch(String cateSearch) {
        this.cateSearch = cateSearch;
    }

    public String getBrandSearch() {
        return brandSearch;
    }

    public void setBrandSearch(String brandSearch) {
        this.brandSearch = brandSearch;
    }

    public int getPriceB() {
        return priceB;
    }

    public void setPriceB(int priceB) {
        this.priceB = priceB;
    }

    public int getPriceE() {
        return priceE;
    }

    public void setPriceE(int priceE) {
        this.priceE = priceE;
    }

    public String getPetSearch() {
        return petSearch;
    }

    public void setPetSearch(String petSearch) {
        this.petSearch = petSearch;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }

    public SearchProductAction() {
    }

    public String execute() throws Exception {

       if(petSearch.equals("-1")) petSearch = "%";
       if(brandSearch.equals("-1")) brandSearch = "%";
       if(cateSearch.equals("-1")) cateSearch = "%";
       if(nameSearch.equals("-1")) nameSearch = "%";
       result = new ProductDAO().searchAll(priceB, priceE, cateSearch, brandSearch, petSearch,nameSearch);
        System.out.println(priceB);
        System.out.println(priceE);
        System.out.println(petSearch);
        System.out.println(brandSearch);
        System.out.println(cateSearch);
        System.out.println(nameSearch);
        return "success";
    }

}
