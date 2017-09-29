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
	<link rel="stylesheet" href="/resources/plugins/iCheck/all.css">
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	<script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<script src="/resources/plugins/jQuery/jquery.form.js"></script>
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="/resources/plugins/fastclick/fastclick.js"></script>
	<script src="/resources/js/app.min.js"></script>
	<script src="/resources/plugins/iCheck/icheck.min.js"></script>
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
				<h2><small>시스템 ></small> 상담원 목록</h2>
			</section>

			<!-- Main content -->
			<section class="content">
			<div class="row" style="height:800px">
				<div class="col-xs-9">
					<div class="box box-primary">
						<div class="box-header ">
							<h3 class="box-title">상담원  <small>(총 : ${agentCount } 명)</small></h3>
							<div class="box-tools">
								<form role="form" id="form_agent_search" action="" method="get">
									<input type="hidden" name="page" value="">
									<input type="hidden" id="sort" name="sort" value="${sort }">
									<input type="hidden" name="searchBoardIndex" id="searchBoardIndex" value="" />
									<div class="input-group input-group-sm col-md-3 pull-right">
										<input tabindex="2" type="text" id="searchQuery" name="searchQuery" class="form-control" placeholder="이름(아이디) or 내선번호를 입력하세요." value="${searchDTO.searchQuery}" maxlength="20">
										<div class="input-group-btn">
											<button type="button" class="jsSearch btn btn-default" tabindex="3">
												<i class="fa fa-search"></i>
											</button>
										</div>
									</div>
									
									<div class="form-group input-group-sm col-md-2 pull-right">
										<select tabindex="1" class="form-control" id="searchGroup" name="searchGroup">
											<option value="">그룹 전체</option>
										<c:forEach items="${groupList }" var="group">
											<option value="${group.groupId }">${group.groupName }</option>
										</c:forEach>
										<c:if test="${groupList eq null }">
											<option value="noGroup">등록된 그룹이 없습니다.</option>
										</c:if>
										</select>
									</div>
								</form> 
							</div>
						</div>
						
						<div class="box-body">
							<table id="example1" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th class="no-sort col-sm-1">No.</th>
										<th class="no-sort col-sm-1">이름(아이디)</th>
										<th class="no-sort col-sm-1">소속그룹</th>
										<th class="no-sort col-sm-1">내선번호</th>
										<th class="no-sort col-sm-1">비실시간
											<span data-toggle="tooltip" title="비실시간 모니터링 대상 여부" class="fa fa-question-circle"></span>
											<a class="realtimeSort pull-right"><i class="fa fa-fw fa-unsorted"></i></a>
										</th>
										<th class="no-sort col-sm-1">실시간
											<span data-toggle="tooltip" title="실시간 모니터링 대상 여부" class="fa fa-question-circle"></span>
											<a class="nonrealtimeSort pull-right"><i class="fa fa-fw fa-unsorted"></i></a>
										</th>
										<th class="no-sort col-sm-1 hidden-print">수정/삭제</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach varStatus="status" items="${agentList}" var="agent">
										<tr>
											<td>${((pageDTO.page-1)*pageDTO.itemPerPage)+status.index+1}</td>
											<td><a href="/monitor/agent_view/${agent.agentId}">${agent.agentName } (${agent.agentId })</a></td>
											<td>${agent.groupName } (${agent.groupId })</td>
											<td>${agent.agentNumber }</td>
											<td>
											<c:choose>
												<c:when test="${agent.isAuditBatch == '1' }">
													대상
												</c:when>
												<c:otherwise>
													비대상
												</c:otherwise>
											</c:choose>
											</td>
											<td>
											<c:choose>
												<c:when test="${agent.isAudit == '1' }">
													대상
												</c:when>
												<c:otherwise>
													비대상
												</c:otherwise>
											</c:choose>
											</td>
											<td class="hidden-print">
												<div class="btn-group">
													<button type="button" class="jsShowModal btn btn-default btn-xs" data-index="${agent.index }">수정</button>
													<button type="button" class="jsDeleteAgent btn btn-default btn-xs" data-index="${agent.index },${agent.agentName }, ${agent.agentId }">삭제</button>
												</div>
											</td>
										</tr>
									</c:forEach>
									<c:if test="${empty agentList }">
										<tr class="empty">
											<td colspan="9">현재 등록된 상담원이 없습니다.</td>
										</tr>
									</c:if>

								</tbody>
							</table>
						</div>
						<!-- /.box-body -->

						<div class="box-footer text-center">
							<div class="pull-left hidden-print">
								<!-- <button type="button" class="btn btn-default " onclick="print()"><i class="fa fa-print"></i><small> 인쇄</small></button> -->
								<!-- <button type="button" class="btn btn-info margin-r-5 "><i class="fa fa-file-excel-o"></i></button> -->
							</div>
							<ul class="pagination pagination-sm no-margin">
								<asnetPage:Pagination 
									page="${pageDTO.page }" 
									itemPerPage="${pageDTO.itemPerPage }" 
									pagePerGroup="${pageDTO.pagePerGroup }" 
									itemCount="${agentCount }" 
								/>
							</ul>
							<div class="pull-right hidden-print">
								<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalAgentCreate">상담원 등록</button>
								<button type="button" class="btn btn-primary jsExcelUpload" ><i class="fa fa-file-excel-o"></i> 엑셀 업로드</button>
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

				<div class="col-lg-3 col-xs-6 hidden-print">

					<!-- TABLE: 모니터링 대상자 현황 -->
					<div class="box box-default">
						<div class="box-header with-border">
							<h3 class="box-title">실시간 대상 상담원</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<div class="table-responsive">
								<table class="table no-margin">
									<thead>
										<tr>
											<th>상담원</th>
											<th>그룹</th>
											<th>내선번호</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${LatestagentList}" var="Latestagent">
										<tr>
											<!--  td><a href="/monitor/agent_view/${Latestagent.agentId}">${Latestagent.agentName }</a></td -->
											<td>${Latestagent.agentName }</td>
											<td>${Latestagent.groupName}</td>
											<td>${Latestagent.agentNumber }</td>
										</tr>
									</c:forEach>
									<c:if test="${empty LatestagentList }">
										<tr class="empty">
											<td colspan="9">현재 등록된 상담원이 없습니다.</td>
										</tr>
									</c:if>
									</tbody>
								</table>
							</div>
							<!-- /.table-responsive -->
						</div>
						<!-- /.box-body -->
						<div class="box-footer clearfix"></div>
						<!-- /.box-footer -->
					</div>
					<!-- /.box -->


				</div>
				<!-- /.col -->

			</div>
			<!-- /.row --> </section>
			<!-- /.content -->
		<!-- Modal 상담원 등록 -->
		<div class="modal fade" id="modalAgentCreate" tabindex="-1" role="dialog" aria-labelledby="modalAgentCreateLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="aa();">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalAgentCreateLabel">상담원 등록</h4>
					</div>
					<form role="form" id="form_agent_create" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<input type="hidden" id="checkedAgentId" value="false">
						<div class="modal-body">
							<div class="form-group">
								<label for="agentName">이름 <span class="text-danger">*</span></label><span class="pull-right"><span class="text-danger"><strong>*</strong></span>는 필수입력정보입니다.</span> 
								<input type="text" class="form-control" id="agentName" name="agentName" placeholder="이름을 입력하세요" maxlength="20">
							</div>
							<div class="form-group">
								<label for="agentName">아이디 <span class="text-danger">*</span></label> 
								<input type="text" class="form-control" id="agentId" name="agentId" placeholder="아이디를 입력하세요" maxlength="20" >
								<span id="checkAgentIdMsg" class="help-block">
									<i class="fa fa-exclamation-circle" aria-hidden="true"></i> 중복 검사 필요
								</span>
							</div>
							<div class="form-group">
								<label>그룹</label> 
								<select class="form-control" id="groupId" name="groupId">
									<option value="">선택</option>
								<c:forEach items="${groupList }" var="group">
									<option value="${group.groupId }">${group.groupName }</option>
								</c:forEach>
								<c:if test="${groupList eq null }">
									<option value="noGroup">등록된 그룹이 없습니다.</option>
								</c:if>
								</select>
							</div>

							<div class="form-group">
								<label for="agentNumber">내선번호</label> 
								<input type="text" class="form-control" id="agentNumber" name="agentNumber" placeholder="내선번호" maxlength="20">
							</div>
							<div class="form-group">
								<label for="agentIp">IP</label> 
								<input type="text" class="form-control" id="agentIp" name="agentIp" placeholder="192.168.0.0" maxlength="16">
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
							
							
							
							
							
							<div class="form-group">
								<jsp:useBean id="now" class="java.util.Date" />
								<input type="hidden" id="isAudit" name="isAudit" value="">
								<input type="hidden" id="isAuditBatch" name="isAuditBatch" value="">
								<label>모니터링 대상 여부</label> 
								<div class="row">
									<div class="col-md-4">
										<label class="margin-r-5"> 
											<input type="radio" name="radioAudit" class="flat-green radioAudit" value="1" >
										</label> 실시간
									</div>
									<div class="col-md-4">
										<label class="margin-r-5"> 
											<input type="radio" name="radioAudit" class="flat-green radioAudit" value="2" >
										</label> 비실시간
									</div>
									<div class="col-md-4">
										<label class="margin-r-5"> 
											<input type="radio" name="radioAudit" class="flat-green radioAudit" value="0" checked>
										</label> 대상아님
									</div>
								</div>
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

		<!-- Modal 상담원 정보 수정 -->
		<div class="modal fade" id="modalAgentModify" tabindex="-1" role="dialog" aria-labelledby="modalAgentModifyLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="aa();">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalAgentModifyLabel">상담원 정보 수정</h4>
					</div>
					<form role="form" id="form_agent_update" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<input type="hidden" name="index" id="index" value="">
						<div class="modal-body">
							<div class="form-group">
								<label for="agentName">이름</label> <input type="text" class="form-control" id="agentName" name="agentName" value="" maxlength="20">
							</div>
							<div class="form-group">
								<label>그룹</label>
								<select class="form-control" id="groupId" name="groupId">
								<c:forEach items="${groupList }" var="group">
									<option value="${group.groupId }">${group.groupName }</option>
								</c:forEach>
								<c:if test="${groupList eq null }">
									<option value="noGroup">등록된 그룹이 없습니다.</option>
								</c:if>
								</select>
							</div>
							<div class="form-group">
								<label for="agentNumber">내선번호</label> 
								<input type="text" class="form-control" id="agentNumber" name="agentNumber" value="" maxlength="20">
							</div>
							<div class="form-group">
								<label for="agentIp">IP</label> 
								<input type="text" class="form-control" id="agentIp" name="agentIp" placeholder="192.168.0.0" value="" maxlength="16">
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
							
							
							<div class="form-group">
								<input type="hidden" id="agentId" name="agentId" value="">
								<input type="hidden" id="isAudit2" name="isAudit" value="">
								<input type="hidden" id="isAuditBatch2" name="isAuditBatch" value="">
								<label>비실시간 모니터링 대상 여부</label> 
									<div class="row">
										<div class="col-md-4">
											<label class="margin-r-5"> 
												<input type="radio" name="radioAudit" class="flat-green radioAudit" value="1">
											</label> 실시간
										</div>
										<div class="col-md-4">
											<label class="margin-r-5"> 
												<input type="radio" name="radioAudit" class="flat-green radioAudit" value="2">
											</label> 비실시간
										</div>
										<div class="col-md-4">
											<label class="margin-r-5"> 
												<input type="radio" name="radioAudit" class="flat-green radioAudit" value="0">
											</label> 대상아님
										</div>
									</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left" data-dismiss="modal" onclick="aa();">취소</button>
							<button type="button" class="jsUpdate btn btn-primary">저장</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- /. modal 상담원 정보 수정 -->

		<!-- Modal 상담원 일괄 등록 -->
		<div class="modal fade" id="modal_agentExcelUpload" tabindex="-1" role="dialog" aria-labelledby="label_agentExcelUpload">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="label_agentExcelUpload">상담원 일괄 등록</h4>
					</div>
					<form role="form" id="form_excelupload" mehtod="POST" enctype="multipart/form-data">
						<div class="modal-body">
							<div class="form-group">
								<input type="file" id="agentExcelFile" name="agentExcelFile">
								<p class="help-block">
									상담원 정보가 들어있는 엑셀 파일을 업로드 하여주세요.
								</p>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left" data-dismiss="modal">취소</button>
							<button type="button" class="btn btn-primary jsSubmitExcelUpload">등록</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- /. modal 상담원 일괄 등록 -->
	
