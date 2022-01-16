

$(document).ready(function(){

	// jQuery methods go here...
	$(document).click(function() {
		$('#map').animate({
			left: '50px'
		});
	});

	$('#map').click(function() {
		$('#welcome').fadeOut();
	});

});
