<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<link rel="stylesheet" href="/resources/plugins/datepicker/datepicker3.css">
	<link rel="stylesheet" href="/resources/plugins/timepicker/bootstrap-timepicker.min.css">
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
	<script src="/resources/plugins/timepicker/bootstrap-timepicker.min.js"></script>
	<script src="/resources/plugins/select2/select2.full.min.js"></script>
<script>
$(document).ready(function(){
	if("${searchBoardIndex}" != null && "${searchBoardIndex}" != '') $("select[name=searchBoardIndex1]").val("${searchBoardIndex}").attr("selected","selected");
});
</script>
</head>

<body class="hold-transition skin-blue sidebar-mini">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			<h2><small>시스템 > 서비스 설정 ></small> 자동 수행 작업 목록</h2>
			</section>

			<!-- Main content -->
			<section class="content">

			<div class="row" style="height:800px">
				<div class="col-xs-12">
					<div class="box box-info">
						<div class="box-header">
							<h3 class="box-title">정기 수행 목록</h3>

							<!-- 
							<div class="box-tools">
								<div class="input-group input-group-sm" style="width: 150px;">
									<input type="text" name="table_search" class="form-control pull-right" placeholder="Search">
									<div class="input-group-btn">
										<button type="submit" class="btn btn-default">
											<i class="fa fa-search"></i>
										</button>
									</div>
								</div>
							</div>
							-->
							
						</div>
						
						<!-- /.box-header -->
						<div class="box-body table-responsive no-padding">
						<form role="form" id="form_batch_search"  action="" method="get">
									<input type="hidden" name="page" value="" />
									<input type="hidden" name="searchBoardIndex" id="searchBoardIndex" value="" />
									</form>
							<table class="table table-hover">
								<colgroup>
									<col class="col-width-type01" />
									<col />
									<col />
									<col />
									<col />
									<col />
									<col />
									<col />
									<col />
									<col />
								</colgroup>
								<tr>
									<th class="no-sort col-sm-1">작업명</th>
									<th class="no-sort col-sm-1">시작일</th>
									<th class="no-sort col-sm-1">종료일</th>
									<th class="no-sort col-sm-1">시작시간</th>
									<th class="no-sort col-sm-1">종료시간</th>
									<th class="no-sort col-sm-1">분석시작시간</th>
									<th class="no-sort col-sm-1">작업대상</th>
									<th class="no-sort col-sm-1">반복</th>
									<th class="no-sort col-sm-1">수정/삭제</th>
								</tr>
								
								<c:forEach items="${batchList}" var="batch">
									<tr>
										<td><a href="/service/batch_log?searchQuery=${batch.jobName }">${batch.jobName}</a></td>
										<td><fmt:formatDate value="${batch.startTime}" pattern="yyyy-MM-dd"/></td>
										<td><fmt:formatDate value="${batch.endTime}" pattern="yyyy-MM-dd"/></td>
										<td><c:set var="str2" value="${batch.recordStart}" />${ fn:substring(str2, 0, 2) }:${ fn:substring(str2, 2, 4) }</td>
										<td><c:set var="str2" value="${batch.recordEnd}" />${ fn:substring(str2, 0, 2) }:${ fn:substring(str2, 2, 4) }</td>
										<td><c:set var="str2" value="${batch.triggerTime}" />${ fn:substring(str2, 0, 2) }:${ fn:substring(str2, 2, 4) }:${ fn:substring(str2, 4, 6) }</td>
										<td>${batch.groupId}
											<c:if test="${batch.agentId ne '' && batch.agentId ne null}">
												,${batch.agentId}
											</c:if>
										</td>
										<td>
											<c:if test="${batch.repeat eq '0'}">
												N
											</c:if>
											<c:if test="${batch.repeat eq '1'}">
												Y
											</c:if>
										</td>
										<td>
											<div class="btn-group">
												<button type="button" class="jsShowModal btn btn-default btn-xs" data-index="${batch.index }">수정</button>
												<button type="button" class="jsDelete btn btn-default btn-xs" data-index="${batch.index },${batch.jobName }">삭제</button>
											</div>
										</td>
									</tr>
								</c:forEach>
								<c:if test="${empty batchList}">
									<tr class="empty">
										<td colspan="8">현재 등록된 수행 작업이 없습니다.</td>
									</tr>
								</c:if>
							</table>
						</div>
						<!-- /.box-body -->
						<div class="box-footer clearfix text-center">
							<form id="form_search" class="hide">
							
							</form>
							<ul class="pagination pagination-sm no-margin">
								<asnetPage:Pagination 
									page="${pageDTO.page }" 
									itemPerPage="${pageDTO.itemPerPage }" 
									pagePerGroup="${pageDTO.pagePerGroup }" 
									itemCount="${batchCount }" 
								/>	
							</ul>
							<button type="button" class="btn btn-info pull-right" data-toggle="modal" data-target="#modal_batchCreate">신규 수행 등록</button>
						</div>
						<div class="input-group input-group-sm col-md-3 pull-right" style="width:100px; margin-top: 10px;">
							<select class="form-control" id="searchBoardIndex1" name="searchBoardIndex1">
								<option value="">선택</option>
								<option value="5">5개</option>
								<option value="10">10개</option>
								<option value="15" selected="selected">15개</option>
								<option value="25">25개</option>
								<option value="50">50개</option>
								<option value="100">100개</option>
							</select>
							<div class="input-group-btn">
								<button type="button" class="jsSearch btn btn-default" tabindex="3">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</div>
					</div>
					<!-- /.box -->
				</div>
			</div>
			</section>
			<!-- /.content -->
		<%@include file="modal_batchCreate.jsp"%>
		<%@include file="modal_batchEdit.jsp"%>
	
