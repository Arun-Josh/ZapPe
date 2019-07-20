<%@page import="java.util.Arrays"%>
<%@page import="com.crypto.Security"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%
    session.setAttribute ( "RANDKEY", Security.generateSecret(  ) );
%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
   <script src="js/rollups/aes.js"></script>  
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/aes.js"></script>  -->
<script src="js/rollups/pbkdf2.js"></script>
<!--   <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9/pbkdf2.js">  -->
<script type="text/javascript">
    function convertAndSubmit()
    {
         var salt = CryptoJS.lib.WordArray.random(128/8);
        var iv = CryptoJS.lib.WordArray.random(128/8);           
        console.log('salt  '+ salt );
        console.log('iv  '+ iv );
        var key128Bits100Iterations = CryptoJS.PBKDF2( '<%=session.getAttribute ( "RANDKEY" ) %>', salt, { keySize: 128/32, iterations: 100 });
        console.log( 'key128Bits100Iterations '+ key128Bits100Iterations);
        var encrypted = CryptoJS.AES.encrypt(document.login.password.value, key128Bits100Iterations, { iv: iv, mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.Pkcs7  });
        document.login.salt.value = salt;
        document.login.iv.value = iv;
        document.login.password.value = encrypted;
        document.login.submit();
    }
</script>
</head>
<body>
    <form action="validate.jsp" method="post" name="login" autocomplete="off">
        <p>User Name : <input type="text" name="userName"/></p>
        <p>
                       <input type="text" style="display:none;">
            Password : <input type="password" name="password"/>
        </p>
        <p>
            <input type="hidden" name="salt"/>
            <input type="hidden" name="iv"/>
            <input type="button" value="Login" onclick="javascript:convertAndSubmit()"/>
        </p>
    </form>
</body>
</html>
