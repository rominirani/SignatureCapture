<!DOCTYPE html>
<%@page import="com.mindstorm.signaturecapture.dao.SignatureRecordDAO"%>
<%@page import="com.mindstorm.signaturecapture.entity.SignatureRecord"%>
<%@page import="java.util.List"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Signature Capture</title>
    <style>
    body { font: normal 100.01%/1.375 "Helvetica Neue",Helvetica,Arial,sans-serif; }
  </style>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
  </head>

  <body>
<div class="container">
    <h3>Signature Capture Demo</h3>
    <a href="signature.jsp">Sign Again</a>
    <table border="1">
    <tr>
    <td>Receiver Name</td>
    <td>Signature</td>
    <td>Last Update</td>
    </tr>
    <%
    List<SignatureRecord> _records = SignatureRecordDAO.INSTANCE.getSignatureRecords();
    for (SignatureRecord record : _records) {
    	%>
    	<tr>
    	<td><%=record.getReceiverName()%></td>
    	<td><img src="<%=record.getSignature().getValue()%>"></img></td>
    	<td><%=record.getLastUpdate()%></td>
    	</tr>
    <%	
    }
    %>
    </table>
	</div> <!-- /container -->
<script src="../js/jquery.js"></script>
  </body>
</html>