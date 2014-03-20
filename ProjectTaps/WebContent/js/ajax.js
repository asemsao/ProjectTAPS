$(document).ready(
		function() {
			$(".deleteEmployee").on(
					'click',
					function() {
						$("#lookUpDeleteEmployee").load(
								"/ProjectTaps/ajax.do?mode=deleteEmployee&task=deleteEmployee&userDomain="
										+ $(this).attr('alt').trim());
						setTimeout(function() {
							$.Dialog({
								overlay : true,
								shadow : true,
								flat : true,
								icon : '<img src="images/LOGO_Taps6.png">',
								title : 'Flat window',
								content : $("#lookUpDeleteEmployee").html(),
								padding : 10,
								title : 'Assignment'
							});
						}, 500);
					});
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
			$("#employeeOnProject").on('click', function() {
				$.Dialog({
					overlay : true,
					shadow : true,
					flat : true,
					icon : '<img src="images/LOGO_Taps6.png">',
					title : 'Flat window',
					content : $("#lookUpEmployeeOnProject").html(),
					padding : 10,
					title : 'Employees on Project'
				});
			});
			$("#employeeOnOrganization").on('click', function() {
				$.Dialog({
					overlay : true,
					shadow : true,
					flat : true,
					icon : '<img src="images/LOGO_Taps6.png">',
					title : 'Flat window',
					content : $("#lookUpEmployeeOnOrganization").html(),
					padding : 10,
					title : 'Employees on Organization'
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
			$("#assigment").on('click', function() {
				$.Dialog({
					overlay : true,
					shadow : true,
					flat : true,
					icon : '<img src="images/LOGO_Taps6.png">',
					title : 'Flat window',
					content : $("#lookUpAssignment").html(),
					padding : 10,
					title : 'Assignment'
				});
			});
			$("#project").on('click', function() {
				$.Dialog({
					overlay : true,
					shadow : true,
					flat : true,
					icon : '<img src="images/LOGO_Taps6.png">',
					title : 'Flat window',
					content : $("#lookUpProject").html(),
					padding : 10,
					title : 'Project'
				});
			});
		});

// ===============================================================================
// Fungsi ajax look up untuk assignment
// ===============================================================================
function loadAssignmentDelete(searchCategory, searchKeyword) {
	setTimeout(function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : $("#lookUpDeleteEmployee").html(),
			padding : 10,
			title : 'Assignment'
		});
		$(".search-category-assignment-delete").get(1).value = searchCategory;
		$(".search-keyword-assignment-delete").get(1).value = searchKeyword;
	}, 400);
}

function setParameterAssignmentDelete() {
	var task = $("#task-assignment-delete").val();
	var search = $(".search-category-assignment-delete").get(1).value;
	var value = $(".search-keyword-assignment-delete").get(1).value;
	var page = $("#page-assignment-delete").val();
	var maxpage = $("#maxpage-assignment-delete").val();
	var assignmentCategory = $("#assignmentCategory-assignment-delete").val();
	var assignmentType = $("#assignmentType-assignment-delete").val();
	var mode = $("#mode-assignment-delete").val();
	var userDomain = $("#userDomain-assignment-delete").val();
	var data = "task=" + task + "&searchCategory=" + search + "&searchKeyword="
			+ value + "&page=" + page + "&maxpage=" + maxpage + "&mode=" + mode
			+ "&assignmentCategory=" + assignmentCategory + "&assignmentType="
			+ assignmentType + "&userDomain=" + userDomain;
	return data;
}

function setResponseAssignmentDelete(data) {
	var json = $.parseJSON(data);
	var content = "<table ";
	content += "class='table striped bordered hovered'>";
	content += "<thead>";
	content += "</thead>";
	content += "<tbody>";
	content += "<thead>";
	content += "<tr>";
	content += "<th class='text-center'>Date</th>";
	content += "<th class='text-center'>Code</th>";
	content += "<th class='text-center'>Type</th>";
	content += "<th class='text-center'>Employee</th>";
	content += "<th class='text-center'>Deadline</th>";
	content += "</tr>";
	content += "</thead>";
	content += "<tbody>";
	for ( var i in json.listEmployeeReport) {
		content += "<tr>";
		content += "<td class='text-center'>";
		content += json.listEmployeeReport[i].assignmentDate;
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listEmployeeReport[i].assignmentCode;
		content += "</td>";
		content += "<td>";
		content += json.listEmployeeReport[i].assignmentCategory;
		content += "</td>";
		content += "<td>";
		content += json.listEmployeeReport[i].fullName;
		content += "</td>";
		content += "<td>";
		content += json.listEmployeeReport[i].assignmentDueDate;
		content += "</td>";
		content += "</tr>";
	}
	content += "</tbody>";
	content += "</table>";
	$("#table-ajax-assignment-delete").html(content);
	$("#page-assignment-delete").val(json.page);
	$("#current-page-assignment-delete").html(json.page);
	$("#maxpage-assignment-delete").val(json.maxpage);
	$("#max-page-assignment-delete").html(json.maxpage);
	$("#total-record-assignment-delete").html(json.countRecord);
	$(".search-category-assignment-delete").val(json.searchCategory);
	$(".search-keyword-assignment-delete").val(json.searchKeyword);
}

function pagingAssignmentDelete(direction) {
	var searchCategory = $(".search-category-assignment-delete").get(1).value;
	var searchKeyword = $(".search-keyword-assignment-delete").get(1).value;
	$.Dialog.close();
	$("#task-assignment-delete").val(direction);
	var data = setParameterAssignmentDelete();
	$.ajax({
		url : "/ProjectTaps/ajax.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
			console.log("problem was here!");
		},
		success : function(data) {
			setResponseAssignmentDelete(data);
		}
	});

	loadAssignmentDelete(searchCategory, searchKeyword);
}

