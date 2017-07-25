<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="../include/taglib.jsp"%>
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
            <script src="/resources/plugins/datatables/jquery.dataTables.min.js"></script>
            <script src="/resources/plugins/datatables/dataTables.bootstrap.min.js"></script>
            <script src="/resources/plugins/chartjs/Chart.min.js"></script>
            <script src="/resources/plugins/ionslider/ion.rangeSlider.min.js"></script>
            <script src="/resources/plugins/raphael/raphael-min.js"></script>
            <script src="/resources/plugins/morris/morris.min.js"></script>
            <script>
                $(document).ready(function() {
                    if ("${searchBoardIndex}" != null && "${searchBoardIndex}" != '') $("select[name=searchBoardIndex1]").val("${searchBoardIndex}").attr("selected", "selected");
                    if ("${searchId}" != null && "${searchId}" != '') $("select[name=searchId]").val("${searchId}").attr("selected", "selected");
                    if ("${searchQuery}" != null && "${searchQuery}" != '') $("select[name=searchQuery]").val("${searchQuery}").attr("selected", "selected");
                });
            </script>
        </head>

        <body class="hold-transition skin-blue sidebar-mini" id="test_tr">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h2><small>모니터 ></small> 모니터링</h2>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row" style="height: 800px;">
                    <div class="col-xs-12">
                        <div class="box box-primary">
                            <div class="box-header">
                                <h3 class="box-title">모니터링</h3>
                            </div>
                            <div class="box-body table-responsive no-padding">
                                <form role="form" id="form_conf_search" action="" method="get">
                                    <input type="hidden" name="page" value="" />
                                    <input type="hidden" name="searchBoardIndex" id="searchBoardIndex" value="" />
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <select class="form-control" id="searchId" name="searchId">
												<option value="">그룹선택</option>
												<c:forEach items="${groupList}" var="group">
													<option value="${group.groupName}">${group.groupName}</option>
												</c:forEach>
											</select>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <select class="form-control" id="searchQuery" name="searchQuery">
												<option value="">상담원선택</option>
												<c:forEach items="${agentList}" var="agent">
													<option value="${agent.agentName}">${agent.agentName}</option>
												</c:forEach>
											</select>
                                        </div>
                                    </div>

                                    <div class="col-md-2 hidden-print">
                                        <button type="button" class="jsSearch btn btn-info">모니터링</button>
                                    </div>
                                    <%--
									<button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#myModal" style="margin-right: 10px;">등록</button>
									--%>
                                </form>

                                <!-- table hovering disabled IOS -->
                                <!-- <table class="table table-hover"> -->
                                <table class="table ">
                                    <thead>
                                        <tr>
                                            <th class="col-sm-1">상담원 그룹</th>
                                            <th class="col-sm-1">상담원</th>
                                            <th class="col-sm-1">내선번호</th>
                                            <th class="col-sm-1">구분</th>
                                            <th class="col-sm-1">프로파일</th>
                                            <th class="col-sm-1">스크립트</th>
                                            <th class="col-sm-1">상세조회</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${realStatList}" var="real">
                                            <tr>
                                                <td rowspan="2">${real.groupName }</td>
                                                <td rowspan="2">${real.agentName }</td>
                                                <td rowspan="2">${real.agentNumber }</td>
                                                <td>고객</td>
                                                <td>${real.customerProfileName }</td>
                                                <td>${real.customerScript }</td>
                                                <td class="hidden-print" rowspan="2">
                                                    <button type="button" class="jsShowModal btn btn-default btn-xs" data-index="${real.agentId }">
												<i class="fa fa-headphones"></i> 
											</button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>상담사</td>
                                                <td>${real.agentProfileName }</td>
                                                <td>${real.agentScript }</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="box-footer clearfix text-center">

                                <%-- <ul class="pagination pagination-sm no-margin">
									<asnetPage:Pagination 
										page="${pageDTO.page }" 
										itemPerPage="${pageDTO.itemPerPage }" 
										pagePerGroup="${pageDTO.pagePerGroup }" 
										itemCount="${SensConfCount }" 
									/>
								</ul> --%>
                                    <!-- <button type="button" class="btn btn-default pull-right hidden-print" onclick="print()"><i class="fa fa-print"></i><small> 인쇄</small></button> -->
                                    <!-- <button type="button" class="btn btn-info pull-right margin-r-5 hidden-print"><i class="fa fa-file-excel-o"></i></button> -->
                            </div>
                            <form role="form" id="form_conf_search" action="" method="get">
                                <input type="hidden" name="page" value="" />
                                <input type="hidden" name="searchBoardIndex" id="searchBoardIndex" value="" />
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
                            </form>
                        </div>
                    </div>
                </div>
            </section>
            <!-- /.content -->

            <!-- Modal 콜 상세 조회 -->
            <div class="modal fade" id="modalCallDetail" tabindex="-1" role="dialog" aria-labelledby=""></div>

            <script>
                var mainTimer;
                var modalTimer;
                var refreshAudioTimer1;
                var refreshAudioTimer2;
                var durationTime1;
                var durationTime2;
                var audioPresentTime1;
                var audioPresentTime2;
                var reloadAudioTimer1;
                var reloadAudioTimer2;
                var isFirstTimePlayAudio1 = true;
                var isFirstTimePlayAudio2 = true;
                var isInitializeAudio1 = false;
                var isInitializeAudio2 = false;
                var audioReloadTime = 30; // 오디오 파일 로딩 주기. 단위는 초.
                var gapSecond1;
                var gapSecond2;
                var thisAgentId = "";
                var lineChart;
                var isModalShow = false;

                var isAudio1Play = false;
                var isAudio2Play = false;

                var lineChartCanvas;
                var lineChartOption = {
                    scales: {
                        xAxes: [{
                            gridLines: {
                                display: false
                            }
                        }]
                    },
                    legend: {
                        position: "bottom"
                    },
                    showScale: true,
                    pointDot: false,
                    pointDotRadius: 3,
                    pointDotStrokeWidth: 1,
                    pointHitDetectionRadius: 20,
                    maintainAspectRatio: true,
                    responsive: true,
                    animation: false
                };

                var lineChartData = {
                    labels: ['00:00', '', '', '', '', '', '', '', '', ''],
                    datasets: [{
                        label: "Stress",
                        borderColor: "rgba(222, 129, 98, 1)",
                        backgroundColor: "rgba(222, 129, 98, 1)",
                        pointBorderColor: "rgba(222, 129, 98, 1)",
                        pointRadius: 2,
                        pointHoverRadius: 4,
                        pointStrokeColor: "#c1c7d1",
                        pointHighlightFill: "#fff",
                        fill: false,
                        pointHoverBackgroundColor: "rgba(220,220,220,1)",
                        data: [0]
                    }, {
                        label: "Angry",
                        borderColor: "rgba(60,141,188,0.9)",
                        backgroundColor: "rgba(60,141,188,0.9)",
                        pointBorderColor: "#3b8bba",
                        pointRadius: 2,
                        pointHoverRadius: 4,
                        pointStrokeColor: "rgba(60,141,188,1)",
                        pointHighlightFill: "#fff",
                        fill: false,
                        pointHoverBackgroundColor: "rgba(60,141,188,1)",
                        data: [0]
                    }]
                };
                $(document).ready(function() {
                    //검색
                    $(document).on("click", ".jsSearch", function(e) {
                        e.preventDefault();
                        document.getElementById("searchBoardIndex").value = $("#searchBoardIndex1").val();
                        document.getElementById("searchId").value = $("#searchId").val();
                        document.getElementById("searchQuery").value = $("#searchQuery").val();

                        $("#form_conf_search").submit();
                    });

                    // timer settings	
                    //mainTimer = window.setInterval(updateCallList, 15000); //5000);
                    modalTimer = window.setInterval(updateChartData, 3000);
                    refreshAudioTimer1 = window.setInterval(audioPlayer1Callback, 3000);
                    refreshAudioTimer2 = window.setInterval(audioPlayer2Callback, 3000);

                    function updateCallList() {
                        if (isModalShow == true) return;
                        //		$("#div_call_list").load("/monitor/call_list_refresh", function( response, status, xhr ) {
                        $("#test_tr").load("/monitor/call_list", function(response, status, xhr) {
                            // 			console.log("updateCallList called -- 1");
                            // 			console.log("response is "+response);
                            // 			console.log("status is "+status);
                            // 			console.log("xhr is "+xhr);
                            if (status == "error") {
                                var msg = "서버의 문제로 화면 갱신에 실패했습니다.";
                                $("#div_call_list").html(msg + xhr.status + " " + xhr.statusText);
                            }
                        });
                    }

                    function updateChartData() {
                        if (isModalShow == false) return;
                        console.log("updateChartData called");
                        $("#div_call_view").load("/monitor/call_view_refresh/" + thisAgentId, function(response, status, xhr) {
                            if (status == "error") {
                                var msg = "서버의 문제로 화면 갱신에 실패했습니다.";
                                $("#div_call_view").html(msg + xhr.status + " " + xhr.statusText);
                            } else {
                                updateChart();
                            }
                        });
                    }

                    function updateChart() {
                        lineChartData.labels = $.parseJSON($("#callAudit_labelString").val().replace(/\'/g, '"'));
                        if ($("#callAudit_agentState").val() == null || $("#callAudit_agentState").val() == "") {
                            lineChartData.datasets[0].data = $.parseJSON("[0]");
                        } else {
                            lineChartData.datasets[0].data = $.parseJSON($("#callAudit_agentState").val());
                        }
                        if ($("#callAudit_customerState").val() == null || $("#callAudit_customerState").val() == "") {
                            lineChartData.datasets[1].data = $.parseJSON("[0]");
                        } else {
                            lineChartData.datasets[1].data = $.parseJSON($("#callAudit_customerState").val());
                        }
                        lineChart.update();
                        lineChart.render(0, false);
                    }

                    $(document).on("click", ".jsShowModal", function(e) {
                        e.preventDefault();
                        var agentId = $(this).attr("data-index");
                        $("#modalCallDetail").load(
                            "/monitor/call_view/" + agentId,
                            function(response, status, xhr) {
                                if (status == "error") {
                                    var msg = "서버의 문제로 해당 정보를 확인할 수 없습니다..";
                                    $("#modalCallDetail").html(msg + xhr.status + " " + xhr.statusText);
                                } else {
                                    $(this).modal("show");
                                }
                            }
                        );
                    });


                    $("#modalCallDetail").on("hidden.bs.modal", function() {
                        clearInterval(refreshInterval);
                        $("audio").trigger("pause");
                    });
                    /*
    $("#modalCallDetail").on("shown.bs.modal", function(){
    	$("#audioPlayer1").on("play", function(e) {
    		isAudio1Play = true; // 음성 파일 리프레시. false 로 처리하면 리프레시 하지 않음.
    	});
    	$("#audioPlayer2").on("play", function(e) {
    		isAudio2Play = true; // 음성 파일 리프레시
    	});

    	lineChartCanvas = $("#lineChart");
    	lineChart = new Chart( lineChartCanvas, {
			type: "bar",
			data: lineChartData,
		    options: lineChartOption
		} );
    	lineChart.clear();
		isModalShow = true;
    });
    
    Morris.Line({
    	element: 'line-chart1',
    	resize: true,
    	data: [
    	<c:set var="i" value="0" />
    	<c:forEach items="${hourlyCallList}" var="hourlyCall">
    	<c:if test="${i < fn:length(hourlyCallList)}">
    	  { h: '<fmt:formatDate pattern="HH" value="${hourlyCall.statTime}" />', a: ${hourlyCall.angryCount},  b: ${hourlyCall.stressCount} },
    	</c:if>
    	<c:if test="${i >= fn:length(hourlyCallList)}">
    	  { h: '<fmt:formatDate pattern="HH" value="${hourlyCall.statTime}" />', a: ${hourlyCall.angryCount},  b: ${hourlyCall.stressCount} }
    	</c:if>
    	<c:set var="i" value="${i+1 }" />
    	</c:forEach>
    	],
    	lineColors: ['#de8162', '#e7cd64'],
    	xkey: 'h',
    	ykeys: ['a', 'b'],
    	labels: ['Anger', 'Stress'],
    	parseTime: false,
    	hideHover: 'auto'
    });
    */
                    function audioPlayer1Callback() {
                        $("#audioPlayer1").on("pause", function(e) {
                            isAudio1Play = false;
                        });
                        if (isModalShow == false) return;

                        var audio = document.getElementById('audioPlayer1');
                        durationTime1 = audio.duration;

                        // 30초 주기로 음성파일 refresh 설정
                        //audioStartTime = new Date($("callStartTime").val());
                        //gapSecond1 = ( new Date().getTime() - ( new Date($("#callStartTime").val()).getTime() ) ) /1000;

                        // 최초의 재생 시간 < 30 초 일 경우, ( 콜 시작 시간 + 30초) 후에 오디오 파일 로딩한다.
                        if (isFirstTimePlayAudio1) {
                            if (durationTime1 < audioReloadTime) {
                                gapSecond1 = audioReloadTime - durationTime1;
                            } else {
                                gapSecond1 = durationTime1;
                            }

                            isFirstTimePlayAudio1 = false;
                        }
                        if (gapSecond1 < audioReloadTime && isInitializeAudio1 == false) {
                            if (isFirstTimePlayAudio1) return;
                            setTimeout(function() {
                                audioReload3(audio)
                            }, Math.abs(gapSecond1) * 1000);
                            audioPresentTime1 = 0;
                            isInitializeAudio1 = true;
                        }

                        if (gapSecond1 >= audioReloadTime && isInitializeAudio1 == false) {
                            audioPresentTime1 = durationTime1 - audioReloadTime;
                            isAudio1Play = true;
                            audio.currentTime = audioPresentTime1;
                            reloadAudioTimer1 = window.setInterval(function() {
                                audioReload1(audio)
                            }, audioReloadTime * 1000);
                            isInitializeAudio1 = true;
                        }
                        //. 30초 주기로 음성파일 refresh 설정 끝

                        if (isAudio1Play == true) {
                            audio.play();
                        }
                    }

                    function audioPlayer2Callback() {
                        $("#audioPlayer2").on("pause", function(e) {
                            isAudio2Play = false;
                        });
                        if (isModalShow == false || isAudio2Play == false) return;
                        var audio2 = document.getElementById('audioPlayer2');
                        durationTime2 = audio2.duration;

                        // 30초 주기로 음성파일 refresh 설정
                        if (isFirstTimePlayAudio2) {
                            if (durationTime2 < audioReloadTime) {
                                gapSecond2 = audioReloadTime - durationTime2;
                            } else {
                                gapSecond2 = durationTime2;
                            }

                            isFirstTimePlayAudio2 = false;
                        }
                        if (gapSecond2 < audioReloadTime && isInitializeAudio2 == false) {
                            if (isFirstTimePlayAudio2) return;
                            setTimeout(function() {
                                audioReload4(audio2)
                            }, Math.abs(gapSecond2) * 1000);
                            audioPresentTime2 = 0;
                            isInitializeAudio2 = true;
                        }

                        if (gapSecond2 >= audioReloadTime && isInitializeAudio2 == false) {
                            audioPresentTime2 = durationTime2 - audioReloadTime;
                            isAudio2Play = true;
                            audio2.currentTime = audioPresentTime2;
                            reloadAudioTimer2 = window.setInterval(function() {
                                audioReload2(audio2)
                            }, audioReloadTime * 1000);
                            isInitializeAudio2 = true;
                        }
                        //. 30초 주기로 음성파일 refresh 설정 끝

                        if (isAudio2Play == true) {
                            audio2.play();
                        }
                    }

                    function audioReload1(audio) {
                        if (isAudio1Play == false) return;
                        audioPresentTime1 = audio.currentTime;
                        audio.src = $("#audioPlayer1").attr("src").split("?c")[0] + "?cb=" + new Date().getTime();
                        audio.load();
                        audio.currentTime = audioPresentTime1;
                    }

                    function audioReload2(audio) {
                        if (isAudio2Play == false) return;
                        audioPresentTime2 = audio.currentTime;
                        audio.src = $("#audioPlayer2").attr("src").split("?c")[0] + "?cb=" + new Date().getTime();
                        audio.load();
                        audio.currentTime = audioPresentTime2;
                    }

                    function audioReload3(audio) {
                        audio.src = $("#audioPlayer1").attr("src").split("?c")[0] + "?cb=" + new Date().getTime();
                        audio.load();
                        reloadAudioTimer1 = window.setInterval(function() {
                            audioReload1(audio)
                        }, audioReloadTime * 1000);
                        isAudio1Play = true;
                    }

                    function audioReload4(audio) {
                        audio.src = $("#audioPlayer2").attr("src").split("?c")[0] + "?cb=" + new Date().getTime();
                        audio.load();
                        reloadAudioTimer2 = window.setInterval(function() {
                            audioReload2(audio)
                        }, audioReloadTime * 1000);
                        isAudio2Play = true;
                    }
                });
            </script>
        </body>

        </html>