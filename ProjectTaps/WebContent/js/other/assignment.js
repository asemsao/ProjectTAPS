$(document).ready(function() {
	$(".pr").hide();
	$("#bu").show();
	$(".adhoc").hide();
	$("input[name='assignment_type']").change(function() {
		if ($(this).val() == "PROJECT") {
			$(".pr").show();
			$("#bu").hide();
			resetFormEmployee();
		} else {
			$(".pr").hide();
			$("#bu").show();
			resetFormEmployee();
		}
	});
	$("input[name='activity_type']").change(function() {
		if ($(this).val() == "ADHOC") {
			$(".adhoc").show();
		} else {
			$(".adhoc").hide();
		}
	});
});

function resetFormEmployee() {
	$("#employee-domain").val('');
	$("#employee-fullName").val('');
	$("#employee-name").val('');
}

function calculateTotalMh(data) {
	var parts = data.split('.');
	var manHours = "";
	if (parts[0].length == 1) {
		manHours = "0" + parts[0];
	} else {
		manHours = parts[0];
	}
	if (parts[1] == "5") {
		manHours = manHours + ":30";
	} else {
		manHours = manHours + ":00";
	}
	return manHours;
}