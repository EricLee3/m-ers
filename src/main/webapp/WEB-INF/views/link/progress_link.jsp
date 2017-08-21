<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="asnetFn" uri="Functions"%>
<%@ taglib prefix="asnetPage" uri="Pagination"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
    	    	       				var content = '<div class="progress_row">';
    	    	       				content += '<div class="container" style="width: 236px; height:72px; background-color: #174799; ">';
    	    	       				content += '<div class="progress" style="margin: 0px; margin-top: 20px; cursor: pointer;" onclick="pop_progress()">';
    	    	       				content += '<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="'+indicator_level_per+'" aria-valuemin="0" aria-valuemax="100" style="width:'+indicator_level_per+'%; ">';
    	    	       				content += indicator_level_per+'%';
    	    	      			    content += '</div>';
    	    	      			    content += '</div>'; 
    	    	      			    content += '<p style="color:white; font-size: 10px;">'+data[i].customer_script+'</p>';
    	    	      			    content += '</div></div>';
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
<body style="background-color: black; text-align:center; ">
	<div class=" progress_body" >
	<c:forEach items="${ProgressList}" var="progress">
	<fmt:parseNumber var="indicator_level" integerOnly="true" value="${progress.indicator_level / 31 * 100}"/>
		<div class="progress_row">
          <div class="container" style="width: 236px; height:72px; background-color: #174799; ">
			  <div  class="progress" style="margin: 0px; margin-top: 20px; cursor: pointer;" onclick="pop_progress()">
			    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${indicator_level}" aria-valuemin="0" aria-valuemax="100" style="width:${indicator_level}%;">
			      ${indicator_level}%
			    </div>
			  </div> 
			   <p style="color:white; font-size: 10px;">${progress.customer_script}</p>
			</div>
        </div>
       </c:forEach>
    </div>
    </body>