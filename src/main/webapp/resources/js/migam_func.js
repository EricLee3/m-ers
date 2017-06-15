/**
 * MIGAM에서 사용할 기초적인 Javascript 함수 및 변수를 모아놓은 파일입ㄴ이다.
 */
$(document).ready(function() {
	$.ajaxSetup({
		type : 'post',
		async : true,
		cache : false,
		contentType : 'application/x-www-form-urlencoded;charset=utf-8',
		beforeSend : function(jqXHR, settings) {
			$.blockUI({
				baseZ : 99999999,
				message : '요청을 처리중입니다.',
				centerY : 0,
				css : {
					width : '250px',
					height : '15px',
					top : '10px',
					left : '',
					right : '10px',
					border : 'none',
					padding : '15px',
					backgroundColor : '#000',
					'-webkit-border-radius' : '10px',
					'-moz-border-radius' : '10px',
					opacity : .5,
					color : '#fff'
				},
				overlayCSS : {
					backgroundColor : '#000',
					opacity : 0,
					cursor : 'wait'
				}
			});
		},
		error : function(xhr, textStatus, errorThrown) {
			$.unblockUI();
			if (xhr.status == 0) {
				alert('Please Check Your Network.');
			} else if (xhr.status == 404) {
				alert('Requested URL not found.');
			} else if (xhr.status == 500) {
				alert('Internel Server Error.');
			} else if (textStatus == 'parsererror') {
				alert('Parsing JSON Request failed.');
				alert('Unknow Error.\n' + xhr.status + '\n' + textStatus + '\n' + errorThrown);
			} else if (textStatus == 'timeout') {
				alert('Request Time out.');
			} else {
				alert('Unknow Error.\n' + xhr.status + '\n' + textStatus + '\n' + errorThrown);
			}
		},
		complete : function(data) {
			$.unblockUI();
		}
	});
	
});


function checkAttachExt(fileExt, type) {
	if (!fileExt)
		return false;
	var uploadFlag = false;

	var imgArr = new Array("jpeg", "jpg", "gif", "png", "jif");
	var fileArr = new Array("hwp", "doc", "docx", "pdf", "zip");
	var exeArr = new Array("exe", "bat", "sh", "jsp");
	var uploadArr = new Array();
	
	if (type == "exceptExe") type = "all";
	if (type == "file") type = "all";

	if ( !type || type == "all" ) {
		uploadArr = imgArr.concat(fileArr);
		
		//첨부파일에 모든 종류의 파일(실행파일 제외)을 업로드 할 수 있도록 변경합니다. 20131001		
		uploadArr = exeArr;
		var exeFlag = true;
		for ( var i = 0; i < uploadArr.length; i++) {
			if (uploadArr[i] == fileExt.toLowerCase()) {
				exeFlag = false;
			}
		}
		if (exeFlag) {
			return true;
		} else {
			alert("실행파일은 업로드 하실 수 없습니다.");
			return false;
		}
		
	} else if (type == "img") {
		uploadArr = imgArr;
	}

	for ( var i = 0; i < uploadArr.length; i++) {
		if (uploadArr[i] == fileExt.toLowerCase()) {
			uploadFlag = true;
		}
	}
	if (!uploadFlag) {
		alert("다음 확장자만 업로드 하실 수 있습니다.\n" + uploadArr.join(", "));
		return false;
	}
	return true;
}

/**
 * String.isEmail()
 * 
 * @returns
 */
if (!String.prototype.isEmail) {
	String.prototype.isEmail = function() {
		var str = this;
		var pattern  = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		return pattern.test(str);
	};
}

/**
 * String.isPhone()
 * 
 * @returns
 */
if (!String.prototype.isPhone) {
	String.prototype.isPhone = function() {
		var str = this;
		var pattern = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;
		return pattern.test(str);
	};
}


if (!migam) {
	var migam= {};
};


