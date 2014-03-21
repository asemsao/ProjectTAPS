$(document).ready(function() {
	$("#__input_file_wrapper__").attr('placeholder', 'Browse File');
	$("#datepicker-begin, #datepicker-end, #datepicker").datepicker({
		format : "dd/mm/yyyy",
		effect : "none",
		position : "bottom"
	});

});