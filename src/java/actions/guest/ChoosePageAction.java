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
public class ChoosePageAction {

    private int numberPage;
     private List result;

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }

    public ChoosePageAction() {
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public String execute() throws Exception {
        numberPage-=1;
        result = new ProductDAO().getByPagin(9*numberPage);
        return "success";
    }
}
