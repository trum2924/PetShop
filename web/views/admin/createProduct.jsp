<%-- 
    Document   : createProduct
    Created on : Jul 9, 2019, 11:34:00 PM
    Author     : oVTuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>createProduct Page</title>
    </head>
    <body>
        <s:form action="createProduct" method="POST">
            <s:textfield name="SKU" label="SKU"/>
            <s:textfield name="name" label="name"/>      
            <s:textfield name="image" label="image"/>      
            <s:textfield name="detail" label="detail"/>      
            <s:textfield  name="quantity" label="quantity"/>      
            <s:textfield  name="price" label="price"/>  
            <s:submit value="Insert"/>
            <select name="brand">
                <option></option>
            </select>
        </s:form>
        <font color ="red">
        <s:if test="%{exception.message.indexOf('duplicate)>-1}">
            <s:property value="SKU"/> is existed
        </s:if>   
        </font>
    </body>
</html>
