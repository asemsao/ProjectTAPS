function addProjectValidation() {

	// =================================================================================
	// ADD Project
	// =================================================================================
	$('#projectCode').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#projectName').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#client').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#parent-organization-name').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#startDate').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#endDate').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});

	// initialize validate plugin on the form
	$('.projectForm').validate({
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
			'addProject.projectCode' : {
				required : true,
				minlength: 4
			},
			'addProject.projectName' : {
				required : true
			},
			'addProject.client' : {
				required : true
			},
			'addProject.organizationName' : {
				required : true
			},
			'addProject.startDate' : {
				required : true
			},
			'addProject.endDate' : {
				required : true
			}
		},
		submitHandler : function(form) {
			form.submit();
			return false;
		}
	});
};

function editProjectValidation() {

	// =================================================================================
	// EDIT Project
	// =================================================================================
	$('#projectCode').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#projectName').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#client').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#parent-organization-name').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#startDate').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#endDate').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});

	// initialize validate plugin on the form
	$('.projectForm').validate({
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
			'pBean.projectCode' : {
				required : true
			},
			'pBean.projectName' : {
				required : true
			},
			'pBean.client' : {
				required : true
			},
			'pBean.organizationName' : {
				required : true
			},
			'pBean.startDate' : {
				required : true
			},
			'pBean.endDate' : {
				required : true
			}
		},
		submitHandler : function(form) {
			form.submit();
			return false;
		}
	});
};

function addProjectMember() {

	// =================================================================================
	// ADD Project Member
	// =================================================================================
	$('#role').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#employee-name').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#employee-name-2').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	// initialize validate plugin on the form
	$('.projectForm').validate({
		
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
			'addSProject.projectRole' : {
				required : true
			},
			'addSProject.assigneeName' : {
				required : true
			},
			'addSProject.directreportName' : {
				required : true,
				notEqualTo: true
			}
		},
		submitHandler : function(form) {
			form.submit();
			return false;
		}
	});
};


function editProjectMember() {

	// =================================================================================
	// EDIT Project Member
	// =================================================================================
	$('#projectRole').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#employee-name-2').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});

	// initialize validate plugin on the form
	$('.projectForm').validate({
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
			'addSProject.projectRole' : {
				required : true
			},
			'addSProject.directreportName' : {
				required : true,
				notEqualTo: true
			}
		},
		submitHandler : function(form) {
			form.submit();
			return false;
		}
	});
};