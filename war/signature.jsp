<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Signature Capture</title>
    <style>
    body { font: normal 100.01%/1.375 "Helvetica Neue",Helvetica,Arial,sans-serif; }
  </style>
  <link href="../css/jquery.signaturepad.css" rel="stylesheet">
  
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
  </head>

  <body>
<div class="container">
    <h3>Signature Capture Demo</h3>
		<form class="sigPad" method="POST" action="signatureservice" name="signatureform" id="signatureform">
			<input name="signature" id="signature" type="hidden"/>
			<br/>
			<input name="receiverName" id="receiverName" type="text" class="span3" placeholder="Receiver Name" maxlength="50">
			<input class="btn btn-primary" type="button" value="Submit" onclick="submitform(); return true;"/>
		    <p class="drawItDesc">Please sign below:</p>
		    <ul class="sigNav">
		      <li class="clearButton"><a href="#clear">Clear</a></li>
		    </ul>
		    <div class="sig sigWrapper">
		      <div class="typed"></div>
		      <canvas class="pad" width="280" height="190"></canvas>
		      <input type="hidden" name="output" class="output">
		    </div>
		  </form>
		  <hr/>
		  <a href="list.jsp">Signature List in last 30 minutes</a>
		  <h4>Your signatures are being cleaned up every 30 minutes via Cron Job.</h4>
	</div> <!-- /container -->
    <script src="../js/jquery.js"></script>
    <script src="../js/jquery.signaturepad.js"></script>
    <script type="text/javascript">
	    $(document).ready(function() {
			api = $('.sigPad').signaturePad({drawOnly:true});
		});
	    function submitform() {
	    	//Retrieve the form values
	    	var receiverName = $.trim(document.signatureform.receiverName.value);
	    	if (receiverName.length === 0) {
	    		alert("Receiver Name cannot be empty");
	    		document.signatureform.receiverName.focus();
	    		return;
	    	}
	    	var _sign = document.getElementById('signature');
	    	_sign.value = api.getSignatureImage(); 
	    	if (confirm('Are you sure you want to submit?')) {
	    		document.signatureform.submit();
	    	}
	    }
    </script>
  </body>
</html>