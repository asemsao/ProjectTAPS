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

function newAssignmentSaveValidation(radVal) {

	// =================================================================================
	// New Self Assignment SAVE
	// =================================================================================
	$('#project-name').tooltipster({
        trigger: 'hover',
        onlyOne: false,
        position: 'right'
    });
	if(radVal == "PROJECT"){
		if($('#project-name').val().length == 0){
			$('#project-name').tooltipster('update', 'This field is required');
			$('#project-name').addClass('highlight-default');
			$('#project-name').tooltipster('hide');
		}
		else{
			document.claimAssignmentForm.submit();
		}
	}
	else{
		document.claimAssignmentForm.submit();
	}
};

function newAssignmentValidation() {
	
	// =================================================================================
	// Assignment
	// =================================================================================
    $('#assignmentDate').tooltipster({
        trigger: 'hover',
        onlyOne: false,
        position: 'right'
    });
    $('#assignmentDueDate').tooltipster({
        trigger: 'hover',
        onlyOne: false,
        position: 'right'
    });
    $('#timepicker').tooltipster({
        trigger: 'hover',
        onlyOne: false,
        position: 'right'
    });
    $('#assignment-code').tooltipster({
        trigger: 'hover',
        onlyOne: false,
        position: 'right'
    });
    $('#employee-name').tooltipster({
        trigger: 'hover',
        onlyOne: false,
        position: 'right'
    });
    $('#project-name').tooltipster({
        trigger: 'hover',
        onlyOne: false,
        position: 'right'
    });
    $('#description').tooltipster({
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
        	'assignmentBean.projectName': {
                required: true
            },
        	'assignmentBean.reffTaskCode': {
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