<script>
$(document).ready(function(){
	
	//검색
	$(document).on("click", ".jsSearch", function(e){
    	e.preventDefault();
    	document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
   	
    	$("#form_batch_search").submit();
    });
	
	$(window).keydown(function(event){
        if(event.keyCode == 13) {
          event.preventDefault();
          return false;
        }
    });
	
	//Initialize Select2 Elements
    $(".select2").select2();
    $(".select3").select2();
	
	$('#modal_batchCreate').on('shown.bs.modal', function (e) {
		$('#startTime').datepicker({
	        autoclose: true
	    });
	    
	    $('#endTime').datepicker({
	        autoclose: true
	    });
	    
	  	//Timepicker
	    $(".timepicker").timepicker({
	      showInputs: false,
	      showMeridian: false
	    });
	});
	
	$('#modal_batchEdit').on('shown.bs.modal', function (e) {
		$('#startTime2').datepicker({
	        autoclose: true
	    });
	    
	    $('#endTime2').datepicker({
	        autoclose: true
	    });
	    
	  	//Timepicker
	    $(".timepicker").timepicker({
	      showInputs: false,
	      showMeridian: false
	    });
	  	
	  	
	});
	
	/*
     * 페이징을 위해 필요한 스크립트입니다.
     * 단, 검색 상자등이 있을 경우에는 해당 항목의 이름 ( 아래에서는 form_search ) 등에 주의하셔야 합니다. 
     * 또한,Page가 정상적으로 동작하기 위해서는 해당 페이지에 <form id="form_search "...><input type="hidden" name="page"> 와 같은 코드가 반드시 필요합니다.
     */
    $(document).on("click", ".pagination li a", function(e) {
        e.preventDefault();
        var page = $(this).attr("data-page");
        $("#form_batch_search input[name='page']").val(page);
        document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
        var pathname = window.location.pathname;
        window.location.href = pathname + "?" + $("#form_batch_search").serialize();
    });
	
    $.fn.serializeObject = function(){
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	    	var name = $.trim(this.name),
	    		value = $.trim(this.value);
	    	
	        if (o[name]) {
	            if (!o[name].push) {
	                o[name] = [o[name]];
	            }
	            o[name].push(value || '');
	        } else {
	            o[name] = value || '';
	        }
	    });
	    return o;
	};	
  	
	//해당 그룹에 맞는 상담원 표시
	$(document).on("change", "#selectAgentGroup", function(){
		var agentGroupId = $("#selectAgentGroup").val();
		if(agentGroupId != "allGroup") {
			$.ajax({
				url : "/REST/agent/listAgent/" +agentGroupId,
			}).done(function(resultList){
				$("#form_batch_create").find("#agentId").empty();
				$("#form_batch_create").find("#agentId").append("<option value=''>전체 상담원</option>");
				if( resultList != null ) {
					$.each(resultList, function (index, agent){
						$("#form_batch_create").find("#agentId").append("<option value='"+agent.agentId+"'>"+agent.agentName+"</option>");
					});	
				}
			});
		} else {
			$("#form_batch_create").find("#agentId").empty().append("<option value='noAgent'>그룹을 선택하세요</option>");
		} 	
	});

	$(document).on("change", "#groupId", function(){
		var agentGroupId = $("#groupId").val();
		if(agentGroupId != "allGroup") {
			$.ajax({
				url : "/REST/agent/listAgent/" +agentGroupId,
			}).done(function(resultList){
				$("#form_batch_update").find("#agentId").empty();
				$("#form_batch_update").find("#agentId").append("<option value=''>전체 상담원</option>");
				if( resultList != null ) {
					$.each(resultList, function (index, agent){
						$("#form_batch_update").find("#agentId").append("<option value='"+agent.agentId+"'>"+agent.agentName+"</option>");
					});	
				}
			});
		} else {
			$("#form_batch_update").find("#agentId").empty().append("<option value=''>그룹을 선택하세요</option>");
		} 	
	});
	
  	
	//자동수행작업목록 등록
	$(document).on('click', '.jsCreate', function(e){
    	e.preventDefault();
    	
    	if ($.trim($("#form_batch_create").find("#jobName").val()).trim().length < 1){
    		alert("작업명을 입력해야 합니다.");
    		$("#form_batch_create").find("#jobName").focus();
    		return false;
    	}
    	
    	if ($.trim($("#startTime").val()).trim().length < 1){
    		alert("시작일을 선택해야 합니다.");
    		$("#startTime").focus();
    		return false;
    	} 
    	
    	if ($.trim($("#endTime").val()).trim().length < 1){
    		alert("종료일을 선택해야 합니다.");
    		$("#endTime").focus();
    		return false;
    	}
    	
    	if ($.trim($("#repeat").val()).trim().length < 1){
    		$("#repeat").val("0");
    	}
    	
    	checkTimepicker();
    	var batchFormData = $("#form_batch_create").serialize();
    	$.ajax({
    		url:"/REST/batch/createBatch",
    		data : batchFormData,
    		dataType : "JSON",
    		method : "POST",
    		success : function(result) {
    			console.info(result);
	    		if( result ) {
	    			if( result.index > 0 ) { 
	    				alert("성공적으로 등록되었습니다.");
    					location.reload();
	    			} else {
	    				alert("새로운 자동수행목록 등록에 실패하였습니다.");
	    			}
	    		}
    		},error : function(err){
    			console.info(err)
    		}
    	});
    });
	
  	
	//자동수행작업목록 수정 버튼 클릭 시 
	$(document).on("click", ".jsShowModal", function(e){
    	e.preventDefault();
    	var batchIndex = $(this).attr("data-index");
    	$.ajax({
    		url:"/REST/batch/selectBatch/" + batchIndex,
    		dataType : "JSON",
    		method : "GET",
    		success : function(result) {
    	    	if( result ) {
    	    		var checktime;
    	    		var date;
    	    		$("#modal_batchEdit").modal("show");
    	    		$("#form_batch_update").find("#index").val(result.index);
    	    		$("#form_batch_update").find("#jobName").val(result.jobName);
    	    		date = new Date(result.startTime);
    	    		$("#form_batch_update").find("#startTime2").val(date.yyyymmdd());
    	    		date = new Date(result.endTime);
    	    		$("#form_batch_update").find("#endTime2").val(date.yyyymmdd());
    	    		checktime = checkupdatetime(result.recordStart);
    	    		$("#form_batch_update").find("#recordStart2").val(checktime);
    	    		checktime = checkupdatetime(result.recordEnd);
    	    		$("#form_batch_update").find("#recordEnd2").val(checktime);
    	    		checktime = checkupdatetime(result.triggerTime);
    	    		$("#form_batch_update").find("#triggerTime2").val(checktime);
    	    		$("#form_batch_update").find("#groupId option[value='"+ result.groupId +"']").attr("selected", "selected");
    	    		$("#form_batch_update").find("#agentId option[value='"+ result.agentId +"']").attr("selected", "selected");
    	    		$("#form_batch_update").find("#status").val(result.status);
    	    		if (result.repeat == '1') {
	    	    		$("#form_batch_update").find(':input:checkbox[name="repeat"]').attr("checked", true);
    	    		}
    	    	} else {
    	    		alert("해당 상담원의 정보를 가져올 수 없습니다.");
    	    	}
    		}
    	});
    });
	
	//수정을 위한 스크립트 입니다.
	$(document).on('click', '.jsUpdate', function(e){
    	e.preventDefault();
    	if ($.trim($("#form_batch_update").find("#jobName").val()).trim().length < 1){
    		alert("작업명을 입력해야 합니다.");
    		$("#form_batch_update").find("#jobName").focus();
    		return false;
    	}
    	if ($("#form_batch_update").find("#groupId").val() == "allGroup") {
    		$("#form_batch_update").find("#groupId").val('');
    	}
    	checkTimepickerUpdate();
    	var batchFormData = $("#form_batch_update").serialize();
    	$.ajax({
    		url:"/REST/batch/updateBatch",
    		data : batchFormData,
    		dataType : "JSON",
    		method : "POST",
    		success : function(result) {
	    		if( result ) {
	    			if( result.index > 0 ) { 
	    				alert("성공적으로 수정 되었습니다.");
	    				
    					location.reload();
	    			} else {
	    				alert("자동수행작업 수정에 실패하였습니다.");
	    			}
	    		}
    		}
    	});
    });
	
	//삭제
	$(document).on("click", ".jsDelete", function(e){
    	e.preventDefault();
    	var username = "${sessionScope.sessionUser.currentUser.userName }";
    	var userid = "${sessionScope.sessionUser.currentUser.userId}";

    	var batchIndex = $(this).attr("data-index")+ "," + username + "," + userid;
    	
    	if(confirm("한번 삭제하면 복구할 수 없습니다. 계속 하시겠습니까?")) {
	    	$.ajax({
	    		url:"/REST/batch/deleteBatch/" + batchIndex,
	    		dataType : "JSON",
	    		method : "GET",
	    		success : function(result) {
	    	    	if( result) {
	    	    		// alert("정상적으로 삭제되어, 화면을 갱신합니다.");
	    	    		location.reload();
	    	    	} else {
	    	    		alert("해당 상담원의 정보를 가져올 수 없습니다.");
	    	    	}
	    		}
	    	});
    	}
    });
	
	//등록
	//종료시간은 시작시작을  넘지 못하게 하는 스크립트입니다.
	$(document).on("change", "#recordEnd", function(){
		var recordStart = $("#recordStart").val().substring(0,2);
	    var recordEnd = $("#recordEnd").val().substring(0,2);
	    var recordStart2 = $("#recordStart").val().substring(3,5);
	    var recordEnd2 = $("#recordEnd").val().substring(3,5);
	    var startTime = $("#startTime").val();
	    var endTime = $("#endTime").val();
	    var startTimeCompare = new Date(startTime);
	    var endTimeCompare = new Date(endTime);

		if(startTimeCompare.getTime() == endTimeCompare.getTime()) {
		    if(recordStart && recordEnd ){
			    if(recordStart > recordEnd) {
			        alert("종료시간은 시작시간과 같거나 이후의 시간으로 입력되어야 합니다.");
			        $("#recordEnd").val($("#recordStart").val());
			        $("#recordEnd").focus();
			        $("#checkDatepicker").val("false");
			    }else if(recordStart == recordEnd){
			    	if(recordStart2 > recordEnd2){
			    		alert("종료시간은 시작시간과 같거나 이후의 시간으로 입력되어야 합니다.");
				        $("#recordEnd").val($("#recordStart").val());
				        $("#recordEnd").focus();
				        $("#checkDatepicker").val("false");
			    	}
			    }else{
			    	$("#checkDatepicker").val("true");
			    }
		    }
		}
	});
	
	//종료시간은 시작시작을  넘지 못하게 하는 스크립트입니다.
	$(document).on("change", "#recordStart", function(){
		var recordStart = $("#recordStart").val().substring(0,2);
	    var recordEnd = $("#recordEnd").val().substring(0,2);
	    var recordStart2 = $("#recordStart").val().substring(3,5);
	    var recordEnd2 = $("#recordEnd").val().substring(3,5);
	    var startTime = $("#startTime").val();
	    var endTime = $("#endTime").val();
	    var startTimeCompare = new Date(startTime);
	    var endTimeCompare = new Date(endTime);

		if(startTimeCompare.getTime() == endTimeCompare.getTime()) {
		    if(recordStart && recordEnd ){
			    if(recordStart > recordEnd) {
			        alert("종료시간은 시작시간과 같거나 이후의 시간으로 입력되어야 합니다.");
			        $("#recordStart").val($("#recordEnd").val());
			        $("#recordStart").focus();
			        $("#checkDatepicker").val("false");
			    }else if(recordStart == recordEnd){
			    	if(recordStart2 > recordEnd2){
			    		alert("종료시간은 시작시간과 같거나 이후의 시간으로 입력되어야 합니다.");
				        $("#recordStart").val($("#recordEnd").val());
				        $("#recordStart").focus();
				        $("#checkDatepicker").val("false");
			    	}
			    }else{
			    	$("#checkDatepicker").val("true");
			    }
		    }
		}
	});
	
	//수정
	//종료시간은 시작시작을  넘지 못하게 하는 스크립트입니다.
	$(document).on("change", "#recordEnd2", function(){
		var recordStart = $("#recordStart2").val().substring(0,2);
	    var recordEnd = $("#recordEnd2").val().substring(0,2);
	    var recordStart2 = $("#recordStart2").val().substring(3,5);
	    var recordEnd2 = $("#recordEnd2").val().substring(3,5);
	    var startTime = $("#startTime2").val();
	    var endTime = $("#endTime2").val();
	    var startTimeCompare = new Date(startTime);
	    var endTimeCompare = new Date(endTime);

		if(startTimeCompare.getTime() == endTimeCompare.getTime()) {
		    if(recordStart && recordEnd ){
			    if(recordStart > recordEnd) {
			        alert("종료시간은 시작시간과 같거나 이후의 시간으로 입력되어야 합니다.");
			        $("#recordEnd2").val($("#recordStart2").val());
			        $("#recordEnd2").focus();
			        $("#checkDatepicker").val("false");
			    }else if(recordStart == recordEnd){
			    	if(recordStart2 > recordEnd2){
			    		alert("종료시간은 시작시간과 같거나 이후의 시간으로 입력되어야 합니다.");
				        $("#recordEnd2").val($("#recordStart2").val());
				        $("#recordEnd2").focus();
				        $("#checkDatepicker").val("false");
			    	}
			    }else{
			    	$("#checkDatepicker").val("true");
			    }
		    }
		}
	});
	
	//종료시간은 시작시작을  넘지 못하게 하는 스크립트입니다.
	$(document).on("change", "#recordStart2", function(){
		var recordStart = $("#recordStart2").val().substring(0,2);
	    var recordEnd = $("#recordEnd2").val().substring(0,2);
	    var recordStart2 = $("#recordStart2").val().substring(3,5);
	    var recordEnd2 = $("#recordEnd2").val().substring(3,5);
	    var startTime = $("#startTime2").val();
	    var endTime = $("#endTime2").val();
	    var startTimeCompare = new Date(startTime);
	    var endTimeCompare = new Date(endTime);

		if(startTimeCompare.getTime() == endTimeCompare.getTime()) {
		    if(recordStart && recordEnd ){
			    if(recordStart > recordEnd) {
			        alert("종료시간은 시작시간과 같거나 이후의 시간으로 입력되어야 합니다.");
			        $("#recordStart2").val($("#recordEnd2").val());
			        $("#recordStart2").focus();
			        $("#checkDatepicker").val("false");
			    }else if(recordStart == recordEnd){
			    	if(recordStart2 > recordEnd2){
			    		alert("종료시간은 시작시간과 같거나 이후의 시간으로 입력되어야 합니다.");
				        $("#recordStart2").val($("#recordEnd2").val());
				        $("#recordStart2").focus();
				        $("#checkDatepicker").val("false");
			    	}
			    }else{
			    	$("#checkDatepicker").val("true");
			    }
		    }
		}
	});
});