<script>

$("#form_agent_create").find("#groupId").change(function(){
	 var name = $("#form_agent_create").find('#groupId option:selected').val();
       var formURL = "selectAgentProfileList?name="+name;               
	        $.ajax(
	       {
	                  url : formURL,
	                  type: "POST",
	                  timeout: 3000,                  
	                  success:function(data, textStatus, jqXHR) 
	                  {       
	                	  for(var i=0;i < data.length; i ++){
							$("#form_agent_create").find("#profile_name_agent option[value='"+ data[i].agent_profile_id +"']").attr("selected", "selected");
							$("#form_agent_create").find("#profile_name_agent option[value='"+ data[i].agent_profile_id +"']").prop("selected", true);
							$("#form_agent_create").find("#profile_name_cus option[value='"+ data[i].customer_profile_id +"']").attr("selected", "selected");
							$("#form_agent_create").find("#profile_name_cus option[value='"+ data[i].customer_profile_id +"']").prop("selected", true); 
	                	  }
	      	    		
	                          /* for(var i=0;i < data.length; i ++){
	                             alert(data[i].agent_profile_id);
	                     
	                       } */
	                    },
	                    error: function(jqXHR, textStatus, errorThrown) 
	                    {              
	                        alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);                     
	                    } 
	     });
   });
   
