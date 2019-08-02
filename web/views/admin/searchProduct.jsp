<%-- 
    Document   : searchProduct
    Created on : Jul 9, 2019, 11:05:43 PM
    Author     : oVTuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Product</title>
    </head>
    <body>
        <h1>Hello admin!</h1>
        <s:form action="SearchAction" method="POST">
            <s:textfield name = "searchValue" label="Fullname"/>
            <select>
                <s:iterator value="listBrand">
                    <option>
                        <s:property value="%{name}"/>
                    </option>
                </s:iterator>
            </select>
            <select>
                <s:iterator value="listCate">
                    <option>
                        <s:property value="%{name}"/>
                    </option>
                </s:iterator>
            </select>
            <select>
                <s:iterator value="listPet">
                    <option>
                        <s:property value="%{name}"/>
                    </option>
                </s:iterator>
            </select>
            <s:submit value="Search"/>
        </s:form>
        <s:if test="%{listProduct != null}">
            <table>
                <s:iterator value="listProduct">
                    <tr>
                        <td><s:property value="%{id}"/></td>
                        <td><s:property value="%{name}"/></td>
                        <td><s:property value="%{image}"/></td>
                        <td><s:property value="%{detail}"/></td>
                        <td><s:property value="%{quantity}"/></td>
                        <td><s:property value="%{price}"/></td>
                        <td>
                            <s:url action="deleteProduct" id="DeleteLink">
                                <s:param name ="lastSearchValue" value="searchValue"/>
                                <s:param name ="id" value="id"/>
                            </s:url>
                            <s:a href="%{DeleteLink}">Delete</s:a>
                            </td>
                        </tr>
                </s:iterator>
            </table>
        </s:if>
    </body>
</html>
