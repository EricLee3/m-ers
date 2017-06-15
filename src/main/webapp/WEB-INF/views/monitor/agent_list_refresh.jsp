<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp"%>
	<c:set var="j" value="0" />
	<c:forEach items="${groupList }" var="group" >
	<div class="col-md-4">
		<div class="small-box bg-light-blue">
			<div class="inner">
				<h5>${group.groupName } ( ${group.agentCount }명 )</h5>
			</div>
			<div class="icon">
				<h1>
					<i class="ion ion-person"></i>
				</h1>
			</div>
		</div>
		<div class="row">
			<c:set var="i" value="0" />
			<c:forEach items="${group.agentList}" var="agent" >
			<div class="col-sm-6 col-xs-12">
				<button type="button" class="btn btn-default bg-flat btn-block btn-sm" onclick="location.href='/monitor/agent_view/${agent.agentId}'">
				<c:if test="${agent.isAudit eq '1' }">
					<c:if test="${agent.callStatus eq '1' }">
						<c:choose>
							<c:when test="${agent.angryCount gt angryCountParameter }">
								<span class="pull-left auditStatus2" title="Angry" data-angrycount="${agent.angryCount }"><i class="fa fa-square"></i></span>
							</c:when>
							<c:otherwise>
								<span class="pull-left auditStatus1" title="Normal" data-angrycount="${agent.angryCount }"><i class="fa fa-square"></i></span>
							</c:otherwise>
						</c:choose>
					</c:if>
					<c:if test="${agent.callStatus eq '0' }">
						<span class="pull-left auditStatus0" title="idle" data-angrycount="${agent.angryCount }"><i class="fa fa-square"></i></span>
					</c:if>
				</c:if>
					<c:set var="agentNumber" value="${agent.agentNumber }"/>
					<c:set var="agentNumberlen" value="${fn:length(agentNumber)}"/>
					${fn:substring(agentNumber,agentNumberlen-4,agentNumberlen)} ${agent.agentName }
				</button>
			</div>
			<c:if test="${i%2 eq '1'}">
			<div class="col-sm-12 col-xs-12" style="height:5px;"></div>
			</c:if>
			<c:set var="i" value="${i+1 }" />
			</c:forEach>
			<div class="row">
				<div class="col-lg-12">
					<div class="small-box bg-default"></div>
				</div>
			</div>
		</div>
	</div>
	<c:set var="j" value="${j+1 }" />
	</c:forEach>
