/**
 * 
 */
$(document).ready(function(){
	//datePicker 셋팅
	/*var datePicker = {
			monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월' ],
			//dayNamesMin: ['일','월','화','수','목','금','토'],
			weekHeader: 'Wk',
			dateFormat: 'yy-mm-dd',  	// 날짜형식 = 20130329
			autoSize: false,   				// 자동리사이즈 (false 이면 상위 정의에 따름)
			//changeMonth: true,  		// 월변경 가능
			//changeYear: true,  			// 연변경 가능			
			yearRange: 'c-99:c+99', 		// 1990~2020년 까지
			maxDate: '+0d',   				// 오늘 부터 6년 후까지만.  +0d 오늘 이전 날짜만 선택
			minDate: '-6Y' ,                  // 30일 이전까지만 선택 가능        
			gotoCurrent: true					// 
	};*/
	var datePicker = {
			monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월' ],
			dayNamesMin: ['일','월','화','수','목','금','토'],
			weekHeader: 'Wk',
			dateFormat: 'yy-mm-dd',  	// 날짜형식 = 20130329
			autoSize: false,   			// 자동리사이즈 (false 이면 상위 정의에 따름)
			changeMonth: true,  		// 월변경 가능
			changeYear: true,  			// 연변경 가능
			showMonthAterYear: true, 	// 년 위에 월 표시
			//showOn: 'both',   				// 엘리먼트와 이미지 동시사용 (both, button)
			buttonImageOnly: false,  		// 이미지 표시
			buttonText: '달력',  				// 버튼 텍스트 표시
			//buttonImage: '/iscc/resources/img/cal.png', // 이미지 주소
			yearRange: 'c-99:c+99', 		// 1990~2020년 까지
			maxDate: '+0Y',   				// 오늘 부터 6년 후까지만.  +0d 오늘 이전 날짜만 선택
			minDate: '-10Y'                   // 1년 이전까지만 선택 가능            
	};
	
	$("#sdate").datepicker(datePicker);
	$("#edate").datepicker(datePicker);	
	
	
	//날짜 입력하기
	$("#today").click(function(){	//오늘	
		setDate('today');
	});
	$("#yesterday").click(function(){	//어제	
		setDate('yesterday');
	});	
	$("#week").click(function(){	//1주일
		setDate('week');
	});
	$("#month").click(function(){	//1달
		setDate('month1');
	});
	$("#month3").click(function(){	//3달
		setDate('month3');
	});
	
});

//한자리가 되는 숫자에 "0"을 넣어주는 함수
function addzero(n){                        
    return n < 10 ? "0" + n: n;
}
//날짜 형식만들어 주는 함수
function formatdate(date){
	var yyyy =date.getFullYear();
	var mm =date.getMonth()+1;
	var dd =date.getDate();
	
	return yyyy+"-"+addzero(mm)+"-"+addzero(dd);
}

function setDate(setday){
	var today=new Date();
	var tmpDt = new Date();
	
	//어제
	var tmp=tmpDt.setDate(tmpDt.getDate() - 1);
	var yesterday = new Date(tmp);
	
	if(setday=='today'){
		var sdate = formatdate(today); 
		var edate = formatdate(today);
	}
	if(setday=='yesterday'){
		var sdate = formatdate(yesterday); 
		var edate = formatdate(yesterday);
	}
	if(setday=='week'){
		var tmpVal = tmpDt.setDate(tmpDt.getDate() - 7);
		tmpVal = new Date(tmpVal);
		
		var sdate = formatdate(tmpVal); 
		var edate = formatdate(yesterday);
	}	
	if(setday=='month1'){
		var tmpVal = tmpDt.setMonth(tmpDt.getMonth() - 1);
		tmpVal = new Date(tmpVal);
		
		var sdate = formatdate(tmpVal); 
		var edate = formatdate(yesterday);
	}
	if(setday=='month3'){
		var tmpVal = tmpDt.setMonth(tmpDt.getMonth() - 3);
		tmpVal = new Date(tmpVal);
		
		var sdate = formatdate(tmpVal); 
		var edate = formatdate(yesterday);
	}
	if(setday=='thismonth'){
		var tmpVal = tmpDt.setDate(0);
		tmpVal = new Date(tmpVal);
		tmpVal = new Date(tmpVal.setDate(tmpVal.getDate() + 1));
		var sdate = formatDt(tmpVal);
		
		var tmpVal = new Date(today.setMonth(today.getMonth() + 1));
		tmpVal = new Date(tmpVal.setDate(0));
		var edate = formatDt(tmpVal);
	}
	
	$("#sdate").val(sdate);
    $("#edate").val(edate);	
}








