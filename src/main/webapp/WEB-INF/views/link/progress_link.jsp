<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="../include/taglib.jsp"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="asnetFn" uri="Functions"%>
<%@ taglib prefix="asnetPage" uri="Pagination"%>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script>
    	function reqDb(){		
    		var formURL = "req_progress";				   
    	    $.ajax(
    	    {
    	    	        url : formURL,
    	    	        type: "POST",
    	    	        timeout: 3000,	    	        
    	    	        success:function(data, textStatus, jqXHR) 
    	    	        {	    	        	
    	    	       		$(".progress_row").remove();
    	    	       			for(var i=0;i < data.length; i ++){
    	    	       				var content = '';
    	    	       				content += '<div class="row margin" style="background: black; width:236px; height: 72px; position: relative;">';
    	    	       				content += '<div style="width: 236px; height: 32px; font-size: 13; color: red; background-color: blue;"><span style="width:236px; height: 60px; bottom: 0%; position: absolute; text-align: center; ">별로 1안화난거같음</span></div>';	
    	    	       				content += '<div style="width: 236px; height: 40px;">';											
    	    	       				content += '<div class="progress" style="width: 100%; height: 100%;" >';	  											               			                  
    	    	       				content += '<div id="pop_progress" class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:40%; cursor:pointer;">40% (Angry)</div>';
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
            $(function() {
                $(document).ready(function() {
                    $("#pop_progress").click(function(){
						window.open('pop_linegraph','pop_linegraph','location=no, directories=no,resizable=no,status=no,toolbar=no,menubar=no,channelmode=no,status=no, height=500px, width=600px, left=0,top=0');  
                	});
               	});
            });
        </script>

	<div class=" progress_body" >
		<div class="progress_row">
           <div class="row margin" style="background: black; width:236px; height: 72px; position: relative;">
           	<div style="width: 236px; height: 32px; font-size: 13; color: red; background-color: blue;"><span style="width:236px; height: 60px; bottom: 0%; position: absolute; text-align: center; ">별로 1안화난거같음</span></div>	
				<div style="width: 236px; height: 40px;">											
					<div class="progress" style="width: 100%; height: 100%;" >	  											               			                  
			  			<div id="pop_progress" class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:40%; cursor:pointer;">40% (Angry)</div>
					</div>
				</div>
           	</div>
        </div>
    </div>