<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>VoiceCream / 미래손 감정분석 솔루션</title>
	<meta http-equiv="Cache-Control" content="no-cache"/>
	<meta http-equiv="Expires" content="0"/>
	<meta http-equiv="Pragma" content="no-cache"/>
<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="/resources/css/ionicons.min.css">
	<link rel="stylesheet" href="/resources/css/AdminLTE.min.css">
	<link rel="stylesheet" href="/resources/css/skins/_all-skins.min.css">
	<link rel="stylesheet" href="/resources/plugins/ionslider/ion.rangeSlider.css">
  	<link rel="stylesheet" href="/resources/plugins/ionslider/ion.rangeSlider.skinHTML5.css">
  	<link rel="stylesheet" href="/resources/plugins/morris/morris.css">
  	<link rel="stylesheet" href="/resources/css/migam.css">
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
	<![endif]-->
	<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
	<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
	<script src="https://www.amcharts.com/lib/3/pie.js"></script>
	<script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="/resources/plugins/fastclick/fastclick.js"></script>
	<script src="/resources/js/app.min.js"></script>
	<script src="/resources/plugins/raphael/raphael-min.js"></script>
	<script src="/resources/plugins/morris/morris.min.js"></script>
	<script src="/resources/plugins/chartjs/Chart.min.js"></script>
	<script src="/resources/plugins/ionslider/ion.rangeSlider.min.js"></script>

	<!-- Ionicons -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
	 <!-- Theme style -->
	<link rel="stylesheet" href="/resources/select2test/css/AdminLTE.min.css">
	<!-- AdminLTE Skins. Choose a skin from the css/skins
	     folder instead of downloading all of them to reduce the load. -->
	<link rel="stylesheet" href="/resources/select2test/css/_all-skins.min.css">
</head>

<script type="text/javascript">
function SoundPlay( soundObj )
{
    var sound = document.getElementById(soundObj);
    sound.Play();
}

