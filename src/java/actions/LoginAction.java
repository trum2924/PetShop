/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import models.admins.AdminDAO;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author oVTuan
 */
public class LoginAction extends ActionSupport {

    private String username;
    private String password;
    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    public LoginAction() {
    }

    public String execute() throws Exception {
        String url = ERROR;
        AdminDAO dao = new AdminDAO();
        boolean rs = dao.checkLogin(username, password);
        HttpServletRequest request = ServletActionContext.getRequest();
        if (rs == false) {
            request.setAttribute("ERROR", "Invalid Username or Password");
        } else {
            Map session = ActionContext.getContext().getSession();
            session.put("ADMIN", username);
            url = SUCCESS;
        }
        return url;
    }

    public String getUsername() {
        return username;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Username can't be blank")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Password can't be blank")
    public void setPassword(String password) {
        this.password = password;
    }

}
