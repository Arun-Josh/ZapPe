// $("verifybtn").click(function(){
//     $.ajax({url: "login", success: function(result){
//             // $("#div1").html(result);
//             window.location.href = "verify.html";
//         }});
// });

function sendMoney() {
    window.location.href="transfersuccess.html";
}

function verifyOTP() {
    var xhr = new XMLHttpRequest();
    var url = "otp";
    xhr.onreadystatechange = function () {
        if(xhr.status==200 && xhr.readyState==4){
            var reply = xhr.responseText;
            console.log("reply "+reply);
            if(reply=="OK"){
                // alert("verify")
                // window.location.href="verify.html";
                reset();
            }
            else{
                console.log("something went wrong")
                // window.location.href="invalid.html";
                // document.getElementById("hidden").style.display = "block !important";
            }
        }
    }

    var mobile = document.getElementById("mobile").value;
    var mail = document.getElementById("mail").value;

    console.log(mobile  + " : "+mail);
    xhr.open("POST",url,true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send("mail="+mail+"&mobile="+mobile);

}


function verifyPage() {

    // document.getElementById("admin").style.display="none";
    // document.getElementById("hidden").style.display="none";
    // alert("inside verify page")

    var xhr = new XMLHttpRequest();
    var url = "storeinfo";
    xhr.onreadystatechange = function () {
        if(xhr.status==200 && xhr.readyState==4){
            var reply = xhr.responseText;
            console.log("reply "+reply);
            if(reply=="OK"){
                // alert("verify")
                window.location.href="verify.html";
            }
            else{
                console.log("something went wrong")
                // window.location.href="invalid.html";
                // document.getElementById("hidden").style.display = "block !important";
            }
        }
    }
    var name = document.getElementById("name").value;
    var mobileno = document.getElementById("mobileno").value;
    var pass = document.getElementById("pass").value;
    var mail = document.getElementById("mail").value;

    console.log(pass  + " : "+mail);
    xhr.open("POST",url,true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send("mail="+mail+"&pass="+pass+"&mobileno="+mobileno+"&name="+name);

    // window.location.href="verify.html";
}

function login(){
    // document.getElementById("admin").style.display="none";
    document.getElementById("hidden").style.display="none";

    var xhr = new XMLHttpRequest();
    var url = "login";
    xhr.onreadystatechange = function () {
        if(xhr.status==200 && xhr.readyState==4){
            var reply = xhr.responseText;
            console.log("reply "+reply);
            if(reply=="OK"){
                window.location.href="home.html";
            }
            else{
                window.location.href="invalid.html";
                // document.getElementById("hidden").style.display = "block";
            }
        }
    }
    var pass = document.getElementById("pass").value;
    var mail = document.getElementById("mail").value;
    // var hashObj = new jsSHA("SHA-512","TEXT",{numRounds:1});
    // hashObj.update(mail+pass1);
    // var hash = hashObj.getHash("HEX");
    // url+="/mail="+mail+"&pass="+pass;
    console.log(pass  + " : "+mail);
    xhr.open("POST",url,true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send("mail="+mail+"&pass="+pass);
}

    function reset(){
        window.location.href="index.html";
    }

// (function ($) {
//     "use strict";
//
//     /*==================================================================
//     [ Validate after type ]*/
//     $('.validate-input .input100').each(function(){
//         $(this).on('blur', function(){
//             if(validate(this) == false){
//                 showValidate(this);
//             }
//             else {
//                 $(this).parent().addClass('true-validate');
//             }
//         })
//     })
//
//
//     /*==================================================================
//     [ Validate ]*/
//     // var input = $('.validate-input .input100');
//
//     // $('.validate-form').on('submit',function(){
//         // var check = true;
//         //
//         // for(var i=0; i<input.length; i++) {
//         //     if(validate(input[i]) == false){
//         //         showValidate(input[i]);
//         //         check=false;
//         //     }
//         // }
//         //
//         // return check;
//     // });
//
//
//     $('.validate-form .input100').each(function(){
//         $(this).focus(function(){
//            hideValidate(this);
//            $(this).parent().removeClass('true-validate');
//         });
//     });
//
//      function validate (input) {
//         if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
//             if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
//                 return false;
//             }
//         }
//         else {
//             if($(input).val().trim() == ''){
//                 return false;
//             }
//         }
//     }
//
//     function showValidate(input) {
//         var thisAlert = $(input).parent();
//
//         $(thisAlert).addClass('alert-validate');
//
//         $(thisAlert).append('<span class="btn-hide-validate">&#xf135;</span>')
//         $('.btn-hide-validate').each(function(){
//             $(this).on('click',function(){
//                hideValidate(this);
//             });
//         });
//     }
//
//     function hideValidate(input) {
//         var thisAlert = $(input).parent();
//         $(thisAlert).removeClass('alert-validate');
//         $(thisAlert).find('.btn-hide-validate').remove();
//     }
//
//
//
// })(jQuery);