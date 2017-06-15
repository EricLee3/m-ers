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
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	<script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="/resources/plugins/fastclick/fastclick.js"></script>
	<script src="/resources/js/app.min.js"></script>
	<script src="/resources/plugins/chartjs/Chart.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
<%@include file="../include/header.jsp" %>
<%@include file="../include/sidebar.jsp" %>
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h2>
        	전체 화면 목록
      </h2>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Tables</a></li>
        <li class="active">Simple</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-md-12">
          <div class="box">
            <div class="box-header with-border">
              <h3 class="box-title">진행 내역</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table class="table table-bordered">
			    <colgroup>
			        <col class="col-sm-6">
			        <col class="col-sm-3">
			        <col class="col-sm-3">
			    </colgroup>
                <tr>
                  <th>메뉴</th>
                  <th>최근 업데이트</th>
                  <th style="width: 40px">계획</th>
                </tr>
                <!-- 
                <tr>
                  <td>전체 업데이트 </td>
                  <td>16.9.25</td>
                  <td>9/26 회의용</td>
                </tr>
                 -->
                <tr>
                  <td><a href="/monitor/agent_list">모니터 > 상담원 목록</a></td>
                  <td>16.9.25</td>
                  <td><span class="text-aqua">완료</span></td>
                </tr>
                <tr>
                  <td><a href="/monitor/agent_view/Agent3">모니터 > 상담원 목록 > 상담원 상세 조회</a></td>
                  <td>16.9.27</td>
                  <td>9.28 (<span class="text-aqua">완료</span>)</td>
                </tr>
                <tr>
                  <td><a href="/monitor/call_list">모니터 > 콜 목록</a></td>
                  <td>16.9.27</td>
                  <td>9.28 (<span class="text-aqua">완료</span>)</td>
                </tr>
                <tr>
                  <td><a href="/report/call_report">리포트 > 콜별 리포트</a></td>
                  <td>16.9.25</td>
                  <td>9.29 (<span class="text-aqua">완료</span>)</td>
                </tr>
                <tr>
                  <td><a href="/report/customer_report">리포트 > 고객 리포트</a></td>
                  <td>16.9.25</td>
                  <td>9.29 (<span class="text-aqua">완료</span>)</td>
                </tr>
                <tr>
                  <td><a href="/report/hour_report">통계 > 시간대별 통계</a></td>
                  <td>16.9.25</td>
                  <td>9.28 (<span class="text-aqua">완료</span>)</td>
                </tr>
                <tr>
                  <td><a href="/report/day_report">통계 > 일별 통계</a></td>
                  <td>16.9.25</td>
                  <td>9.28 (<span class="text-aqua">완료</span>)</td>
                </tr>
                <tr>
                  <td><a href="/report/month_report">통계 > 월별 통계</a></td>
                  <td>16.9.25</td>
                  <td>9.28 (<span class="text-aqua">완료</span>)</td>
                </tr>
                <!-- 
                <tr>
                  <td><a href="/report/week_report">통계 > 주간별 통계</a></td>
                  <td>16.9.25</td>
                  <td>9.29</td>
                </tr> -->
                <tr>
                  <td><a href="/report/agent_report">통계 > 상담원별 통계</a></td>
                  <td>16.9.25</td>
                  <td>9.28 (<span class="text-aqua">완료</span>)</td>
                </tr>
                <tr>
                  <td><a href="/report/performance_report">통계 > 근무성과별 통계</a></td>
                  <td>16.9.25</td>
                  <td>9.29 (<span class="text-aqua">완료</span>)</td>
                </tr>
                <tr>
                  <td><a href="/service/batch_list">서비스 > 자동 수행 작업 목록</a></td>
                  <td>16.9.25</td>
                  <td>9.29 (<span class="text-aqua">완료</span>)</td>
                </tr>
                <tr>
                  <td><a href="/service/batch_log">서비스 > 자동 수행 작업 이력</a></td>
                  <td>16.9.25</td>
                  <td>9.29 (<span class="text-aqua">완료</span>)</td>
                </tr>
                <tr>
                  <td><a href="/service/config_limit">서비스 > 임계치 설정</a></td>
                  <td>16.9.25</td>
                  <td>9.30 (<span class="text-aqua">완료</span>)</td>
                </tr>
                <tr>
                  <td><a href="/system/license">시스템 > 라이선스 설정</a></td>
                  <td>16.9.25</td>
                  <td>16.10.4 (<span class="text-aqua">완료</span>)</td>
                </tr>
                <tr>
                  <td><a href="/system/user_list">시스템 > 사용자 목록</a></td>
                  <td>16.9.25</td>
                  <td><span class="text-aqua">완료</span></td>
                </tr>
                <tr>
                  <td><a href="/system/agent_list">시스템 > 상담원 목록</a></td>
                  <td>16.9.25</td>
                  <td><span class="text-aqua">완료</span></td>
                </tr>
                <tr>
                  <td><a href="/system/group_list">시스템 > 그룹 관리</a></td>
                  <td>16.9.25</td>
                  <td><span class="text-aqua">완료</span></td>
                </tr>
                <tr>
                  <td><a href="/">대시 보드</a></td>
                  <td>16.9.25</td>
                  <td>10.4(<span class="text-aqua">완료</span>)</td>
                </tr>
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
<%@include file="../include/footer.jsp" %>
</div>
</body>
</html>