$("#form_agent_update").find("#groupId").change(function(){
    var name = $("#form_agent_update").find('#groupId option:selected').val();
     var formURL = "selectAgentProfileList?name="+name;               
	        $.ajax(
	       {
	                  url : formURL,
	                  type: "POST",
	                  timeout: 3000,                  
	                  success:function(data, textStatus, jqXHR) 
	                  {       
	                	  for(var i=0;i < data.length; i ++){
							$("#form_agent_update").find("#profile_name_agent option[value='"+ data[i].agent_profile_id +"']").attr("selected", "selected");
							$("#form_agent_update").find("#profile_name_agent option[value='"+ data[i].agent_profile_id +"']").prop("selected", true);
							$("#form_agent_update").find("#profile_name_cus option[value='"+ data[i].customer_profile_id +"']").attr("selected", "selected");
							$("#form_agent_update").find("#profile_name_cus option[value='"+ data[i].customer_profile_id +"']").prop("selected", true); 
	                	  }
	      	    		
	                          /* for(var i=0;i < data.length; i ++){
	                             alert(data[i].agent_profile_id);
	                     
	                       } */
	                    },
	                    error: function(jqXHR, textStatus, errorThrown) 
	                    {              
	                        alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);                     
	                    } 
	     });
 });


$(document).ready(function(){
	
	
	
	$("#form_agent_search input[name=searchQuery]").keydown(function(e){
        if(e.keyCode == 13){
            e.cancelBubble = true;
            $(".jsSearch").click();
            return false;
        }
    });
	
	 // 엑셀에 등록된 상담원 목록 업로드 ( 신규 상담원 일괄 등록 ) jsSubmitExcelUpload
    $(document).on('click', '.jsExcelUpload', function(e){
    	e.preventDefault();
    	$("#modal_agentExcelUpload").modal("show");
    });
	 
	 // 선택된 파일을 서버로 전송합니다. 
    $(document).on('click', '.jsSubmitExcelUpload', function(e){
    	e.preventDefault();
    	if( $("#agentExcelFile").val() == "" ) {
    		alert("업로드할 상담원 목록이 담긴 엑셀 파일을 선택하여 주십시오.");
    		return;
    	}
    	// var agentListFormData = $("#form_excelupload").serialize();
    	$("#form_excelupload").ajaxForm({
    		url:"/REST/agent/uploadAgentList",
    		dataType : "JSON",
    		enctype: "multipart/form-data", 
    		method : "POST",
    		success : function(result) {
	    		if( result ) {
	    			if( result.index > 0 ) { 
	    				alert("성공적으로 "+result.index+"건이 등록되었습니다.");
    					location.reload();
	    			} else {
	    				alert("새로운 상담원 등록에 실패하였습니다.");
	    			}
	    		}
    		}
    	}).submit();
    	
    });

    // 상담원 ID 중복확인
    $(document).on('change', '#agentId', function(e){
    	e.preventDefault();
    	checkAvailableAgentId();
    });
	
    $(document).on('click', '.jsCreate', function(e){
    	e.preventDefault();
    	
    	if ($.trim($("#agentName").val()).trim().length < 1){
    		alert("상담원 이름을 입력해야 합니다.");
    		$("#agentName").focus();
    		return false;
    	}else if ($.trim($("#agentName").val()).length > 21) {
    		alert("상담원 이름은 최대 20자까지 입력 가능합니다.");
    		$("#agentName").val($("#agentName").val().substring(0, 20));
    		$("#agentName").focus();
            return false;
        }
    	
    	if ($.trim($("#agentId").val()).trim().length < 1 || $("#checkedAgentId").val()=="false" ){
    		alert("사용 가능한 아이디를 입력해야 합니다.");
    		$("#agentId").focus();
    		return false;
    	}
    	
    	if ($.trim($("#agentNumber").val()).length > 21) {
    		alert("내선번호는 최대 20자까지 입력 가능합니다.");
    		$("#agentNumber").val($("#agentNumber").val().substring(0, 20));
    		$("#agentNumber").focus();
            return false;
        }
    	
    	var radioAuditNo = $(":input:radio[name='radioAudit']:checked").val();
		$("#isAudit").val( radioAuditNo == 1 ? "1" : "0");
		$("#isAuditBatch").val( radioAuditNo == 2 ? "1" : "0");
    	var userFormData = $("#form_agent_create").serialize();
    	$.ajax({
    		url:"/REST/agent/createAgent",
    		data : userFormData,
    		dataType : "JSON",
    		method : "POST",
    		success : function(result) {
	    		if( result ) {
	    			if( result.index > 0 ) { 
	    				alert("성공적으로 등록되었습니다.");
    					location.reload();
	    			} else {
	    				alert("새로운 상담원 등록에 실패하였습니다.");
	    			}
	    		}
    		}
    	});
    });
    
    $(document).on('click', '.jsUpdate', function(e){
    	e.preventDefault();
    	if ($.trim($("#form_agent_update").find("#agentName").val()).trim().length < 1){
    		alert("상담원 이름을 입력해야 합니다.");
    		$("#form_agent_update").find("#agentName").focus();
    		return false;
    	}
    	
    	var radioAuditNo = $("#form_agent_update").find(":input:radio[name='radioAudit']:checked").val();
		$("#isAudit2").val( radioAuditNo == 1 ? "1" : "0");
		$("#isAuditBatch2").val( radioAuditNo == 2 ? "1" : "0");
    	var agentFormData = $("#form_agent_update").serialize();
    	$.ajax({
			url : "/REST/agent/updateAgent",
			data : agentFormData,
			dataType : "JSON",
			method : "POST",
			success : function(result) {				
				if (result != 2) {
					if (result == 1) {
						//alert("성공적으로 수정되었습니다.");
						location.reload();
					} else {
						alert("상담원 정보 수정에 실패하였습니다.");
					}
				}else{
					alert("현재 라이선스의 채널수를 모두 사용중입니다. 상담원을 모니터링 대상자로 등록하시려면, 라이선스 채널수를 변경하시거나 추가 라이선스 구매 바랍니다.")
				}
				
			}
		});
    });
    
    $(document).on("click", ".jsShowModal", function(e){
    	e.preventDefault();
    	var userIndex = $(this).attr("data-index");
    	$.ajax({
    		url:"/REST/agent/selectAgent/" + userIndex,
    		dataType : "JSON",
    		method : "GET",
    		success : function(result) {
    	    	if( result ) {
    	    		$("#modalAgentModify").modal("show");
    	    		$("#form_agent_update").find("#index").val(result.index);
    	    		$("#form_agent_update").find("#agentName").val(result.agentName);
    	    		$("#form_agent_update").find("#agentNumber").val(result.agentNumber);
    	    		$("#form_agent_update").find("#agentIp").val(result.agentIp);
    	    		$("#form_agent_update").find("#groupId option[value='"+ result.groupId +"']").attr("selected", "selected");
    	    		$("#form_agent_update").find("#groupId option[value='"+ result.groupId +"']").prop("selected", true);
    	    		$("#form_agent_update").find("#isAuditBatch").val(result.isAuditBatch);
    	    		$("#form_agent_update").find("#isAudit").val(result.isAudit);
    	    		$("#form_agent_update").find("#agentId").val(result.agentId);
    	    		if (result.isAudit == 1 ) {
    	    			$("#form_agent_update").find(':input:radio[name=radioAudit]:input[value="1"]').attr("checked", true);
    	    			$("#form_agent_update").find(':input:radio[name=radioAudit]:input[value="1"]').prop("checked",true);
    	    			$('input').iCheck({
    	    		        radioClass: 'iradio_flat-green'
    	    		    });
    	    		}
    	    		if (result.isAuditBatch == 1) {
    	    			$("#form_agent_update").find(':input:radio[name="radioAudit"]:input[value="2"]').attr("checked", true);
    	    			$("#form_agent_update").find(':input:radio[name="radioAudit"]:input[value="2"]').prop("checked",true);
    	    			$('input').iCheck({
    	    		        radioClass: 'iradio_flat-green'
    	    		    });
    	    		}
    	    		if (result.isAudit == 0 && result.isAuditBatch == 0) {
    	    			$("#form_agent_update").find(':input:radio[name="radioAudit"]:input[value="0"]').attr("checked", true);
    	    			$("#form_agent_update").find(':input:radio[name="radioAudit"]:input[value="0"]').prop("checked",true);
    	    			$('input').iCheck({
    	    		        radioClass: 'iradio_flat-green'
    	    		    });
    	    		}
    	    		$("#form_agent_update").find("#profile_name_agent option[value='"+ result.agent_profile_id +"']").attr("selected", "selected");
    	    		$("#form_agent_update").find("#profile_name_cus option[value='"+ result.customer_profile_id +"']").attr("selected", "selected");
    	    		$("#form_agent_update").find("#profile_name_agent option[value='"+ result.agent_profile_id +"']").prop("selected", true);
    	    		$("#form_agent_update").find("#profile_name_cus option[value='"+ result.customer_profile_id +"']").prop("selected", true);
    	    		
    	    	} else {
    	    		alert("해당 상담원의 정보를 가져올 수 없습니다.");
    	    	}
    		}
    	});
    });
    
    $(document).on("click", ".jsDeleteAgent", function(e){
    	e.preventDefault();
    	var username = "${sessionScope.sessionUser.currentUser.userName }";
    	var userid = "${sessionScope.sessionUser.currentUser.userId}";
    	var userIndex = $(this).attr("data-index") + "," + username + "," + userid;
    	if(confirm("한번 삭제하면 복구할 수 없습니다. 계속 하시겠습니까?")) {
	    	$.ajax({
	    		url:"/REST/agent/deleteAgent/" + userIndex,
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
    
    $(document).on("click", ".jsSearch", function(e){
    	e.preventDefault();
        var searchQuery = $("#searchQuery").val();
    
    	var regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/gi;
    	searchQuery = searchQuery.replace(regExp, "");
    	document.getElementById("searchQuery").value = searchQuery;
    	document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
    	document.getElementById("sort").value = ""; 	
    	$("#form_agent_search").submit();
    });
    
    <c:if test="${searchDTO.searchGroup != null}">
    $("#form_agent_search").find("#searchGroup option[value='${searchDTO.searchGroup}']").attr("selected", "selected");
    </c:if>	
    	
    $(document).on("click", ".nonrealtimeSort", function(e){
    	if(document.getElementById("sort").value == 1){
    		document.getElementById("sort").value = "";
    	}else{
    		document.getElementById("sort").value = "1";	
    	}
    	
    	$("#form_agent_search").submit();
    });
    
    $(document).on("click", ".realtimeSort", function(e){
    	if(document.getElementById("sort").value == 2){
    		document.getElementById("sort").value = "";
    	}else{
    		document.getElementById("sort").value = "2";	
    	}
    	$("#form_agent_search").submit();
    });
    
    /*
     * 페이징을 위해 필요한 스크립트입니다.
     * 단, 검색 상자등이 있을 경우에는 해당 항목의 이름 ( 아래에서는 form_search ) 등에 주의하셔야 합니다. 
     * 또한,Page가 정상적으로 동작하기 위해서는 해당 페이지에 <form id="form_search "...><input type="hidden" name="page"> 와 같은 코드가 반드시 필요합니다.
     */
    $(document).on("click", ".pagination li a", function(e) {
        e.preventDefault();
        var page = $(this).attr("data-page");
        $("#form_agent_search input[name='page']").val(page);
        document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
        var pathname = window.location.pathname;
        window.location.href = pathname + "?" + $("#form_agent_search").serialize();
    });

	//Flat color scheme for iCheck
	$('input[type="checkbox"].flat-green, input[type="radio"].flat-green').iCheck({
		checkboxClass : 'icheckbox_flat-green',
		radioClass : 'iradio_flat-green'
	});
	
});

function checkAvailableAgentId() {
	var newAgentId = $("#agentId").val();
	$.ajax({
		url:"/REST/agent/isDuplicatedAgentId",
		data : { 'agentId' : newAgentId },
		dataType : "JSON",
		method : "GET",
		success : function(result) {
	    	if( result ) {
	    		$("#checkAgentIdMsg").html("<i class='fa fa-check-circle' aria-hidden='true'></i> 사용 가능");
	    		$("#checkedAgentId").val("true");
	    	} else {
	    		$("#checkAgentIdMsg").html("<i class='fa fa-ban' aria-hidden='true'></i> 사용 불가");
	    		$("#checkedAgentId").val("false");
	    	}
		}
	});
}
</script>

</body>
</html>