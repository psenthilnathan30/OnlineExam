 $("document").ready(function(){

	 

 console.log(getFormData('#onlinetest'));
 
 alert(getFormData('#onlinetest'));
			
	 
 });

	//read in a form's data and convert it to a key:value object
 function getFormData(dom_query){
     var out = {};
     var s_data = $(dom_query).serializeArray();
     //transform into simple data/value object
     for(var i = 0; i<s_data.length; i++){
         var record = s_data[i];
         out[record.name] = record.value;
     }
     return out;
 }


	


