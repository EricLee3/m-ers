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
	<link rel="stylesheet" href="/resources/plugins/bootstrap-slider/slider.css">
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
	<script src="/resources/plugins/bootstrap-slider/bootstrap-slider.js"></script>
</head>

<body class="hold-transition skin-blue sidebar-mini">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h2><small>시스템 > 서비스 설정 ></small> 임계치 설정</h2>
			</section>

			<!-- Main content -->
			<section class="content">

			<div class="row">
				<div class="col-xs-9">
					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">설정</h3>
						</div>
						<form class="form-horizontal" id="form_parameter_update" action="">
							<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
							<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
							<div class="box-body">
								<div class="form-group">
									<input type="hidden" name="userId" value="forTest">
									<label for="inputEmail3" class="col-sm-2 control-label"></label>
									<div class="col-sm-10">
										<label for="inputEmail3"></label>
									</div>
								</div>
								<div class="form-group">
									<label for="customerAngry" class="col-sm-2 control-label">Angry</label>
									<div class="col-sm-1 text-right">0</div>
									<div class="col-sm-8">
										<input type="text" id="customerAngry" name="customerAngry" value="" class="slider form-control"
											data-slider-min="0" data-slider-max="30.0"
											data-slider-step="0.1" data-slider-value="${recognitionParameter.customerAngry }"
											data-slider-orientation="horizontal"
											data-slider-selection="before" data-slider-tooltip="always"
											data-slider-id="red" />
									</div>
									<div class="col-sm-1">30.0</div>
								</div>
								<div class="form-group"></div>
								<div class="form-group">
									<label for="agentStress" class="col-sm-2 control-label">Stress</label>
									<div class="col-sm-1 text-right">0</div>
									<div class="col-sm-8">
										<input type="text" id="agentStress" name="agentStress" value="" class="slider form-control"
											data-slider-min="0" data-slider-max="30.0"
											data-slider-step="0.1" data-slider-value="${recognitionParameter.agentStress}"
											data-slider-orientation="horizontal"
											data-slider-selection="before" data-slider-tooltip="always"
											data-slider-id="yellow" />
									</div>
									<div class="col-sm-1">30.0</div>
								</div>
								<div class="form-group"></div>
								<div class="form-group">
									<label for="angryCount" class="col-sm-2 control-label">Angry Count</label>
									<div class="col-sm-1 text-right">0</div>
									<div class="col-sm-8">
										<input type="text" id="angryCount" name="angryCount" value="" class="slider form-control"
											data-slider-min="0" data-slider-max="10" data-slider-step="1"
											data-slider-value="${recognitionParameter.angryCount }" data-slider-orientation="horizontal"
											data-slider-selection="before" data-slider-tooltip="always"
											data-slider-id="red">
									</div>
									<div class="col-sm-1">10</div>
								</div>
								<div class="form-group"></div>
								<div class="form-group">
									<label for="stressCount" class="col-sm-2 control-label">Stress Count</label>
									<div class="col-sm-1 text-right">0</div>
									<div class="col-sm-8">
										<input type="text" id="stressCount" name="stressCount" value="" class="slider form-control"
											data-slider-min="0" data-slider-max="10" data-slider-step="1"
											data-slider-value="${recognitionParameter.stressCount }" data-slider-orientation="horizontal"
											data-slider-selection="before" data-slider-tooltip="always"
											data-slider-id="yellow">
									</div>
									<div class="col-sm-1">10</div>
								</div>
								<div class="col-sm-12 text-center">
									<button type="button" class="jsUpdate btn btn-info">설정 값 적용</button>
								</div>
								<div class="form-group"> </div>
							</div>
							<div class="box-footer">
								<label for="title" class="col-sm-2 control-label">임계치 설정명</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="title" name="title" placeholder="현재 설정 값을 저장하기 위한 이름을 입력하세요" maxlength="20">
								</div>
								<div class="col-sm-1">
									<button type="button" class="jsSave btn btn-default pull-left">저장</button>
								</div>
							</div>
						</form>
					</div>
				</div>

				<div class="col-lg-3 col-xs-6">

					<!-- TABLE: 최근 저장 값 -->
					<div class="box box-warning">
						<div class="box-header with-border">
							<h3 class="box-title">최근 저장 목록</h3>
						</div>
						<div class="box-body">
							<div class="table-responsive">
								<table class="table no-margin">
									<thead>
										<tr>
											<th>임계치 설정명</th>
											<th>Angry</th>
											<th>Stress</th>
											<th>Ac <span data-toggle="tooltip" title="Angry Count" class="fa fa-question-circle"></span></th>
											<th>Sc <span data-toggle="tooltip" title="Stress Count" class="fa fa-question-circle"></span></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${parameterHistoryList}" var="parameter">
										<tr>
											<td><span class="jsApplyParamter " style="cursor:pointer;"
												data-customerAngry="${parameter.customerAngry}"
												data-agentStress="${parameter.agentStress}"
												data-angryCount="${parameter.angryCount}"
												data-stressCount="${parameter.stressCount}"
												data-dashTitle="${parameter.title}"
											>${parameter.title}</span></td>
											<td>${parameter.customerAngry}</td>
											<td>${parameter.agentStress}</td>
											<td>${parameter.angryCount}</td>
											<td>${parameter.stressCount}</td>
										</tr>
										</c:forEach>
										<c:if test="${empty parameterHistoryList}">
											<tr class="empty">
												<td colspan="3">현재 등록된 수행 작업이 없습니다.</td>
											</tr>
										</c:if>
									</tbody>
								</table>
							</div>
						</div>
						<div class="box-footer clearfix">
						</div>
					</div>
					<!-- /.box -->

				</div>
				<!-- /.col -->

			</div>
			<!-- /.row --> </section>
			<!-- /.content -->
