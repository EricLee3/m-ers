<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>VoiceCream / 미래손 감정분석 솔루션</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/font-awesome.min.css">
<link rel="stylesheet" href="/resources/css/ionicons.min.css">
<link rel="stylesheet" href="/resources/css/AdminLTE.min.css">
<link rel="stylesheet" href="/resources/css/migam.css">
<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
<script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="hold-transition login-page" style="background-color: #fff;">

	<div class="login-box">
		<div class="login-logo">
			<h4 class="text-info">콜센터를 위한 감정 인식 서비스</h4>
			<strong>VoiceCream</strong>
		</div>
		<div class="login-box-body">
			<p class="login-box-msg">사용자 아이디와 암호를 입력하십시오.</p>
			<form method="post" id="form_login">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" placeholder="ID"
						id="userId" name="userId" maxlength="20"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" placeholder="Password"
						id="passwd" name="passwd" maxlength="32"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8"></div>
					<div class="col-xs-4">
						<button type="button"
							class="jsLogin btn btn-primary btn-block btn-flat">로그인</button>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-12">
			<h5 class="text-info">
				주식회사 <strong>미래손</strong> | <br>서울시 금천구 서부샛길 606 대성 디폴리스 A동
				1301호
			</h5>
		</div>
	</div>
	<script>
		$(window).keydown(function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				$("#form_login").submit();
			}
		});
		$(document).on("click", ".jsLogin", function(e) {
			if ($.trim($("#userId").val()).length < 1) {
				alert("아이디를 입력해주세요.");
				$("#userId").focus();
				return false;
			}
			if ($.trim($("#passwd").val()).trim().length < 1) {
				alert("암호를 입력해주세요.");
				$("#passwd").focus();
				return false;
			}

			$("#form_login").submit();
		});

		$(document).ready(function() {
			//get Funtion
			function getRequest() {
				if (location.search.length > 1) {
					var get = new Object();
					var ret = location.search.substr(1).split('&');
					for (var i = 0; i < ret.length; i++) {
						var r = ret[i].split('=');
						get[r[0]] = r[1];
					}
					return get;
				} else {
					return false;
				}
			}

			var get = getRequest();
			var flag = get['flag'];

			if (flag != null && flag != '') {
				if (flag == "1") {
					alert("세션이 끊겼습니다.");
				} else {
					alert("아이디 패스워드를 확인해주세요.");
				}

				var protocol = location.protocol + "//";
				var host = location.host;
				var login = "/login";

				window.top.location.href = protocol + host + login;
			}
		});
	</script>
</body>
</html>
