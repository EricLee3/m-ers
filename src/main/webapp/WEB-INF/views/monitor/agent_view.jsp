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
	<link rel="stylesheet" href="/resources/plugins/datatables/dataTables.bootstrap.css">
	<link rel="stylesheet" href="/resources/plugins/iCheck/all.css">
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	<script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="/resources/plugins/fastclick/fastclick.js"></script>
	<script src="/resources/js/app.min.js"></script>
	<script src="/resources/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="/resources/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script src="/resources/plugins/chartjs/Chart.min.js"></script>
	<script src="/resources/plugins/iCheck/icheck.min.js"></script>
	
</head>
<body class="hold-transition skin-blue sidebar-mini">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h2><small>모니터 > 상담원 목록 ></small> 상담원 상세 조회</h2>
			</section>

			<!-- Main content -->
			<section class="content">

<%-- 				<h2 class="page-header">${agent.agentName } (${agent.groupName }, ${agent.agentNumber })</h2> --%>
				<h2 class="page-header">${agent.agentName } (${agent.groupName })</h2>

				<div class="row">
					<div class="col-md-3">
						
						<div class="info-box">
							<span class="info-box-icon bg-aqua text-center pull-right">
								${agent.angryCount }
							</span>
							<div class="info-box-content-agent">
								<span class="info-box-text"><h4 class="box-title">분노 단계</h4></span> 
								<span class="text-muted">최근 7일간 합산 값입니다.</span>
							</div>
						</div>
						<div class="info-box">
							<span class="info-box-icon bg-aqua text-center pull-right">
								${agent.stressCount }
							</span>
							<div class="info-box-content-agent">
								<span class="info-box-text"><h4 class="box-title">스트레스 단계</h4></span> 
								<span class="text-muted">최근 7일간 합산 값입니다.</span>
							</div>
						</div>

						<!-- 상담원 상세 정보 -->
						<!-- 2017.08.23 kyw del -->
						<!--  
						<div class="box box-success">
							<div class="box-header with-border">
								<h3 class="box-title">모니터링 대상 여부</h3>
							</div>
							<form id="form_isAudit_update" action="" method="post">
								<input type="hidden" id="agentId" name="agentId" value="${agent.agentId }">
								<input type="hidden" id="groupId" name="groupId" value="${agent.groupId }">
								<input type="hidden" id="isAudit" name="isAudit" value="${agent.isAudit }">
								<input type="hidden" id="isAuditBatch" name="isAuditBatch" value="${agent.isAuditBatch }">
								<div class="box-body">
									<div class="row">
										<div class="col-md-4">
											<label class="margin-r-5"> 
												<input type="radio" name="radioAudit" class="flat-green radioAudit" value="1" <c:if test="${agent.isAudit eq 1 }">checked</c:if>>
											</label> 실시간
										</div>
										<div class="col-md-4">
											<label class="margin-r-5"> 
												<input type="radio" name="radioAudit" class="flat-green radioAudit" value="2" <c:if test="${agent.isAuditBatch eq 1 }">checked</c:if>>
											</label> 비실시간
										</div>
										<div class="col-md-4">
											<label class="margin-r-5"> 
												<input type="radio" name="radioAudit" class="flat-green radioAudit" value="0" <c:if test="${agent.isAuditBatch eq 0 and agent.isAudit eq 0}">checked</c:if>>
											</label> 대상아님
										</div>
									</div>
								</div>
								<div class="box-footer">
									<button type="button" class="jsUpdateButton btn btn-info pull-right disabled" data-index="" disabled>적용</button>
								</div>
							</form>

						</div>
-->
						<!-- 대상자 메모 box -->
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">메모 사항</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<form role="form" id="form_agentHistory_create" action="" method="post" onsubmit="return false;">
									<input type="hidden" id="agentId" name="agentId" value="${agent.agentId }">
									<div class="input-group">
										<input type="text" name="description" id="description" placeholder="지정 사유를 입력하세요." class="form-control" maxlength="20">
										<span class="input-group-btn">
											<button type="button" class="jsCreate btn btn-info btn-flat">저장</button>
										</span>
									</div>
								</form>
							</div>
							<div class="box-body" id="box-body">
								<c:forEach items="${agentHistoryList }" var="agentHistory">
								<div class="row">
									<div class="col-md-12">
										<strong><i class="fa fa-file-text-o margin-r-5"></i><fmt:formatDate value="${agentHistory.createDate }" pattern="yyyy-MM-dd"/> </strong>
									</div>
									<div class="col-md-10">
										${agentHistory.description }
									</div>
									<div class="col-md-1">
										<button class="jsDelete btn btn-link" data-index="${agentHistory.index}">
											<i class="fa fa-trash-o"></i>
										</button>
									</div>
								</div>
								<hr>
								</c:forEach>
								<c:if test="${empty agentHistoryList }">
								<div class="row">
									<div class="col-md-12">
										등록된 메모가 없습니다.
									</div>
								</div>
								</c:if>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- ./ 대상자 메모 box -->

					</div>
					<!-- /.col -->
					<div class="col-md-6">

						<div class="box box-info">
							<div class="box-header">
								<h3 class="box-title">최근 콜 목록</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<table id="" class="table table-bordered table-striped">
									<thead>
										<tr>
											<th class="no-sort col-sm-1">고객번호</th>
											<th class="no-sort col-sm-1">시작시간</th>
											<th class="no-sort col-sm-1">분노 단계</th>
											<th class="no-sort col-sm-1">스트레스 단계</th>
											<th class="no-sort col-sm-1">상세조회</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${callAnalysisList }" var="callAnalysis">
										<tr>
											<td>${callAnalysis.customerNumber }</td>
											<td><fmt:formatDate pattern="yy/MM/dd HH:mm" value="${callAnalysis.startTime}" /></td>
											<td>
