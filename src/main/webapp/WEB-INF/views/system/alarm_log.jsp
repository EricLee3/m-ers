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
	<script>
		$(document).ready(function(){
			if("${searchType}" != null && "${searchType}" != '') $("select[name=searchType]").val("${searchType}").attr("selected","selected");
			if("${searchId}" != null && "${searchId}" != '') $("select[name=searchId]").val("${searchId}").attr("selected","selected");
			if("${searchBoardIndex}" != null && "${searchBoardIndex}" != '') $("select[name=searchBoardIndex1]").val("${searchBoardIndex}").attr("selected","selected");
		});
	</script>
</head>

<body class="hold-transition skin-blue sidebar-mini">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			<h2><small>시스템 ></small> 알람 이력</h2>
			</section>
			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box box-success">
							<div class="box-header">
								<h3 class="box-title">알람 이력<small>(총 : ${alarmLogCount }개, 조회기간 : ${searchDTO.startDate} ~ ${searchDTO.endDate})</small></h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body" style="width:100%;">
								<!-- 검색 조건 -->
								<form role="form" id="form_alarmLog_search"  action="" method="get">
									<input type="hidden" name="page" value="" />
									<input type="hidden" name="searchBoardIndex" id="searchBoardIndex" value="" />
									<div class="col-md-2 hidden-print">
										<div class="form-group">
											<div class="input-group date">
												<div class="input-group-addon">
													<i class="fa fa-calendar"></i>
												</div>
												<input type="hidden" id="checkDatepicker" value="false"> 
												<input type="text" name="startDate" class="form-control pull-right" id="startDate" placeholder="분석시작일" value="${searchDTO.startDate}" readonly="true">
											</div>
										</div>
									</div>
									
								<div class="col-md-2 hidden-print">
										<div class="form-group">
											<div class="input-group date">
												<div class="input-group-addon">
													<i class="fa fa-calendar"></i>
												</div>
												<input type="text" name="endDate" class="form-control pull-right" id="endDate" placeholder="분석종료일" value="${searchDTO.endDate}" readonly="true">
											</div>
										</div>
									</div>
									<div class="col-md-2 hidden-print">
										<div class="form-group">
											<input tabindex="1" type="text" id="searchQuery" name="searchQuery" class="form-control pull-right" placeholder="알람코드" value="${searchDTO.searchQuery }"> 
										</div>
									</div>
									<div class="col-md-2 hidden-print"style="width:150px;">
											<div class="form-group">
													<select class="form-control" id="searchType" name="searchType">
														<option value="">전체 상태</option>
														<option value="1">발생</option>
														<option value="0">해제</option>
													</select>
										</div>
									</div>
									<div class="col-md-2 hidden-print"style="width:150px;">
											<div class="form-group">
													<select class="form-control" id="searchId" name="searchId">
														<option value="">전체 레벨</option>
														<option value="3">CRITICAL</option>
														<option value="2">MAJOR</option>
														<option value="1">MINOR</option>
														<option value="0">NORMAL</option>
														<option value="4">FAULT</option>
													</select>
										</div>
									</div>
									<div class="col-md-2 hidden-print">
										<div class="form-group">
											<input type="text" class="form-control" id="searchCondition" name="searchCondition" placeholder="알람정보 " value="<c:if test="${searchDTO.searchCondition ne null && searchDTO.searchCondition ne '' }">${searchDTO.searchCondition}</c:if>" maxlength="30">
										</div>
									</div>
									<div class="col-md-2 hidden-print" style="width: 50px;">
										<button type="button" class="jsSearch btn btn-info">조회</button>
									</div>
								</form>
								<!-- /. 검색 조건 -->
						</div>
						<!-- /.box-header -->
						<div class="box-body table-responsive no-padding">
							<table id="example1" class="table table-bordered table-striped" style="width: 100%;"> 
								<thead>
									<tr>
										<th class="no-sort" style="width: 3%;">No.</th>
										<th class="no-sort" style="width: 10%;">발생시간</th>
										<th class="no-sort" style="width: 10%;">해제시간</th>
										<th class="no-sort" style="width: 5%;">시스템명</th>
										<th class="no-sort col-sm-1">알람코드</th>
										<th class="no-sort col-sm-1">알람 상태</th>
										<th class="no-sort col-sm-1">알람 레벨</th>
										<th class="no-sort" width="*%">알람정보</th>
										<!-- 
										<th class="no-sort col-sm-1">삭제</th>
										 -->
									</tr>
								</thead>
								<c:forEach varStatus="status" items="${alarmLogList}" var="alarmLog">

									<tr>
										<td>${((pageDTO.page-1)*pageDTO.itemPerPage)+status.index+1}</td>
										<td><fmt:formatDate value="${alarmLog.alarmedTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td><fmt:formatDate value="${alarmLog.releaseTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td>${alarmLog.sysName}</td>
										<td>${alarmLog.alarmCode}</td>										
										<c:if test="${alarmLog.alarmFlag eq 0}">
										<td><font color="green">해제</td>
										</c:if>
										<c:if test="${alarmLog.alarmFlag eq 1}">
										<td><font color="red">발생</font></td>
										</c:if>
										<c:if test="${alarmLog.alarmLv eq 0}">
										<td><a class="normal">NORMAL</a></td>
										</c:if>
										<c:if test="${alarmLog.alarmLv eq 1}">
										<td><a class="minor">MINOR</a></td>
										</c:if>
										<c:if test="${alarmLog.alarmLv eq 2}">
										<td><a class="major">MAJOR</a></td>
										</c:if>
										<c:if test="${alarmLog.alarmLv eq 3}">
										<td><a class="critical">CRITICAL</a></td>
										</c:if>
										<c:if test="${alarmLog.alarmLv eq 4}">
										<td><a class="fault">FAULT</a></td>
										</c:if>
										<td>
											<nobr>
												<span title="${alarmLog.alarmDetail}" style="CURSOR:hand;">
													<p style="width:420px;overflow:hidden;text-overflow:ellipsis" >${alarmLog.alarmDetail} 
													</p>
												</span>	
											</nobr>
	
										</td>

										<!-- 
										<td>
											<div class="btn-group">
												<button type="button" class="jsDelete btn btn-default btn-xs" data-index="${batchHistory.index }">삭제</button>
											</div>
										</td>
										 -->
									</tr>

								</c:forEach>
								<c:if test="${empty alarmLogList}">
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
										itemCount="${alarmLogCount }" 
									/>
								</ul>
								<!-- <button type="button" class="btn btn-default pull-right hidden-print" onclick="print()"><i class="fa fa-print"></i><small> 인쇄</small></button> -->
								<!-- <button type="button" class="btn btn-info pull-right margin-r-5 hidden-print"><i class="fa fa-file-excel-o"></i></button> -->
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
	
<script>
$(document).ready(function(){
	
	$('#startDate').datepicker({
	      autoclose: true
    });
    
    $('#endDate').datepicker({
        autoclose: true
	});
	
	//검색시 enter키 활성화
	$("#form_alarmLog_search input[name=searchQuery]").keydown(function(e){
        if(e.keyCode == 13){
            e.cancelBubble = true;
            $(".jsSearch").click();
            return false;
        }
    });
	
	//검색
	$(document).on("click", ".jsSearch", function(e){
    	e.preventDefault();
        var searchQuery = $("#searchQuery").val();
    
    	var regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-+<>@\#$%&\\\=\(\'\"]/gi;
    	searchQuery = searchQuery.replace(regExp, "");
    	
    	document.getElementById("searchQuery").value = searchQuery;
    	document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
   	
    	$("#form_alarmLog_search").submit();
    	
    	<c:if test="${searchDTO.searchType != null}">
        $("#form_customerCall_search").find("#selectCallType option[value='${searchDTO.searchType}']").attr("selected", "selected");
        </c:if>
    });
	
	//삭제
	$(document).on("click", ".jsDelete", function(e){
    	e.preventDefault();
    	var batchHistoryIndex = $(this).attr("data-index");
    	if(confirm("한번 삭제하면 복구할 수 없습니다. 계속 하시겠습니까?")) {
	    	$.ajax({
	    		url:"/REST/batchHistory/deleteBatchHistory/" + batchHistoryIndex,
	    		dataType : "JSON",
	    		method : "GET",
	    		success : function(result) {
	    	    	if( result) {
	    	    		// alert("정상적으로 삭제되어, 화면을 갱신합니다.");
	    	    		location.reload();
	    	    	} else {
	    	    		alert("해당 자동수행작업목록의 히스토리 정보를 가져올 수 없습니다.");
	    	    	}
	    		}
	    	});
    	}
    });
	
    /*
     * 페이징을 위해 필요한 스크립트입니다.
     * 단, 검색 상자등이 있을 경우에는 해당 항목의 이름 ( 아래에서는 form_search ) 등에 주의하셔야 합니다. 
     * 또한,Page가 정상적으로 동작하기 위해서는 해당 페이지에 <form id="form_search "...><input type="hidden" name="page"> 와 같은 코드가 반드시 필요합니다.
     */
    $(document).on("click", ".pagination li a", function(e) {
        e.preventDefault();
        var page = $(this).attr("data-page");
        $("#form_alarmLog_search input[name='page']").val(page);
        document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
        var pathname = window.location.pathname;
        window.location.href = pathname + "?" + $("#form_alarmLog_search").serialize();
    });
	
     
  	//달력(시작일,종료일)에서 .day(일)를 클릭했을때마다 실행되는 스크립트 입니다.
    $(document).on('click', '.day', function(e){
    	e.preventDefault();
    	checkDatepicker();
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