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
			if("${searchType}" != null && "${searchType}" != '') $("select[name=searchType]").val("${searchType}").attr("selected","selected");
			if("${searchBoardIndex}" != null && "${searchBoardIndex}" != '') $("select[name=searchBoardIndex1]").val("${searchBoardIndex}").attr("selected","selected");
		});
	</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h2><small>시스템 ></small> 알람 코드 설정</h2>
			</section> 
			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box box-success">
							<div class="box-header">
								<h3 class="box-title">알람 코드 설정<small>(총 : ${alarmCodeCount }개)</small></h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<!-- 검색 조건 -->
								<form role="form" id="form_alarmCode_search"  action="" method="get">
									<input type="hidden" name="page" value="" />
									<input type="hidden" name="searchBoardIndex" id="searchBoardIndex" value="" />
									
									<div class="col-md-2 hidden-print">
										<div class="form-group">
											<input type="text" class="form-control" id="searchQuery" name="searchQuery" placeholder="알람코드" maxlength="10" value="${searchDTO.searchQuery }">
										</div>
									</div>
									
									<div class="col-md-2 hidden-print">
										<div class="form-group">
											<select class="form-control" id="searchType" name="searchType">
												<option value="">전체 레벨</option>
												<option value="0">NORMAL</option>
												<option value="1">MINOR</option>
												<option value="2">MAJOR</option>
												<option value="3">CRITICAL</option>
												<option value="4">FAULT</option>
											</select>
										</div>
									</div>
									
									<div class="col-md-2 hidden-print">
										<div class="form-group">
											<input type="text" class="form-control" id="searchCondition" name="searchCondition" placeholder="설명 " maxlength="30" value="<c:if test="${searchDTO.searchCondition ne null && searchDTO.searchCondition ne '' }">${searchDTO.searchCondition}</c:if>">
										</div>
									</div>
									
									<div class="col-md-2 hidden-print">
										<button type="button" class="jsSearch btn btn-info">조회</button>
									</div>
								</form>
						</div>
							<div class="box-body table-responsive no-padding">
								<table id="example1" class="table table-bordered table-striped" style="width: 100%;">
									<thead>
										<tr>
											<th class="col-sm-1" style="width: 1%;">No.</th>
											<th class="col-sm-1" style="width: 2%;">알람 코드</th>
											<th class="col-sm-1" style="width: 2%;">알람 레벨</th>
											<th class="col-sm-1" style="width: 2%;">알람 여부</th>
											<th class="col-sm-1" style="width: 2%;">가시 여부</th>
											<th class="col-sm-1" style="width: 2%;">가청 여부</th>
											<th class="col-sm-1" width="*%">설명</th>
											<th class="col-sm-1" style="width: 2%;">관리</th>
										</tr>
									</thead>
									<c:forEach varStatus="status" items="${alarmList}" var="alarm">
									<tr>
										<td>${((pageDTO.page-1)*pageDTO.itemPerPage)+status.index+1}</td>
										<td>${alarm.alarmCode }</td>
										<c:if test="${alarm.alarmLv eq 0}">
										<td><img src="/resources/img/nor.PNG" alt="normal" width="70px;" height="25px;"></td>
										</c:if>
										<c:if test="${alarm.alarmLv eq 1}">
										<td><img src="/resources/img/mi.PNG" alt="minor" width="70px;" height="25px;"></td>
										</c:if>
										<c:if test="${alarm.alarmLv eq 2}">
										<td><img src="/resources/img/mj.PNG" alt="major" width="70px;" height="25px;"></td>
										</c:if>
										<c:if test="${alarm.alarmLv eq 3}">
										<td><img src="/resources/img/cri.PNG" alt="critical" width="70px;" height="25px;"></td>
										</c:if>
										<c:if test="${alarm.alarmLv eq 4}">
										<td><img src="/resources/img/fa.PNG" alt="fault" width="70px;" height="25px;"></td>
										</c:if>
										<c:if test="${alarm.useFlag eq 0}">
										<td>미사용</td>
										</c:if>
										<c:if test="${alarm.useFlag eq 1}">
										<td>사용</td>
										</c:if>
										<c:if test="${alarm.visualFlag eq 0}">
										<td>미사용</td>
										</c:if>
										<c:if test="${alarm.visualFlag eq 1}">
										<td>사용</td>
										</c:if>
										<c:if test="${alarm.audioFlag eq 0}">
										<td>미사용</td>
										</c:if>
										<c:if test="${alarm.audioFlag eq 1}">
										<td>사용</td>
										</c:if>
										<td>
											<nobr>
												<span title="${alarm.alarmDesc}" style="CURSOR:hand;">
													<p style="width:620px;overflow:hidden;text-overflow:ellipsis" >${alarm.alarmDesc}
													</p>
												</span>	
											</nobr>
										</td>
										<td>
										
									
											<div class="btn-group">
												<button type="button" class="jsShowModal btn btn-default btn-xs" data-alarmcode="${alarm.alarmCode }">수정</button>
												<button type="button" class="jsDeleteAlarm btn btn-default btn-xs" data-alarmcode="${alarm.alarmCode },${alarm.alarmLv}">삭제</button>
											</div>
										</td>
									</tr>
									</c:forEach>
									<c:if test="${empty alarmList }">
										<tr class="empty">
											<td colspan="5">등록된 정보가 없습니다.</td>
										</tr>
									</c:if>
									
								</table>
							</div>
													<!-- /.box-body -->
						<div class="box-footer clearfix text-center">
								<ul class="pagination pagination-sm no-margin">
									<asnetPage:Pagination 
										page="${pageDTO.page }" 
										itemPerPage="${pageDTO.itemPerPage }" 
										pagePerGroup="${pageDTO.pagePerGroup }" 
										itemCount="${alarmCodeCount }" 
									/>
								</ul>
								<!-- <button type="button" class="btn btn-default pull-right hidden-print" onclick="print()"><i class="fa fa-print"></i><small> 인쇄</small></button> -->
								<!-- <button type="button" class="btn btn-info pull-right margin-r-5 hidden-print"><i class="fa fa-file-excel-o"></i></button> -->
								<button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#myModal">알람 등록</button>
								
						</div>
						<div class="input-group input-group-sm col-md-3 pull-right" style="width:110px; margin-top: 10px;">
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
						<h4 class="modal-title" id="myModalLabel">알람 코드 등록</h4>
					</div>
					<form role="form" id="form_alarm_create" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<input type="hidden" id="checkedAlarmCode" name="checkedAlarmCode" value="false">
						<input type="hidden" name="searchBoardIndex" id="searchBoardIndex" value="" />
						<div class="modal-body">
							<div class="form-group">
								<label for="alarmCode">알람 코드 <span class="text-danger">*</span></label><span class="pull-right"><span class="text-danger"><strong>*</strong></span>는 필수입력정보입니다.</span> 
								<input type="text" class="form-control" id="alarmCode" name="alarmCode" placeholder="알람코드를 입력하세요" maxlength="10">
								<span id="checkAlarmCodeMsg" class="help-block">
									<i class="fa fa-exclamation-circle" aria-hidden="true"></i> 중복 검사 필요
								</span>
							</div>
							<div class="form-group">
								<label>알람 레벨<span class="text-danger">*</span></label> 
								<select class="form-control" id="alarmLv" name="alarmLv">
									<option value="0">NORMAL</option>
									<option value="1">MINOR</option>
									<option value="2">MAJOR</option>
									<option value="3">CRITICAL</option>
									<option value="4">FAULT</option>
								</select>
							</div>
							<div class="form-group">
								<label>알람 여부</label> 
								<select class="form-control" id="useFlag" name="useFlag">
									<option value="1">사용</option>
									<option value="0">사용안함</option>
								</select>
							</div>
							<div class="form-group">
								<label>가시 여부</label> 
								<select class="form-control" id="visualFlag" name="visualFlag">
									<option value="1">사용</option>
									<option value="0">사용안함</option>
								</select>
							</div>
							<div class="form-group">
								<label>가청 여부</label> 
								<select class="form-control" id="audioFlag" name="audioFlag">
									<option value="1">사용</option>
									<option value="0">사용안함</option>
								</select>
							</div>
							<div class="form-group">
								<label for="GroupName">알람 정보 </label> 
								<textarea rows="10" cols="51" class="form-control" id="alarmDesc" name="alarmDesc" placeholder="정보를 입력하세요" maxlength="512"></textarea>
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
		<div class="modal fade" id="modalAlarmCodeModify" tabindex="-1" role="dialog" aria-labelledby="modalAlarmCodeModifyLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="modalAlarmCodeModifyLabel">알람 코드 수정</h4>
					</div>
					<form role="form" id="from_alarm_update" action="" method="post">
						<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
						<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
						<div class="modal-body">
							<div class="form-group">
								<label for="alarmCode">알람코드</label> 
								<input type="text" class="form-control" id="alarmCode" name="alarmCode" value="" maxlength="10" readonly>
								<span class="help-block">
									<i class="fa fa-exclamation-circle" aria-hidden="true"></i> 변경 불가 
								</span>
							</div>
							<div class="form-group">
								<label for="useFlag">알람 사용여부</label> 
								<select class="form-control" id="useFlag" name="useFlag" value="">
									<option value="1">사용</option>
									<option value="0">사용안함</option>
								</select>
							</div>
							<div class="form-group">
								<label for="alarmLv">알람레벨<span class="text-danger">*</span></label> 
								<select class="form-control" id="alarmLv" name="alarmLv" value="">
									<option value="0">NORMAL</option>
									<option value="1">MINOR</option>
									<option value="2">MAJOR</option>
									<option value="3">CRITICAL</option>
									<option value="4">FAULT</option>
								</select>
							</div>
							<div class="form-group">
								<label for="visualFlag">가시 여부</label> 
								<select class="form-control" id="visualFlag" name="visualFlag" value="">
									<option value="1">사용</option>
									<option value="0">사용안함</option>
								</select>
							</div>
							<div class="form-group">
								<label for="audioFlag">가시 여부</label> 
								<select class="form-control" id="audioFlag" name="audioFlag" value="">
									<option value="1">사용</option>
									<option value="0">사용안함</option>
								</select>
							</div>
							<div class="form-group">
								<label for="alarmDesc">알람 정보 </label> 
								<textarea rows="10" cols="51" class="form-control" id="alarmDesc" name="alarmDesc" placeholder="정보를 입력하세요" maxlength="512"></textarea>
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
    $(window).keydown(function(event){
        if(event.keyCode == 13) {
          event.preventDefault();
          return false;
        }
    });	
			
	// 그룹 ID 중복확인
    $(document).on('change', '#alarmCode', function(e){
    	e.preventDefault();
    	checkAvailableAlarmCode();
    });
			
	//검색시 enter키 활성화
	$("#form_alarmCode_search input[name=searchQuery]").keydown(function(e){
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
   	
    	$("#form_alarmCode_search").submit();
    });
    	
	$(document).on('click', '.jsCreate', function(e){
		e.preventDefault();
    	if ($.trim($("#alarmCode").val()).length < 1){
    		alert("알람코드를 입력해야 합니다.");
    		$("#alarmCode").focus();
    		return false;
    	}
    	
    	if ($("#checkedAlarmCode").val()=="false" ){
    		alert("등록 된 알람코드 입니다.");
    		$("#alarmCode").focus();
    		return false;
    	}
    	
    	if ($.trim($("#alarmDesc").val()).length > 256) {
    		alert("알람정보는 최대 256자까지 입력 가능합니다.");
    		$("#alarmDesc").val($("#alarmDesc").val().substring(0, 256));
    		$("#alarmDesc").focus();
            return false;
        }

    	var alarmFormData = $("#form_alarm_create").serialize();
        e.preventDefault();
        $.ajax({
    		url: "/REST/alarmcode/createAlarmCode",
    		data : alarmFormData,
    		dataType : "JSON",
    		method : "POST",
    		success : function(result) {
	    		if( result ) {
    				alert("성공적으로 등록되었습니다.");
   					location.reload();
    			} else {
    				alert("새로운 알람코드 등록에 실패하였습니다.");
	    		}
    		}
    	});
    });
			
	$(document).on('click', '.jsUpdate', function(e){
		//alert($("#from_alarm_update").find("#useFlag").val());
    	e.preventDefault();
    	if ($.trim($("#from_alarm_update").find("#alarmCode").val()).trim().length < 1){
    		alert("알람코드를 입력해야 합니다.");
    		$("#from_alarm_update").find("#alarmCode").focus();
    		return false;
    	}
    	
    	var alarmFormData = $("#from_alarm_update").serialize();
    	$.ajax({
    		url:"/REST/alarmcode/updateAlarmCode",
    		data : alarmFormData,
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
    	var alarmCode = $(this).attr("data-alarmcode");
    	$.ajax({
    		url:"/REST/alarmcode/selectAlarmCode/" + alarmCode,
    		dataType : "JSON",
    		method : "GET",
    		success : function(result) {
    	    	if( result ) {
    	    		$("#modalAlarmCodeModify").modal("show");
    	    		$("#from_alarm_update").find("#alarmCode").val(result.alarmCode);
    	    		$("#from_alarm_update").find("#alarmLv option[value='"+ result.alarmLv +"']").attr("selected", "selected");
    	    		$("#from_alarm_update").find("#alarmDesc").val(result.alarmDesc);
    	    		$("#from_alarm_update").find("#useFlag option[value='"+ result.useFlag +"']").attr("selected", "selected");
    	    		$("#from_alarm_update").find("#visualFlag option[value='"+ result.visualFlag +"']").attr("selected", "selected");
    	    		$("#from_alarm_update").find("#audioFlag option[value='"+ result.audioFlag +"']").attr("selected", "selected");
    	    	} else {
    	    		alert("해당 알람코드 정보를 가져올 수 없습니다.");
    	    	}
    		}
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
        $("#form_alarmCode_search input[name='page']").val(page);
        document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
        var pathname = window.location.pathname;
        window.location.href = pathname + "?" + $("#form_alarmCode_search").serialize();
    });
    
	$(document).on("click", ".jsDeleteAlarm", function(e){
    	e.preventDefault();
    	var username = "${sessionScope.sessionUser.currentUser.userName }";
    	var userid = "${sessionScope.sessionUser.currentUser.userId}";
    	var lv = $('#lv22').val();
    	var alarmCode = $(this).attr("data-alarmcode") + "," + username + "," + userid;
    	
    	if(confirm("해당 알람코드 정보가 삭제됩니다. 계속 하시겠습니까?")) {
	    	$.ajax({
	    		url:"/REST/alarmcode/deleteAlarmCode/" + alarmCode,
	    		dataType : "JSON",
	    		method : "GET",
	    		success : function(result) {
	    	    	if( result) {
	    	    		alert("정상적으로 삭제되어, 화면을 갱신합니다.");
	    	    		location.reload();
	    	    	} else {
	    	    		alert("서버의 문제가 없는지 확인해 주시기 바랍니다.");
	    	    	}
	    		}
	    	});
    	}
    });

});
		
function checkAvailableAlarmCode() {
	var newAlarmCode = $("#alarmCode").val();
	$.ajax({
		url : "/REST/alarmcode/isDuplicatedAlarmCoded",
		data : { "alarmCode" : newAlarmCode },
		dataType : "JSON",
		method : "GET",
		success : function(result) {
	    	if( result ) {
	    		$("#checkAlarmCodeMsg").html("<i class='fa fa-check-circle' aria-hidden='true'></i> 사용 가능");
	    		$("#checkedAlarmCode").val("true");
	    	} else {
	    		$("#checkAlarmCodeMsg").html("<i class='fa fa-ban' aria-hidden='true'></i> 사용 불가");
	    		$("#checkedAlarmCode").val("false");
	    	}
		}
	});
}
</script>
</body>
</html>