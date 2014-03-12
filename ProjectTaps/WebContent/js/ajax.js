$(document).ready(function() {
	$("#activeDirectory").on('click', function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : $("#lookUpActiveDirectory").html(),
			padding : 10,
			title : 'Employees AD'
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
			title : 'Employees'
		});
	});
	$("#employee2").on('click', function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : $("#lookUpEmployee2").html(),
			padding : 10,
			title : 'Employees'
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
			title : 'Organizations'
		});
	});
});


//===============================================================================
//Fungsi ajax look up untuk Active Directory Employee
//===============================================================================
function loadActiveDirectory(searchCategory, searchKeyword) {
	setTimeout(function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : $("#lookUpActiveDirectory").html(),
			padding : 10,
			title : 'Employees AD'
		});
		$(".search-category-ActiveDirectory").get(1).value = searchCategory;
		$(".search-keyword-ActiveDirectory").get(1).value = searchKeyword;
	}, 500);
}

function setParameterActiveDirectory() {
	var task = $("#task-ActiveDirectory").val();
	var search = $(".search-category-ActiveDirectory").get(1).value;
	var value = $(".search-keyword-ActiveDirectory").get(1).value;
	var page = $("#page-ActiveDirectory").val();
	var maxpage = $("#maxpage-ActiveDirectory").val();
	var mode = $("#mode-ActiveDirectory").val();
	var data = "task=" + task + "&searchCategory=" + search + "&searchKeyword="
			+ value + "&page=" + page + "&maxpage=" + maxpage + "&mode=" + mode;
	return data;
}

function setResponseActiveDirectory(data) {
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
	content += "<th class='text-center'>Name</th>";
	content += "</tr>";
	content += "</thead>";
	content += "<tbody>";
	for ( var i in json.listAD) {
		content += "<tr>";
		content += "<td class='text-center'>";
		content += "<input type='radio' name='ad_choose'";
		content += "value='" + json.listAD[i].userDomain + "' />";
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listAD[i].userDomain;
		content += "</td>";
		content += "<td>";
		content += json.listAD[i].fullName;
		content += "</td>";
		content += "</tr>";
	}
	content += "</tbody>";
	content += "</table>";
	$("#table-ajax-ActiveDirectory").html(content);
	$("#page-ActiveDirectory").val(json.page);
	$("#current-page-ActiveDirectory").html(json.page);
	$("#maxpage-ActiveDirectory").val(json.maxpage);
	$("#max-page-ActiveDirectory").html(json.maxpage);
	$("#total-record-ActiveDirectory").html(json.countRecord);
	$(".search-category-ActiveDirectory").val(json.searchCategory);
	$(".search-keyword-ActiveDirectory").val(json.searchKeyword);
}

function pagingActiveDirectory(direction) {
	var searchCategory = $(".search-category-ActiveDirectory").get(1).value;
	var searchKeyword = $(".search-keyword-ActiveDirectory").get(1).value;
	$.Dialog.close();
	$("#task-ActiveDirectory").val(direction);
	var data = setParameterActiveDirectory();
	$.ajax({
		url : "/ProjectTaps/ajax.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
			console.log("problem was here!");
		},
		success : function(data) {
			setResponseActiveDirectory(data);
		}
	});

	loadActiveDirectory(searchCategory, searchKeyword);
}

function chooseActiveDirectory() {
	var choosen = $("input[name='ad_choose']:checked").val();
	$("#activeDirectory-domain").val(choosen);
	
	$.Dialog.close();
}


// ===============================================================================
// Fungsi ajax look up untuk employees
// ===============================================================================
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

//===============================================================================
//Fungsi ajax look up untuk employees2
//===============================================================================
function loadEmployee2(searchCategory, searchKeyword) {
	setTimeout(function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : $("#lookUpEmployee2").html(),
			padding : 10,
			title : 'Employee'
		});
		$(".search-category-employee-2").get(1).value = searchCategory;
		$(".search-keyword-employee-2").get(1).value = searchKeyword;
	}, 500);
}