<%-- 											<c:if test="${callAnalysis.customerResultFlag eq 0 &&  callAnalysis.customerFailCode eq 0 }"> --%>
												<span class="text-danger">${callAnalysis.customerResultString }</span>
<%-- 											</c:if> --%>
											</td>
											<td>
<%-- 											<c:if test="${callAnalysis.agentResultFlag eq 0 &&  callAnalysis.agentFailCode eq 0 }"> --%>
												<span class="text-danger"> ${callAnalysis.agentResultString }</span>
<%-- 											</c:if> --%>
											</td>
											<td>
												<button type="button" class="jsShowModal btn btn-default btn-xs" data-index="${callAnalysis.index }">
													<i class="fa fa-headphones"></i>
												</button>
											</td>
										</tr>
										</c:forEach>
										<c:if test="${empty callAnalysisList}">
											<tr class="empty">
												<td colspan="5">최근 등록된 콜이 없습니다.</td>
											</tr>
										</c:if>
									</tbody>
								</table>
							</div>
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->
					<div class="col-md-3">
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
												<th>그룹 ID</th>
												<th>분노 단계</th>
												<th>스트레스 단계</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${todayAgentList }" var="agent">
											<tr>
												<td><a href="/monitor/agent_view/${agent.agentId }">${agent.agentName }</a></td>
												<td>${agent.groupId }</td>
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
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>
		<!-- Modal 콜 상세 조회 -->
		<div class="modal fade" id="modalCallDetail" tabindex="-1" role="dialog" aria-labelledby=""></div>


<script>
var lineChart;
var lineChartCanvas;

var lineChartOption = {
	scales: {
		xAxes: [{
			gridLines: {
				display: false
			}
		}]
	},
	legend: {
		position: "bottom"
	},
	showScale: true,
	pointDot: false,
	pointDotRadius: 3,
	pointDotStrokeWidth: 1,
	pointHitDetectionRadius: 20,
	maintainAspectRatio: true,
	responsive: true,
	animation : false
};

