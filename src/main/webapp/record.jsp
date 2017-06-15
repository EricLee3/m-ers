
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>HTML5 Audio Editor</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="/resources/SoundRecorder/bootstrap/css/bootstrap.css" rel="stylesheet">
    <style>
      /* body {
        padding-top: 10px; /* 60px to make the container go all the way to the bottom of the topbar */
      }
      .soundBite input {
        margin-right: 4px;
      } */
    </style>
    <link href="/resources/SoundRecorder/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="bootstrap/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/resources/SoundRecorder/bootstrap/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/resources/SoundRecorder/bootstrap/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/resources/SoundRecorder/bootstrap/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/resources/SoundRecorder/bootstrap/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <body>
    <div class="recorder container">
      <input type="hidden" max="1" step="0.1" value="0" onchange="changeVolume(this.value)"/>
        <button class="btn btn-primary" onclick="startRecording(this);" style="margin-left: -20px;">Record</button>
        <button class="btn btn-warning" onclick="stopRecording(this);"  disabled>Stop</button>
  
      <table id="recordingslist" style="margin-left: -20px;">
       
      
      </table>
    </div>


    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/resources/SoundRecorder/jquery/js/jquery-1.7.2.js"></script>
    <script src="/resources/SoundRecorder/bootstrap/js/bootstrap-transition.js"></script>
    <script src="/resources/SoundRecorder/bootstrap/js/bootstrap-alert.js"></script>
    <script src="/resources/SoundRecorder/bootstrap/js/bootstrap-modal.js"></script>
    <script src="/resources/SoundRecorder/bootstrap/js/bootstrap-dropdown.js"></script>
    <script src="/resources/SoundRecorder/bootstrap/js/bootstrap-scrollspy.js"></script>
    <script src="/resources/SoundRecorder/bootstrap/js/bootstrap-tab.js"></script>
    <script src="/resources/SoundRecorder/bootstrap/js/bootstrap-tooltip.js"></script>
    <script src="/resources/SoundRecorder/bootstrap/js/bootstrap-popover.js"></script>
    <script src="/resources/SoundRecorder/bootstrap/js/bootstrap-button.js"></script>
    <script src="/resources/SoundRecorder/bootstrap/js/bootstrap-collapse.js"></script>
    <script src="/resources/SoundRecorder/bootstrap/js/bootstrap-carousel.js"></script>
    <script src="/resources/SoundRecorder/bootstrap/js/bootstrap-typeahead.js"></script>


    <script type="text/javascript" src="/resources/SoundRecorder/app/js/ACFIRFilter.js"></script>
    <script type="text/javascript" src="/resources/SoundRecorder/app/js/ACAAFilter.js"></script> 
    <script type="text/javascript" src="/resources/SoundRecorder/app/js/ACSpectrum.js"></script>    
    <script type="text/javascript" src="/resources/SoundRecorder/app/js/ACFFT.js"></script>
    <script type="text/javascript" src="/resources/SoundRecorder/app/js/SpectrumWorker.js"></script>
    <script type="text/javascript" src="/resources/SoundRecorder/app/js/SpectrumDisplay.js"></script>
    <script type="text/javascript" src="/resources/SoundRecorder/app/js/audioplayback.js"></script>
    <script type="text/javascript" src="/resources/SoundRecorder/app/js/filedropbox.js"></script>
    <script type="text/javascript" src="/resources/SoundRecorder/app/js/fft.js"></script>
    <script type="text/javascript" src="/resources/SoundRecorder/app/js/audioLayerControl.js"></script>
    <script type="text/javascript" src="/resources/SoundRecorder/app/js/audiosequence.js"></script>
    <script type="text/javascript" src="/resources/SoundRecorder/app/js/AudioSequenceEditor.js"></script>
    <script type="text/javascript" src="/resources/SoundRecorder/app/js/mathutilities.js"></script>
    <script type="text/javascript" src="/resources/SoundRecorder/app/js/wavetrack.js"></script>
    <script type="text/javascript" src="/resources/SoundRecorder/app/js/binarytoolkit.js"></script>
    <script type="text/javascript" src="/resources/SoundRecorder/app/js/filesystemutility.js"></script>
    <script type="text/javascript" src="/resources/SoundRecorder/app/js/editorapp.js"></script>

    <script src="/resources/SoundRecorder/js/lib/recorder.js"></script>
    <script src="/resources/SoundRecorder/js/recordLive.js"></script>
    <script src="/resources/SoundRecorder/js/sequencer.js"></script>
    <script src="/resources/SoundRecorder/js/drone.js"></script>

    <script type="text/javascript">
      $(window).load(function()
      {
        $('.editor.container').addClass('invisible');
     //   onDocumentLoaded();
      });
    </script>
  </body>
</html>