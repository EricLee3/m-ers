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
		$("input[type=checkbox]").prop("checked",false);
	}
	
	function checkAll(){
	      if( $("#all_check").is(':checked') ){
	        $("input[id=basic_idx]").prop("checked", true);
	      }else{
	        $("input[id=basic_idx]").prop("checked", false); 
	      }
	}
	
	function select_all(natsize,obj)
    {
        var count = natsize;
        var chk = document.getElementsByName(obj);
        if ( all_check.checked == true ){
            for (var i=0; i < count; i++) {
                //var b = "document.adminfrm.nationcode"+i;
                chk[i].checked = true;
            }
        }else{
            //alert("BBBBBBBBBBBBBBBBBBBBBB::::::["+natsize+"]");
            for (var i=0; i < count; i++) {
                //var b = "document.adminfrm.nationcode"+i;
                chk[i].checked = false;
            }
        }
    }
	
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
				<h2><small>시스템 ></small> 프로파일 기초 데이터 관리</h2>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row" style="height: 800px;">
					<div class="col-xs-12">
						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">프로파일 기초 데이터 목록</h3>
							</div>
							<div class="box-body table-responsive no-padding">
							<form role="form" id="form_group_search"  action="" method="get">
									<input type="hidden" name="page" value="" />
									<input type="hidden" name="searchBoardIndex" id="searchBoardIndex" value="" />
									<div class="col-md-2 hidden-print">
										<div class="form-group">
											<select class="form-control" id="searchId" name="searchId">
												<option value="">ALL</option>
												<c:forEach items="${svIndiList}" var="name">
													<option value="${name.name}">${name.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								
									<div class="col-md-2 hidden-print">
										<button type="button" class="jsSearch btn btn-info">조회</button>
									</div>
									</form>
							
							
							
							<!-- <table class="table table-hover">
								<tr>
									<th class="col-sm-1">Service Indicator
										<select class="form-control_mj" id="type" name="type">
										<option value="0">Basic</option>
										<option value="0">Calculated</option>
										</select>
											<div class="col-md-2 hidden-print">
										<button type="button" class="jsSearch btn btn-info">조회</button>
									</div>
									</th>

								</tr>
									
							</table> -->
								<table class="table table-hover">
									<thead>
									<tr>
										<th class="col-sm-1">프로파일</th>
										<th class="col-sm-1">Description</th>
										<th class="col-sm-1">상세/수정/삭제</th>
									</tr>
									</thead>
									<tbody>
									<c:forEach items="${prometaList}" var="pro">
									<tr>
										<td>${pro.name}</td>
										<td>${pro.description}</td>
										<td>
											<div class="btn-group">
												<button type="button" class="jsShowDetail btn btn-default btn-xs" data-groupid="${pro.name}">상세</button>
												<button type="button" class="jsShowModal btn btn-default btn-xs" data-groupid="${pro.name}">수정</button>
												<button type="button" class="jsDeleteProMeta btn btn-default btn-xs" data-groupid="${pro.profile_meta_idx},${pro.name}">삭제</button>
											</div>
										</td>
									</tr>
									</c:forEach>
									<c:if test="${empty prometaList }">
										<tr class="empty">
											<td colspan="3">현재 등록된 데이터가 없습니다.</td>
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
										itemCount="${ProMetaCount }" 
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
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">프로파일 기초 데이터 등록</h4>
					</div>
					<form role="form" id="form_pro_create" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<input type="hidden" id="checkedGroupId" name="checkedGroupId" value="false">
						<div class="modal-body">
							<div class="form-group">
								<label for="name">프로파일 명<span class="text-danger">*</span></label><span class="pull-right"><span class="text-danger"><strong>*</strong></span>는 필수입력정보입니다.</span> 
								<input type="text" class="form-control" id="name" name="name" placeholder="프로파일명을 입력하세요" maxlength="64">
								<span id="checkGroupIdMsg" class="help-block">
									<i class="fa fa-exclamation-circle" aria-hidden="true"></i> 중복 검사 필요
								</span>
							</div>
							<div class="form-group">
								<label for="name">Description</label>
								<input type="text" class="form-control" id="description" name="description" placeholder="설명을 입력하세요" maxlength="64">
							</div>
							<div class="form-group" style="height: 360px">
							<table cellpadding="0" border="0" align="left" width="100%">
								<tr>
									<td width="10%" align="center"><label for="desc">선택<span class="text-danger">*</span></label> </td>
									<td width="90%" align="center"><label for="desc">Service Indicator<span class="text-danger">*</span></label> </td>
								</tr>
								<c:forEach items="${IndiList}" var="name">
								<tr>
									<td align="center"><input type="checkbox" id="service_idx" name="service_idx" value="${name.svc_meta_idx}"></td>
									<td align="center">${name.name}(${name.min} ~ ${name.max})</td>
								</tr>
								</c:forEach>
							</table>
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
		<div class="modal fade" id="modalProMetaModify" tabindex="-1" role="dialog" aria-labelledby="modalAgentGroupModifyLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="aa();">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalAgentGroupModifyLabel">프로파일 기초 데이터 수정</h4>
					</div>
					<form role="form" id="form_pro_update" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<div class="modal-body">
							<div class="form-group">
								<label for="name">프로파일명<span class="text-danger">*</span></label><span class="pull-right"><span class="text-danger"><strong>*</strong></span>는 필수입력정보입니다.</span> 
								<input type="text" class="form-control" id="name" name="name" maxlength="20" readonly="readonly">
							</div>
							<input type="hidden" name="profile_meta_idx" id="profile_meta_idx" value="">
							<div class="form-group">
								<label for="name">Description</label>
								<input type="text" class="form-control" id="description" name="description" placeholder="설명을 입력하세요" maxlength="64">
							</div>
							<div class="form-group" style="height: 360px">
							<table cellpadding="0" border="0" align="left" width="100%">
								<tr>
									<td width="10%" align="center"><label for="desc">선택<span class="text-danger">*</span></label> </td>
									<td width="90%" align="center"><label for="desc">Service Indicator<span class="text-danger">*</span></label> </td>
								</tr>
								<c:forEach items="${IndiList}" var="name"  varStatus="status">
								<tr>
									<td align="center">
									<input type="checkbox" id="service_idx${name.svc_meta_idx}" name="service_idx" value="${name.svc_meta_idx}">
									</td>
									<td align="center">${name.name}(${name.min} ~ ${name.max})</td>
								</tr>
								</c:forEach>
							</table>
							</div>
							<!-- 
							<div class="form-group">
								<label for="groupName">그룹 이름</label> 
								<input type="text" class="form-control" id="groupName" name="groupName" value="" maxlength="20">
							</div>
							 -->
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
		
		<!-- Detail -->
		<div class="modal fade" id="modalProMetaDetail" tabindex="-1" role="dialog" aria-labelledby="modalAgentGroupModifyLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="aa();">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalAgentGroupModifyLabel">프로파일 기초 데이터 상세정보</h4>
					</div>
					<form role="form" id="form_pro_detail" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<div class="modal-body">
						<div class="form-group">
								<label for="name">프로파일명</label> 
								<input type="text" class="form-control" id="name" name="name" maxlength="20" readonly="readonly">
							</div>
							<input type="hidden" name="profile_meta_idx" id="profile_meta_idx" value="">
							<div class="form-group">
								<label for="name">Description</label>
								<input type="text" class="form-control" id="description" name="description" maxlength="64" readonly="readonly">
							</div>
							<div class="form-group" style="height: 360px">
							<table cellpadding="0" border="0" align="left" width="100%">
								<tr>
									<td width="10%" align="center"><label for="desc">No</label> </td>
									<td width="90%" align="center"><label for="desc">Service Indicator</label> </td>
								</tr>
							<tr align="center">
								<td id="s_name_detail_num" width="40%" align="center">
								<td id="s_name_detail" width="40%" align="center" colspan="2"></td>
							</tr>
							</table>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-right" data-dismiss="modal" onclick="aa();">닫기</button>
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
    	document.getElementById("searchId").value = $("#searchId").val();
   	
    	$("#form_group_search").submit();
    	
    });
	
    $(window).keydown(function(event){
        if(event.keyCode == 13) {
          event.preventDefault();
          return false;
        }
    });	
			
	// 그룹 ID 중복확인
    $(document).on('change', '#name', function(e){
    	e.preventDefault();
    	checkAvailableGroupId();
    });
			
	$(document).on('click', '.jsCreate', function(e){
		e.preventDefault();
    	if ($.trim($("#name").val()).length < 1 || $("#checkedGroupId").val()=="false" ){
    		alert("프로파일명을 입력해야 합니다.");
    		$("#name").focus();
    		return false;
    	}
    	
    	if($("input:checkbox[id='service_idx']").is(":checked") == false) {
            alert("Service Indicator를 선택해 주세요.");
            return false;
        }else {
        	$('input:checkbox[name="service_idx"]').each(function() {
		      if(this.checked){
		      }

			}); 
        }
    	
    	var groupFormData = $("#form_pro_create").serialize();
        e.preventDefault();
        $.ajax({
    		url: "/REST/sens/createProMeta",
    		data : groupFormData,
    		dataType : "JSON",
    		method : "POST",
    		success : function(result) {
	    		if( result ) {
    				alert("성공적으로 등록되었습니다.");
   					location.reload();
    			} else {
    				alert("등록에 실패하였습니다.");
	    		}
    		}
    	});
    });
			
	$(document).on('click', '.jsUpdate', function(e){
    	e.preventDefault();
    	
    	if ($.trim($("#form_pro_update").find("#name").val()).trim().length < 1){
    		alert("프로파일명을 입력해야 합니다.");
    		$("#form_pro_update").find("#name").focus();
    		return false;
    	}
   
    	if($("input:checkbox[name='service_idx']").is(":checked") == false) {
            alert("Service Indicator를 선택해 주세요.");
            return false;
        }else {
        	$('input:checkbox[name="service_idx"]').each(function() {
		      if(this.checked){
		    	 
		      }

			}); 
        }

    	/* 
    	$('input:checkbox[name="service_idx"]').each(function() { 
    	        alert($(this).val());
    	   }); */


	
    	
    	var groupFormData = $("#form_pro_update").serialize();
    	   $.ajax({
    		url:"/REST/sens/updateProMeta",
    		data : groupFormData,
    		dataType : "JSON",
    		method : "POST",
    		success : function(result) {
    			if(result == 888) {
    				alert("[프로파일 설정] 메뉴에서 사용 중 이므로 수정이 불가합니다.");
    				return false;
    			}else {
	    		if( result ) {
   					location.reload();
    			} else {
    				alert("수정에 실패하였습니다.");
	    		}
    			}
    		}
    	});   
    });
	
	 $(document).on("click", ".jsShowModal", function(e){
	    	//$("input:checkbox[name='basic_idx']").removeAttr("checked");
	    	e.preventDefault();
	    	
	    	var groupId = $(this).attr("data-groupid");
	    	$.ajax({
	    		url:"/REST/sens/selectProMeta/" + groupId,
	    		dataType : "JSON",
	    		method : "GET",
	    		success : function(result) {
	    	    	if( result ) {
	    	    		
	    	    		$("#modalProMetaModify").modal("show");
	    	    		
	
    	    		
    	    		var idx = result.service_idx;
    	    		idx = idx.split(",");
    	    		
    	    		
    	    		$("#form_pro_update").find("#name").val(result.name);
    	    		$("#form_pro_update").find("#profile_meta_idx").val(result.profile_meta_idx);
    	    		$("#form_pro_update").find("#description").val(result.description);
    	    		for(var i = 0; i < idx.length; i++) {
    	    	    	//$("input:checkbox[id='service_idx"+idx[i]+"']").attr("checked",true);
    	    	    	$("#form_pro_update").find(':input:checkbox[id=service_idx'+idx[i]+']').attr("checked", true);
    	    	    	$("#form_pro_update").find(':input:checkbox[id=service_idx'+idx[i]+']').prop("checked",true);
    	    	    	//$("#form_pro_update").find("#service_idx").val(result.service_idx);

    	    		}
    	    		
    	    		
    	    		
    	    	} else {
    	    		alert("정보를 가져올 수 없습니다.");
    	    	}
    		}
    	}); 
    });
	 
	 
	 $(document).on("click", ".jsShowDetail", function(e){
	    	e.preventDefault();
	    	
	    	var groupId = $(this).attr("data-groupid");
	    	$.ajax({
	    		url:"/REST/sens/selectProMeta2/" + groupId,
	    		dataType : "JSON",
	    		method : "GET",
	    		success : function(result) {
	    	    	if( result ) {
	    	    		
	    	    		$("#modalProMetaDetail").modal("show");
	    	    		
	    	    		var idx = result.service_name;
	    	    		idx = idx.split(",");
	    	    		
	    	    		$("#form_pro_detail").find("#name").val(result.name);
	    	    		$("#form_pro_detail").find("#description").val(result.description);
	    	    		document.getElementById("s_name_detail_num").innerHTML="";
	    	    		document.getElementById("s_name_detail").innerHTML="";
	    	    		for(var i = 0; i < idx.length; i++) {
	    	    			document.getElementById("s_name_detail_num").innerHTML += [i+1]+"<br>";
	     	    			document.getElementById("s_name_detail").innerHTML += idx[i]+"<br>";

	    		}
	    
	    		
	    		
	    	} else {
	    		alert("정보를 가져올 수 없습니다.");
	    	}
		}
	}); 
});
	 
	 
	 
	 /* 
	 $(document).on("click", ".jsShowDetail", function(e){
	    	e.preventDefault();
	    	
	    	var groupId = $(this).attr("data-groupid");
	    	$.ajax({
	    		url:"/REST/sens/selectProMeta2/" + groupId,
	    		dataType : "JSON",
	    		method : "GET",
	    		success : function(result) {
	    	    	if( result ) {
	    	    		
	    	    		$("#modalProMetaDetail").modal("show");
	    	    		
	
 	    
 	    		var idx = result.service_name;
	    		idx = idx.split(",");
	    		
	    		
 	    		var rname = result.name;
 	    		var desc = result.description;
 	    		document.getElementById("s_name_detail").innerHTML="";
 	    		document.getElementById("s_name_detail_num").innerHTML="";

 	    		
 	    		document.getElementById("description_detail").innerHTML = desc;
 	    		document.getElementById("name_detail").innerHTML = rname;
 	    		
 	    		for(var i=0; i < idx.length; i++) {
 	    			document.getElementById("s_name_detail_num").innerHTML += [i+1]+"<br>";
 	    			document.getElementById("s_name_detail").innerHTML += idx[i]+"<br>";
 	    		}
 	    
 	    		
 	    		
 	    	} else {
 	    		alert("정보를 가져올 수 없습니다.");
 	    	}
 		}
 	}); 
 }); */
	
	$(document).on("click", ".jsDeleteProMeta", function(e){
    	e.preventDefault();
    	var username = "${sessionScope.sessionUser.currentUser.userName }";
    	var userid = "${sessionScope.sessionUser.currentUser.userId}";
    	//var groupId = escape(encodeURIComponent($(this).attr("data-groupid")));
    	var groupId = $(this).attr("data-groupid") + "," + username + "," + userid;
    	if(confirm("삭제 하시겠습니까?")) {
	    	$.ajax({
	    		url:"/REST/sens/deleteProMeta/" + groupId,
	    		dataType : "JSON",
	    		method : "GET",
	    		success : function(result) {
	    			if(result == 999) {
	    				alert("[프로파일 설정] 메뉴 에서 사용중입니다.\n삭제하시려면 [프로파일 설정] 메뉴에서 먼저 삭제하세요.");
	    				return false;
	    			}else {
	    				if( result) {
		    	    		// alert("정상적으로 삭제되어, 화면을 갱신합니다.");
		    	    		location.reload();
		    	    	} else {
		    	    		
		    	    		alert("삭제 실패하였습니다.");
		    	    	}
	    			}
	    			
	    			if(result == 888) {
	    				alert("[프로파일 설정] 메뉴 에서 사용중입니다.\n삭제하시려면 [프로파일 설정] 메뉴에서 먼저 삭제하세요.");
	    				return false;
	    			}else {
	    				if( result) {
		    	    		// alert("정상적으로 삭제되어, 화면을 갱신합니다.");
		    	    		location.reload();
		    	    	} else {
		    	    		
		    	    		alert("삭제 실패하였습니다.");
		    	    	}
	    				
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
	var newGroupId = $("#name").val();
	$.ajax({
		url : "/REST/sens/isDuplicatedProName",
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