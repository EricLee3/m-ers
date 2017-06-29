<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@include file="../include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <title>VoiceCream / 미래손 감정분석 솔루션</title>
   <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
   <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
   <link rel="stylesheet" href="/resources/css/font-awesome.min.css">
   <link rel="stylesheet" href="/resources/css/ionicons.min.css">
   <link rel="stylesheet" href="/resources/css/AdminLTE.min.css">
   <link rel="stylesheet" href="/resources/css/skins/_all-skins.min.css">
   <link rel="stylesheet" href="/resources/plugins/ionslider/ion.rangeSlider.css">
     <link rel="stylesheet" href="/resources/plugins/ionslider/ion.rangeSlider.skinHTML5.css">
     <link rel="stylesheet" href="/resources/plugins/morris/morris.css">
     <link rel="stylesheet" href="/resources/css/migam.css">
   <!--[if lt IE 9]>
   <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
   <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
   <![endif]-->
   <script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
   <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
   <script src="https://www.amcharts.com/lib/3/pie.js"></script>
   <script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
   <script src="/resources/bootstrap/js/bootstrap.min.js"></script>
   <script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
   <script src="/resources/plugins/fastclick/fastclick.js"></script>
   <script src="/resources/js/app.min.js"></script>
   <script src="/resources/plugins/raphael/raphael-min.js"></script>
   <script src="/resources/plugins/morris/morris.min.js"></script>
   <script src="/resources/plugins/chartjs/Chart.min.js"></script>
   <script src="/resources/plugins/ionslider/ion.rangeSlider.min.js"></script>

   <!-- Ionicons -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
   <link rel="stylesheet" href="/resources/select2test/css/AdminLTE.min.css">
   <!-- AdminLTE Skins. Choose a skin from the css/skins
        folder instead of downloading all of them to reduce the load. -->
   <link rel="stylesheet" href="/resources/select2test/css/_all-skins.min.css">
   
