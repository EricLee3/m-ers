<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp"%>
<table id="" class="table table-bordered table-striped">
	<thead>
		<tr>
			<th class="no-sort col-sm-1">고객번호</th>
			<th class="no-sort col-sm-1">상담원</th>
			<th class="no-sort col-sm-1">그룹</th>
			<th class="no-sort col-sm-1">시작시간</th>
			<th class="no-sort col-sm-1">Anger</th>
			<th class="no-sort col-sm-1">Stress</th>
			<th class="no-sort col-sm-1">상세조회</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${callAuditList }" var="callAudit">
		<tr>
			<td>
			<c:if test="${callAudit.callStatus eq '1' }">
				<c:choose>
					<c:when test="${callAudit.customerAngryCount gt angryCountParameter }">
						<span class="auditStatus2" title="Angry" data-angrycount="${agent.angryCount }"><i class="fa fa-square"></i></span>
					</c:when>
					<c:otherwise>
						<span class="auditStatus1" title="Normal" data-angrycount="${agent.angryCount }"><i class="fa fa-square"></i></span>
					</c:otherwise>
				</c:choose>
			</c:if>
			<c:if test="${callAudit.callStatus eq '0' }">
				<span class="auditStatus0" title="idle" data-angrycount="${agent.angryCount }"><i class="fa fa-square"></i></span>
			</c:if>
				${callAudit.customerNumber }
			</td>
			<td>
			<c:if test="${callAudit.callStatus eq '1' }">
				<c:choose>
					<c:when test="${callAudit.agentStressCount gt angryCountParameter }">
						<span class="auditStatus2" title="Angry" data-angrycount="${agent.angryCount }"><i class="fa fa-square"></i></span>
					</c:when>
					<c:otherwise>
						<span class="auditStatus1" title="Normal" data-angrycount="${agent.angryCount }"><i class="fa fa-square"></i></span>
					</c:otherwise>
				</c:choose>
			</c:if>
			<c:if test="${callAudit.callStatus eq '0' }">
				<span class="auditStatus0" title="idle" data-angrycount="${agent.angryCount }"><i class="fa fa-square"></i></span>
			</c:if>
				<a href="/monitor/agent_view/${callAudit.agentId}">${callAudit.agentName }</a>
			</td>
			<td>${callAudit.groupName }</td>
			<td><fmt:formatDate pattern="hh:mm:ss" value="${callAudit.startTime}" /></td>
			<td>${callAudit.customerAngryCount }</td>
			<td>${callAudit.agentStressCount }</td>
			<td><!--  data-toggle="modal" data-target="#myModal"-->
				<button type="button" class="jsShowModal btn btn-default btn-xs"  data-index="${callAudit.agentId }">
					<i class="fa fa-headphones"></i>
				</button>
			</td>
		</tr>
		</c:forEach>
		<c:if test="${empty callAuditList }">
			<tr class="empty">
				<td colspan="7">현재 실시간 모니터링 대상으로 등록된 상담원이 없습니다.</td>
			</tr>
		</c:if>

	</tbody>
</table>
