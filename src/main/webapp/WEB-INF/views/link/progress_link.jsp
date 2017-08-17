<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@include file="../include/taglib.jsp"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="asnetFn" uri="Functions"%>
<%@ taglib prefix="asnetPage" uri="Pagination"%>
            <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
            <link rel="stylesheet" href="/resources/css/font-awesome.min.css">
            <link rel="stylesheet" href="/resources/css/ionicons.min.css">
            <link rel="stylesheet" href="/resources/css/AdminLTE.min.css">
            <link rel="stylesheet" href="/resources/css/skins/_all-skins.min.css">
            <link rel="stylesheet" href="/resources/css/migam.css">
            <link rel="stylesheet" href="/resources/plugins/datatables/dataTables.bootstrap.css">
            <link rel="stylesheet" href="/resources/plugins/ionslider/ion.rangeSlider.css">
            <link rel="stylesheet" href="/resources/plugins/ionslider/ion.rangeSlider.skinHTML5.css">
            <link rel="stylesheet" href="/resources/plugins/morris/morris.css">
            <!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
            <script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
            <script src="/resources/bootstrap/js/bootstrap.min.js"></script>
            <script src="/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
            <script src="/resources/plugins/fastclick/fastclick.js"></script>
            <script src="/resources/js/app.min.js"></script>
            <script src="/resources/plugins/datatables/jquery.dataTables.min.js"></script>
            <script src="/resources/plugins/datatables/dataTables.bootstrap.min.js"></script>
            <script src="/resources/plugins/chartjs/Chart.min.js"></script>
            <script src="/resources/plugins/ionslider/ion.rangeSlider.min.js"></script>
            <script src="/resources/plugins/raphael/raphael-min.js"></script>
            <script src="/resources/plugins/morris/morris.min.js"></script>
        <script>
            $(function() {
                $(document).ready(function() {
                    $("#pop_progress").click(function(){
						window.open('pop_linegraph','pop_linegraph','location=no, directories=no,resizable=no,status=no,toolbar=no,menubar=no,channelmode=no,status=no, height=500px, width=600px, left=0,top=0');  
                	});
               	});
            });
        </script>


           <div class="row margin">
			<div style="width: 236px; height: 72px">											
				<div class="progress">	  											               			                  
				  	<div id="pop_progress" class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:100%; cursor:pointer;">100%</div>
				</div>
			</div>
           </div>