function SoundStop( soundObj )
{
    var sound = document.getElementById(soundObj);
    sound.stop();
}

   $(document).ready(function(){
        var fnc = function(){
        	reqcpu();
        	reqmemory();
        	reqprocess();
        	reqdisk();
        	reqalarm();
        	reqfaultalarm();
      };
        
        setInterval(fnc, 3000);
      
   });
   
   function reqcpu(){      
	      var formURL = "reqcpu";               
	       $.ajax(
	       {
	                  url : formURL,
	                  type: "POST",
	                  timeout: 3000,                  
	                  success:function(data, textStatus, jqXHR) 
	                  {
	                       $(".cpu").remove();
	                       for(var i=0;i < data.length; i ++){
	                    	   var content = "";
	                    	   if(data[i].alarm_lv == 0) {
	                    		   content += "<div class=\"cpu info-box bg-green\" style=\"height: 160px; text-align: center;\">";
	                    	   }else if(data[i].alarm_lv == 1) {
	                    		   content += "<div class=\"cpu info-box\" style=\"height: 160px; text-align: center; background-color: #FFD700;\">";
	                    	   }else if(data[i].alarm_lv == 2) {
	                    		   content += "<div class=\"cpu info-box bg-yellow\" style=\"height: 160px; text-align: center;\">";
	                    	   }else {
	                    		   content += "<div class=\"cpu info-box bg-red\" style=\"height: 160px; text-align: center;\">";
	                    	   }
	                    	   		content += "<span class=\"info-box-text\"><font style=\"font-size: 30px;\">CPU</font></span>";
	                    	   		content += "<span class=\"info-box-number\"><font style=\"font-size: 60px;\">"+data[i].value+" %</font></span></div>";
	                          $(".cpu_body").append(content);
	                       }
	                    },
	                    error: function(jqXHR, textStatus, errorThrown) 
	                    {              
	                        alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);                     
	                    }
	                });                
	                       
	   } 
   
   function reqmemory(){      
	      var formURL = "reqmemory";               
	       $.ajax(
	       {
	                  url : formURL,
	                  type: "POST",
	                  timeout: 3000,                  
	                  success:function(data, textStatus, jqXHR) 
	                  {
	                       $(".memory").remove();
	                       
	                       for(var i=0;i < data.length; i ++){
	                    	   var content = "";
	                    	   var val = data[i].value.split('/');
	                    	   var valper = val[0] / val[1] * 100;
	                    	   var aa = valper.toFixed(1);
	                    	   var a = Math.round(val[0] / val[1] * 100);
	                    	   
	                    	   if(data[i].alarm_lv == 0) {
	                    		   content += "<div class=\"memory info-box bg-green\" style=\"height: 160px; text-align: center;\">";
	                    	   }else if(data[i].alarm_lv == 1) {
	                    		   content += "<div class=\"memory info-box\" style=\"height: 160px; text-align: center; background-color: #FFD700;\">";
	                    	   }else if(data[i].alarm_lv == 2) {
	                    		   content += "<div class=\"memory info-box bg-yellow\" style=\"height: 160px; text-align: center;\">";
	                    	   }else {
	                    		   content += "<div class=\"memory info-box bg-red\" style=\"height: 160px; text-align: center;\">";
	                    	   }
	                    	   content += "<span class=\"info-box-text\"><font style=\"font-size: 30px;\">MEMORY</font></span>";
	                    	   content += "<span class=\"info-box-number\"><font style=\"font-size: 60px;\">"+aa+" %</font></span>";
	                    	   content += "<span class=\"info-box-number\"><font style=\"font-size: 20px;\">("+data[i].value+" GB)</font></span></div>";
	                    	   $(".memory_body").append(content);
	                       }
	                    },
	                    error: function(jqXHR, textStatus, errorThrown) 
	                    {              
	                        alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);                     
	                    }
	                });                
	                       
	   }  
   
   function reqprocess(){      
	      var formURL = "reqprocess";               
	       $.ajax(
	       {
	                  url : formURL,
	                  type: "POST",
	                  timeout: 3000,                  
	                  success:function(data, textStatus, jqXHR) 
	                  {                     
	                       $(".process_row").remove();
	                       for(var i=0;i < data.length; i ++){
	                    	   var val = data[i].value.split('#');
	                    	   var bb = val[0];
	                    	   var cc = val[1];
	                    	   var valper = val[0] / val[1] * 100;
	                    	   var aa = valper.toFixed(1);
	                    	   var a = Math.round(val[0] / val[1] * 100);
	                    	   
	                    	   var content = "<tr class='process_row'>";
				                if(data[i].alarm_lv ==0) {
				                	 content += "<td><font color=\"#006400\">"+data[i].category+"</font></td>";
				                }else {
				                	content += "<td><font color=\"#FF0000\">"+data[i].category+"</font></td>";
				                }
				                if(data[i].alarm_lv ==0) {
				               		content += "<td><font color=\"#006400\">"+cc+"/"+bb+" %</font></td>";
				                }else {
				                	content += "<td><font color=\"#FF0000\">"+cc+"/"+bb+" %</font></td>";
				                }
				                content += "<td><div class=\"btn-group\">";
				              if(data[i].alarm_lv == 3) {
				            	  content += "<button type=\"button\" class=\"jsStartProcess btn btn-default btn-xs\" data-groupid="+data[i].category+">시작</button>";       	  
				              }else {
	                          	content += "<button type=\"button\" class=\"jsStopProcess btn btn-default btn-xs\" data-groupid="+data[i].category+">종료</button>";
				              }
	                          	content += "</div></td></tr>";                             
	                          $(".process_body").append(content);
	                       }
	                    },
	                    error: function(jqXHR, textStatus, errorThrown) 
	                    {              
	                        alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);                     
	                    }
	                });                
	                       
	   }  

   function reqdisk(){      
	      var formURL = "reqdisk";               
	       $.ajax(
	       {
	                  url : formURL,
	                  type: "POST",
	                  timeout: 3000,                  
	                  success:function(data, textStatus, jqXHR) 
	                  {                     
	                       $(".disk_row").remove();
	                       for(var i=0;i < data.length; i ++){
	                    	   
	                    	   var val = data[i].value.split('/');
	                    	   var valper = val[0] / val[1] * 100;
	                    	   var aa = valper.toFixed(1);
	                    	   var a = Math.round(val[0] / val[1] * 100);
	                    	   
	                    	   
	                    	   var content = "<tr class='disk_row'>";
	                    	   content += "<td>"+data[i].category+"</td>";
	                          content += "<td>"+aa+" % ("+data[i].value+" GB)</td>";
	                          content += "</tr>";                             
	                          $(".disk_body").append(content);
	                       }
	                    },
	                    error: function(jqXHR, textStatus, errorThrown) 
	                    {              
	                        alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);                     
	                    }
	                });                
	                       
	   }  
   

   function reqalarm(){      
	      var formURL = "reqalarm";  
	       $.ajax(
	       {
	    	   
	                  url : formURL,
	                  type: "POST",
	                  timeout: 3000,                  
	                  success:function(data, textStatus, jqXHR) 
	                  {                     
	                       $(".alarm_row").remove();
	                       for(var i=0;i < data.length; i ++){
	                    	  
	                    	   	if("${a_flag}" == 0) {	//가청 OFF이고
	                    	   	 var content = "<tr class='alarm_row'>";
	                          	  content += "<td><font size=\"2\">"+data[i].alarmed_time+"</font></td>";
		                          content += "<td><font size=\"2\">"+data[i].sys_name+"</font></td>";
		                          content += "<td><font size=\"2\">"+data[i].alarm_code+"</font></td>";
		                          if(data[i].alarm_lv ==0) {
		                        	  content += "<td><a class=\"noraml\">NORMAL</a></td>";
		                          }else if(data[i].alarm_lv ==1){
		                        	  content += "<td><a class=\"minor\">MINOR</a></td>";
		                          }else if(data[i].alarm_lv ==2){
		                        	  content += "<td><a class=\"major\">MAJOR</a></td>";
		                          }else {
		                        	  content += "<td><a class=\"critical\">CRITICAL</a></td>";
		                          }
		                          content += "<td><font size=\"2\">"+data[i].alarm_detail+"</font></td>"; 
		                          content += "</tr>";  
		                       $(".alarm_body").append(content);
		                       
	                    	   		if(data[0].audio_flag == 1) {	//듣기 ON이고
	                    	   			if(data[0].alarmed_time.substring(0,19) > "${a_date}") {	//최근 데이터날짜가 접속 날짜보다 크면
	                    	   				if(data[0].alarm_lv ==1) {
	                    					   var mi = new Audio("/resources/wav/C1_Minor.mp3");
	                    					   mi.play();
		                    			   }else if(data[0].alarm_lv ==2) {
		                    				   var mj = new Audio("/resources/wav/C1_Major.mp3");
		                    				   mj.play();
		                    			   }else if(data[0].alarm_lv ==3) {
		                    				   var ct = new Audio("/resources/wav/C1_critical.mp3");
		                    				   ct.play();
		                    			   }
	                    	   			}else {		//최근 데이터날짜가 접속 날짜보다 작으면
	                    	   				
	                    	   			}
	                    	   		}else {		//듣기 OFF면
	                    	   			
	                    	   		}
	                    	   	}else {			//가청ON이고
	                    	   	 var content = "<tr class='alarm_row'>";
	                          	  content += "<td><font size=\"2\">"+data[i].alarmed_time+"</font></td>";
		                          content += "<td><font size=\"2\">"+data[i].sys_name+"</font></td>";
		                          content += "<td><font size=\"2\">"+data[i].alarm_code+"</font></td>";
		                          if(data[i].alarm_lv ==0) {
		                        	  content += "<td><a class=\"noraml\">NORMAL</a></td>";
		                          }else if(data[i].alarm_lv ==1){
		                        	  content += "<td><a class=\"minor\">MINOR</a></td>";
		                          }else if(data[i].alarm_lv ==2){
		                        	  content += "<td><a class=\"major\">MAJOR</a></td>";
		                          }else {
		                        	  content += "<td><a class=\"critical\">CRITICAL</a></td>";
		                          }
		                          content += "<td><font size=\"2\">"+data[i].alarm_detail+"</font></td>"; 
		                          content += "</tr>";  
		                       $(".alarm_body").append(content);
		                       
	                    	   		if(data[0].audio_flag == 1) {	//듣기 ON이고
	                    	   			if(data[0].alarm_lv ==1) {
	                    					   var mi = new Audio("/resources/wav/C1_Minor.mp3");
	                    					   mi.play();
		                    			   }else if(data[0].alarm_lv ==2) {
		                    				   var mj = new Audio("/resources/wav/C1_Major.mp3");
		                    				   mj.play();
		                    			   }else if(data[0].alarm_lv ==3) {
		                    				   var ct = new Audio("/resources/wav/C1_critical.mp3");
		                    				   ct.play();
		                    			   }
	                    	   	}
	                    	 
	                    	   	}
	                    	  
	                       }
	                    },
	                    error: function(jqXHR, textStatus, errorThrown) 
	                    {              
	                        alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);                     
	                    }
	                });                
	                       
	   }  
   
   function reqfaultalarm(){      
	      var formURL = "reqfaultalarm";  
	       $.ajax(
	       {
	                  url : formURL,
	                  type: "POST",
	                  timeout: 3000,                  
	                  success:function(data, textStatus, jqXHR) 
	                  {                     
	                       $(".fault_row").remove();
	                       for(var i=0;i < data.length; i ++){
	                    	   	var content = "<tr class='fault_row'>";
	                          	  content += "<td><font size=\"2\">"+data[i].happened_time+"</font></td>";
	                          	  //content += "<td><font size=\"2\">"+data[i].sys_id+"</font></td>";
		                          content += "<td><font size=\"2\">"+data[i].sys_name+"</font></td>";
		                          content += "<td><font size=\"2\">"+data[i].code+"</font></td>";
		                          content += "<td><font size=\"2\">"+data[i].detail+"</font></td>"; 
		                          content += "<td><button type=\"button\" class=\"jsFaultAlarmDelete btn btn-default btn-xs\" data-groupid="+data[i].code+">삭제</button></td>";
		                          
								  content += "</tr>";                          
	                         $(".fault_body").append(content);
	                       }
	                    },
	                    error: function(jqXHR, textStatus, errorThrown) 
	                    {              
	                        alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);                     
	                    }
	                });                
	                       
	   }  


   </script>
   