</head>
<script type="text/javascript">
/*
$(document).ready(function(){
	if("${login}" == "1") {
		if (confirm("이미 접속중입니다. 기존의 접속을 종료하시겠습니까?") == true){
	        location.replace("main");
	     }else {
	       alert('중복로그인은 허용되지 않습니다. 로그인 페이지로 이동합니다.');
	       location.replace("login");
	     }
	}
	
});
*/
function side(gubun){
	
	document.getElementById('agent_list').setAttribute("class","");
	document.getElementById('call_list').setAttribute("class","");
	document.getElementById('call_report').setAttribute("class","");
	document.getElementById('customer_report').setAttribute("class","");
	document.getElementById('hour_report').setAttribute("class","");
	document.getElementById('day_report').setAttribute("class","");
	document.getElementById('month_report').setAttribute("class","");
	document.getElementById('agent_report').setAttribute("class","");
	document.getElementById('performance_report').setAttribute("class","");
	document.getElementById('batch_list').setAttribute("class","");
	document.getElementById('batch_log').setAttribute("class","");
	document.getElementById('config_limit').setAttribute("class","");
	document.getElementById('license').setAttribute("class","");
	document.getElementById('user_list').setAttribute("class","");
	document.getElementById('s_agent_list').setAttribute("class","");
	document.getElementById('group_list').setAttribute("class","");
	document.getElementById('alarm_code').setAttribute("class","");
	document.getElementById('alarm_limit').setAttribute("class","");
	document.getElementById('resource_log').setAttribute("class","");
	document.getElementById('alarm_log').setAttribute("class","");
	document.getElementById('his_log').setAttribute("class","");
	document.getElementById('fault_alarm_log').setAttribute("class","");
	document.getElementById('sens_meta').setAttribute("class","");
	document.getElementById('sens_conf').setAttribute("class","");
	document.getElementById('pro_meta').setAttribute("class","");
	document.getElementById('pro_conf').setAttribute("class","");
	document.getElementById('sens_basic').setAttribute("class","");
	document.getElementById('sens_demo').setAttribute("class","");
	
	
   if(gubun == 0){
      document.getElementById('agent_list').setAttribute("class","active");
   }else if(gubun == 1){
	  document.getElementById('call_list').setAttribute("class","active");
   }else if(gubun == 2){
	  document.getElementById('call_report').setAttribute("class","active");
   }else if(gubun == 3){
	  document.getElementById('customer_report').setAttribute("class","active");
   }else if(gubun == 4){
	  document.getElementById('hour_report').setAttribute("class","active");
   }else if(gubun == 5){
	  document.getElementById('day_report').setAttribute("class","active");
   }else if(gubun == 6){
	  document.getElementById('month_report').setAttribute("class","active");
   }else if(gubun == 7){
	  document.getElementById('agent_report').setAttribute("class","active");
   }else if(gubun == 8){
	  document.getElementById('performance_report').setAttribute("class","active");
   }else if(gubun == 9){
	  document.getElementById('batch_list').setAttribute("class","active");
   }else if(gubun == 10){
	  document.getElementById('batch_log').setAttribute("class","active");
   }else if(gubun == 11){
	  document.getElementById('config_limit').setAttribute("class","active");
   }else if(gubun == 12){
	  document.getElementById('license').setAttribute("class","active");
   }else if(gubun == 13){
	  document.getElementById('user_list').setAttribute("class","active");
   }else if(gubun == 14){
	  document.getElementById('s_agent_list').setAttribute("class","active");
   }else if(gubun == 15){
	  document.getElementById('group_list').setAttribute("class","active");
   }else if(gubun == 16){
	  document.getElementById('alarm_code').setAttribute("class","active");
   }else if(gubun == 17){
	  document.getElementById('alarm_limit').setAttribute("class","active");
   }else if(gubun == 18){
	  document.getElementById('resource_log').setAttribute("class","active");
   }else if(gubun == 19){
	  document.getElementById('alarm_log').setAttribute("class","active");
   }else if(gubun == 20){
	  document.getElementById('his_log').setAttribute("class","active");
   }else if(gubun == 21){
	  document.getElementById('fault_alarm_log').setAttribute("class","active");
   }else if(gubun == 22){
	  document.getElementById('sens_meta').setAttribute("class","active");
   }else if(gubun == 23){
	  document.getElementById('sens_conf').setAttribute("class","active");
   }else if(gubun == 24){
	  document.getElementById('pro_meta').setAttribute("class","active");
   }else if(gubun == 25){
	  document.getElementById('pro_conf').setAttribute("class","active");
   }else if(gubun == 26){
	  document.getElementById('sens_basic').setAttribute("class","active");
   }else if(gubun == 27){
	  document.getElementById('sens_demo').setAttribute("class","active");
   }
   
   
}


</script>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="/" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>ME</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg">VoiceCream</span>
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
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="/resources/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>
          	 ${sessionScope.sessionUser.currentUser.userName }님 
          </p>
        </div>
      </div>
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
		<li class="treeview active">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>모니터</span> <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
<c:choose>
	<c:when test="${menuCategory eq 'monitor' && menu eq 'agent'}">
			<li class="active"><a href="/monitor/agent_list" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 상담원 목록</font></a></li>
	</c:when>
	<c:otherwise>
			<li class="" id="agent_list"><a href="/monitor/agent_list" target="iframe" onclick="side(0);"><i class="fa fa-circle-o"></i> 상담원 목록</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'monitor' && menu eq 'call'}">
			<li class="active"><a href="/monitor/call_list" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 콜 목록</font></a></li>
	</c:when>
	<c:otherwise>
			<li class="" id="call_list"><a href="/monitor/call_list"  target="iframe"  onclick="side(1);"><i class="fa fa-circle-o"></i> 콜 목록</a></li>
	</c:otherwise>
</c:choose>
          </ul>
        </li>
        
		<li class="treeview active">
          <a href="#">
            <i class="fa fa-files-o"></i>
            <span>리포트</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
