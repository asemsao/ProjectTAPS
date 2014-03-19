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
	});
	$('#organization-name').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'top'
	});
	$('#employeeAddress').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#employeeAddEdit input[id="phoneNumber"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#employeeAddEdit input[id="mobileNumber"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
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
			'newEmployee.firstName' : {
				required : true
			},
			'newEmployee.businessUnitName' : {
				required : true
			},
			'newEmployee.employeeAddress' : {
				required : true
			},
			'newEmployee.phoneNumber' : {
				digits : true
			},
			'newEmployee.mobileNumber' : {
				digits : true
			},
			'newEmployee.email' : {
				required : true
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