<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
      <script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
   <title></title>
  <style type='text/css'>
.txtarea{
    max-width:100%;
    min-height:200px;    
    display:block;
    width:100%;
}

.mydiv{
    padding:10px;
}

.gen_btn{
    padding:5px;
    background-color:#743ED9;
    color:white;
    font-family:arial;
    font-size:13px;
    border:2px solid black;
}

.gen_btn:hover{
    background-color:#9a64ff;
}
  </style>

</head>
<body>
<div class='mydiv'>    
    <textarea id="txt" class='txtarea'>
    [{"Vehicle":"BMW","Date":"30, Jul 2013 09:24 AM","Location":"Hauz Khas, Enclave, New Delhi, Delhi, India","Speed":42},{"Vehicle":"Honda CBR","Date":"30, Jul 2013 12:00 AM","Location":"Military Road,  West Bengal 734013,  India","Speed":0},{"Vehicle":"Supra","Date":"30, Jul 2013 07:53 AM","Location":"Sec-45, St. Angel's School, Gurgaon, Haryana, India","Speed":58},{"Vehicle":"Land Cruiser","Date":"30, Jul 2013 09:35 AM","Location":"DLF Phase I, Marble Market, Gurgaon, Haryana, India","Speed":83},{"Vehicle":"Suzuki Swift","Date":"30, Jul 2013 12:02 AM","Location":"Behind Central Bank RO, Ram Krishna Rd by-lane, Siliguri, West Bengal, India","Speed":0},{"Vehicle":"Honda Civic","Date":"30, Jul 2013 12:00 AM","Location":"Behind Central Bank RO, Ram Krishna Rd by-lane, Siliguri, West Bengal, India","Speed":0},{"Vehicle":"Honda Accord","Date":"30, Jul 2013 11:05 AM","Location":"DLF Phase IV, Super Mart 1, Gurgaon, Haryana, India","Speed":71}]
    </textarea>
    <button class='gen_btn'>Generate File</button>
</div>
<script type="text/javascript">
var localip="";
if(location.host.indexOf("localhost") == -1 || location.host.indexOf("192.168.20.105") == -1){
   localip="http://"+location.host;
}else{
   localip="http://"+location.host;
}
$(document).ready(function(){

        $('button').click(function(){
           $.getJSON(localip+"/system/linegraph_csv?call_id="+"WEB_20170426161006674",
                 function(data) {
               JSONToCSVConvertor(data, "VoiceCream_Demo", true);
         });
     });     
           
       var a =  b();
       alert(a);
});
function b(){
    var row = "2";
    var row2 = "";
    var value="";
    var value2="";
    $.getJSON(localip+"/system/linegraph_csv?call_id="+"WEB_20170426161006674",
            function(data) {
        value ="startdate,0,2,4,6";
        row += '' + value.replace(/"/g, '""') + ',';
        return row;
    });
    
    return row;
}


function JSONToCSVConvertor(JSONData, ReportTitle, ShowLabel) {
    var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;
    var CSV = '';    
    
    CSV += ReportTitle + '\r\n\n';

    if (ShowLabel) {
        var row = "";
        var row2 = "";
        var value="";
        var value2="";
     
  
        
        $.getJSON(localip+"/system/linegraph_csv?call_id="+"WEB_20170426161006674",
                function(data) {
        	
            value2 ="eddate,2,4,6,8";
            row2 += '' + value2.replace(/"/g, '""') + ',';
                
           
        });
        
        row = row.slice(0, -1);
        CSV += row + '\r\n';
        row2 = row2.slice(0, -1);
        CSV += row2 + '\r\n';
     
    }
    
    
    
    for (var i = 0; i < arrData.length; i++) {
        var row = "";
        
        for (var index in arrData[i]) {
            var value = arrData[i][index] + "";
            row += '' + value.replace(/"/g, '""') + ',';
        }
       // alert(row);
        row.slice(0, row.length - 1);
        CSV += row + '\r\n';
    }

    if (CSV == '') {         
        alert("Invalid data");
        return;
    }   
    
    var fileName = "MyReport_";
    fileName += ReportTitle.replace(/ /g,"_");   
    
    var uri = 'data:text/csv;charset=utf-8,' + escape(CSV);
    
    var link = document.createElement("a");    
    link.href = uri;
    
    link.style = "visibility:hidden";
    link.download = fileName + ".csv";
    
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
}
</script>
</body>
</html>