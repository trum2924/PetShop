<%-- 
    Document   : error
    Created on : Jun 27, 2019, 2:51:29 PM
    Author     : oVTuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Error page</h1>
        <h2>
            <font color ="red">
            <s:property value="%{#request.ERROR}"/> 
            </font>
        </h2>
    </body>
</html>
