<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header id="topnav">
    <!-- Topbar Start -->
    <div class="navbar-custom">
        <div class="container-fluid">
            <ul class="list-unstyled topnav-menu float-right mb-0">

                <li class="dropdown notification-list">
                    <!-- Mobile menu toggle-->
                    <a class="navbar-toggle nav-link">
                        <div class="lines">
                            <span></span>
                            <span></span>
                            <span></span>
                        </div>
                    </a>
                    <!-- End mobile menu toggle-->
                </li>

                <li class="dropdown d-none d-lg-block">
                    <a class="nav-link dropdown-toggle mr-0" data-toggle="dropdown" href="#" role="button"
                       aria-haspopup="false" aria-expanded="false">
                        <img src="/assets\images\flags\us.jpg" alt="user-image" class="mr-2" height="12"> <span
                            class="align-middle">English <i class="mdi mdi-chevron-down"></i> </span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <img src="/assets\images\flags\germany.jpg" alt="user-image" class="mr-2" height="12"> <span
                                class="align-middle">German</span>
                        </a>

                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <img src="/assets\images\flags\italy.jpg" alt="user-image" class="mr-2" height="12"> <span
                                class="align-middle">Italian</span>
                        </a>

                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <img src="/assets\images\flags\spain.jpg" alt="user-image" class="mr-2" height="12"> <span
                                class="align-middle">Spanish</span>
                        </a>

                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <img src="/assets\images\flags\russia.jpg" alt="user-image" class="mr-2" height="12"> <span
                                class="align-middle">Russian</span>
                        </a>
                    </div>
                </li>

                <li class="dropdown notification-list">
                    <a class="nav-link dropdown-toggle  waves-effect waves-light" data-toggle="dropdown" href="#"
                       role="button" aria-haspopup="false" aria-expanded="false">
                        <i class="mdi mdi-bell noti-icon"></i>
                        <span class="badge badge-success rounded-circle noti-icon-badge">4</span>
                        <div class="noti-dot">
                            <span class="dot"></span>
                            <span class="pulse"></span>
                        </div>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-lg">

                        <!-- item-->
                        <div class="dropdown-item noti-title">
                            <h5 class="font-16 m-0">
                                                            <span class="float-right">
                                                                <a href="" class="text-dark">
                                                                    <small>Clear All</small>
                                                                </a>
                                                            </span>Notification
                            </h5>
                        </div>

                        <div class="slimscroll noti-scroll">

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon bg-success">
                                    <i class="mdi mdi-settings-outline"></i>
                                </div>
                                <p class="notify-details">New settings
                                    <small class="text-muted">There are new settings available</small>
                                </p>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon bg-info">
                                    <i class="mdi mdi-bell-outline"></i>
                                </div>
                                <p class="notify-details">Updates
                                    <small class="text-muted">There are 2 new updates available</small>
                                </p>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon bg-danger">
                                    <i class="mdi mdi-account-plus"></i>
                                </div>
                                <p class="notify-details">New user
                                    <small class="text-muted">You have 10 unread messages</small>
                                </p>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon bg-info">
                                    <i class="mdi mdi-comment-account-outline"></i>
                                </div>
                                <p class="notify-details">Caleb Flakelar commented on Admin
                                    <small class="text-muted">4 days ago</small>
                                </p>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon bg-secondary">
                                    <i class="mdi mdi-heart"></i>
                                </div>
                                <p class="notify-details">Carlos Crouch liked
                                    <b>Admin</b>
                                    <small class="text-muted">13 days ago</small>
                                </p>
                            </a>
                        </div>

                        <!-- All-->
                        <a href="javascript:void(0);"
                           class="dropdown-item text-center text-primary notify-item notify-all">
                            See all Notification
                            <i class="fi-arrow-right"></i>
                        </a>

                    </div>
                </li>

                <li class="dropdown notification-list">
                    <a class="nav-link dropdown-toggle  waves-effect waves-light" data-toggle="dropdown" href="#"
                       role="button" aria-haspopup="false" aria-expanded="false">
                        <i class="mdi mdi-email noti-icon"></i>
                        <span class="badge badge-danger rounded-circle noti-icon-badge">8</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-lg">

                        <!-- item-->
                        <div class="dropdown-item noti-title">
                            <h5 class="font-16 m-0">
                                                            <span class="float-right">
                                                                <a href="" class="text-dark">
                                                                    <small>Clear All</small>
                                                                </a>
                                                            </span>Messages
                            </h5>
                        </div>

                        <div class="slimscroll noti-scroll">

                            <div class="inbox-widget">
                                <a href="#">
                                    <div class="inbox-item">
                                        <div class="inbox-item-img"><img src="/assets\images\users\avatar-1.jpg"
                                                                         class="rounded-circle" alt=""></div>
                                        <p class="inbox-item-author">Chadengle</p>
                                        <p class="inbox-item-text text-truncate">Hey! there I'm available...</p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="inbox-item">
                                        <div class="inbox-item-img"><img src="/assets\images\users\avatar-2.jpg"
                                                                         class="rounded-circle" alt=""></div>
                                        <p class="inbox-item-author">Tomaslau</p>
                                        <p class="inbox-item-text text-truncate">I've finished it! See you so...</p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="inbox-item">
                                        <div class="inbox-item-img"><img src="/assets\images\users\avatar-3.jpg"
                                                                         class="rounded-circle" alt=""></div>
                                        <p class="inbox-item-author">Stillnotdavid</p>
                                        <p class="inbox-item-text text-truncate">This theme is awesome!</p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="inbox-item">
                                        <div class="inbox-item-img"><img src="/assets\images\users\avatar-4.jpg"
                                                                         class="rounded-circle" alt=""></div>
                                        <p class="inbox-item-author">Kurafire</p>
                                        <p class="inbox-item-text text-truncate">Nice to meet you</p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="inbox-item">
                                        <div class="inbox-item-img"><img src="/assets\images\users\avatar-5.jpg"
                                                                         class="rounded-circle" alt=""></div>
                                        <p class="inbox-item-author">Shahedk</p>
                                        <p class="inbox-item-text text-truncate">Hey! there I'm available...</p>

                                    </div>
                                </a>
                            </div> <!-- end inbox-widget -->

                        </div>

                        <!-- All-->
                        <a href="javascript:void(0);"
                           class="dropdown-item text-center text-primary notify-item notify-all">
                            See all Messages
                            <i class="fi-arrow-right"></i>
                        </a>


                    </div>
                </li>

                <li class="dropdown notification-list">
                    <a class="nav-link dropdown-toggle nav-user mr-0 waves-effect waves-light" data-toggle="dropdown"
                       href="#" role="button" aria-haspopup="false" aria-expanded="false">
                        <img src="/assets\images\users\avatar-1.jpg" alt="user-image" class="rounded-circle">
                    </a>
                    <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
                        <!-- item-->
                        <div class="dropdown-header noti-title">
                            <h6 class="text-overflow m-0">Welcome !</h6>
                        </div>

                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <i class="mdi mdi-account-outline"></i>
                            <span>Profile</span>
                        </a>

                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <i class="mdi mdi-settings-outline"></i>
                            <span>Settings</span>
                        </a>

                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <i class="mdi mdi-lock-outline"></i>
                            <span>Lock Screen</span>
                        </a>

                        <div class="dropdown-divider"></div>

                        <!-- item-->
                        <a href="/index.jsp" class="dropdown-item notify-item">
                            <i class="mdi mdi-logout-variant"></i>
                            <span>Logout</span>
                        </a>

                    </div>
                </li>

                <li class="dropdown notification-list">
                    <a href="javascript:void(0);" class="nav-link right-bar-toggle waves-effect waves-light">
                        <i class="mdi mdi-settings-outline noti-icon"></i>
                    </a>
                </li>

            </ul>

            <!-- LOGO -->
            <div class="logo-box">
                <a href="\index.jsp" class="logo text-center">
                                    <span class="logo-lg">
                                        <img src="/assets\images\logo.png" alt="" height="30">
                                        <!-- <span class="logo-lg-text-light">Zircos</span> -->
                                    </span>
                    <span class="logo-sm">
                                        <!-- <span class="logo-sm-text-dark">Z</span> -->
                                        <img src="/assets\images\logo-sm.png" alt="" height="22">
                                    </span>
                </a>
            </div>


            <ul class="list-unstyled topnav-menu topnav-menu-left m-0">

                <li class="d-none d-sm-block">
                       <form action="/students?action=search" class="app-search" method="post">
                           <div class="app-search-box">
                               <div class="input-group">
                                   <input type="text" name="txtSearch" class="form-control" placeholder="Search...">
                                   <div class="input-group-append">
                                       <button class="btn" type="submit">
                                           <i class="fas fa-search"></i>
                                       </button>
                                   </div>
                               </div>
                           </div>
                       </form>
                </li>
            </ul>
            <div class="clearfix"></div>
        </div>
    </div>
    <!-- end Topbar -->

    <div class="topbar-menu">
        <div class="container-fluid">
            <div id="navigation">
                <!-- Navigation Menu-->
                <ul class="navigation-menu">

                    <li class="has-submenu">
                        <a href="#"> <i class="mdi mdi-view-dashboard"></i>Dashboard</a>
                        <ul class="submenu">
                            <li><a href="index.html">Dashboard 1</a></li>
                            <li><a href="dashboard_2.html">Dashboard 2</a></li>
                        </ul>
                    </li>
                    <li class="has-submenu">
                        <a href="#">
                            <i class="mdi mdi-diamond-stone"></i>Components
                        </a>
                        <ul class="submenu">
                            <li class="has-submenu">
                                <a href="#">Forms
                                    <div class="arrow-down"></div>
                                </a>
                                <ul class="submenu">
                                    <li class="active"><a href="/customers?action=create">Form Customer Create</a></li>
                                    <li class="active"><a href="/customers?action=Edit">Form Customer Edit</a></li>
                                    <li class="active"><a href="/countrys?action=create">Form Country Create</a></li>
                                    <li class="active"><a href="/customers?action=edit">Form Country Edit</a></li>
                                </ul>
                            </li>
                            <li class="has-submenu">
                                <a href="#">Tables
                                    <div class="arrow-down"></div>
                                </a>
                                <ul class="submenu">
                                    <li><a href="/customers">Basic Tables</a></li>
                                    <li><a href="/countrys">Tables Country</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>

                    <li class="has-submenu">
                    </li>
                    <li class="has-submenu">
                    </li>

                </ul>
                <!-- End navigation menu -->

                <div class="clearfix"></div>
            </div>
            <!-- end #navigation -->
        </div>
        <!-- end container -->
    </div>
    <!-- end navbar-custom -->
</header>