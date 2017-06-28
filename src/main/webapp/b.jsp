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
	                        var series = this.series[0];
	                        var series2 = this.series[1];
	                        var series3 = this.series[2];
	                        var series4 = this.series[3];
	                        
	                        setInterval(function() {
	                            var x = (new Date()).getTime(); // current time
	                                y = Math.random();
	                                z = Math.random();
	                                a = Math.random();
	                                b = Math.random();
	                            series.addPoint([x, y], false, true);
	                            series2.addPoint([x,z], false, true);
	                            series3.addPoint([x,a], false, true);
	                            series4.addPoint([x,b], true, true);
	                            
	                            
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
	             {
	                name: '툴팁라벨1!!!',
	                data: (function() {
	                    // generate an array of random data
	                    var data = [],
	                        time = (new Date()).getTime(),
	                        i;
	                    
	                    for (a = -19; a <= 0; a++) {
	                        data.push({
	                            x: time + i * 1000,
	                            y: Math.random()
	                        });
	                    }
	                    console.log("Log 정보::"+data); 
	                    return data;
	                })()
	            },
	            {
	                name: '툴팁라벨2',
	                data: (function() {
	                    // generate an array of random data
	                    var data = [],
	                        time = (new Date()).getTime(),
	                        a;
	    
	                    for (a = -19; a <= 0; a++) {
	                        data.push({
	                            x: time + a * 1000,
	                            y: Math.random()
	                        });
	                    }
	                    return data;
	                })()
	            },
	            {
	                name: '툴팁라벨3',
	                data: (function() {
	                    // generate an array of random data
	                    var data = [],
	                        time = (new Date()).getTime(),
	                        a;
	    
	                    for (a = -19; a <= 0; a++) {
	                        data.push({
	                            x: time + a * 1000,
	                            y: Math.random()
	                        });
	                    }
	                    return data;
	                })()
	            },
	            {
	                name: '툴팁라벨4',
	                data: (function() {
	                    // generate an array of random data
	                    var data = [],
	                        time = (new Date()).getTime(),
	                        a;
	    
	                    for (a = -19; a <= 0; a++) {
	                        data.push({
	                            x: time + a * 1000,
	                            y: Math.random()
	                        });
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
