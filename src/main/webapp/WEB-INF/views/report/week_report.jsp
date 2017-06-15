<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
	<link rel="stylesheet" href="/resources/plugins/datatables/dataTables.bootstrap.css">
	<link rel="stylesheet" href="/resources/plugins/ionslider/ion.rangeSlider.css">
	<link rel="stylesheet" href="/resources/plugins/ionslider/ion.rangeSlider.skinHTML5.css">
	<link rel="stylesheet" href="/resources/plugins/datepicker/datepicker3.css">
	<link rel="stylesheet" href="/resources/plugins/morris/morris.css">
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	<script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="/resources/plugins/fastclick/fastclick.js"></script>
	<script src="/resources/js/app.min.js"></script>
	<script src="/resources/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script src="/resources/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="/resources/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script src="/resources/plugins/chartjs/Chart.min.js"></script>
	<script src="/resources/plugins/ionslider/ion.rangeSlider.min.js"></script>
	<script src="/resources/plugins/raphael/raphael-min.js"></script>
	<script src="/resources/plugins/morris/morris.min.js"></script>
</head>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<%@include file="../include/header.jsp"%>
		<%@include file="../include/sidebar.jsp"%>

		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h2>통계 > 주간별 통계</h2>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box box-success">
							<div class="box-header">
								<h3 class="box-title">조회</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">

								<!-- 검색 조건 -->
								<form role="form" id="form_weekReport_search" action="" mehtod="post">
									<input type="hidden" id="checkDatepicker" value="false">
									<div class="col-md-2">
										<div class="form-group">
											<select class="form-control" id="selectAgentGroup" name="agentGruopId">
												<option value="noGroup">--그룹 선택--</option>
												<c:forEach items="${agentGroupList}" var="agentGroup">	
												<option value="${agentGroup.groupId }">${agentGroup.groupName }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<select class="form-control" id="selectAgent" name="agentId">
												<option value='noAgent'>그룹을 선택하세요</option>
											</select>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<div class="input-group date">
												<div class="input-group-addon">
													<i class="fa fa-calendar"></i>
												</div>
												<input type="text" class="form-control pull-right" id="datepicker" placeholder="시작일">
											</div>
										</div>
									</div>
									<div class="col-md-2">
											<div class="form-group">
												<div class="input-group date">
													<div class="input-group-addon">
														<i class="fa fa-calendar"></i>
													</div>
													<input type="text" class="form-control pull-right" id="datepicker2" placeholder="종료일" value="">
												</div>
											</div>
									</div>
									<div class="col-md-2">
										<button type="button" class="jsSearch btn btn-info">조회</button>
									</div>
								</form>
								<!-- /. 검색 조건 -->

								<div class="col-md-12">
									<!-- BAR CHART -->
									<div class="box box-default">
										<div class="box-header with-border">
											<h3 class="box-title">16/08/22 ~ 16/08/27 주간별 감정분석 리포트</h3>
										</div>
										<div class="box-body chart-responsive">
											<div class="chart" id="line-chart" style="height: 300px;"></div>
										</div>
										<div class="box-footer clearfix">
											<span class="pull-right"> 
												<i class="fa fa-minus" style="color: #de8162;"></i> Anger Call수 
												<i class="fa fa-minus" style="color: #e7cd64;"></i> Stress Call수
											</span>
										</div>
									</div>
								</div>

								<table id="example1" class="table table-bordered table-striped">
									<thead>
										<tr>
											<th class="no-sort">상담원</th>
											<th class="no-sort">그룹</th>
											<th class="no-sort">요일</th>
											<th class="no-sort">상담 Call수</th>
											<th class="no-sort">Anger</th>
											<th class="no-sort">Stress</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>전체</td>
											<td>전체</td>
											<td>16/08/22 (월)</td>
											<td>1,250</td>
											<td><span class="text-danger">100</span></td>
											<td><span class="text-info">30</span></td>
										</tr>
										<tr>
											<td>전체</td>
											<td>전체</td>
											<td>16/08/23 (화)</td>
											<td>1,250</td>
											<td><span class="text-danger">100</span></td>
											<td><span class="text-info">30</span></td>
										</tr>
										<tr>
											<td>전체</td>
											<td>전체</td>
											<td>16/08/24 (수)</td>
											<td>1,250</td>
											<td><span class="text-danger">100</span></td>
											<td><span class="text-info">30</span></td>
										</tr>
										<tr>
											<td>전체</td>
											<td>전체</td>
											<td>16/08/25 (목)</td>
											<td>1,250</td>
											<td><span class="text-danger">100</span></td>
											<td><span class="text-info">30</span></td>
										</tr>
										<tr>
											<td>전체</td>
											<td>전체</td>
											<td>16/08/26 (금)</td>
											<td>1,250</td>
											<td><span class="text-danger">100</span></td>
											<td><span class="text-info">30</span></td>
										</tr>
										<tr>
											<td>전체</td>
											<td>전체</td>
											<td>16/08/27 (토)</td>
											<td>1,250</td>
											<td><span class="text-danger">100</span></td>
											<td><span class="text-info">30</span></td>
										</tr>

									</tbody>

								</table>
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
		</div>
		<!-- /.content-wrapper -->
		
		<%@include file="../include/footer.jsp"%>
		
		<!-- Modal 콜 상세 조회 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content modal-lg">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">콜 상세조회</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-4">
								<div class="info-box">
									<span class="info-box-icon bg-aqua">
										<i class="fa fa-user"></i>
									</span>
									<div class="info-box-content">
										<span class="info-box-text">고객번호</span> 
										<span class="info-box-number">056-632-2317</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->

								<div class="info-box">
									<span class="info-box-icon bg-aqua">
										<i class="fa fa-headphones"></i>
									</span>
									<div class="info-box-content">
										<span class="info-box-text">상담원 : 김영희</span> 
										<span class="info-box-text">(고객응대 1팀)</span> 
										<span class="info-box-number">3005</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->

								<div class="info-box">
									<span class="info-box-icon bg-aqua">
										<i class="fa fa-clock-o"></i>
									</span>
									<div class="info-box-content">
										<span class="info-box-text">시작시간 / 통화시간</span> 
										<span class="info-box-number">14:08 / 03:00</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->
								<span class="pull-left"> 
									<i class="fa fa-minus text-primary"></i> 고객 
									<i class="fa fa-minus text-gray"></i> 상담원
								</span>
								<button type="button" class="btn-default btn-xs pull-right">
									<i class="fa fa-play"></i>
								</button>

							</div>
							<!-- /.col -->

							<div class="col-md-8">
								<!-- LINE CHART -->
								<div class="row margin">
									<canvas id="lineChart" style="height: 250px"></canvas>
									<input id="range_1" type="text" name="range_1" value="">
								</div>
								<!-- /.box-body -->
								<!-- /.box -->
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>

	</div>
	
