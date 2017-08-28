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
window.onload = function () {
	document.getElementById('dashboard').setAttribute("class","active");
    document.getElementById('segment').setAttribute("class","");
}


$(document).on("click", ".jsSearch1", function(e){
	      document.getElementById('dashboard').setAttribute("class","active");
	      document.getElementById('segment').setAttribute("class","");
});

$(document).on("click", ".jsSearch2", function(e){
	      document.getElementById('dashboard').setAttribute("class","");
	      document.getElementById('segment').setAttribute("class","active");
});

</script>
<body class="hold-transition skin-blue sidebar-mini">
      <!-- Main content -->
   <section class="content">
      <ul id="myTab" class="nav nav-tabs" role="tablist">
   <%-- 
     <li role="presentation" class="active"><a data-target="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true" onclick="b();">DashBoard</a></li>
    <li role="presentation" class=""><a data-target="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true" onclick="a();">시스템 상태</a></li>
   </ul>
     <div role="tabpanel" class="tab-pane fade active in" id="home" aria-labelledby="home-tab">

   <iframe name="LayerAttributeView" id="LayerAttributeView" src="/main5" width="100%" height="900px;"frameborder="0"></iframe>
--%>
<%--
          <li class="" id="dashboard"><a href="/main5" target="iframe2" class="jsSearch1">DashBoard</a></li>
           <li class="" id="segment"><a href="/system/segment_list" target="iframe2" class="jsSearch2">시스템 상태</a></li>
         </ul>
       
            <iframe src="/main5" width="100%"  scrolling="no" frameborder="0" border="0" bordercolor="#000000" marginwidth="0" marginheight="0" name="iframe2" id="iframe2"></iframe>
             --%>
             <li class="" id="segment"><a href="/system/segment_list" target="iframe2" class="jsSearch2">시스템 상태</a></li>
             </ul>
             <iframe src="/system/segment_list" width="100%"  scrolling="no" frameborder="0" border="0" bordercolor="#000000" marginwidth="0" marginheight="0" name="iframe2" id="iframe2"></iframe>
      </section>

   <!-- Modal 콜 상세 조회 -->
   <div class="modal fade" id="modalCallDetail" tabindex="-1" role="dialog" aria-labelledby="modalCallDetailLabel">
      <!-- /.modal-dialog -->
   </div>

<script>
 function resize_frame(id) {
 var frm = document.getElementById("iframe2");
 function resize() {
 var ms_ie = false;
  var ua = window.navigator.userAgent;
  var old_ie = ua.indexOf('MSIE ');
  var new_ie = ua.indexOf('Trident/');
 
  if ((old_ie > -1) || (new_ie > -1)) {
   ms_ie = true;
  }
 
  if ( ms_ie ) {
   //IE specific code goes here
  var iframe2Height = frm.contentWindow.document.body.scrollHeight;
  frm.height=iframe2Height+20;
  }else{
  frm.style.height = "auto"; // set default height for Opera
  contentHeight = frm.contentWindow.document.documentElement.scrollHeight;
  frm.style.height = contentHeight + 23 + "px"; // 23px for IE7
  }
 }
 if (frm.addEventListener) {
 frm.addEventListener('load', resize, false);
 } else {
 frm.attachEvent('onload', resize);
 }
}
resize_frame('iframe'); 
</script>
</body>
</html>