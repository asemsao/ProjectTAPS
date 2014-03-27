$(document).ready(function() {
	$("#phoneNumberAreaCode").keydown(function (e) {
	    if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
	        (e.keyCode == 65 && e.ctrlKey === true) || 
	        (e.keyCode >= 35 && e.keyCode <= 39)) {
	             return;
	    }
	    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
	        e.preventDefault();
	    }
	});
	$("#phoneNumberMidNumb").keydown(function (e) {
	    if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
	        (e.keyCode == 65 && e.ctrlKey === true) || 
	        (e.keyCode >= 35 && e.keyCode <= 39)) {
	             return;
	    }
	    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
	        e.preventDefault();
	    }
	});
	$("#phoneNumberLastNumb").keydown(function (e) {
	    if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
	        (e.keyCode == 65 && e.ctrlKey === true) || 
	        (e.keyCode >= 35 && e.keyCode <= 39)) {
	             return;
	    }
	    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
	        e.preventDefault();
	    }
	});
	$("#mobileNumberAreaCode").keydown(function (e) {
	    if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
	        (e.keyCode == 65 && e.ctrlKey === true) || 
	        (e.keyCode >= 35 && e.keyCode <= 39)) {
	             return;
	    }
	    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
	        e.preventDefault();
	    }
	});
	$("#mobileNumberMidNumb").keydown(function (e) {
	    if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
	        (e.keyCode == 65 && e.ctrlKey === true) || 
	        (e.keyCode >= 35 && e.keyCode <= 39)) {
	             return;
	    }
	    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
	        e.preventDefault();
	    }
	});
	$("#mobileNumberLastNumb").keydown(function (e) {
	    if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
	        (e.keyCode == 65 && e.ctrlKey === true) || 
	        (e.keyCode >= 35 && e.keyCode <= 39)) {
	             return;
	    }
	    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
	        e.preventDefault();
	    }
	});
});

function employeeValidation() {

	// =================================================================================
	// EMPLOYEE
	// =================================================================================
	$('#employeeAddEdit input[id="activeDirectory-domain"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#employeeAddEdit input[id="employeeCode"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#employeeAddEdit input[id="employeeNik"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#employeeAddEdit input[id="lastName"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});/*
	$('#organization-name').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'top'
	});*/
	$('#employeeAddress').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#employeeAddEdit input[id="phoneNumberAreaCode"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#employeeAddEdit input[id="phoneNumberMidNumb"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#employeeAddEdit input[id="phoneNumberLastNumb"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#employeeAddEdit input[id="mobileNumberAreaCode"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#employeeAddEdit input[id="mobileNumberMidNumb"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});/*
	$('#employeeAddEdit input[id="mobileNumberLastNumb"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});*/
	$('#employeeAddEdit input[id="email"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#golonganNumber').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'left'
	});
	$('#golonganLevel').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});

	// initialize validate plugin on the form
	$('#employeeAddEdit').validate({
		errorPlacement : function(error, element) {
			$(element).tooltipster('update', $(error).text());
			$(element).tooltipster('hide');
			$(element).addClass('highlight-default');
		},
		success : function(label, element) {
			$(element).tooltipster('hide');
			$(element).removeClass('highlight-default');
			$(element).tooltipster('update', 'accepted');
		},
		rules : {
			'newEmployee.employeeDomain' : {
				required : true,
				maxlength : 25
			},
			'newEmployee.employeeCode' : {
				required : true,
				minlength : 3
			},
			'newEmployee.employeeNik' : {
				required : true
			},
			'newEmployee.lastName' : {
				required : true
			},/*
			'newEmployee.businessUnitName' : {
				required : true
			},*/
			'newEmployee.employeeAddress' : {
				required : true
			},
			'newEmployee.phoneNumberAreaCode' : {
				digits : true,
				phoneArea : true,
				phoneExt : true
			},
			'newEmployee.phoneNumberMidNumb' : {
				digits : true,
				phoneNumber : true,
				phoneExt : true
			},
			'newEmployee.phoneNumberLastNumb' : {
				digits : true
			},
			'newEmployee.mobileNumberAreaCode' : {
				digits : true,
				mobileArea: true
			},
			'newEmployee.mobileNumberMidNumb' : {
				digits : true,
				mobileNumber : true
			},/*
			'newEmployee.mobileNumberLastNumb' : {
				digits : true
			},*/
			'newEmployee.email' : {
				required : true,
				email : true
			},
			'newEmployee.golonganNumber' : {
				required : true
			},
			'newEmployee.golonganLevel' : {
				required : true
			}
		},
		submitHandler : function(form) {
			form.submit();
			return false;
		}
	});
}