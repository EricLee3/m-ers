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
				<h2><small>시스템 ></small> 서비스 감성 지표(Service Indicator) 기초 정보 관리</h2>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row" style="height: 800px;">
					<div class="col-xs-12">
						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">서비스 감성 지표(Service Indicator) 기초 정보  목록</h3>
							</div>
							<div class="box-body table-responsive no-padding">
							<form role="form" id="form_meta_search"  action="" method="get">
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
									<%--
									<button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#myModal" style="margin-right: 10px;">등록</button>
									--%>
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
											<th class="col-sm-1">Service Indicator</th>
											<th class="col-sm-1">한글명</th>
											<th class="col-sm-1">Min Level</th>
											<th class="col-sm-1">Max Level</th>
											<th class="col-sm-1">설명</th>
											<th class="col-sm-1">상세/수정/삭제</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${sensmetaList}" var="meta">
									<tr>
										<td>${meta.name}</td>
										<td>${meta.kr_name}</td>
										<td>${meta.min}</td>
										<td>${meta.max}</td>
										<td>${meta.description}</td>
										<td>
											<div class="btn-group">
												<button type="button" class="jsShowDetail btn btn-default btn-xs" data-groupid="${meta.svc_meta_idx }">상세</button>
												<button type="button" class="jsShowModal btn btn-default btn-xs" data-groupid="${meta.svc_meta_idx }">수정</button>
												<button type="button" class="jsDeleteSensMeta btn btn-default btn-xs" data-groupid="${meta.svc_meta_idx },${meta.name}">삭제</button>
											</div>
										</td>
									</tr>
									</c:forEach>
									<c:if test="${empty sensmetaList }">
											<tr class="empty">
												<td colspan="5">현재 등록된 데이터가 없습니다.</td>
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
										itemCount="${SensMetaCount }" 
									/>
								</ul>
								<!-- <button type="button" class="btn btn-default pull-right hidden-print" onclick="print()"><i class="fa fa-print"></i><small> 인쇄</small></button> -->
								<!-- <button type="button" class="btn btn-info pull-right margin-r-5 hidden-print"><i class="fa fa-file-excel-o"></i></button> -->
						</div>
						<%--
						<form role="form" id="form_meta_search"  action="" method="get">
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
						<h4 class="modal-title" id="myModalLabel">서비스 감성 지표(Service Indicator) 기초 정보  등록</h4> 
					</div>
					<form role="form" id="form_meta_create" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<input type="hidden" id="checkedGroupId" name="checkedGroupId" value="false">
						<div class="modal-body">
							<table cellpadding="0" border="0" align="center" width="100%">
								<tr align="center">
									<td width="40%" align="center"><label for="desc">Service Indicator<span class="text-danger">*</span></label> </td>
									<td width="30%" align="center"><label for="desc">Min Level<span class="text-danger">*</span></label> </td>
									<td width="30%" align="center"><label for="desc">Max Level<span class="text-danger">*</span></label> </td>
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
										<input type="text" onKeyPress="return numkeyCheck(event)" style="width:95%" class="form-control" id="min" name="min" maxlength="2" style="width:100px" value="1" readonly="readonly">
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
							<div class="form-group">
								<label for="name">Description</label>
								<input type="text" class="form-control" id="description" name="description" placeholder="Description을 입력하세요" maxlength="64">
							</div>
							<div class="form-group">
								<label for="name">한글명</label>
								<input type="text" class="form-control" id="kr_name" name="kr_name" placeholder="한글명을 입력하세요" maxlength="64">
							</div>
							<div class="form-group" style="height: 400px">
							<table cellpadding="0" border="0" align="left" width="100%">
								<tr>
									<td width="10%" align="center"><label for="desc">선택<span class="text-danger">*</span></label> </td>
									<td width="*%" align="center"><label for="desc">Basic Indicator<span class="text-danger">*</span></label> </td>
									<td width="10%" align="center"><label for="desc">Min<span class="text-danger">*</span></label> </td>
									<td width="10%" align="center"><label for="desc">Max<span class="text-danger">*</span></label> </td>
								</tr>
								<%--
								 <input type="checkbox" id="all_check" value="1" onClick="checkAll();"/>all<br>
								--%>
								<c:forEach items="${IndiList}" var="name">
								<tr>
									<td align="center"><input type="checkbox" id="basic_idx" name="basic_idx" value="${name.basic_idx}"></td>
									<td align="center">${name.name}</td>
									<td align="center"><input type="text" class="form-control_mj" id="b_min" name="b_min" maxlength="2" onKeyPress="return numkeyCheck(event)"></td>
									<td align="center"><input type="text" class="form-control_mj" id="b_max" name="b_max" maxlength="2" onKeyPress="return numkeyCheck(event)"></td>
								</tr>
								</c:forEach>
							</table>
							</div>
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
		<div class="modal fade" id="modalSensMetaModify" tabindex="-1" role="dialog" aria-labelledby="modalAgentGroupModifyLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="aa();">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalAgentGroupModifyLabel">서비스 감성 지표(Service Indicator) 기초 정보  수정</h4>
					</div>
					<form role="form" id="form_meta_update" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<div class="modal-body">
							<table cellpadding="0" border="0" align="center" width="100%">
								<tr align="center">
									<td width="40%" align="center"><label for="desc">Service Indicator<span class="text-danger">*</span></label> </td>
									<td width="30%" align="center"><label for="desc">Min Level<span class="text-danger">*</span></label> </td>
									<td width="30%" align="center"><label for="desc">Max Level<span class="text-danger">*</span></label> </td>
								</tr>
								<tr align="center">
									<td align="center" id="example1"> 
									<input type="text" class="form-control" id="name" name="name" maxlength="20" style="width:95%" readonly="readonly">
									<span id="checkGroupIdMsg" class="help-block">
										&nbsp;
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
							<div class="form-group">
								<label for="name">Description</label>
								<input type="text" class="form-control" id="description" name="description" placeholder="Description을 입력하세요" maxlength="64">
							</div>
							<div class="form-group">
								<label for="name">한글명</label>
								<input type="text" class="form-control" id="kr_name" name="kr_name" placeholder="한글명을 입력하세요" maxlength="64">
							</div>
							<input type="hidden" name="svc_meta_idx" id="svc_meta_idx" value="">
							<div class="form-group" style="height: 400px">
							<table cellpadding="0" border="0" align="left" width="100%">
								<tr>
									<td width="10%" align="center"><label for="desc">선택<span class="text-danger">*</span></label> </td>
									<td width="*%" align="center"><label for="desc">Basic Indicator<span class="text-danger">*</span></label> </td>
									<td width="10%" align="center"><label for="desc">Min<span class="text-danger">*</span></label> </td>
									<td width="10%" align="center"><label for="desc">Max<span class="text-danger">*</span></label> </td>
								</tr>
								<%--
								 <input type="checkbox" id="all_check" value="1" onClick="checkAll();"/>all<br>
								--%>
								<c:forEach items="${IndiList}" var="name" varStatus="status">
								<tr>
									<td align="center">
									<input type="checkbox" id="basic_idx${name.basic_idx}" name="basic_idx" value="${name.basic_idx}">
									</td>
									<td align="center">${name.name}</td>
									<td align="center"><input type="text" class="form-control_mj" id="b_min${name.basic_idx}" name="b_min" maxlength="2" onKeyPress="return numkeyCheck(event)"></td>
									<td align="center"><input type="text" class="form-control_mj" id="b_max${name.basic_idx}" name="b_max" maxlength="2" onKeyPress="return numkeyCheck(event)"></td>
								</tr>
								</c:forEach>
							</table>
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
		
		<!-- Detail -->
		<div class="modal fade" id="modalSensMetaDetail" tabindex="-1" role="dialog" aria-labelledby="modalAgentGroupDetailLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="aa();">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalAgentGroupDetailLabel">서비스 감성 지표(Service Indicator) 기초  상세정보</h4>
					</div>
					<form role="form" id="form_meta_detail" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<div class="modal-body">
							<table cellpadding="0" border="0" align="center" width="100%">
								<tr align="center">
									<td width="40%" align="center"><label for="desc">Service Indicator</label> </td>
									<td width="30%" align="center"><label for="desc">Min Level</label> </td>
									<td width="30%" align="center"><label for="desc">Max Level</label> </td>
								</tr>
								<tr align="center">
									<td align="center" id="example1"> 
									<input type="text" class="form-control" id="name" name="name" maxlength="20" style="width:95%" readonly="readonly">
									<span id="checkGroupIdMsg" class="help-block">
										&nbsp;
										</span>
									<%--
										<select name="indicator" class="form-control" style="width:95%">
											<option value="">선택</option>
										</select>
									--%>
									</td>
									<td align="center"> 
										<input type="text" onKeyPress="return numkeyCheck(event)" style="width:95%" class="form-control" id="min" name="min" maxlength="2" style="width:100px" readonly="readonly">
										<span id="checkGroupIdMsg" class="help-block">
										&nbsp;
										</span>
									</td>
									<td align="center">
										<input type="text" onKeyPress="return numkeyCheck(event)" style="width:95%" class="form-control" id="max" name="max" maxlength="2" style="width:100px" readonly="readonly">
										<span id="checkGroupIdMsg" class="help-block">
										&nbsp;
										</span>
									</td>
								</tr>
							</table>
							<div class="form-group">
								<label for="name">Description</label>
								<input type="text" class="form-control" id="description" name="description" maxlength="64" readonly="readonly">
							</div>
							<div class="form-group">
								<label for="name">한글명</label>
								<input type="text" class="form-control" id="kr_name" name="kr_name" maxlength="64" readonly="readonly">
							</div>
							<input type="hidden" name="svc_meta_idx" id="svc_meta_idx" value="">
							<div class="form-group" style="height: 350px">
							<table cellpadding="0" border="0" align="left" width="100%">
								<tr>
									<td width="10%" align="center"><label for="desc">No</label> </td>
									<td width="*%" align="center"><label for="desc">Basic Indicator</label> </td>
									<td width="10%" align="center"><label for="desc">Min</label> </td>
									<td width="10%" align="center"><label for="desc">Max</label> </td>
								</tr>
								<%--
								 <input type="checkbox" id="all_check" value="1" onClick="checkAll();"/>all<br>
								--%>
								<tr align="center">
									<td id="b_name_detail_num" align="center"></td>
									<td id="b_name_detail" align="center"></td>
									<td id="min_detail" align="center"></td>
									<td id="max_detail" align="center"></td>
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
    	document.getElementById("searchId").value = $("#searchId").val();
    	document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
    	$("#form_meta_search").submit();
    	
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
		
		if ($.trim($("#name").val()).length < 1|| $("#checkedGroupId").val()=="false"){
    		alert("Service Indicator를 입력해야 합니다.");
    		$("#name").focus();
    		return false;
    	}
		
	 	if($("input:checkbox[id='basic_idx']").is(":checked") == false) {
            alert("Basic Indicator를 선택해 주세요.");
            return false;
        }else {
        	$('input:checkbox[name="basic_idx"]').each(function() {
		      if(this.checked){
		    	 
		      }

			}); 
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
	      		alert("Min값이 Max값보다 클 수 없습니다.");
	      		$("#min").focus();
	      		return false;
	      	}
	      	
	      	
	      	var bidx= $(":checkbox[name='basic_idx']:checked").length;
			for(i=0; i<bidx; i++){
				
				if($("input[name='basic_idx']")[i].checked == true){
					if($('input[name="b_min"]')[i].value == ''){
						alert("min 값을 입력해야 합니다.");
						$('input[name="b_min"]')[i].focus();
						return false;
					}
					
					if($('input[name="b_min"]')[i].value != ''){
						if($('input[name="b_max"]')[i].value == ''){
							alert("max 값을 입력해야 합니다.");
							$('input[name="b_max"]')[i].focus();
							return false;
						}
					}
					
					if(parseInt($('input[name="b_min"]')[i].value) > parseInt($('input[name="b_max"]')[i].value)) {
						alert("Min값("+$('input[name="b_min"]')[i].value+")이 \nMax값("+$('input[name="b_max"]')[i].value+") 보다 클 수 없습니다.");
						$('input[name="b_min"]')[i].focus();
						return false;
					}
					
				}
			}

    	var groupFormData = $("#form_meta_create").serialize();
        e.preventDefault();
        $.ajax({
    		url: "/REST/sens/createSensMeta",
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
    	
    	
    /* 	if($("#form_meta_update").find("input:checkbox[id='basic_idx']").is(":checked") == false) {
            alert("Indicator를 선택해 주세요.");
            return false;
        }else {
        	$("#form_meta_update").find('input:checkbox[name="basic_idx"]').each(function() {
		      if(this.checked){
		      }

			}); 
        } */
		
    	
        if($("input:checkbox[name='basic_idx']").is(":checked") == false) {
            alert("Basic Indicator를 선택해 주세요.");
            return false;
        }else {
        	$('input:checkbox[name="basic_idx"]').each(function() {
		      if(this.checked){
		    	 
		      }

			}); 
        }
    	
    	if ($.trim($("#form_meta_update").find("#min").val()).trim().length < 1){
    		alert("Min을 입력해야 합니다.");
    		$("#form_meta_update").find("#min").focus();
    		return false;
    	}
    	
    	if ($.trim($("#form_meta_update").find("#max").val()).trim().length < 1){
    		alert("Max을 입력해야 합니다.");
    		$("#form_meta_update").find("#max").focus();
    		return false;
    	}
    	
    	if(parseInt($("#form_meta_update").find("#min").val()) > parseInt($("#form_meta_update").find("#max").val())) {
    		alert("Min값이 Max값 보다 클 수 없습니다.");
    		$("#form_meta_update").find("#min").focus();
    		return false;
    	}
    	
    	
    	var bidx= $(":checkbox[name='basic_idx']:checked").length;
		for(i=0; i<bidx; i++){
			
			if($("input[name='basic_idx']")[i].checked == true){
				if($('input[name="b_min"]')[i].value == ''){
					alert("min 값을 입력해야 합니다.");
					$('input[name="b_min"]')[i].focus();
					return false;
				}
				
				if($('input[name="b_min"]')[i].value != ''){
					if($('input[name="b_max"]')[i].value == ''){
						alert("max 값을 입력해야 합니다.");
						$('input[name="b_max"]')[i].focus();
						return false;
					}
				}
				
				if(parseInt($('input[name="b_min"]')[i].value) > parseInt($('input[name="b_max"]')[i].value)) {
					alert("Min값("+$('input[name="b_min"]')[i].value+")이 \nMax값("+$('input[name="b_max"]')[i].value+") 보다 클 수 없습니다.");
					$('input[name="b_min"]')[i].focus();
					return false;
				}
				
			}
		}
    	
    	
    	var groupFormData = $("#form_meta_update").serialize();
    	$.ajax({
    		url:"/REST/sens/updateSensMeta",
    		data : groupFormData,
    		dataType : "JSON",
    		method : "POST",
    		success : function(result) {
    			if(result == '888') {
    				alert("[프로파일 기초정보 설정] 메뉴에서 사용 중여서, 수정이 불가합니다.");
    				return false;
    			}else {
		    		if( result ) {
	   					location.reload();
	    			} else {
	    				alert("정보 수정에 실패하였습니다.");
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
    		url:"/REST/sens/selectSensMeta/" + groupId,
    		dataType : "JSON",
    		method : "GET",
    		success : function(result) {
    	    	if( result ) {
    	    		
    	    		$("#modalSensMetaModify").modal("show");
    	    		var idx = result.basic_idx;
    	    		idx = idx.split(",");
    	    		
    	    		var b_min = result.b_min;
    	    		b_min = b_min.split(",");
    	    		
    	    		var b_max = result.b_max;
    	    		b_max = b_max.split(",");
    	    		
    	    		$("#form_meta_update").find("#svc_meta_idx").val(result.svc_meta_idx);
    	    		$("#form_meta_update").find("#name").val(result.name);
    	    		$("#form_meta_update").find("#min").val(result.min);
    	    		$("#form_meta_update").find("#max").val(result.max);
    	    		$("#form_meta_update").find("#description").val(result.description);
    	    		$("#form_meta_update").find("#kr_name").val(result.kr_name);
    	    		
    	    		for(var i = 0; i < idx.length; i++) {
        	    		$("#form_meta_update").find(':input:checkbox[id=basic_idx'+idx[i]+']').attr("checked", true);
    	    			$("#form_meta_update").find(':input:checkbox[id=basic_idx'+idx[i]+']').prop("checked",true);
    	    		}
    	    		
    	    		for(var i = 0; i < b_min.length; i++) {
    	    			$("#form_meta_update").find("#b_min"+idx[i]).val(b_min[i]);
    	    		}
    	    		
    	    		for(var i = 0; i < b_max.length; i++) {
    	    			$("#form_meta_update").find("#b_max"+idx[i]).val(b_max[i]);
    	    		}
    	    		
    	    	} else {
    	    		alert("정보를 가져올 수 없습니다.");
    	    	}
    		}
    	}); 
    });
    
    $(document).on("click", ".jsShowDetail", function(e){
    	//$("input:checkbox[name='basic_idx']").removeAttr("checked");
    	e.preventDefault();
    	
    	var groupId = $(this).attr("data-groupid");
    	$.ajax({
    		url:"/REST/sens/selectSensMeta2/" + groupId,
    		dataType : "JSON",
    		method : "GET",
    		success : function(result) {
    	    	if( result ) {
    	    		
    	    		$("#modalSensMetaDetail").modal("show");
    	    		
    	    		var idx = result.basic_idx;
    	    		idx = idx.split(",");
    	    		
    	    		var b_min = result.b_min;
    	    		b_min = b_min.split(",");
    	    		
    	    		var b_max = result.b_max;
    	    		b_max = b_max.split(",");
    	    		
    	    		var idx = result.b_name.split(",");
     	    		document.getElementById("b_name_detail").innerHTML="";
     	    		document.getElementById("b_name_detail_num").innerHTML="";
     	    		document.getElementById("min_detail").innerHTML="";
     	    		document.getElementById("max_detail").innerHTML="";
    	    		
    	    		$("#form_meta_detail").find("#name").val(result.name);
    	    		$("#form_meta_detail").find("#min").val(result.min);
    	    		$("#form_meta_detail").find("#max").val(result.max);
    	    		$("#form_meta_detail").find("#description").val(result.description);
    	    		$("#form_meta_detail").find("#kr_name").val(result.kr_name);

   	    			for(var i=0; i < idx.length; i++) {
   	    				document.getElementById("b_name_detail_num").innerHTML +=[i+1]+"<br>";
     	    			document.getElementById("b_name_detail").innerHTML += idx[i]+"<br>";
       	    		}
   	    			
   	    			for(var i = 0; i < b_min.length; i++) {
    	    			document.getElementById("min_detail").innerHTML += b_min[i]+"<br>";
    	    		}
    	    		
    	    		for(var i = 0; i < b_max.length; i++) {
    	    			document.getElementById("max_detail").innerHTML += b_max[i]+"<br>";
    	    		}
       	    		
    	    	} else {
    	    		alert("정보를 가져올 수 없습니다.");
    	    	}
    		}
    	});
    });
    
    /* $(document).on("click", ".jsShowDetail", function(e){
    	e.preventDefault();
    	
    	var groupId = $(this).attr("data-groupid");
    	$.ajax({
    		url:"/REST/sens/selectSensMeta2/" + groupId,
    		dataType : "JSON",
    		method : "GET",
    		success : function(result) {
    	    	if( result ) {
    	    		
    	    		$("#modalSensMetaDetail").modal("show");

    	    		var idx = result.basic_idx;
    	    		idx = idx.split(",");
    	    		
    	    		var idx = result.b_name.split(",");
     	    		document.getElementById("b_name_detail").innerHTML="";
     	    		document.getElementById("b_name_detail_num").innerHTML="";

     	    		
     	    		document.getElementById("name_detail").innerHTML = result.name;
     	    		document.getElementById("min_detail").innerHTML = result.min;
     	    		document.getElementById("max_detail").innerHTML = result.max;
     	    		document.getElementById("description_detail").innerHTML = result.description;
     	    		document.getElementById("kr_name_detail").innerHTML = result.kr_name;
     	    		
     	    		for(var i=0; i < idx.length; i++) {
     	    			document.getElementById("b_name_detail_num").innerHTML +=[i+1]+"<br>";
     	    			document.getElementById("b_name_detail").innerHTML += idx[i]+"<br>";
     	    		}
    	    		
    	    		
    	    		
    	    	} else {
    	    		alert("정보를 가져올 수 없습니다.");
    	    	}
    		}
    	}); 
    }); */
	
	$(document).on("click", ".jsDeleteSensMeta", function(e){
    	e.preventDefault();
    	var username = "${sessionScope.sessionUser.currentUser.userName }";
    	var userid = "${sessionScope.sessionUser.currentUser.userId}";
    	var groupId = $(this).attr("data-groupid") + "," + username + "," + userid;
    	if(confirm("삭제 하시겠습니까?")) {
	    	$.ajax({
	    		url:"/REST/sens/deleteSensMeta/" + groupId,
	    		dataType : "JSON",
	    		method : "GET",
	    		success : function(result) {
	    			if(result == '999') {
	    				alert("[감성지표 설정] 메뉴에서 사용 중여서, 삭제가 불가합니다.");
	    				return false;
	    			}else {
		    	    	if( result) {
		    	    		// alert("정상적으로 삭제되어, 화면을 갱신합니다.");
		    	    		location.reload();
		    	    	} else {
		    	    		alert("삭제 실패하였습니다.");
		    	    	}
	    			}
	    			if(result == '888') {
	    				alert("[프로파일 기초정보 설정] 메뉴에서 사용 중여서, 삭제가 불가합니다.");
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
        $("#form_meta_search input[name='page']").val(page);
        document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
        var pathname = window.location.pathname;
        window.location.href = pathname + "?" + $("#form_meta_search").serialize();
    });

});
		
function checkAvailableGroupId() {
	var newGroupId = $("#name").val();
	$.ajax({
		url : "/REST/sens/isDuplicatedName",
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