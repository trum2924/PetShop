<%-- 
    Document   : searchPet
    Created on : Jul 9, 2019, 11:07:33 PM
    Author     : oVTuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mana Pet</title>
    </head>
    <body>
        <h1>Hello admin!</h1>
        <s:if test="%{listPet != null}">
            <table>
                <s:iterator value="listPet">
                    <tr>
                        <td><s:property value="%{id}"/></td>
                        <td><s:property value="%{name}"/></td>
                        <td><s:property value="%{status}"/></td>
                        <td>
                            <s:url action="deletePet" id="DeleteLink">
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
