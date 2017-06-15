<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	<script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="/resources/plugins/fastclick/fastclick.js"></script>
	<script src="/resources/js/app.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h2>
                  서비스 > 자동 수행 작업 목록 > 작업 상세
      </h2>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- SELECT2 EXAMPLE -->
      <div class="box box-info">
        <div class="box-header with-border">
          <h3 class="box-title">상세</h3>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>작업제목</label>
                  <span class="form-control">정기 작업 1차</span>
              </div>

              <div class="form-group">
                <label>시작일</label>
                
                <div class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <span class="form-control">07/01/2016</span>
                </div>
                <!-- /.input group -->
              </div>
              
              <!-- time Picker -->
              <div class="bootstrap-timepicker">
                <div class="form-group">
                  <label>녹취화일 시작시간</label>

                  <div class="input-group">
                    <div class="input-group-addon">
                      <i class="fa fa-clock-o"></i>
                    </div>

                    <span class="form-control">07:00 AM</span>
                  </div>
                  <!-- /.input group -->
                </div>
                <!-- /.form group -->
              </div>
              
              <!-- time Picker -->
              <div class="bootstrap-timepicker">
                <div class="form-group">
                  <label>작업 시작시간</label>

                  <div class="input-group">
                    <div class="input-group-addon">
                      <i class="fa fa-clock-o"></i>
                    </div>

                    <span class="form-control">06:30 PM</span>
                  </div>
                  <!-- /.input group -->
                </div>
                <!-- /.form group -->
              </div>
            </div>
            <!-- /.col -->
            <div class="col-md-6">
              <div class="form-group">
                <label>등록일</label>
                
                <div class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <span class="form-control">06/20/2016</span>
                </div>
                <!-- /.input group -->
              </div>

              <div class="form-group">
                <label>종료일</label>
                
                <div class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <span class="form-control">07/31/2016</span>
                </div>
                <!-- /.input group -->
              </div>
              
              <!-- time Picker -->
              <div class="bootstrap-timepicker">
                <div class="form-group">
                  <label>녹취화일 종료시간</label>

                  <div class="input-group">
                    <div class="input-group-addon">
                      <i class="fa fa-clock-o"></i>
                    </div>

                    <span class="form-control">06:00 PM</span>
                  </div>
                  <!-- /.input group -->
                </div>
                <!-- /.form group -->
              </div>
            </div>
            <!-- /.col -->
          </div>
          <!-- /.row -->
        </div>
        <!-- /.box-body -->
        
        <div class="box-footer">
            <button type="button" class="btn btn-default" onclick="location.href='/service/batch_list'">목록</button>
            <span class="pull-right">
	            <button type="button" class="btn btn-info" onclick="location.href='/service/batch_log'">수행 결과 조회</button>
	            <button type="button" class="btn btn-info" onclick="location.href='/service/batch_edit'">수정</button>
	        </span>
        </div>
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
</body>
</html>