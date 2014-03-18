$(document).ready(function () {
	
	// =================================================================================
	// New Self Assignment
	// =================================================================================
    $('#newSelfAssignment input[id="assignmentDate"]').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    });

    // initialize validate plugin on the form
    $('#newSelfAssignment').validate({
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
        	'selfAssignBean.assignmentDate': {
        		required: true,
                date: true
        	}
        },
        submitHandler: function (form) {
            form.submit();
            return false;
        }
    });

});