<c:choose>
	<c:when test="${menuCategory eq 'report' && menu eq 'call_report'}">
			<li class="active"><a href="/report/call_report" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 콜별 리포트</font></a></li>
	</c:when>
	<c:otherwise>
			<li class="" id="call_report"><a href="/report/call_report" target="iframe" onclick="side(2);"><i class="fa fa-circle-o"></i> 콜별 리포트</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'report' && menu eq 'customer_report'}">
			<li class="active"><a href="/report/customer_report" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 고객 리포트</font></a></li>
	</c:when>
	<c:otherwise>
			<li class="" id="customer_report"><a href="/report/customer_report" target="iframe" onclick="side(3);"><i class="fa fa-circle-o"></i> 고객 리포트</a></li>
	</c:otherwise>
</c:choose>
          </ul>
        </li>

		<li class="treeview active">
          <a href="#">
            <i class="fa fa-line-chart"></i>
            <span>통계</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
<c:choose>
	<c:when test="${menuCategory eq 'report' && menu eq 'hour_report'}">
			<li class="active"><a href="/report/hour_report"  target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 시간대별 통계</font></a></li>
	</c:when>
	<c:otherwise>
			<li class="" id="hour_report"><a href="/report/hour_report" target="iframe" onclick="side(4);"><i class="fa fa-circle-o"></i> 시간대별 통계</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'report' && menu eq 'day_report'}">
			<li class="active"><a href="/report/day_report" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 일별 통계</font></a></li>
	</c:when>
	<c:otherwise>
			<li class="" id="day_report"><a href="/report/day_report" target="iframe" onclick="side(5);"><i class="fa fa-circle-o"></i> 일별 통계</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'report' && menu eq 'month_report'}">
			<li class="active"><a href="/report/month_report"  target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 월별 통계</font></a></li>
	</c:when>
	<c:otherwise>
			<li class="" id="month_report"><a href="/report/month_report" target="iframe" onclick="side(6);"><i class="fa fa-circle-o"></i> 월별 통계</a></li>
	</c:otherwise>
</c:choose>
<!-- <c:choose>
	<c:when test="${menuCategory eq 'report' && menu eq 'week_report'}">
			<li class="active"><a href="/report/week_report"><i class="fa fa-circle-o"></i> 주간별 통계</a></li>
	</c:when>
	<c:otherwise>
			<li><a href="/report/week_report"><i class="fa fa-circle-o"></i> 주간별 통계</a></li>
	</c:otherwise>
</c:choose>-->
<c:choose>
	<c:when test="${menuCategory eq 'report' && menu eq 'agent_report'}">
			<li class="active"><a href="/report/agent_report" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 상담원별 통계</font></a></li>
	</c:when>
	<c:otherwise>
			<li class="" id="agent_report"><a href="/report/agent_report" target="iframe" onclick="side(7);"><i class="fa fa-circle-o"></i> 상담원별 통계</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'report' && menu eq 'performance_report'}">
			<li class="active"><a href="/report/performance_report" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 근무성과별 통계</font></a></li>
	</c:when>
	<c:otherwise>
			<li class="" id="performance_report"><a href="/report/performance_report" target="iframe" onclick="side(8);"><i class="fa fa-circle-o"></i> 근무성과별 통계</a></li>
	</c:otherwise>
</c:choose>
          </ul>
        </li>

		<li class="treeview active">
          <a href="#">
            <i class="fa fa-th"></i>
            <span>시스템</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
			<li class="active">
              <a href="#"><i class="fa fa-circle-o"></i> 서비스 설정  <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
<c:choose>
	<c:when test="${menuCategory eq 'service' && menu eq 'sens_demo'}">
				<li class="active"><a href="/system/sens_demo" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 감성 분석 데모</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="sens_demo"><a href="/system/sens_demo" target="iframe" onclick="side(27);"><i class="fa fa-circle-o"></i> 감성 분석 데모</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'service' && menu eq 'batch'}">
				<li class="active"><a href="/service/batch_list" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 자동 수행 작업 목록</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="batch_list"><a href="/service/batch_list" target="iframe" onclick="side(9);"><i class="fa fa-circle-o"></i> 자동 수행 작업 목록</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'service' && menu eq 'batch_log'}">
				<li class="active"><a href="/service/batch_log" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 자동 수행 작업 이력</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="batch_log"><a href="/service/batch_log" target="iframe" onclick="side(10);"><i class="fa fa-circle-o"></i> 자동 수행 작업 이력</a></li>
	</c:otherwise>
