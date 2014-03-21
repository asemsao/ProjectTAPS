$(document).ready(function() {
	ajaxnotification();
	setInterval(function() {
		$(".notification").effect("bounce", {
			direction : 'up',
			distance : 20,
			times : 2
		});
	}, 1000);

	setInterval(function() {
		ajaxnotification();
	}, 10000);
});

function ajaxnotification() {
	var data = "mode=autoRefresh";
	$.ajax({
		url : "/ProjectTaps/dashboard.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
			console.log("problem was here!");
		},
		success : function(data) {
			notification(data);
		}
	});
}

function notification(data) {
	var json = $.parseJSON(data);
	$("#rfa").html(json.totalRFA);
	$("#rfa-s").html(json.totalRFAself);
	$("#claim").html(json.totalClaim);
	$("#correction").html(json.totalCorrection);
	$("#coorection-s").html(json.totalCorrectionSelf);

	if (json.unreadApproval) {
		$("#rfa-link").addClass('notification');
		$("#rfa-badge").removeClass('bg-gray');
		$("#rfa-badge").addClass('bg-red');
	} else {
		$("#rfa-link").removeClass('notification');
		$("#rfa-badge").removeClass('bg-red');
		$("#rfa-badge").addClass('bg-gray');
	}
	if (json.unreadApprovalSelf) {
		$("#rfa-s-link").addClass('notification');
		$("#rfa-s-badge").removeClass('bg-gray');
		$("#rfa-s-badge").addClass('bg-red');
	} else {
		$("#rfa-s-link").removeClass('notification');
		$("#rfa-s-badge").removeClass('bg-red');
		$("#rfa-s-badge").addClass('bg-gray');
	}
	if (json.unreadClaim) {
		$("#claim-link").addClass('notification');
		$("#claim-badge").removeClass('bg-gray');
		$("#claim-badge").addClass('bg-red');
	} else {
		$("#claim-link").removeClass('notification');
		$("#claim-badge").removeClass('bg-red');
		$("#claim-badge").addClass('bg-gray');
	}
	if (json.unreadCorrection) {
		$("#correction-link").addClass('notification');
		$("#correction-badge").removeClass('bg-gray');
		$("#correction-badge").addClass('bg-red');
	} else {
		$("#correction-link").removeClass('notification');
		$("#correction-badge").removeClass('bg-red');
		$("#correction-badge").addClass('bg-gray');
	}
	if (json.unreadCorrectionSelf) {
		$("#correction-s-link").addClass('notification');
		$("#correction-s-badge").removeClass('bg-gray');
		$("#correction-s-badge").addClass('bg-red');
	} else {
		$("#correction-s-link").removeClass('notification');
		$("#correction-s-badge").removeClass('bg-red');
		$("#correction-s-badge").addClass('bg-gray');
	}
}

// 60000
// totalClaim: 0
// totalCorrection: 0
// totalCorrectionSelf: 0
// totalRFA: 0
// totalRFAself: 0
