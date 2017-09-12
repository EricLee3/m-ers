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
<script>
$(document).ready(function(){
	if("${searchBoardIndex}" != null && "${searchBoardIndex}" != '') $("select[name=searchBoardIndex1]").val("${searchBoardIndex}").attr("selected","selected");
});
</script>
</head>

<body class="hold-transition skin-blue sidebar-mini">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h2><small>시스템 ></small> 사용자 목록</h2>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row"  style="height:800px">
					<div class="col-xs-9">
						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">전체 목록</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<table id="example1" class="table table-bordered table-striped">
									<thead>
										<tr>
											<th class="no-sort col-sm-1">번호</th>
											<th class="no-sort col-sm-1">ID</th>
											<th class="no-sort col-sm-1">등급</th>
											<th class="no-sort col-sm-1">부서</th>
											<th class="no-sort col-sm-1">이름</th>
											<th class="no-sort col-sm-1">직급</th>
											<th class="no-sort col-sm-1">전화번호</th>
											<th class="no-sort col-sm-1">수정/삭제</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${userList}" var="user">
											<tr>
												<td>${user.index}</td>
												<td>${user.userId}</td>
												<td>${user.role}</td>
												<td>${user.org}</td>
												<td>${user.userName}</td>
												<td>${user.position}</td>
												<td>${user.phone}</td>
												<td>
													<div class="btn-group">
														<button type="button" class="jsShowModal btn btn-default btn-xs" data-index="${user.index }">수정</button>
														<button type="button" class="jsDeleteUser btn btn-default btn-xs" data-index="${user.index },${user.userId},${user.userName}">삭제</button>
													</div>
												</td>
											</tr>
										</c:forEach>
										<c:if test="${empty userList }">
											<tr class="empty">
												<td colspan="8">현재 등록된 사용자가 없습니다.</td>
											</tr>
										</c:if>
									</tbody>
								</table>
							</div>
							<!-- /.box-body -->
							<div class="box-footer text-center">
								<form id="form_search" class="hide">
										<input type="hidden" name="page" value="${pageDTO.page }" />
										<input type="hidden" name="searchBoardIndex" id="searchBoardIndex" value="" />
								</form>
								<ul class="pagination pagination-sm no-margin">
									<asnetPage:Pagination 
										page="${pageDTO.page }" 
										itemPerPage="${pageDTO.itemPerPage }" 
										pagePerGroup="${pageDTO.pagePerGroup }" 
										itemCount="${userCount }" 
									/>
								</ul>
								<div class="pull-right">
									<button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#modalUserCreate">사용자 등록</button>
								</div>
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
					<!-- /.col -->
	
					<div class="col-lg-3 col-xs-6">
	
						<!-- TABLE: 최근 접속 기록 -->
						<div class="box box-default">
							<div class="box-header with-border">
								<h3 class="box-title">최근 로그인</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<div class="table-responsive">
									<table class="table no-margin">
										<thead>
											<tr>
												<th>ID</th>
												<th>등급</th>
												<th>로그인 시간</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${loginList}" var="loginUser">
												<tr>
													<td>${loginUser.userId }</td>
													<td>${loginUser.role}</td>
													<td><fmt:formatDate pattern="yyyy.MM.dd HH:mm:ss" value="${loginUser.visitDate}" /></td>
												</tr>
											</c:forEach>
											<c:if test="${empty loginList }">
												<tr>
													<td colspan="3">저장된 로그인 기록이 없습니다.</td>
												</tr>
											</c:if>
										</tbody>
									</table>
								</div>
								<!-- /.table-responsive -->
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
		<!-- Modal 사용자 등록 -->
		<div class="modal fade" id="modalUserCreate" tabindex="-1" role="dialog" aria-labelledby="modalUserCreateLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalUserCreateLabel">신규 사용자 등록</h4>
					</div>
					<form role="form" id="form_user_create" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<input type="hidden" id="checkedUserId" value="false">
						<div class="modal-body">
							<div class="form-group">
								<label for="userId">ID <span class="text-danger">*</span></label><span class="pull-right"><span class="text-danger"><strong>*</strong></span>는 필수입력정보입니다.</span> 
								<input type="text" class="form-control" id="userId" name="userId" placeholder="아이디" maxlength="20"> 
								<span id="checkUserIdMsg" class="help-block">
									<i class="fa fa-exclamation-circle" aria-hidden="true"></i> 중복 검사 필요
								</span>
							</div>
							<div class="form-group">
								<label for="passwd">Password <span class="text-danger">*</span></label> 
								<input class="form-control" id="passwd" name="passwd" type="password" value="" maxlength="32">
							</div>
							<div class="form-group">
								<label for="userName">이름 <span class="text-danger">*</span></label> 
								<input type="text" class="form-control" id="userName" name="userName" placeholder="이름" maxlength="20">
							</div>
							<div class="form-group">
								<label>등급</label> 
								<select class="form-control" id="role" name="role">
									<option value="MANAGER">Manager</option>
									<option value="ADMIN">Administrator</option>
									<!-- <option value="SUPERUSER">Superuser</option>  -->
								</select>
							</div>
							<div class="form-group">
								<label for="org">부서</label> 
								<input type="text" class="form-control" id="org" name="org" placeholder="부서" maxlength="20">
							</div>
							<div class="form-group">
								<label for="position">직위</label> 
								<input type="text" class="form-control" id="position" name="position" placeholder="직위" maxlength="20">
							</div>
							<div class="form-group">
								<label for="phone">전화번호</label> 
								<input type="text" class="form-control" id="phone" name="phone" placeholder="전화번호" maxlength="20">
							</div>
							<input type="hidden" class="form-control" id="status" name="status" placeholder="상태" value="1">
							<!--
							<div class="form-group">
							
								<label>상태</label> 
								<select class="form-control" id="status" name="status">
									<option value="0">비승인</option>
									<option value="1" selected>정상승인</option>
								</select>
								
							</div>-->
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left" data-dismiss="modal">취소</button>
							<button type="button" class="jsCreate btn btn-primary">등록</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- /. Modal 사용자 등록 -->


		<!-- Modal 사용자 정보 수정 -->
		<div class="modal fade" id="modalUserModify" tabindex="-1" role="dialog" aria-labelledby="modalUserModifyLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalUserModifyLabel">사용자 정보 변경</h4>
					</div>
					<form role="form" id="form_user_update" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<input type="hidden" name="index" id="index" value="">
						<div class="modal-body">
							<div class="form-group">
								<label for="userId">ID</label> 
								<input type="text" class="form-control" id="userId" name="userId" placeholder="아이디" value="엊?" readonly> 
								<span class="help-block">
									<i class="fa fa-exclamation-circle" aria-hidden="true"></i> 변경 불가 
								</span>
							</div>
							<div class="form-group">
								<label for="passwd">Password</label> 
								<input class="form-control" id="passwd" name="passwd" type="password" value="" maxlength="32"> 
								<span class="help-block">
									<i class="fa fa-exclamation-circle" aria-hidden="true"></i> 입력하지 않으면 기존의 값이 유지됨
								</span>
							</div>
							<div class="form-group">
								<label for="userName">이름</label> 
								<input type="text" class="form-control" id="userName" name="userName" placeholder="이름" maxlength="20">
							</div>
							<div class="form-group">
								<label>등급</label> 
								<select class="form-control" id="role" name="role">
									<option value="MANAGER">Manager</option>
									<option value="ADMIN">Administrator</option>
