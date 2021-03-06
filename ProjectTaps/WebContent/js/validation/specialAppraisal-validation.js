function specialAppraisalValidation() {

	// =================================================================================
	// SPECIAL APPRAISAL
	// =================================================================================
	$('#createdDate').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#employee-name').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#description').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});

	// initialize validate plugin on the form
	$('#specialAppraisal').validate({
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
			'appraisalBean.createdDate' : {
				required : true
			},
			'appraisalBean.employeeName' : {
				required : true
			},
			'appraisalBean.description' : {
				required : true
			}
		},
		submitHandler : function(form) {
			form.submit();
			return false;
		}
	});
};