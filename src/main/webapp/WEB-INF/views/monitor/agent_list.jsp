<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" href="/resources/css/migam.css">
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	<script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="/resources/plugins/fastclick/fastclick.js"></script>
	<script src="/resources/js/app.min.js"></script>
	<script src="/resources/plugins/chartjs/Chart.min.js"></script>
	
</head>
<body class="hold-transition skin-blue sidebar-mini">
	
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h2><small>모니터 ></small> 상담원 목록</h2>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<!-- left column grid 1-9 start -->
					<!-- 상담원 버튼 리스트 IOS  -->
					<div class="col-lg-9" id="div_agent_list">
						
						<c:set var="j" value="0" />
						<c:forEach items="${groupList }" var="group" >
						<div class="col-md-4">
<!-- 							<div class="small-box bg-light-blue"> -->
<!-- 								<div class="inner"> -->
<%-- 									<h5>${group.groupName } ( ${group.agentCount }명 )</h5> --%>
<!-- 								</div> -->
<!-- 								<div class="icon"> -->
<!-- 									<h1> -->
<!-- 										<i class="ion ion-person"></i> -->
<!-- 									</h1> -->
<!-- 								</div> -->
<!-- 								<a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>  -->
<!-- 							</div> -->
							
							
							<div class="row">
								<c:set var="i" value="0" />
								<c:forEach items="${group.agentList}" var="agent" >
								<div class="col-sm-6 col-xs-12">
									<button type="button" class="btn btn-default bg-flat btn-block btn-sm" onclick="location.href='/monitor/agent_view/${agent.agentId}'">
									<c:if test="${agent.isAudit eq '1' }">
										<c:if test="${agent.callStatus eq '1' }">
											<c:choose>
												<c:when test="${agent.angryCount gt angryCountParameter }">
													<span class="pull-left auditStatus2" title="주의 단계" data-angrycount="${agent.angryCount }"><i class="fa fa-square"></i></span>
												</c:when>
												<c:otherwise>
													<span class="pull-left auditStatus1" title="Normal" data-angrycount="${agent.angryCount }"><i class="fa fa-square"></i></span>
												</c:otherwise>
											</c:choose>
										</c:if>
										<c:if test="${agent.callStatus eq '0' }">
											<span class="pull-left auditStatus0" title="idle" data-angrycount="${agent.angryCount }"><i class="fa fa-square"></i></span>
										</c:if>
									</c:if>
									<c:set var="agentNumber" value="${agent.agentNumber }"/>
									<c:set var="agentNumberlen" value="${fn:length(agentNumber)}"/>
									${fn:substring(agentNumber,agentNumberlen-4,agentNumberlen)} ${agent.agentName }
									</button>
								</div>
								<c:if test="${i%2 eq '1'}">
								<div class="col-sm-12 col-xs-12" style="height:5px;"></div>
								</c:if>
								<c:set var="i" value="${i+1 }" />
								</c:forEach>
								<div class="row">
									<div class="col-lg-12">
										<div class="small-box bg-default"></div>
									</div>
								</div>
							</div>
							
							
						</div>
						<c:set var="j" value="${j+1 }" />
						</c:forEach>
						
					</div>
					<!-- ./left column grid 1-9 -->

					<!-- right column grid 10-12 -->
					<div class="col-lg-3">

						<!-- TABLE: 오늘 콜 정보 -->
						<div class="box box-primary">
							<div class="box-header with-border">
								<h3 class="box-title">오늘 콜 정보 </h3>
							</div>
							<div class="box-body">
								<div class="table-responsive">
									<table class="table no-margin">
										<thead>
											<tr>
												<th></th>
												<th>전체 <span data-toggle="tooltip" title="전체 분석 콜 수" class="fa fa-question-circle"></span></th>
												<th>분노 단계</th>
												<th>스트레스 단계</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><jsp:useBean id="today" class="java.util.Date" /><fmt:formatDate pattern="MM/dd" value="${today}" /></td>
												<td>${totalCall }</td>
												<td>${angerCall }</td>
												<td>${stressCall }</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<!-- /. TABLE: 오늘 콜 정보 -->

						<div class="box box-danger">
							<div class="box-header with-border">
								<h3 class="box-title">오늘 콜 정보 (분노 단계, 스트레스 단계) 차트</h3>
							</div>
							<div class="box-body">
								<div class="row">
								<c:choose>
									<c:when test="${totalCall > 0 }">
									<div class="col-md-8">
										<div class="chart-responsive">
											<canvas id="pieChart" height="150"></canvas>
										</div>
									</div>
									<div class="col-md-4 ">
										<ul class="chart-legend clearfix">
											<li><i class="fa fa-square text-red"></i> 분노 단계</li>
											<li><i class="fa fa-square text-yellow"></i> 스트레스 단계</li>
											<li><i class="fa fa-square text-green"></i> Normal Call</li>
										</ul>
									</div>
									</c:when>
									<c:otherwise>
									<div class="col-md-12 text-center" style="height:150">
										<span>조회할 콜 정보가 없습니다.</span>
									</div>
									</c:otherwise>
								</c:choose>

								</div>
							</div>
							<!--
				            <div class="box-footer clearfix">
				              <span class="text-class pull-right"> (전일 기준)</span>
				            </div>
				            -->
						</div>
						<!-- /. TABLE: 오늘 콜 정보 분포-->

						<div class="col-lg-12">
							<div class="small-box bg-default"></div>
						</div>


						<!-- 오늘 상담원별 콜 정보 -->
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">오늘 상담원별 콜 정보</h3>
							</div>
							<div class="box-body">
								<div class="table-responsive">
									<table class="table no-margin">
										<thead>
											<tr>
												<th>상담원</th>
