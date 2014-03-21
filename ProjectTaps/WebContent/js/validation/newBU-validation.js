function newBUValidation() {

	// =================================================================================
	// New BU
	// =================================================================================
	$('#organizationCode').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#organizationName').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#employee-name').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});

	// initialize validate plugin on the form
	$('.organizationForm').validate({
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
			'orgBean.organizationCode' : {
				required : true
			},
			'orgBean.organizationName' : {
				required : true
			},
			'orgBean.headName' : {
				required : true
			}
		},
		submitHandler : function(form) {
			form.submit();
			return false;
		}
	});
};