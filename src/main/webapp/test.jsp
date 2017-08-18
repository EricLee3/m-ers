<!--
http://bestjquery.com/tutorial/progress-bar/demo47/
http://bestjquery.com/tutorial/progress-bar/demo33/
http://bestjquery.com/tutorial/progress-bar/demo32/
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
.progressbar-title{
    font-size: 14px;
    color: #848484;
    text-transform: capitalize;
}
.progress{
    height: 5px;
    overflow: visible;
    background: #f0f0f0;
    margin-bottom: 40px;
}
.progress .progress-bar{
    position: relative;
    animation: animate-positive 2s;
}
.progress .progress-icon{
    width: 20px;
    height: 20px;
    line-height: 25px;
    border-radius: 50%;
    font-size: 13px;
    position: absolute;
    top: -7px;
    right: 0;
    background: #fff;
    border-width: 3px;
    border-style: solid;
}
.progress-value{
    font-size: 13px;
    color: #848484;
    position: absolute;
    top: 16px;
    right: 0;
}
@-webkit-keyframes animate-positive {
    0% { width: 0%; }
}
@keyframes animate-positive {
    0% { width: 0%; }
}
</style>
</head>
<body style="background-color: black; text-align:center; ">

    <div class="row">
        <div class="col-md-6">
            <b class="progressbar-title">HTML</b>
            <div class="progress">
                <div class="progress-bar" style="width: 65%; background: #ed687c;">
                    <span class="progress-icon fa fa-check" style="border-color:#ed687c; color:#ed687c;"></span>
                    <div class="progress-value">65%</div>
                </div>
            </div>
 
            <h3 class="progressbar-title">CSS3</h3>
            <div class="progress">
                <div class="progress-bar" style="width: 50%; background: #92c26a;">
                    <span class="progress-icon fa fa-check" style="border-color:#92c26a; color:#92c26a;"></span>
                    <div class="progress-value">50%</div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
