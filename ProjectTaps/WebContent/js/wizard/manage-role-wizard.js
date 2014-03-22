function checkAll(elem) {
	if ($(elem).prop("checked")) {
		$("input:checkbox[name='menu_choose']").each(function() {
			if (!$(this).is(":disabled")) {
				$(this).prop("checked", true);
			}
		});
	} else {
		$("input:checkbox[name='menu_choose']").prop("checked", false);
	}
}

function viewListMenu() {
	var roleId = $("input:radio[name='role_choose']:checked").val().split('@')[0];
	var roleName = $("input:radio[name='role_choose']:checked").val()
			.split('@')[1];
	var data = "task=listMenu" + "&roleId=" + roleId;
	$
			.ajax({
				url : "/ProjectTaps/manageRole.do",
				type : "POST",
				data : data,
				context : this,
				error : function() {
					console.log("problem was here!");
				},
				success : function(data) {
					var json = $.parseJSON(data);
					var menuContent = "";
					if (json.listMenu.length > 0) {
						menuContent += '<table class="table">' + '<tr>'
								+ '<td width="15%">Role</td>'
								+ '<td width="5%">:</td>' + '<td>' + roleName
								+ '</td>' + '</tr>' + '</table>';
						menuContent += "<table id=\"table-ajax-list-menu\" class=\"table striped bordered hovered\">";
						menuContent += "<thead>";
						menuContent += "<tr>";
						menuContent += "<th class=\"text-center\"><div class=\"input-control checkbox align-left\"><label><input type=\"checkbox\" id=\"check-all\" onchange=\"checkAll(this)\"  \/><span class=\"check\"><\/span><\/label><\/div><\/th>";
						menuContent += "<th class=\"text-center\">Menu Name<\/th>";
						menuContent += "<th class=\"text-center\">Description<\/th>";
						menuContent += "<\/tr>";
						menuContent += "<\/thead>";
						menuContent += "<tbody>";
						for ( var i in json.listMenu) {
							menuContent += "<tr>";
							if (json.listMenu[i].isExist == "1") {
								menuContent += "<td>";
								menuContent += "<div class=\"input-control checkbox align-left\"><label><input checked name=\"menu_choose\" type=\"checkbox\" value=\""
										+ json.listMenu[i].menuId
										+ "@"
										+ json.listMenu[i].menuName
										+ "\" \/><span class=\"check\"><\/span><\/label><\/div>";
								menuContent += "</td><td>";
							} else {
								menuContent += "<td>";
								menuContent += "<div class=\"input-control checkbox align-left\"><label><input name=\"menu_choose\" type=\"checkbox\" value=\""
										+ json.listMenu[i].menuId
										+ "@"
										+ json.listMenu[i].menuName
										+ "\" \/><span class=\"check\"><\/span><\/label><\/div>";
								menuContent += "</td><td>";
							}
							menuContent += json.listMenu[i].menuName;
							menuContent += "</td><td>";
							menuContent += json.listMenu[i].description;
							menuContent += "</td>";
							menuContent += "<\/tr>";
						}

					} else {
						menuContent += "<tr><td colspan=3 class=\"text-center\">No Menu<\/td><\/tr>";
					}

					menuContent += "<\/tbody>";
					menuContent += "<\/table>";
					$("#table-ajax-list-menu").html(menuContent);
				}
			});
}

function viewSummary() {
	// var roleId =
	// $("input:radio[name='role_choose']:checked").val().split('@')[0];
	var roleName = $("input:radio[name='role_choose']:checked").val()
			.split('@')[1];
	var data = "task=retrieveSummary";
	$
			.ajax({
				url : "/ProjectTaps/manageRole.do",
				type : "POST",
				data : data,
				context : this,
				error : function() {
					console.log("problem was here!");
				},
				success : function(data) {
					var json = $.parseJSON(data);
					var summaryContent = "";
					summaryContent += '<table class="table">' + '<tr>'
					+ '<td width="15%">Role</td>'
					+ '<td width="5%">:</td>' + '<td>' + roleName
					+ '</td>' + '</tr>';
					if ($("input:checkbox[name='menu_choose']:checked").length > 0) {
						summaryContent += '<table class="table">' + '<tr>'
						+ '<td width="15%">Menu Given</td>'
						+ '<td width="5%">:</td>' + '<td>';
						
						$("input:checkbox[name='menu_choose']:checked").each(function() {
							summaryContent += $(this).val().split('@')[1]+"; ";
						});
						summaryContent += '</td>' + '</tr>';;
					} else {
						summaryContent += "<tr><td colspan=3 class=\"text-center\">No Menu<\/td><\/tr>";
					}

					summaryContent += "<\/tbody>";
					summaryContent += "<\/table>";
					$("#table-ajax-summary-menu-role").html(summaryContent);
				}
			});
}

$(document).ready(
		function() {
			$("#mrForm").formToWizard({
				submitButton : 'submit-btn-menu-role'
			});
			$("#step0Next").click(function() {
				viewListMenu();
			});
			$("#step1Next").click(function() {
				viewSummary();
			});

			$("#submit-btn-menu-role").click(
					function() {
						var params = new Object();
						params.roleId = $(
								"input:radio[name='role_choose']:checked")
								.val().split('@')[0];
						var selected = $(
								"input:checkbox[name='menu_choose']:checked")
								.map(function(i, el) {
									return $(el).val().split('@')[0];
								}).get();
						params.listMenu = selected;
						var data = "task=updateRoleMenu&params="
								+ JSON.stringify(params);
						$.ajax({
							type : "POST",
							url : "/ProjectTaps/manageRole.do",
							data : data,
							error : function() {
								console.log("problem was here!");
							},
							success : function() {
								alert('Success');
							}
						});
					});
		});
