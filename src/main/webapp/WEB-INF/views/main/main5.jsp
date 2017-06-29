<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


<div class="wrapper" style="height:1600px">
      <!-- Content Header (Page header) -->

   <div id="myTabContent" class="tab-content">
     <div role="tabpanel" class="tab-pane active in" id="home" aria-labelledby="home-tab">
       
         <div class="row">

            <div class="col-md-6">
               <!-- TABLE: 현재 콜 정보 -->
               <div class="box box-info">
                  <div class="box-header with-border">
                     <h3 class="box-title">현재 콜 정보</h3>
                  </div>
                  <div class="box-body">
                     <div class="table-responsive" id="div_call_list">
                        <table class="table no-margin">
                           <thead>
                              <tr>
                                 <th>상담원</th>
                                 <th>그룹</th>
                                 <th>주의 단계</th>
                                 <th>흥미 단계</th>
                                 <th>상세조회</th>
                              </tr>
                           </thead>
                           <tbody>
                              <c:forEach items="${callAuditList }" var="callAudit">
                              <tr>
                                 <td><a href="/monitor/agent_view/${callAudit.agentId}">${callAudit.agentName }</a></td>
                                 <td>${callAudit.groupName }</td>
                                 <td>
                                      <c:if test="${callAudit.callStatus eq '1' }">
                                    <c:choose>
                                       <c:when test="${callAudit.customerAngryCount gt angryCountParameter }">
                                          <span class="label label-danger" title="Angry">${callAudit.customerAngryCount }</span>
                                       </c:when>
                                       <c:otherwise>
                                          <span class="label label-success" title="Normal">${callAudit.customerAngryCount }</span>
                                       </c:otherwise>
                                    </c:choose>
                                 </c:if>
                                 <c:if test="${callAudit.callStatus eq '0' }">
                                    <span class="label label-default" title="Angry">${callAudit.customerAngryCount }</span>
                                 </c:if>
                                 </td>
                                 <td>
                                      <c:if test="${callAudit.callStatus eq '1' }">
                                    <c:choose>
                                       <c:when test="${callAudit.agentStressCount gt stressCountParameter }">
                                          <span class="label label-danger" title="Stress">${callAudit.agentStressCount }</span>
                                       </c:when>
                                       <c:otherwise>
                                          <span class="label label-success" title="Normal">${callAudit.agentStressCount }</span>
                                       </c:otherwise>
                                    </c:choose>
                                 </c:if>
                                 <c:if test="${callAudit.callStatus eq '0' }">
                                    <span class="label label-default" title="idle">${callAudit.agentStressCount }</span>
                                 </c:if>
                                 </td>
                                 <td>
                                    <button type="button" class="jsShowModal btn btn-default btn-xs"  data-index="${callAudit.agentId }">
                                       <i class="fa fa-headphones"></i>
                                    </button>
                                 </td>
                              </tr>
                              </c:forEach>
                              <c:if test="${empty callAuditList }">
                                 <tr class="empty">
                                    <td colspan="5">현재 실시간 모니터링 대상으로 등록된 상담원이 없습니다.</td>
                                 </tr>
                              </c:if>
                           </tbody>
                        </table>
                     </div>
                  </div>
               </div>
            </div>

            <div class="col-md-6">
               <div class="box box-primary">
                  <div class="box-header with-border">
                     <h3 class="box-title">지난 달 대비 이번 달 일별 현황 (${searchDTO.startDate} ~ ${searchDTO.endDate})</h3>
                     <span class="pull-right" ><a href="/schedule"><span style="color:#ffffff;"></span></a></span>
                  </div>
                  <div class="box-body">
                     <div class="chart" id="line-chart" style="height: 300px;"></div>
                  </div>
                  <div class="box-footer clearfix">
                     <span class="pull-right">
                           <i class="fa fa-minus" style="color: #54aaff;"></i> 이번 달
                        <i class="fa fa-minus" style="color: #e7cd64;"></i> 지난 달 (주의 단계) 
                         </span>
                  </div>
               </div>
               <!-- BAR CHART -->
               <div class="box box-info">
                  <div class="box-header with-border">
                     <h3 class="box-title"><c:out value="${fn:substring(searchDTO.startDate, 0, 7)}" /> 상담원 업무 현황</h3>
                  </div>
                  <div class="box-body chart-responsive">
                     <div class="chart" id="bar-chart" style="height: 300px;"></div>
                  </div>
                  <div class="box-footer clearfix">
                     <span class="pull-right">
                           <i class="fa fa-minus" style="color: #de8162;"></i> 이번 달 
                         <i class="fa fa-minus" style="color: #e7cd64;"></i> 지난 달 (주의 단계)
                       </span>
                  </div>
               </div>
            </div>
         </div>
          </div>
          
          
      <div role="tabpanel" class="tab-pane fade" id="profile" aria-labelledby="profile-tab">
       
       <%@include file="../system/segment_list.jsp"%>
        </div>
   </div>
          
          

   <!-- Modal 콜 상세 조회 -->
   <div class="modal fade" id="modalCallDetail" tabindex="-1" role="dialog" aria-labelledby="modalCallDetailLabel">
      <!-- /.modal-dialog -->
   </div>


