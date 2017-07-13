<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/taglib.jsp"%>
	<script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<script type="text/javascript" src="/resources/highcharts/highcharts.js"></script>
	<script type="text/javascript" src="/resources/highcharts/exporting.js"></script>
<script>
	$(function () {
	    $(document).ready(function() {
	        Highcharts.setOptions({
	            global: {
	                useUTC: false
	            }
	        });
	    
	        var chart;
	        $('#container').highcharts({
	            chart: {
	                type: 'spline',
	                animation: Highcharts.svg, // don't animate in old IE
	                marginRight: 10,
	                events: {
	                    load: function() {
	                        // set up the updating of the chart each second
	                       	var series = this.series, chk=true; 
	                        
	                        setInterval(function() {
	                            var x = (new Date()).getTime(),
	                                data = [Math.random(),Math.random(),Math.random(),Math.random()];
	                            
	                                 for(var i=0; i < data.length; i ++){
	                                	 if(i == data.length-1)chk=true;
	                                	 else chk=false;
	                                	 series[i].addPoint([x, data[i]], chk,true);
	                                 }
	                        }, 1000);
	                    }
	                }
	            },	            
	            title: {
	                text: '샘플그래프' 
	            },
	             subtitle: {
	                text: '서브타이틀'
	            },
	            xAxis: {
	                title:{
	                    text:'X 값'  /*X 축 라벨*/
	                    },
	                type: 'datetime',
	                tickPixelInterval: 150
	            },
	            yAxis: {
	                title: {
	                    text: 'Y 값'  /*y축 라벨*/
	                },
	                plotLines: [{
	                    value: 0,
	                    width: 1,
	                    color: '#808080'
	                }]
	            },
	            tooltip: {
	                formatter: function() {
	                        return '<b>'+ this.series.name +'</b><br/>'+
	                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
	                        Highcharts.numberFormat(this.y, 2);
	                }
	            },
	            legend: {
	                enabled: false
	            },
	            exporting: {
	                enabled: false
	            },
	            series: [
	            { name: 'Random data1',data: (function() {  var data = [], time = (new Date()).getTime(), i; for (i = -15; i <= 0; i++) {   data.push({ x: time + i * 1000, y: 0 });  }
				        return data;
				    })()
	            },{
	                name: 'Random data2',data: (function() {
				        var data = [], time = (new Date()).getTime(), i;
				         for (i = -15; i <= 0; i++) {
				            data.push({ x: time + i * 1000, y: 0 });
				        }
				        return data;
				    })()
	            },{
	                name: 'Random data3',data: (function() {
				        var data = [], time = (new Date()).getTime(), i;
				         for (i = -15; i <= 0; i++) {
				            data.push({ x: time + i * 1000, y: 0 });
				        }
				        return data;
				    })()
	            },{
	                name: 'Random data4',data: (function() {
				        var data = [], time = (new Date()).getTime(), i;
				         for (i = -15; i <= 0; i++) {
				            data.push({ x: time + i * 1000, y: 0 });
				        }
				        return data;
				    })()
	            }
	            ]
	        });
	    });
	    
	});


</script>

<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
