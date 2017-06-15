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
	function aa() {
		$('select').find('option:first').prop("selected", true);
		$("input[type=checkbox]").prop("checked",false);
	}
	</script>
	
	<script>
		$(document).ready(function(){
			if("${searchBoardIndex}" != null && "${searchBoardIndex}" != '') $("select[name=searchBoardIndex1]").val("${searchBoardIndex}").attr("selected","selected");
		});
	</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h2><small>시스템 ></small> 그룹 관리</h2>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row" style="height: 800px;">
					<div class="col-xs-12">
						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">상담원 그룹 목록</h3>
							</div>
							<div class="box-body table-responsive no-padding">
								<table class="table table-hover">
									<tr>
										<th class="col-sm-1">그룹ID</th>
										<th class="col-sm-1">그룹명</th>
										<th class="col-sm-1">소속인원</th>
										<th class="col-sm-1">그룹명 수정/삭제</th>
									</tr>
									<c:forEach items="${groupList}" var="group">
									<tr>
										<td>${group.groupId }</td>
										<td>${group.groupName }</td>
										<td>${group.agentCount }</td>
										<td>
											<div class="btn-group">
												<button type="button" class="jsShowModal btn btn-default btn-xs" data-groupid="${group.groupId }">수정</button>
												<button type="button" class="jsDeleteGroup btn btn-default btn-xs" data-groupid="${group.groupId },${group.groupName }">삭제</button>
											</div>
										</td>
									</tr>
									</c:forEach>
									<c:if test="${empty groupList }">
										<tr class="empty">
											<td colspan="4">등록된 그룹이 없습니다.</td>
										</tr>
									</c:if>
									
								</table>
							</div>
							<div class="box-footer clearfix text-center">
								<button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#myModal">신규 그룹 등록</button>
							
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
						<form role="form" id="form_group_search"  action="" method="get">
							<input type="hidden" name="page" value="" />
							<input type="hidden" name="searchBoardIndex" id="searchBoardIndex" value="" />
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
							</form>
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
						<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="aa();">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">그룹 등록</h4>
					</div>
					<form role="form" id="form_group_create" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<input type="hidden" id="checkedGroupId" name="checkedGroupId" value="false">
						<div class="modal-body">
							<div class="form-group">
								<label for="groupId">그룹 ID <span class="text-danger">*</span></label><span class="pull-right"><span class="text-danger"><strong>*</strong></span>는 필수입력정보입니다.</span> 
								<input type="text" class="form-control" id="groupId" name="groupId" placeholder="그룹ID를 입력하세요" maxlength="20">
								<span id="checkGroupIdMsg" class="help-block">
									<i class="fa fa-exclamation-circle" aria-hidden="true"></i> 중복 검사 필요
								</span>
							</div>
							<div class="form-group">
								<label for="GroupName">그룹 이름 <span class="text-danger">*</span></label> 
								<input type="text" class="form-control" id="groupName" name="groupName" placeholder="그룹명을 입력하세요" maxlength="20">
							</div>
							<div class="form-group">
								<label>상담사 프로파일</label> 
								<select class="form-control" id="profile_name_agent" name="profile_name_agent">
									<option value="">선택</option>
								<c:forEach items="${ProfileList }" var="agentpro">
									<option value="${agentpro.profile_meta_idx }">${agentpro.profile_name }</option>
								</c:forEach>
								<c:if test="${ProfileList eq null }">
									<option value="noGroup">등록된 프로파일이 없습니다.</option>
								</c:if>
								</select>
							</div>
							
							<div class="form-group">
								<label>고객 프로파일</label> 
								<select class="form-control" id="profile_name_cus" name="profile_name_cus">
									<option value="">선택</option>
								<c:forEach items="${ProfileList }" var="agentpro">
									<option value="${agentpro.profile_meta_idx }">${agentpro.profile_name }</option>
								</c:forEach>
								<c:if test="${ProfileList eq null }">
									<option value="noGroup">등록된 프로파일이 없습니다.</option>
								</c:if>
								</select>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left" data-dismiss="modal" onclick="aa();">취소</button>
							<button type="button" class="jsCreate btn btn-primary">등록</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>


		<!-- Modal -->
		<div class="modal fade" id="modalAgentGroupModify" tabindex="-1" role="dialog" aria-labelledby="modalAgentGroupModifyLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="aa();">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalAgentGroupModifyLabel">그룹 정보 수정</h4>
					</div>
					<form role="form" id="form_group_update" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<div class="modal-body">
							<div class="form-group">
								<label for="groupId">그룹 ID</label> 
								<input type="text" class="form-control" id="groupId" name="groupId" value="" maxlength="20" readonly>
								<span class="help-block">
									<i class="fa fa-exclamation-circle" aria-hidden="true"></i> 변경 불가 
								</span>
							</div>
							<div class="form-group">
								<label for="groupName">그룹 이름</label> 
								<input type="text" class="form-control" id="groupName" name="groupName" value="" maxlength="20">
							</div>
							<div class="form-group">
								<label>상담사 프로파일</label> 
								<select class="form-control" id="profile_name_agent" name="profile_name_agent">
									<option value="">선택</option>
								<c:forEach items="${ProfileList }" var="agentpro">
									<option value="${agentpro.profile_meta_idx }">${agentpro.profile_name }</option>
								</c:forEach>
								<c:if test="${ProfileList eq null }">
									<option value="noGroup">등록된 프로파일이 없습니다.</option>
								</c:if>
								</select>
							</div>
							
							<div class="form-group">
								<label>고객 프로파일</label> 
								<select class="form-control" id="profile_name_cus" name="profile_name_cus">
									<option value="">선택</option>
								<c:forEach items="${ProfileList }" var="agentpro">
									<option value="${agentpro.profile_meta_idx }">${agentpro.profile_name }</option>
								</c:forEach>
								<c:if test="${ProfileList eq null }">
									<option value="noGroup">등록된 프로파일이 없습니다.</option>
								</c:if>
								</select>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left" data-dismiss="modal" onclick="aa();">취소</button>
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
    	document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
   	
    	$("#form_group_search").submit();
    	
    });
	
    $(window).keydown(function(event){
        if(event.keyCode == 13) {
          event.preventDefault();
          return false;
        }
    });	
			
	// 그룹 ID 중복확인
    $(document).on('change', '#groupId', function(e){
    	e.preventDefault();
    	checkAvailableGroupId();
    });
			
	$(document).on('click', '.jsCreate', function(e){
		e.preventDefault();
    	if ($.trim($("#groupId").val()).length < 1 || $("#checkedGroupId").val()=="false" ){
    		alert("그룹 ID를 입력해야 합니다.");
    		$("#groupId").focus();
    		return false;
    	}
    	if ($.trim($("#groupName").val()).trim().length < 1){
    		alert("그룹 이름을 입력해야 합니다.");
    		$("#groupName").focus();
    		return false;
    	} else if ($.trim($("#groupName").val()).length > 21) {
    		alert("그룹이름은 최대 20자까지 입력 가능합니다.");
    		$("#groupName").val($("#groupName").val().substring(0, 20));
    		$("#groupName").focus();
            return false;
        }

    	var groupFormData = $("#form_group_create").serialize();
        e.preventDefault();
        $.ajax({
    		url: "/REST/agentgroup/createAgentGroup",
    		data : groupFormData,
    		dataType : "JSON",
    		method : "POST",
    		success : function(result) {
	    		if( result ) {
    				alert("성공적으로 등록되었습니다.");
   					location.reload();
    			} else {
    				alert("새로운 그룹 등록에 실패하였습니다.");
	    		}
    		}
    	});
    });
			
	$(document).on('click', '.jsUpdate', function(e){
    	e.preventDefault();
    	if ($.trim($("#form_group_update").find("#groupId").val()).trim().length < 1){
    		alert("그룹 ID를 입력해야 합니다.");
    		$("#form_group_update").find("#groupId").focus();
    		return false;
    	}
    	
    	if ($.trim($("#form_group_update").find("#groupName").val()).trim().length < 1){
    		alert("그룹 이름을 입력해야 합니다.");
    		$("#form_group_update").find("#groupName").focus();
    		return false;
    	}
    	
    	var groupFormData = $("#form_group_update").serialize();
    	$.ajax({
    		url:"/REST/agentgroup/updateAgentGroup",
    		data : groupFormData,
    		dataType : "JSON",
    		method : "POST",
    		success : function(result) {
	    		if( result ) {
   					location.reload();
    			} else {
    				alert("그룹 정보 수정에 실패하였습니다.");
	    		}
    		}
    	});
    });
			
    $(document).on("click", ".jsShowModal", function(e){
    	e.preventDefault();
    	var groupId = $(this).attr("data-groupid");
    	$.ajax({
    		url:"/REST/agentgroup/selectAgentGroup/" + groupId,
    		dataType : "JSON",
    		method : "GET",
    		success : function(result) {
    	    	if( result ) {
    	    		$("#modalAgentGroupModify").modal("show");
    	    		$("#form_group_update").find("#groupId").val(result.groupId);
    	    		$("#form_group_update").find("#groupName").val(result.groupName);
    	    		$("#form_group_update").find("#profile_name_agent option[value='"+ result.agent_profile_id +"']").attr("selected", "selected");
    	    		$("#form_group_update").find("#profile_name_cus option[value='"+ result.customer_profile_id +"']").attr("selected", "selected");
    	    		$("#form_group_update").find("#profile_name_agent option[value='"+ result.agent_profile_id +"']").prop("selected", true);
    	    		$("#form_group_update").find("#profile_name_cus option[value='"+ result.customer_profile_id +"']").prop("selected", true);
    	    	} else {
    	    		alert("해당 그룹 정보를 가져올 수 없습니다.");
    	    	}
    		}
    	});
    });
	
	$(document).on("click", ".jsDeleteGroup", function(e){
    	e.preventDefault();
    	var username = "${sessionScope.sessionUser.currentUser.userName }";
    	var userid = "${sessionScope.sessionUser.currentUser.userId}";
    	var groupId = $(this).attr("data-groupid") + "," + username + "," + userid;
    	if(confirm("그룹 정보만 삭제하며, 그룹에 속해있던 상담원 정보는 삭제되지 않습니다. 계속 하시겠습니까?")) {
	    	$.ajax({
	    		url:"/REST/agentgroup/deleteAgentGroup/" + groupId,
	    		dataType : "JSON",
	    		method : "GET",
	    		success : function(result) {
	    	    	if( result) {
	    	    		// alert("정상적으로 삭제되어, 화면을 갱신합니다.");
	    	    		location.reload();
	    	    	} else {
	    	    		alert("해당 그룹을 삭제하려면,소속된 상담원이 없어야 합니다.");
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
        $("#form_group_search input[name='page']").val(page);
        document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
        var pathname = window.location.pathname;
        window.location.href = pathname + "?" + $("#form_group_search").serialize();
    });

});
		
function checkAvailableGroupId() {
	var newGroupId = $("#groupId").val();
	$.ajax({
		url : "/REST/agentgroup/isDuplicatedGroupIdd",
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