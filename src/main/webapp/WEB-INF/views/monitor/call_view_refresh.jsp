<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp"%>
<span class="info-box-text">시작시간 / 통화시간</span> 
<span class="info-box-number" id="startTime"><fmt:formatDate pattern="HH:mm:ss" value="${callAudit.startTime}" /> / ${callAudit.callDuration}초</span>
<form id="dummyforData" class="hide">
	<input id="callAudit_agentState" type="text" value="[${callAudit.agentState}]">
	<input id="callAudit_customerState" type="text" value="[${callAudit.customerState}]">
	<input id="callAudit_labelString" type="text" value="[${labelString}]">
</form>