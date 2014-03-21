function newSelfAssignmentValidation() {

	// =================================================================================
	// New Self Assignment
	// =================================================================================
	$('#newSelfAssignment input[id="assignmentDate"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#newSelfAssignment input[id="project-name"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#newSelfAssignment input[id="employee-name"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#newSelfAssignment input[id="employee-name-2"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#newSelfAssignment input[id="timepicker"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});

	// initialize validate plugin on the form
	$('#newSelfAssignment').validate({
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
			'selfAssignBean.assignmentDate' : {
				required : true
			},
			'selfAssignBean.projectName' : {
				required : true
			},
			'selfAssignBean.reportToFullName' : {
				required : true
			},
			'selfAssignBean.adhocFullName' : {
				required : true
			},
			'selfAssignBean.assignmentTime' : {
				required : true
			}
		},
		submitHandler : function(form) {
			form.submit();
			return false;
		}
	});

};