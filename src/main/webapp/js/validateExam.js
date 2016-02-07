var editor; 
var table;
$("document").ready(function(){
	 $("#upload").click(function(){
		 uploadFile();
	 });
	 $('#previewBtn').addClass('disabled');
	 table=$('#questions').DataTable( {
		 scrollY:'300px',
		 scrollCollapse:false,
	        columns: [
	          
	            { data: "question",
	            	"defaultContent": ""},
	            { data: "option_1" ,
	            		"defaultContent": ""},
	            { data: "option_2",
	            			"defaultContent": ""},
	            { data: "option_3","defaultContent": "" },
	            { data: "option_4" ,"defaultContent": ""},
	            { data: "category","defaultContent": "" },
	            { data: "answer","defaultContent": "" },
	            {data:"descriptions","defaultContent": ""}
	        ]
	       
	    } );
	/* editor = new $.fn.dataTable.Editor( {
	        table: "#questions",
	        fields: [ {
	                label: "Question",
	                name: "question"
	            }, {
	                label: "Option A",
	                name: "option_1"
	            }, {
	                label: "Option B",
	                name: "option_2"
	            }, {
	                label: "Option C",
	                name: "option_3"
	            }, {
	                label: "Option D",
	                name: "option_4"
	            }, {
	                label: "Category",
	                name: "category",
	            }, {
	                label: "Answer",
	                name: "answer"
	            }, {
	                label: "Description",
	                name: "Descriptions"
	            }
	            
	        ]
	    } );
	    // Activate an inline edit on click of a table cell
	    $('#questions').on( 'click', 'tbody td:not(:first-child)', function (e) {
	        editor.inline( this );
	    } );*/
 });
 function uploadFile() {
     var formData = new FormData();
     formData.append('file', $('input[type=file]')[0].files[0]);
     $.ajax({
         url : 'uploadFile.do',
         data : formData,
         processData : false,
         contentType : false,
         dataType:'json',
         type : 'POST',
         success : function(response) {
        	 table.rows.add(response).draw();
        	 $('#previewModal').modal({
        		 show:'show',
        		 backdrop:'static'
        		 })
        		 $('#previewBtn').removeClass('disabled');
         },
         error : function(err) {
             alert(err);
         }
     });
     		
     
 }
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
