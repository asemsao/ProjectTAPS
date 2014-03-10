$(document)
		.ready(
				function() {
					$(
							'#select-, #select-bu, #select-tingkat, #select-gol, #select-semester, #select-phase, #select-bu, #select-mh, #select-search, .size-mh, #select-periode, #select-range, #select-head, #select-parent')
							.selectize({
								sortField : {
									field : 'text',
									direction : 'asc'
								}
							});

					$('#select-month').selectize();

					var getName = function(item) {
						return $.trim((item.desc.split("@")[0]));
					};

					var getDesc = function(item) {
						return $.trim((item.desc.split("@")[1]));
					};

					$('#select-to')
							.selectize(
									{
										create : false,
										persist : false,
										maxItems : 1,
										valueField : 'id',
										labelField : 'desc',
										searchField : [ 'id', 'desc' ],
										sortField : [ {
											field : 'text',
											direction : 'asc'
										} ],

										render : {
											item : function(item, escape) {
												var name = getName(item);
												return '<div>'
														+ (name ? '<span class="name">'
																+ escape(name)
																+ '</span>'
																: '')
														+ '</div>';
											},
											option : function(item, escape) {
												var name = getDesc(item);
												var label = getName(item);

												return '<div>'
														+ '<div class="">'
														+ escape(label)
														+ '</div>'
														+ (name ? '<span class="caption">'
																+ escape(name)
																+ '</span>'
																: '')
														+ '</div>';
											}
										}
									});

				});