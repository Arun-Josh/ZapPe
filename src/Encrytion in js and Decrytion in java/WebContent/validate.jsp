<%@page import="java.util.Arrays"%>
<%@page import="com.crypto.Security"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
    <%
        out.println ("<br/>Encrypted Password     :    " + request.getParameter("password"));
        out.println ("<br/>Salt                 :    " + request.getParameter("salt"));
        out.println ("<br/>IV                     :    " + request.getParameter("iv"));
        out.println ("<br/>Key                 :    " + session.getAttribute ( "RANDKEY" ) );
        out.println ("<br/>Original Password     :    " + Security.decryptAESEncryptWithSaltAndIV(request.getParameter("password"), session.getAttribute ( "RANDKEY" ).toString (  ), request.getParameter("salt"), request.getParameter("iv") ) );    
    %>
</body>
</html>