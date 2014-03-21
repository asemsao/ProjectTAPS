/* Created by jankoatwarpspeed.com */

(function($) {
	$.fn.formToWizard = function(options) {
		options = $.extend({
			submitButton : ""
		}, options);

		var element = this;

		var steps = $(element).find("fieldset");
		var count = steps.size();
		var submmitButtonName = "#" + options.submitButton;
		$(submmitButtonName).hide();

		// 2
		$(element).before("<ul id='steps'></ul>");

		steps.each(function(i) {
			$(this).wrap("<div id='step" + i + "'></div>");
			$(this).append("<p id='step" + i + "commands'></p>");

			// 2
			var name = $(this).find("legend").html();
			$("#steps").append(
					"<li id='stepDesc" + i + "'>Step " + (i + 1) + "<span>"
							+ name + "</span></li>");

			if (i == 0) {
				createNextButton(i);
				selectStep(i);
			} else if (i == count - 1) {
				$("#step" + i).hide();
				createPrevButton(i);
			} else {
				$("#step" + i).hide();
				createPrevButton(i);
				createNextButton(i);
			}
		});

		function createPrevButton(i) {
			var stepName = "step" + i;
			$("#" + stepName + "commands")
					.append(
							"<button type='button' id='"
									+ stepName
									+ "Prev' class='prev-wizard'><i class='icon-arrow-left-5'></i> Back</button>");

			$("#" + stepName + "Prev").bind("click", function(e) {
				$("#" + stepName).hide();
				$("#step" + (i - 1)).show();
				$(submmitButtonName).hide();
				selectStep(i - 1);
			});
		}

		function createNextButton(i) {
			var stepName = "step" + i;
			$("#" + stepName + "commands")
					.append(
							"<button type='button' id='"
									+ stepName
									+ "Next' class='next-wizard'>Next <i class='icon-arrow-right-5'></i></button>");

			$("#" + stepName + "Next").bind("click", function(e) {
				$("#" + stepName).hide();
				$("#step" + (i + 1)).show();
				if (i + 2 == count)
					$(submmitButtonName).show();
				selectStep(i + 1);
			});
		}

		function selectStep(i) {
			$("#steps li").removeClass("current");
			$("#stepDesc" + i).addClass("current");
		}

	}
	
})(jQuery);

function checkAll(elem) {
	if ($(elem).prop("checked")) {
		$("input:checkbox[name='member_choose']").prop("checked", true);
	} else {
		$("input:checkbox[name='member_choose']").prop("checked", false);
	}
}

