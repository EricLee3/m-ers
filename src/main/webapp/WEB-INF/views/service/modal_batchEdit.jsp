<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	function rightaction_up(){
		if( $("#right_action_up").is(':checked') ){
			$("#triggertimeChk_up").hide();
			$("#right_action_val_up").val("1");
		}else{
			$("#triggertimeChk_up").show(); 
			$("#right_action_val_up").val("0");
		}
	}
</script>
	<!-- Modal -->
	<div class="modal fade" id="modal_batchEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">작업 수정</h4>
	      </div>
		<form role="form" id="form_batch_update">
			<input type="hidden" name="username" value="${sessionScope.sessionUser.currentUser.userName }" />
			<input type="hidden" name="userid" value="${sessionScope.sessionUser.currentUser.userId}" />
		      <input type="hidden" value="true" id="checkDatepicker" name="checkDatepicker">
		      <input type="hidden" value="" id="index" name="index">					
		      <div class="modal-body">
		      	<div class="form-group">
					<label for="agentName">작업명</label> 
					<input type="text" class="form-control" id="jobName" name="jobName" placeholder="작업명을 입력하세요" value="" maxlength="64">
				</div> 
		      <!-- 	
		      	<div class="form-group">
					<label for="agentName">작업ID</label> 
					<input type="text" class="form-control" id="jobId" name="jobId" placeholder="작업ID를 입력하세요" value="" maxlength="20">
				</div> 
			  -->
                <div class="form-group">
	                <label for="exampleInputEmail1">시작일</label>
	                <div class="input-group date">
		                <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
		                <input type="text" class="form-control pull-right" id="startTime2" name="startTime" value="">
                	</div>
                </div>
                <div class="form-group">
	                <label for="exampleInputEmail1">종료일</label>
	                <div class="input-group date">
		                <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
		                <input type="text" class="form-control pull-right" id="endTime2" name="endTime" value="">
                	</div>
                </div>
                <div class="bootstrap-timepicker">
	                <div class="form-group">
		                <label for="exampleInputEmail1">녹취 시작시간</label>
		                <div class="input-group">
		                	<div class="input-group-addon"><i class="fa fa-clock-o"></i></div>
		                	<input type="text" class="form-control timepicker" id="recordStart2" name="recordStart" value="">
		                </div>
	                </div>
                </div>
                <div class="bootstrap-timepicker">
	                <div class="form-group">
		                <label for="exampleInputEmail1">녹취 종료시간</label>
		                <div class="input-group">
		                	<div class="input-group-addon"><i class="fa fa-clock-o"></i></div>
		                	<input type="text" class="form-control timepicker" id="recordEnd2" name="recordEnd" value="">
		                </div>
	                </div>
	            </div>
	            <div class="bootstrap-timepicker">
	                <div class="form-group">
		                <label for="exampleInputEmail1">분석 시작시간</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                <label for="exampleInputEmail1">바로 실행</label>
						<input type="checkbox" value="1" id="right_action_up" name="right_action_up" onclick="rightaction_up();">
		                <div class="input-group triggertimeChk_up" id="triggertimeChk_up" name="triggertimeChk_up">
		                	<div class="input-group-addon"><i class="fa fa-clock-o"></i></div>
		                	<input type="text" class="form-control timepicker" id="triggerTime2" name="triggerTime" value="">
		                </div>
		                <input type="hidden" name="right_action_val_up" id="right_action_val_up">
					</div>
                </div>
                <div class="form-group">
					<label>그룹 선택</label>
					<select class="form-control" id="groupId" name="groupId">
						<option value="allGroup">전체 그룹</option>
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
						<option value=''>상담원 선택</option>
					</select>
                </div>
                <div class="form-group">
					<label>반복 여부</label>
					<input type="checkbox" id="repeat" name="repeat" value="1">
                </div>
                <input type="hidden" id="status" name="status">
		      </div>
		      	<div class="modal-footer">
			        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">취소</button>
			        <button type="button" class="jsUpdate btn btn-primary">저장</button>
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
	    	checkDatepickerupdate();
	    });
	});
	
	</script>
	