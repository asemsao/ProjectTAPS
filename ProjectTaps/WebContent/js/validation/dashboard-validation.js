function commentSelfSupervisorAssignmentValidation() {
	// =================================================================================
	// Comment Supervisor Report
	// =================================================================================

	$('#selfSupervisorAssignmentComment input[id="comment"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});

	// initialize validate plugin on the form
	$('#selfSupervisorAssignmentComment').validate({
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
			'selfAssignBean.comment' : {
				required : true
			}
		},
		submitHandler : function(form) {
			form.submit();
			return false;
		}
	});

};

function commentDashboardValidationSelf() {

	// =================================================================================
	// Comment Dashboard
	// =================================================================================

	$('#dashboardComment input[id="comment"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});

	// initialize validate plugin on the form
	$('#dashboardComment').validate({
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
			'selfAssignBean.comment' : {
				required : true
			}
		},
		submitHandler : function(form) {
			form.submit();
			return false;
		}
	});

};

function commentDashboardValidation() {

	// =================================================================================
	// Comment Dashboard
	// =================================================================================

	$('#dashboardComment input[id="comment"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});

	// initialize validate plugin on the form
	$('#dashboardComment').validate({
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

function commentClaimDateStringValidation() {

	// =================================================================================
	// Comment Claim
	// =================================================================================

	$('#claimDateString input[id="description"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#claimDateString input[id="manHours"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('.claimTime').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#claimDateString input[id="assignmentDate"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});

	// initialize validate plugin on the form
	$('#claimDateString').validate({
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
			'claimBean.detailDescription' : {
				required : true
			},
			'claimBean.manHours' : {
				required : true
			},
			'claimBean.claimTime' : {
				required : true
			},
			'claimBean.claimDate' : {
				required : true
			}
		},
		submitHandler : function(form) {
			form.submit();
			return false;
		}
	});

};