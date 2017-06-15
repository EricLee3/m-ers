
	
	$(document).ready(function(){
		
		var currentTime = new Date();
		var month = currentTime.getMonth() + 1;
		var day = currentTime.getDate();
		var year = currentTime.getFullYear();	
		
		if(month < 10){
			month = "0" + month;
		}
		if(day < 10){
			day = "0" + day;
		}
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

		$("#sdate2").datepicker(datePicker);
		$("#edate2").datepicker(datePicker);

		$("#today").click(function(){
			$("#sdate").val(year+"-"+month+"-"+day);
			$("#edate").val(year+"-"+month+"-"+day);
				
		});		
		$("#week").click(function(){			
			var currentTime2 = new Date();
			currentTime2.setFullYear(year, month-1, day-7);			
			var month2 = currentTime2.getMonth()+1;
			var day2 = currentTime2.getDate();
			var year2 = currentTime2.getFullYear();	
			if(month2 < 10){
				month2 = "0" + month2;
			}
			if(day2 < 10){
				day2 = "0" + day2;
			}
			
			$("#sdate").val(year2+"-"+month2+"-"+day2);
			$("#edate").val(year+"-"+month+"-"+day);
			
		});
		
		$("#month").click(function(){
			
			var currentTime2 = new Date();
			currentTime2.setFullYear(year, month-1, day);			
			var month2 = currentTime2.getMonth();
			var day2 = currentTime2.getDate();
			var year2 = currentTime2.getFullYear();	
			if(month2 < 10){
				month2 = "0" + month2;
			}
			if(day2 < 10){
				day2 = "0" + day2;
			}
			$("#sdate").val(year2+"-"+month2+"-"+day2);
			$("#edate").val(year+"-"+month+"-"+day);
			
		});
		
		$("#today2").click(function(){
			$("#sdate2").val(year+"-"+month+"-"+day);
			$("#edate2").val(year+"-"+month+"-"+day);
				
		});		
		$("#week2").click(function(){			
			var currentTime2 = new Date();
			currentTime2.setFullYear(year, month-1, day-7);			
			var month2 = currentTime2.getMonth()+1;
			var day2 = currentTime2.getDate();
			var year2 = currentTime2.getFullYear();	
			if(month2 < 10){
				month2 = "0" + month2;
			}
			if(day2 < 10){
				day2 = "0" + day2;
			}
			
			$("#sdate2").val(year2+"-"+month2+"-"+day2);
			$("#edate2").val(year+"-"+month+"-"+day);
			
		});
		
		$("#month2").click(function(){
			
			var currentTime2 = new Date();
			currentTime2.setFullYear(year, month-1, day);			
			var month2 = currentTime2.getMonth();
			var day2 = currentTime2.getDate();
			var year2 = currentTime2.getFullYear();	
			if(month2 < 10){
				month2 = "0" + month2;
			}
			if(day2 < 10){
				day2 = "0" + day2;
			}
			$("#sdate2").val(year2+"-"+month2+"-"+day2);
			$("#edate2").val(year+"-"+month+"-"+day);
			
		});
	});