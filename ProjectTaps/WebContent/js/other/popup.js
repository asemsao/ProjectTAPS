$(document).ready(function() {
	$("#employee").on('click', function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : '',
			padding : 10,
			onShow : function(_dialog) {
				$.Dialog.title("Employee");
				$.Dialog.content($("#popup_employee").html());
				$.Metro.initInputs();
			}
		});
	});

	$("#employee-2").on('click', function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : '',
			padding : 10,
			onShow : function(_dialog) {
				$.Dialog.title("Employee");
				$.Dialog.content($("#popup_employee-2").html());
				$.Metro.initInputs();
			}
		});
	});

	$("#task").on('click', function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : '',
			padding : 10,
			onShow : function(_dialog) {
				$.Dialog.title("Task Code");
				$.Dialog.content($("#popup_task").html());
				$.Metro.initInputs();
			}
		});
	});

	$("#organization").on('click', function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : $("#lookUpOrganization").html(),
			padding : 10,
			title : 'Bussiness Unit'
		});
	});

	function dialogFunction() {
		$("#next-ajax").click(function(e) {
			alert(1);
		});
	}

	$("#project").on('click', function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : '',
			padding : 10,
			onShow : function(_dialog) {
				$.Dialog.title("Projects");
				$.Dialog.content($("#popup_project").html());
				$.Metro.initInputs();
			}
		});
	});

	$("#appraisal").on('click', function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : '',
			padding : 10,
			onShow : function(_dialog) {
				$.Dialog.title("Appraisal");
				$.Dialog.content($("#popup_appraisal").html());

				$.Metro.initInputs();
			}
		});
	});

	$("#approve").on('click', function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : '',
			padding : 10,
			onShow : function(_dialog) {
				$.Dialog.title("Approval");
				$.Dialog.content($("#popup_approve").html());
				$.Metro.initInputs();
			}
		});
	});

	$("#updatestar").on('click', function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : '',
			padding : 10,
			onShow : function(_dialog) {
				$.Dialog.title("Star");
				$.Dialog.content($("#popup_updatestar").html());
				$.Metro.initInputs();
			}
		});
	});

});
