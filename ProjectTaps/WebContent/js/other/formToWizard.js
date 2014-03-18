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
							"<button type='button' disabled id='"
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

$(document).ready(function() {
	$("#myForm").formToWizard({ submitButton: 'submit-btn' });
	$("input:radio[name='project_choose']").prop("checked", false);
	$("input:radio[name='project_choose']").click(function() {
		$("button.next-wizard").prop("disabled", false);
	});
	$("input:radio[name='org_choose']").click(function() {
		$("button.next-wizard").prop("disabled", false);
	});
	
	$("button#step0Next").click(function() {
		var projectCode = $("input:radio[name='project_choose']:checked").val();
		var data = "task=retrieveProject&projectCode=" + projectCode;
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
				
				$("#table-ajax-project").html(projectContent + '</table>');
			}
		});
	});
	
	$("button#step1Next").click(function() {
		var projectCode = $("input:radio[name='project_choose']:checked").val();
		var orgCode = $("input:radio[name='org_choose']:checked").val().split('@')[0];
		var orgName = $("input:radio[name='org_choose']:checked").val().split('@')[1];
		var data = "task=retrieveStructure&projectCode=" + projectCode + "&orgCode=" + orgCode + "&orgName=" + orgName;
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
						+ '</tr></table>';
				
				projectContent += '<tr><td width="15%">Transfer<td width="5%">:</td><td>' + json.pBean.organizationName + ' ( <b>' + json.pBean.organizationCode + '</b> )';
				projectContent += '&nbsp;&nbsp;<i class="icon-arrow-right-5"></i>&nbsp;&nbsp;' + json.orgName + ' ( <b>' + json.orgCode + '</b> )';
				projectContent += '</td></tr>';
				$("#table-ajax-project2").html(projectContent);
				
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
		
	$("button#step2Next").click(function() {
		var projectCode = $("input:radio[name='project_choose']:checked").val();
		var orgCode = $("input:radio[name='org_choose']:checked").val().split('@')[0];
		var orgName = $("input:radio[name='org_choose']:checked").val().split('@')[1];
		var data = "task=retrieveStructure&projectCode=" + projectCode + "&orgCode=" + orgCode + "&orgName=" + orgName;
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
			}
		});
	});
	
	$("#submit-btn").click(function() {
		var params = new Object();
		params.projectCode = $("input:radio[name='project_choose']:checked").val();
		params.orgCode = $("input:radio[name='org_choose']:checked").val().split('@')[0];
		var selected = $("input:checkbox[name='member_choose']:checked").map(function(i,el) {
							return $(el).val().split('@')[0];
						}).get();
		params.listMember = selected;
		var data = "task=update&params=" + JSON.stringify(params);
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