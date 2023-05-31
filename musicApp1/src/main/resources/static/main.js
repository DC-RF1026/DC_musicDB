
 	window.addEventListener('DOMContentLoaded', function(){
 	
 	const icon = document.getElementsByClassName('icon');
 	
 	for(let i =0; i < icon.length; i++){
 	
	
	icon[i].addEventListener('click', function(){
	    
	    if(icon[i].classList.contains('fav') == false){
	    
	    	icon[i].classList.add('fav');
	    	
	    } else {
	    
	    	icon[i].classList.remove('fav');
	 
	    }
	});
	
	}
	 	
  });

