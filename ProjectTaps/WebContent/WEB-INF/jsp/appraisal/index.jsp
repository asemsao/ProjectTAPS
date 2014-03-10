<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<jsp:include page="/js/import.jsp" />

<title>Appraisal</title>
</head>

<body class="metro">
	<jsp:include page="/frame/header.jsp" />

	<div class="container container-taps">
		<div class="grid">
			<div class="row row-taps shadow-taps">

				<table class="table striped bordered hovered">
					<thead>
						<tr>
							<th colspan=4 class="text-center"><h3>Special Appraisal</h3></th>
						</tr>
						<tr>
							<th class="text-center">Appraisal Date</th>
							<th class="text-center">Appraisal To</th>
							<th class="text-center">Appraisal Star</th>
							<th class="text-center">View</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="text-center">01/03/2014</td>
							<td class="text-center">Devri</td>
							<td class="text-center">10</td>
							<td class="text-center"><a href="view.jsp"
								data-hint="View Appraisal" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
						</tr>
						<tr>
							<td class="text-center">01/03/2014</td>
							<td class="text-center">Devri</td>
							<td class="text-center">10</td>
							<td class="text-center"><a href="view.jsp"
								data-hint="View Appraisal" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
						</tr>
						<tr>
							<td class="text-center">01/03/2014</td>
							<td class="text-center">Devri</td>
							<td class="text-center">10</td>
							<td class="text-center"><a href="view.jsp"
								data-hint="View Appraisal" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
						</tr>
						<tr>
							<td class="text-center">01/03/2014</td>
							<td class="text-center">Devri</td>
							<td class="text-center">10</td>
							<td class="text-center"><a href="view.jsp"
								data-hint="View Appraisal" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
						</tr>
						<tr>
							<td class="text-center">01/03/2014</td>
							<td class="text-center">Devri</td>
							<td class="text-center">10</td>
							<td class="text-center"><a href="view.jsp"
								data-hint="View Appraisal" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
						</tr>
						<tr>
							<td class="text-center">01/03/2014</td>
							<td class="text-center">Devri</td>
							<td class="text-center">10</td>
							<td class="text-center"><a href="view.jsp"
								data-hint="View Appraisal" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
						</tr>
						<tr>
							<td class="text-center">01/03/2014</td>
							<td class="text-center">Devri</td>
							<td class="text-center">10</td>
							<td class="text-center"><a href="view.jsp"
								data-hint="View Appraisal" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
						</tr>
						<tr>
							<td class="text-center">01/03/2014</td>
							<td class="text-center">Devri</td>
							<td class="text-center">10</td>
							<td class="text-center"><a href="view.jsp"
								data-hint="View Appraisal" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
						</tr>
						<tr>
							<td class="text-center">01/03/2014</td>
							<td class="text-center">Devri</td>
							<td class="text-center">10</td>
							<td class="text-center"><a href="view.jsp"
								data-hint="View Appraisal" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
						</tr>
						<tr>
							<td class="text-center">01/03/2014</td>
							<td class="text-center">Devri</td>
							<td class="text-center">10</td>
							<td class="text-center"><a href="view.jsp"
								data-hint="View Appraisal" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/EDIT.png"></a></td>
						</tr>
						<tr>
							<td colspan=3 class="text-center">
								<div class="pagination">
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
								</div>
							</td>
							<td class="text-center"><a href="new.jsp"
								data-hint="New Special Appraisal" data-hint-position="bottom"><img
									alt="" src="<%=request.getContextPath()%>/images/ADD_STAR.png"></a></td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>
	</div>
	<jsp:include page="/frame/footer.jsp" />
</body>

</html>