//날짜 format 스크립트입니다.
Date.prototype.yyyymmdd = function() {
	  var mm = this.getMonth() + 1; // getMonth() is zero-based
	  var dd = this.getDate();
	  
	  if(mm < 10){
		  mm = "0"+mm;
	  }
	  if(dd < 10){
		  dd = "0"+dd;
	  }
	  return [this.getFullYear(),'-',mm,'-',dd].join(''); // padding
};

function checkTimepicker(){
	var time = $("#recordStart").val();
	var time2 = $("#recordEnd").val();
	var time3 = $("#triggerTime").val();
	var hour1 = time.substring(0,2);
	var hour2 = time2.substring(0,2);
	var hour3 = time3.substring(0,2);
	
	var minute1 = time.substring(3,5);
	var minute2 = time2.substring(3,5);
	var minute3 = time3.substring(3,5);
	
	$("#recordStart").val(hour1+minute1);
	$("#recordEnd").val(hour2+minute2);
	$("#triggerTime").val(hour3+minute3);
}

function checkTimepickerUpdate(){
	var time = $("#recordStart2").val();
	var time2 = $("#recordEnd2").val();
	var time3 = $("#triggerTime2").val();
	
	var hour1 = time.substring(0,2);
	var hour2 = time2.substring(0,2);
	var hour3 = time3.substring(0,2);
	
	var minute1 = time.substring(3,5);
	var minute2 = time2.substring(3,5);
	var minute3 = time3.substring(3,5);
	
	$("#recordStart2").val(hour1+minute1);
	$("#recordEnd2").val(hour2+minute2);
	$("#triggerTime2").val(hour3+minute3);
}

