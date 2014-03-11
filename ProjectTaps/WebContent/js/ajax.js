$(document).ready(function() {
	$("#employee").on('click', function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : $("#lookUpEmployee").html(),
			padding : 10,
			title : 'Employee'
		});
	});
});

function loadEmployee(searchCategory, searchKeyword) {
	setTimeout(function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : $("#lookUpEmployee").html(),
			padding : 10,
			title : 'Employee'
		});
		$(".search-category-employee").get(1).value = searchCategory;
		$(".search-keyword-employee").get(1).value = searchKeyword;
	}, 500);
}

function setParameterEmployee() {
	var task = $("#task-employee").val();
	var search = $(".search-category-employee").get(1).value;
	var value = $(".search-keyword-employee").get(1).value;
	var page = $("#page-employee").val();
	var maxpage = $("#maxpage-employee").val();
	var mode = $("#mode-employee").val();
	var data = "task=" + task + "&searchCategory=" + search + "&searchKeyword="
			+ value + "&page=" + page + "&maxpage=" + maxpage + "&mode=" + mode;
	return data;
}

function setResponseEmployee(data) {
	var json = $.parseJSON(data);
	var content = "<table ";
	content += "class='table striped bordered hovered'>";
	content += "<thead>";
	content += "</thead>";
	content += "<tbody>";
	content += "<thead>";
	content += "<tr>";
	content += "<th class='text-center'>Choose</th>";
	content += "<th class='text-center'>Domain</th>";
	content += "<th class='text-center'>Code</th>";
	content += "<th class='text-center'>Name</th>";
	content += "<th class='text-center'>Address</th>";
	content += "</tr>";
	content += "</thead>";
	content += "<tbody>";
	for ( var i in json.listEmployees) {
		content += "<tr>";
		content += "<td class='text-center'>";
		content += "<input type='radio' name='employee_choose'";
		content += "value='" + json.listEmployees[i].employeeDomain + "@"
				+ json.listEmployees[i].employeeName + "' />";
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listEmployees[i].employeeDomain;
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listEmployees[i].employeeCode;
		content += "</td>";
		content += "<td>";
		content += json.listEmployees[i].employeeName;
		content += "</td>";
		content += "<td>";
		content += json.listEmployees[i].employeeAddress;
		content += "</td>";
		content += "</tr>";
	}
	content += "</tbody>";
	content += "</table>";
	$("#table-ajax-employee").html(content);
	$("#page-employee").val(json.page);
	$("#current-page-employee").html(json.page);
	$("#maxpage-employee").val(json.maxpage);
	$("#max-page-employee").html(json.maxpage);
	$("#total-record-employee").html(json.countRecord);
	$(".search-category-employee").val(json.searchCategory);
	$(".search-keyword-employee").val(json.searchKeyword);
}

function pagingEmployee(direction) {
	var searchCategory = $(".search-category-employee").get(1).value;
	var searchKeyword = $(".search-keyword-employee").get(1).value;
	$.Dialog.close();
	$("#task-employee").val(direction);
	var data = setParameterEmployee();
	$.ajax({
		url : "/ProjectTaps/ajax.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
			console.log("problem was here!");
		},
		success : function(data) {
			setResponseEmployee(data);
		}
	});

	loadEmployee(searchCategory, searchKeyword);
}

function chooseEmployee() {
	var choosen = $("input[name='employee_choose']:checked").val();
	$("#employee-domain").val(choosen.split('@')[0]);
	$("#employee-name").val(choosen.split('@')[1]);
	$.Dialog.close();
}