</div>
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
   animation : false
};

var lineChartData = {
      labels: ['00:00','','','','','','','','',''],
   datasets: [
      {
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
      },
      {
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
      }
   ]
};
$(document).ready(function(){
   mainTimer = window.setInterval(updateCallList, 5000);
   modalTimer = window.setInterval(updateChartData, 3000);
   refreshAudioTimer1 = window.setInterval(audioPlayer1Callback, 3000);
   refreshAudioTimer2 = window.setInterval(audioPlayer2Callback, 3000);
   
   function updateCallList(){
      if( isModalShow == true ) return;
      $("#div_call_list").load("/main/call_list_refresh", function( response, status, xhr ) {
         if ( status == "error" ) {
            var msg = "서버의 문제로 화면 갱신에 실패했습니다.";
            $( "#div_call_list" ).html( msg + xhr.status + " " + xhr.statusText );
         } 
      });
   }
   
   function updateChartData() {
      if( isModalShow == false ) return;
      $("#div_call_view").load("/main/call_view_refresh/"+thisAgentId, function( response, status, xhr ) {
         if ( status == "error" ) {
            var msg = "서버의 문제로 화면 갱신에 실패했습니다.";
            $( "#div_call_view" ).html( msg + xhr.status + " " + xhr.statusText );
         } else {
            updateChart();
         }
      });
   }

   function updateChart() {
      lineChartData.labels = $.parseJSON ( $("#callAudit_labelString").val().replace(/\'/g, '"') );
      if ( $("#callAudit_agentState").val() == null || $("#callAudit_agentState").val() == "" ) {
         lineChartData.datasets[0].data = $.parseJSON ( "[0]" );
      } else {
         lineChartData.datasets[0].data = $.parseJSON ( $("#callAudit_agentState").val() );
      }
      if ( $("#callAudit_customerState").val() == null || $("#callAudit_customerState").val() == "" ) {
         lineChartData.datasets[1].data = $.parseJSON ( "[0]" );
      } else {
         lineChartData.datasets[1].data = $.parseJSON ( $("#callAudit_customerState").val() );
      }
       lineChart.update();
       lineChart.render(0, false);
   }

    $(document).on("click", ".jsShowModal", function(e){
       e.preventDefault();
       var agentId = $(this).attr("data-index");
       thisAgentId = agentId;
       $("#modalCallDetail").load(
          "/main/call_view/"+agentId, 
          function( response, status, xhr ) {
             if ( status == "error" ) {
                var msg = "서버의 문제로 해당 정보를 확인할 수 없습니다..";
                $( "#modalCallDetail" ).html( msg + xhr.status + " " + xhr.statusText );
             } else {
                $(this).modal("show");
             }
          }
       );
    });
   
    $("#modalCallDetail").on("hidden.bs.modal", function(){
       isModalShow = false;
       isAudio1Play = false;
       isAudio2Play = false;
       isFirstTimePlayAudio1 = true;
       isFirstTimePlayAudio2 = true;
       isInitializeAudio1 = false;
       isInitializeAudio2 = false;
       window.clearInterval(reloadAudioTimer1);
       window.clearInterval(reloadAudioTimer2);
       $("audio").trigger("pause");
    });
    
    $("#modalCallDetail").on("shown.bs.modal", function(){
       $("#audioPlayer1").on("play", function(e) {
          isAudio1Play = true;
       });
       $("#audioPlayer2").on("play", function(e) {
          isAudio2Play = true;
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

    $(function () {
        //LINE CHART
        var line = new Morris.Line({
          element: 'line-chart',
          resize: true,
          data: [
            <c:if test="${fn:length(dailyLastMonthCallListForChart) > 0}">
            <c:set var="i" value="0" />
            <c:set var="dailyThisMonthCallItem" value="${dailyCallListForChart}" />
          <c:forEach items="${dailyLastMonthCallListForChart}" var="dailyLastMonthCallItem"> {
                  date: '<fmt:formatDate pattern="dd" value="${dailyLastMonthCallItem.statTime}" />', 
               <c:choose>
                  <c:when test="${dailyLastMonthCallItem.angryCount ne null}" >
                  LastMonth: ${dailyLastMonthCallItem.angryCount}
                  </c:when>
                  <c:otherwise>
                  0
                  </c:otherwise>
               </c:choose>
               <c:if test="${dailyThisMonthCallItem[i] ne null}">
                  ,ThisMonth:${dailyThisMonthCallItem[i].stressCount}
               </c:if>
            },
            <c:set var="i" value="${i+1}" />
          </c:forEach>
          </c:if>
          
          <c:if test="${fn:length(dailyLastMonthCallListForChart) eq 0}">
          <c:forEach var="dailyThisMonthCallItem" items="${dailyCallListForChart}"> {
                date: '<fmt:formatDate pattern="dd" value="${dailyThisMonthCallItem.statTime}" />',
                LastMonth: 0,
                  ThisMonth:${dailyThisMonthCallItem.stressCount}
           },
            </c:forEach>
          </c:if>
          ],
          lineColors: ['#e7cd64', '#54aaff'],
          xkey: 'date',
          ykeys: ['LastMonth', 'ThisMonth'],
          labels: ['지난 달', '이번 달'],
          parseTime: false,
          hideHover: 'auto'
        });
    });

    
   $(function () {
       var bar = new Morris.Bar({
         element: 'bar-chart',
         resize: true,
         data: [
      <c:forEach items="${agentCallListForChart}" var="agentCallItem"> {
                 agentName: '${agentCallItem.agentName}', 
               LastMonth: ${agentCallItem.angryCount},
         <c:forEach items="${agentDailyAngryCallForDashBoard}" var="agentDailyItem">         
            <c:choose>
               <c:when test="${agentDailyItem.agentId eq agentCallItem.agentId}">
               ThisMonth: ${agentDailyItem.customerResult}
                   </c:when>
               <c:otherwise>
               ThisMonth: 0
               </c:otherwise>
                </c:choose>
         </c:forEach>
         <c:if test="${empty agentDailyAngryCallForDashBoard}">
               ThisMonth: 0
         </c:if>
           },
      </c:forEach>
         ],
         barColors: ['#e7cd64', '#de8162'],
         xkey: 'agentName',
         ykeys: ['LastMonth', 'ThisMonth'],
         labels: ['1일~어제', '오늘'],
         hideHover: 'auto'
       });
   });

    function audioPlayer1Callback() {
       $("#audioPlayer1").on("pause", function(e) {
           isAudio1Play = false; 
        });
      if ( isModalShow == false ) return;
      
      var audio = document.getElementById('audioPlayer1');
      durationTime1 = audio.duration;

      // 최초의 재생 시간 < 30 초 일 경우, ( 콜 시작 시간 + 30초) 후에 오디오 파일 로딩한다.
      if ( isFirstTimePlayAudio1 ) {
         if ( durationTime1 < audioReloadTime ) {
            gapSecond1 = audioReloadTime - durationTime1;
         } else {
            gapSecond1 = durationTime1;
         }

         isFirstTimePlayAudio1 = false;
         console.log("isFirstTimePlayAudio1=" + isFirstTimePlayAudio1);
      }
      if ( gapSecond1 < audioReloadTime && isInitializeAudio1 == false ) {
         if ( isFirstTimePlayAudio1 ) return;
         setTimeout( function() { audioReload3(audio) }, Math.abs(gapSecond1) * 1000 );
         audioPresentTime1 = 0;
         isInitializeAudio1 = true;
      }
      
      if ( gapSecond1 >= audioReloadTime && isInitializeAudio1 == false ) {
         audioPresentTime1 = durationTime1 - audioReloadTime;
         isAudio1Play = true;
         audio.currentTime = audioPresentTime1;
         reloadAudioTimer1 = window.setInterval( function() { audioReload1(audio) }, audioReloadTime * 1000 );
         isInitializeAudio1 = true;
      }
      //. 30초 주기로 음성파일 refresh 설정 끝
      
      if (isAudio1Play == true ) {
         audio.play();        
      }
    }
    
    function audioPlayer2Callback() {
       $("#audioPlayer2").on("pause", function(e) {
           isAudio2Play = false; 
        });
      if ( isModalShow == false ) return;
      var audio2 = document.getElementById('audioPlayer2');
      durationTime2 = audio2.duration;

       // 30초 주기로 음성파일 refresh 설정
      if ( isFirstTimePlayAudio2 ) {
         if ( durationTime2 < audioReloadTime ) {
            gapSecond2 = audioReloadTime - durationTime2;
         } else {
            gapSecond2 = durationTime2;
         }

         isFirstTimePlayAudio2 = false;
         console.log("isFirstTimePlayAudio2=" + isFirstTimePlayAudio2);
      }
      if ( gapSecond2 < audioReloadTime && isInitializeAudio2 == false ) {
         if ( isFirstTimePlayAudio2 ) return;
         setTimeout( function() { audioReload4(audio2) }, Math.abs(gapSecond2) * 1000 );
         audioPresentTime2 = 0;
         isInitializeAudio2 = true;
      }
      
      if ( gapSecond2 >= audioReloadTime && isInitializeAudio2 == false ) {
         audioPresentTime2 = durationTime2 - audioReloadTime;
         isAudio2Play = true;
         audio2.currentTime = audioPresentTime2;
         reloadAudioTimer2 = window.setInterval( function() { audioReload2(audio2) }, audioReloadTime * 1000 );
         isInitializeAudio2 = true;
      }
      //. 30초 주기로 음성파일 refresh 설정 끝
      
      if (isAudio2Play == true) {
         audio2.play();        
      }
     }
    
    function audioReload1(fAudio1) {
       if ( isAudio1Play == false ) return;
       audioPresentTime1 = fAudio1.currentTime;
       fAudio1.src = $("#audioPlayer1").attr("src").split("?c")[0] + "?cb=" + new Date().getTime();
       fAudio1.load();
       fAudio1.currentTime = audioPresentTime1;
      console.log("audioReload1 reload");
    }
    
    function audioReload2(fAudio2) {
       if ( isAudio2Play == false ) return;
       audioPresentTime2 = fAudio2.currentTime;
       fAudio2.src = $("#audioPlayer2").attr("src").split("?c")[0] + "?cb=" + new Date().getTime();
       fAudio2.load();
       fAudio2.currentTime = audioPresentTime2;
      console.log("audioReload2 reload");
    }
    
    function audioReload3(fAudio3) {
       fAudio3.src = $("#audioPlayer1").attr("src").split("?c")[0] + "?cb=" + new Date().getTime();
       fAudio3.load();
      reloadAudioTimer1 = window.setInterval( function() { audioReload1(fAudio3) }, audioReloadTime * 1000 );
      isAudio1Play = true;
      console.log("audioReload3 load");
    }
    
    function audioReload4(fAudio4) {
       fAudio4.src = $("#audioPlayer2").attr("src").split("?c")[0] + "?cb=" + new Date().getTime();
       fAudio4.load();
      reloadAudioTimer2 = window.setInterval( function() { audioReload2(fAudio4) }, audioReloadTime * 1000 );
      isAudio2Play = true;
      console.log("audioReload4 load");
    }
});
</script>
</html>