function viewListProject() {
	var projectCategory = $("#projectCategory").val();
	var projectKeyword = $("#projectKeyword").val();
	var pagingDirection = $("#pagingDirection").val();
	var pageP = $("#pageP").val();
	var maxPageP = $("#maxPageP").val();
	var data = "task=searchProject" + "&projectCategory=" + projectCategory + "&projectKeyword=" + projectKeyword + "&pagingDirection=" + pagingDirection + "&pageP=" + pageP + "&maxPageP=" + maxPageP;
	$.ajax({
		url : "/ProjectTaps/transferProject.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
			console.log("problem was here!");
		},
		success : function(data) {
			var json = $.parseJSON(data);
			var content="";
			content += "<table class=\"table striped bordered hovered\">";
			if (json.listProject.length > 0) {
				content += "<thead>";
				content += "<tr>";
				content += "<th><\/th>";
				content += "<th class=\"text-center\">Project Code<\/th>";
				content += "<th class=\"text-center\">Project Name<\/th>";
				content += "<th class=\"text-center\">Client<\/th>";
				content += "<th class=\"text-center\">Business Unit<\/th>";
				content += "<th class=\"text-center\">Phase<\/th>";
				content += "<th class=\"text-center\">Start Date<\/th>";
				content += "<th class=\"text-center\">Estimate Finish Date<\/th>";
				content += "<th class=\"text-center\">Running (day)<\/th>";
				content += "<\/tr>";
				content += "<\/thead>";
				content += "<tbody>";
				for (var i in json.listProject) {
					content += "<tr>";
					content += "<td width=\"5%\">";
					content += "<div class=\"input-control radio default-style\">";
					content += "<label>";
					content += "<input type=\"radio\" name=\"project_choose\" value=\"" + json.listProject[i].projectCode + "\" \/>";
					content += "<span class=\"check\"><\/span>";
					content += "<\/label>";
					content += "<\/div>";
					content += "<\/td>";
					content += "<td class=\"text-center\">";
					content += json.listProject[i].projectCode;
					content += "<\/td>";
					content += "<td>";
					content += json.listProject[i].projectName;
					content += "<\/td>";
					content += "<td class=\"text-center\">";
					content += json.listProject[i].client;
					content += "<\/td>";
					content += "<td class=\"text-center\">";
					content += json.listProject[i].organizationCode;
					content += "<\/td>";
					content += "<td class=\"text-center\">";
					content += json.listProject[i].phase;
					content += "<\/td>";
					content += "<td class=\"text-center\">";
					content += json.listProject[i].startDate;
					content += "<\/td>";
					content += "<td class=\"text-center\">";
					content += json.listProject[i].endDate;
					content += "<\/td>";
					content += "<td class=\"text-center\">";
					content += json.listProject[i].runningDay;
					content += "<\/td>";
					content += "<\/tr>";
				}
			} else {
				content += "<tr>";
				content += "<td class=\"text-center\">";
				content += "Project not available";
				content += "<\/td>";
				content += "<\/tr>";
			}
			content += "<\/tbody>";
			content += "<\/table>";
			
			$("#table-list-project").html(content);
			if (json.listProject.length > 0) {
				$("input:radio[name='project_choose']:first").prop("checked", true);
				$("button#step0Next").prop("disabled", false);
			} else {
				$("button#step0Next").prop("disabled", true);
			}
			$("#pageP").val(json.pageP);
			$("#maxPageP").val(json.maxPageP);
			$("#currentRecordP").val(json.currentRecordP);
			$("span#currentPageP").html(json.pageP);
			$("span#lastPageP").html(json.maxPageP);
			$("span#totalRecordP").html(json.countRecordP);
		}
	});
}

