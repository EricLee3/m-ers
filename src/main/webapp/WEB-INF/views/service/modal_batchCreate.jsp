<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp"%>
<script>
	function rightaction(){
		if( $("#right_action").is(':checked') ){
			$("#triggertimeChk").hide();
			$("#right_action_val").val("1");
		}else{
			$("#triggertimeChk").show(); 
			$("#right_action_val").val("0");
		}
	}
</script>
	<!-- 등록 Modal -->
	<div class="modal fade" id="modal_batchCreate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">신규 수행 등록</h4>
	      </div>
		
		<form role="form" id="form_batch_create" action="" method="post">
			<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
			<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
			<input type="hidden" value="true" id="checkDatepicker" name="checkDatepicker">					
		      <div class="modal-body">
		      	<div class="form-group">
					<label for="agentName">작업명 <span class="text-danger">*</span></label><span class="pull-right"><span class="text-danger"><strong>*</strong></span>는 필수입력정보입니다.</span> 
					<input type="text" class="form-control" id="jobName" name="jobName" value="" maxlength="64">
					 
					<input type="hidden" class="form-control" id="jobId" name="jobId" value="JOB_ID_${nowdate }" maxlength="20">
					
				</div>
                <div class="form-group">
	                <label for="exampleInputEmail1">시작일 <span class="text-danger">*</span></label>
	                <div class="input-group date">
		                <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
		                <input type="text" class="form-control pull-right" id="startTime" name="startTime">
                	</div>
                </div>
                <div class="form-group">
	                <label for="exampleInputEmail1">종료일 <span class="text-danger">*</span></label>
	                <div class="input-group date">
		                <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
		                <input type="text" class="form-control pull-right" id="endTime" name="endTime">
                	</div>
                </div>
                <div class="bootstrap-timepicker">
	                <div class="form-group">
		                <label for="exampleInputEmail1">녹취 시작시간</label>
		                <div class="input-group">
		                	<div class="input-group-addon"><i class="fa fa-clock-o"></i></div>
		                	<input type="text" class="form-control timepicker" id="recordStart" name="recordStart" value="09:00">
		                </div>
	                </div>
                </div>
                <div class="bootstrap-timepicker">
	                <div class="form-group">
		                <label for="exampleInputEmail1">녹취 종료시간</label>
		                <div class="input-group">
		                	<div class="input-group-addon"><i class="fa fa-clock-o"></i></div>
		                	<input type="text" class="form-control timepicker" id="recordEnd" name="recordEnd" value="18:00">
		                </div>
	                </div>
	            </div>
	            <div class="bootstrap-timepicker">
	                <div class="form-group">
		                <label for="exampleInputEmail1">분석 시작시간</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                <label for="exampleInputEmail1">바로 실행</label>
						<input type="checkbox" value="1" id="right_action" name="right_action" onclick="rightaction();">
		                <div class="input-group triggertimeChk" id="triggertimeChk" name="triggertimeChk">
		                	<div class="input-group-addon"><i class="fa fa-clock-o"></i></div>
		                	<input type="text" class="form-control timepicker" id="triggerTime" name="triggerTime" value="18:30">
		                </div>
		                <input type="hidden" name="right_action_val" id="right_action_val">
					</div>
                </div>
                <div class="form-group">
					<label>그룹 선택</label>
					<select class="form-control" id="selectAgentGroup" name="groupId">
						<option value="">전체 그룹</option>
						<c:forEach items="${agentGroupList}" var="agentGroup">	
						<option value="${agentGroup.groupId }">${agentGroup.groupName }</option>
						</c:forEach>
					</select>
                </div>
                <div class="form-group">
					<label>상담원 선택</label>
					<!-- 상담원 이름을 표시하기 위해 agentName 대신 searchIsNotice 를 사용했다. -->
					<input type="hidden" id="agentName" name="searchIsNotice" value="">
					<select class="form-control" id="agentId" name="agentId">
						<option value=''>전체 상담원</option>
						<c:forEach items="${agentList}" var="agent">	
						<option value="${agent.agentId }">${agent.agentName }</option>
						</c:forEach>
					</select>
                </div>
                <div class="form-group">
					<label>반복 여부</label>
					<input type="checkbox" value="1" id="repeat" name="repeat">
                </div>
                <input type="hidden" value="0" id="status" name="status">
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">취소</button>
		        <button type="button" class="jsCreate btn btn-primary">등록</button>
		      </div>
		</form>
	    </div>
	  </div>
	</div>
	
	<script>
	$(document).ready(function(){
		//달력(시작일,종료일)에서 .day(일)를 클릭했을때마다 실행되는 스크립트 입니다.
	    $(document).on('click', '.day', function(e){
	    	e.preventDefault();
	    	checkDatepicker();
	    });
	});
	
	</script>
