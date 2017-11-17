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
	<link rel="stylesheet" href="/resources/plugins/select2/select2.min.css">
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
	<script src="/resources/plugins/select2/select2.full.min.js"></script>
	<script src="/resources/plugins/input-mask/jquery.inputmask.js"></script>
	<script src="/resources/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script src="/resources/plugins/input-mask/jquery.inputmask.extensions.js"></script>
</head>
<script>
		$(document).ready(function(){
			if("${searchGroup}" != null && "${searchGroup}" != '') $("select[name=searchGroup]").val("${searchGroup}").attr("selected","selected");
			if("${searchId}" != null && "${searchId}" != '') $("select[name=selectAgent]").val("${searchId}").attr("selected","selected");
		});
</script>
<body class="hold-transition skin-blue sidebar-mini">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h2><small>통계 ></small> 상담원별 통계</h2>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row" >
					<div class="col-xs-12">
						<div class="box box-success">
							<div class="box-header">
								<h3 class="box-title">상담원별 통계 <strong>(기간 : ${searchDTO.startDate} ~ ${searchDTO.endDate})</strong></h3>
							</div>
							<!-- /.box-header -->
							
							<div class="box-body">
								<!-- 검색 조건 -->
								<form role="form" id="form_agentCall_search" action="/report/agent_report" method="post">
									<input type="hidden" name="page" value="">
									<input type="hidden" name="searchType" value="${searchDTO.searchType}">
<!-- 									<div class="col-md-2"> -->
<!-- 										<div class="form-group"> -->
<!-- 											<select class="form-control" id="selectAgentGroup" name="searchGroup"> -->
<!-- 												<option value="allGroup">--그룹 선택--</option> -->
<%-- 												<c:forEach items="${agentGroupList}" var="agentGroup">	 --%>
<%-- 												<option value="${agentGroup.groupId }">${agentGroup.groupName }</option> --%>
<%-- 												</c:forEach> --%>
<!-- 											</select> -->
<!-- 										</div> -->
<!-- 									</div> -->
									<div class="col-md-2">
										<div class="form-group">
											<input type="hidden" id="searchId" name="searchId" value="">
											<select class="form-control" id="selectAgent" name="selectAgent">
												<option value='allAgent'>-- 상담원 선택 --</option>
												<option value='selectAllAgent'>전체 선택 </option>
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
							
									<div class="col-md-8 box-header agentList" id="agentList"></div>
								
								</form>
								<!-- /. 검색 조건 -->
<%--
								<div class="col-md-12">
									<div class="box box-default">
										<div class="box-body chart-responsive">
											<div class="chart" id="bar-chart" style="height: 300px;"></div>
										</div>
										<div class="box-footer clearfix">
											<span class="pull-right"> 
												<i class="fa fa-minus" style="color: #de8162;"></i> 분노 단계
												<i class="fa fa-minus" style="color: #e7cd64;"></i> 스트레스 단계
											</span>
										</div>
									</div>
								</div>
 --%>
								<div class="col-md-12">
									<div class="box">
										<div class="box-body">
											<table class="table table-bordered table-striped">
												<thead>
													<tr>
														<th class="no-sort">상담원</th>
														<th class="no-sort">전체 호</th>
														<th class="no-sort">성공 호</th>
														<th class="no-sort">실패 호</th>
														<th class="no-sort">분노 단계</th>
														<th class="no-sort">스트레스 단계</th>
<!-- 														<th class="no-sort">욕구단계</th> -->
														<!--th class="no-sort">고객불만 감소</th-->
													</tr>
												</thead>
												<tbody>
													<tr class="info">
														<td >합계</td>
														<td >${totalCall}</td>
														<td >${successCount}</td>
														<td >${failCount}</td>
														<td >${angerCall}</td>
														<td >${stressCall}</td>
<%-- 														<td >${incrementCount }</td> --%>
														<!--td >${decrementCount }</td-->
													</tr>
													<c:forEach items="${agentCallListForChart }"  var="agentCall" >
													<tr>
														<td>${agentCall.agentName}</td>
														<td>${agentCall.totalCount}</td>
														<td>${agentCall.successCount}</td>
														<td>${agentCall.failCount}</td>
														<td><span class="text-danger">${agentCall.angryCount}</span></td>
														<td><span class="text-info">${agentCall.stressCount}</span></td>
