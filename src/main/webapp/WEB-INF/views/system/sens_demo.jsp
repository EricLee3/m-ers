<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
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
	<script type="text/javascript" src="/resources/highcharts/highcharts.js"></script>
	<script type="text/javascript" src="/resources/highcharts/exporting.js"></script>
<style>
#loading {
 width: 100%;  
 height: 100%;  
 top: 0px;
 left: 0px;
 position: fixed;  
 display: block;  
 opacity: 0.7;  
 background-color: #fff;  
 z-index: 99;  
 text-align: center; } 
  
#loading-image { 
 position: absolute; 
 left: 50%; 
 transform: translateX(-50%);
 top: 20%;  
 z-index: 100; }
 
 
</style>


<script>
$(document).ready(function(){
	 $('#loading').hide();  
    //최상단 체크박스 클릭
    $("#checkall").click(function(){
        //클릭되었으면
        if($("#checkall").prop("checked")){
            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
            $("input[name=service_idx]").prop("checked",true);
            //클릭이 안되있으면
        }else{
            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
            $("input[name=service_idx]").prop("checked",false);
        }
    })

    $('.resizing_img').css('width' ,  $(window).width() - 280 );
    //$('.wBox').css('height' ,  $(window).height() - 200 );
    $(window).resize(function() {
      $('.resizing_img').css('width' ,  $(window).width() - 280 );
  //    $('.wBox').css('height' ,  $(window).height() - 200 );
    });
});

