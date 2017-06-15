<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp"%>
<table class="table no-margin">
	<thead>
		<tr>
			<th>상담원</th>
			<th>그룹</th>
			<th>Angry</th>
			<th>Stress</th>
			<th>상세조회</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${callAuditList }" var="callAudit">
		<tr>
			<td><a href="/monitor/agent_view/${callAudit.agentId}">${callAudit.agentName }</a></td>
			<td>${callAudit.groupName }</td>
			<td>
            <c:if test="${callAudit.callStatus eq '1' }">
				<c:choose>
					<c:when test="${callAudit.customerAngryCount gt angryCountParameter }">
						<span class="label label-danger" title="Angry">${callAudit.customerAngryCount }</span>
					</c:when>
					<c:otherwise>
						<span class="label label-success" title="Normal">${callAudit.customerAngryCount }</span>
					</c:otherwise>
				</c:choose>
			</c:if>
			<c:if test="${callAudit.callStatus eq '0' }">
				<span class="label label-default" title="Angry">${callAudit.customerAngryCount }</span>
			</c:if>
			</td>
			<td>
            <c:if test="${callAudit.callStatus eq '1' }">
				<c:choose>
					<c:when test="${callAudit.agentStressCount gt stressCountParameter }">
						<span class="label label-danger" title="Stress">${callAudit.agentStressCount }</span>
					</c:when>
					<c:otherwise>
						<span class="label label-success" title="Normal">${callAudit.agentStressCount }</span>
					</c:otherwise>
				</c:choose>
			</c:if>
			<c:if test="${callAudit.callStatus eq '0' }">
				<span class="label label-default" title="idle">${callAudit.agentStressCount }</span>
			</c:if>
			</td>
			<td>
				<button type="button" class="jsShowModal btn btn-default btn-xs"  data-index="${callAudit.agentId }">
					<i class="fa fa-headphones"></i>
				</button>
			</td>
		</tr>
		</c:forEach>
		<c:if test="${empty callAuditList }">
			<tr class="empty">
				<td colspan="5">현재 실시간 모니터링 대상으로 등록된 상담원이 없습니다.</td>
			</tr>
		</c:if>
	</tbody>
</table>
