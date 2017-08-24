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
	<link rel="stylesheet" href="/resources/css/print.css" media="print">
	<link rel="stylesheet" href="/resources/plugins/datatables/dataTables.bootstrap.css">
	<link rel="stylesheet" href="/resources/plugins/ionslider/ion.rangeSlider.css">
	<link rel="stylesheet" href="/resources/plugins/ionslider/ion.rangeSlider.skinHTML5.css">
	<link rel="stylesheet" href="/resources/plugins/datepicker/datepicker3.css">
	<link rel="stylesheet" href="/resources/plugins/morris/morris.css">
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	<script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="/resources/plugins/fastclick/fastclick.js"></script>
	<script src="/resources/js/app.min.js"></script>
	<script src="/resources/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script src="/resources/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="/resources/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script src="/resources/plugins/chartjs/Chart.min.js"></script>
	<script src="/resources/plugins/ionslider/ion.rangeSlider.min.js"></script>
	<script src="/resources/plugins/raphael/raphael-min.js"></script>
	<script src="/resources/plugins/morris/morris.min.js"></script>
</head>

<body class="hold-transition skin-blue sidebar-mini">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h2><small>통계 ></small> 일별 통계</h2>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box box-success">
							<div class="box-header">
								<h3 class="box-title">일별 통계 <strong>(${searchDTO.startDate} ~ ${searchDTO.endDate})</strong></h3>
							</div>
							
							<!-- /.box-header -->
							
							<div class="box-body">

								<!-- 검색 조건 -->
								<form role="form" id="form_dailyCall_search" action="/report/day_report" mehtod="post" >
									<input type="hidden" name="page" value="">
									<input type="hidden" name="searchType" value="${searchDTO.searchType}">
<!-- 									<div class="col-md-2"> -->
<!-- 										<div class="form-group"> -->
<!-- 											<select class="form-control" id="selectAgentGroup" name="searchGroup"> -->
<!-- 												<option value="allGroup">전체 그룹</option> -->
<%-- 												<c:forEach items="${agentGroupList}" var="agentGroup">	 --%>
<%-- 												<option value="${agentGroup.groupId }">${agentGroup.groupName }</option> --%>
<%-- 												</c:forEach> --%>
<!-- 											</select> -->
<!-- 										</div> -->
<!-- 									</div> -->
									<div class="col-md-2">
										<div class="form-group">
											<!-- 상담원 이름을 표시하기 위해 agentName 대신 searchIsNotice 를 사용했다. -->
											<input type="hidden" id="agentName" name="searchIsNotice" value="">
											<select class="form-control" id="selectAgent" name="searchId">
												<option value='allAgent'>전체 상담원</option>
												<c:forEach items="${agentList}" var="agent">	
												<option value="${agent.agentId }">${agent.agentName }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-2 hidden-print">
										<div class="form-group">
											<div class="input-group date">
												<div class="input-group-addon">
													<i class="fa fa-calendar"></i>
												</div>
												<input type="hidden" id="checkDatepicker" value="false"> 
												<input type="text" name="startDate" class="form-control pull-right" id="startDate" placeholder="시작일" value="${searchDTO.startDate}" readonly="true">
											</div>
										</div>
									</div>
									<div class="col-md-2 hidden-print">
										<div class="form-group">
											<div class="input-group date">
												<div class="input-group-addon">
													<i class="fa fa-calendar"></i>
												</div>
												<input type="text" name="endDate" class="form-control pull-right" id="endDate" placeholder="종료일" value="${searchDTO.endDate}" readonly="true">
											</div>
										</div>
									</div>
									<div class="col-md-2 hidden-print">
										<button type="button" class="jsSearch btn btn-info">조회</button>
									</div>
								</form>
								<!-- /. 검색 조건 -->

