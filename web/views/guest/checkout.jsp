<%-- 
    Document   : checkout
    Created on : Jul 13, 2019, 10:51:01 PM
    Author     : oVTuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>

    <head>
        <title>Checkout page</title>
        <!--meta tags -->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="keywords" content="Toys Shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script>
            addEventListener("load", function () {
                setTimeout(hideURLbar, 0);
            }, false);
            function hideURLbar() {
                window.scrollTo(0, 1);
            }
        </script>
        <!--//meta tags ends here-->
        <!--booststrap-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <!--//booststrap end-->
        <!-- font-awesome icons -->
        <link href="css/fontawesome-all.min.css" rel="stylesheet" type="text/css" media="all">
        <!-- //font-awesome icons -->
        <!--Shoping cart-->
        <link rel="stylesheet" href="css/shop.css" type="text/css" />
        <!--//Shoping cart-->
        <!--checkout-->
        <link rel="stylesheet" type="text/css" href="css/checkout.css">
        <!--//checkout-->
        <!--stylesheets-->
        <link href="css/style.css" rel='stylesheet' type='text/css' media="all">
        <!--//stylesheets-->
        <!-- <link href="//fonts.googleapis.com/css?family=Sunflower:500,700" rel="stylesheet">
          <link href="//fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet"> -->
    </head>

    <body>
        <form action="checkOut">
            <!--headder-->
            <s:if test="%{#session.CART!=null}">

                <div class="shop_inner_inf">
                    <div class="container">
                        <div class="checkout-right">
                            <h4>Your shopping cart contains: <span><s:property value="%{#session.CART.cart.size}"/> Products</span></h4>
                            <table class="timetable_sub">
                                <thead>
                                    <tr>
                                        <th>Stt</th>
                                        <th>Ảnh minh họa</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Số lượng</th>
                                        <th>Giá thành</th>
                                        <th>Hủy bỏ</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <s:iterator value="%{#session.CART.cart}" status="counter">
                                        <tr>
                                            <td class="invert">
                                                <s:property value="%{#counter.count}"/>
                                            </td>
                                            <td class="invert-image">
                                                <img src="<s:property value="key.image"/>" alt=" " class="img-responsive">
                                            </td>
                                            <td class="invert">
                                                <s:property value="key.name"/>
                                                <input type="hidden" name="SKU" value="<s:property value="key.SKU"/>" />
                                            </td>

                                            <td class="invert">
                                                <div class="quantity">
                                                    <div class="quantity-select">
                                                        <div class="entry value-minus">&nbsp;</div>
                                                        <input class="entry value" type="text" name="quantity" value="<s:property value="value"/>"/> 
                                                        <div class="entry value-plus active">&nbsp;</div>
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="invert price"><s:property value="key.price"/>k</td>
                                            <td class="invert">
                                                <div class="rem">
                                                    <div class="close1"  onclick="removeFromCart('<s:property value="key.SKU"/>')"> </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </s:iterator>
                                </tbody>

                            </table>
                            <s:if test="%{#request.ERROR!=null}">
                                <font color="red"><s:property value="%{#request.ERROR}"/></font>
                            </s:if>
                            <br>

                        </div>
                    </div>
                </div>

            </s:if>
            <s:else>
                <div style="text-align: center;margin-top: 30px" class="col-md-8">
                    <h2><font color="red">Giỏ hàng trống!</font></h2>
                </div>
            </s:else>
            <div class="container">
                <div class="row">
                    <div class="col-md-3 checkout-left-basket">
                        <h4><a href="/NullShopv3">Tiếp tục mua hàng</a></h4>
                    </div>
                    <div class="col-md-6 checkout-left-basket">
                        <ul>
                            <s:iterator value="%{#session.CART.cart}">
                                <li><s:property value="key.name"/> <span><s:property value="key.price"/>k*<s:property value="value"/></span></li>
                                </s:iterator>

                            <li>Total:  <span id="Total"></span></li>
                        </ul>
                    </div>
                    <div class="col-md-3 address_form">
                        <h4>Thông tin giao hàng</h4>
                        <div class="creditly-card-form agileinfo_form">

                            <div class="controls">
                                <label class="control-label">Tên đầy đủ: </label>
                                <input class="billing-address-name form-control" type="text" name="name" placeholder="Tên đầy đủ">
                            </div>
                            <div class="controls">
                                <label class="control-label">Số điện thoại: </label>
                                <input class="billing-address-name form-control" type="text" name="sdt" placeholder="Số điện thoại">
                            </div>
                            <div class="controls">
                                <label class="control-label">Địa chỉ: </label>
                                <input class="billing-address-name form-control" type="text" name="adress" placeholder="Địa chỉ">
                            </div>
                            <input id="totalprice" type="hidden" name="totalprice"/>
                            <div class="checkout-right-basket">
                                <input type="submit" value="Thanh toan" />
                            </div>

                        </div>
                    </div>
                </div>
            </div>


            <!-- //top products -->
        </form>
    </div>
    <!-- //Modal 1-->
    <!--js working-->
    <script src='js/jquery-2.2.3.min.js'></script>
    <!--//js working-->
    <!-- cart-js -->
    <script src="js/minicart.js"></script>
    <script>
                                                        toys.render();
                                                        toys.cart.on('toys_checkout', function (evt) {
                                                            var items, len, i;
                                                            if (this.subtotal() > 0) {
                                                                items = this.items();
                                                                for (i = 0, len = items.length; i < len; i++) {
                                                                }
                                                            }
                                                        });
    </script>
    <!--// cart-js -->
    <!--quantity-->
    <script>
        $('.value-plus').on('click', function () {
            var divUpd = $(this).parent().find('.value'),
                    newVal = parseInt(divUpd.val(), 10) + 1;
            divUpd.val(newVal);
            cacu();
        });
        $('.value-minus').on('click', function () {
            var divUpd = $(this).parent().find('.value'),
                    newVal = parseInt(divUpd.val(), 10) - 1;
            if (newVal >= 1)
                divUpd.val(newVal);

            cacu();
        });
    </script>
    <!--quantity-->
    <!--closed-->
    <script>

