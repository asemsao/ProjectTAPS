// LOOK UP ORGANIZATION
$(document).ready(function() {
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

function loadOrganization() {
	setTimeout(function() {
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
	}, 500);
}

function setParameterOrganization() {
	var task = $("#task-organization").val();
	var search = $("#search-organization").val();
	var value = $("#value-organization").val();
	var page = $("#page-organization").val();
	var maxpage = $("#maxpage-organization").val();
	var data = "task=" + task + "&search=" + search + "&value=" + value
			+ "&page=" + page + "&maxpage=" + maxpage;
	return data;
}

function setResponseOrganization(data) {
	var json = $.parseJSON(data);
	var content = "<table ";
	content += "class='table striped bordered hovered'>";
	content += "<thead>";
	content += "</thead>";
	content += "<tbody>";
	content += "<thead>";
	content += "<tr>";
	content += "<th class='text-center'>Choose</th>";
	content += "<th class='text-center'>Organization Code</th>";
	content += "<th class='text-center'>Organization Name</th>";
	content += "<th class='text-center'>Head Name</th>";
	content += "</tr>";
	content += "</thead>";
	content += "<tbody>";
	for ( var i in json.listOrganizations) {
		content += "<tr>";
		content += "<td class='text-center'>";
		content += "<input type='radio' name='organization_choose'";
		content += "value='" + json.listOrganizations[i].organizationCode + "@"
				+ json.listOrganizations[i].organizationName + "' />";
		content += "</td>";
		content += "<td>";
		content += json.listOrganizations[i].organizationCode;
		content += "</td>";
		content += "<td>";
		content += json.listOrganizations[i].organizationName;
		content += "</td>";
		content += "<td>";
		content += json.listOrganizations[i].headName;
		content += "</td>";
		content += "</tr>";
	}
	content += "</tbody>";
	content += "</table>";
	$("#table-ajax-organization").html(content);
	$("#page-organization").val(json.page);
	$("#current-page-organization").html(json.page);
	$("#maxpage-organization").val(json.maxpage);
	$("#max-page-organization").html(json.maxpage);
	$("#total-record-organization").html(json.countRecord);
}

function pagingOrganization(direction) {
	$.Dialog.close();
	$("#task-organization").val(direction);
	var data = setParameterOrganization();
	$.ajax({
		url : "/ProjectTaps/organization.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
			console.log("problem was here!");
		},
		success : function(data) {
			setResponseOrganization(data);
		}
	});
	loadOrganization();
}

function chooseBussinessUnit() {
	var choosen = $("input[name='organization_choose']:checked").val().replace(
			/\-/g, '');
	$("#parent_organization_id").val(choosen.split('@')[0]);
	$("#parent_organization").val(choosen.split('@')[1]);
	$("#organization_id").val(choosen.split('@')[0]);
	$("#organization").val(choosen.split('@')[1]);
	$.Dialog.close();
}

// numpang employee

function loadEmployee() {
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
	}, 500);
}

function setParameterEmployee() {
	var task = $("#task-employee").val();
	var search = $("#search-employee").val();
	var value = $("#value-employee").val();
	var page = $("#page-employee").val();
	var maxpage = $("#maxpage-employee").val();
	var data = "task=" + task + "&search=" + search + "&value=" + value
			+ "&pageEmployee=" + page + "&maxpageEmployee=" + maxpage;
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
	$("#page-employee").val(json.pageEmployee);
	$("#current-page-employee").html(json.pageEmployee);
	$("#maxpage-employee").val(json.maxpageEmployee);
	$("#max-page-employee").html(json.maxpageEmployee);
	$("#total-record-employee").html(json.countRecordEmployee);
}

function pagingEmployee(direction) {
	$.Dialog.close();
	$("#task-employee").val(direction);
	var data = setParameterEmployee();
	$.ajax({
		url : "/ProjectTaps/organization.do",
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
	loadEmployee();
}

function chooseEmployee() {
	var choosen = $("input[name='employee_choose']:checked").val();
	$("#employee_id").val(choosen.split('@')[0]);
	$("#employee_name").val(choosen.split('@')[1]);
	$.Dialog.close();
}