<div class="wrapper">
<%@include file="../include/taglib.jsp"%>
<div class="content-wrapper">
<form action=data_list id="processingForm" method="POST">   
   <input type="hidden" name="test" value="test">
   <input type="hidden" name="ac_work_type" value="1">
</form>

				<div class="row">
					<div class="col-xs-12">
						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">시스템 상태 목록</h3>
								<input type="hidden" name="page" value="">
							</div>
							<div style="height: 800px;">
								<div style="width: 100%; height: 380px; margin: 0 auto">
<div class="box box-primary" style="width: 25%; float: left; position: relative; margin-left: 100px;">
								<div class="box-header with-border">
								<h4 class="box-title" align="center">
									<b>자원 사용률 </b>
								</h4> 
								</div>
<table id="example1" class="table no-margin" style="width: 100%;">
     <tr>
     <td> <div class="cpu_body">
      </div></td>
      </tr>
      <tr>
	<td><div class="memory_body">
	</div></td>
	</tr>
</table>
</div>
		<div class="box box-warning" style="width: 25%; float: left; position: relative; margin-left: 100px;">
								<div class="box-header with-border">
								<h4 class="box-title" align="center">
									<b>디스크 사용량 </b>
								</h4>
								</div>
								<table id="example1" class="table no-margin" style="width: 100%;">
									<thead>
										<tr>
											<th class="no-sort" width="50%">이름</th>
											<th class="no-sort" width="50%">사용량</th> 
										</tr>
									</thead>
									<tbody class="disk_body">
                          			</tbody>
									
								</table>
