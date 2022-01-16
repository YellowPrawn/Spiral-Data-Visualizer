
/*
$(document).ready(function(){

	// jQuery methods go here...
	$(document).click(function() {
		$('#map').animate({
			left: '50px'
		});
	});

	$("object").click(function() {
		$("#welcome").fadeOut();
	});

});*/

var startAnimation = function() {
	$("#welcome").fadeOut(1000, shiftLeft($('#map')))
};

var shiftLeft = function(thing) {
	thing.css("transform", "translateX(-95%)");
}

/*
var dataAppear = function() {

}
*/