function viewListOrg() {
	var orgCategory = $("#orgCategory").val();
	var orgKeyword = $("#orgKeyword").val();
	var pagingDirection = $("#pagingDirection").val();
	var pageO = $("#pageO").val();
	var maxPageO = $("#maxPageO").val();
	var data = "task=searchOrg" + "&orgCategory=" + orgCategory + "&orgKeyword=" + orgKeyword + "&pagingDirection=" + pagingDirection + "&pageO=" + pageO + "&maxPageO=" + maxPageO;
	$.ajax({
		url : "/ProjectTaps/transferProject.do",
		type : "POST",
		data : data,
		context : this,
		error : function() {
			console.log("problem was here!");
		},
		success : function(data) {
			var json = $.parseJSON(data);
			var content="";
			content += "<table class=\"table striped bordered hovered\">";
			if (json.listOrganization.length > 0) {
				content += "<thead>";
				content += "<tr>";
				content += "<th><\/th>";
				content += "<th colspan=3 class=\"text-center\">Business Unit Code<\/th>";
				content += "<th class=\"text-center\">Business Unit Name<\/th>";
				content += "<th class=\"text-center\">Head Name<\/th>";
				content += "<\/tr>";
				content += "<\/thead>";
				content += "<tbody>";
				for (var i in json.listOrganization) {
					content += "<tr>";
					content += "<td width=\"5%\">";
					content += "<div class=\"input-control radio default-style\">";
					content += "<label>";
					content += "<input type=\"radio\" name=\"org_choose\" value=\"" + json.listOrganization[i].organizationCode + '@' + json.listOrganization[i].organizationName + "\" \/>";
					content += "<span class=\"check\"><\/span>";
					content += "<\/label>";
					content += "<\/div>";
					content += "<\/td>";
					content += "<td width=\"4%\" class=\"text-center\">";
					if (json.listOrganization[i].organizationLevel == 0) {
						content += json.listOrganization[i].organizationCode;
					}
					content += "<td width=\"4%\" class=\"text-center\">";
					if (json.listOrganization[i].organizationLevel == 1) {
						content += json.listOrganization[i].organizationCode;
					}
					content += "<td width=\"4%\" class=\"text-center\">";
					if (json.listOrganization[i].organizationLevel == 2) {
						content += json.listOrganization[i].organizationCode;
					}
					content += "<\/td>";
					content += "<td>";
					content += json.listOrganization[i].organizationName;
					content += "<\/td>";
					content += "<td class=\"text-center\">";
					content += json.listOrganization[i].headName;
					content += "<\/td>";
					content += "<\/tr>";
				}
			} else {
				content += "<tr>";
				content += "<td class=\"text-center\">";
				content += "Project not available";
				content += "<\/td>";
				content += "<\/tr>";
			}
			content += "<\/tbody>";
			content += "<\/table>";
			
			$("#table-list-org").html(content);
			if (json.listOrganization.length > 0) {
				$("input:radio[name='org_choose']:first").prop("checked", true);
				$("button#step1Next").prop("disabled", false);
			} else {
				$("button#step1Next").prop("disabled", true);
			}
			$("#pageO").val(json.pageO);
			$("#maxPageO").val(json.maxPageO);
			$("#currentRecordO").val(json.currentRecordO);
			$("span#currentPageO").html(json.pageO);
			$("span#lastPageO").html(json.maxPageO);
			$("span#totalRecordO").html(json.countRecordO);
		}
	});
}

function button(pagingDirection) {
	$("#pagingDirection").val(pagingDirection);
	if (pagingDirection == "nextP" || pagingDirection == "prevP" || pagingDirection == "firstP" || pagingDirection == "lastP") {
		viewListProject();
	} else {
		viewListOrg();
	}
}