<!-- 												<th>그룹 ID</th> -->
												<th>분노 단계</th>
												<th>스트레스 단계</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${todayAgentList }" var="agent">
											<tr>
												<td><a href="/monitor/agent_view/${agent.agentId }">${agent.agentName }</a></td>
<!-- 												<td> -->
<%-- 												<c:forEach items="${groupList }" var="group" > --%>
<%-- 													<c:if test="${group.groupId eq agent.groupId }"> --%>
<%-- 														${group.groupName } --%>
<%-- 													</c:if> --%>
<%-- 												</c:forEach> --%>
<!-- 												</td> -->
												<td>${agent.angryCount }</td>
												<td>${agent.stressCount }</td>
											</tr>
											</c:forEach>
											<c:if test="${empty todayAgentList }">
											<tr class="empty">
												<td colspan="4">조회할 콜 정보가 없습니다.</td>
											</tr>
											</c:if>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<!-- /. 오늘 상담원별 콜 정보 -->

						<!-- TABLE: 지난주 상담원별 A,S 콜 정보  -->
						<div class="box box-warning">
							<div class="box-header with-border">
								<h3 class="box-title">지난주 상담원별 콜 정보</h3>
							</div>
							<div class="box-body">
								<div class="table-responsive">
									<table class="table no-margin">
										<thead>
											<tr>
												<th>상담원</th>
<!-- 												<th>그룹 ID</th> -->
												<th>분노 단계</th>
												<th>스트레스 단계</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${lastWeekAgentList }" var="agent">
											<tr>
												<!--  td><a href="/monitor/agent_view/${agent.agentId }">${agent.agentName }</a></td -->
												<td>${agent.agentName }</td>
<!-- 												<td> -->
<%-- 												<c:forEach items="${groupList }" var="group" > --%>
<%-- 													<c:if test="${group.groupId eq agent.groupId }"> --%>
<%-- 														${group.groupName } --%>
<%-- 													</c:if> --%>
<%-- 												</c:forEach> --%>
<!-- 												</td> -->
												<td>${agent.angryCount }</td>
												<td>${agent.stressCount }</td>
											</tr>
											</c:forEach>
											<c:if test="${empty lastWeekAgentList }">
											<tr class="empty">
												<td colspan="4">조회할 콜 정보가 없습니다.</td>
											</tr>
											</c:if>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<!-- /. 지난주 상담원별 A,S 콜 정보 -->

					</div>
				</div>

			</section>
			<!-- /.content -->
<script>
var refreshTimer;
$(document).ready(function(){
	refreshTimer = window.setInterval(updateAgentList, 5000);
});

function updateAgentList(){
	$("#div_agent_list").load("/monitor/agent_list_refresh", function( response, status, xhr ) {
		if ( status == "error" ) {
			var msg = "서버의 문제로 화면 갱신에 실패했습니다.";
			$( "#div_agent_list" ).html( msg + xhr.status + " " + xhr.statusText );
		} 
	});
}

$(function () {
	'use strict';
	
	// ChartJS - Pie chart
	var pieChartCanvas = $("#pieChart");//.get(0).getContext("2d");
	var PieData = {
		labels: ["분노 단계","스트레스 단계","Normal"],
		datasets: [
			{
				data: [ ${angerCall }, ${stressCall }, ${totalCall }-${angerCall }-${stressCall } ],
				backgroundColor: [
				    "#f56954",
				    "#f39c12",
				    "#00a65a"
				],
				hoverBackgroundColor: [
				    "#f56954",
				    "#f39c12",
				    "#00a65a"
				]		        	   
			}
		]
	}; 
	var pieChart = new Chart(pieChartCanvas, {
		type: "pie",
		data: PieData,
		options: {
			showScale: true,
			maintainAspectRatio: true,
			responsive: true,
			animation : false,
			legend: {
				display: false
			}
		}
	});
});
</script>
</body>
</html>