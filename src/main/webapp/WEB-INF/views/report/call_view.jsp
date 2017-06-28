<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp"%>
<%
String path = application.getRealPath("/");
System.out.println("path:::::::::::::::" + path);
%>
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content modal-lg">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">
							콜 상세조회
						</h4>
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
										<span class="info-box-number" id="startTime"><fmt:formatDate pattern="HH:mm:ss" value="${callAnalysis.startTime}" /> / ${callAnalysis.callDuration}초</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<div class="col-md-12" style="height: 30px"></div>
								<div class="col-md-6">
									<span class="pull-left"> 
										<i class="fa fa-minus text-info"></i> 고객
									</span>
								</div>
								<div class="col-md-12" style="height: 30px"></div>
								<div class="col-md-6">
									<span class="pull-left"> 
										<i class="fa fa-minus" style="color:#de8162;"></i> 상담원
									</span>
								</div>

							</div>
							<!-- /.col -->

							<div class="col-md-8">
								<!-- LINE CHART -->
								<div class="row margin">
									<canvas id="lineChart" style="height: 250px"></canvas>
 								</div>
 								<span class="col-md-12">
<!--  
									<audio id="audioPlayer" src="/resources/wav/${callAnalysis.mixedWavePath}" controls preload="auto"></audio>
-->									
									<audio id="audioPlayer" src="/resources/wav/${fn:replace(callAnalysis.mixedWavePath, 'C:/home/mecs/PSNR/', '')}" controls preload="auto"></audio>
								</span>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					</div>
				</div>
				<!-- /.modal-content -->
				<form id="dummyforData" class="hide">
					<input id="callAnalysis_customerSegmentData" type="text" value="[${callAnalysis.customerSegmentData}]">
					<input id="callAnalysis_agentSegmentData" type="text" value="[${callAnalysis.agentSegmentData}]">
					<input id="callAnalysis_labelString" type="text" value="[${labelString}]">
				</form>
			</div>
