<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<li class="active"><a href="/monitor/agent_list"><i class="fa fa-circle-o"></i> 상담원 목록</a></li>
	</c:when>
	<c:otherwise>
			<li><a href="/monitor/agent_list"><i class="fa fa-circle-o"></i> 상담원 목록</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'monitor' && menu eq 'call'}">
			<li class="active"><a href="/monitor/call_list"><i class="fa fa-circle-o"></i> 콜 목록</a></li>
	</c:when>
	<c:otherwise>
			<li><a href="/monitor/call_list"><i class="fa fa-circle-o"></i> 콜 목록</a></li>
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
			<li class="active"><a href="/report/call_report"><i class="fa fa-circle-o"></i> 콜별 리포트</a></li>
	</c:when>
	<c:otherwise>
			<li><a href="/report/call_report"><i class="fa fa-circle-o"></i> 콜별 리포트</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'report' && menu eq 'customer_report'}">
			<li class="active"><a href="/report/customer_report"><i class="fa fa-circle-o"></i> 고객 리포트</a></li>
	</c:when>
	<c:otherwise>
			<li><a href="/report/customer_report"><i class="fa fa-circle-o"></i> 고객 리포트</a></li>
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
			<li class="active"><a href="/report/hour_report"><i class="fa fa-circle-o"></i> 시간대별 통계</a></li>
	</c:when>
	<c:otherwise>
			<li><a href="/report/hour_report"><i class="fa fa-circle-o"></i> 시간대별 통계</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'report' && menu eq 'day_report'}">
			<li class="active"><a href="/report/day_report"><i class="fa fa-circle-o"></i> 일별 통계</a></li>
	</c:when>
	<c:otherwise>
			<li><a href="/report/day_report"><i class="fa fa-circle-o"></i> 일별 통계</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'report' && menu eq 'month_report'}">
			<li class="active"><a href="/report/month_report"><i class="fa fa-circle-o"></i> 월별 통계</a></li>
	</c:when>
	<c:otherwise>
			<li><a href="/report/month_report"><i class="fa fa-circle-o"></i> 월별 통계</a></li>
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
			<li class="active"><a href="/report/agent_report"><i class="fa fa-circle-o"></i> 상담원별 통계</a></li>
	</c:when>
	<c:otherwise>
			<li><a href="/report/agent_report"><i class="fa fa-circle-o"></i> 상담원별 통계</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'report' && menu eq 'performance_report'}">
			<li class="active"><a href="/report/performance_report"><i class="fa fa-circle-o"></i> 근무성과별 통계</a></li>
	</c:when>
	<c:otherwise>
			<li><a href="/report/performance_report"><i class="fa fa-circle-o"></i> 근무성과별 통계</a></li>
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
	<c:when test="${menuCategory eq 'service' && menu eq 'batch'}">
				<li class="active"><a href="/service/batch_list"><i class="fa fa-circle-o"></i> 자동 수행 작업 목록</a></li>
	</c:when>
	<c:otherwise>
				<li><a href="/service/batch_list"><i class="fa fa-circle-o"></i> 자동 수행 작업 목록</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'service' && menu eq 'batch_log'}">
				<li class="active"><a href="/service/batch_log"><i class="fa fa-circle-o"></i> 자동 수행 작업 이력</a></li>
	</c:when>
	<c:otherwise>
				<li><a href="/service/batch_log"><i class="fa fa-circle-o"></i> 자동 수행 작업 이력</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'service' && menu eq 'config'}">
				<li class="active"><a href="/service/config_limit"><i class="fa fa-circle-o"></i> 임계치 설정</a></li>
	</c:when>
	<c:otherwise>
				<li><a href="/service/config_limit"><i class="fa fa-circle-o"></i> 임계치 설정</a></li>
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
				<li class="active"><a href="/system/license"><i class="fa fa-circle-o"></i> 라이선스 설정</a></li>
	</c:when>
	<c:otherwise>
				<li><a href="/system/license"><i class="fa fa-circle-o"></i> 라이선스 설정</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'user'}">
				<li class="active"><a href="/system/user_list"><i class="fa fa-circle-o"></i> 사용자 목록</a></li>
	</c:when>
	<c:otherwise>
				<li><a href="/system/user_list"><i class="fa fa-circle-o"></i> 사용자 목록</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'agent'}">
				<li class="active"><a href="/system/agent_list"><i class="fa fa-circle-o"></i> 상담원 목록</a></li>
	</c:when>
	<c:otherwise>
				<li><a href="/system/agent_list"><i class="fa fa-circle-o"></i> 상담원 목록</a></li>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${menuCategory eq 'system' && menu eq 'group'}">
				<li class="active"><a href="/system/group_list"><i class="fa fa-circle-o"></i> 그룹 관리</a></li>
	</c:when>
	<c:otherwise>
				<li><a href="/system/group_list"><i class="fa fa-circle-o"></i> 그룹 관리</a></li>
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
  