function chooseAssignmentDelete(task) {
	if (task == "delete") {
		var choosen = $("input[id='userDomain-assignment-delete']").val();
		$("#employeeDomain").val(choosen);
		$("#task").val("delete");
		$("#CRUDForm").submit();
	}
	$.Dialog.close();
}

// ===============================================================================
// Fungsi ajax look up untuk Active Directory Employee
// ===============================================================================
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
	}, 400);
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
	$("#activeDirectory-domain").val(choosen).trigger('change');

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
	}, 400);
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
	
	if ($("#headBu").length > 0) {
		var headBu = $("#headBu").val();
		data += "&headBu=" + headBu;
	} 

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
	$("#employee-name").val(choosen.split('@')[1]).trigger('change');
	$.Dialog.close();
}

// ===============================================================================
// Fungsi ajax look up untuk employees on project
// ===============================================================================
function loadEmployeeOnProject(searchCategory, searchKeyword) {
	setTimeout(
			function() {
				$.Dialog({
					overlay : true,
					shadow : true,
					flat : true,
					icon : '<img src="images/LOGO_Taps6.png">',
					title : 'Flat window',
					content : $("#lookUpEmployeeOnProject").html(),
					padding : 10,
					title : 'Employee on Project'
				});
				$(".search-category-employee-on-project").get(1).value = searchCategory;
				$(".search-keyword-employee-on-project").get(1).value = searchKeyword;
			}, 400);
}

function setParameterEmployeeOnProject() {
	var task = $("#task-employee-on-project").val();
	var search = $(".search-category-employee-on-project").get(1).value;
	var value = $(".search-keyword-employee-on-project").get(1).value;
	var page = $("#page-employee-on-project").val();
	var maxpage = $("#maxpage-employee-on-project").val();
	var mode = $("#mode-employee-on-project").val();
	var project = $("#project-code").val();
	var data = "task=" + task + "&searchCategory=" + search + "&searchKeyword="
			+ value + "&page=" + page + "&maxpage=" + maxpage + "&mode=" + mode
			+ "&projectCode=" + project;
	return data;
}

