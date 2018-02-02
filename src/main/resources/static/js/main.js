$(document).ready(function () {

$('#contact-form1').submit(function () {

//jQuery.validator.setDefaults({
//              debug: true,
//              success: "valid"
//            });
//            $( "#contact-form" ).validate({
//              rules: {
//                name: {
//                  required: true
//                }
//                 email: {
//                    required: true
//                 }
//                message:{
//                required:true
//                }
//              }
//            });

            alert("iopta");
            var data = {}
			data["name"] = $("input[name='name']").val();
			data["email"] = $("input[name='email']").val();
			data["message"] = $("textarea[name='message']").val();


e.preventDefault();
e.stopPropagation();
             $.ajax({
                     type: "POST",
                     contentType: "application/json",
                     url: "/test",
                     data: JSON.stringify(data),
                     timeout: 600000,
                     dataType: 'json',
                     success: function (data) {
                         $('#success').modal('show');
                     },
                     error: function (e) {
                        $('#fail').modal('show');
                     }
            });
         });

});