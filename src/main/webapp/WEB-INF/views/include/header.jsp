<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="taglib.jsp"%>
  <header class="main-header">
    <!-- Logo -->
    <a href="/" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>ME</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>VoiceCream</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="/resources/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">${sessionScope.sessionUser.currentUser.userName}(${sessionScope.sessionUser.currentUser.userId})</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="/resources/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  	${sessionScope.sessionUser.currentUser.org } - ${sessionScope.sessionUser.currentUser.userName}
                  <small><fmt:formatDate pattern = "yyyy. MM. dd" value="${sessionScope.sessionUser.currentUser.createDate}" /></small>
                </p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="#" class="btn btn-default btn-flat jsLogout">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <script>
  	$(document).ready(function(){
  		$(document).on("click", ".jsLogout", function(e){
  			e.preventDefault();
  			location.href="/logout";
  		})
  	});
  </script>