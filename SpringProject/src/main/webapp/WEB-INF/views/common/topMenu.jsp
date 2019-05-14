<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<header id="header">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 overflow">
                <div class="social-icons pull-right">
                    <ul class="nav nav-pills">
                        <c:choose>
                            <c:when test="${sessionScope.loginId != null}">
                                <a href="#">${sessionScope.loginId}</a>
                                <a href="/login/logout">로그아웃</a>
                            </c:when>
                            <c:otherwise>
                                <a href="/login/googleLogin" class="btn btn-common">로그인</a>
                            </c:otherwise>
                        </c:choose>

                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="navbar navbar-inverse" role="banner">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <a class="navbar-brand" href="/">
                    <h1><img src="/commons/images/logo.png" alt="logo"></h1>
                </a>

            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="/">Home</a></li>
                    <li class="dropdown"><a href="#">일정 만들기</a></li>
                        <ul role="menu" class="sub-menu">
                            <li><a href="aboutus.html">About</a></li>
                            <li><a href="aboutus2.html">About 2</a></li>
                            <li><a href="service.html">Services</a></li>
                            <li><a href="pricing.html">Pricing</a></li>
                            <li><a href="contact.html">Contact us</a></li>
                            <li><a href="contact2.html">Contact us 2</a></li>
                            <li><a href="404.html">404 error</a></li>
                            <li><a href="coming-soon.html">Coming Soon</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="blog.html">일정 공유공간 </a>
                        <ul role="menu" class="sub-menu">
                            <li><a href="blog.html">Blog Default</a></li>
                            <li><a href="blogtwo.html">Timeline Blog</a></li>
                            <li><a href="blogone.html">2 Columns + Right Sidebar</a></li>
                            <li><a href="blogthree.html">1 Column + Left Sidebar</a></li>
                            <li><a href="blogfour.html">Blog Masonary</a></li>
                            <li><a href="blogdetails.html">Blog Details</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="portfolio.html">여행지 추천 </a>
                        <ul role="menu" class="sub-menu">
                            <li><a href="portfolio.html">Portfolio Default</a></li>
                            <li><a href="portfoliofour.html">Isotope 3 Columns + Right Sidebar</a></li>
                            <li><a href="portfolioone.html">3 Columns + Right Sidebar</a></li>
                            <li><a href="portfoliotwo.html">3 Columns + Left Sidebar</a></li>
                            <li><a href="portfoliothree.html">2 Columns</a></li>
                            <li><a href="portfolio-details.html">Portfolio Details</a></li>
                        </ul>
                    </li>
                    <li><a href="shortcodes.html ">Shortcodes</a></li>
                </ul>
            </div>
            <div class="search">
                <form role="form">
                    <i class="fa fa-search"></i>
                    <div class="field-toggle">
                        <input type="text" class="search-form" autocomplete="off" placeholder="Search">
                    </div>
                </form>
            </div>
        </div>
    </div>
</header>