function fun_lastresult(){
	var localip="";
	   if(location.host.indexOf("8083") == -1 ){
		      localip="https://"+location.host;
		   }else{
		      localip="http://"+location.host;
		   }
	//$.getJSON("http://localhost:8080/system/linegraph?call_id="+"${call_id}",
	$.getJSON(localip+"/system/linegraph?call_id="+"${call_id}",
			  function(data) {
			      linegraph(data);
	});
		
	
	//$.getJSON("http://localhost:8080/system/circle?call_id="+"${call_id}",
	$.getJSON(localip+"/system/circle?call_id="+"${call_id}",
			  function(data) {
			      circlegraph(data);
	});
}
function linegraph(mdata){
	Highcharts.setOptions({
	    colors: ['#b6728e', '#6dc066', '#ff6666', '#66cdaa', '#f08080', 
	             '#ffc82e', '#ffb6c1','#11a51b', '#738b9a', '#7ac5cd',
	             '#4f90c1', '#222d4a','#9c3b30', '#db8e4e', '#dbbc5d',
	             '#ff8fcf', '#d11141','#6663bf', '#16f14b', '#d0a92b']
	});
    Highcharts.chart('linegraph_display', {
	    title: {
	        //text: 'Solar Employment Growth by Sector, 2010-2016'
	        text: ' '
	    },
	    subtitle: {
	        //text: 'Source: thesolarfoundation.com'
	    },
	    yAxis: {
	        title: {
	           // text: 'Number of Employees'
	        	  text: ' ',
	        	  allowDecimals: false // 정수로만 표기
	        }
	       // ,tickInterval: 10
	    },
	    xAxis: {
	      //  type: 'datetime'
	        //categories: ['0','2','4','6','8']
	         tickInterval: 2,
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


function circlegraph(adata){
	  //data1 = [[['화난', 210],['Oranges', 111], ['Bananas', 74], ['Grapes', 72],['Pears', 49]]];
	  //  toolTip1 = ['Red Delicious Apples', 'Parson Brown Oranges', 'Cavendish Bananas', 'Albaranzeuli Nero Grapes', 'Green Anjou Pears'];
	    
	    var plot1 = jQuery.jqplot('circlegraph_display', 
	    		adata,
	        {
	            title: ' ', 
	            grid: {
	                drawBorder: false, 
	                drawGridlines: false,
	                background: '#ffffff',
	                shadow:false
	            },
	            seriesDefaults: {
	                shadow: false, 
	                renderer: jQuery.jqplot.PieRenderer, 
	                rendererOptions: { padding: 2, sliceMargin: 2, showDataLabels: true }
	            },
	            legend: {
	                show: true,
	                location: 's',
	                renderer: $.jqplot.EnhancedPieLegendRenderer,
	                rendererOptions: {
	                    numberColumns: 4
	                	//numberRows:1
	                    //toolTips: toolTip1
	                }
	            },
	        }
	    );
}


$(document).ready(function(){
	
    $('#excel').click(function(){
    	 $("input[name=excel_call_id]").val("${call_id}");
    	 $('#form_excel').attr("target","excel_iframe");
	  	$('#form_excel').submit();
	});
	
	
var refreshInterval="";

if("${result_flag}" == 1){
	 $('#loading').show();  
	 refreshInterval =  setInterval(fun_result,1000);
}


var cnt=0;
function fun_result(){		
	var formURL = "sens_resultCnt?call_id="+"${call_id}";				   
    $.ajax(
    {
    	        url : formURL,
    	        type: "POST",
    	        timeout: 3000,	    	        
    	        success:function(data, textStatus, jqXHR) 
    	        {	
    	       		 if(data != 0){
	    	       			fun_failcode();
	    	       			clearInterval(refreshInterval);
	    	       			//disable 풀어
	    	       			$("[id=excel]").removeAttr("disabled");
	    	       		 }else{
	    	       			 cnt ++;
	    	       			 if(cnt == 60){
	    	       				 alert("응답이 없습니다.(결과 출력 재시도 횟수 60회 초과)");
	    	       				 $('#loading').hide(); 
	    	       				 clearInterval(refreshInterval);
	    	       			 }
	    	       		 }
	    	       				       	
   		        },
   		        error: function(jqXHR, textStatus, errorThrown) 
   		        {   		     
   		         	alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);							
   		        }
  });		    	   
   		    		 
}

function fun_failcode(){		
	var formURL = "sens_failcode?call_id="+"${call_id}";				   
    $.ajax(
    {
    	        url : formURL,
    	        type: "POST",
    	        timeout: 3000,	    	        
    	        success:function(data, textStatus, jqXHR) 
    	        {	    	  
        	        $('#loading').hide();  
    	       		 if(data != 0){
	    	       			var data_str = "";
	    	       			if(data == '1') {
	    	       				data_str = "실패원인 : QAEP_NOT_CONNECTED";
	    	       			}else if(data == '2') {
	    	       				data_str = "실패원인 : NO_LICENSE";
	    	       			}else if(data == '3') {
	    	       				data_str = "실패원인 : MAX_CHANNEL_EXCEED";
	    	       			}else if(data == '4') {
	    	       				data_str = "실패원인 : CHANNEL_LIMIT";
	    	       			}else if(data == '5') {
	    	       				data_str = "실패원인 : VOICE_TOO_SHORT";
	    	       			}else if(data == '6') {
	    	       				data_str = "실패원인 : CODEC_ERROR";
	    	       			}else if(data == '7') {
	    	       				data_str = "실패원인 : TIMEOUT";
	    	       			}else if(data == '8') {
	    	       				data_str = "실패원인 : NOT_SUBSCRIBED_NR";
	    	       			}else if(data == '9') {
	    	       				data_str = "실패원인 : NOT_SUBSCRIBED_RT";
	    	       			}else if(data == '10') {
	    	       				data_str = "실패원인 : NO_RESULT";
	    	       			}else if(data == '11') {
	    	       				data_str = "실패원인 : WRONG_PROCESSING";
	    	       			}else if(data == '12') {
	    	       				data_str = "실패원인 : VOICE_FILE_ACCESS_ERROR";
	    	       			}else if(data == '13') {
	    	       				data_str = "실패원인 : SEGMENT_RESPONSE_ERROR";
	    	       			}else if(data == '14') {
	    	       				data_str = "실패원인 : PROFILER_RESPONSE_ERROR";
	    	       			}else if(data == '15') {
	    	       				data_str = "실패원인 : SUMMARY_RESPONSE_ERROR";
	    	       			}else if(data == '16') {
	    	       				data_str = "실패원인 : SEGMENT_VOICE_TOO_SHORT";
	    	       			}else if(data == '17') {
	    	       				data_str = "실패원인 : PROFILER_VOICE_TOO_SHORT";
	    	       			}else if(data == '18') {
	    	       				data_str = "실패원인 : SUMMARY_VOICE_TOO_SHORT";
	    	       			}else if(data == '19') {
	    	       				data_str = "실패원인 : No_Recorded_File";
	    	       			}else if(data == '20') {
	    	       				data_str = "실패원인 : AGENT_RECORD_FILE_NOEXIST";
	    	       			}else if(data == '21') {
	    	       				data_str = "실패원인 : CUSTOMER_RECORD_FILE_NOEXIST";
	    	       			}else if(data == '22') {
	    	       				data_str = "실패원인 : AGENT_SEGMENT_VOICE_TOO_SHORT";
	    	       			}else if(data == '23') {
	    	       				data_str = "실패원인 : CUSTOMER_SEGMENT_VOICE_TOO_SHORT";
	    	       			}else if(data == '24') {
	    	       				data_str = "실패원인 : AGENT_VOICE_FILE_ACCESS_ERROR";
	    	       			}else if(data == '25') {
	    	       				data_str = "실패원인 : AGENT_SEGMENT_RESPONSE_ERROR";
	    	       			}else if(data == '26') {
	    	       				data_str = "실패원인 : AGENT_PROFILER_RESPONSE_ERROR";
	    	       			}else if(data == '27') {
	    	       				data_str = "실패원인 : AGENT_SUMMARY_RESPONSE_ERROR";
	    	       			}else if(data == '28') {
	    	       				data_str = "실패원인 : CUSTOMER_VOICE_FILE_ACCESS_ERROR";
	    	       			}else if(data == '29') {
	    	       				data_str = "실패원인 : CUSTOMER_SEGMENT_RESPONSE_ERROR";
	    	       			}else if(data == '30') {
	    	       				data_str = "실패원인 : CUSTOMER_PROFILER_RESPONSE_ERROR";
	    	       			}else if(data == '31') {
	    	       				data_str = "실패원인 : CUSTOMER_SUMMARY_RESPONSE_ERROR";
	    	       			}else if(data == '32') {
	    	       				data_str = "실패원인 : PSNR_NOT_CONNECTED";
	    	       			}else if(data == '33') {
	    	       				data_str = "실패원인 : SQL_operation_error";
	    	       			}else if(data == '34') {
	    	       				data_str = "실패원인 : PARSE_ERR";
	    	       			}else if(data == '35') {
	    	       				data_str = "실패원인 : SHORT_INPUT_PARM";
	    	       			}else if(data == '36') {
	    	       				data_str = "실패원인 : INVALID_SVCA";
	    	       			}else if(data == '37') {
	    	       				data_str = "실패원인 : INVALID_DVCA";
	    	       			}else if(data == '38') {
	    	       				data_str = "실패원인 : INVALID_TRANS_ID";
	    	       			}else if(data == '39') {
	    	       				data_str = "실패원인 : INVALID_INPUT_PARAM";
	    	       			}else if(data == '40') {
	    	       				data_str = "실패원인 : AGENT_QUERY_FAIL";
	    	       			}else if(data == '41') {
	    	       				data_str = "실패원인 : RECORD_FILE_CREATE_ERROR";
	    	       			}else if(data == '42') {
	    	       				data_str = "실패원인 : PACKET_SEND_FAIL";
	    	       			}else if(data == '43') {
	    	       				data_str = "실패원인 : AGENT_NO_LICENSE";
	    	       			}else if(data == '44') {
	    	       				data_str = "실패원인 : CUSTOMER_NO_LICENSE";
	    	       			}else if(data == '45') {
	    	       				data_str = "실패원인 : AGENT_CHANNEL_LIMIT";
	    	       			}else if(data == '46') {
	    	       				data_str = "실패원인 : CUSTOMER_CHANNEL_LIMIT";
	    	       			}else if(data == '47') {
	    	       				data_str = "실패원인 : AGENT_CODEC_ERROR";
	    	       			}else if(data == '48') {
	    	       				data_str = "실패원인 : CUSTOMER_CODEC_ERROR";
	    	       			}else if(data == '49') {
	    	       				data_str = "실패원인 : RESOURCE_UNAVAILABLE";
	    	       			}else if(data == '50') {
	    	       				data_str = "실패원인 : SYSTEM_CANCEL";
	    	       			}else {
	    	       				data_str = "실패원인 : 기타 오류";
	    	       			}

	    	       			//document.getElementById("failcode").innerHTML = data_str;
	    	       			alert(data_str);
	    	       		 }else{
	    	       			fun_lastresult();
	    	       		 }
	    	       				       	
   		        },
   		        error: function(jqXHR, textStatus, errorThrown) 
   		        {   		     
   		         	alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);							
   		        }
  });		    	   
   		    		 
}



	
	if("${searchBoardIndex}" != null && "${searchBoardIndex}" != '') $("select[name=searchBoardIndex1]").val("${searchBoardIndex}").attr("selected","selected");
	reqMent("1"); // imsi ment text
	
	
	      
	      $('#analysis').click(function(){
	    	    if((!$('#wavfile').val().toLowerCase().match(/\.(WAV)$/i) || !$('#wavfile').val().toLowerCase().match(/\.(wav)$/i) )&& $('#wavfile').val().value != '' )
	    	    {
	    	        alert("wav 파일만 올릴수 있습니다.");
	    	 
	    	        return false;
	    	    }
	    	   if( $("#form_sumbit").find("#svr_array").val() == null ||  $("#form_sumbit").find("#svr_array").val() == ""){
	    		   alert("감성지표를 1개이상 선택해 주세요.");
	    		   return false;
	    	   }
	    	    
	    	  	$('#form_sumbit').submit();
	    	});
	        
	      $("input:radio[name=testMent]").click(function(){ 
	    	   var Ment = $("input:radio[name=testMent]:checked").val();
				//alert(Ment);
				reqMent(Ment);
				        
	     }) ;
	      

});

	function reqMent(Mentval){		
		var formURL = "reqMent?Mentval="+Mentval;				   
	    $.ajax(
	    {
	    	        url : formURL,
	    	        type: "POST",
	    	        timeout: 3000,	    	        
	    	        success:function(data, textStatus, jqXHR) 
	    	        {	    	        	
	    	       		$(".ment_row").remove();
	    	       			
	    	       			
	    	       			for(var i=0;i < data.length; i ++){
		    	       			
		    	       	//	alert(data[i].ment1);
		    	       			var content = ''
		    	       				content += '<div class="ment_row"  >';
		    	       				content += data[i].ment1;
		    	       				content += '</div>';
	    	       			$(".ment_body").append(content);
	    	       		}
	   		        },
	   		        error: function(jqXHR, textStatus, errorThrown) 
	   		        {   		     
	   		         	alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);							
	   		        }
	  });		    	   
	   		    		 
	}
	
	
</script>
	</head>

<body class="hold-transition skin-blue sidebar-mini">
<iframe name="excel_iframe" style="width: 1px; height: 1px;"></iframe>
	<form role="form" id="form_excel"  action="demo_excel" method="post">
		<input type="hidden" name="excel_call_id" id="excel_call_id">
	</form>
<div id="loading"><img id="loading-image" src="/resources/img/loading.gif" alt="Loading..." /></div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
			<h2><small>서비스 ></small> 감성 분석 데모 페이지</h2>
			</section>

			<!-- Main content -->
			<section class="content">

			<div class="row" style="height: 100%;">
				<div class="col-xs-12">
					<div>
					<img src="/resources/img/VoiceCream.png" class="user-image" alt="VoiceCream" style="width: 120px; height: 35px;">
					<img src="/resources/img/graph.png" class="user-image resizing_img" alt="graph" style="width: 79%; height: 35px;">
					<img src="/resources/img/miraeson.png" class="user-image" alt="Miraeson" style="width: 120px; height: 35px;">
						<div class="box-header">
							<div class="box-tools hidden-print">
								<form role="form" id="form_batchLog_search"  action="" method="get">
									<input type="hidden" name="page" value="" />
									<input type="hidden" name="searchBoardIndex" id="searchBoardIndex" value="" />

								</form>
							</div>
						</div>
						<!-- /.box-header -->
						<div class="box-body table-responsive no-padding">
						<form role="form" id="form_sumbit"  action="sens_demo_act" method="post" enctype="multipart/form-data">
							<div role="tabpanel" class="tab-pane active in" id="home" aria-labelledby="home-tab">
						         <div class="row" >
						            <div class="col-md-4">
						               <div class="box box-primary">
						                  <div class="box-header with-border">
						                     <h3 class="box-title">녹음</h3>
						                  </div>
						                  <div class="box-body">
						                     <div class="table-responsive" id="div_call_list">
						                        <iframe src="/record.jsp" height="100px"  scrolling="auto" align="left"  frameborder="0" border="0" bordercolor="#000000" marginwidth="0" marginheight="0" name="iframe2" id="iframe2"></iframe>
						                     </div>
						                  </div>
						               </div>
						            </div>
						
						            <div class="col-md-4">
						               <div class="box box-primary">
						                  <div class="box-header with-border">
						                     <h3 class="box-title">녹음파일 선택</h3>
						                  </div>
						                  <div class="box-body">
						                  	<div class="table-responsive" id="div_call_list" style="height:100px;">
						                     	<input type="file" name="wavfile" id="wavfile">
						                     </div>
						                  </div>
						               </div>
						            </div>
						            
						             <div class="col-md-4">
						               <div class="box box-primary">
						                  <div class="box-header with-border">
						                     <h3 class="box-title">감정분석</h3>
						                  </div>
						                  <div class="box-body">
						                 	 <div class="table-responsive" id="div_call_list" style="height:100px;">
							                     <button class="btn_mj btn-primary" type="button" name="sens_data" id="sens_data" value="감성 지표 선택" data-target="#myModal" >감성 지표 선택</button>&nbsp;&nbsp;
							                     <button class="btn_mj btn-primary" type="button" name="analysis" id="analysis" value="분석" >분석</button>&nbsp;&nbsp;
							                     <button class="btn_mj btn-primary" type="button" name="excel" id="excel" value="Excel" disabled>Excel</button>
							                  </div>
						                  </div>
						               </div>
						            </div>
						         </div>
						          </div>
							<input type="hidden" name="svr_array" id="svr_array" value="">
						</form>	
						
					
						
						<div role="tabpanel" class="tab-pane active in" id="home" aria-labelledby="home-tab">
						         <div class="row" >
						            <div class="col-md-4">
						               <div class="box box-primary">
						                  <div class="box-header with-border">
						                     <h3 class="box-title">녹음멘트 선택</h3>
						                  </div>
						                  <div class="box-body">
						                     <div class="table-responsive" id="div_call_list" style=" float: left;">
						                        <input type="radio" name="testMent" value="1" checked>테스트 멘트[1] <br>
												<input type="radio" name="testMent" value="2">테스트 멘트[2] <br>
												<input type="radio" name="testMent" value="3">테스트 멘트[3] 
						                     </div>
						                  </div>
						               </div>
						            </div>
						
						            <div class="col-md-8">
						               <div class="box box-primary">
						                  <div class="box-header with-border">
						                     <h3 class="box-title">녹음멘트</h3>
						                  </div>
						                  <div class="box-body">
						                  	<div class="ment_body table-responsive"  style="height:100%;">
						                     	<div class="ment_row"></div>
						                     </div>
						                  </div>
						               </div>
						            </div>
						         </div>
						          </div>

							
							<div role="tabpanel" class="tab-pane active in" id="home" aria-labelledby="home-tab">
						         <div class="row" >
						            <div class="col-md-6">
						               <div class="box box-primary">
						                  <div class="box-header with-border">
						                     <h3 class="box-title">시계열 분석</h3>
						                  </div>
						                  <div class="box-body">
						                     <div class="table-responsive" id="div_call_list" style=" float: left;">
						                       <div id="linegraph_display"  style="margin-top:20px; margin-left:20px; width:560px; height:300px;"></div>
						                     </div>
						                  </div>
						               </div>
						            </div>
						
						            <div class="col-md-6">
						               <div class="box box-primary">
						                  <div class="box-header with-border">
						                     <h3 class="box-title">빈도 분석</h3>
						                  </div>
						                  <div class="box-body">
						                  	<div class="table-responsive">
						                     	<div id="circlegraph_display"  style="margin-top:20px; margin-left:20px; width:460px; height:300px;"></div>
						                     </div>
						                  </div>
						               </div>
						            </div>
						         </div>
						          </div>
							
							
						</div>
						<!-- /.box-body -->
					</div>
					<!-- /.box -->
				</div>
			</div>
			
			
			<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">감성 지표 선택</h4>
					</div>
					<form role="form" id="form_pro_create" action="" method="post">
						<input type="hidden" id="checkedGroupId" name="checkedGroupId" value="false">
						<div class="modal-body">
							<div class="form-group" style="height: 360px">
							<table cellpadding="0" border="0" align="left" width="100%">
								<tr style="border-bottom:1px solid #D3D3D3;">
									<td width="10%" align="center">전체<input type="checkbox" id="checkall" /></td>
									<td width="90%" align="center"><label for="desc">Service Indicator</label> </td>
								</tr>
								<c:forEach items="${IndiList}" var="name">
								<tr>
									<td align="center"><input type="checkbox" id="service_idx" name="service_idx" value="${name.name}"></td>
									<td align="center">${name.name}</td>
								</tr>
								</c:forEach>
							</table>
							</div>
							<!-- 
							<div class="form-group">
								<label for="GroupName">Basic Emotion<span class="text-danger">*</span></label> 
								<input type="text" class="form-control" id="groupName" name="groupName" placeholder="그룹명을 입력하세요" maxlength="20">
							</div>
							 -->
						</div>
	
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left" data-dismiss="modal">취소</button>
							<button type="button" class="jsCreate btn btn-primary">확인</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</section>
			<!-- /.content -->
<script>
$(document).on("click", "#sens_data", function(e){
		$("#myModal").modal("show");
	
});

$(document).on("click", ".jsCreate", function(e){
	
	var svr_idx="";
 	var bidx= $(":checkbox[name='service_idx']").length;
 
	for(i=0; i<bidx; i++){
		if($("input[name='service_idx']")[i].checked == true){
				svr_idx += $('input[name="service_idx"]')[i].value+",";
		
		}
	}
	$("#form_sumbit").find("#svr_array").val(svr_idx.slice(0,-1));
	$("#myModal").modal("hide");
});
</script>
</body>

</html>