</c:choose>
<!-- 
<c:choose>
	<c:when test="${menuCategory eq 'service' && menu eq 'config'}">
				<li class="active"><a href="/service/config_limit" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 임계치 설정</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="config_limit"><a href="/service/config_limit" target="iframe" onclick="side(11);"><i class="fa fa-circle-o"></i> 임계치 설정</a></li>
	</c:otherwise>
</c:choose>
 -->

<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'sens_conf'}">
				<li class="active"><a href="/system/sens_conf" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 감성지표 설정</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="sens_conf"><a href="/system/sens_conf" target="iframe" onclick="side(23);"><i class="fa fa-circle-o"></i> 감성지표 설정</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'pro_conf'}">
				<li class="active"><a href="/system/pro_conf" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 프로파일 설정</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="pro_conf"><a href="/system/pro_conf" target="iframe" onclick="side(25);"><i class="fa fa-circle-o"></i> 프로파일 설정</a></li>
	</c:otherwise>
</c:choose>
              </ul>
            </li>          
<c:if test="${sessionScope.sessionUser.superUser}" >
			<li class="active">
              <a href="#"><i class="fa fa-circle-o"></i> 시스템 설정  <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'license'}">
				<li class="active"><a href="/system/license"  target="iframe"style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 라이선스 설정</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="license" ><a href="/system/license" target="iframe" onclick="side(12);"><i class="fa fa-circle-o"></i> 라이선스 설정</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'user'}">
				<li class="active"><a href="/system/user_list" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 사용자 목록</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="user_list" ><a href="/system/user_list" target="iframe" onclick="side(13);"><i class="fa fa-circle-o"></i> 사용자 목록</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'agent'}">
				<li class="active"><a href="/system/agent_list" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 상담원 목록</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="s_agent_list"><a href="/system/agent_list" target="iframe" onclick="side(14);"><i class="fa fa-circle-o"></i> 상담원 목록</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'group'}">
				<li class="active"><a href="/system/group_list" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 그룹 관리</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="group_list"><a href="/system/group_list" target="iframe" onclick="side(15);"><i class="fa fa-circle-o"></i> 그룹 관리</a></li>
	</c:otherwise>
</c:choose>
<!--  
<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'segment'}">
				<li class="active"><a href="/system/segment_list"><i class="fa fa-circle-o"></i> 시스템 상태 관리</a></li>
	</c:when>
	<c:otherwise>
				<li><a href="/system/segment_list"><i class="fa fa-circle-o"></i> 시스템 상태 관리</a></li>
	</c:otherwise>
</c:choose>
-->
<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'alarmCode'}">
				<li class="active"><a href="/system/alarm_code" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 알람 코드 설정</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="alarm_code"><a href="/system/alarm_code" target="iframe" onclick="side(16);"><i class="fa fa-circle-o"></i> 알람 코드 설정</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'alarmLimit'}">
				<li class="active"><a href="/system/alarm_limit"  target="iframe"style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 알람 임계치 설정</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="alarm_limit"><a href="/system/alarm_limit" target="iframe" onclick="side(17);"><i class="fa fa-circle-o"></i> 알람 임계치 설정</a></li>
	</c:otherwise>
</c:choose>
<c:choose> 
	<c:when test="${menuCategory eq 'system' && menu eq 'sens_basic'}">
				<li class="active"><a href="/system/sens_basic" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 기본 감성지표 관리 </font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="sens_basic"><a href="/system/sens_basic" target="iframe" onclick="side(26);"><i class="fa fa-circle-o"></i> 기본 감성지표 관리 </a></li>
	</c:otherwise>
