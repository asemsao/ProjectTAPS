$(document).ready(
		function() {
			$("#dashboard").click(function() {
				window.location.replace("../main/dashboard.jsp");
			});

			$("#datepicker-begin, #datepicker-end, #datepicker").datepicker({
				date : "2014-01-01",
				format : "dd/mm/yyyy",
				effect : "none",
				position : "bottom"
			});

			$(".choose").click(
					function(e) {
						// e.preventDefault();
						$(this).addClass('menu-accordion-choosen').siblings()
								.removeClass('menu-accordion-choosen').parent()
								.siblings().find('.menu-accordion-choosen')
								.removeClass('menu-accordion-choosen');

					});
			// =================================================================================
			// REPORT
			// =================================================================================
			$("#1month").hide();
			$("#6month").show();
			$("input[name='period_type']").change(function() {
				if ($(this).val() == "6 Months") {
					$("#6month").show();
					$("#1month").hide();
				} else {
					$("#6month").hide();
					$("#1month").show();
				}
			});
			$("#generate-btn").click(function() {
				window.location.replace("view.jsp");
			});
			$("#back-btn").click(function() {
				window.location.replace("index.jsp");
			});

			// =================================================================================
			// PROJECTS
			// =================================================================================
			$("#save-btn").click(function() {
				window.location.replace("structure.jsp");
			});
			$("#cancel-btn-2").click(function() {
				window.location.replace("structure.jsp");
			});
			$("#back-btn").click(function() {
				window.location.replace("index.jsp");
			});
			$("#add-btn").click(function() {
				window.location.replace("add.jsp");
			});
			$("#save-btn").click(function() {
				window.location.replace("index.jsp");
			});
			$("#cancel-btn").click(function() {
				window.location.replace("index.jsp");
			});

			// =================================================================================
			// APPRAISAL
			// =================================================================================
			$("#rating").rating({
				stars : 11,
				score : 6,
				// showScore : true,
				// scoreHint: "",
				static : false,
				click : function(value, rating) {
					rating.rate(value);
				}
			});
			$("#appraisal-btn").click(function() {
				window.location.replace("index.jsp");
			});

			// =================================================================================
			// EMPLOYEE
			// =================================================================================
			$("#__input_file_wrapper__").attr('placeholder', 'Browse File');

			// =================================================================================
			// ASSIGNMENT
			// =================================================================================
			$("#approve-btn").click(function() {
				window.location.replace("index.jsp");
			});
			$("#correction-btn").click(function() {
				window.location.replace("index.jsp");
			});
			$("#reject-btn").click(function() {
				window.location.replace("index.jsp");
			});
			$("#cancel-btn").click(function() {
				window.location.replace("index.jsp");
			});
			$("#claim-btn").click(function() {
				window.location.replace("index.jsp");
			});
			$("#claimclose-btn").click(function() {
				window.location.replace("index.jsp");
			});

			$("#firstclaim-btn").click(function() {
				window.location.replace("index_claim.jsp");
			});
			$("#firstclaimclose-btn").click(function() {
				window.location.replace("index_claim.jsp");
			});
			$("#firstcancel-btn").click(function() {
				window.location.replace("index_claim.jsp");
			});

			$(".pr").hide();
			$("#bu").show();
			$(".adhoc").hide();
			$("input[name='assignment_type']").change(function() {
				if ($(this).val() == "Project") {
					$(".pr").show();
					$("#bu").hide();
				} else {
					$(".pr").hide();
					$("#bu").show();
				}
			});
			$("input[name='activity_type']").change(function() {
				if ($(this).val() == "AdHoc") {
					$(".adhoc").show();
				} else {
					$(".adhoc").hide();
				}
			});
			$("#save-btn").click(function() {
				window.location.replace("index.jsp");
			});
			$("#save-btn-emp").click(function() {
				window.location.replace("index.jsp");
			});
			$("#assign-btn").click(function() {
				window.location.replace("index.jsp");
			});
			$("#cancel-btn").click(function() {
				window.location.replace("index.jsp");
			});
			$("#updatestar-btn").click(function() {
				window.location.replace("index.jsp");
			});

		});