function setResponseEmployeeOnProject(data) {
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
	content += "<th class='text-center'>Role</th>";
	content += "</tr>";
	content += "</thead>";
	content += "<tbody>";
	for ( var i in json.listEmployeesOnProject) {
		content += "<tr>";
		content += "<td class='text-center'>";
		content += "<input type='radio' name='employee_choose_on_project'";
		content += "value='" + json.listEmployeesOnProject[i].employeeDomain
				+ "@" + json.listEmployeesOnProject[i].employeeName + "' />";
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listEmployeesOnProject[i].employeeDomain;
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listEmployeesOnProject[i].employeeCode;
		content += "</td>";
		content += "<td>";
		content += json.listEmployeesOnProject[i].employeeName;
		content += "</td>";
		content += "<td>";
		content += json.listEmployeesOnProject[i].projectRole;
		content += "</td>";
		content += "</tr>";
	}
	content += "</tbody>";
	content += "</table>";
	$("#table-ajax-employee-on-project").html(content);
	$("#page-employee-on-project").val(json.page);
	$("#current-page-employee-on-project").html(json.page);
	$("#maxpage-employee-on-project").val(json.maxpage);
	$("#max-page-employee-on-project").html(json.maxpage);
	$("#total-record-employee-on-project").html(json.countRecord);
	$(".search-category-employee-on-project").val(json.searchCategory);
	$(".search-keyword-employee-on-project").val(json.searchKeyword);
}

function pagingEmployeeOnProject(direction) {
	var searchCategory = $(".search-category-employee-on-project").get(1).value;
	var searchKeyword = $(".search-keyword-employee-on-project").get(1).value;
	$.Dialog.close();
	$("#task-employee-on-project").val(direction);
	var data = setParameterEmployeeOnProject();
	$.ajax({
		url : "/ProjectTaps/ajax.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
			console.log("problem was here!");
		},
		success : function(data) {
			setResponseEmployeeOnProject(data);
		}
	});

	loadEmployeeOnProject(searchCategory, searchKeyword);
}

function chooseEmployeeOnProject() {
	var choosen = $("input[name='employee_choose_on_project']:checked").val();
	$("#employee-domain").val(choosen.split('@')[0]);
	$("#employee-name").val(choosen.split('@')[1]);
	$.Dialog.close();
}

// ===============================================================================
// Fungsi ajax look up untuk employees on Organization
// ===============================================================================
function loadEmployeeOnOrganization(searchCategory, searchKeyword) {
	setTimeout(
			function() {
				$.Dialog({
					overlay : true,
					shadow : true,
					flat : true,
					icon : '<img src="images/LOGO_Taps6.png">',
					title : 'Flat window',
					content : $("#lookUpEmployeeOnOrganization").html(),
					padding : 10,
					title : 'Employee on Organization'
				});
				$(".search-category-employee-on-organization").get(1).value = searchCategory;
				$(".search-keyword-employee-on-organization").get(1).value = searchKeyword;
			}, 400);
}

function setParameterEmployeeOnOrganization() {
	var task = $("#task-employee-on-organization").val();
	var search = $(".search-category-employee-on-organization").get(1).value;
	var value = $(".search-keyword-employee-on-organization").get(1).value;
	var page = $("#page-employee-on-organization").val();
	var maxpage = $("#maxpage-employee-on-organization").val();
	var mode = $("#mode-employee-on-organization").val();
	var organization = $("#organization-code").val();
	var data = "task=" + task + "&searchCategory=" + search + "&searchKeyword="
			+ value + "&page=" + page + "&maxpage=" + maxpage + "&mode=" + mode
			+ "&organizationCode=" + organization;
	return data;
}

