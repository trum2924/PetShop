<%-- 
    Document   : admin
    Created on : Jul 3, 2019, 7:10:22 PM
    Author     : oVTuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Hello <s:property value="%{#session.ADMIN}"/>!</h1>
        <s:a href="">Manager Product</s:a> |
        <s:a href="">Manager Pet</s:a> |
        <s:a href="">Manager Cate</s:a> |
        <s:a href="">Manager Brand</s:a>

            <div id="content">
            <s:form action="ViewListBillAction" method="POST">
                <s:combobox list="%{stt}" name ="cbx" value="%{cbx}"/>
                <s:submit value="Search"/>
            </s:form>

            <s:if test="%{listBill != null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>id</th>
                            <th>idAdmin</th>
                            <th>total price</th>
                            <th>date</th>
                            <th>Thông tin giao hàng</th>
                            <th>ApproveButton</th>
                            <th>DeleteButton</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="listBill" status="counter">
                            <tr>
                                <td><s:property value="%{#counter.count}"/></td>
                                <td><s:property value="%{id}"/></td>
                                <td><s:property value="%{idAdmin}"/></td>
                                <td><s:property value="%{totalPrice}"/></td>
                                <td><s:property value="%{date}"/></td>
                                <td><s:property value="%{info}"/></td>
                                <td>
                                    <s:if test="%{status == 1}">
                                        <s:form action="approve" method="POST">
                                            <%--<s:hidden name ="lastSearchValue" value="%{searchValue}"/>--%>
                                            <s:hidden name ="idBill" value="%{id}"/>
                                            <s:hidden name ="cbx" value="%{cbx}"/>
                                            <s:hidden name ="idAdmin" value="%{#session.ADMIN}"/>
                                            <s:submit value="Approve"/>
                                        </s:form>
                                    </s:if>
                                    <s:elseif test="%{status == 0}">
                                        <font color="grey">Deleted</font>
                                    </s:elseif>
                                    <s:else>
                                        <font color="grey">Approved</font>
                                    </s:else>
                                </td>
                                <td>
                                    <s:if test="%{status != 0}">
                                        <s:form action="delete" method="POST">
                                            <s:hidden name ="idBill" value="%{id}"/>
                                            <s:hidden name ="cbx" value="%{cbx}"/>
                                            <s:submit value="Delete"/>
                                        </s:form>
                                    </s:if>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
        </div>
    </body>
</html>
