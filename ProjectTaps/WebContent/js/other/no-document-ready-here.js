function confDel() {
	$.Dialog({
		overlay : true,
		shadow : true,
		flat : true,
		icon : '<img src="images/LOGO_Taps6.png">',
		title : 'Flat window',
		content : '',
		padding : 50,
		onShow : function(_dialog) {
			$.Dialog.title("Confirmation");
			$.Dialog.content($("#popup_delete").html());
			$.Metro.initInputs();
		}
	});
}

function deleteBtn() {
	$("#task").val("delete");
	$("#CRUDForm").submit();
}

function appraisalBtn() {
	window.location.replace("index.jsp");
}

// LOOK UP ORGANIZATION
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

function setParameter() {
	var task = $("#task").val();
	var search = $("#search").val();
	var value = $("#value").val();
	var page = $("#page").val();
	var maxpage = $("#maxpage").val();
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
		content += "value='" + json.listOrganizations[i].organizationCode
				+ "' />";
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
	$("#current-page").html(json.page);
	$("#max-page").html(json.maxpage);
	$("#max-page").html(json.countRecord);
}

function lastOrganization() {
	$.Dialog.close();
	$("#task").val('last-ajax');
	var data = setParameter();
	$.ajax({
		url : "/ProjectTaps/organization.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
		},
		success : function(data) {
			setResponseOrganization(data);
		}
	});
	loadOrganization();
}

function nextOrganization() {
	$.Dialog.close();
	$("#task").val('next-ajax');
	var data = setParameter();
	$.ajax({
		url : "/ProjectTaps/organization.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
		},
		success : function(data) {
			setResponseOrganization(data);
		}
	});
	loadOrganization();
}

function prevOrganization() {
	$.Dialog.close();
	$("#task").val('prev-ajax');
	var data = setParameter();
	$.ajax({
		url : "/ProjectTaps/organization.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
		},
		success : function(data) {
			setResponseOrganization(data);
		}
	});
	loadOrganization();
}

function firstOrganization() {
	$.Dialog.close();
	$("#task").val('first-ajax');
	var data = setParameter();
	$.ajax({
		url : "/ProjectTaps/organization.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
		},
		success : function(data) {
			setResponseOrganization(data);
		}
	});
	loadOrganization();
}
function chooseBussinessUnit() {
	var choosen = $("input[name='organization_choose']:checked").val();
	$("#parent_organization_id").val(choosen.split('@')[0]);
	$("#parent_organization").val(choosen.split('@')[1]);
	$("#organization_id").val(choosen.split('@')[0]);
	$("#parent_organization").val(choosen.split('@')[1]);
	// $.Dialog.close();
}

function chooseEmployee() {
	var choosen = $("input[name='employee_choose']:checked").val();
	$("#employee_id").val(choosen.split('@')[0]);
	$("#employee_name").val(choosen.split('@')[1]);
	$.Dialog.close();
}

function chooseEmployee2() {
	var choosen = $("input[name='employee_choose']:checked").val();
	$("#employee_id-2").val(choosen.split('@')[0]);
	$("#employee_name-2").val(choosen.split('@')[1]);
	$.Dialog.close();
}

function chooseProject() {
	var choosen = $("input[name='employee_choose']:checked").val();
	$("#project_code").val(choosen.split('@')[0]);
	$("#project_name").val(choosen.split('@')[1]);
	$.Dialog.close();
}

function chooseTask() {
	var choosen = $("input[name='task_choose']:checked").val();
	$("#task_code").val(choosen);
	$.Dialog.close();
}