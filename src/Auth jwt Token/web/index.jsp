<%--
  Created by IntelliJ IDEA.
  User: arun-pt3013
  Date: 18/7/19
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
  </head>
  <body onload="jQueryAjax()">
       <a href="home.html">Click tme</a>

  <script>
    function ajax() {
      console.log("inside ajax")
      var name = "dragon";
      var pass = "j";
      var xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function () {
        if(xhr.readyState ==4 && xhr.status ==200){
           var response = this.responseText;
           var token = jwtDecode(response)
           sessionStorage.setItem("token",token);
           console.log(response);
           console.log(token.payload.name)
        }
        xhr.open("GET","Login?name="+name+"&pass="+pass,true);
        xhr.send();
      }
    }

    function jQueryAjax() {
      var d = {name:"dragon" , pass:"j"};
        $.ajax( {url : "Login" ,
              data : d ,
              success: function(result) {
          console.log("success ajax" + result);
      }});
    }

    function jwtDecode(t) {
      var token = {};
      token.raw = t;
      token.header = JSON.parse(window.atob(t.split('.')[0]));
      token.payload = JSON.parse(window.atob(t.split('.')[1]));
      return (token)
    }
  </script>
  </body>
</html>