<script>
$(document).ready(function(){
	$(document).on("change", "#selectAgentGroup", function(){
		var agentGroupId = $("#selectAgentGroup").val();
		if(agentGroupId != "noGroup") {
			$.ajax({
				url : "/REST/agent/listAgent/" +agentGroupId,
			}).done(function(resultList){
				$("#selectAgent").empty();
				if( resultList != null ) {
					$.each(resultList, function (index, agent){
						$("#selectAgent").append("<option value='"+agent.agentId+"'>"+agent.agentName+"</option>");
					});	
				}
			});
		} else {
			$("#selectAgent").empty().append("<option value='noAgent'>그룹을 선택하세요</option>");
		} 	
	});
});	

$(function () {
    $('#example1').DataTable({
      "paging": false,
      "lengthChange": false,
      "iDisplayLength": 20,
      "searching": false,
      "ordering": false,
      "info": true,
      "autoWidth": false,
      "order": [],
      "columnDefs": [ {
        "targets"  : 'no-sort',
        "orderable": false,
      }]
    });

    /* ChartJS
     * -------
     * Here we will create a few charts using ChartJS
     */

    //--------------
    //- AREA CHART -
    //--------------

    // Get context with jQuery - using jQuery's .get() method.
    // var areaChartCanvas = $("#areaChart").get(0).getContext("2d");
    // This will get the first returned node in the jQuery collection.
    // var areaChart = new Chart(areaChartCanvas);

    var areaChartData = {
      labels: ["00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00"],
      datasets: [
        {
          label: "Electronics",
          fillColor: "rgba(210, 214, 222, 1)",
          strokeColor: "rgba(210, 214, 222, 1)",
          pointColor: "rgba(210, 214, 222, 1)",
          pointStrokeColor: "#c1c7d1",
          pointHighlightFill: "#fff",
          pointHighlightStroke: "rgba(220,220,220,1)",
          data: [65, 59, 80, 81, 56, 55, 40]
        },
        {
          label: "Digital Goods",
          fillColor: "rgba(60,141,188,0.9)",
          strokeColor: "rgba(60,141,188,0.8)",
          pointColor: "#3b8bba",
          pointStrokeColor: "rgba(60,141,188,1)",
          pointHighlightFill: "#fff",
          pointHighlightStroke: "rgba(60,141,188,1)",
          data: [28, 48, 40, 19, 86, 27, 90]
        }
      ]
    };

    var areaChartOptions = {
      //Boolean - If we should show the scale at all
      showScale: true,
      //Boolean - Whether grid lines are shown across the chart
      scaleShowGridLines: false,
      //String - Colour of the grid lines
      scaleGridLineColor: "rgba(0,0,0,.05)",
      //Number - Width of the grid lines
      scaleGridLineWidth: 1,
      //Boolean - Whether to show horizontal lines (except X axis)
      scaleShowHorizontalLines: true,
      //Boolean - Whether to show vertical lines (except Y axis)
      scaleShowVerticalLines: true,
      //Boolean - Whether the line is curved between points
      bezierCurve: true,
      //Number - Tension of the bezier curve between points
      bezierCurveTension: 0.3,
      //Boolean - Whether to show a dot for each point
      pointDot: false,
      //Number - Radius of each point dot in pixels
      pointDotRadius: 4,
      //Number - Pixel width of point dot stroke
      pointDotStrokeWidth: 1,
      //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
      pointHitDetectionRadius: 20,
      //Boolean - Whether to show a stroke for datasets
      datasetStroke: true,
      //Number - Pixel width of dataset stroke
      datasetStrokeWidth: 2,
      //Boolean - Whether to fill the dataset with a color
      datasetFill: true,
      //String - A legend template
      legendTemplate: "",
      //Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
      maintainAspectRatio: true,
      //Boolean - whether to make the chart responsive to window resizing
      responsive: true
    };

    //Create the line chart
    //areaChart.Line(areaChartData, areaChartOptions);

    //-------------
    //- LINE CHART -
    //--------------
    $('#myModal').on('shown.bs.modal', function (e) {
    var lineChartCanvas = $("#lineChart").get(0).getContext("2d");
    var lineChart = new Chart(lineChartCanvas);
    var lineChartOptions = areaChartOptions;
    lineChartOptions.datasetFill = false;
    lineChart.Line(areaChartData, lineChartOptions);
    });

    /* ION SLIDER */
    $("#range_1").ionRangeSlider({
      min: 0,
      max: 180,
      from: 0,
      to: 180,
      type: 'single',
      step: 1,
      postfix: "초",
      prettify: false,
      hasGrid: true
    });

    //LINE CHART
    var line = new Morris.Line({
      element: 'line-chart',
      resize: true,
      data: [
        {y: '08/22', a: 120, b: 30, c: 4, d: 7, e: 12},
        {y: '08/23', a: 145, b: 45, c: 2, d: 4, e: 9},
        {y: '08/24', a: 80, b: 23, c: 0, d: 6, e: 7},
        {y: '08/25', a: 98, b: 14, c: 2, d: 5, e: 10},
        {y: '08/26', a: 70, b: 27, c: 5, d: 5, e: 14},
        {y: '08/27', a: 126, b: 30, c: 0, d: 0, e: 0}
      ],
      lineColors: ['#de8162', '#e7cd64'],
      xkey: 'y',
      ykeys: ['a', 'b'],
      labels: ['Anger Call', 'Stress Call'],
      parseTime: false,
      hideHover: 'auto'
    });

    //Date picker
    $('#datepicker').datepicker({
      autoclose: true
    });
    
    $('#datepicker2').datepicker({
        autoclose: true
    });
    
  	//달력(시작일,종료일)에서 .day(일)를 클릭했을때마다 실행되는 스크립트 입니다.
    $(document).on('click', '.day', function(e){
    	e.preventDefault();
    	checkDatepicker();
    });
  	
    /* jsSearch
     * 일별 조회를 위한 스크립트 입니다. 
     */
    $(document).on("click", ".jsSearch", function(e){
    	e.preventDefault();
		
    	if ($.trim($("#datepicker").val()).length < 1 || $.trim($("#datepicker2").val()).length < 1 || $("#checkDatepicker").val()=="false"){
    		alert("종료월은 시작월과 같거나 이후의 날짜로 입력되어야 합니다.");
			$("#datepicker2").focus();
    		return false;
    	}
    	
    });
    
});

	/* 시작일과 종료일을 비교하기 위한 함수입니다.
	 * 시작일  > 종료일, 종료일 < 시작일 일때 경고창을 띄어 줍니다.
	 */
	function checkDatepicker() {
		
		var datepicker = $("#datepicker").val();
	    var datepicker2 = $("#datepicker2").val();
	             
	    var startDateCompare = new Date(datepicker);
	    var endDateCompare = new Date(datepicker2);
	     
	    if(datepicker != "" && datepicker2 != ""){
		    if(startDateCompare.getTime() > endDateCompare.getTime()) {
		        alert("종료월은 시작월과 같거나 이후의 날짜로 입력되어야 합니다.");
		        $("#datepicker2").val("");
		        $("#datepicker2").focus();
		        $("#checkDatepicker").val("false");
		    }else{
		    	$("#checkDatepicker").val("true");
		    }
	    }
	
	}
</script>

</body>
</html>