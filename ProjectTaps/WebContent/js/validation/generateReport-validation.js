function reportValidation() {

	// =================================================================================
	// REPORT VALIDATION
	// =================================================================================
	$('.reportForm input[id="reportYear"]').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#reportPeriode').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});
	$('#reportMonth').tooltipster({
		trigger : 'hover',
		onlyOne : false,
		position : 'right'
	});

	// initialize validate plugin on the form
	$('.reportForm').validate({
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
			'reportYear' : {
				required : true
			},
			'reportPeriode' : {
				required : true
			},
			'reportMonth' : {
				required : true
			}
		},
		submitHandler : function(form) {
			form.submit();
			return false;
		}
	});
};