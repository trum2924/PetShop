<%-- 
    Document   : search
    Created on : Jul 9, 2019, 9:37:12 PM
    Author     : oVTuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <body>
        <s:if test="%{result == null}">
            <font color="red"> Không tìm thấy sản phẩm nào</font>
        </s:if>
        <s:iterator value="result">
            <div class="col-lg-4 col-md-6 col-sm-6 product-men women_two">
                <div class="product-toys-info">
                    <div class="men-pro-item">
                        <div class="men-thumb-item">
                            <img onerror="this.src='https://www.petcity.vn//media/product/3655_untitle7969d.jpg';" src="<s:property value='image'/>" class="img-thumbnail img-fluid" alt="">
                            <div class="men-cart-pro">
                                <form action="viewDetail">
                                    <input type="hidden" name="SKU" value="<s:property value="SKU"/>"/>
                                    <input type="submit" class="link-product-add-cart" value="Xem chi tiết">
                                </form>
                            </div>
                        </div>
                        <div class="item-info-product">
                            <div class="info-product-price">
                                <div class="grid_meta">
                                    <div class="product_price">
                                        <h4>
                                            <a href="single.html"><s:property value="name"/></a>
                                        </h4>
                                        <div class="grid-price mt-2">
                                            <span class="money "><s:property value="price"/>k</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="toys single-item hvr-outline-out">
                                    <form action="#" method="post">
                                        <button type="submit" class="toys-cart ptoys-cart">
                                            <i class="fas fa-cart-plus"></i>
                                        </button>
                                    </form>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </s:iterator>


    </body>
</html>