function setResponseEmployeeOnOrganization(data) {
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
	for ( var i in json.listEmployeesOnOrganization) {
		content += "<tr>";
		content += "<td class='text-center'>";
		content += "<input type='radio' name='employee_choose_on_organization'";
		content += "value='"
				+ json.listEmployeesOnOrganization[i].employeeDomain + "@"
				+ json.listEmployeesOnOrganization[i].employeeName + "' />";
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listEmployeesOnOrganization[i].employeeDomain;
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listEmployeesOnOrganization[i].employeeCode;
		content += "</td>";
		content += "<td>";
		content += json.listEmployeesOnOrganization[i].employeeName;
		content += "</td>";
		content += "<td>";
		content += json.listEmployeesOnOrganization[i].employeeAddress;
		content += "</td>";
		content += "</tr>";
	}
	content += "</tbody>";
	content += "</table>";
	$("#table-ajax-employee-on-organization").html(content);
	$("#page-employee-on-organization").val(json.page);
	$("#current-page-employee-on-organization").html(json.page);
	$("#maxpage-employee-on-organization").val(json.maxpage);
	$("#max-page-employee-on-organization").html(json.maxpage);
	$("#total-record-employee-on-organization").html(json.countRecord);
	$(".search-category-employee-on-organization").val(json.searchCategory);
	$(".search-keyword-employee-on-organization").val(json.searchKeyword);
}

function pagingEmployeeOnOrganization(direction) {
	var searchCategory = $(".search-category-employee-on-organization").get(1).value;
	var searchKeyword = $(".search-keyword-employee-on-organization").get(1).value;
	$.Dialog.close();
	$("#task-employee-on-organization").val(direction);
	var data = setParameterEmployeeOnOrganization();
	$.ajax({
		url : "/ProjectTaps/ajax.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
			console.log("problem was here!");
		},
		success : function(data) {
			setResponseEmployeeOnOrganization(data);
		}
	});

	loadEmployeeOnOrganization(searchCategory, searchKeyword);
}

function chooseEmployeeOnOrganization() {
	var choosen = $("input[name='employee_choose_on_organization']:checked")
			.val();
	$("#employee-domain").val(choosen.split('@')[0]);
	$("#employee-name").val(choosen.split('@')[1]);
	$.Dialog.close();
}

// ===============================================================================
// Fungsi ajax look up untuk employees2
// ===============================================================================
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
	}, 400);
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
	}, 400);
}

function setParameterOrganization() {
	var task = $("#task-organization").val();
	var search = $(".search-category-organization").get(1).value;
	var value = $(".search-keyword-organization").get(1).value;
	var page = $("#page-organization").val();
	var maxpage = $("#maxpage-organization").val();
	var mode = $("#mode-organization").val();
	var level = $("#level-organization").val();
	var data = "task=" + task + "&searchCategory=" + search + "&searchKeyword="
			+ value + "&page=" + page + "&maxpage=" + maxpage + "&mode=" + mode
			+ "&level=" + level;
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
	$("#parent-organization-code").val(choosen.split('@')[0].trim());
	$("#parent-organization-name").val(choosen.split('@')[1].trim());
	$("#organization-code").val(choosen.split('@')[0].trim());
	$("#organization-name").val(choosen.split('@')[1].trim());
	$.Dialog.close();
}

// ===============================================================================
// Fungsi ajax look up untuk assignment
// ===============================================================================
function loadAssignment(searchCategory, searchKeyword) {
	setTimeout(function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : $("#lookUpAssignment").html(),
			padding : 10,
			title : 'Assignment'
		});
		$(".search-category-assignment").get(1).value = searchCategory;
		$(".search-keyword-assignment").get(1).value = searchKeyword;
	}, 400);
}

function setParameterAssignment() {
	var task = $("#task-assignment").val();
	var search = $(".search-category-assignment").get(1).value;
	var value = $(".search-keyword-assignment").get(1).value;
	var page = $("#page-assignment").val();
	var maxpage = $("#maxpage-assignment").val();
	var assignmentCategory = $("#assignmentCategory-assignment").val();
	var assignmentType = $("#assignmentType-assignment").val();
	var mode = $("#mode-assignment").val();
	var data = "task=" + task + "&searchCategory=" + search + "&searchKeyword="
			+ value + "&page=" + page + "&maxpage=" + maxpage + "&mode=" + mode
			+ "&assignmentCategory=" + assignmentCategory + "&assignmentType="
			+ assignmentType;
	return data;
}

