
var startAnimation = function() {
	$("#welcome").fadeOut(1000, shiftLeft($('#map')))
};

var shiftLeft = function(thing) {
	thing.css("transform", "translateX(-95%)");
}

var selectedState = function(state) {
	$('#info p').css('opacity', '0');
	switch(state) {
		case 'BC':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#7accfe");
			stateData(state);
			break;
		case 'AB':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#01d8c0");
			stateData(state);
			break;
		case 'SK':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#49f9a6");
			stateData(state);
			break;
		case 'MB':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#f8de6f");
			stateData(state);
			break;
		case 'ON':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#e0a53f");
			stateData(state);
			break;
		case 'QC':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#fc9b6e");
			stateData(state);
			break;
		case 'NB':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#ff6273");
			stateData(state);
			break;
		case 'NS':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#fe3bba");
			stateData(state);
			break;
		case 'NL':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#f58de4");
			stateData(state);
			break;
		case 'YT':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#6565f1");
			stateData(state);
			break;
		case 'NT':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#a768f5");
			stateData(state);
			break;
		case 'NU':
			$('g').css("fill", "#d3d3d3");
			$('#' + state).css("fill", "#d09cfe");
			stateData(state);
			break;

		default:
			$('#' + state).css("fill", "#d3d3d3");
	}
}

var stateData = function(state) {
	var stateColor = $('#' + state).css('fill');
	$('#info .title').css('color', stateColor);
	$('#info > .' + state + ' *').css('opacity', '1');
}