</div>
							
							<div class="box box-danger" style="width: 25%; float: left; position: relative; margin-left: 100px;">
								<div class="box-header with-border">
								<h4 class="box-title" align="center">
									<b>프로세스</b>
								</h4>
								</div>
								<table id="example1" class="table no-margin" style="width: 100%;">
									<thead>
										<tr>
											<th class="no-sort" width="50%">프로세스명</th>
											<th class="no-sort" width="50%">PID/CPU</th>
											<th class="no-sort" width="50%">관리</th>
										</tr>
									</thead>
									<tbody class="process_body">
                          			</tbody>
								</table>
							</div>
							
							
							
								</div>
								<!-- /.box-header -->
								
							<div class="box box-info" style="width: 100%; float: left;">
							
								<div class="box-header with-border">
									<h4 class="box-title" align="center">
										<b>현재 알람 목록 <small>(총 : ${alarmstatCount } 건)</small></b>
									</h4>
									<div style="float: right;">
									<c:if test="${a_flag eq 0}">
											<button type="button" class="jsSetFlagOn btn btn-default btn-xs">가청 ON</button>
										</c:if>
										<c:if test="${a_flag eq 1}">
											<button type="button" class="jsSetFlagOff btn btn-default btn-xs">가청 OFF</button>
										</c:if>
										</div>
								</div>
								<div style="overflow:auto; height:400px;">
									<table id="example1" class="table table-bordered table-striped" style="width: 100%;"> 
										<thead>
											<tr>
												<th class="no-sort" width="10%">발생 시간</th>
												<th class="no-sort" width="10%">시스템명</th>
												<th class="no-sort" width="10%">알람 코드</th>
												<th class="no-sort" width="8%">알람 등급</th>
												<th class="no-sort" width="*%">알람 정보</th>
											</tr>
										</thead>
										<tbody class="alarm_body">
	                          			</tbody>
									</table>
								</div>
							</div>
							
							
							<div class="box box-info" style="width: 100%; float: left;">
								<div class="box-header with-border">
									<h4 class="box-title" align="center">
										<b>FAULT 알람 목록 <small>(총 : ${faultalarmstatCount } 건)</small></b>
									</h4>
								</div>
								<div style="overflow:auto; height:400px;">
									<table id="example1" class="table table-bordered table-striped" style="width: 100%;"> 
										<thead>
											<tr>
												<th class="no-sort" width="10%">발생 시간</th>
												<th class="no-sort" width="10%">시스템명</th>
												<th class="no-sort" width="10%">알람 코드</th>
												<th class="no-sort" width="*%">알람 정보</th>
												<th class="no-sort" width="7%">관리</th>
											</tr>
										</thead>
										<tbody class="fault_body">
	                          			</tbody>
									</table>
								</div>
							</div>
							
							
							</div>
							<div class="box-footer clearfix">
							</div>
						</div>
					</div>
				</div>
				</div>
				</div>
			<!-- /.content -->
		<!-- /.content-wrapper -->