/* 시작일과 종료일을 비교하기 위한 함수입니다.
 * 시작일  > 종료일, 종료일 < 시작일 일때 경고창을 띄어 줍니다.
 */
function checkDatepicker() {
 
	var datepicker = $("#startTime").val();
    var datepicker2 = $("#endTime").val();
    
    var startDateCompare = new Date(datepicker);
    var endDateCompare = new Date(datepicker2);
     
    if(datepicker != "" && datepicker2 != ""){
	    if(startDateCompare.getTime() > endDateCompare.getTime()) {
	        alert("종요일은 시작일과 같거나 이후의 날짜로 입력되어야 합니다.");
	        $("#endTime").val("");
	        $("#endTime").focus();
	        $("#checkDatepicker").val("false");
	    }else{
	    	$("#checkDatepicker").val("true");
	    }
    }

}
 
/* 시작일과 종료일을 비교하기 위한 함수입니다.
 * 시작일  > 종료일, 종료일 < 시작일 일때 경고창을 띄어 줍니다.
 */
function checkDatepickerupdate() {
 
	var datepicker = $("#startTime2").val();
    var datepicker2 = $("#endTime2").val();
    
    var startDateCompare = new Date(datepicker);
    var endDateCompare = new Date(datepicker2);
     
    if(datepicker != "" && datepicker2 != ""){
	    if(startDateCompare.getTime() > endDateCompare.getTime()) {
	        alert("종요일은 시작일과 같거나 이후의 날짜로 입력되어야 합니다.");
	        $("#endTime2").val("");
	        $("#endTime2").focus();
	        $("#checkDatepicker").val("false");
	    }else{
	    	$("#checkDatepicker").val("true");
	    }
    }

}
 
 function checkupdatetime(checktime){
	 
	 var checktime = checktime;
	 var hour = checktime.substring(0,2);
	 var minute = checktime.substring(2,4);
	 
	 checktime = hour+":"+minute;
	 
	 return checktime;
 }
</script>

</body>
</html>