function setParameterEmployee2() {
	var task = $("#task-employee-2").val();
	var search = $(".search-category-employee-2").get(1).value;
	var value = $(".search-keyword-employee-2").get(1).value;
	var page = $("#page-employee-2").val();
	var maxpage = $("#maxpage-employee-2").val();
	var mode = $("#mode-employee-2").val();
	var data = "task=" + task + "&searchCategory=" + search + "&searchKeyword="
			+ value + "&page=" + page + "&maxpage=" + maxpage + "&mode=" + mode;
	return data;
}

function setResponseEmployee2(data) {
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
	for ( var i in json.listEmployees2) {
		content += "<tr>";
		content += "<td class='text-center'>";
		content += "<input type='radio' name='employee_choose2'";
		content += "value='" + json.listEmployees2[i].employeeDomain + "@"
				+ json.listEmployees2[i].employeeName + "' />";
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listEmployees2[i].employeeDomain;
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listEmployees2[i].employeeCode;
		content += "</td>";
		content += "<td>";
		content += json.listEmployees2[i].employeeName;
		content += "</td>";
		content += "<td>";
		content += json.listEmployees2[i].employeeAddress;
		content += "</td>";
		content += "</tr>";
	}
	content += "</tbody>";
	content += "</table>";
	$("#table-ajax-employee-2").html(content);
	$("#page-employee-2").val(json.page);
	$("#current-page-employee-2").html(json.page);
	$("#maxpage-employee-2").val(json.maxpage);
	$("#max-page-employee-2").html(json.maxpage);
	$("#total-record-employee-2").html(json.countRecord);
	$(".search-category-employee-2").val(json.searchCategory);
	$(".search-keyword-employee-2").val(json.searchKeyword);
}

function pagingEmployee2(direction) {
	var searchCategory = $(".search-category-employee-2").get(1).value;
	var searchKeyword = $(".search-keyword-employee-2").get(1).value;
	$.Dialog.close();
	$("#task-employee-2").val(direction);
	var data = setParameterEmployee2();
	$.ajax({
		url : "/ProjectTaps/ajax.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
			console.log("problem was here!");
		},
		success : function(data) {
			setResponseEmployee2(data);
		}
	});

	loadEmployee2(searchCategory, searchKeyword);
}

function chooseEmployee2() {
	var choosen = $("input[name='employee_choose2']:checked").val();
	$("#employee-domain-2").val(choosen.split('@')[0]);
	$("#employee-name-2").val(choosen.split('@')[1]);
	$.Dialog.close();
}



// ===============================================================================
// Fungsi ajax look up untuk organizations
// ===============================================================================
function loadOrganization(searchCategory, searchKeyword) {
	setTimeout(function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : $("#lookUpOrganization").html(),
			padding : 10,
			title : 'Organization'
		});
		$(".search-category-organization").get(1).value = searchCategory;
		$(".search-keyword-organization").get(1).value = searchKeyword;
	}, 500);
}

function setParameterOrganization() {
	var task = $("#task-organization").val();
	var search = $(".search-category-organization").get(1).value;
	var value = $(".search-keyword-organization").get(1).value;
	var page = $("#page-organization").val();
	var maxpage = $("#maxpage-organization").val();
	var mode = $("#mode-organization").val();
	var data = "task=" + task + "&searchCategory=" + search + "&searchKeyword="
			+ value + "&page=" + page + "&maxpage=" + maxpage + "&mode=" + mode;
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
	$(".search-category-organization").val(json.searchCategory);
	$(".search-keyword-organization").val(json.searchKeyword);
}

function pagingOrganization(direction) {
	var searchCategory = $(".search-category-organization").get(1).value;
	var searchKeyword = $(".search-keyword-organization").get(1).value;
	$.Dialog.close();
	$("#task-organization").val(direction);
	var data = setParameterOrganization();
	$.ajax({
		url : "/ProjectTaps/ajax.do",
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
	loadOrganization(searchCategory, searchKeyword);
}

function chooseOrganization() {
	var choosen = $("input[name='organization_choose']:checked").val().replace(
			/\-/g, '');
	$("#parent-organization-code").val(choosen.split('@')[0]);
	$("#parent-organization-name").val(choosen.split('@')[1]);
	$("#organization-code").val(choosen.split('@')[0]);
	$("#organization-name").val(choosen.split('@')[1]);
	$.Dialog.close();
}
