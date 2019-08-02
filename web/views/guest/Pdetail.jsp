<%-- 
    Document   : Pdetail
    Created on : Jul 14, 2019, 8:01:06 PM
    Author     : oVTuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon"
              href="https://www.petcity.vn/template/2017/images/favicon.png?v=2.2" />
        <title>Null-Shop</title>
        <!--meta tags -->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

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
        <!--<link href="views/guest/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">-->
        <!--//booststrap end-->
        <!-- font-awesome icons -->
        <link href="views/guest/css/fontawesome-all.min.css" rel="stylesheet" type="text/css" media="all">
        <!-- //font-awesome icons -->
        <!--Shoping cart-->
        <link rel="stylesheet" href="views/guest/css/shop.css" type="text/css" />
        <link rel="stylesheet" href="views/guest/css/flexslider.css" type="text/css" />
        <!--//Shoping cart-->
        <!--price range-->
        <link rel="stylesheet" type="text/css" href="views/guest/css/jquery-ui1.css">
        <!--//price range-->
        <!--stylesheets-->
        <link href="views/guest/css/style.css" rel='stylesheet' type='text/css' media="all">
        <!--//stylesheets-->
        <!-- <link href="//fonts.googleapis.com/css?family=Sunflower:500,700" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet"> -->
    </head>
    <body>
               <!--headder-->
        <div class="header-outs" id="home">
            <div class="header-bar">
                <div class="info-top-grid">
                    <div class="info-contact-agile">
                        <ul>
                            <li>
                                <span class="fas fa-phone-volume"></span>
                                <p>0774495599</p>
                            </li>
                            <li>
                                <span class="fas fa-envelope"></span>
                                <p><a href="mailto:info@example.com">tuannse62717@fpt.edu.vn</a></p>
                            </li>
                            <li>
                            </li>
                        </ul>
                    </div>
                </div>

                <nav class="navbar navbar-expand-lg navbar-light">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-center" id="navbarSupportedContent">
                        <ul class="navbar-nav ">
                            <li class="nav-item ">
                                <a class="nav-link" href="/NullShopv3">Trang Chủ <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a href="about.html" class="nav-link">Giới thiệu</a>
                            </li>
                            <li class="nav-item">
                                <a href="service.html" class="nav-link">Dịch vụ</a>
                            </li>

                            <li class="nav-item">
                                <a href="#Contact" class="nav-link">Liên hệ</a>
                            </li>
                            <li class="nav-item">

                                <div class="cart-icons">

                                    <ul>
                                        <li class="toyscart toyscart2 cart cart box_1">
                                            <a class="top_toys_cart" href="views/guest/checkout.jsp">
                                                <span class="fas fa-cart-arrow-down"></span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
        <!--//headder-->
        <!-- banner -->
        <div class="inner_page-banner one-img">
        </div>
        <!--//banner -->
        <!-- short -->
        <div class="using-border py-3">

            <h1 style="font-family:'Comic Sans MS', cursive, sans-serif;">PetShop</h1>

        </div>
        <section class="banner-bottom py-lg-5 py-3">
            <div class="container">
                <div class="inner-sec-shop pt-lg-4 pt-3">
                    <div class="row">
                        <div class="col-lg-4 single-right-left ">
                            <div class="grid images_3_of_2">
                                <div class="flexslider1">
                                    <ul class="slides">
                                        <li data-thumb="<s:property value="dto.image"/>">
                                            <div class="thumb-image"> <img src="<s:property value="dto.image"/>" data-imagezoom="true" class="img-fluid" alt=" "> </div>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-8 single-right-left simpleCart_shelfItem">
                            <h3><s:property value="dto.name"/></h3>
                            <p>Nhã hiệu:
                                <span class="item_price"><s:property value="brand"/></span>

                            </p>
                            <p>Dành cho:
                                <span class="item_price"><s:property value="pet"/></span>

                            </p>
                            <p>Thuộc nhóm: 
                                <span class="item_price"><s:property value="cate"/></span>

                            </p>
                            <p>
                                <span class="item_price"><s:property value="dto.price"/>.000đ</span>

                            </p>

                            <div class="occasion-cart">
                                <div class="toys single-item singlepage">
                                  
                                        
                                    <button onclick="add2cart('<s:property value="SKU"/>')"  class="toys-cart ptoys-cart add">
                                            Add to Cart
                                        </button>
                               
                                </div>
                            </div>

                        </div>
                        <div class="clearfix"> </div>
                        <!--/tabs-->
                        <div class="responsive_tabs">
                            <div id="horizontalTab">

                                <div class="resp-tabs-container">
                                    <!--/tab_one-->
                                    <div class="tab1">
                                        <div class="single_page">
                                            <s:property value="dto.detail"/>
                                        </div>
                                    </div>
                                    <!--//tab_one-->
                                </div>
                            </div>
                        </div>
                        <!--//tabs-->
                    </div>
                </div>
            </div>
        </section>
                                        <section class="subscribe" id="Contact">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6 col-md-6 map-info-right px-0">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7836.889048316591!2d106.62497539999998!3d10.853755300000007!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x2222564f53ae228d!2zQ8O0bmcgVmnDqm4gUGjhuqduIE3hu4FtIFF1YW5nIFRydW5n!5e0!3m2!1svi!2s!4v1562554049942!5m2!1svi!2s" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
                    </div>
                    <div class="col-lg-6 col-md-6 address-w3l-right text-center">
                        <div class="address-gried ">
                            <span class="far fa-map"></span>
                            <p>cvpm<br>Quang Trung
                            <p>
                        </div>
                        <div class="address-gried mt-3">
                            <span class="fas fa-phone-volume"></span>
                            <p> 0774495599</p>
                        </div>
                        <div class=" address-gried mt-3">
                            <span class="far fa-envelope"></span>
                            <p><a href="mailto:info@example.com">tuanvvse62717@fpt.edu.vn</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--//subscribe-address-->
        <section class="sub-below-address py-lg-4 py-md-3 py-sm-3 py-3">
            <div class="container py-lg-5 py-md-5 py-sm-4 py-3">
                <h3 class="title clr text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">Get In Touch Us</h3>
                <div class="icons mt-4 text-center">
                    <ul>
                        <li><a href="#"><span class="fab fa-facebook-f"></span></a></li>
                        <li><a href="#"><span class="fas fa-envelope"></span></a></li>
                        <li><a href="#"><span class="fas fa-rss"></span></a></li>
                        <li><a href="#"><span class="fab fa-vk"></span></a></li>
                    </ul>
                    <p class="my-3">velit sagittis vehicula. Duis posuere
                        ex in mollis iaculis. Suspendisse tincidunt
                        velit sagittis vehicula. Duis posuere
                        velit sagittis vehicula. Duis posuere
                    </p>
                </div>
                <div class="email-sub-agile">
                    
                        <div class="form-group sub-info-mail">
                            <input type="email" class="form-control email-sub-agile" placeholder="Email">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn subscrib-btnn">Subscribe</button>
                        </div>
          
                </div>
            </div>
        </section>
        <!--//subscribe-->
        <!-- footer -->
        <footer class="py-lg-4 py-md-3 py-sm-3 py-3 text-center">
            <div class="copy-agile-right">
                <p>
                    © 2018 Toys-Shop. All Rights Reserved | Design by <a href="http://www.W3Layouts.com" target="_blank">W3Layouts</a>
                </p>
            </div>
        </footer>
        <script src='views/guest/js/jquery-2.2.3.min.js'></script>
        <!--//js working-->
        <!-- cart-js -->
        <script src="views/guest/js/minicart.js"></script>
        <!-- //cart-js -->
        <!-- price range (top products) -->
        <script src="views/guest/js/jquery-ui.js"></script>
        <script src="views/guest/js/move-top.js"></script>
        <script src="views/guest/js/easing.js"></script>
        <script src="views/guest/js/bootstrap.min.js"></script>
        <script>
             var sl = 0;
            function add2cart(SKU) {
                sl += 1;
                $(".fa-cart-arrow-down").text(sl);
                $.ajax({
                    method: "GET",
                    url: "addtocart",
                    data: {SKU: SKU}
                });
            }
        </script>
    </body>
</html>
