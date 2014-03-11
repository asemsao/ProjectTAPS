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
	$("#current-page").html(json.page);
	$("#max-page").html(json.maxpage);
	$("#total-record").html(json.countRecord);
}

function pagingOrganization(direction) {
	$.Dialog.close();
	$("#task").val(direction);
	var data = setParameter();
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