<!-- 								<div class="col-md-12"> -->
<!-- 									<div class="box box-default"> -->
<!-- 										<div class="box-body chart-responsive"> -->
<!-- 											<div class="chart" id="line-chart" style="height: 300px;"></div> -->
<!-- 										</div> -->
<!-- 										<div class="box-footer clearfix"> -->
<!-- 											<span class="pull-right">  -->
<!-- 												<i class="fa fa-minus" style="color: #de8162;"></i> 주의 단계 -->
<!-- 												<i class="fa fa-minus" style="color: #e7cd64;"></i> 흥미 단계 -->
<!-- 											</span> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->

								<div class="col-md-12">
									<div class="box">
										<div class="box-body">
											<table class="table table-bordered table-striped">
												<thead>
													<tr>
														<th class="no-sort">상담일</th>
														<th class="no-sort">전체 호</th>
														<th class="no-sort">성공 호</th>
														<th class="no-sort">실패 호</th>
														<th class="no-sort">주의단계</th>
														<th class="no-sort">흥미단계</th>
														<th class="no-sort">욕구단계</th>
														<!-- th class="no-sort">고객불만 감소</th -->
													</tr>
													
												</thead>
												<tbody>
													<tr class="info">
														<td >합계</td>
														<td >${totalCall }</td>
														<td >${successCount }</td>
														<td >${failCount }</td>
														<td >${angerCall }</td>
														<td >${stressCall }</td>
														<td >${incrementCount }</td>
														<!--td >${decrementCount }</td -->
													</tr>
													<c:forEach items="${dailyCallList }"  var="dailyCall" >
													<tr>
														<td><fmt:formatDate pattern="yy-MM-dd" value="${dailyCall.statTime}" /></td>
														<td>${dailyCall.totalCount}</td>
														<td>${dailyCall.successCount}</td>
														<td>${dailyCall.failCount}</td>
														<td><span class="text-danger">${dailyCall.angryCount}</span></td>
														<td><span class="text-info">${dailyCall.stressCount}</span></td>
														<td>${dailyCall.incrementCount}</td>
														<!--td>${dailyCall.decrementCount}</td-->
													</tr>
													</c:forEach>
													<c:if test="${empty dailyCallListForChart }">
														<tr class="empty">
															<td colspan="8">조회 결과가 없습니다.</td>
														</tr>
													</c:if>
												</tbody>
											</table>
										</div>
										<div class="box-footer chart-responsive">
											<button type="button" class="btn btn-default pull-right hidden-print jsPrint"><i class="fa fa-print"></i><small> 인쇄</small></button>
											<button type="button" class="btn btn-default pull-right hidden-print jsExcelDownload" ><i class="fa fa-file-excel-o"></i><small> 다운로드</small></button>
										</div>
									</div>
								</div>

							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
