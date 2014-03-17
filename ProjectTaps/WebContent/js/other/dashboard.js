$(document).ready(function() {
	setInterval(function() {
		var data = "task=autoRefresh";
		$.ajax({
			url : "/ProjectTaps/dashboard.do",
			type : "POST",
			data : data,
			context : this,
			error : function() {
				console.log("problem was here!");
			},
			success : function(data) {
				var json = $.parseJSON(data);
				console.log(json);
				$("#rfa").html(json.totalRFA);
				$("#rfa-s").html(json.totalRFAself);
				$("#claim").html(json.totalClaim);
				$("#correction").html(json.totalCorrection);
				$("#coorection-s").html(json.totalCorrectionSelf);
			}
		});

	}, 10000);
});

// 60000
// totalClaim: 0
// totalCorrection: 0
// totalCorrectionSelf: 0
// totalRFA: 0
// totalRFAself: 0
