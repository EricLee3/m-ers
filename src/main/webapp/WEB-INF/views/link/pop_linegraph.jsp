<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="../include/taglib.jsp"%>
   		<script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
        <script type="text/javascript" src="/resources/highcharts/highcharts.js"></script>
        <script type="text/javascript" src="/resources/highcharts/exporting.js"></script>
        <script>
            $(function() {
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
                                    var series = this.series,
                                        name = "",
                                        val = 0,
//                                         attention = 0,
//                                         interest = 0,
//                                         desire = 0,
                                        angry = 0;
//                                         boredom = 0,
//                                         uncomfortable = 0,
//                                        stressCallee = 0,
//                                       energeticCallee = 0,
//                                        uncertain = 0,
//                                        concentration = 0,
//                                        dissatisfaction = 0,
//                                        stressCaller = 0,
//                                        energeticCaller = 0;
                                    refreshInterval = setInterval(function() {
                                        $.ajax({
                                            url: '/monitor/call_linegraph?agentId=' + '${agent_id}',
                                            success: function(data) {
                                                //var x = (new Date()).getTime(); // current time
                                                for (var i = 0; i < data.length; i++) {
                                                    dataArr = data[i].split(",");
                                                    name = dataArr[0];
                                                    val = dataArr[1];
                                                    
                                                    //if (name == "Attention") attention = val;
                                                    //if (name == "Interest") interest = val;
                                                    //if (name == "Desire") desire = val;
                                                    if (name == "Angry") angry = val;
                                                    //if (name == "Boredom") boredom = val;
                                                    //if (name == "Uncomfortable") uncomfortable = val;
                                                    //if (name == "StressCallee") stressCallee = val;
                                                    //if (name == "EnergeticCallee") energeticCallee = val;
                                                    //if (name == "Uncertain") uncertain = val;
                                                    //if (name == "Concentration") concentration = val;
                                                    //if (name == "Dissatisfaction") dissatisfaction = val;
                                                    //if (name == "StressCaller") stressCaller = val;
                                                    //if (name == "EnergeticCaller") energeticCaller = val;
                                                    
                                                }
                                            }
                                        })

                                        // x should be here because of the case returned fail  IOS[170717] 
                                        var x = (new Date()).getTime(); // current time

                                        //series[0].addPoint([x, parseInt(angry)], false, true);
                                        //series[1].addPoint([x, parseInt(stress)], true, true);

                                        //console.log("name : "+series[0].name + "-----" + "name : " + series[1].name);
                                        //console.log("data[0].x : "+series[0].data[0].x);
                                        //console.log("data[0].y : "+series[0].data[0].y);


                                        // static code for STM version only, requested by Cho E IOS[170711] 
                                        series[0].addPoint([x, parseInt(angry)			], true, true);
                                        //series[1].addPoint([x, parseInt(stressCallee)	], false, true);
                                        //series[2].addPoint([x, parseInt(energeticCallee)], false, true);
                                        //series[3].addPoint([x, parseInt(uncertain)		], false, true);
                                        //series[4].addPoint([x, parseInt(concentration)	], false, true);
                                        //series[5].addPoint([x, parseInt(dissatisfaction)], false, true);
                                        //series[6].addPoint([x, parseInt(stressCaller)	], false, true);
                                        //series[7].addPoint([x, parseInt(energeticCaller)], true,  true);
                                        
//                                         series[0].addPoint([x, parseInt(attention)], false, true);
//                                         series[1].addPoint([x, parseInt(interest)], false, true);
//                                         series[2].addPoint([x, parseInt(desire)], false, true);
//                                         series[4].addPoint([x, parseInt(boredom)], false, true);
//                                         series[5].addPoint([x, parseInt(uncomfortable)], false, true);

                                        angry = 0;
                                        //stressCallee = 0,
                                        //energeticCallee = 0,
                                        //uncertain = 0,
                                        //concentration = 0,
                                        //dissatisfaction = 0,
                                        //stressCaller = 0,
                                        //energeticCaller = 0;
                                    }, 1000);
                                }
                            }
                        },
                        title: {
                            text: ' '
                        },
                        xAxis: {
                            type: 'datetime',
                            tickPixelInterval: 150
                        },
                        yAxis: {
                            plotLines: [{
                                value: 0,
                                width: 1,
                                color: '#808080'
                            }]
                        },
                        tooltip: {
                            formatter: function() {
                                return '<b>' + this.series.name + '</b><br/>' +
                                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
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
                        navigator: {
                            enabled: false
                        },
                        series: [{
                            name: '화남',
                            data: (function() {
                                var data = [], time = (new Date()).getTime(), i;
                                for (i = -15; i <= 0; i++) {
                                    data.push({x: time + i * 1000, y: 0});
                                }
                                return data;
                            })()
                        }
//                         , {
//                             name: '불확실',
//                             data: (function() {
//                                 var data = [], time = (new Date()).getTime(), i;
//                                 for (i = -15; i <= 0; i++) {
//                                     data.push({x: time + i * 1000, y: 0
//                                     });
//                                 }
//                                 return data;
//                             })()
//                         }, {
//                             name: '집중',
//                             data: (function() {
//                                 var data = [], time = (new Date()).getTime(), i;
//                                 for (i = -15; i <= 0; i++) {
//                                     data.push({x: time + i * 1000, y: 0});
//                                 }
//                                 return data;
//                             }
//                            )()
                        ]
                    });
                });

            });
        </script>


                    <h4 class="modal-title" id="myModalLabel" style="text-align: center">실시간 감성지표</h4>
                <div>
                    <div class="row">
                        <div class="col-md-4">

                            <!-- /.info-box -->
                            <!--  
								<div class="col-md-6">
									<span class="pull-left"> 
										<i class="fa fa-minus text-primary"></i> 고객
									</span>
								</div>
								<div class="col-md-6">
									<!-- <button type="button" class="btn-default btn-xs pull-right">
										<i class="fa fa-play"></i>
									</button> 
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
                                <!--  <canvas id="lineChart" style="height: 250px"></canvas>-->
                                <div id="linegraph_display" style="margin-top:20px; margin-left:5px; width:560px; height:300px;"></div>
                                <!--  
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
           
                            </div>
                
							<div class="info-box" style="text-align: left; margin-left: 20px;">
                                <span class="info-box-icon bg-aqua"><i class="fa fa-user"></i></span>
                                <div class="info-box-content">
                                    <span class="info-box-text">고객번호 : </span>
                                    <span class="info-box-number" id="customerNumber">${custom_num} &nbsp;&nbsp;</span>
                                    <br>
                                  	<span class="info-box-text">상담원 : ${agent_id}&nbsp;&nbsp;</span> 
                                  	<br>
                                  	<span class="info-box-text">시작시간 : ${time}</span>
                                </div>
                            </div>
