
var startAnimation = function() {
	$("#welcome").fadeOut(1000, shiftLeft($('#map')))
};

var shiftLeft = function(thing) {
	thing.css("transform", "translateX(-95%)");
}

var selectedState = function(state) {
	switch(state) {
		case 'BC':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#7accfe");
			break;
		case 'AB':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#01d8c0");
			break;
		case 'SK':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#49f9a6");
			break;
		case 'MB':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#ffff8b");
			break;
		case 'ON':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#f8de6f");
			break;
		case 'QC':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#fc9b6e");
			break;
		case 'NB':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#ff6273");
			break;
		case 'NS':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#fe3bba");
			break;
		case 'NL':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#f58de4");
			break;
		case 'YT':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#6565f1");
			break;
		case 'NT':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#a768f5");
			break;
		case 'YU':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#01d8c0");
			break;
		case 'NU':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#d09cfe");
			break;

		default:
			$('#' + state).css("fill", "#d3d3d3");
	}

}