</c:choose>
<c:choose> 
	<c:when test="${menuCategory eq 'system' && menu eq 'sens_meta'}">
				<li class="active"><a href="/system/sens_meta" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 서비스 감성 지표 기초 정보 관리</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="sens_meta"><a href="/system/sens_meta" target="iframe" onclick="side(22);"><i class="fa fa-circle-o"></i> 서비스 감성 지표 기초 정보 관리</a></li>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'pro_meta'}">
				<li class="active"><a href="/system/pro_meta" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 프로파일 기초정보 설정</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="pro_meta"><a href="/system/pro_meta" target="iframe" onclick="side(24);"><i class="fa fa-circle-o"></i> 프로파일 기초정보 설정</a></li>
	</c:otherwise>
</c:choose>
</c:if>
</ul>
            </li>  
<c:if test="${sessionScope.sessionUser.superUser}" >
			<li class="active">
              <a href="#"><i class="fa fa-circle-o"></i> 시스템 이력  <i class="fa fa-angle-left pull-right"></i></a>
              <ul class="treeview-menu">
<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'resource'}">
				<li class="active"><a href="/system/resource_log" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 리소스 이력</font></a></li>
	</c:when>
	<c:otherwise>
				<li  class="" id="resource_log"><a href="/system/resource_log" target="iframe" onclick="side(18);"><i class="fa fa-circle-o"></i> 리소스 이력</a></li>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'alarmLog'}">
				<li class="active"><a href="/system/alarm_log" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 알람 이력</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="alarm_log"><a href="/system/alarm_log" target="iframe" onclick="side(19);"><i class="fa fa-circle-o"></i> 알람 이력</a></li>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'hisLog'}">
				<li class="active"><a href="/system/his_log" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> 운영자 조작 이력</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="his_log"><a href="/system/his_log" target="iframe" onclick="side(20);"><i class="fa fa-circle-o"></i> 운영자 조작 이력</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'faultalarmLog'}">
				<li class="active"><a href="/system/fault_alarm_log" target="iframe" style="color: #1E90FF;"><i class="fa fa-circle-o"></i><font style="color: #1E90FF;"> Fault 알람 이력</font></a></li>
	</c:when>
	<c:otherwise>
				<li class="" id="fault_alarm_log"><a href="/system/fault_alarm_log" target="iframe" onclick="side(21);"><i class="fa fa-circle-o"></i> Fault 알람 이력</a></li>
	</c:otherwise>
</c:choose>
</c:if>
			</ul>
          </ul>
        </li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
  
   <div class="content-wrapper">
      <!-- Content Header (Page header) -->
   
      <!-- Main content -->
   	 <section class="content">
            <iframe src="/main4" width="100%"  scrolling="no" frameborder="0" border="0" bordercolor="#000000" marginwidth="0" marginheight="0" name="iframe" id="iframe"></iframe>
     </section>
      </div>
   </div>

   <!-- /.content-wrapper -->

   <%@include file="../include/footer.jsp" %>

   <!-- Modal 콜 상세 조회 -->
   <div class="modal fade" id="modalCallDetail" tabindex="-1" role="dialog" aria-labelledby="modalCallDetailLabel">
      <!-- /.modal-dialog -->
   </div>


</div>
<script>
 function resize_frame(id) {
 var frm = document.getElementById("iframe");
 function resize() {
 var ms_ie = false;
  var ua = window.navigator.userAgent;
  var old_ie = ua.indexOf('MSIE ');
  var new_ie = ua.indexOf('Trident/');
 
  if ((old_ie > -1) || (new_ie > -1)) {
   ms_ie = true;
  }
 
  if ( ms_ie ) {
   //IE specific code goes here
  var iframeHeight=frm.contentWindow.document.body.scrollHeight;
  frm.height=iframeHeight+20;
  }else{
  frm.style.height = "auto"; // set default height for Opera
  contentHeight = frm.contentWindow.document.documentElement.scrollHeight;
  frm.style.height = contentHeight + 23 + "px"; // 23px for IE7
  }
 }
 if (frm.addEventListener) {
 frm.addEventListener('load', resize, false);
 } else {
 frm.attachEvent('onload', resize);
 }
}
resize_frame('iframe'); 
</script>
</body>
</html>