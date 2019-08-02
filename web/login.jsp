<%-- 
    Document   : index
    Created on : Jun 25, 2019, 5:13:19 PM
    Author     : oVTuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <s:form action="Login" method="POST">
            <s:textfield name = "username" label="Username"/>
            <s:textfield name = "password" label="Password"/>
            <s:submit value="Login"/>
        </s:form>
    </body>
</html>
