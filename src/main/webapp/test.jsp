<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <title>VoiceCream / 미래손 감정분석 솔루션</title>
   <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
   <script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
   
   <script type="text/javascript" src="/resources/jqplot/jquery.jqplot.js"></script>
   <script type="text/javascript" src="/resources/jqplot/plugins/jqplot.pieRenderer.js"></script>
   <script type="text/javascript" src="/resources/jqplot/plugins/jqplot.enhancedPieLegendRenderer.js"></script>
   <link rel="stylesheet" type="text/css" href="/resources/jqplot/jquery.jqplot.css" />
</head>
<body >
    <div id=kmj1  style="margin-top:20px; margin-left:20px; width:460px; height:300px;"></div>
<script>
$(document).ready(function(){
    
    data1 = [[['Apples', 210],['Oranges', 111], ['Bananas', 74], ['Grapes', 72],['Pears', 49]]];
    toolTip1 = ['Red Delicious Apples', 'Parson Brown Oranges', 'Cavendish Bananas', 'Albaranzeuli Nero Grapes', 'Green Anjou Pears'];
 
    var plot1 = jQuery.jqplot('kmj1', 
        data1,
        {
            title: ' ', 
            seriesDefaults: {
                shadow: false, 
                renderer: jQuery.jqplot.PieRenderer, 
                rendererOptions: { padding: 2, sliceMargin: 2, showDataLabels: true }
            },
            legend: {
                show: true,
                location: 'e',
                renderer: $.jqplot.EnhancedPieLegendRenderer,
                rendererOptions: {
                    numberColumns: 1,
                    toolTips: toolTip1
                }
            },
        }
    );
});

</script>
</body>
</html>