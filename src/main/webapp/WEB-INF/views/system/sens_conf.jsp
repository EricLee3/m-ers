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
	
	function numkeyCheck(e) { var keyValue = event.keyCode; if( ((keyValue >= 48) && (keyValue <= 57)) ) return true; else return false; } 
	</script>
	<script>
		$(document).ready(function(){
			if("${searchBoardIndex}" != null && "${searchBoardIndex}" != '') $("select[name=searchBoardIndex1]").val("${searchBoardIndex}").attr("selected","selected");
			if("${searchId}" != null && "${searchId}" != '') $("select[name=searchId]").val("${searchId}").attr("selected","selected");
		});
	</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h2><small>시스템 ></small> 서비스 감성지표 (Service Indicator) 관리</h2>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row" style="height: 800px;">
					<div class="col-xs-12">
						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">서비스 감성지표 (Service Indicator) 목록</h3>
							</div>
							<div class="box-body table-responsive no-padding">
							<form role="form" id="form_conf_search"  action="" method="get">
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
								<table class="table table-hover">
									<thead>
									<tr>
										<th class="col-sm-1">Service Indicator</th><!-- 
										<th class="col-sm-1">KR NAME</th> -->
										<th class="col-sm-1">Emotion Level</th>
										<th class="col-sm-1">Description</th>
										<th class="col-sm-1">상세/수정/삭제</th>
									</tr>
									</thead>
									<tbody>
									<c:forEach items="${sensconfList}" var="conf">
									<tr>
										<td>${conf.name}</td><%-- 
										<td>${conf.kr_name}</td> --%>
										<td>${conf.emotion_level}</td>
										<td>${conf.description}</td>
										<td>
											<div class="btn-group"><%-- 
												<button type="button" class="jsShowModal btn btn-default btn-xs" data-groupid="${conf.name },${conf.emotion_level},${conf.kr_name}">수정</button> --%>
												<button type="button" class="jsShowDetail btn btn-default btn-xs" data-groupid="${conf.name },${conf.emotion_level}">상세</button>
												<button type="button" class="jsShowModal btn btn-default btn-xs" data-groupid="${conf.name },${conf.emotion_level}">수정</button>
												<button type="button" class="jsDeleteGroup btn btn-default btn-xs" data-groupid="${conf.name },${conf.emotion_level}">삭제</button>
											</div>
										</td>
									</tr>
									</c:forEach>
									<c:if test="${empty sensconfList }">
										<tr class="empty">
											<td colspan="4">현재 등록된 데이터가 없습니다.</td>
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
										itemCount="${SensConfCount }" 
									/>
								</ul>
								<!-- <button type="button" class="btn btn-default pull-right hidden-print" onclick="print()"><i class="fa fa-print"></i><small> 인쇄</small></button> -->
								<!-- <button type="button" class="btn btn-info pull-right margin-r-5 hidden-print"><i class="fa fa-file-excel-o"></i></button> -->
						</div>
						<form role="form" id="form_conf_search"  action="" method="get">
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
						<h4 class="modal-title" id="myModalLabel">서비스 감성지표(Service Indicator) 등록</h4>
					</div>
					<form role="form" id="form_conf_create" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<input type="hidden" id="checkedGroupId" name="checkedGroupId" value="false">
						<div class="modal-body">
							<div class="form-group">
								<label for="name">Service Indicator<span class="text-danger">*</span></label> 
								<select tabindex="2" class="form-control" id="name" name="name">
									<option value="">선택</option>
									<c:forEach items="${svIndiList}" var="name">
										<option value="${name.name }">${name.name }</option>
									</c:forEach>
								</select>
								<!-- 
								<span id="checkGroupIdMsg" class="help-block">
									<i class="fa fa-exclamation-circle" aria-hidden="true"></i> 중복 검사 필요
								</span>
								 -->
							</div>
							<!-- <div class="form-group">
								<label for="name">KR NAME</label> 
								<input type="text" class="form-control" id="kr_name" name="kr_name" maxlength="50" placeholder="KR NAME을 입력하세요" >
								
								<span id="checkGroupIdMsg" class="help-block">
									<i class="fa fa-exclamation-circle" aria-hidden="true"></i> 중복 검사 필요
								</span>
								
							</div> -->
							<div class="form-group">
								<label for="level">Level<span class="text-danger">*</span></label>
								<input type="text" class="form-control" id="emotion_level" name="emotion_level" maxlength="11" onKeyPress="return numkeyCheck(event)" readonly="readonly">
								<!-- 
								<span id="checkGroupIdMsg" class="help-block">
									<i class="fa fa-exclamation-circle" aria-hidden="true"></i> 중복 검사 필요
								</span>
								 -->
							</div>
							<div class="form-group">
								<label for="name">Description</label>
								<input type="text" class="form-control" id="description" name="description" placeholder="Description을 입력하세요" maxlength="64">
							</div>
							<div class="form-group create_body" style="height: 430px">
							<div class="create_row"></div>
							</div>
							<!-- 
							<div class="form-group">
								<label for="GroupName">Basic Emotion<span class="text-danger">*</span></label> 
								<input type="text" class="form-control" id="groupName" name="groupName" placeholder="그룹명을 입력하세요" maxlength="20">
							</div>
							 -->
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
		<div class="modal fade" id="modalSensConfModify" tabindex="-1" role="dialog" aria-labelledby="modalAgentGroupModifyLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="aa();">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalAgentGroupModifyLabel">서비스 감성지표(Service Indicator) 수정</h4>
					</div>
					<form role="form" id="form_conf_update" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<div class="modal-body modify_body">
                        	<div class="modify_row"></div>
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
		
		<!-- Modal -->
		<div class="modal fade" id="modalSensConfDetail" tabindex="-1" role="dialog" aria-labelledby="modalAgentGroupModifyLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="aa();">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalAgentGroupModifyLabel">서비스 감성지표(Service Indicator) 상세정보</h4>
					</div>
					<form role="form" id="form_conf_update" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<div class="modal-body detail_body">
                        	<div class="detail_row"></div>
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
	
	$("#form_conf_create").find("#name").change(function(){
	       var name = $("#form_conf_create").find('#name option:selected').val();
	         var formURL = "selectLevelList?name="+name;               
		       $.ajax(
		       {
		                  url : formURL,
		                  type: "POST",
		                  timeout: 3000,                  
		                  success:function(data, textStatus, jqXHR) 
		                  {                     
		                          for(var i=0;i < data.length; i ++){
		                        	  $("#form_conf_create").find("#emotion_level").val(data[i].emotion_level);
		                       }
		                    },
		                    error: function(jqXHR, textStatus, errorThrown) 
		                    {              
		                        alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);                     
		                    }
		     }); 
	    });
	
	$('#name').change(function(){
	       //var name = $('#name option:selected').val();
	       var name = escape(encodeURIComponent($('#name option:selected').val()));
	        var formURL = "selectSvList2?name="+name;               
		       $.ajax(
		       {
		                  url : formURL,
		                  type: "POST",
		                  timeout: 3000,                  
		                  success:function(data, textStatus, jqXHR) 
		                  {                     
		                       $(".create_row").remove();
		                          
		                          for(var i=0;i < data.length; i ++){
		                        	
		                             var content = "<div class=\"create_row\">";
		                                content += "<table cellpadding=\"0\" border=\"0\" align=\"left\" width=\"100%\">";
		                                content += "<tr>";
		                                content += "<td width=\"10%\" align=\"center\"><label for=\"desc\">선택<span class=\"text-danger\">*</span></label></td>";
		                                content += "<td width=\"70%\" align=\"center\"><label for=\"desc\">Basic Indicator<span class=\"text-danger\">*</span></label> </td>";
		                                content += "<td width=\"10%\" align=\"center\"><label for=\"desc\">Min<span class=\"text-danger\">*</span></label> </td>";
		                                content += "<td width=\"10%\" align=\"center\"><label for=\"desc\">Max<span class=\"text-danger\">*</span></label> </td>";
		                                content += "</tr>";
		                                for (var i=0; i < data.length; i++) {
		                                content += "<tr>";
		                                content += "<td align=\"center\">";
		                                content += "<input type=\"checkbox\" id=basic_idx"+data[i].basic_idx+" name=\"basic_idx\" value="+data[i].basic_idx+" checked onclick=\"return false;\" style=\"background-color: gray\" >";  
		                                content += "</td>";
		                             	content += "<td align=\"center\">"+data[i].b_name+"("+data[i].b_min+" ~ "+ data[i].b_max+")</td>";
		                             	content += "<input type=\"hidden\" name=\"s_min\" id=\"s_min\" value='"+data[i].min+"'>";
		                             	content += "<input type=\"hidden\" name=\"s_max\" id=\"s_max\" value='"+data[i].max+"'>";
		                                content += "<td align=\"center\"><input type=\"text\" class=\"form-control_mj\" id=\"min\" name=\"min\" maxlength=\"2\" onKeyPress=\"return numkeyCheck(event)\"></td>";
		                                content += "<td align=\"center\"><input type=\"text\" class=\"form-control_mj\" id=\"max\" name=\"max\" maxlength=\"2\" onKeyPress=\"return numkeyCheck(event)\"></td>";
		                                content += "</tr>";
		                                }
		                                content += "</table>";
		                                content += "</div>";
		                          $(".create_body").append(content);
		                       }
		                    },
		                    error: function(jqXHR, textStatus, errorThrown) 
		                    {              
		                        alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);                     
		                    }
		     });
	    });
	
	
	
	//검색
	$(document).on("click", ".jsSearch", function(e){
    	e.preventDefault();
    	document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
    	document.getElementById("searchId").value = $("#searchId").val();
   	
    	$("#form_conf_search").submit();
    	
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
	
		
		if( $(":checkbox[name='basic_idx']:checked").length==0 ){
			alert("Basic Indicator를 선택하세요.");
			return false;
		}
    	
	 	var bidx= $(":checkbox[name='basic_idx']:checked").length;
		for(i=0; i<bidx; i++){
			
			if($("input[name='basic_idx']")[i].checked == true){
				if($('input[name="min"]')[i].value == ''){
					alert("min 값을 입력해야 합니다.");
					$('input[name="min"]')[i].focus();
					return false;
				}
				
				if($('input[name="min"]')[i].value != ''){
					if($('input[name="max"]')[i].value == ''){
						alert("max 값을 입력해야 합니다.");
						$('input[name="max"]')[i].focus();
						return false;
					}
				}
				
				if(parseInt($('input[name="min"]')[i].value) > parseInt($('input[name="max"]')[i].value)) {
					alert("Min값("+$('input[name="min"]')[i].value+")이 \nMax값("+$('input[name="max"]')[i].value+") 보다 클 수 없습니다.");
					$('input[name="min"]')[i].focus();
					return false;
				}
				
				
				if(parseInt($('input[name="s_min"]')[i].value) > parseInt($('input[name="min"]')[i].value)) {
					alert("입력하신 Min값("+$('input[name="min"]')[i].value+")이 \nBasic Indicator의 Min값("+$('input[name="s_min"]')[i].value+") 보다 작을 수 없습니다.");
					$('input[name="min"]')[i].focus();
					return false;
				}
				
				if(parseInt($('input[name="s_max"]')[i].value) < parseInt($('input[name="min"]')[i].value)) {
					alert("입력하신 Min값("+$('input[name="min"]')[i].value+")이 \nBasic Indicator의 Max값("+$('input[name="s_max"]')[i].value+") 보다 클 수 없습니다.");
					$('input[name="min"]')[i].focus();
					return false;
				}
				
				if(parseInt($('input[name="s_max"]')[i].value) < parseInt($('input[name="max"]')[i].value)) {
					alert("입력하신 Max값("+$('input[name="max"]')[i].value+")이 \nBasic Indicator의 Max("+$('input[name="s_max"]')[i].value+")값 보다 클 수 없습니다.");
					$('input[name="max"]')[i].focus();
					return false;
				}
				
				if(parseInt($('input[name="s_min"]')[i].value) > parseInt($('input[name="max"]')[i].value)) {
					alert("입력하신 Max값("+$('input[name="max"]')[i].value+")이 \nBasic Indicator의 Min값("+$('input[name="s_min"]')[i].value+") 보다 작을 수 없습니다.");
					$('input[name="max"]')[i].focus();
					return false;
				}
				
			}
		}
		
    
    
    	var groupFormData = $("#form_conf_create").serialize();
        e.preventDefault();
        $.ajax({
    		url: "/REST/sens/createSensConf",
    		data : groupFormData,
    		dataType : "JSON",
    		method : "POST",
    		success : function(result) {
    			if(result == '888') {
    				alert("이미 등록 된 Basic Indicator의 Min, Max값이 있습니다.");
    			}else {
		    		if( result ) {
	    				alert("성공적으로 등록되었습니다.");
	   					location.reload();
	    			} else {
	    				alert("등록에 실패하였습니다.");
		    		}
    			}
    		}
    	});
    });
			
	$(document).on('click', '.jsUpdate', function(e){
    	e.preventDefault();
    	
    	var groupFormData = $("#form_conf_update").serialize();
    	
    	
    	if( $(":checkbox[name='basic_idx']:checked").length==0 ){
			alert("Indicator를 선택하세요.");
			return false;
		}
    	
    	var bidx= $(":checkbox[name='basic_idx']:checked").length;
    	var all = $("input:checkbox[name=basic_idx]").length;
    	
		for(i=0; i<all; i++){
			if($("input[name='basic_idx']")[i].checked == true){
				if($('input[name="min"]')[i].value == ''){
					alert("min 값을 입력해야 합니다.");
					$('input[name="min"]')[i].focus();
					return false;
				}
				
				if($('input[name="min"]')[i].value != ''){
					if($('input[name="max"]')[i].value == ''){
						alert("max 값을 입력해야 합니다.");
						$('input[name="max"]')[i].focus();
						return false;
					}
				}
				
				if(parseInt($('input[name="min"]')[i].value) > parseInt($('input[name="max"]')[i].value)) {
					alert("Min값("+$('input[name="min"]')[i].value+")이\n Max값("+$('input[name="max"]')[i].value+") 보다 클 수 없습니다.");
					$('input[name="min"]')[i].focus();
					return false;
				}
				
				
				
				if(parseInt($('input[name="s_min"]')[i].value) > parseInt($('input[name="min"]')[i].value)) {
					alert("입력하신 Min값("+$('input[name="min"]')[i].value+")이 \nBasic Indicator의 Min값("+$('input[name="s_min"]')[i].value+") 보다 작을 수 없습니다.");
					$('input[name="min"]')[i].focus();
					return false;
				}
				
				if(parseInt($('input[name="s_max"]')[i].value) < parseInt($('input[name="min"]')[i].value)) {
					alert("입력하신 Min값("+$('input[name="min"]')[i].value+")이\nBasic Indicator의 Max값("+$('input[name="s_max"]')[i].value+") 보다 클 수 없습니다.");
					$('input[name="min"]')[i].focus();
					return false;
				}
				
				if(parseInt($('input[name="s_max"]')[i].value) < parseInt($('input[name="max"]')[i].value)) {
					alert("입력하신 Max값("+$('input[name="max"]')[i].value+")이 \nBasic Indicator의 Max값("+$('input[name="s_max"]')[i].value+") 보다 클 수 없습니다.");
					$('input[name="max"]')[i].focus();
					return false;
				}
				
				if(parseInt($('input[name="s_min"]')[i].value) > parseInt($('input[name="max"]')[i].value)) {
					alert("입력하신 Max값("+$('input[name="max"]')[i].value+")이 \nBasic Indicator의 Min값("+$('input[name="s_min"]')[i].value+") 보다 작을 수 없습니다.");
					$('input[name="max"]')[i].focus();
					return false;
				}
			}
		}
    	
    	
    	$.ajax({
    		url:"/REST/sens/updateSensConf",
    		data : groupFormData,
    		dataType : "JSON",
    		method : "POST",
    		success : function(result) {
    			if(result == '888') {
    				alert("이미 등록 된 Basic Indicator의 Min, Max값이 있습니다.");
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
    	e.preventDefault();
    	 var groupId = escape(encodeURIComponent($(this).attr("data-groupid")));
    	 $("#modalSensConfModify").modal("show");
    	 
    	 
    	 var formURL = "selectSensConf?groupId="+groupId;               
	       $.ajax(
	       {
	                  url : formURL,
	                  type: "POST",
	                  timeout: 3000,                  
	                  success:function(data, textStatus, jqXHR) 
	                  {                     
	                       $(".modify_row").remove();
	                          
	                          
	                          for(var i=0;i < data.length; i ++){
	                             
	                             var content = "<div class=\"modify_row\">";
	                                content += "<div class=\"form-group\">";
	                                content += "<label for=\"name\">Service Indicator<span class=\"text-danger\">*</span></label>";
	                                content += "<input type='text' class='form-control' name='name' id='name' value='"+data[i].name+"' readonly>";
	                                content += "</div>";
	                              /*   content += "<div class=\"form-group\">";
	                                content += "<label for=\"kr_name\">KR NAME</label>";
	                                content += "<input type=\"text\" class=\"form-control\" id=\"kr_name\" name=\"kr_name\" maxlength=\"50\" placeholder=\"KR NAME을 입력하세요\" value='"+data[i].kr_name+"' readonly>";
	                                content += "</div>"; */
	                                content += "<div class=\"form-group\">";
	                                content += "<label for=\"emotion_level\">Level<span class=\"text-danger\">*</span></label>";
	                                content += "<input type=\"text\" class=\"form-control\" id=\"emotion_level\" name=\"emotion_level\"  maxlength=\"11\" onKeyPress=\"return numkeyCheck(event)\" value='"+data[i].emotion_level+"' readonly>";
	                                content += "</div>";
	                                content += "<div class=\"form-group\">";
	                                content += "<label for=\"name\">Description</label>";
	                                content += "<input type=\"text\" class=\"form-control\" id=\"description\" name=\"description\" placeholder=\"Description을 입력하세요\" value='"+data[i].description+"' maxlength=\"64\">";
	                                content += "</div>";
	                                content += "<div class=\"form-group\" style=\"height: 430px\">";
	                                content += "<table cellpadding=\"0\" border=\"0\" align=\"left\" width=\"100%\">";
	                                content += "<tr>";
	                                content += "<td width=\"10%\" align=\"center\"><label for=\"desc\">선택<span class=\"text-danger\">*</span></label></td>";
	                                content += "<td width=\"70%\" align=\"center\"><label for=\"desc\">Basic Indicator<span class=\"text-danger\">*</span></label></td>";
	                                content += "<td width=\"10%\" align=\"center\"><label for=\"desc\">Min<span class=\"text-danger\">*</span></label></td>";
	                                content += "<td width=\"10%\" align=\"center\"><label for=\"desc\">Max<span class=\"text-danger\">*</span></label></td>";
	                                content += "</tr>";
	                                for (var i=0; i < data.length; i++) {
	                                content += "<tr>";
	                                content += "<td align=\"center\">";
	                                
	                                content += "<input type=\"checkbox\" id=basic_idx"+data[i].basic_idx+" name=\"basic_idx\" value='"+data[i].basic_idx+"' checked onclick=\"return false;\" style=\"background-color: gray\" >";
                               		$("#form_conf_update").find(':input:checkbox[id=basic_idx'+data[i].basic_idx+']').prop("checked",true);
	                               /*  if(data[i].min != '') {
	                               	 content += "<input type=\"checkbox\" id=basic_idx"+data[i].basic_idx+" name=\"basic_idx\" value='"+data[i].basic_idx+"' checked>";
	                               		$("#form_conf_update").find(':input:checkbox[id=basic_idx'+data[i].basic_idx+']').prop("checked",true);
	                                }else{
	                                 content += "<input type=\"checkbox\" id=basic_idx"+data[i].basic_idx+" name=\"basic_idx\" value='"+data[i].basic_idx+"'>";  
	                                } */
	                                content += "</td>";
	                             	content += "<td align=\"center\">"+data[i].indi_name+" ("+data[i].b_min+" ~ "+data[i].b_max+")</td>";
	                             	content += "<input type=\"hidden\" name=\"s_min\" id=\"s_min\" value='"+data[i].b_min+"'>";
	                             	content += "<input type=\"hidden\" name=\"s_max\" id=\"s_max\" value='"+data[i].b_max+"'>";     	
	                                content += "<td align=\"center\"><input type=\"text\" class=\"form-control_mj\" id=\"min\" name=\"min\" maxlength=\"2\" onKeyPress=\"return numkeyCheck(event)\" value='"+data[i].min+"'></td>";
	                                content += "<td align=\"center\"><input type=\"text\" class=\"form-control_mj\" id=\"max\" name=\"max\" maxlength=\"2\" onKeyPress=\"return numkeyCheck(event)\" value='"+data[i].max+"'></td>";
	                                content += "</tr>";
	                                }
	                                content += "</table>";
	                                content += "</div>";
	                                content += "</div>";
	                                
	                              
	                                
	                          $(".modify_body").append(content);
	                       }
	                    },
	                    error: function(jqXHR, textStatus, errorThrown) 
	                    {              
	                        alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);                     
	                    }
	     });                
    	 
  
    });
	
	$(document).on("click", ".jsShowDetail", function(e){
    	e.preventDefault();
    	 var groupId = escape(encodeURIComponent($(this).attr("data-groupid")));
    	 $("#modalSensConfDetail").modal("show");
    	 
    	 
    	 var formURL = "selectSensConf?groupId="+groupId;               
	       $.ajax(
	       {
	                  url : formURL,
	                  type: "POST",
	                  timeout: 3000,                  
	                  success:function(data, textStatus, jqXHR) 
	                  {                     
	                       $(".detail_row").remove();
	                       for(var i=0;i < data.length; i ++){
	                             
	                             var content = "<div class=\"detail_row\">";
	                                content += "<div class=\"form-group\">";
	                                content += "<label for=\"name\">Service Indicator</label>";
	                                content += "<input type='text' class='form-control' name='name' id='name' value='"+data[i].name+"' readonly>";
	                                content += "</div>";
	                                content += "<div class=\"form-group\">";
	                                content += "<label for=\"emotion_level\">Level</label>";
	                                content += "<input type=\"text\" class=\"form-control\" id=\"emotion_level\" name=\"emotion_level\"  maxlength=\"11\" onKeyPress=\"return numkeyCheck(event)\" value='"+data[i].emotion_level+"' readonly>";
	                                content += "</div>";
	                                
	                                content += "<div class=\"form-group\">";
	                                content += "<label for=\"name\">Description</label>";
	                                content += "<input type=\"text\" class=\"form-control\" id=\"description\" name=\"description\" value='"+data[i].description+"' maxlength=\"64\" readonly>";
	                                content += "</div>";
	                                
	                                content += "<div class=\"form-group\" style=\"height: 430px\">";
	                                content += "<table cellpadding=\"0\" border=\"0\" align=\"left\" width=\"100%\">";
	                                content += "<tr>";
	                                content += "<td width=\"10%\" align=\"center\"><label for=\"desc\">No</label></td>";
	                                content += "<td width=\"70%\" align=\"center\"><label for=\"desc\">Basic Indicator</label></td>";
	                                content += "<td width=\"10%\" align=\"center\"><label for=\"desc\">Min</label></td>";
	                                content += "<td width=\"10%\" align=\"center\"><label for=\"desc\">Max</label></td>";
	                                content += "</tr>";
	                                for (var i=0; i < data.length; i++) {
	                                	 content += "<tr>";
	 	                                content += "<td align=\"center\">";
	 	                                content += "<input type=\"checkbox\" id=basic_idx"+data[i].basic_idx+" name=\"basic_idx\" value='"+data[i].basic_idx+"' checked onclick=\"return false;\" style=\"background-color: gray\" >";
	                                		$("#form_conf_update").find(':input:checkbox[id=basic_idx'+data[i].basic_idx+']').prop("checked",true);
	 	                                content += "</td>";
	 	                             	content += "<td align=\"center\">"+data[i].indi_name+" ("+data[i].b_min+" ~ "+data[i].b_max+")</td>";
	 	                             	content += "<input type=\"hidden\" name=\"s_min\" id=\"s_min\" value='"+data[i].b_min+"'>";
	 	                             	content += "<input type=\"hidden\" name=\"s_max\" id=\"s_max\" value='"+data[i].b_max+"'>";     	
	 	                                content += "<td align=\"center\"><input type=\"text\" class=\"form-control_mj\" id=\"min\" name=\"min\" maxlength=\"2\" onKeyPress=\"return numkeyCheck(event)\" value='"+data[i].min+"' readonly></td>";
	 	                                content += "<td align=\"center\"><input type=\"text\" class=\"form-control_mj\" id=\"max\" name=\"max\" maxlength=\"2\" onKeyPress=\"return numkeyCheck(event)\" value='"+data[i].max+"' readonly></td>";
	 	                                content += "</tr>";
	                                }
	                                content += "</table>";
	                                content += "</div>";
	                                content += "</div>";
	                              
	                                
	                          $(".detail_body").append(content);
	                       }
	                    },
	                    error: function(jqXHR, textStatus, errorThrown) 
	                    {              
	                        alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);                     
	                    }
	     });                
    	 
  
    });
	
	
/* 	$(document).on("click", ".jsShowDetail", function(e){
    	e.preventDefault();
    	 var groupId = escape(encodeURIComponent($(this).attr("data-groupid")));
    	 $("#modalSensConfDetail").modal("show");
    	 
    	 
    	 var formURL = "selectSensConf?groupId="+groupId;               
	       $.ajax(
	       {
	                  url : formURL,
	                  type: "POST",
	                  timeout: 3000,                  
	                  success:function(data, textStatus, jqXHR) 
	                  {                     
	                       $(".detail_row").remove();
	                          
	                          
	                          for(var i=0;i < data.length; i ++){
	                             
	                             var content = "<div class=\"detail_row\">";
	                             
	                             content += "<table cellpadding=\"0\" border=\"1\" align=\"center\" width=\"100%\">";
	                             content += "<tr align=\"center\">";
	                             content += "<td width=\"40%\" align=\"center\"><label for=\"desc\">Service Indicator</label> </td>";
	                             content += "<td id=\"name_detail\" width=\"30%\" align=\"center\" colsapn=\"2\">"+data[i].name+"</td>";
	                             content += "</tr>";
	                             content += "<tr align=\"center\">";
	                             content += "<td width=\"40%\" align=\"center\"><label for=\"desc\">Level</label> </td>";
	                             content += "<td id=\"name_detail\" width=\"30%\" align=\"center\" colsapn=\"2\">"+data[i].emotion_level+"</td>";
	                             content += "</tr>";
	                             content += "<tr align=\"center\">";
	                             content += "<td width=\"40%\" align=\"center\"><label for=\"desc\">description</label> </td>";
	                             content += "<td id=\"description_detail\" width=\"30%\" align=\"center\" colsapn=\"2\">"+data[i].description+"</td>";
	                             content += "</tr>";
	                             
	                             content += "<tr align=\"center\">";
	                             content += "<td width=\"40%\" align=\"center\"><label for=\"desc\">Basic Indicator</label> </td>";
	                             content += "<td width=\"40%\" align=\"center\"><label for=\"desc\">Min</label> </td>";
	                             content += "<td width=\"40%\" align=\"center\"><label for=\"desc\">Max</label> </td>";
	                             content += "</tr>";

	                             for (var i=0; i < data.length; i++) {
	                             content += "<tr align=\"center\">";
	                             content += "<td width=\"40%\" align=\"center\">"+data[i].indi_name+" ("+data[i].indi_min+" ~ "+data[i].indi_max+")</td>";
	                             content += "<td width=\"40%\" align=\"center\">"+data[i].min+"</td>";
	                             content += "<td width=\"40%\" align=\"center\">"+data[i].max+"</td>";
	                             
	                             content += "</tr>";
	                             }
	                                content += "</table>";
	                                content += "</div>";
	                                
	                              
	                                
	                          $(".detail_body").append(content);
	                       }
	                    },
	                    error: function(jqXHR, textStatus, errorThrown) 
	                    {              
	                        alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);                     
	                    }
	     });                
    	 
  
    }); */
	
	$(document).on("click", ".jsDeleteGroup", function(e){
    	e.preventDefault();
    	var username = "${sessionScope.sessionUser.currentUser.userName }";
    	var userid = "${sessionScope.sessionUser.currentUser.userId}";
    	var groupId = $(this).attr("data-groupid") + "," + username + "," + userid;
    	if(confirm("삭제 하시겠습니까?")) {
	    	$.ajax({
	    		url:"/REST/sens/deleteSensConf/" + groupId,
	    		dataType : "JSON",
	    		method : "GET",
	    		success : function(result) {
	    			if(result == '999') {
	    				alert("상위 레벨을 삭제 한 뒤 삭제할 수 있습니다.");
	    				return false;
	    			}else {
		    	    	if( result) {
		    	    		// alert("정상적으로 삭제되어, 화면을 갱신합니다.");
		    	    		location.reload();
		    	    	} else {
		    	    		alert("삭제를 실패하였습니다.");
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
        $("#form_conf_search input[name='page']").val(page);
        document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
        var pathname = window.location.pathname;
        window.location.href = pathname + "?" + $("#form_conf_search").serialize();
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