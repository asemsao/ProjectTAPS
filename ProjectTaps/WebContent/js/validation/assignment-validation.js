function commentAssigmentValidation() {

	// =================================================================================
	// Comment Assignment
	// =================================================================================

	$('#claimAssignment input[id="comment"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});

	// initialize validate plugin on the form
	$('#claimAssignment').validate({
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
			'claimBean.comment' : {
				required : true
			}
		},
		submitHandler : function(form) {
			form.submit();
			return false;
		}
	});

};

function newAssignmentSaveValidation() {

	// =================================================================================
	// New Self Assignment SAVE
	// =================================================================================

	$('#newAssignment input[id="project-name"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});

	// initialize validate plugin on the form
	$('#newAssignment').validate({
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
			'assignmentBean.projectName' : {
				required : true
			}
		},
		submitHandler : function(form) {
			form.submit();
			return false;
		}
	});

};


function newCorrectionAssignmentValidation() {

	// =================================================================================
	// New Self Assignment Correction
	// =================================================================================
	$('#employee-name').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});

	// initialize validate plugin on the form
	$('#selfAssignment').validate({
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
			'selfAssignBean.projectName' : {
				required : true
			}
		},
		submitHandler : function(form) {
			form.submit();
			return false;
		}
	});

};



function newAssignmentValidation() {
	
	// =================================================================================
	// Assignment
	// =================================================================================
    $('#newAssignment input[id="assignmentDate"]').tooltipster({
        trigger: 'hover',
        onlyOne: false,
        position: 'right'
    });
    $('#newAssignment input[id="assignmentDueDate"]').tooltipster({
        trigger: 'hover',
        onlyOne: false,
        position: 'right'
    });
    $('#newAssignment input[id="timepicker"]').tooltipster({
        trigger: 'hover',
        onlyOne: false,
        position: 'right'
    });
    $('#employee-name').tooltipster({
        trigger: 'hover',
        onlyOne: false,
        position: 'right'
    });
    $('#newAssignment input[id="project-name"]').tooltipster({
        trigger: 'hover',
        onlyOne: false,
        position: 'right'
    });
    $('#newAssignment input[id="employee-name"]').tooltipster({
        trigger: 'hover',
        onlyOne: false,
        position: 'right'
    });
    $('#newAssignment input[id="employee-name"]').tooltipster({
        trigger: 'hover',
        onlyOne: false,
        position: 'right'
    });
    $('#description').tooltipster({
        trigger: 'hover',
        onlyOne: false,
        position: 'right'
    });
    $('#employee-name').tooltipster({
        trigger: 'hover',
        onlyOne: false,
        position: 'right'
    });

    // initialize validate plugin on the form
    $('#newAssignment').validate({
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
        rules: {
        	'assignmentBean.assignmentDate': {
        		required: true
        	},
        	'assignmentBean.assignmentDueDate': {
                required: true
            },
        	'assignmentBean.assignmentTime': {
                required: true
            },
        	'#employee-name': {
                required: true
            },
        	'assignmentBean.projectName': {
                required: true
            },
        	'assignmentBean.assignToFullName': {
                required: true
            },
        	'assignmentBean.description': {
                required: true
            },
        	'assignmentBean.assignToFullName': {
                required: true,
                notEqualToAssignmentTo: true
            }
        },
        submitHandler: function (form) {
            form.submit();
            return false;
        }
    });
};