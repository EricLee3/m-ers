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
        현재까지 작업한 페이지 목록
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
                  <th>최근 수정일</th>
                  <th style="width: 40px">완료 예정일</th>
                </tr>
                <tr>
                  <td><a href="/monitor/agent_list">모니터링 > 상담원 목록</a></td>
                  <td>16.8.1</td>
                  <td>수정계획 없음</td>
                </tr>
                <tr>
                  <td><a href="/monitor/agent_view">모니터링 > 상담원 목록 > 상담원 상세 조회</a></td>
                  <td>16.8.1</td>
                  <td>16.8.3 (4일 완료)</td>
                </tr>
                <tr>
                  <td><a href="/monitor/agent_view">모니터링 > 상담원 목록 > 상담원 정보 수정 (레이어 팝업)</a></td>
                  <td>16.8.1</td>
                  <td>16.8.3</td>
                </tr>
                <tr>
                  <td><a href="/monitor/call_list">모니터링 > 콜 목록</a></td>
                  <td>16.8.1</td>
                  <td>16.8.3</td>
                </tr>
                <tr>
                  <td><a href="/monitor/call_view">모니터링 > 개별 콜 상세 조회</a></td>
                  <td>16.8.1</td>
                  <td>16.8.3</td>
                </tr>
                <tr>
                  <td><a href="/report/call_report">리포팅 > 콜별 리포트</a></td>
                  <td>16.8.1</td>
                  <td>16.8.2 (완료)</td>
                </tr>
                <tr>
                  <td><a href="/report/call_report_view">리포팅 > 콜별 리포트 > 콜 상세 정보</a></td>
                  <td>16.8.1</td>
                  <td>16.8.3</td>
                </tr>
                <tr>
                  <td><a href="/report/agent_report">리포팅 > 상담원별 리포트</a></td>
                  <td>16.8.1</td>
                  <td>16.8.2 (완료)</td>
                </tr>
                <tr>
                  <td><a href="/report/agent_report_term">리포팅 > 상담원별 리포트 > 기간 분석</a></td>
                  <td>16.8.1</td>
                  <td>상담원별 리포트 화면에서 처리</td>
                </tr>
                <tr>
                  <td><a href="/report/customer_report">리포팅 > 고객 리포트</a></td>
                  <td>16.8.1</td>
                  <td>16.8.2 (완료)</td>
                </tr>
                <tr>
                  <td><a href="/report/customer_report_term">리포팅 > 고객 리포트 > 기간 분석</a></td>
                  <td>16.8.1</td>
                  <td>고객 리포트 화면에서 처리</td>
                </tr>
                <tr>
                  <td><a href="/service/batch_list">서비스 > 자동 수행 작업 목록</a></td>
                  <td>16.8.1</td>
                  <td>16.8.1</td>
                </tr>
                <tr>
                  <td><a href="/service/batch_create">서비스 > 자동 수행 작업 목록 > 신규 작업 등록</a></td>
                  <td>16.8.1</td>
                  <td>수정계획 없음</td>
                </tr>
                <tr>
                  <td><a href="/service/batch_view">서비스 > 자동 수행 작업 목록 > 작업 상세  (추가)</a></td>
                  <td>16.8.1</td>
                  <td>수정계획 없음</td>
                </tr>
                <tr>
                  <td><a href="/service/batch_edit">서비스 > 자동 수행 작업 목록 > 수행 등록 수정</a></td>
                  <td>16.8.1</td>
                  <td>수정계획 없음</td>
                </tr>
                <tr>
                  <td><a href="/service/batch_log">서비스 > 자동 수행 작업 목록 > 수행 결과 조회</a></td>
                  <td>16.8.1</td>
                  <td>수정계획 없음</td>
                </tr>
                <tr>
                  <td><a href="/service/config_limit">서비스 > 임계치 설정</a></td>
                  <td>16.8.1</td>
                  <td>16.8.2 (완료)</td>
                </tr>
                <tr>
                  <td><a href="/system/license">시스템 > 라이선스 설정</a></td>
                  <td>16.8.1</td>
                  <td>16.8.2 (완료)</td>
                </tr>
                <tr>
                  <td><a href="/system/user_list">시스템 > 사용자 목록</a></td>
                  <td>16.8.1</td>
                  <td>수정계획 없음</td>
                </tr>
                <tr>
                  <td><a href="/system/user_list">시스템 > 사용자 목록 > 사용자 등록 (레이어 팝업)</a></td>
                  <td>16.8.1</td>
                  <td>수정계획 없음</td>
                </tr>
                <tr>
                  <td><a href="/system/user_list">시스템 > 사용자 목록 > 사용자 정보 수정 (레이어 팝업)</a></td>
                  <td>16.8.1</td>
                  <td>수정계획 없음</td>
                </tr>
                <tr>
                  <td><a href="/system/agent_list">시스템 > 상담원 목록</a></td>
                  <td>16.8.1</td>
                  <td>16.8.3</td>
                </tr>
                <tr>
                  <td><a href="/system/agent_list">시스템 > 상담원 정보 수정 (레이어 팝업)</a></td>
                  <td>16.8.1</td>
                  <td>16.8.3</td>
                </tr>
                <tr>
                  <td><a href="/system/agent_list">시스템 > 상담원 등록 (레이어 팝업)</a></td>
                  <td>16.8.1</td>
                  <td>16.8.3</td>
                </tr>
                <tr>
                  <td><a href="/system/group_list">시스템 > 그룹 관리</a></td>
                  <td>16.8.1</td>
                  <td>16.8.1</td>
                </tr>
                <tr>
                  <td><a href="/system/group_list">시스템 > 그룹 관리 > 그룹 등록 (레이어 팝업)</a></td>
                  <td>16.8.1</td>
                  <td>수정계획 없음</td>
                </tr>
                <tr>
                  <td><a href="/system/group_list">시스템 > 그룹 관리 > 그룹 정보 수정 (레이어 팝업)</a></td>
                  <td>16.8.1</td>
                  <td>수정계획 없음</td>
                </tr>
                <tr>
                  <td><a href="/system/group_agent">시스템 > 그룹 관리 > 그룹별 상담원</a></td>
                  <td>16.8.1</td>
                  <td>16.8.3</td>
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
<!-- 
<ul>
	<li><a href="/monitor/agent_list">모니터링 > 상담원 목록</a></li>
	<li><a href="/monitor/agent_view">모니터링 > 상담원 목록 > 상담원 상세 조회</a></li>
	<li><a href="/monitor/agent_view">모니터링 > 상담원 목록 > 상담원 정보 수정 (레이어 팝업)</a></li>
	<li><a href="/monitor/call_list">모니터링 > 콜 목록</a></li>
	<li><a href="/monitor/call_view">모니터링 > 개별 콜 상세 조회</a></li>
	<li><a href="/service/batch_list">서비스 > 자동 수행 작업 목록</a></li>
	<li><a href="/service/batch_create">서비스 > 자동 수행 작업 목록 > 신규 작업 등록</a></li>
	<li><a href="/service/batch_view">서비스 > 자동 수행 작업 목록 > 작업 상세  (추가)</a></li>
	<li><a href="/service/batch_edit">서비스 > 자동 수행 작업 목록 > 수행 등록 수정</a></li>
	<li><a href="/service/batch_log">서비스 > 자동 수행 작업 목록 > 수행 결과 조회</a></li>
	<li><a href="/service/config_limit">서비스 > 임계치 설정</a></li>
	<li><a href="/report/call_report">리포팅 > 콜별 리포트</a></li>
	<li><a href="/report/call_report_view">리포팅 > 콜별 리포트 > 콜 상세 정보</a></li>
	<li><a href="/report/agent_report">리포팅 > 상담원별 리포트</a></li>
	<li><a href="/report/agent_report_term">리포팅 > 상담원별 리포트 > 기간 분석</a></li>
	<li><a href="/report/customer_report">리포팅 > 고객 리포트</a></li>
	<li><a href="/report/customer_report_term">리포팅 > 고객 리포트 > 기간 분석</a></li>
	<li><a href="/system/license">시스템 > 라이선스 설정</a></li>
	<li><a href="/system/user_list">시스템 > 사용자 목록</a></li>
	<li><a href="/system/user_list">시스템 > 사용자 목록 > 사용자 등록 (레이어 팝업)</a></li>
	<li><a href="/system/user_list">시스템 > 사용자 목록 > 사용자 정보 수정 (레이어 팝업)</a></li>
	<li><a href="/system/agent_list">시스템 > 상담원 목록</a></li>
	<li><a href="/system/agent_list">시스템 > 상담원 정보 수정 (레이어 팝업)</a></li>
	<li><a href="/system/agent_list">시스템 > 상담원 등록 (레이어 팝업)</a></li>
	<li><a href="/system/group_list">시스템 > 그룹 관리</a></li>
	<li><a href="/system/group_list">시스템 > 그룹 관리 > 그룹 등록 (레이어 팝업)</a></li>
	<li><a href="/system/group_list">시스템 > 그룹 관리 > 그룹 정보 수정 (레이어 팝업)</a></li>
	<li><a href="/system/group_agent">시스템 > 그룹 관리 > 그룹별 상담원</a></li>
</ul>
 -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
<%@include file="../include/footer.jsp" %>
</div>
</body>
</html>