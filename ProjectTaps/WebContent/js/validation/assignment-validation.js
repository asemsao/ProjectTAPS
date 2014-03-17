$(document).ready(function () {
	
	// =================================================================================
	// Assignment
	// =================================================================================
    $('#newAssignment input[id="assignmentDate"]').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    });
    $('#newAssignment input[id="assignmentDueDate"]').tooltipster({
        trigger: 'custom',
        onlyOne: false,
        position: 'right'
    });

    // initialize validate plugin on the form
    $('#newAssignment').validate({
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
        	'assignmentBean.assignmentDate': {
        		required: true,
                maxlength:25
        	},
        	'assignmentBean.assignmentDueDate': {
                required: true,
                maxlength:3
            }
        },
        submitHandler: function (form) {
            form.submit();
            return false;
        }
    });

});