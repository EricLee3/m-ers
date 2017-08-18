<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="asnetFn" uri="Functions"%>
<%@ taglib prefix="asnetPage" uri="Pagination"%>
<!DOCTYPE html>

<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style type="text/css">
.progress-title{
    font-size: 14px;
    font-weight: bold;
    color: #97a5b6;
    margin-bottom: 5px;
}
.progress{
    height: 20px;
    border: 1px solid #e0e0e0;
    background: transparent;
    border-radius: 50px;
    box-shadow: none;
    padding: 5px 8px;
    overflow: visible;
    margin-bottom: 30px;
}
.progress .progress-bar{
    position: relative;
}
.progress .progress-bar:after{
    content: "";
    width: 1px;
    height: 28px;
    position: absolute;
    right: 0;
    top: -6px;
}
.progress .progress-value{
    font-size: 13px;
    font-weight: bold;
    color: #97a5b6;
    position: absolute;
    bottom: -25px;
    right: 5px;
}
.progress.red .progress-bar:after{
    background: #d9534f;
}
.progress.green .progress-bar:after{
    background: #5cb85c;
}
.progress.blue .progress-bar:after{
    background: #5bc0de;
}
.progress.yellow .progress-bar:after{
    background: #f0ad4e;
}
@-webkit-keyframes animate-positive{
    0% { width: 0%; }
}
@keyframes animate-positive{
    0% { width: 0%; }
}
</style>
</head>
        <script>
        
        
        $(function() {
            $(document).ready(function() {
            	setInterval(req_progress,1000);
           	});
        });
        
        function pop_progress(){
        	window.open('pop_linegraph?agent_id=${agent_id}','pop_linegraph','location=no, directories=no,resizable=no,status=no,toolbar=no,menubar=no,channelmode=no,status=no, height=500px, width=600px, left=0,top=0');  
        	
        }
        
    	function req_progress(){		
    		var formURL = "req_progress";
    	    $.ajax(
    	    {
    	    	        url : formURL,
    	    	        type: "POST",
    	    	        timeout: 3000,	    
    	    	        data: {agent_id : "${agent_id}" ,indicator_name : "${indicator_name}"},
    	    	        success:function(data, textStatus, jqXHR) 
    	    	        {	    	        	
    	    	       		$(".progress_row").remove();
    	    	       			for(var i=0;i < data.length; i ++){
    	    	       				var indicator_level_per =parseInt(data[i].indicator_level / 31 * 100);
    	    	       				var content = '<div class="progress_row" style="width: 236px; height:72px;">';
    	    	       				content += '<b class="progressbar-title">';
    	    	       				if(data[i].customer_script == "" )content += '&nbsp;';
        	    	       			content += data[i].customer_script;
        	    	       			content += '</b>';
        	    	       			content += '<div class="progress red" style="cursor: pointer; margin-top: 5px;" onclick="pop_progress()">';
        	    	       			content += '<div class="progress-bar" style="width: '+indicator_level_per+'%; background: #d9534f;">';
        	    	       			content += '<span class="progress-icon fa fa-check" style="border-color:#ed687c; color:#ed687c;"></span>';
        	    	       			content += '<div class="progress-value">'+indicator_level_per+'%</div>';
        	    	       			content += '</div>';
        	    	       			content += '</div>';
        	    	       			content += '</div>';
    	    	       			$(".progress_body").append(content);
    	    	       		}


    	   		        },
    	   		        error: function(jqXHR, textStatus, errorThrown) 
    	   		        {   		     
    	   		         	alert("에러가 발생하였습니다. 관리자에게 알려주세요.\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);							
    	   		        }
    	  });	
    	}

        </script>
<body style="background-color: black; text-align:center;">
	<div class=" progress_body" align="center">
	<c:forEach items="${ProgressList}" var="progress">
	<fmt:parseNumber var="indicator_level" integerOnly="true" value="${progress.indicator_level / 31 * 100}"/>
		<div class="progress_row" style="width: 236px; height:72px;">
			<b class="progressbar-title">
			<c:if test="${progress.customer_script == ''}">&nbsp;</c:if>
				${progress.customer_script}
			</b>
            <div class="progress red" style="cursor: pointer; margin-top: 5px;" onclick="pop_progress()">
                <div class="progress-bar" style="width: ${indicator_level}%; background: #d9534f">
                    <div class="progress-value">${indicator_level}%</div>
                </div>
            </div>
        </div>
       </c:forEach>
    </div>
    </body>