<script>
$(document).ready(function(){
	$(document).on("click", ".jsExcelDownload", function(e){
		e.preventDefault();
		console.log("click the control");
		window.open("/report/day_report_download?page=${pageDTO.page }&searchGroup=${searchDTO.searchGroup}&searchId=${searchDTO.searchId}&startDate=${searchDTO.startDate}&endDate=${searchDTO.endDate}&searchType=${searchDTO.searchType}&searchIsNotice=${searchDTO.searchIsNotice}", target="_blank");
	});

	$(document).on("click", ".jsPrint", function(e){
		e.preventDefault();
		print();
	});
	
	if ('matchMedia' in window) {
	    window.matchMedia('print').addListener(function(media) {
	    	lineDraw();
		});
	}
	
	$(document).on("change", "#selectAgentGroup", function(){
		var agentGroupId = $("#selectAgentGroup").val();
		if(agentGroupId != "allGroup") {
			$.ajax({
				url : "/REST/agent/listAgent/" +agentGroupId,
			}).done(function(resultList){
				$("#selectAgent").empty();
				$("#selectAgent").append("<option value='allAgent'>전체 상담원</option>");
				if( resultList != null ) {
					$.each(resultList, function (index, agent){
						$("#selectAgent").append("<option value='"+agent.agentId+"'>"+agent.agentName+"</option>");
					});	
				}
			});
		} else {
			$("#selectAgent").empty().append("<option value='allAgent'>전체 상담원</option>");
		} 	
	});

	$(document).on("click", ".jsSearch", function(e){
		e.preventDefault();
	   	var tempEnddate = $("#endDate").val();
		if (tempEnddate == "" || tempEnddate == null) {
	   		alert("종료일을 입력해주세요.");
	       $("#endDate").val("");
	       $("#endDate").focus();
	       $("#checkDatepicker").val("false");
	       return false;
	   	}
		var agentName = $("#selectAgent option:selected").text(); 
		$("#form_dailyCall_search").find("#agentName").val(agentName);
		$("#form_dailyCall_search").submit();
	});
	<c:if test="${searchDTO.searchId != null}">
	$("#form_dailyCall_search").find("#selectAgent option[value='${searchDTO.searchId}']").attr("selected", "selected");
	</c:if>
	<c:if test="${searchDTO.searchGroup != null}">
	$("#form_dailyCall_search").find("#selectAgentGroup option[value='${searchDTO.searchGroup}']").attr("selected", "selected");
	</c:if>
    /*
     * 페이징을 위해 필요한 스크립트입니다.
     * 단, 검색 상자등이 있을 경우에는 해당 항목의 이름 ( 아래에서는 form_search ) 등에 주의하셔야 합니다. 
     * 또한,Page가 정상적으로 동작하기 위해서는 해당 페이지에 <form id="form_search "...><input type="hidden" name="page"> 와 같은 코드가 반드시 필요합니다.
     */
    $(document).on("click", ".pagination li a", function(e) {
        e.preventDefault();
        var page = $(this).attr("data-page");
        $("#form_callreport_search input[name='page']").val(page);
        var pathname = window.location.pathname;
        window.location.href = pathname + "?" + $("#form_callreport_search").serialize();
    });

	$(function () {
		/*
		 * 그래프를 삭제하기 위한 주석, 이 부분에서 에러가 발생해서 밑의 Date Picker가 수행되지 않는 듯... IOS
		/*
	    //LINE CHART
	    var line = new Morris.Line({
	      element: 'line-chart',
	      resize: true,
	      data: [
			<c:forEach items="${dailyCallListForChart}" var="dailyCallItem"> {
	        	date: '<fmt:formatDate pattern="MM/dd" value="${dailyCallItem.statTime}" />', 
	        	AngryCall: ${dailyCallItem.angryCount}, 
	        	StressCall:${dailyCallItem.stressCount}
	        },
			</c:forEach>
	      ],
	      lineColors: ['#de8162', '#e7cd64'],
	      xkey: 'date',
	      ykeys: ['주의 단계', '흥미 단계'],
	      labels: ['주의 단계', '흥미 단계'],
	      parseTime: false,
	      hideHover: 'auto'
	    });
*/
	    //Date picker
	    $('#startDate').datepicker({
	      autoclose: true
	    });
	    
	    $('#endDate').datepicker({
	        autoclose: true
		});
	    
	  	//달력(시작일,종료일)에서 .day(일)를 클릭했을때마다 실행되는 스크립트 입니다.
	    $(document).on('click', '.day', function(e){
	    	e.preventDefault();
	    	checkDatepicker();
	    });
	});

});	


/* 시작일과 종료일을 비교하기 위한 함수입니다.
 * 시작일  > 종료일, 종료일 < 시작일 일때 경고창을 띄어 줍니다.
 */
function checkDatepicker() {
	var startDate = $("#startDate").val();
    var endDate = $("#endDate").val();
    var startDateCompare = new Date(startDate);
    var endDateCompare = new Date(endDate);
    if(startDate && endDate ){
	    if(startDateCompare.getTime() > endDateCompare.getTime()) {
	        alert("종료일은 시작일과 같거나 이후의 날짜로 입력되어야 합니다.");
	        $("#endDate").val("");
	        $("#endDate").focus();
	        $("#checkDatepicker").val("false");
	    }else{
	    	$("#checkDatepicker").val("true");
	    }
    }
}

function lineDraw(){
    //LINE CHART
    var line = new Morris.Line({
      element: 'line-chart',
      resize: true,
      data: [
		<c:forEach items="${dailyCallListForChart}" var="dailyCallItem"> {
        	date: '<fmt:formatDate pattern="MM/dd" value="${dailyCallItem.statTime}" />', 
        	AngryCall: ${dailyCallItem.angryCount}, 
        	StressCall:${dailyCallItem.stressCount}
        },
		</c:forEach>
      ],
      lineColors: ['#de8162', '#e7cd64'],
      xkey: 'date',
      ykeys: ['주의 단계', '흥미 단계'],
      labels: ['주의 단계', '흥미 단계'],
      parseTime: false,
      hideHover: 'auto'
    });
}
</script>

</body>
</html>