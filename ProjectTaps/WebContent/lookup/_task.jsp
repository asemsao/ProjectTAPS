<script type="text/javascript">
	$("#datepicker-begin, #datepicker-end").datepicker({
		date : "2014-01-01",
		format : "dd/mm/yyyy",
		effect : "none",
		position : "bottom"
	});
	$('#select-search').selectize();
</script>
<div class='span10'>
	<table class='table'>
		<thead>
			<tr>
				<th colspan=6 class='text-center'>List Task</th>
			</tr>
			<tr>
				<th colspan=6>Periode :
					<div class="input-control text size2 in-bl" id="datepicker-begin">
						<input type="text">
						<button class="btn-date"></button>
					</div> -
					<div class="input-control text size2" id="datepicker-end">
						<input type="text">
						<button class="btn-date"></button>
					</div>
				</th>

			</tr>
			<tr>
				<td colspan=2 class="text-center">
					<div class="input-control select size2">
						<select>
							<option value=''>All</option>
							<option value='taskCode'>Task Code</option>
							<option value='taskType'>Task Type</option>
							<option value='employeeName'>Employee Name</option>
						</select>
					</div>
				</td>
				<td colspan=4 class="text-center">
					<div class="input-control text size8">
						<input type='text' placeholder='Keyword of Task' />
						<button class='btn-search'></button>
					</div>
				</td>
			</tr>
			<tr>
				<th></th>
				<th class="text-center">Task Date</th>
				<th class="text-center">Task Code</th>
				<th class="text-center">Task Type</th>
				<th class="text-center">Employee Name</th>
				<th class="text-center">Deadline</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class='text-center'><input type='radio'
					name='employee_choose' value='1'></td>
				<td class="text-center">18-11-2013</td>
				<td class="text-center">PRJ123456789</td>
				<td class="text-center">Assignment</td>
				<td class="text-center">Kartiko Edhi</td>
				<td class="text-center">01-04-2014</td>
			</tr>
			<tr>
				<td class='text-center'><input type='radio'
					name='employee_choose' value='2'></td>
				<td class="text-center">18-11-2013</td>
				<td class="text-center">PRJ123456789</td>
				<td class="text-center">Assignment</td>
				<td class="text-center">Kartiko Edhi</td>
				<td class="text-center">01-04-2014</td>
			</tr>
			<tr>
				<td class='text-center'><input type='radio'
					name='employee_choose' value='3'></td>
				<td class="text-center">18-11-2013</td>
				<td class="text-center">PRJ123456789</td>
				<td class="text-center">Assignment</td>
				<td class="text-center">Kartiko Edhi</td>
				<td class="text-center">01-04-2014</td>
			</tr>
			<tr>
				<td class='text-center'><input type='radio'
					name='employee_choose' value='4'></td>
				<td class="text-center">18-11-2013</td>
				<td class="text-center">PRJ123456789</td>
				<td class="text-center">Assignment</td>
				<td class="text-center">Kartiko Edhi</td>
				<td class="text-center">01-04-2014</td>
			</tr>
			<tr>
				<td class='text-center'><input type='radio'
					name='employee_choose' value='5'></td>
				<td class="text-center">18-11-2013</td>
				<td class="text-center">PRJ123456789</td>
				<td class="text-center">Assignment</td>
				<td class="text-center">Kartiko Edhi</td>
				<td class="text-center">01-04-2014</td>
			</tr>
			<tr>
				<td class='text-center'><input type='radio'
					name='employee_choose' value='6'></td>
				<td class="text-center">18-11-2013</td>
				<td class="text-center">PRJ123456789</td>
				<td class="text-center">Self Assignment</td>
				<td class="text-center">Kartiko Edhi</td>
				<td class="text-center">01-04-2014</td>
			</tr>
			<tr>
				<td class='text-center'><input type='radio'
					name='employee_choose' value='7'></td>
				<td class="text-center">18-11-2013</td>
				<td class="text-center">PRJ123456789</td>
				<td class="text-center">Self Assignment</td>
				<td class="text-center">Kartiko Edhi</td>
				<td class="text-center">01-04-2014</td>
			</tr>
			<tr>
				<td class='text-center'><input type='radio'
					name='employee_choose' value='8'></td>
				<td class="text-center">18-11-2013</td>
				<td class="text-center">PRJ123456789</td>
				<td class="text-center">Self Assignment</td>
				<td class="text-center">Kartiko Edhi</td>
				<td class="text-center">01-04-2014</td>
			</tr>
			<tr>
				<td class='text-center'><input type='radio'
					name='employee_choose' value='9'></td>
				<td class="text-center">18-11-2013</td>
				<td class="text-center">PRJ123456789</td>
				<td class="text-center">Self Assignment</td>
				<td class="text-center">Kartiko Edhi</td>
				<td class="text-center">01-04-2014</td>
			</tr>
			<tr>
				<td class='text-center'><input type='radio'
					name='employee_choose' value='10'></td>
				<td class="text-center">18-11-2013</td>
				<td class="text-center">PRJ123456789</td>
				<td class="text-center">Self Assignment</td>
				<td class="text-center">Kartiko Edhi</td>
				<td class="text-center">01-04-2014</td>
			</tr>
			<tr>
				<td colspan=6 class='text-center'><div class="pagination">
						<ul>
							<li class="first"><a><i class="icon-first-2"></i></a></li>
							<li class="prev"><a><i class="icon-previous"></i></a></li>
							<li><a>1</a></li>
							<li><a>2</a></li>
							<li class="active"><a>3</a></li>
							<li class="spaces"><a>...</a></li>
							<li class="disabled"><a>4</a></li>
							<li><a>500</a></li>
							<li class="next"><a><i class="icon-next"></i></a></li>
							<li class="last"><a><i class="icon-last-2"></i></a></li>
						</ul>
					</div></td>
			</tr>

			<tr>
				<td colspan=6 class='text-right'><button class='button success'>Add</button></td>
			</tr>
		</tbody>
	</table>
</div>
