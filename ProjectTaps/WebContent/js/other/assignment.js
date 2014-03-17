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
