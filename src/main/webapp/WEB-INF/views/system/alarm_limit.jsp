<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>VoiceCream / 미래손 감정분석 솔루션</title>

<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/font-awesome.min.css">
<link rel="stylesheet" href="/resources/css/ionicons.min.css">
<link rel="stylesheet"
	href="/resources/plugins/bootstrap-slider/slider.css">
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
<script>
$(document).ready(function(){
	if("${searchQuery}" != null && "${searchQuery}" != '') $("select[name=searchQuery]").val("${searchQuery}").attr("selected","selected");
});
</script>

<style type="text/css">
#critical .slider-selection {
	background: #FF0000;
}

#major .slider-selection {
	background: #ff8c00;
}

#minor .slider-selection {
	background: #ffd900;
}
</style>

</head>

<body class="hold-transition skin-blue sidebar-mini">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			<h2>
				<small>시스템 ></small> 알람 임계치 설정
			</h2>
			</section>

			<!-- Main content -->
			<section class="content">

			<div class="row">
				<div class="col-xs-12">
					<div class="box box-info">
						<p><br>
						<!-- <form class="form-horizontal" role="form" id="form_alarmLimit_search" action="" method="get">
								<div class="form-group">
									<label for="alarmIdx" class="col-sm-2 control-label" style="padding-left:160px;">시스템 자원  </label>
									<div class="col-sm-9" style="padding-left:110px;">
			  							<select  tabindex="2" id="searchQuery" name="searchQuery" onchange="alarmSearch(this.value);">
			                              <option value="0" selected="selected">CPU</option>
			                              <option value="1">DISK</option>
			                              <option value="2">MEMORY</option>
			                           </select>
									</div>
									<div class="col-sm-1"></div>
								</div>
						</form> -->
						<form class="form-horizontal" id="form_alarmLimit_update" action="">
							<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
							<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
							<c:forEach items="${recognitionAlarmLimit}" var="recognitionAlarmLimit">
								<div class="form-group">
									<input type="hidden" name="alarmId" value="forTest"> <label
										for="inputEmail3" class="col-sm-2 control-label"></label>
									<input type="hidden" id = "alarmIdx1" name="alarmIdx1" value="">
									<div class="col-sm-10">
										<label for="inputEmail3"></label>
									</div>
								</div>
								
								<div class="form-group">
									<label for="alarmIdx" class="col-sm-2 control-label" style="padding-left:160px;">시스템 자원  </label>
									<div class="col-sm-9" style="padding-left:110px;">
										<c:choose>
										    <c:when test="${recognitionAlarmLimit.alarmIdx eq '0'}"><b>CPU</b></c:when>
										    <c:when test="${recognitionAlarmLimit.alarmIdx eq '1'}"><b>DISK</b></c:when>
										    <c:otherwise><b>MEMORY</b></c:otherwise>
										</c:choose>
									</div>
									<div class="col-sm-1"></div>
								</div>
								
								<div class="form-group">
									<label for="criticalValue" class="col-sm-2 control-label">CRITICAL</label>
									<div class="col-sm-1 text-right">0</div>
									<div class="col-sm-8">
										<input type="hidden" name="alarmIdx" value="${recognitionAlarmLimit.alarmIdx}">
										<input type="text" id="criticalValue" name="criticalValue"
											value="" class="slider form-control" data-slider-min="0"
											data-slider-max="100"
											data-slider-value="${recognitionAlarmLimit.cpuCri }"
											data-slider-orientation="horizontal"
											data-slider-selection="before" data-slider-tooltip="always"
											data-slider-id="critical" />
									</div>
									<div class="col-sm-1">100</div>
								</div>
								<div class="form-group"></div>
								<div class="form-group">
									<label for="majorValue" class="col-sm-2 control-label">MAJOR</label>
									<div class="col-sm-1 text-right">0</div>
									<div class="col-sm-8">
										<input type="text" id="majorValue" name="majorValue" value=""
											class="slider form-control" data-slider-min="0"
											data-slider-max="100"
											data-slider-value="${recognitionAlarmLimit.cpuMajor}"
											data-slider-orientation="horizontal"
											data-slider-selection="before" data-slider-tooltip="always"
											data-slider-id="major" />
									</div>
									<div class="col-sm-1">100</div>
								</div>

								<div class="form-group"></div>
								<div class="form-group">
									<label for="minorValue" class="col-sm-2 control-label">MINOR</label>
									<div class="col-sm-1 text-right">0</div>
									<div class="col-sm-8">
										<input type="text" id="minorValue" name="minorValue" value=""
											class="slider form-control" data-slider-min="0"
											data-slider-max="100" data-slider-step="1"
											data-slider-value="${recognitionAlarmLimit.cpuMinor}"
											data-slider-orientation="horizontal"
											data-slider-selection="before" data-slider-tooltip="always"
											data-slider-id="minor">
									</div>
									<div class="col-sm-1">100</div>
								</div>
								<input type="hidden" name="cri" id="cri" value="${recognitionAlarmLimit.cpuCri }">
								<input type="hidden" name="mj" id="mj" value="${recognitionAlarmLimit.cpuMajor }">
								<input type="hidden" name="mi" id="mi" value="${recognitionAlarmLimit.cpuMinor }">
								<input type="hidden" name="idx" id="idx" value="${recognitionAlarmLimit.alarmIdx}">
							</c:forEach>
								<div class="col-sm-12 text-center" >
									<button type="button" class="jsUpdate btn btn-info">설정 값 적용</button>
										<p><br>
								</div>
								
								<div class="form-group"></div>
							</div>
						</form>
						
						
				
					</div>
				</div>
				<!-- /.col -->

			</div>
			<!-- /.row --> 
			</section>

	<script>
		var valueChanged = false;
		$(document).ready(function() {
			/* BOOTSTRAP SLIDER */
			$(function() {
				$('.slider').slider();
			});

			$(document).on("change", ".slider", function(e) {
				e.preventDefault();
				valueChanged = true;
			});

			$(document).on('click', '.jsUpdate', function(e) {
				e.preventDefault();
				var update_flag = "";
				var alarmIdx =$("#searchQuery").val();
				var test1=$("#alarmIdx").val();
				
				var cval = $("#criticalValue").val();
				cval *= 1;
				var maval = $("#majorValue").val();
				maval *= 1;
				var mival = $("#minorValue").val();
				mival *= 1;
				
				var cri = $("#cri").val();
				var mj = $("#mj").val();
				var mi = $("#mi").val();
				
				if(cval < maval) {
					alert("MAJOR_VALUE가 CRITICAL_VALUE보다 클 수 없습니다.");
					update_flag = 0;
					$("#criticalValue").val (cri);
					$("#criticalValue").slider ("refresh");
					$("#majorValue").val (mj);
					$("#majorValue").slider ("refresh");
					return false;
				}else{
					update_flag = 1;
				}
				
				if(cval < mival) {
					alert("MINOR_VALUE가 CRITICAL_VALUE보다 클 수 없습니다.");
					update_flag = 0;
					$("#minorValue").val (mi);
					$("#minorValue").slider ("refresh");
					$("#criticalValue").val(cri);
					$("#criticalValue").slider ("refresh");
					return false;
				}else{
					update_flag = 1;
				}
				
				if(maval < mival) {
					alert("MINOR_VALUE가 MAJOR_VALUE보다 클 수 없습니다.");
					update_flag = 0;
					$("#minorValue").val (mi);
					$("#minorValue").slider ("refresh");
					$("#majorValue").val (mj);
					$("#majorValue").slider ("refresh");
					return false;
				}else{
					update_flag = 1;
				}
				
				if(update_flag == 1){
					
					$("#form_alarmLimit_update").attr("METHOD", "POST");			
					$("#form_alarmLimit_update").submit();
				}
	
			});
			
			<c:forEach items="${recognitionAlarmLimit}" var="recognitionAlarmLimit">
		    $("#form_alarmLimit_search").find("#searchQuery option[value='${recognitionAlarmLimit.alarmIdx}']").attr("selected", "selected");
		    </c:forEach>
		});
		//검색
		  function alarmSearch(alarmdate) {
		         var searchQuery = $("#searchQuery").val();

		         var regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-+<>@\#$%&\\\=\(\'\"]/gi;
		         searchQuery = searchQuery.replace(regExp, "");
		         document.getElementById("searchQuery").value = searchQuery;
		         $("#form_alarmLimit_search").submit();
		      }
	</script>
</body>
</html>