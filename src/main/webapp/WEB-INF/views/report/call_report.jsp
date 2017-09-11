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
	<link rel="stylesheet" href="/resources/plugins/datatables/dataTables.bootstrap.css">
	<link rel="stylesheet" href="/resources/plugins/ionslider/ion.rangeSlider.css">
	<link rel="stylesheet" href="/resources/plugins/ionslider/ion.rangeSlider.skinHTML5.css">
	<link rel="stylesheet" href="/resources/plugins/datepicker/datepicker3.css">
	<link rel="stylesheet" href="/resources/plugins/morris/morris.css">
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
	<script src="/resources/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script src="/resources/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="/resources/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script src="/resources/plugins/chartjs/Chart.min.js"></script>
	<script src="/resources/plugins/ionslider/ion.rangeSlider.min.js"></script>
	<script src="/resources/plugins/raphael/raphael-min.js"></script>
	<script src="/resources/plugins/morris/morris.min.js"></script>
</head>
<script>
		$(document).ready(function(){
			if("${searchGroup}" != null && "${searchGroup}" != '') $("select[name=searchGroup]").val("${searchGroup}").attr("selected","selected");
			if("${searchId}" != null && "${searchId}" != '') $("select[name=selectAgent]").val("${searchId}").attr("selected","selected");
			if("${SearchType}" != null && "${SearchType}" != '') $("select[name=searchType]").val("${SearchType}").attr("selected","selected");
			
			
			
		});
</script>
<body class="hold-transition skin-blue sidebar-mini">
			<section class="content-header">
				<h2><small>리포트 ></small> 콜별 리포트</h2>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box box-success">
							<div class="box-header">
								<h3 class="box-title">${searchDTO.startDate} ~ ${searchDTO.endDate} 콜별 감정분석 리포트 (총 : ${callAnalysisCount }개)</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<!-- 검색 조건 -->
								<form role="form" id="form_callreport_search" action="" mehtod="get">
									<input type="hidden" name="page" value="">
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
									<div class="col-md-2 hidden-print"  >
										<div class="form-group">
											<div class="input-group date">
												<div class="input-group-addon">
													<i class="fa fa-calendar"></i>
												</div>
												<input type="text" name="endDate" class="form-control pull-right" id="endDate" placeholder="종료일" value="${searchDTO.endDate}" readonly="true">
											</div>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<select class="form-control" id="selectCallType" name="searchType">
												<option value="0">전체 Call</option>
												<option value="1">분노 단계</option>
												<option value="2">스트레스 단계</option>
												<option value="3">분노 or 스트레스 단계</option>
											</select>
										</div>
									</div>
									<div class="col-md-2">
										<button type="button" class="jsSearch btn btn-info hidden-print">조회</button>
									</div>
									
									<div class="col-md-8 box-header agentList" id="agentList"></div>
								</form>
								<!-- /. 검색 조건 -->
<%--
								<div class="col-md-12">
									<div class="box box-info">
										<!-- 
										<div class="box-header with-border">
											<h3>${searchDTO.startDate} ~ ${searchDTO.endDate} 콜별 감정분석 리포트 (총 : ${callAnalysisCount }개)</h3>
										</div>
										 -->
										<div class="box-body chart-responsive">
											<div class="chart" id="line-chart" style="height: 300px;"></div>
										</div>
										<div class="box-footer clearfix">
											<span class="pull-right"> 
												<i class="fa fa-minus" style="color: #54aaff;"></i> 분노 단계
												<i class="fa fa-minus" style="color: #de8162;"></i> 스트레스 단계
											</span>
										</div>
									</div>
								</div>
 --%>								
								<div class="col-md-12">
									<div class="box box-info">
										<div class="box-body chart-responsive">
										<table class="table table-bordered table-striped">
											<thead>
												<tr>
													<th class="no-sort">No.</th>
													<th class="no-sort">상담원</th>
													<th class="no-sort">고객번호</th>													
													<th class="no-sort">상담일</th>
													<th class="no-sort">시작시간</th>
													<th class="no-sort">종료시간</th>
													<th class="no-sort">통화시간(초)</th>
													<th class="no-sort">고객</th>
													<th class="no-sort">상담원</th>
													<!-- <th class="no-sort">Angry
														<span data-toggle="tooltip" title="Angry Call (Angry Count) : Angry Call 일 경우 Y (Angry Count) 와 같이 표시됩니다. Angry Call 이 아닐 경우 아무 것도 표시하지 않습니다." class="fa fa-question-circle"></span>
													</th>
													<th class="no-sort">Stress
														<span data-toggle="tooltip" title="Stress Call (Stress Count) : (Stress Call 일 경우 Y (Stress Count) 와 같이 표시됩니다. (Stress Call 이 아닐 경우 아무 것도 표시하지 않습니다." class="fa fa-question-circle"></span>
													</th> -->
													<th class="hidden-print">상세조회</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach varStatus="status" items="${callAnalysisList }" var="callAnalysis">
												<tr>
													<td>${((pageDTO.page-1)*pageDTO.itemPerPage)+status.index+1}</td>
													<td>${callAnalysis.agentName }</td>
													<td>${callAnalysis.customerNumber }</td>
													<td><fmt:formatDate pattern="yy-MM-dd" value="${callAnalysis.startTime }" /></td>
													<td><fmt:formatDate pattern="HH:mm:ss" value="${callAnalysis.startTime }" /></td>
													<td><fmt:formatDate pattern="HH:mm:ss" value="${callAnalysis.endTime }" /></td>
													<td>${callAnalysis.callDuration }</td>
													<td><span class="text-info">
														<c:if test="${callAnalysis.customerResult eq 1 &&  callAnalysis.customerFailCode eq 0 }">
															${callAnalysis.customerResultString }
														</c:if>
														</span>
													</td>
													<td><span class="text-info">
														<c:if test="${callAnalysis.agentResult eq 1 &&  callAnalysis.agentFailCode eq 0 }">
															${callAnalysis.agentResultString }
														</c:if>
														</span>
													</td>
													<td class="hidden-print">
														<button type="button" class="jsShowModal btn btn-default btn-xs" data-index="${callAnalysis.index }">
															<i class="fa fa-headphones"></i> 
														</button>
													</td>
												</tr>
												</c:forEach>
												<c:if test="${empty callAnalysisList }">
												<tr class="empty">
													<td colspan="11">조회할 콜 정보가 없습니다.</td>
												</tr>
												</c:if>
											</tbody>
										</table>
										</div>
										<div class="box-footer chart-responsive text-center">
											<ul class="pagination pagination-sm no-margin">
												<asnetPage:Pagination 
													page="${pageDTO.page }" 
													itemPerPage="${pageDTO.itemPerPage }" 
													pagePerGroup="${pageDTO.pagePerGroup }" 
													itemCount="${callAnalysisCount }" 
												/>
											</ul>
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

		<!-- Modal 콜 상세 조회 -->
		<div class="modal fade" id="modalCallDetail" tabindex="-1" role="dialog" aria-labelledby=""></div>
