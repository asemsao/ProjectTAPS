function importFile(filename) {
	var filetype = filename.substring(filename.lastIndexOf('.') + 1);
	var tag = '';

	switch (filetype) {
	case 'css':
		tag = document.createElement('link');
		tag.setAttribute('rel', 'stylesheet');
		tag.setAttribute('type', 'text/css');
		tag.setAttribute('href', filename);
		break;

	case 'js':
		tag = document.createElement('script');
		tag.setAttribute('type', 'text/javascript');
		tag.setAttribute('src', filename);
		break;

	default:
		break;
	}

	if (tag !== undefined) {
		var head = document.getElementsByTagName('head')[0];
		head.appendChild(tag);
	}
}

var base = location.pathname.match(/\/\w+/i);

//Import CSS Files
importFile(base + '/css/metro-bootstrap.css');
importFile(base + '/css/metro-bootstrap-responsive.css');
importFile(base + '/css/style.css');
importFile(base + '/css/selectize.css');

//Import JS Files
importFile(base + '/js/jquery/jquery.min.js');
importFile(base + '/js/jquery/jquery.widget.min.js');
importFile(base + '/js/metro/metro.min.js');
importFile(base + '/js/rumble/jquery.jrumble.1.3.min.js');
importFile(base + '/js/metro/metro-calendar.min.js');
importFile(base + '/js/metro/metro-datepicker.min.js');
importFile(base + '/js/selectize/selectize.js');
importFile(base + '/js/selectize/index.js');
importFile(base + '/js/other/script.js');
importFile(base + '/js/other/popup.js');
importFile(base + '/js/other/selectize.js');

setTimeout(function() {
	
}, 500);





