<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/taglib.jsp"%>
	<script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<script>
//var arr1 = ['A', 'B', 'C', 'D'];
//var arr2 = ['C', 'D', 'E', 'F'];

var arr1 = ['A', 'B', 'C', 'D'];
var arr2 = ['E', 'F'];
var arr2 = ['E', 'F'];


$.intersect = function(a,b){
	return $.grep(a,function(i){
		return $.inArray(i,b)>-1;});
	};
(function() {


  // Intersection
  console.log( $.intersect(arr1, arr2) );
  
  if( $.intersect(arr1, arr2).length > 0){
	 alert( $.intersect(arr1, arr2) );
  }

});
</script>