<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp"%>
	<script type="text/javascript" src="/resources/highcharts/highcharts.js"></script>
	<script type="text/javascript" src="/resources/highcharts/exporting.js"></script>
<script>
	$(function () {
	    $(document).ready(function() {
	        Highcharts.setOptions({
	            global: {
	                useUTC: false
	            }
	        });
	    
	        $('#linegraph_display').highcharts({
	            chart: {
	                type: 'spline',
	                animation: Highcharts.svg, // don't animate in old IE
	                marginRight: 10,
	                events: {
	                    load: function() {
	                        // set up the updating of the chart each second
	                        var series = this.series[0];
	                        var series2 = this.series[1];
	                        var attention = 0;
                        	var desire = 0;
	                       refreshInterval= setInterval(function() {
	                        	
	                        	 $.ajax({
	                                 url:'/monitor/call_linegraph?agentId='+'${agentId}',
	                                 success:function(data){
										
										attention=data[0];
										desire=data[1];
	                                 }
	                             })
	                            var x = (new Date()).getTime(); // current time
	                                //a = Math.random();
	                                //d = Math.random();
	                                  a = attention;
	                                  d = desire;
	                                //  alert(a+":::"+d);
	                            series.addPoint([x, a], false, true)
	                            series2.addPoint([x,d], true, true);
	                        }, 1000);
	                    }
	                }
	            },	            
	            title: {
	                text: ' ' 
	            },
	             subtitle: {
	                text: ' '
	            },
	            xAxis: {
	                title:{
	                    text:' '  /*X 축 라벨*/
	                    },
	                type: 'datetime',
	                tickPixelInterval: 150
	            },
	            yAxis: {
	                title: {
	                    text: ' '  /*y축 라벨*/
	                },
	                plotLines: [{
	                    value: 0,
	                    width: 1,
	                    color: '#808080'
	                }]
	            },
	            tooltip: {
	                formatter: function() {
	                        return '<b>'+ this.series.name +'</b><br/>'+
	                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
	                        Highcharts.numberFormat(this.y, 2);
	                }
	            },
	            legend: {
	            	layout: 'horizontal',
	    	        align: 'center',
	    	        verticalAlign: 'bottom'
	            },
	            exporting: {
	                enabled: false
	            },
	            series: [   
	             {
	                name: '디자이어',
	                data: (function() {
	                    // generate an array of random data
	                    var data = [],
	                        time = (new Date()).getTime(),
	                        i;
	                    
	                    for (i = -15; i <= 0; i++) {
	                        data.push({
	                            x: time + i * 1000,
	                            y: 0
	                            //y: Math.random()
	                        });
	                    }
	                    return data;
	                })()
	            },
	            {
	                name: '어텐션',
	                data: (function() {
	                    // generate an array of random data
	                    var data = [],
	                        time = (new Date()).getTime(),
	                        i;
	                    
	                    for (i = -15; i <= 0; i++) {
	                        data.push({
	                            x: time + i * 1000,
	                            y: 0
	                           // y: Math.random()
	                        });
	                    }
	                    return data;
	                })()
	            }
	            ]
	        });
	    });
	    
	});



</script>

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
									<span class="info-box-icon bg-aqua"><i class="fa fa-user"></i></span>
									<div class="info-box-content">
										<span class="info-box-text">고객번호</span> 
										<span class="info-box-number" id="customerNumber">${callAudit.customerNumber }</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->

								<div class="info-box">
									<span class="info-box-icon bg-aqua"><i class="fa fa-headphones"></i></span>
									<div class="info-box-content">
										<span class="info-box-text" id="agentName">상담원 : ${callAudit.agentName }</span> 
										<span class="info-box-text" id="groupName">(${callAudit.groupName})</span> 
										<span class="info-box-number" id="agentNumber">${callAudit.agentNumber}</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->

								<div class="info-box">
									<span class="info-box-icon bg-aqua"><i class="fa fa-clock-o"></i></span>
									<div class="info-box-content" id="div_call_view">
										<span class="info-box-text">시작시간 / 통화시간</span> 
										<span class="info-box-number" id="startTime"><fmt:formatDate pattern="HH:mm:ss" value="${callAudit.startTime}" /> / ${callAudit.callDuration}초</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->
								<div class="col-md-6">
									<span class="pull-left"> 
										<i class="fa fa-minus text-primary"></i> 고객
									</span>
								</div>
								<div class="col-md-6">
									<!-- <button type="button" class="btn-default btn-xs pull-right">
										<i class="fa fa-play"></i>
									</button> -->
								</div>
								<div class="col-md-12" style="height: 30px"></div>
								<div class="col-md-6">
									<span class="pull-left"> 
										<i class="fa fa-minus" style="color:#de8162;"></i> 상담원
									</span>
								</div>
							</div>
							<!-- /.col -->

							<div class="col-md-8">
								<!-- LINE CHART -->
								<div class="row margin">
									<!--  <canvas id="lineChart" style="height: 250px"></canvas>-->
									<div id="linegraph_display"  style="margin-top:20px; margin-left:5px; width:560px; height:300px;"></div>
									
									<span class="col-md-12">
										<audio id="audioPlayer1" src="/resources/wav/${fn:replace(callAudit.customerWavePath, '/home/mecs/PSNR/', '')}" controls preload="auto" ></audio>
										<audio id="audioPlayer2" src="/resources/wav/${fn:replace(callAudit.agentWavePath, '/home/mecs/PSNR/', '')}" controls preload="auto" ></audio>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					</div>
				</div>
				<!-- /.modal-content -->
				<form id="dummyforData" class="hide">
					<input id='callStartTime' type='text' value='<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${callAudit.startTime}" />'>
				</form>
			</div>