<!-- Chart code -->
<script>
 
 $(document).on("click", ".jsStartProcess", function(e){
		e.preventDefault();
		var category = $(this).attr("data-groupid");
		if(confirm("프로세스를 시작 하시겠습니까?")) {
	    	$.ajax({
	    		url:"/REST/processgroup/startProcess/" + category,
	    		dataType : "JSON",
	    		method : "GET",
	    		success : function(result) {
	    	    	if( result) {
	    	    		alert("프로세스"+[category]+"를 시작하였습니다.");
	    	    		location.reload();
	    	    	} else {
	    	    		alert("프로세스"+[category]+"시작을 실패하였습니다.");
	    	    	}
	    		}
	    	});
		}
	});

$(document).on("click", ".jsStopProcess", function(e){
	e.preventDefault();
	var category = $(this).attr("data-groupid");
	if(confirm("프로세스를 종료 하시겠습니까?")) {
    	$.ajax({
    		url:"/REST/processgroup/deleteProcess/" + category,
    		dataType : "JSON",
    		method : "GET",
    		success : function(result) {
    	    	if( result) {
    	    		alert("프로세스"+[category]+"를 종료하였습니다.");
    	    		location.reload();
    	    	} else {
    	    		alert("프로세스"+[category]+"종료를 실패하였습니다.");
    	    	}
    		}
    	});
	}
});

$(document).on("click", ".jsFaultAlarmDelete", function(e){
	e.preventDefault();
	
	var username = "${sessionScope.sessionUser.currentUser.userName }";
	var userid = "${sessionScope.sessionUser.currentUser.userId}";
	var code = $(this).attr("data-groupid")+","+username+","+userid;
	
	if(confirm("Fault 알람을 삭제하시겠습니까?")) {
    	$.ajax({
    		url:"/REST/processgroup/deleteFaultAlarm/" + code,
    		dataType : "JSON",
    		method : "GET",
    		success : function(result) {
    	    	if( result) {
    	    		//alert("프로세스"+[category]+"를 종료하였습니다.");
    	    		//location.reload();
    	    	} else {
    	    		//alert("프로세스"+[category]+"종료를 실패하였습니다.");
    	    	}
    		}
    	});
	}
});

$(document).on("click", ".jsSetFlagOff", function(e){
	e.preventDefault();
	if(confirm("가청을 OFF하시겠습니까?") == true) {
    	$.ajax({
    		url:"/REST/processgroup/setSoundOff/",
    		dataType : "JSON",
    		method : "GET",
    		success : function(result) {
    	    	if( result) {
    	    		//alert("프로세스"+[category]+"를 종료하였습니다.");
    	    		//location.reload();
    	    	} else {
    	    		//alert("프로세스"+[category]+"종료를 실패하였습니다.");
    	    	}
    		}
    	});
    	//window.location.reload(true);
    	$('#profile').load("../system/segment_list");
	}
});

$(document).on("click", ".jsSetFlagOn", function(e){
	e.preventDefault();
	if(confirm("가청을 On 하시겠습니까?") == true) {
    	$.ajax({
    		url:"/REST/processgroup/setSoundOn/",
    		dataType : "JSON",
    		method : "GET",
    		success : function(result) {
    	    	if( result) {
    	    		//alert("프로세스"+[category]+"를 종료하였습니다.");
    	    		//location.reload();
    	    	} else {
    	    		//alert("프로세스"+[category]+"종료를 실패하였습니다.");
    	    	}
    	    	
    		}
    	});
    	//window.location.reload(true);
    	$('#profile').load("../system/segment_list");
    	
	}
});

</script>
</html>