<!--  									<option value="SUPERUSER">Superuser</option>-->
								</select>
							</div>
							<div class="form-group">
								<label for="org">부서</label> 
								<input type="text" class="form-control" id="org" name="org" placeholder="부서" maxlength="20">
							</div>
							<div class="form-group">
								<label for="position">직위</label> 
								<input type="text" class="form-control" id="position" name="position" placeholder="직위" maxlength="20">
							</div>
							<div class="form-group">
								<label for="phone">전화번호</label> 
								<input type="text" class="form-control" id="phone" name="phone" placeholder="전화번호" maxlength="20">
							</div>
							<input type="hidden" class="form-control" id="status" name="status" placeholder="상태" value="1">
							<!-- 
							<div class="form-group">
								<label>상태</label> 
								<select class="form-control" id="status" name="status">
									<option value="0">비승인</option>
									<option value="1" selected>정상승인</option>
								</select>
							</div>
							 -->
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left" data-dismiss="modal">취소</button>
							<button type="button" class="jsUpdate btn btn-primary">변경사항 적용</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- /. Modal 사용자 정보 수정 -->

<script>
$(document).ready(function(){
	
	//검색
	$(document).on("click", ".jsSearch", function(e){
    	e.preventDefault();
    	document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
   	
    	$("#form_search").submit();
    	
    });
	
    $(window).keydown(function(event){
        if(event.keyCode == 13) {
          event.preventDefault();
          return false;
        }
    });
    
    // 회원 ID 중복확인
    $(document).on('change', '#userId', function(e){
    	e.preventDefault();
    	checkAvailableUserId();
    });
    
    
    $(document).on('click', '.jsCreate', function(e){
    	e.preventDefault();
    	
    	if ($.trim($("#userId").val()).length < 1 || $("#checkedUserId").val()=="false" ){
    		alert("사용 가능한 아이디를 입력해야 합니다.");
    		$("#userId").focus();
    		return false;
    	}else if ($.trim($("#userId").val()).length > 21) {
    		alert("ID는 최대 20자까지 입력 가능합니다.");
    		$("#userId").val($("#userId").val().substring(0, 20));
    		$("#userId").focus();
            return false;
        } 
    	
    	if ($.trim($("#passwd").val()).trim().length < 1){
    		alert("로그인 암호를 입력해야 합니다.");
    		$("#passwd").focus();
    		return false;
    	}else if ($.trim($("#passwd").val()).length > 33) {
    		alert("Password는 최대 32자까지 입력 가능합니다.");
    		$("#passwd").val($("#passwd").val().substring(0, 32));
    		$("#passwd").focus();
            return false;
        } 
    	
    	if ($.trim($("#userName").val()).trim().length < 1){
    		alert("사용자 이름을 입력해야 합니다.");
    		$("#userName").focus();
    		return false;
    	}else if ($.trim($("#userName").val()).length > 21) {
    		alert("이름은 최대 20자까지 입력 가능합니다.");
    		$("#userName").val($("#userName").val().substring(0, 20));
    		$("#userName").focus();
            return false;
        }
    	
    	if ($.trim($("#org").val()).length > 21) {
    		alert("부서는 최대 20자까지 입력 가능합니다.");
    		$("#org").val($("#org").val().substring(0, 20));
    		$("#org").focus();
            return false;
        }
    	
    	if ($.trim($("#position").val()).length > 21) {
    		alert("직위는 최대 20자까지 입력 가능합니다.");
    		$("#position").val($("#position").val().substring(0, 20));
    		$("#position").focus();
            return false;
        }
    	
    	if ($.trim($("#phone").val()).length > 21) {
    		alert("전화번호는 최대 20자까지 입력 가능합니다.");
    		$("#phone").val($("#phone").val().substring(0, 20));
    		$("#phone").focus();
            return false;
        }

    	var userFormData = $("#form_user_create").serialize();
    	$.ajax({
    		url:"/REST/account/createUser",
    		data : userFormData,
    		dataType : "JSON",
    		method : "POST",
    		success : function(result) {
	    		if( result ) {
	    			if( result.index > 0 ) { 
	    				alert("성공적으로 등록되었습니다.");
    					location.reload();
	    			} else {
	    				alert("새로운 사용자 등록에 실패하였습니다.");
	    			}
	    		}
    		}
    	});
    });
    
    $(document).on('click', '.jsUpdate', function(e){
    	e.preventDefault();
    	if ($.trim($("#form_user_update").find("#userName").val()).trim().length < 1){
    		alert("사용자 이름을 입력해야 합니다.");
    		$("#form_user_update").find("#userName").focus();
    		return false;
    	}
    	
    	var userFormData = $("#form_user_update").serialize();
    	$.ajax({
    		url:"/REST/account/updateUser",
    		data : userFormData,
    		dataType : "JSON",
    		method : "POST",
    		success : function(result) {
	    		if( result ) {
	    			if( result.index > 0 ) { 
	    				// alert("성공적으로 수정 되었습니다.");
    					location.reload();
	    			} else {
	    				alert("사용자 정보 수정에 실패하였습니다.");
	    			}
	    		}
    		}
    	});
    });
    
    $(document).on("click", ".jsShowModal", function(e){
    	e.preventDefault();
    	var userIndex = $(this).attr("data-index");
    	$.ajax({
    		url:"/REST/account/selectUser/" + userIndex,
    		dataType : "JSON",
    		method : "GET",
    		success : function(result) {
    	    	if( result ) {
    	    		$("#modalUserModify").modal("show");
    	    		$("#form_user_update").find("#index").val(result.index);
    	    		$("#form_user_update").find("#userId").val(result.userId);
    	    		$("#form_user_update").find("#userName").val(result.userName);
    	    		$("#form_user_update").find("#phone").val(result.phone);
    	    		$("#form_user_update").find("#org").val(result.org);
    	    		$("#form_user_update").find("#position").val(result.position);
    	    		$("#form_user_update").find("#role option[value='"+ result.role +"']").attr("selected", "selected");
    	    		$("#form_user_update").find("#status option[value='"+ result.status +"']").attr("selected", "selected");
    	    	} else {
    	    		alert("해당 사용자의 정보를 가져올 수 없습니다.");
    	    	}
    		}
    	});
    });
    
    $(document).on("click", ".jsDeleteUser", function(e){
    	e.preventDefault();
    	var username = "${sessionScope.sessionUser.currentUser.userName }";
    	var userid = "${sessionScope.sessionUser.currentUser.userId}";
    	var userIndex = $(this).attr("data-index") + "," + username + "," + userid;
    	if(confirm("한번 삭제하면 복구할 수 없습니다. 계속 하시겠습니까?")) {
	    	$.ajax({
	    		url:"/REST/account/deleteUser/" + userIndex,
	    		dataType : "JSON",
	    		method : "GET",
	    		success : function(result) {
	    	    	if( result) {
	    	    		// alert("정상적으로 삭제되어, 화면을 갱신합니다.");
	    	    		location.reload();
	    	    	} else {
	    	    		alert("해당 사용자의 정보를 가져올 수 없습니다.");
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
        $("#form_search input[name='page']").val(page);
        document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
        var pathname = window.location.pathname;
        window.location.href = pathname + "?" + $("#form_search").serialize();
    });
});

function checkAvailableUserId() {
	var newUserId = $("#userId").val();
	$.ajax({
		url:"/REST/account/isDuplicatedUserId",
		data : { 'userId' : newUserId },
		dataType : "JSON",
		method : "GET",
		success : function(result) {
	    	if( result ) {
	    		$("#checkUserIdMsg").html("<i class='fa fa-check-circle' aria-hidden='true'></i> 사용 가능");
	    		$("#checkedUserId").val("true");
	    	} else {
	    		$("#checkUserIdMsg").html("<i class='fa fa-ban' aria-hidden='true'></i> 사용 불가");
	    		$("#checkedUserId").val("false");
	    	}
		}
	});
}
</script>

</body>
</html>