<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp"%>
	<script type="text/javascript" src="/resources/highcharts/stock/highstock.js"></script>
	<script type="text/javascript" src="/resources/highcharts/stock/exporting.js"></script>
	
<script>

function linegraph(mdata){
	Highcharts.setOptions({
	    colors: ['#b6728e', '#6dc066', '#ff6666', '#66cdaa', '#f08080', 
	             '#ffc82e', '#ffb6c1','#11a51b', '#738b9a', '#7ac5cd',
	             '#4f90c1', '#222d4a','#9c3b30', '#db8e4e', '#dbbc5d',
	             '#ff8fcf', '#d11141','#6663bf', '#16f14b', '#d0a92b']
	});
   // Highcharts.chart('linegraph_display', {
    	Highcharts.stockChart('linegraph_display', {
    	chart: {
            type: 'spline'
    	},
	    title: {
	        text: ' '
	    },
	    subtitle: {
	    },
	    tooltip: {
	    	shared: true,
	        useHTML: true,
	        headerFormat: '<small>{point.x}</small><table>',
	        pointFormat: '<tr><td style="color: {series.color}">{series.name}: </td>' +
	            		  '<td style="text-align: right"><b>{point.y}</b></td></tr>',
	        footerFormat: '</table>',
	        valueDecimals:0
	    },
	    yAxis: {
	        title: {
	        	  text: ' ',
	        	  allowDecimals: false // 정수로만 표기
	        } 
	    },
	    xAxis: {
	    	labels: {  formatter: function () {return this.value;} },
	        // tickInterval: 2,
	         minPadding: 0.05,
	         maxPadding: 0.05
	    },
	    legend: {
	        layout: 'horizontal',
	        align: 'center',
	        verticalAlign: 'bottom'
	    },
	    plotOptions: {
	        series: {
	            pointStart: 0
	        },
	        line: {
                dataLabels: {
                    enabled: true
                }
            } 
	    },    
	    scrollbar: {
            enabled:true
	    },
	    rangeSelector: {
	        inputEnabled: false,
	        buttonTheme: {
	            visibility: 'hidden'
	        },
	        labelStyle: {
	            visibility: 'hidden'
	        }
	    },
	    /*
	    series: [{
	        data: [
	               ["0", 29.9],
	               ["1", 71.5],
	               ["7", 106.4]
	           ]
	       }]
	    */
	   series:mdata   
	}); 
	
}

	$(document).ready(function(){

		$.getJSON("https://"+location.host+"/report/linegraph?idx="+"${index}",
				  function(data) {
				      linegraph(data);
		});

	});
</script>

			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content modal-lg">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">
							콜 상세조회
						</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-4"> 
								<div class="info-box">
									<span class="info-box-icon bg-aqua"><i class="fa fa-user"></i></span>
									<div class="info-box-content">
										<span class="info-box-text">고객번호</span> 
										<span class="info-box-number" id="customerNumber">${callAnalysis.customerNumber }</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->

								<div class="info-box">
									<span class="info-box-icon bg-aqua"><i class="fa fa-headphones"></i></span>
									<div class="info-box-content">
										<span class="info-box-text" id="agentName">상담원 : ${callAnalysis.agentName }</span> 
										<span class="info-box-text" id="groupName">(${callAnalysis.groupId})</span> 
										<span class="info-box-number" id="agentNumber">${callAnalysis.agentNumber}</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->

								<div class="info-box">
									<span class="info-box-icon bg-aqua"><i class="fa fa-clock-o"></i></span>
									<div class="info-box-content">
										<span class="info-box-text">시작시간 / 통화시간</span> 
										<span class="info-box-number" id="startTime"><fmt:formatDate pattern="HH:mm:ss" value="${callAnalysis.startTime}" /> / ${callAnalysis.callDuration}초</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!--  
								<div class="col-md-12" style="height: 30px"></div>
								<div class="col-md-6">
									<span class="pull-left"> 
										<i class="fa fa-minus text-info"></i> 고객
									</span>
								</div>
								<div class="col-md-12" style="height: 30px"></div>
								<div class="col-md-6">
									<span class="pull-left"> 
										<i class="fa fa-minus" style="color:#de8162;"></i> 상담원
									</span>
								</div>
								-->
							</div>
							<!-- /.col -->

							<div class="col-md-8">
								<!-- LINE CHART -->
								<div class="row margin">
								<!-- 
									<canvas id="lineChart" style="height: 250px"></canvas>
									 -->
									 <!--  
									  <div id="linegraph_display"  style="margin-top:20px; margin-left:5px; width:560px; height:300px;"></div>
									  -->
									  <div id="linegraph_display"  style="margin-top:20px; margin-left:5px; width:560px; height:300px;"></div>
 								</div>
 								
 								<span class="col-md-12">
<!--  
									<audio id="audioPlayer" src="/resources/wav/${callAnalysis.mixedWavePath}" controls preload="auto"></audio>
-->									
								<!-- 
									<audio id="audioPlayer" src="/resources/wav/${fn:replace(callAnalysis.mixedWavePath, 'C:/home/mecs/PSNR/', '')}" controls preload="auto"></audio>
								-->
								</span>
								 
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					</div>
				</div>
				<!-- /.modal-content -->
				<form id="dummyforData" class="hide">
					<input id="callAnalysis_customerSegmentData" type="text" value="[${callAnalysis.customerSegmentData}]">
					<input id="callAnalysis_agentSegmentData" type="text" value="[${callAnalysis.agentSegmentData}]">
					<input id="callAnalysis_labelString" type="text" value="[${labelString}]">
				</form>
			</div>
