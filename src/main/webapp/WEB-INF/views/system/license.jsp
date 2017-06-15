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
</head>

<body class="hold-transition skin-blue sidebar-mini">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h2>
					<small>시스템 ></small> 라이선스 설정 
				</h2>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-4">
						<div class="box box-widget widget-user-2">
							<div class="widget-user-header bg-yellow">
								<h2 class="text-center ">라이선스 정보</h2>
							</div>
							<div class="box-body">
								<ul class="nav nav-stacked">
									<li><a href="#">채널 라이선스
										<span class="pull-right ">
											<span style="margin-right:15px;">
											<c:if test="${license.realtimeService eq 1 }">
												<i class="fa fa-check-square-o"></i>
											</c:if>
											<c:if test="${license.realtimeService eq 0 }">
												<i class="fa fa-square-o"></i>
											</c:if>
											 실시간</span>
											<c:if test="${license.nonrealtimeService eq 1 }">
												<i class="fa fa-check-square-o"></i>
											</c:if>
											<c:if test="${license.nonrealtimeService eq 0 }">
												<i class="fa fa-square-o"></i>
											</c:if> 
											 비실시간
										</span></a>
									</li>
									<li><a href="#">총 사용 채널<span class="pull-right badge bg-blue ">${license.realtimeChannel + license.nonrealtimeChannel }</span></a></li>
									<li><a href="#">실시간 분석채널 <span class="pull-right badge bg-aqua">${license.realtimeChannel }</span></a></li>
									<li><a href="#">비실시간 분석 채널<span class="pull-right badge bg-aqua">${license.nonrealtimeChannel }</span></a></li>
									<li><a href="#">서비스별 라이선스
										<span class="pull-right ">
											<span style="margin-right:15px;">
											<c:if test="${license.agentStress eq 1 }">
												<i class="fa fa-check-square-o"></i>
											</c:if>
											<c:if test="${license.agentStress eq 0 }">
												<i class="fa fa-square-o"></i>
											</c:if>
											 상담원</span>
											<c:if test="${license.customerStress eq 1 }">
												<i class="fa fa-check-square-o"></i>
											</c:if>
											<c:if test="${license.customerStress eq 0 }">
												<i class="fa fa-square-o"></i>
											</c:if> 
											 고객
										</span></a>
									</li>
								</ul>
							</div>
							<div class="box-footer">
								<a href="/system/license_update">
								<button type="button" class="btn btn-block btn-warning" >변경</button>
								</a>
							</div>
						</div>
					</div>

				</div>
			</section>
			<!-- /.content -->
</body>
</html>