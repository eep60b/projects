 var handle = {};
   
 function on_start() {  
     handle = setTimeout(function() {  
         $('html').addClass('progress');  
     }, 50);  
 }  
   
 function on_complete() {  
     clearTimeout(handle);  
     $('html').removeClass('progress');  
 } 

