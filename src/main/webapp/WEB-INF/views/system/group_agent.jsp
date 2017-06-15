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
  	<link rel="stylesheet" href="/resources/plugins/iCheck/flat/blue.css">
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	<script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="/resources/plugins/fastclick/fastclick.js"></script>
	<script src="/resources/js/app.min.js"></script>
	<script src="/resources/plugins/iCheck/icheck.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
<%@include file="../include/header.jsp" %>
<%@include file="../include/sidebar.jsp" %>
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h2>
                    시스템 > 그룹 관리 > 그룹별 상담원
      </h2>
    </section>

    <!-- Main content -->
    <section class="content">

      <div class="row">
        <div class="col-xs-12">
          <div class="box box-primary">
            <div class="box-header">
              <h3 class="box-title">고객응대 1팀</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive mailbox-messages no-padding ">
              <table class="table table-hover">
                <tr>
                  <th class="text-center"><button type="button" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i></button></th>
                  <th>소속그룹</th>
                  <th>이름</th>
                  <th>내선번호</th>
                  <th>입사일</th>
                  <th>녹취</th>
                  <th>모니터링</th>
                </tr>
                <tr>
                  <td class="text-center"><input type="checkbox"></td>
                  <td>고객응대 1팀</td>
                  <td>양정아</td>
                  <td>3007</td>
                  <td>16.02.24</td>
                  <td>No</td>
                  <td>No</td>
                </tr>
                <tr>
                  <td class="text-center"><input type="checkbox"></td>
                  <td>고객응대 1팀</td>
                  <td>김숙희</td>
                  <td>3014</td>
                  <td>16.01.01</td>
                  <td>No</td>
                  <td>No</td>
                </tr>
                <tr>
                  <td class="text-center"><input type="checkbox"></td>
                  <td>고객응대 1팀</td>
                  <td>주혜리</td>
                  <td>3017</td>
                  <td>16.01.01</td>
                  <td>No</td>
                  <td>No</td>
                </tr>
                <tr>
                  <td class="text-center"><input type="checkbox"></td>
                  <td>고객응대 1팀</td>
                  <td>오혜란</td>
                  <td>3014</td>
                  <td>16.01.01</td>
                  <td>No</td>
                  <td>No</td>
                </tr>
                <tr>
                  <td class="text-center"><input type="checkbox"></td>
                  <td>고객응대 1팀</td>
                  <td>나미숙</td>
                  <td>3018</td>
                  <td>16.01.01</td>
                  <td>No</td>
                  <td>No</td>
                </tr>
                <tr>
                  <td class="text-center"><input type="checkbox"></td>
                  <td>고객응대 1팀</td>
                  <td>이미영</td>
                  <td>3019</td>
                  <td>16.01.01</td>
                  <td>No</td>
                  <td>No</td>
                </tr>
              </table>
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix">
                <button type="button" class="btn btn-default pull-left" onclick="location.href='/system/group_list'">그룹 목록 보기</button>
              	<div class="pull-right">
                	<button type="button" class="btn btn-primary">선택 상담원 제외</button>
                	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal_agentAdd">그룹에 상담원 추가</button>
                </div>
            </div>
            
          </div>
          <!-- /.box -->
        </div>
      </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
<%@include file="../include/footer.jsp" %>
	<!-- Modal 상담원 그룹에 추가 -->
	<div class="modal fade" id="modal_agentAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">상담원 선택</h4>
	      </div>
	      <form role="form">
		      <div class="modal-body" id="slimtest1">
	              <table class="table table-hover">
	                <tr>
	                  <th class="text-center">선택</th>
	                  <th>이름</th>
	                  <th>녹취</th>
	                  <th>모니터링</th>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>양정아</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>김숙희</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>주혜리</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>오혜란</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>나미숙</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>이미영</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>오혜란</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>나미숙</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>이미영</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>오혜란</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>나미숙</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>이미영</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>오혜란</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>나미숙</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>이미영</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>오혜란</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>나미숙</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>이미영</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>오혜란</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>나미숙</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	                <tr>
	                  <td class="text-center"><input type="checkbox"></td>
	                  <td>이미영</td>
	                  <td>No</td>
	                  <td>No</td>
	                </tr>
	              </table>

		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">취소</button>
		        <button type="submit" class="btn btn-primary">선택 상담원 그룹에 추가</button>
		      </div>
	      </form>
	    </div>
	    <!-- /.modal-content -->
	  </div>
	  <!-- /.modal-dialog -->
	</div>
</div>
<script>
  $(function () {
    //Enable iCheck plugin for checkboxes
    //iCheck for checkbox and radio inputs
    $('.mailbox-messages input[type="checkbox"]').iCheck({
      checkboxClass: 'icheckbox_flat-blue',
      radioClass: 'iradio_flat-blue'
    });

    //Enable check and uncheck all functionality
    $(".checkbox-toggle").click(function () {
      var clicks = $(this).data('clicks');
      if (clicks) {
        //Uncheck all checkboxes
        $(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
        $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
      } else {
        //Check all checkboxes
        $(".mailbox-messages input[type='checkbox']").iCheck("check");
        $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
      }
      $(this).data("clicks", !clicks);
    });

    //Handle starring for glyphicon and font awesome
    $(".mailbox-star").click(function (e) {
      e.preventDefault();
      //detect type
      var $this = $(this).find("a > i");
      var glyph = $this.hasClass("glyphicon");
      var fa = $this.hasClass("fa");

    });
  });
  
  $('#slimtest1').slimScroll({
	    height: '400px',
	    alwaysVisible: true
	});
</script>
</body>
</html>