function setResponseAssignment(data) {
	var json = $.parseJSON(data);
	var content = "<table ";
	content += "class='table striped bordered hovered'>";
	content += "<thead>";
	content += "</thead>";
	content += "<tbody>";
	content += "<thead>";
	content += "<tr>";
	content += "<th class='text-center'>Choose</th>";
	content += "<th class='text-center'>Date</th>";
	content += "<th class='text-center'>Code</th>";
	content += "<th class='text-center'>Type</th>";
	content += "<th class='text-center'>Employee</th>";
	content += "<th class='text-center'>Deadline</th>";
	content += "</tr>";
	content += "</thead>";
	content += "<tbody>";
	for ( var i in json.listEmployeeReport) {
		content += "<tr>";
		content += "<td class='text-center'>";
		content += "<input type='radio' name='assignment_choose'";
		content += "value='" + json.listEmployeeReport[i].assignmentCode
				+ "' />";
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listEmployeeReport[i].assignmentDate;
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listEmployeeReport[i].assignmentCode;
		content += "</td>";
		content += "<td>";
		content += json.listEmployeeReport[i].assignmentCategory;
		content += "</td>";
		content += "<td>";
		content += json.listEmployeeReport[i].fullName;
		content += "</td>";
		content += "<td>";
		content += json.listEmployeeReport[i].assignmentDueDate;
		content += "</td>";
		content += "</tr>";
	}
	content += "</tbody>";
	content += "</table>";
	$("#table-ajax-assignment").html(content);
	$("#page-assignment").val(json.page);
	$("#current-page-assignment").html(json.page);
	$("#maxpage-assignment").val(json.maxpage);
	$("#max-page-assignment").html(json.maxpage);
	$("#total-record-assignment").html(json.countRecord);
	$(".search-category-assignment").val(json.searchCategory);
	$(".search-keyword-assignment").val(json.searchKeyword);
}

function pagingAssignment(direction) {
	var searchCategory = $(".search-category-assignment").get(1).value;
	var searchKeyword = $(".search-keyword-assignment").get(1).value;
	$.Dialog.close();
	$("#task-assignment").val(direction);
	var data = setParameterAssignment();
	$.ajax({
		url : "/ProjectTaps/ajax.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
			console.log("problem was here!");
		},
		success : function(data) {
			setResponseAssignment(data);
		}
	});

	loadAssignment(searchCategory, searchKeyword);
}

function chooseAssignment() {
	var choosen = $("input[name='assignment_choose']:checked").val();
	$("#assignment-code").val(choosen);
	$.Dialog.close();
}

// ===============================================================================
// Fungsi ajax look up untuk project
// ===============================================================================
function loadProject(searchCategory, searchKeyword) {
	setTimeout(function() {
		$.Dialog({
			overlay : true,
			shadow : true,
			flat : true,
			icon : '<img src="images/LOGO_Taps6.png">',
			title : 'Flat window',
			content : $("#lookUpProject").html(),
			padding : 10,
			title : 'Project'
		});
		$(".search-category-project").get(1).value = searchCategory;
		$(".search-keyword-project").get(1).value = searchKeyword;
	}, 400);
}

function setParameterProject() {
	var task = $("#task-project").val();
	var search = $(".search-category-project").get(1).value;
	var value = $(".search-keyword-project").get(1).value;
	var page = $("#page-project").val();
	var maxpage = $("#maxpage-project").val();
	var mode = $("#mode-project").val();
	var data = "task=" + task + "&searchCategory=" + search + "&searchKeyword="
			+ value + "&page=" + page + "&maxpage=" + maxpage + "&mode=" + mode;
	return data;
}

