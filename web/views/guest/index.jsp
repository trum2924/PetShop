<%-- 
    Document   : index
    Created on : Jul 1, 2019, 8:43:01 PM
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
        <!-- //short-->
        <!--show Now-->
        <!--show Now-->
        <section class="contact py-lg-4 py-md-3 py-sm-3 py-3">
            <div class="container-fluid py-lg-5 py-md-4 py-sm-4 py-3">
                <h3 class="title text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">Show Room</h3>

                <div class="row">
                    <div class="side-bar col-lg-3">
                        <div class="search-hotel">
                            <h3 class="agileits-sear-head">Tìm kiếm sản phẩm</h3>

                            <input type="search" placeholder="Tên sản phẩm" id="nameSearch" required="">
                            <input value=" ">

                        </div>
                        <!-- price range -->
                        <div class="range">
                            <h3 class="agileits-sear-head">Khoảng giá</h3>
                            <ul class="dropdown-menu6">
                                <li>
                                    <div id="slider-range"></div>
                                    <input type="text" id="amount" style="border: 0; color: #ffffff; font-weight: normal;" />
                                </li>
                            </ul>
                        </div>
                        <!-- //price range -->
                        <!--preference -->
                        <div class="left-side">
                            <h3 class="agileits-sear-head">Thú cưng</h3>
                            <ul>
                                <select style="width: 50%" id="petSearch">
                                    <option value="-1"> Tất cả Pet</option>
                                    <s:iterator value="CachePet">
                                        <option value=<s:property value="id"/>><s:property value="name"/></option>
                                    </s:iterator>
                                </select>

                            </ul>
                        </div>
                        <!-- // preference -->
                        <!-- discounts -->
                        <div class="left-side">
                            <h3 class="agileits-sear-head">Nhóm</h3>
                            <select style="width: 50%" id="cateSearch">
                                <option value="-1"> Tất cả Nhóm</option>
                                <s:iterator value="CacheCate">
                                    <option value=<s:property value="id"/>><s:property value="name"/></option>
                                </s:iterator>
                            </select>
                            <%--<s:select list="CacheCate" listValue="name" name="cateSearch" headerKey="-1" headerValue="Tất cả Nhóm" cssStyle="width: 50%" />--%>

                            <!--                           
