$(document).ready(function () {
	
	// =================================================================================
	// EMPLOYEE
	// =================================================================================
    $('#employeeAddEdit input[id="activeDirectory-domain"]').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    });
    $('#employeeAddEdit input[id="employeeCode"]').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    });
    $('#employeeAddEdit input[id="employeeNik"]').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    });
    $('#employeeAddEdit input[id="firstName"]').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    });
    $('#employeeAddEdit input[id="lastName"]').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    });
    $('#organization-name').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'top'
    });
    $('#employeeAddress').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    });
    $('#employeeAddEdit input[id="phoneNumber"]').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    });
    $('#employeeAddEdit input[id="mobileNumber"]').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    });
    $('#employeeAddEdit input[id="email"]').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    });
    $('#golonganNumber').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'left'
    });
    $('#golonganLevel').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    });

    // initialize validate plugin on the form
    $('#employeeAddEdit').validate({
        errorPlacement: function (error, element) {
            $(element).tooltipster('update', $(error).text());
            $(element).tooltipster('show');
            $(element).addClass('highlight-default');
        },
        success: function (label, element) {
            $(element).tooltipster('hide');
            $(element).removeClass('highlight-default');
            //$(element).tooltipster('update', 'accepted');
        },
        rules: {
        	'newEmployee.employeeDomain': {
        		required: true,
                maxlength:25
        	},
        	'newEmployee.employeeCode': {
                required: true,
                maxlength:3
            },
        	'newEmployee.employeeNik': {
                required: true,
                maxlength:8
            },
        	'newEmployee.firstName': {
                required: true,
                maxlength:20
            },
        	'newEmployee.lastName': {
                required: true,
                maxlength:25
            },
            'newEmployee.businessUnit': {
                required: true
            },
        	'newEmployee.employeeAddress': {
                required: true,
                maxlength:50
            },
        	'newEmployee.phoneNumber': {
                required: true,
                digits:true,
                maxlength:12
            },
        	'newEmployee.mobileNumber': {
                required: true,
                digits:true,
                maxlength:15
            },
        	'newEmployee.email': {
                required: true,
                maxlength:30
            },
        	'newEmployee.golonganNumber': {
                required: true
            },
        	'newEmployee.golonganLevel': {
                required: true
            }
        },
        submitHandler: function (form) {
            form.submit();
            return false;
        }
    });

});