function setResponseProject(data) {
	var json = $.parseJSON(data);
	var content = "<table ";
	content += "class='table striped bordered hovered'>";
	content += "<thead>";
	content += "</thead>";
	content += "<tbody>";
	content += "<thead>";
	content += "<tr>";
	content += "<th class='text-center'>Choose</th>";
	content += "<th class='text-center'>Code</th>";
	content += "<th class='text-center'>Name</th>";
	content += "<th class='text-center'>Client</th>";
	content += "<th class='text-center'>Start Date</th>";
	content += "<th class='text-center'>Phase</th>";
	content += "<th class='text-center'>Organization</th>";
	content += "</tr>";
	content += "</thead>";
	content += "<tbody>";
	for ( var i in json.listProject) {
		content += "<tr>";
		content += "<td class='text-center'>";
		content += "<input type='radio' name='project_choose'";
		content += "value='" + json.listProject[i].projectCode + "@"
				+ json.listProject[i].projectName + "'/>";
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listProject[i].projectCode;
		content += "</td>";
		content += "<td>";
		content += json.listProject[i].projectShortName;
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listProject[i].client;
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listProject[i].startDate;
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listProject[i].phase;
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.listProject[i].organizationCode;
		content += "</td>";
		content += "</tr>";
	}
	content += "</tbody>";
	content += "</table>";
	$("#table-ajax-project").html(content);
	$("#page-project").val(json.page);
	$("#current-page-project").html(json.page);
	$("#maxpage-project").val(json.maxpage);
	$("#max-page-project").html(json.maxpage);
	$("#total-record-project").html(json.countRecord);
	$(".search-category-project").val(json.searchCategory);
	$(".search-keyword-project").val(json.searchKeyword);
}

function pagingProject(direction) {
	var searchCategory = $(".search-category-project").get(1).value;
	var searchKeyword = $(".search-keyword-project").get(1).value;
	$.Dialog.close();
	$("#task-project").val(direction);
	var data = setParameterProject();
	$.ajax({
		url : "/ProjectTaps/ajax.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
			console.log("problem was here!");
		},
		success : function(data) {
			setResponseProject(data);
		}
	});

	loadProject(searchCategory, searchKeyword);
}

function chooseProject() {
	var choosen = $("input[name='project_choose']:checked").val();
	$("#project-code").val(choosen.split('@')[0]).trigger('change');
	;
	$("#project-name").val(choosen.split('@')[1]).trigger('change');
	;
	$.Dialog.close();
}

// ===============================================================================
// Fungsi ajax untuk paging comment
// ===============================================================================

function setParameterComment() {
	var task = $("#task-comment").val();
	var page = $("#page-comment").val();
	var maxpage = $("#maxpage-comment").val();
	var mode = $("#mode-comment").val();
	var taskCode = $("#task-code").val();
	var data = "task=" + task + "&page=" + page + "&maxpage=" + maxpage
			+ "&mode=" + mode + "&taskCode=" + taskCode;
	return data;
}

function setResponseComment(data) {
	var json = $.parseJSON(data);
	var content = "<table ";
	content += "class='table striped bordered hovered'>";
	content += "<thead>";
	content += "</thead>";
	content += "<tbody>";
	content += "<thead>";
	content += "<tr>";
	content += "<th class='text-center' colspan=5>History Comment</th>";
	content += "</tr>";
	content += "<tr>";
	content += "<th class='text-center'>Date</th>";
	content += "<th class='text-center'>Comment</th>";
	content += "<th class='text-center'>From</th>";
	content += "<th class='text-center'>To</th>";
	content += "<th class='text-center'>Status</th>";
	content += "</tr>";
	content += "</thead>";
	content += "<tbody>";
	for ( var i in json.historyComment) {
		content += "<tr>";
		content += "<td class='text-center'>";
		content += json.historyComment[i].commentDate;
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.historyComment[i].assignmentComment;
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.historyComment[i].commentFrom;
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.historyComment[i].commentTo;
		content += "</td>";
		content += "<td class='text-center'>";
		content += json.historyComment[i].status;
		content += "</td>";
		content += "</tr>";
	}
	content += "</tbody>";
	content += "</table>";
	$("#table-ajax-comment").html(content);
	$("#page-comment").val(json.page);
	$("#current-page-comment").html(json.page);
	$("#maxpage-comment").val(json.maxpage);
	$("#max-page-comment").html(json.maxpage);
	$("#total-record-comment").html(json.countRecord);
}

function pagingComment(direction) {
	$("#task-comment").val(direction);
	var data = setParameterComment();
	$.ajax({
		url : "/ProjectTaps/ajax.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
			console.log("problem was here!");
		},
		success : function(data) {
			setResponseComment(data);
		}
	});
}