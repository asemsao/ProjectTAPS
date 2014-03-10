function confDel() {
	$.Dialog({
		overlay : true,
		shadow : true,
		flat : true,
		icon : '<img src="../images/LOGO_Taps6.png">',
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

function appraisalBtn() {
	window.location.replace("index.jsp");
}

function chooseBussinessUnit() {
	var choosen = $("input[name='organization_choose']:checked").val();
	$("#parent_organization_id").val(choosen.split('@')[0]);
	$("#parent_organization").val(choosen.split('@')[1]);
	$("#organization_id").val(choosen.split('@')[0]);
	$("#parent_organization").val(choosen.split('@')[1]);
	$.Dialog.close();
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