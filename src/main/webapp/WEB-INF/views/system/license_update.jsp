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
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="/resources/plugins/fastclick/fastclick.js"></script>
	<script src="/resources/js/app.min.js"></script>
	<script src="/resources/plugins/iCheck/icheck.min.js"></script>
	
</head>

<body class="hold-transition skin-blue sidebar-mini">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h2>
					시스템 > 라이선스 설정 <small></small>
				</h2>
			</section>
	
			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-4">
						<!-- Widget: style 1 -->
						<div class="box">
							<div class="box-header with-border bg-yellow">
								<h2 class="text-center ">라이선스 설정</h2>
							</div>
							<form role="form" class="form-horizontal" id="form_license_update" method="POST">
							<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
							<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
							<div class="box-body">
								<div class="form-group"></div>
								<div class="form-group">
									<label for="service" class="col-sm-4 control-label">채널 라이선스</label>
									<div class="col-sm-2"></div>
									<div class="col-sm-3">
										<input type="hidden" name="realtimeService" value="${license.realtimeService}">
										<input type="hidden" name="nonrealtimeService" value="${license.nonrealtimeService}">
										<input id="realtimeService" class="flat-orange" type="checkbox" value="${license.realtimeService}" <c:if test="${license.realtimeService eq 1 }">checked</c:if>> 실시간
									</div>
									<div class="col-sm-3">
				                    	<input id="nonrealtimeService" class="flat-orange" type="checkbox" value="${license.nonrealtimeService}" <c:if test="${license.nonrealtimeService eq 1 }">checked</c:if>> 비실시간
									</div>
								</div>
								<div class="form-group"></div>
								<div class="form-group">
									<label for="realtimeChannel" class="col-sm-4 control-label">실시간 분석채널 <span data-toggle="tooltip" title="비실시간 모니터링 대상 여부" class="fa fa-question-circle"></span></label>
									<div class="col-sm-2"></div>
									<div class="col-sm-6">
										<input type="text" class="form-control onlynum" id="realtimeChannel" name="realtimeChannel" value="${license.realtimeChannel }" maxlength="5">
										<span class="realtimeChannelCheck help-block hidden">실시간 대상 상담원 : 10명</span>
									</div>
									
								</div>
								<div class="form-group"></div>
								<div class="form-group">
									<label for="nonrealtimeChannel" class="col-sm-4 control-label">비실시간 분석채널</label>
									<div class="col-sm-2"></div>
									<div class="col-sm-6 ">
										<input type="text" class="form-control onlynum" id="nonrealtimeChannel" name="nonrealtimeChannel" value="${license.nonrealtimeChannel}" maxlength="5">
										<span class="nonrealtimeChannelCheck help-block hidden">비실시간 대상 상담원 : 10명</span>
									</div>
								</div>
								<div class="form-group"></div>
								<div class="form-group">
									<label for="service" class="col-sm-4 control-label">서비스별 라이선스</label>
									<div class="col-sm-2"></div>
									<div class="col-sm-3 ">
										<input type="hidden" name="agentStress" value="${license.agentStress}">
										<input type="hidden" name="customerStress" value="${license.customerStress}">
										<input id="agentStress" class="flat-orange" type="checkbox" value="${license.agentStress}" <c:if test="${license.agentStress eq 1 }">checked</c:if>> 상담원
									</div>
									<div class="col-sm-3">
				                    	<input id="customerStress" class="flat-orange" type="checkbox" value="${license.customerStress}" <c:if test="${license.customerStress eq 1 }">checked</c:if>> 고객
									</div>
								</div>
							</div>
							<div class="box-footer">
								<a href="/system/license"><button type="button" class="btn btn-default pull-left">취소</button></a>
								<button type="button" class="jsUpdate btn btn-warning pull-right">적용</button>
							</div>
							</form>
						</div>
					</div>
				
				</div>
			</section>
			<!-- /.content -->
<script>
$(document).ready(function() {
	$(".onlynum").keyup(function(){$(this).val( $(this).val().replace(/[^0-9]/g,"") );} );
	
	$(document).on('click', '.jsUpdate', function(e) {
		e.preventDefault();
		if ( $.trim ( $("#realtimeChannel").val() ).length < 1) {
			alert("실시간 분석 채널의 값을 입력하십시오.");
			$("#realtimeChannel").focus();
			return false;
		}
		if ($.trim ( $("#nonrealtimeChannel").val() ).length < 1) {
			alert("비실시간 분석 채널의 값을 입력하십시오.");
			$("#nonrealtimeChannel").focus();
			return false;
		}
		$("input[name='realtimeService']").val( $("#realtimeService").is(":checked") ? "1" : "0");
		$("input[name='nonrealtimeService']").val( $("#nonrealtimeService").is(":checked") ? "1" : "0");
		$("input[name='agentStress']").val( $("#agentStress").is(":checked") ? "1" : "0");
		$("input[name='customerStress']").val( $("#customerStress").is(":checked") ? "1" : "0");
		
		var realtimeChannel = $("#realtimeChannel").val()
		var nonrealtimeChannel = $("#nonrealtimeChannel").val()
		if(${auditCount} <= realtimeChannel){
			if(${auditBatchCount} <= nonrealtimeChannel){
				$("#form_license_update").submit();
			}else{
				alert("변경하려는 채널 수보다, 현재 비실시간 대상자가 많습니다.");
				return false;
			}
		}else{
			alert("변경하려는 채널 수보다, 현재 실시간 대상자가 많습니다.");
			return false;
		}
		
	});
	
	//Flat red color scheme for iCheck
	$('input[type="checkbox"].flat-orange').iCheck({
		checkboxClass : 'icheckbox_flat-orange',
		radioClass : 'iradio_flat-green'
	});
});
</script>
</body>
</html>