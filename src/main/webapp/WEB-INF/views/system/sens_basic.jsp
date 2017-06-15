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
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	<script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="/resources/plugins/fastclick/fastclick.js"></script>
	<script src="/resources/js/app.min.js"></script>
	<script type="text/javascript"> 
	function numkeyCheck(e) { var keyValue = event.keyCode; if( ((keyValue >= 48) && (keyValue <= 57)) ) return true; else return false; } 
	</script>

	<script>
		$(document).ready(function(){
			if("${searchId}" != null && "${searchId}" != '') $("select[name=searchId]").val("${searchId}").attr("selected","selected");
			if("${searchBoardIndex}" != null && "${searchBoardIndex}" != '') $("select[name=searchBoardIndex1]").val("${searchBoardIndex}").attr("selected","selected");
		});
	</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h2><small>시스템 ></small> 기본 감성지표(Basic Indicator) 관리</h2>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row" style="height: 800px;">
					<div class="col-xs-12">
						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">기본 감성지표(Basic Indicator) 목록</h3>
							</div>
							<div class="box-body table-responsive no-padding">
							<form role="form" id="form_sensBasic_search"  action="" method="get">
									<input type="hidden" name="page" value="" />
									<input type="hidden" name="searchBoardIndex" id="searchBoardIndex" value="" />
									<div class="col-md-2 hidden-print">
										<div class="form-group">
											<select class="form-control" id="searchId" name="searchId">
												<option value="">ALL</option>
												<c:forEach items="${nameList}" var="name">
													<option value="${name.name}">${name.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								
									<div class="col-md-2 hidden-print">
										<button type="button" class="jsSearch btn btn-info">조회</button>
									</div>
									</form>
							
								<table class="table table-hover">
									<thead>
									<tr>
										<th class="col-sm-1">No</th>
										<th class="col-sm-1">Indicator</th>
										<th class="col-sm-1">Type</th>
										<th class="col-sm-1">Min</th>
										<th class="col-sm-1">Max</th>
										<th class="col-sm-1">설명</th>
										<th class="col-sm-1">수정/삭제</th>
									</tr>
									</thead>
									<tbody>
										<c:forEach varStatus="status" items="${sensbasicList}" var="basic">
									<tr>
										<td>${((pageDTO.page-1)*pageDTO.itemPerPage)+status.index+1}</td>
										<td>${basic.name}</td>
										<c:if test="${basic.type eq 0}">
											<td>Basic</td>
										</c:if>
										<c:if test="${basic.type eq 1}">
											<td>Calculated</td>
										</c:if>
										<td>${basic.min}</td>
										<td>${basic.max}</td>
										<td>${basic.description}</td>
										<td>
											<div class="btn-group">
												<button type="button" class="jsShowModal btn btn-default btn-xs" data-groupid="${basic.basic_idx }">수정</button>
												<button type="button" class="jsDeleteSensBasic btn btn-default btn-xs" data-groupid="${basic.basic_idx },${basic.name},${basic.type}">삭제</button>
											</div>
										</td>
									</tr>
									</c:forEach>
										<c:if test="${empty sensbasicList }">
											<tr class="empty">
												<td colspan="8">현재 등록된 데이터가 없습니다.</td>
											</tr>
										</c:if>
									</tbody>
								</table>
							</div>
							<div class="box-footer clearfix text-center">
								<button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#myModal">등록</button>
							
								<ul class="pagination pagination-sm no-margin">
									<asnetPage:Pagination 
										page="${pageDTO.page }" 
										itemPerPage="${pageDTO.itemPerPage }" 
										pagePerGroup="${pageDTO.pagePerGroup }" 
										itemCount="${SensBasicCount }" 
									/>
								</ul>
								<!-- <button type="button" class="btn btn-default pull-right hidden-print" onclick="print()"><i class="fa fa-print"></i><small> 인쇄</small></button> -->
								<!-- <button type="button" class="btn btn-info pull-right margin-r-5 hidden-print"><i class="fa fa-file-excel-o"></i></button> -->
						</div>
						<%--
						<form role="form" id="form_sensBasic_search"  action="" method="get">
							<input type="hidden" name="page" value="" />
							<input type="hidden" name="searchBoardIndex" id="searchBoardIndex" value="" />
							 --%>
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
								<%--
							</form>
							 --%>
						</div>
					</div>
				</div>
			</section>
			<!-- /.content -->
		
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">기본 감성지표(Basic Indicator) 등록</h4>
					</div>
					<form role="form" id="form_sensbasic_create" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<input type="hidden" id="checkedGroupId" name="checkedGroupId" value="false">
						<div class="modal-body">
							<div class="form-group" style="margin-bottom: 30px;">
								<span class="pull-right"><span class="text-danger"><strong>*</strong></span>는 필수입력정보입니다.</span></td>
							</div>
							<div class="form-group" align="center">
							<table cellpadding="0" border="0" align="center" width="100%">
								<tr align="center">
									<td width="40%" align="center"><label for="desc">Indicator<span class="text-danger">*</span></label> </td>
									<td width="30%" align="center"><label for="desc">Min<span class="text-danger">*</span></label> </td>
									<td width="30%" align="center"><label for="desc">Max<span class="text-danger">*</span></label> </td>
								</tr>
								<tr align="center">
									<td align="center" id="example1"> 
									<input type="text" class="form-control" id="name" name="name" maxlength="20" style="width:95%">
									<span id="checkGroupIdMsg" class="help-block">
										<i class="fa fa-exclamation-circle" aria-hidden="true"></i> 중복 검사 필요
									</span>
									<%--
										<select name="indicator" class="form-control" style="width:95%">
											<option value="">선택</option>
										</select>
									--%>
									</td>
									<td align="center"> 
										<input type="text" onKeyPress="return numkeyCheck(event)" style="width:95%" class="form-control" id="min" name="min" maxlength="2" style="width:100px">
										<span id="checkGroupIdMsg" class="help-block">
										&nbsp;
										</span>
									</td>
									<td align="center">
										<input type="text" onKeyPress="return numkeyCheck(event)" style="width:95%" class="form-control" id="max" name="max" maxlength="2" style="width:100px">
										<span id="checkGroupIdMsg" class="help-block">
										&nbsp;
										</span>
									</td>
								</tr>
							</table>
							</div>
							<div class="form-group">
								<label for="desc">Type<span class="text-danger">*</span></label> 
								<select class="form-control" id="type" name="type">
										<option value="0">Basic</option>
										<option value="1">Calculated</option>
									</select>
							</div>
							<div class="form-group">
								<label for="desc">Description</label> 
								<input type="text" class="form-control" id="description" name="description" placeholder="설명을 입력하세요" maxlength="64" >
							</div>
							
							<!-- 
							<div class="form-group">
								<label for="GroupName">Basic Emotion<span class="text-danger">*</span></label> 
								<input type="text" class="form-control" id="groupName" name="groupName" placeholder="그룹명을 입력하세요" maxlength="20">
							</div>
							 -->
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left" data-dismiss="modal">취소</button>
							<button type="button" class="jsCreate btn btn-primary">등록</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>


		
		<!-- Modal -->
		<div class="modal fade" id="modalSensBasicModify" tabindex="-1" role="dialog" aria-labelledby="modalSensBasicModifyLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalAgentGroupModifyLabel">기본 감성지표(Basic Indicator) 수정</h4>
					</div>
					<form role="form" id="form_sensbasic_update" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<div class="modal-body">
							<div class="form-group" style="margin-bottom: 30px;">
								<span class="pull-right"><span class="text-danger"><strong>*</strong></span>는 필수입력정보입니다.</span></td>
							</div>
							<div class="form-group" align="center">
							<table cellpadding="0" border="0" align="center" width="100%">
								<tr align="center">
									<td width="40%" align="center"><label for="desc">Indicator<span class="text-danger">*</span></label> </td>
									<td width="30%" align="center"><label for="desc">Min<span class="text-danger">*</span></label> </td>
									<td width="30%" align="center"><label for="desc">Max<span class="text-danger">*</span></label> </td>
								</tr>
								<tr align="center">
									<td align="center"  id="example1"> 
										<input type="text" class="form-control" id="name" name="name" maxlength="20" style="width:95%" readonly="readonly">
										<input type="hidden" class="form-control" id="basic_idx" name="basic_idx" maxlength="20" style="width:95%" readonly="readonly">
										<%--
										<span class="help-block">
											<i class="fa fa-exclamation-circle" aria-hidden="true"></i> 변경 불가 
										</span>
										--%>
									</td>
									<td align="center"> <input type="text" onKeyPress="return numkeyCheck(event)" style="width:95%" class="form-control" id="min" name="min" maxlength="2" style="width:100px"></td>
									<td align="center"> <input type="text" onKeyPress="return numkeyCheck(event)" style="width:95%" class="form-control" id="max" name="max" maxlength="2" style="width:100px"></td>
								</tr>
							</table>
							</div>
							<div class="form-group">
								<label for="desc">Type<span class="text-danger">*</span></label> 
								<input type="text" class="form-control" id="type" name="type" maxlength="20" readonly="readonly">
								<%--
								<span class="help-block">
									<i class="fa fa-exclamation-circle" aria-hidden="true"></i> 변경 불가 
								</span>
								--%>
								<%--
								<select class="form-control" id="type" name="type">
									<option value="0">Basic</option>
									<option value="1">Calculated</option>
								</select>
								--%>
							</div>
							<div class="form-group">
								<label for="desc">Description</label> 
								<input type="text" class="form-control" id="description" name="description" placeholder="설명을 입력하세요" maxlength="64" >
							</div>
							
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left" data-dismiss="modal">취소</button>
							<button type="button" class="jsUpdate btn btn-primary">수정</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>

<script>
$(document).ready(function(){
	
	//검색
	$(document).on("click", ".jsSearch", function(e){
    	e.preventDefault();
    	document.getElementById("searchId").value = $("#searchId").val();
        document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
   	
    	$("#form_sensBasic_search").submit();
    	
    });
	
    $(window).keydown(function(event){
        if(event.keyCode == 13) {
          event.preventDefault();
          return false;
        }
    });	
			
  //그룹 ID 중복확인
    $(document).on('change', '#name', function(e){
    	e.preventDefault();
    	checkAvailableGroupId();
    });
			
	$(document).on('click', '.jsCreate', function(e){
		e.preventDefault();
    	if ($.trim($("#name").val()).length == 0 || $("#checkedGroupId").val()=="false" ){
    		alert("Indicator를 입력해야 합니다.");
    		$("#name").focus();
    		return false;
    	}
    	if ($.trim($("#min").val()).trim().length < 1){
    		alert("Min을 입력해야 합니다.");
    		$("#min").focus();
    		return false;
    	}
    	if ($.trim($("#max").val()).trim().length < 1){
    		alert("Max를 입력해야 합니다.");
    		$("#max").focus();
    		return false;
    	} 
    	
    	if(parseInt($("#min").val()) > parseInt($("#max").val())) {
    		alert("Min값이 Max값 보다 클 수 없습니다.");
    		$("#min").focus();
    		return false;
    	}

    	var groupFormData = $("#form_sensbasic_create").serialize();
        e.preventDefault();
        $.ajax({
    		url: "/REST/sens/createSensBasic", 
    		data : groupFormData,
    		dataType : "JSON",
    		method : "POST",
    		success : function(result) {
	    		if( result ) {
    				alert("성공적으로 등록되었습니다.");
   					location.reload();
    			} else {
    				alert("등록 실패하였습니다.");
	    		}
    		}
    	});
    });
			
	$(document).on('click', '.jsUpdate', function(e){
    	e.preventDefault();
    	

    	if ($.trim($("#form_sensbasic_update").find("#type").val()).trim().length < 1){
    		alert("Type을 선택해야 합니다.");
    		$("#form_sensbasic_update").find("#type").focus();
    		return false;
    	}
    	
    	if ($.trim($("#form_sensbasic_update").find("#min").val()).trim().length < 1){
    		alert("Min을 입력해야 합니다.");
    		$("#form_sensbasic_update").find("#min").focus();
    		return false;
    	}
    	
    	if ($.trim($("#form_sensbasic_update").find("#max").val()).trim().length < 1){
    		alert("Max을 입력해야 합니다.");
    		$("#form_sensbasic_update").find("#max").focus();
    		return false;
    	}
    	
    	if(parseInt($("#form_sensbasic_update").find("#min").val()) > parseInt($("#form_sensbasic_update").find("#max").val())) {
    		alert("Min값이 Max값 보다 클 수 없습니다.");
    		$("#form_sensbasic_update").find("#min").focus();
    		return false;
    	}
    	
    	var groupFormData = $("#form_sensbasic_update").serialize();
    	$.ajax({
    		url:"/REST/sens/updateSensBasic",
    		data : groupFormData,
    		dataType : "JSON",
    		method : "POST",
    		success : function(result) {
	    		if( result ) {
   					location.reload();
    			} else {
    				alert("수정에 실패하였습니다.");
	    		}
    		}
    	});
    });
			
    $(document).on("click", ".jsShowModal", function(e){
    	e.preventDefault();
    	 var groupId = $(this).attr("data-groupid");
    	$.ajax({
    		url:"/REST/sens/selectSensBasic/" + groupId,
    		dataType : "JSON",
    		method : "GET",
    		success : function(result) {
    	    	if( result ) {
    	    	
    	    		var type = "";
    	    		if(result.type == '0') {
    	    			type = "Basic";
    	    		}else {
    	    			type = "Calculator";
    	    		}
    	    	
    	    		$("#modalSensBasicModify").modal("show");
    	    		$("#form_sensbasic_update").find("#basic_idx").val(result.basic_idx);
    	    		$("#form_sensbasic_update").find("#name").val(result.name);
    	    		$("#form_sensbasic_update").find("#type").val(type);
    	    		//$("#form_sensbasic_update").find("#type option[value='"+ result.type +"']").attr("selected", "selected");
    	    		$("#form_sensbasic_update").find("#min").val(result.min);
    	    		$("#form_sensbasic_update").find("#max").val(result.max);
    	    		$("#form_sensbasic_update").find("#description").val(result.description);
    	    	} else {
    	    		alert("해당 정보를 가져올 수 없습니다.");
    	    	}
    		}
    	}); 
    });
	
	$(document).on("click", ".jsDeleteSensBasic", function(e){
    	e.preventDefault();
    	var username = "${sessionScope.sessionUser.currentUser.userName }";
    	var userid = "${sessionScope.sessionUser.currentUser.userId}";
    	var groupId = $(this).attr("data-groupid") + "," + username + "," + userid;
    	if(confirm("삭제 하시겠습니까?")) {
	    	$.ajax({
	    		url:"/REST/sens/deleteSensBasic/" + groupId,
	    		dataType : "JSON",
	    		method : "GET",
	    		success : function(result) {
	    	    	if( result) {
	    	    		// alert("정상적으로 삭제되어, 화면을 갱신합니다.");
	    	    		location.reload();
	    	    	} else {
	    	    		alert("삭제 실패하였습니다.");
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
        $("#form_sensBasic_search input[name='page']").val(page);
        document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
        var pathname = window.location.pathname;
        window.location.href = pathname + "?" + $("#form_sensBasic_search").serialize();
    });

});


		
function checkAvailableGroupId() {
	var newGroupId = $("#name").val();
	$.ajax({
		url : "/REST/sens/isDuplicatedGroupIdd",
		data : { "groupId" : newGroupId },
		dataType : "JSON",
		method : "GET",
		success : function(result) {
	    	if( result ) {
	    		$("#checkGroupIdMsg").html("<i class='fa fa-check-circle' aria-hidden='true'></i> 사용 가능");
	    		$("#checkedGroupId").val("true");
	    	} else {
	    		$("#checkGroupIdMsg").html("<i class='fa fa-ban' aria-hidden='true'></i> 사용 불가");
	    		$("#checkedGroupId").val("false");
	    	}
		}
	});
}
</script>
</body>
</html>