var lineChartData = {
   	labels: ['00:00','','','','','','','','',''],
	datasets: [
		{
			label: "상담원",
			borderColor: "rgba(222, 129, 98, 1)",
			backgroundColor: "rgba(222, 129, 98, 1)",
			pointBorderColor: "rgba(222, 129, 98, 1)",
			pointRadius: 2,
			pointHoverRadius: 4,
			pointStrokeColor: "#c1c7d1",
			pointHighlightFill: "#fff",
			fill: false,
			pointHoverBackgroundColor: "rgba(220,220,220,1)",
			data: [0]
		},
		{
			label: "고객",
			borderColor: "rgba(60,141,188,0.9)",
			backgroundColor: "rgba(60,141,188,0.9)",
			pointBorderColor: "#3b8bba",
			pointRadius: 2,
			pointHoverRadius: 4,
			pointStrokeColor: "rgba(60,141,188,1)",
			pointHighlightFill: "#fff",
			fill: false,
			pointHoverBackgroundColor: "rgba(60,141,188,1)",
			data: [0]
		}
	]
};
$(document).ready(function(){
	$(document).on("click", ".jsShowModal", function(e){
		e.preventDefault();
		var callIndex = $(this).attr("data-index"); 
		$("#modalCallDetail").load(
			"/monitor/call_view_agent/"+callIndex, 
			function( response, status, xhr ) {
				if ( status == "error" ) {
					var msg = "서버의 문제로 해당 정보를 확인할 수 없습니다..";
					$( "#modalCallDetail" ).html( msg + xhr.status + " " + xhr.statusText );
				} else {
					$(this).modal("show");
				}
			}
		);
	});
	
	$("#modalCallDetail").on("hidden.bs.modal", function(){
    	$("audio").trigger("pause");
	});
		
	$("#modalCallDetail").on("shown.bs.modal", function(){
		lineChartCanvas = $("#lineChart");
		lineChartData.labels = $.parseJSON ( $("#callAnalysis_labelString").val().replace(/\'/g, '"') );
		if ( $("#callAnalysis_agentSegmentData").val() == null || $("#callAnalysis_agentSegmentData").val() == "" ) {
			lineChartData.datasets[0].data = $.parseJSON ( "[0]" );
		} else {
			lineChartData.datasets[0].data = $.parseJSON ( $("#callAnalysis_agentSegmentData").val() );
		}
		if ( $("#callAnalysis_customerSegmentData").val() == null || $("#callAnalysis_customerSegmentData").val() == "" ) {
			lineChartData.datasets[1].data = $.parseJSON ( "[0]" );
		} else {
			lineChartData.datasets[1].data = $.parseJSON ( $("#callAnalysis_customerSegmentData").val() );
		}
		lineChart = new Chart( lineChartCanvas, {
			type: "bar",
			data: lineChartData,
		    options: lineChartOption
		} );
		lineChart.clear();
		lineChart.update();
	    lineChart.render(0, false);
 	});

	//SLIMSCROLL FOR 
	$('#box-body').slimScroll({
		height : '180px'
	});

	//Flat red color scheme for iCheck
	$('input[type="checkbox"].flat-green, input[type="radio"].flat-green').iCheck({
		checkboxClass : 'icheckbox_flat-green',
		radioClass : 'iradio_flat-green'
	});
	
	
	
	/**
	 * 실시간 /비실시간 모니터링 수정에 관한 스크립트 입니다. 
	 * 관련 문서를 공부할 것 : http://icheck.fronteed.com/
	 */
	$(document).on( 'ifChanged', ".radioAudit", function() {
		$(".jsUpdateButton").prop("disabled", false).removeClass("disabled");
	});
	
	$(document).on('click', '.jsUpdateButton', function(e) {
		e.preventDefault();
		var radioAuditNo = $(":input:radio[name='radioAudit']:checked").val();
		$("#isAudit").val( radioAuditNo == 1 ? "1" : "0");
		$("#isAuditBatch").val( radioAuditNo == 2 ? "1" : "0");			
		var auditFormData = $("#form_isAudit_update").serialize();
		$.ajax({
			url : "/REST/agent/updateAgentAudit",
			data : auditFormData,
			dataType : "JSON",
			method : "POST",
			success : function(result) {
				if (result != 2) {
					if (result == 1) {
						alert("모니터링 대상 여부가 변경 되었습니다.");
					} else {
						alert("상담원 정보 수정에 실패하였습니다.");
					}
				}else{
					alert("현재 라이선스의 채널수를 모두 사용중입니다. 상담원을 모니터링 대상자로 등록하시려면, 라이선스 채널수를 변경하시거나 추가 라이선스 구매 바랍니다.")
					location.reload();
				}
				
			}
		});
	});
	
	/* 
	 * 모니터링 대상 지정 사유 삭제에 필요한 스크립트입니다.
	 */
	$(document).on( "click", ".jsDelete", function(e) {
		e.preventDefault();
		var agentHistoryIndex = $(this).attr("data-index");
		if (confirm("한번 삭제하면 복구할 수 없습니다. 계속 하시겠습니까?")) {
			$.ajax({
				url : "/REST/agentHistory/deleteAgentHistory/" + agentHistoryIndex,
				dataType : "JSON",
				method : "GET",
				success : function(result) {
					if (result) {
						location.reload();
					} else {
						alert("해당 지정사유를 가져올 수 없습니다.");
					}
				}
			});
		}
	});
	
	/* 
	 * 모니터링 대상 지정 사유 등록에 필요한 스크립트입니다.
	 *
	 */
	$(document).on('click', '.jsCreate', function(e){
    	e.preventDefault();
    	if ($.trim($("#description").val()).trim().length < 1){
    		alert("모니터링 대상 지정 사유를 입력해야 합니다.");
    		$("#description").focus();
    		return false;
    	}
    	var agentHistoryFormData = $("#form_agentHistory_create").serialize();
    	$.ajax({
    		url:"/REST/agentHistory/createAgentHistory",
    		data : agentHistoryFormData,
    		dataType : "JSON",
    		method : "POST",
    		success : function(result) {
	    		if( result ) {
	    			if( result.index > 0 ) { 
    					location.reload();
	    			} else {
	    				alert("새로운 모니터링 지정 사유 등록에 실패하였습니다.");
	    			}
	    		}
    		}
    	});
    });
});

</script>
</body>
</html>