<script>
var valueChanged = false;
$(document).ready(function() {
	/* BOOTSTRAP SLIDER */
	$(function () {
		$('.slider').slider();
	});

	$(document).on("change", ".slider", function(e) {
		e.preventDefault();
		valueChanged = true;
	});
	$(document).on('click', '.jsUpdate', function(e) {
		e.preventDefault();
		$("#form_parameter_update").attr("METHOD", "POST");
		$("#form_parameter_update").submit();
	});
	
	$(document).on('click', '.jsSave', function(e) {
		e.preventDefault();
		/*if(valueChanged == true) {
			alert("변경 값을 적용하신 후에 저장하실 수 있습니다.");
			return false;
		}*/
		if ($.trim($("#title").val()).trim().length < 1) {
			alert("임계치 설정명을 입력해야 합니다.");
			$("#title").focus();
			return false;
		}
		$("#form_parameter_update").attr("METHOD", "POST");
		$("#form_parameter_update").submit();
		var parameterFormData = $("#form_parameter_update").serialize();
		$.ajax({
			url : "/REST/config/createParameterHistory",
			data : parameterFormData,
			dataType : "JSON",
			method : "POST",
			success : function(resultHistory) {
				if (resultHistory) {
					location.reload();
				} else {
					alert("변경 내역 저장 중 오류가 발생했습니다.");
				}
			}						
		});
		
	}); 
	$(document).on('click', '.jsApplyParamter', function(e) {
		e.preventDefault();
		$("#title").val($(this).attr("data-dashTitle"));
		$("#customerAngry").slider( 'setValue',  parseFloat($(this).attr("data-customerAngry")) ); 
		$("#agentStress").slider( 'setValue', parseFloat($(this).attr("data-agentStress")) ); 
		$("#angryCount").slider( 'setValue', parseFloat($(this).attr("data-angryCount")) ); 
		$("#stressCount").slider( 'setValue', parseFloat($(this).attr("data-stressCount")) ); 
 	});

});
</script>
</body>
</html>