//        $(document).ready(function (c) {
//            $('.close1').on('click', function (c) {
//               
//            });
//        });
        function  removeFromCart(SKU) {
//             $(this).fadeOut('slow', function (c) {
//                    $(this).parent().parent().parent().remove();
//                });
            $.ajax({
                method: "GET",
                url: "deleteAnItem",
                data: {SKU: SKU}
            })
                    .done(function (msg) {
                        $("html").html(msg);
                    });
        }
    </script>


    <!--//closed-->
    <!-- start-smoth-scrolling -->
    <script src="js/move-top.js"></script>
    <script src="js/easing.js"></script>
    <script>
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({
                    scrollTop: $(this.hash).offset().top
                }, 900);
            });
        });
    </script>
    <!-- start-smoth-scrolling -->
    <!-- here stars scrolling icon -->
    <script>
        $(document).ready(function () {

            var defaults = {
                containerID: 'toTop', // fading element id
                containerHoverID: 'toTopHover', // fading element hover id
                scrollSpeed: 1200,
                easingType: 'linear'
            };
            $().UItoTop({
                easingType: 'easeOutQuart'
            });
        });

    </script>
    <script>
        function cacu() {
            var n = 0;
            for (var i = 0; i < $('.price').length; i++) {
                n += parseInt($('.price')[i].innerText.replace("k", "")) * parseInt($('.value')[i].value)
            }
            $("#Total").text(n + "k")
            $("#totalprice").val(n)
        }
        $(document).ready(cacu());

    </script>
    <script>
        function checkout() {

            $.ajax({
                method: "GET",
                url: "checkOut",
                data: {name: $("[name='name']").val(), sdt: $("[name='sdt']").val(), address: $("[name='address']").val(), totalprice: $("#Total").text().replace("k", "")}
            })
                    .done(function (msg) {
                        $("html").html(msg);
                    });
        }


    </script>
    <!-- //here ends scrolling icon -->
    <!--bootstrap working-->
    <script src="js/bootstrap.min.js"></script>
    <!-- //bootstrap working-->
</body>

</html>