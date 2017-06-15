<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp"%>

<script>

$(function () {

    var gaugeOptions = {

        chart: {
            type: 'solidgauge'
        },

        title: null,

        pane: {
            center: ['50%', '85%'],
            size: '140%',
            startAngle: -90,
            endAngle: 90,
            background: {
                backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || '#EEE',
                innerRadius: '60%',
                outerRadius: '100%',
                shape: 'arc'
            }
        },

        tooltip: {
            enabled: false
        },

        // the value axis
        yAxis: {
            stops: [
                [0.1, '#55BF3B'], // green
                [0.5, '#DDDF0D'], // yellow
                [0.9, '#DF5353'] // red
            ],
            lineWidth: 0,
            minorTickInterval: null,
            tickAmount: 2,
            title: {
                y: -70
            },
            labels: {
                y: 16
            }
        },

        plotOptions: {
            solidgauge: {
                dataLabels: {
                    y: 5,
                    borderWidth: 0,
                    useHTML: true
                }
            }
        }
    };

    // The CPU gauge
    var cpu_val = $('#cpu_val').val();
    cpu_val = parseInt(cpu_val);
    var chartCpu = Highcharts.chart('container-cpu', Highcharts.merge(gaugeOptions, {
        yAxis: {
            min: 0,
            max: 100,
            title: {
                text: 'CPU'
            }
        },

        credits: {
            enabled: false
        },

        series: [{
            name: 'CPU',
            data: [cpu_val],
            dataLabels: {
                format: '<div style="text-align:center"><span style="font-size:25px;color:' +
                    ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y}</span><br/>'+
                    '<span style="font-size:12px;color:silver">단위 : IDLE</span></div>'
            },
            tooltip: {
            }
        }]

    }));

    // The MEMORY gauge
    var memory_val = $('#memory_val').val().split('/');
    memory_val = parseFloat(memory_val[0]);
    
    var memory_val_max = $('#memory_val').val().split('/');
    memory_val_max = parseFloat(memory_val_max[1]);
    //memory_val_max2 = {memory_val_max:.2f}
   // alert(memory_val_max2);
    
    var chartMemory = Highcharts.chart('container-memory', Highcharts.merge(gaugeOptions, {
        yAxis: {
            min: 0,
            max: memory_val_max,
            title: {
                text: 'MEMORY'
            }
        },

        series: [{
            name: 'MEMORY',
            data: [memory_val],
            dataLabels: {
                format: '<div style="text-align:center"><span style="font-size:25px;color:' +
                    ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y:.2f}</span><br/>' +
                       '<span style="font-size:12px;color:silver">단위 : kbps</span></div>'
            },
            tooltip: {
                valueSuffix: ' revolutions/min'
            }
        }]

    }));
    
 // The DISK gauge
    var disk_val = $('#disk_val').val().split('/');
    disk_val = parseFloat(disk_val[0]);
    
    var disk_val_max = $('#disk_val').val().split('/');
    disk_val_max = parseFloat(disk_val_max[1]);
    
    var chartDisk = Highcharts.chart('container-disk', Highcharts.merge(gaugeOptions, {
        yAxis: {
            min: 0,
            max: disk_val_max,
            title: {
                text: 'DISK'
            }
        },

        credits: {
            enabled: false
        },

        series: [{
            name: 'DISK',
            data: [disk_val],
            dataLabels: {
                format: '<div style="text-align:center"><span style="font-size:25px;color:' +
                    ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black') + '">{y}</span><br/>'+
                    '<span style="font-size:12px;color:silver">단위 : GB</span></div>'
            },
            tooltip: {
            }
        }]

    }));

    // Bring life to the dials
    setInterval(function () {
        // disk
        var point,
            newVal,
            inc;

        if (chartCpu) {
            point = chartCpu.series[0].points[0];
            inc = Math.round((Math.random() - 0.5) * 100);
            //newVal = point.y + inc;
			newVal = point.y;
            /*
            if (newVal < 0 || newVal > 200) {
                newVal = point.y - inc;
            }
            */

            point.update(newVal);
        }

        // Memory
        if (chartMemory) {
            point = chartMemory.series[0].points[0];
            inc = Math.random() - 0.5;
            //newVal = point.y + inc;
            newVal = point.y;

            /*
            if (newVal < 0 || newVal > 5) {
                newVal = point.y - inc;
            }
			*/
			
            point.update(newVal);
        }
        
     // Disk
        var point,
            newVal,
            inc;

        if (chartDisk) {
            point = chartDisk.series[0].points[0];
            inc = Math.round((Math.random() - 0.5) * 100);
            //newVal = point.y + inc;
			newVal = point.y;
            /*
            if (newVal < 0 || newVal > 200) {
                newVal = point.y - inc;
            }
            */

            point.update(newVal);
        }

    }, 5000);

});
</script>