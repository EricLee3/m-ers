<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp"%>
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content modal-lg">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">콜 상세조회</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-4"> 
								<div class="info-box">
									<span class="info-box-icon bg-aqua"><i class="fa fa-user"></i></span>
									<div class="info-box-content">
										<span class="info-box-text">고객번호</span> 
										<span class="info-box-number" id="customerNumber">${callAnalysis.customerNumber }</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->

								<div class="info-box">
									<span class="info-box-icon bg-aqua"><i class="fa fa-headphones"></i></span>
									<div class="info-box-content">
										<span class="info-box-text" id="agentName">상담원 : ${callAnalysis.agentName }</span> 
										<span class="info-box-text" id="groupName">(${callAnalysis.groupId})</span> 
										<span class="info-box-number" id="agentNumber">${callAnalysis.agentNumber}</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->

								<div class="info-box">
									<span class="info-box-icon bg-aqua"><i class="fa fa-clock-o"></i></span>
									<div class="info-box-content">
										<span class="info-box-text">시작시간 / 통화시간</span> 
										<span class="info-box-number" id="startTime"><fmt:formatDate pattern="hh:mm:ss" value="${callAnalysis.startTime}" /> / ${callAnalysis.callDuration}초</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<div class="col-md-12" style="height: 30px"></div>
								<div class="col-md-6">
									<span class="pull-left"> 
										<i class="fa fa-minus text-gray"></i> 통화 내용
									</span>
								</div>

							</div>
							<!-- /.col -->

							<div class="col-md-8">
								<!-- LINE CHART -->
								<div class="row margin">
									<canvas id="lineChart" style="height: 250px"></canvas>
									
									<audio id="audioPlayer" src="/resources/wav/${fn:replace(callAnalysis.wavePath, '/home/mecs/PSNR/', '')}" controls preload="auto"></audio>
 								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					</div>
				</div>
				<!-- /.modal-content -->
				<form id="dummyforData" class="hide">
					<input id="callAnalysis_segmentData" type="text" value="[${callAnalysis.segmentData}]">
				</form>
			</div>
