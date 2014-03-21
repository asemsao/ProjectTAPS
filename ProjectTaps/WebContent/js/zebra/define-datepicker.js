$(document).ready(function() {

	// Day picker
	
	$(".datepicker-all").Zebra_DatePicker({
		format : "d/m/Y"
	});
	
	$(".datepicker-future").Zebra_DatePicker({
		format : "d/m/Y",
		direction : true
	});
	
	$(".datepicker-back").Zebra_DatePicker({
		format : "d/m/Y",
		direction : false
	});
	
	$(".datepicker-start").Zebra_DatePicker({
		format : "d/m/Y",
		pair : $("#datepicker-end")
	});
	
	$(".datepicker-future-start").Zebra_DatePicker({
		format : "d/m/Y",
		direction : true,
		pair : $("#datepicker-end")
	});
	
	$(".datepicker-back-start").Zebra_DatePicker({
		format : "d/m/Y",
		direction : false,
		pair : $("#datepicker-end")
	});
	
	$(".datepicker-end").Zebra_DatePicker({
		format : "d/m/Y",
		direction : true
	});
	
	$(".datepicker-future-tommorow").Zebra_DatePicker({
		format : "d/m/Y",
		direction : 1
	});
	
	// Year Picker
	
	$(".datepicker-month").Zebra_DatePicker({
		format : "M"
	});
	
	$(".datepicker-month-future").Zebra_DatePicker({
		format : "M",
		direction : true
	});
	
	$(".datepicker-month-back").Zebra_DatePicker({
		format : "M",
		direction : false
	});
	
	// Year Picker
	
	$(".datepicker-year").Zebra_DatePicker({
		format : "Y"
	});
	
	$(".datepicker-year-future").Zebra_DatePicker({
		format : "Y",
		direction : true
	});
	
	$(".datepicker-year-back").Zebra_DatePicker({
		format : "Y",
		direction : false
	});

});