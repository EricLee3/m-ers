<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/taglib.jsp"%>
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
	<link rel="stylesheet" href="/resources/plugins/datepicker/datepicker3.css">	
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

	<link rel="stylesheet" type="text/css" href="/resources/jqplot/jquery.jqplot.css" />
	
	<script type="text/javascript" src="/resources/jqplot/jquery.jqplot.js"></script>
	<script type="text/javascript" src="/resources/jqplot/plugins/jqplot.pieRenderer.js"></script>
	<script type="text/javascript" src="/resources/jqplot/plugins/jqplot.enhancedPieLegendRenderer.js"></script>
	<script type="text/javascript" src="/resources/jqplot/plugins/jqplot.dateAxisRenderer.js"></script>
	<script type="text/javascript" src="/resources/jqplot/plugins/jqplot.logAxisRenderer.js"></script>
	<script type="text/javascript" src="/resources/jqplot/plugins/jqplot.canvasTextRenderer.js"></script>
	<script type="text/javascript" src="/resources/jqplot/plugins/jqplot.canvasAxisTickRenderer.js"></script>
	<script type="text/javascript" src="/resources/jqplot/plugins/jqplot.highlighter.js"></script>
	

	<script>
$(document).ready(function(){
	if("${searchBoardIndex}" != null && "${searchBoardIndex}" != '') $("select[name=searchBoardIndex1]").val("${searchBoardIndex}").attr("selected","selected");
	
	 	data1 = [[['Apples', 210],['Oranges', 111], ['Bananas', 74], ['Grapes', 72],['Pears', 49]]];
	    toolTip1 = ['Red Delicious Apples', 'Parson Brown Oranges', 'Cavendish Bananas', 'Albaranzeuli Nero Grapes', 'Green Anjou Pears'];
	    
	    var plot1 = jQuery.jqplot('kmj1', 
	        data1,
	        {
	            title: ' ', 
	            seriesDefaults: {
	                shadow: false, 
	                renderer: jQuery.jqplot.PieRenderer, 
	                rendererOptions: { padding: 2, sliceMargin: 2, showDataLabels: true }
	            },
	            legend: {
	                show: true,
	                location: 'e',
	                renderer: $.jqplot.EnhancedPieLegendRenderer,
	                rendererOptions: {
	                    numberColumns: 1,
	                    toolTips: toolTip1
	                }
	            },
	        }
	    );
	    
	    
	    $.jqplot._noToImageButton = true;
	    var prevYear = [["2011-08-01",398], ["2011-08-02",255.25], ["2011-08-03",263.9], ["2011-08-04",154.24], 
	    ["2011-08-05",210.18], ["2011-08-06",109.73], ["2011-08-07",166.91], ["2011-08-08",330.27], ["2011-08-09",546.6], 
	    ["2011-08-10",260.5], ["2011-08-11",330.34], ["2011-08-12",464.32], ["2011-08-13",432.13], ["2011-08-14",197.78], 
	    ["2011-08-15",311.93], ["2011-08-16",650.02], ["2011-08-17",486.13], ["2011-08-18",330.99], ["2011-08-19",504.33], 
	    ["2011-08-20",773.12], ["2011-08-21",296.5], ["2011-08-22",280.13], ["2011-08-23",428.9], ["2011-08-24",469.75], 
	    ["2011-08-25",628.07], ["2011-08-26",516.5], ["2011-08-27",405.81], ["2011-08-28",367.5], ["2011-08-29",492.68], 
	    ["2011-08-30",700.79], ["2011-08-31",588.5], ["2011-09-01",511.83], ["2011-09-02",721.15], ["2011-09-03",649.62], 
	    ["2011-09-04",653.14], ["2011-09-06",900.31], ["2011-09-07",803.59], ["2011-09-08",851.19], ["2011-09-09",2059.24], 
	    ["2011-09-10",994.05], ["2011-09-11",742.95], ["2011-09-12",1340.98], ["2011-09-13",839.78], ["2011-09-14",1769.21], 
	    ["2011-09-15",1559.01], ["2011-09-16",2099.49], ["2011-09-17",1510.22], ["2011-09-18",1691.72], 
	    ["2011-09-19",1074.45], ["2011-09-20",1529.41], ["2011-09-21",1876.44], ["2011-09-22",1986.02], 
	    ["2011-09-23",1461.91], ["2011-09-24",1460.3], ["2011-09-25",1392.96], ["2011-09-26",2164.85], 
	    ["2011-09-27",1746.86], ["2011-09-28",2220.28], ["2011-09-29",2617.91], ["2011-09-30",3236.63]];
	 
	    var currYear = [["2011-08-01",796.01], ["2011-08-02",510.5], ["2011-08-03",527.8], ["2011-08-04",308.48], 
	    ["2011-08-05",420.36], ["2011-08-06",219.47], ["2011-08-07",333.82], ["2011-08-08",660.55], ["2011-08-09",1093.19], 
	    ["2011-08-10",521], ["2011-08-11",660.68], ["2011-08-12",928.65], ["2011-08-13",864.26], ["2011-08-14",395.55], 
	    ["2011-08-15",623.86], ["2011-08-16",1300.05], ["2011-08-17",972.25], ["2011-08-18",661.98], ["2011-08-19",1008.67], 
	    ["2011-08-20",1546.23], ["2011-08-21",593], ["2011-08-22",560.25], ["2011-08-23",857.8], ["2011-08-24",939.5], 
	    ["2011-08-25",1256.14], ["2011-08-26",1033.01], ["2011-08-27",811.63], ["2011-08-28",735.01], ["2011-08-29",985.35], 
	    ["2011-08-30",1401.58], ["2011-08-31",1177], ["2011-09-01",1023.66], ["2011-09-02",1442.31], ["2011-09-03",1299.24], 
	    ["2011-09-04",1306.29], ["2011-09-06",1800.62], ["2011-09-07",1607.18], ["2011-09-08",1702.38], 
	    ["2011-09-09",4118.48], ["2011-09-10",1988.11], ["2011-09-11",1485.89], ["2011-09-12",2681.97], 
	    ["2011-09-13",1679.56], ["2011-09-14",3538.43], ["2011-09-15",3118.01], ["2011-09-16",4198.97], 
	    ["2011-09-17",3020.44], ["2011-09-18",3383.45], ["2011-09-19",2148.91], ["2011-09-20",3058.82], 
	    ["2011-09-21",3752.88], ["2011-09-22",3972.03], ["2011-09-23",2923.82], ["2011-09-24",2920.59], 
	    ["2011-09-25",2785.93], ["2011-09-26",4329.7], ["2011-09-27",3493.72], ["2011-09-28",4440.55], 
	    ["2011-09-29",5235.81], ["2011-09-30",6473.25]];
	 
	    var plot1 = $.jqplot("mj", [prevYear, currYear], {
	        seriesColors: ["rgba(78, 135, 194, 0.7)", "rgb(211, 235, 59)"],
	        title: 'Monthly TurnKey Revenue',
	        highlighter: {
	            show: true,
	            sizeAdjust: 1,
	            tooltipOffset: 9
	        },
	        grid: {
	            background: 'rgba(57,57,57,0.0)',
	            drawBorder: false,
	            shadow: false,
	            gridLineColor: '#666666',
	            gridLineWidth: 2
	        },
	        legend: {
	            show: true,
	            placement: 'outside'
	        },
	        seriesDefaults: {
	            rendererOptions: {
	                smooth: true,
	                animation: {
	                    show: true
	                }
	            },
	            showMarker: false
	        },
	        series: [
	            {
	               // fill: true,
	                label: '2010'
	            },
	            {
	                label: '2011'
	            }
	        ],
	        axesDefaults: {
	            rendererOptions: {
	                baselineWidth: 1.5,
	                baselineColor: '#444444',
	                drawBaseline: false
	            }
	        },
	        axes: {
	            xaxis: {
	                renderer: $.jqplot.DateAxisRenderer,
	                tickRenderer: $.jqplot.CanvasAxisTickRenderer,
	                tickOptions: {
	                    formatString: "%b %e",
	                    angle: -30,
	                    textColor: '#dddddd'
	                },
	                min: "2011-08-01",
	                max: "2011-09-30",
	                tickInterval: "7 days",
	                drawMajorGridlines: false
	            },
	            yaxis: {
	                renderer: $.jqplot.LogAxisRenderer,
	                pad: 0,
	                rendererOptions: {
	                    minorTicks: 1
	                },
	                tickOptions: {
	                    formatString: "$%'d",
	                    showMark: false
	                }
	            }
	        }
	    });
	 
	      $('.jqplot-highlighter-tooltip').addClass('ui-corner-all')

});
</script>
	</head>

