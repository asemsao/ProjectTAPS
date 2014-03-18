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
							"<button type='button' onclick='nextWizard()' disabled id='"
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

function nextWizard() {
	var projectCode = $("input[name='project_choose']:checked").val();
	var data = "task=retrieve&projectCode=" + projectCode;
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
					+ '</tr>' + '</table>';
			
			$("#table-ajax-project").html(projectContent);
			$("#table-ajax-project2").html(projectContent);
			
			var structureContent = "";
			if (json.listMember.length > 0) {
				structureContent += "<table class=\"table striped bordered hovered\">";
				structureContent += "<thead>";
				structureContent += "<tr>";
				structureContent += "<th class=\"text-center\"><div class=\"input-control checkbox align-left\"><label><input type=\"checkbox\" \/><span class=\"check\"><\/span><\/label><\/div><\/th>";
				structureContent += "<th class=\"text-center\">Role<\/th>";
				structureContent += "<th class=\"text-center\">Assignee<\/th>";
				structureContent += "<th class=\"text-center\">Direct Report<\/th>";
				structureContent += "<\/tr>";
				structureContent += "<\/thead>";
				structureContent += "<tbody>";			
				for ( var i in json.listMember) {
					structureContent += "<tr>";
					structureContent += "<td class=\"text-center\"><div class=\"input-control checkbox align-left\"><label><input type=\"checkbox\" name=\"member_choose\" value=\"" + json.listMember[i].assigneeUserDomain + "\" \/><span class=\"check\"><\/span><\/label><\/div><\/td>";
					structureContent += "<td>";
					structureContent += json.listMember[i].projectRole;
					structureContent += "</td><td>";
					structureContent += json.listMember[i].assignee;
					structureContent += "</td><td>";
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
}


function nextWizard(){
	var choosen = $("input[name='project_choose']:checked").val();
	$("#choosenBU").html(choosen);
}