<%-- 														<td>${agentCall.incrementCount}</td> --%>
														<!--td>${agentCall.decrementCount}</td-->
													</tr>
													</c:forEach>
													<c:if test="${empty agentCallListForChart }">
														<tr class="empty">
															<td colspan="6">조회 결과가 없습니다.</td>
														</tr>
													</c:if>
												</tbody>
											</table>
											<div class="box-footer clearfix text-center">
						                        <ul class="pagination pagination-sm no-margin">
													<asnetPage:Pagination 
														page="${pageDTO.page }" 
														itemPerPage="${pageDTO.itemPerPage }" 
														pagePerGroup="${pageDTO.pagePerGroup }" 
														itemCount="${call_list_Count }" 
													/>
												</ul> 
						                  </div>
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
		window.open("/report/agent_report_download?page=${pageDTO.page }&searchGroup=${searchDTO.searchGroup}&searchId=${searchDTO.searchId}&startDate=${searchDTO.startDate}&endDate=${searchDTO.endDate}&searchType=${searchDTO.searchType}", target="_blank");
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


    $(document).on("click", ".pagination li a", function(e) {
        e.preventDefault();
        var agentIdList = "";
        $(".jsRemoveSearchAgent").each(function(index){
			if( index != 0) agentIdList += ","; 
			agentIdList += ("'" + $(this).attr("data-agentId") + "'");
		});

		$("#searchId").val(agentIdList);	
        
        var page = $(this).attr("data-page");
        $("#form_agentCall_search input[name='page']").val(page);
        
        $("#form_agentCall_search").submit();
        
       // var pathname = window.location.pathname;
      //  window.location.href = pathname + "?" + $("#form_callreport_search").serialize();
    });

    
	$(document).on("change", "#selectAgentGroup", function(){
		var agentGroupId = $("#selectAgentGroup").val();
		if(agentGroupId != "allGroup") {
			$.ajax({
				url : "/REST/agent/listAgent/" +agentGroupId,
			}).done(function(resultList){
				$("#selectAgent").empty();
				if( resultList != null ) {
					$("#selectAgent").append("<option value='allAgent'>상담원을 선택하세요 </option>");
					$("#selectAgent").append("<option value='selectAllAgent'>전체 선택 </option>");
					$.each(resultList, function (index, agent){
						$("#selectAgent").append("<option value='"+agent.agentId+"'>"+agent.agentName+"</option>");
					});	
				}
			});
		} else {
			$("#selectAgent").empty().append("<option value='allAgent'>--상담원 선택--</option>");
		} 	
	});
	
	
	
	$(document).on("change", "#selectAgent", function(e){
		e.preventDefault();
		var agentId = $(this).val();
		var agentName = $(this).find("option[value='"+ agentId +"']").text();
		var agentcheck = 1;		
		if($(".jsRemoveSearchAgent").index() == 0){
		$(".jsRemoveSearchAgent").each(function(index){
			if($(this).attr("data-agentId") == agentId){
				alert(agentName+" 상담원은 이미 선택되었습니다.");
				agentcheck = 0;
			}		
		});
		}
		if(agentcheck == 1){
			if(agentId != "allAgent") {
				if (agentId == "selectAllAgent") {
					$("#selectAgent option").each(function() {
						if ( $(this).val() != "allAgent" && $(this).val() != "selectAllAgent") {
							/*
							$("#agentList").append(" <span data-agentId='"
									+$(this).val()+"' data-agentName ='"
									+$(this).text()+"' class='btn btn-xs btn-info pull-left jsRemoveSearchAgent'>"
									+"<i class='fa fa-times hidden-print'></i> "
									+$(this).text()+"</span>");	
							*/
							$(".jsRemoveSearchAgent").remove();
						}
						
					});
				} else {
					$("#agentList").append(" <span data-agentId='"
						+agentId+"' data-agentName ='"
						+agentName+"' class='btn btn-xs btn-info pull-left jsRemoveSearchAgent'>"
						+"<i class='fa fa-times hidden-print'></i> "
						+agentName+"</span>");
				}
			}
		}
	});
	
	$(document).on("click", ".jsRemoveSearchAgent", function(e){
		e.preventDefault();
		$(this).remove();
	});

	$(document).on("click", ".jsSearch", function(e){
		e.preventDefault();
		var agentIdList = "";
		$(".jsRemoveSearchAgent").each(function(index){
			if( index != 0) agentIdList += ","; 
			agentIdList += ("'" + $(this).attr("data-agentId") + "'");
		});
		
		if($("select[name=selectAgent]").val() != 'selectAllAgent'){
			if( agentIdList.length < 1 ) {
				alert("상담원을 선택하여야 합니다.");
				return false;
			}
		}
		$("#searchId").val(agentIdList);
		
	   	var tempEnddate = $("#endDate").val();
		if (tempEnddate == "" || tempEnddate == null) {
	   		alert("종료일을 입력해주세요.");
	       $("#endDate").val("");
	       $("#endDate").focus();
	       $("#checkDatepicker").val("false");
	       return false;
	   	}
		$("#form_agentCall_search").submit();
	});

	<c:if test="${searchDTO.searchGroup != null and searchDTO.searchId == null }">
	$("#form_agentCall_search").find("#selectAgentGroup option[value='${searchDTO.searchGroup}']").attr("selected", "selected");
	</c:if>
	<c:if test="${searchDTO.searchId != null and searchDTO.searchGroup == null}">
	var idList = "${searchDTO.searchId}";
	idList = idList.replace(/'/gi, "");
	var idListArray = idList.split(",");
	if ( idListArray.length > 1 ) {
		$.each(idListArray, function(idx, thisAgentId) {
			$("#selectAgent option").each(function() {
				if ( $(this).val() == thisAgentId ) {
					$("#agentList").append(" <span data-agentId='"
							+$(this).val()+"' data-agentName ='"
							+$(this).text()+"' class='btn btn-xs btn-info pull-left jsRemoveSearchAgent'>"
							+"<i class='fa fa-times hidden-print'></i> "
							+$(this).text()+"</span>");
				}
			});			
		});	
	} else {
		$("#form_agentCall_search").find("#selectAgent option[value='" + idList + "']").attr("selected", "selected");
		$("#selectAgent option").each(function() {
			if ( $(this).val() == idList ) {
				$("#agentList").append(" <span data-agentId='"
						+$(this).val()+"' data-agentName ='"
						+$(this).text()+"' class='btn btn-xs btn-info pull-left jsRemoveSearchAgent'>"
						+"<i class='fa fa-times hidden-print'></i> "
						+$(this).text()+"</span>");
			}
		});
	}
	</c:if>
	
	$(function () {
		
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

</script>

</body>
</html>