<script>
/*
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
			label: "Stress",
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
			label: "Angry",
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
*/
$(document).ready(function(){
	
	$(document).on("click", ".jsExcelDownload", function(e){
		e.preventDefault();
		window.open("/report/call_report_download?page=${pageDTO.page }&searchGroup=${searchDTO.searchGroup}&searchId=${searchDTO.searchId}&startDate=${searchDTO.startDate}&endDate=${searchDTO.endDate}&searchType=${searchDTO.searchType}", target="_blank");
	});

	$(document).on("click", ".jsPrint", function(e){
		e.preventDefault();
		print();
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
				alert("상담원 또는 그룹을 선택하여야 합니다.");
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
    	$("#form_callreport_search").submit();
    });
    <c:if test="${searchDTO.searchGroup != null and searchDTO.searchId == null }">
	$("#form_callreport_search").find("#selectAgentGroup option[value='${searchDTO.searchGroup}']").attr("selected", "selected");
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
		$("#form_callreport_search").find("#selectAgent option[value='" + idList + "']").attr("selected", "selected");
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
    /*
     * 페이징을 위해 필요한 스크립트입니다.
     * 단, 검색 상자등이 있을 경우에는 해당 항목의 이름 ( 아래에서는 form_search ) 등에 주의하셔야 합니다. 
     * 또한,Page가 정상적으로 동작하기 위해서는 해당 페이지에 <form id="form_search "...><input type="hidden" name="page"> 와 같은 코드가 반드시 필요합니다.
     */
    $(document).on("click", ".pagination li a", function(e) {
        e.preventDefault();
        var agentIdList = "";
        $(".jsRemoveSearchAgent").each(function(index){
			if( index != 0) agentIdList += ","; 
			agentIdList += ("'" + $(this).attr("data-agentId") + "'");
		});

		$("#searchId").val(agentIdList);	
        
        var page = $(this).attr("data-page");
        $("#form_callreport_search input[name='page']").val(page);
        
        $("#form_callreport_search").submit();
        
       // var pathname = window.location.pathname;
      //  window.location.href = pathname + "?" + $("#form_callreport_search").serialize();
    });
     
   // lineDraw();

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
  
	$(document).on("click", ".jsShowModal", function(e){
		e.preventDefault();
		var callIndex = $(this).attr("data-index"); 
		$("#modalCallDetail").load(
			"/report/call_view/"+callIndex, 
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
	/*
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
	*/
	 $('.player_audio').click(function() {
		    if ($('.player_audio').paused == false) {
		        $('.player_audio').pause();
		        alert('music paused');
		    } else {
		        $('.player_audio').play();
		        alert('music playing');
		    }
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
 
 
 function getDataUrlFromAgatePath(path) {
  var ext = path.split('.').pop();
  var dataUrl = "data:";
  if (ext.lastIndexOf('/') < 0) {
   ext = ext.toLowerCase();
   if (ext == "wav" || ext == "mp3") {
    dataUrl += "image/" + ext;
   }
  }
  dataUrl += ";base64," + agate.base64.read(path);
  return dataUrl;
 }
 
 /*
 function lineDraw(){
	//LINE CHART
	    var line = new Morris.Line({
	      element: 'line-chart',
	      resize: true,
	      data: [
			<c:forEach items="${dailyCallListForChart}" var="dailyCallItem"> {
	        	date: '<fmt:formatDate pattern="MM/dd" value="${dailyCallItem.statTime}" />', 
	        	<c:if test="${searchDTO.searchType eq '0' || searchDTO.searchType eq '3'}">
	        	AngryCall: ${dailyCallItem.angryCount}, 
	        	StressCall:${dailyCallItem.stressCount}
	        	</c:if>
	        	<c:if test="${searchDTO.searchType eq '1'}">
	        	AngryCall: ${dailyCallItem.angryCount} 
	        	</c:if>
	        	<c:if test="${searchDTO.searchType eq '2'}">
	        	StressCall: ${dailyCallItem.stressCount} 
	        	</c:if>
	        },
			</c:forEach>
	      ],
	      lineColors: ['#54aaff', '#de8162'],
	      xkey: 'date',
	      ykeys: ['AngryCall', 'StressCall'],
	      labels: ['Angry Call', 'Stress Call'],      
	      parseTime: false,
	      hideHover: 'auto'
	    });
 }
 */
</script>
</body>
</html>