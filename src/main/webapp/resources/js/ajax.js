 
function makeAjaxCall(){
	//alert("sasa");
	var dataToSend = JSON.stringify(serializeObject($('#accountSetting')));
	
	$.ajax({
		
		url: 'addAccountSetting',
		type: 'POST',
		dataType: "JSON",           // Accepts
 		data:dataToSend,
 		contentType: 'application/json',   // Sends
 		success: function(accountSetting) {
 			$('#formInput').html("");
 			$("#formInput").append( '<H3 align="center"> Account Setting Saved With Info:- <H3>');                
			$('#formInput').append("<H4 align='center'>Address:  " + accountSetting.address  + "</h4>"  );
			$('#formInput').append("<H4 align='center'>Company Name: " + accountSetting.companyName  + "</h4>" );
			$('#formInput').append("<H4 align='center'>Short Name: " + accountSetting.shortName   + "</h4>");
			make_visible('formInput');
			$("#address").val("");
			$("#companyName").val("");
			$("#shortName").val("");
			make_hidden('errors');
		},

	error: function(errorObject ){	
			//alert(errorObject.responseJSON.errorType);
			$('#errors').html("");
			if (errorObject.responseJSON.errorType == "ValidationError") {
	 			$('#success').html("");
	 			$("#errors").append( '<H3 align="center"> Error(s)!! <H3>');                
	  			    $("#result").append( '<p>');
	  	
	  			    var errorList = errorObject.responseJSON.errors;
	 	 	        $.each(errorList,  function(i,error) {			   
	 		    		$("#errors").append( error.message + '<br>');
			    	});
	 	 	        $("#errors").append( '</p>');
	 	 	      make_visible('errors');
			}
			else {
				alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
			}
			
		
	}
	
	});
}

toggle_visibility = function(id) {
    var element = document.getElementById(id);
    if(element.style.display == 'block')
    	element.style.display = 'none';
    else
    	element.style.display = 'block';
 }	

make_hidden = function(id) {
    var element = document.getElementById(id);
    element.style.display = 'none';
        }	   

make_visible = function(id) {
    var element = document.getElementById(id);
    element.style.display = 'block';
 }	   

resetForm = function(id) {
    var element = document.getElementById(id);
    $(element)[0].reset();

    }	  

// Translate form to array
// Then put in JSON format
 function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;

};

