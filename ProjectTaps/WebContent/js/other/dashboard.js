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
				// $("#auto-refresh").html($("#ar").val() + "=");
			}
		});

		
	}, 5000);
});

// 60000