<select style="width: 50%">
                                <option>
                                    Tất cả Nhóm
                                </option>
                                
                            </select>-->
                        </div>
                        <div class="left-side">
                            <h3 class="agileits-sear-head">Nhãn hiệu</h3>

                            <select style="width: 50%" id="brandSearch">
                                <option value="-1"> Tất cả Nhãn hiệu</option>
                                <s:iterator value="CacheBrand">
                                    <option value=<s:property value="id"/>><s:property value="name"/></option>
                                </s:iterator>
                            </select>
                            <%--<s:select list="CacheBrand" listValue="name" name="brandSearch" headerKey="-1" headerValue="Tất cả Nhãn Hiệu" cssStyle="width: 50%"/>--%>

                            <!--                            <select style="width: 50%">
                                                            <option>
                                                                Tất cả nhãn hiệu
                                                            </option>
                            <%--<s:iterator value="CacheBrand">--%>
                                <option>
                            <%--<s:property value="%{name}"/>--%>
                        </option>
                            <%--</s:iterator>--%>
                        </select>-->
                        </div>
                        <!-- //discounts -->
                        <!-- deals -->
                        <div class="deal-leftmk left-side">
                            <h3 class="agileits-sear-head">Gợi ý cho bạn</h3>

                            <s:iterator value="CacheProductAds">
                                <div class="special-sec1">
                                    <div class="col-xs-4 img-deals">
                                        <img onerror="this.src='https://www.petcity.vn//media/product/3655_untitle7969d.jpg';" src="<s:property value="image"/>" alt="" class="img-fluid">
                                    </div>
                                    <div class="col-xs-8 img-deal1">
                                        <h3><s:property value="name"/></h3>
                                        <a><s:property value="price"/>k</a>
                                        <form action="viewDetail">
                                            <input type="hidden" name="SKU" value="<s:property value="SKU"/>"/>
                                            <input type="submit" class="link-product-add-cart" value="Xem chi tiết">
                                        </form>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </s:iterator>

                        </div>
                        <!-- //deals -->
                    </div>
                    <div class="left-ads-display col-lg-9">
                        <div class="pagination">

                            <a class="active">1</a>
                            <a >2</a>
                            <a >3</a>
                            <a >4</a>
                            <a >5</a>
                            <a >6</a>

                        </div>
                        <div class="row" id="ShowSearch">


                            <s:iterator value="CacheProduct">
                                <div class="col-lg-4 col-md-6 col-sm-6 product-men women_two">
                                    <div class="product-toys-info">
                                        <div class="men-pro-item">
                                            <div class="men-thumb-item">
                                                <img onerror="this.src='https://www.petcity.vn//media/product/3655_untitle7969d.jpg';" src="<s:property value='image'/>" class="img-thumbnail img-fluid" alt="">
                                                <div class="men-cart-pro">
                                                    <div class="inner-men-cart-pro">
                                                        <form action="viewDetail">
                                                            <input type="hidden" name="SKU" value="<s:property value="SKU"/>"/>
                                                            <input type="submit" class="link-product-add-cart" value="Xem chi tiết">
                                                        </form>
                                                    </div>
                                                </div>

                                            </div>
                                            <div class="item-info-product">
                                                <div class="info-product-price">
                                                    <div class="grid_meta">
                                                        <div class="product_price">
                                                            <h4>
                                                                <a><s:property value="name"/></a>
                                                            </h4>
                                                            <div class="grid-price mt-2">
                                                                <span class="money "><s:property value="price"/>k</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="toys single-item hvr-outline-out">


                                                        <button class="toys-cart ptoys-cart" onclick="add2cart('<s:property value="SKU"/>')">
                                                            <i class="fas fa-cart-plus"></i>
                                                        </button>

                                                    </div>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </s:iterator>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- //show Now-->
        <!--subscribe-address-->
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
        <!-- //footer -->
        <!-- Modal 1-->

        <!-- //Modal 1-->
        <!--js working-->
        <script src='views/guest/js/jquery-2.2.3.min.js'></script>
        <!--//js working-->
        <!-- cart-js -->
        <script src="views/guest/js/minicart.js"></script>
        <!-- //cart-js -->
        <!-- price range (top products) -->
        <script src="views/guest/js/jquery-ui.js"></script>
        <script>
                                                            //<![CDATA[ 
                                                            $(window).load(function () {
                                                                $("#slider-range").slider({
                                                                    range: true,
                                                                    min: 0,
                                                                    max: 1000,
                                                                    values: [0, 500],
                                                                    slide: function (event, ui) {
                                                                        $("#amount").val(ui.values[0] + "k - " + ui.values[1] + "k");
                                                                        callAjax();
                                                                    }
                                                                });
                                                                $("#amount").val($("#slider-range").slider("values", 0) + "k - " + $("#slider-range").slider("values", 1) + "k");

                                                            }); //]]>
        </script>
        <!-- //price range (top products) -->
        <!-- start-smoth-scrolling -->
        <script src="views/guest/js/move-top.js"></script>
        <script src="views/guest/js/easing.js"></script>
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
        <!-- //here ends scrolling icon -->
        <!--bootstrap working-->
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



            function callAjax() {

                $.ajax({
                    method: "GET",
                    url: "Csearch",
                    data: {cateSearch: $("#cateSearch option:selected").attr('value'), petSearch: $("#petSearch option:selected").attr('value'), brandSearch: $("#brandSearch option:selected").attr('value'), priceB: $("#amount")[0].value.slice(0, $("#amount")[0].value.indexOf("k")), priceE: $("#amount")[0].value.slice($("#amount")[0].value.lastIndexOf(" ") + 1, $("#amount")[0].value.lastIndexOf("k")), nameSearch: $("#nameSearch").val()}
                })
                        .done(function (msg) {
                            $("#ShowSearch").html(msg);
                        });
            }

            $("#petSearch,#brandSearch,#cateSearch,#nameSearch").change(function () {
                callAjax();
            }
            );
            $(".pagination a").on('click',
                    function () {
                        $(".pagination a").removeClass("active");
                        $(this).addClass("active");
                        $.ajax({
                            method: "GET",
                            url: "CsearchPagin",
                            data: {numberPage: $(this).text()}
                        })
                                .done(function (msg) {
                                    $("#ShowSearch").html(msg);
                                });
                    }
            );
//            CsearchPagin
        </script>
        <!-- //bootstrap working-->
    </body>
</html>
