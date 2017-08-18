<!--
http://bestjquery.com/tutorial/progress-bar/demo47/
-->
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.progress{
    height: 40px;
    background: #e1e1e1;
    margin-bottom: 20px;
    position: relative;
}
.progress .progress-bar{
    animation: animate-positive 2s;
}
.progress .progress-value{
    position: absolute;
    bottom: 5px;
    right: 10px;
    background: #fff;
    font-size: 14px;
    color: #a2a6a9;
    padding: 5px 10px;
    border-radius: 3px;
}
.progress .progressbar-title{
    position: absolute;
    bottom: 9px;
    left: 10px;
    font-size: 14px;
    font-weight: bold;
    color: #fff;
    letter-spacing: 1px;
}
@-webkit-keyframes animate-positive{
    0% { width: 0%; }
}
@keyframes animate-positive{
    0% { width: 0%; }
}
</style>
</head>
<body style="background-color: black; text-align:center; ">

<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="progress">
                <div class="progress-bar" style="width:100%; background:#084c61;">
                    <div class="progress-value">100%</div>
                    <div class="progressbar-title">HTML5HTML5HTML5HTML5HTML5HTML5HTML5HTML5HTML5HTML5</div>
                </div>
            </div>
 
            <div class="progress">
                <div class="progress-bar" style="width:75%; background:#db504a;">
                    <div class="progress-value">75%</div>
                    <div class="progressbar-title">CSS3</div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