$(document).ready(function() {
	$("#projectKeyword").val("");
	$("#orgKeyword").val("");
	$("#pageP").val(1);
	$("#pageO").val(1);
	$("#myForm").formToWizard({ submitButton: 'submit-btn' });
	$("input:radio[name='project_choose']:first").prop("checked", true);
	$("input:radio[name='org_choose']:first").prop("checked", true);
	
	$("button#search-btn-project").click(function() {
		$("#pagingDirection").val("");
		$("#pageP").val(1);
		viewListProject();
	});
	
	$("button#search-btn-org").click(function() {
		viewListOrg();
	});
	
	$("button#step0Next").click(function() {
		var projectCode = $("input:radio[name='project_choose']:checked").val();
		var data = "task=retrieveFromStep1&projectCode=" + projectCode;
		$.ajax({
			url : "/ProjectTaps/transferProject.do",
			type : "POST",
			data : data,
			context : this,
			error : function() {
				console.log("problem was here!");
			},
			success : function(data) {
				var json = $.parseJSON(data);
				var projectContent = '<table class="table">' + '<tr>'
						+ '<td width="15%">Project Code</td>'
						+ '<td width="5%">:</td>' + '<td>'
						+ json.pBean.projectCode
						+ '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Project Name</td>'
						+ '<td width="5%">:</td>'
						+ '<td>'
						+ json.pBean.projectName
						+ '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Client</td>'
						+ '<td width="5%">:</td>'
						+ '<td>' + json.pBean.client + '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Business Unit</td>'
						+ '<td width="5%">:</td>'
						+ '<td>' + json.pBean.organizationName + ' (' + json.pBean.organizationCode + ')' + '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Phase</td>'
						+ '<td width="5%">:</td>'
						+ '<td>' + json.pBean.phase + '</td>'
						+ '</tr>'
						+ '</table>';
				
				$("#table-ajax-project").html(projectContent);
				
				var structureContent = "";
				if (json.listMember.length > 0) {
					structureContent += "<table class=\"table striped bordered hovered\">";
					structureContent += "<thead>";
					structureContent += "<tr>";
					structureContent += "<th class=\"text-center\"><div class=\"input-control checkbox align-left\"><label><input type=\"checkbox\" id=\"check-all\" onchange=\"checkAll(this)\" \/><span class=\"check\"><\/span><\/label><\/div><\/th>";
					structureContent += "<th class=\"text-center\">Role<\/th>";
					structureContent += "<th class=\"text-center\">Assignee<\/th>";
					structureContent += "<th class=\"text-center\">Direct Report<\/th>";
					structureContent += "<\/tr>";
					structureContent += "<\/thead>";
					structureContent += "<tbody>";			
					for ( var i in json.listMember) {
						structureContent += "<tr>";
						structureContent += "<td class=\"text-center\"><div class=\"input-control checkbox align-left\"><label><input type=\"checkbox\" name=\"member_choose\" value=\"" + json.listMember[i].assigneeUserDomain + "@" + json.listMember[i].assignee + "\" \/><span class=\"check\"><\/span><\/label><\/div><\/td>";
						structureContent += "<td>";
						structureContent += json.listMember[i].projectRole;
						structureContent += "</td><td>";
						structureContent += "<img src=\"transferProject.do?task=getAssigneePhoto&assigneeUserDomain=" + json.listMember[i].assigneeUserDomain + "\" style=\"width: 30px; height: 30px;\" \>&nbsp;&nbsp;";
						structureContent += json.listMember[i].assignee;
						structureContent += "</td><td>";
						structureContent += "<img src=\"transferProject.do?task=getDirectReportPhoto&directReportUserDomain=" + json.listMember[i].directReportUserDomain + "\" style=\"width: 30px; height: 30px;\" \>&nbsp;&nbsp;";
						structureContent += json.listMember[i].directReport;
						structureContent += "</td>";
						structureContent += "<\/tr>";
					}
					structureContent += "<\/tbody>";
					structureContent += "<\/table>";
				} else {
					structureContent += "<table class=\"table striped bordered hovered\">";
					structureContent += "<tr><td colspan=4 class=\"text-center\">No Member<\/td><\/tr>";
					structureContent += "<\/table>";
				}
				
				$("#table-ajax-structure").html(structureContent);
			}
		});
	});
	
	$("button#step1Next").click(function() {
		var projectCode = $("input:radio[name='project_choose']:checked").val();
		var orgCode = $("input:radio[name='org_choose']:checked").val().split('@')[0];
		var orgName = $("input:radio[name='org_choose']:checked").val().split('@')[1];
		var data = "task=retrieveFromStep2&projectCode=" + projectCode + "&orgCode=" + orgCode + "&orgName=" + orgName;
		$.ajax({
			url : "/ProjectTaps/transferProject.do",
			type : "POST",
			data : data,
			context : this,
			error : function() {
				console.log("problem was here!");
			},
			success : function(data) {
				var json = $.parseJSON(data);
				var projectContent = '<table class="table">' + '<tr>'
						+ '<td width="15%">Project Code</td>'
						+ '<td width="5%">:</td>' + '<td>'
						+ json.pBean.projectCode
						+ '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Project Name</td>'
						+ '<td width="5%">:</td>'
						+ '<td>'
						+ json.pBean.projectName
						+ '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Client</td>'
						+ '<td width="5%">:</td>'
						+ '<td>' + json.pBean.client + '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Business Unit</td>'
						+ '<td width="5%">:</td>'
						+ '<td>' + json.pBean.organizationName + ' ( <b>' + json.pBean.organizationCode + '</b> )' + '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Phase</td>'
						+ '<td width="5%">:</td>'
						+ '<td>' + json.pBean.phase + '</td>'
						+ '</tr>';
				
				projectContent += '<tr><td width="15%">Transfer<td width="5%">:</td><td>' + json.pBean.organizationName + ' ( <b>' + json.pBean.organizationCode + '</b> )';
				projectContent += '&nbsp;&nbsp;<i class="icon-arrow-right-5"></i>&nbsp;&nbsp;' + json.orgName + ' ( <b>' + json.orgCode + '</b> )';
				projectContent += '</td></tr></table>';
				$("#table-ajax-project2").html(projectContent);
			}
		});
	});
	
	$("button#step2Next").click(function() {
		var projectCode = $("input:radio[name='project_choose']:checked").val();
		var orgCode = $("input:radio[name='org_choose']:checked").val().split('@')[0];
		var orgName = $("input:radio[name='org_choose']:checked").val().split('@')[1];
		var data = "task=retrieveProject&projectCode=" + projectCode + "&orgCode=" + orgCode + "&orgName=" + orgName;
		$.ajax({
			url : "/ProjectTaps/transferProject.do",
			type : "POST",
			data : data,
			context : this,
			error : function() {
				console.log("problem was here!");
			},
			success : function(data) {
				var json = $.parseJSON(data);
				var projectContent = '<table class="table">' + '<tr>'
						+ '<td width="15%">Project Code</td>'
						+ '<td width="5%">:</td>' + '<td>'
						+ json.pBean.projectCode
						+ '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Project Name</td>'
						+ '<td width="5%">:</td>'
						+ '<td>'
						+ json.pBean.projectName
						+ '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Client</td>'
						+ '<td width="5%">:</td>'
						+ '<td>' + json.pBean.client + '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Business Unit</td>'
						+ '<td width="5%">:</td>'
						+ '<td>' + json.pBean.organizationName + ' ( <b>' + json.pBean.organizationCode + '</b> )' + '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Phase</td>'
						+ '<td width="5%">:</td>'
						+ '<td>' + json.pBean.phase + '</td>'
						+ '</tr>';
				
				projectContent += '<tr><td width="15%">Transfer<td width="5%">:</td><td>' + json.pBean.organizationName + ' ( <b>' + json.pBean.organizationCode + '</b> )';
				projectContent += '&nbsp;&nbsp;<i class="icon-arrow-right-5"></i>&nbsp;&nbsp;' + json.orgName + ' ( <b>' + json.orgCode + '</b> )';
				projectContent += '</td></tr></table>';
				$("#table-ajax-project3").html(projectContent);
			}
		});
	});
		
	$("button#step3Next").click(function() {
		var projectCode = $("input:radio[name='project_choose']:checked").val();
		var orgCode = $("input:radio[name='org_choose']:checked").val().split('@')[0];
		var orgName = $("input:radio[name='org_choose']:checked").val().split('@')[1];
		var data = "task=retrieveProject&projectCode=" + projectCode + "&orgCode=" + orgCode + "&orgName=" + orgName;
		$.ajax({
			url : "/ProjectTaps/transferProject.do",
			type : "POST",
			data : data,
			context : this,
			error : function() {
				console.log("problem was here!");
			},
			success : function(data) {
				var json = $.parseJSON(data);
				var summaryContent = '<table class="table">' + '<tr>'
						+ '<td width="15%">Project Code</td>'
						+ '<td width="5%">:</td>' + '<td>'
						+ json.pBean.projectCode
						+ '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Project Name</td>'
						+ '<td width="5%">:</td>'
						+ '<td>'
						+ json.pBean.projectName
						+ '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Client</td>'
						+ '<td width="5%">:</td>'
						+ '<td>' + json.pBean.client + '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Business Unit</td>'
						+ '<td width="5%">:</td>'
						+ '<td>' + json.pBean.organizationName + ' ( <b>' + json.pBean.organizationCode + '</b> )' + '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Phase</td>'
						+ '<td width="5%">:</td>'
						+ '<td>' + json.pBean.phase + '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Start Date</td>'
						+ '<td width="5%">:</td>'
						+ '<td>' + json.pBean.startDate + '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Finish Date</td>'
						+ '<td width="5%">:</td>'
						+ '<td>' + json.pBean.endDate + '</td>'
						+ '</tr>'
						+ '<tr>'
						+ '<td width="15%">Running (day)</td>'
						+ '<td width="5%">:</td>'
						+ '<td>' + json.pBean.runningDay + ' day' + '</td>'
						+ '</tr>';
				
				summaryContent += '<tr><td width="15%">Transfer<td width="5%">:</td><td>' + json.pBean.organizationName + ' ( <b>' + json.pBean.organizationCode + '</b> )';
				summaryContent += '&nbsp;&nbsp;<i class="icon-arrow-right-5"></i>&nbsp;&nbsp;' + json.orgName + ' ( <b>' + json.orgCode + '</b> )';
				summaryContent += '</td></tr>';
				summaryContent += "<tr>";
				summaryContent += "<td width=\"15%\">Member who stay</td>";
				summaryContent += "<td width=\"5%\">:</td>";
				summaryContent += "<td>";
				if ($("input:checkbox[name='member_choose']:not(:checked)").length > 0) {
					$("input:checkbox[name='member_choose']:not(:checked)").each(function() {
						summaryContent += "<img src=\"transferProject.do?task=getAssigneePhoto&assigneeUserDomain=" + $(this).val().split('@')[0] + "\" style=\"width: 30px; height: 30px;\" \>&nbsp;" + $(this).val().split('@')[1] + "&nbsp;&nbsp;";
					});
				} else {
					summaryContent += "&nbsp;<i class=\"icon-minus-2\"></i>";
				}
				summaryContent += "</td>";
				summaryContent += "</tr>";
				summaryContent += "<tr>";
				summaryContent += "<td width=\"15%\">Member who move</td>";
				summaryContent += "<td width=\"5%\">:</td>";
				summaryContent += "<td>";
				if ($("input:checkbox[name='member_choose']:checked").length > 0) {
					$("input:checkbox[name='member_choose']:checked").each(function() {
						summaryContent += "<img src=\"transferProject.do?task=getAssigneePhoto&assigneeUserDomain=" + $(this).val().split('@')[0] + "\" style=\"width: 30px; height: 30px;\" \>&nbsp;" + $(this).val().split('@')[1] + "&nbsp;&nbsp;";
					});
				} else {
					summaryContent += "&nbsp;<i class=\"icon-minus-2\"></i>";
				}
				summaryContent += "</td>";
				summaryContent += "</tr>";
				summaryContent += "</table>";
				
				$("#table-ajax-summary").html(summaryContent);
				$("#orgBefore").val(json.pBean.organizationCode);
			}
		});
	});
	
	$("#submit-btn").click(function() {
		var params = new Object();
		params.projectCode = $("input:radio[name='project_choose']:checked").val();
		params.orgCode = $("input:radio[name='org_choose']:checked").val().split('@')[0];
		params.transferDate = $("#transferDate").val();
		params.orgBefore = $("#orgBefore").val();
		var selected = $("input:checkbox[name='member_choose']:checked").map(function(i,el) {
							return $(el).val().split('@')[0];
						}).get();
		params.listMember = selected;
		var data = "task=updateTransfer&params=" + JSON.stringify(params);
		$.ajax({
			   type: "POST",
			   url: "/ProjectTaps/transferProject.do",
			   data: data,
			   error : function() {
					console.log("problem was here!");
				},
			   success: function() {
				   alert('Success');
			   }
		});
	});
});