<body class="hold-transition skin-blue sidebar-mini">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			<h2><small>서비스 ></small> 감성 분석 데모 페이지</h2>
			</section>

			<!-- Main content -->
			<section class="content">

			<div class="row">
				<div class="col-xs-12">
					<div class="box box-info">
						<div class="box-header">
							<h3 class="box-title">감성분석 데모 페이지</h3>
							<div class="box-tools visible-print-block">
							</div>
							<div class="box-tools hidden-print">
								<form role="form" id="form_batchLog_search"  action="" method="get">
									<input type="hidden" name="page" value="" />
									<input type="hidden" name="searchBoardIndex" id="searchBoardIndex" value="" />

								</form>
							</div>
							<p></p>
						</div>
						<!-- /.box-header -->
						<div class="box-body table-responsive no-padding">
							<table class="table table-hover">
								<colgroup>
									<col class="col-width-type01" />
									<col />
									<col />
									<col />
								</colgroup>
								<tr>
									<th class="no-sort col-sm-1">녹음파일 선택</th>
									<th class="no-sort col-sm-1">녹음</th>
									<th class="no-sort col-sm-1">분석대상</th>
									<th class="no-sort col-sm-1">감성 분석</th>
								</tr>
								<tr>
									<td><input type="file" name="wavfile" value="aaa"></td>
									<td><input type="button" name="rstart" value="▶녹음">&nbsp;&nbsp;<input type="button" name="rstop" value="■종료"></td>
									<td><input type="radio" name="VCtts" value="1">녹음 &nbsp;&nbsp;<input type="radio" name="VCfile" value="2">파일</td>
									<td><input type="button" name="analysis" value="분석">&nbsp;&nbsp;<input type="button" name="excel" value="Excel"></td>
								</tr>
							</table>
							
							<table class="table table-hover">
								<colgroup>
									<col class="col-width-type01" width="20%"/>
									<col  width="80%"/>
								</colgroup>
								<tr>
									<th class="no-sort col-sm-1">녹음멘트 선택</th>
									<th class="no-sort col-sm-1">녹음 멘트</th>

								</tr>
								<tr>
									<td>
										<input type="radio" name="testMent" value="1">테스트 멘트[1] <br>
										<input type="radio" name="testMent" value="2">테스트 멘트[2] <br>
										<input type="radio" name="testMent" value="3">테스트 멘트[3] 
									</td>
									<td>
										<textarea rows="5" cols="30" name="contents" style="width: 800px"></textarea>
									</td>
								</tr>
							</table>
							
							<table class="table table-hover">
								<colgroup>
									<col class="col-width-type01" width="50%"/>
									<col width="50%"/>
								</colgroup>
								<tr>
									<th class="no-sort col-sm-1">시계열 분석</th>
									<th class="no-sort col-sm-1">빈도 분석</th>

								</tr>
								<tr>
									<td>
										<div id=mj  style="margin-top:20px; margin-left:20px; width:460px; height:300px;"></div>
									</td>
									<td>
										<div id=kmj1  style="margin-top:20px; margin-left:20px; width:460px; height:300px;"></div>
									</td>
								</tr>
							</table>
						</div>
						<!-- /.box-body -->

					</div>
					<!-- /.box -->
				</div>
			</div>
			</section>
			<!-- /.content -->

</body>
</html>