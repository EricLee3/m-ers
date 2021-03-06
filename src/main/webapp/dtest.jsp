<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <script src="/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
   <script src="/resources/js/transpose.js"></script>
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
    <button class='gen_btn'>Generate File</button>
</div>
<script type="text/javascript">
$(document).ready(function(){
       var localip="";
       if(location.host.indexOf("localhost") == -1 || location.host.indexOf("192.168.20.105") == -1){
          localip="http://"+location.host;
       }else{
          localip="http://"+location.host;
       }
        $('button').click(function(){
           var call_id = "WEB_20170426161006674";
           var transposed1;
           $.getJSON(localip+"/system/demo_excel?call_id="+call_id,
                 function(data) {
           //    var matrix = [ [1, 2, 3,4], ['a', 'b', 'c','d'], ['v', 'z', 'g','h'] ];
               vtransposed1 = data.transpose();

               exportToCsv(call_id+".csv",vtransposed1);
         });
     
     });     
           
          
});
function exportToCsv(filename, rows) {
    var processRow = function (row) {
        var finalVal = '';
        for (var j = 0; j < row.length; j++) {
            var innerValue = row[j] === null ? '' : row[j].toString();
            if (row[j] instanceof Date) {
                innerValue = row[j].toLocaleString();
            };
            var result = innerValue.replace(/"/g, '""');
            if (result.search(/("|,|\n)/g) >= 0)
                result = '"' + result + '"';
            if (j > 0)
                finalVal += ',';
            finalVal += result;
        }
        return finalVal + '\n';
    };

    var csvFile = '';
    for (var i = 0; i < rows.length; i++) {
        csvFile += processRow(rows[i]);
    }

    var blob = new Blob([csvFile], { type: 'text/csv;charset=utf-8;' });
    if (navigator.msSaveBlob) { // IE 10+
        navigator.msSaveBlob(blob, filename);
    } else {
        var link = document.createElement("a");
        if (link.download !== undefined) { // feature detection
            // Browsers that support HTML5 download attribute
            var url = URL.createObjectURL(blob);
            link.setAttribute("href", url);
            link.setAttribute("download", filename);
            link.style.visibility = 'hidden';
            document.body.appendChild(link);
            link.click();
            document.body.removeChild(link);
        }
    }
}

</script>
</body>
</html>