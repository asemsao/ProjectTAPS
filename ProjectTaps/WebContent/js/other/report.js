$(document).ready(function() {
	$("#1month").hide();
	$("#6month").show();
	$("input[id='defaultCheck']").attr('checked', 'checked');
	$("input[class='reportFormCheck']").change(function() {
		if ($(this).val() == "6 Months") {
			$("#6month").show();
			$("#1month").hide();
		} else {
			$("#6month").hide();
			$("#1month").show();
		}
	});
});