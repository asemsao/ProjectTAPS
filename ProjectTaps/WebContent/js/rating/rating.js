$(function() {
	$('#rating-kiri')
			.barrating(
					{
						showSelectedRating : true,
						showValues : false,
						initialRating : '0',
						reverse : true,
						onSelect : function(value, text) {
							$('div.star-hider p').empty();
							$('div.star-hider p').append("&nbsp;");
							for ( var int = 0; int < Math.abs(value); int++) {
								$('div.star-hider p')
										.append(
												"<img src='images/star/star_meyah_kecil_catu.png'/>");
							}
							$('#star').val(value);
							$('div.rating-kiri').hide();
							$('div.rating-tengah').hide();
							$('div.rating-kanan').hide();
							$('#edit-star-btn').show();
						}
					});

	$('#rating-tengah')
			.barrating(
					{
						showSelectedRating : true,
						showValues : false,
						initialRating : '0',
						onSelect : function(value, text) {
							$('div.star-hider p').empty();
							$('div.star-hider p').append("&nbsp;");
							$('div.star-hider p')
									.append(
											"<img src='images/star/star_tengah_kecil_catu.png'/>");
							$('#star').val(value);
							$('div.rating-kiri').hide();
							$('div.rating-tengah').hide();
							$('div.rating-kanan').hide();
							$('#edit-star-btn').show();
						}
					});

	$('#rating-kanan')
			.barrating(
					{
						showSelectedRating : true,
						showValues : false,
						initialRating : '0',
						onSelect : function(value, text) {
							$('div.star-hider p').empty();
							$('div.star-hider p').append("&nbsp;");
							for ( var int = 0; int < Math.abs(value); int++) {
								$('div.star-hider p')
										.append(
												"<img src='images/star/star_ijo_kecil_catu.png'/>");
							}
							$('#star').val(value);
							$('div.rating-kiri').hide();
							$('div.rating-tengah').hide();
							$('div.rating-kanan').hide();
							$('#edit-star-btn').show();
						}
					});

	$('#edit-star-btn').click(function() {
		$('div.star-hider p').empty();
		$('div.rating-kiri').show();
		$('div.rating-tengah').show();
		$('div.rating-kanan').show();
		$(this).hide();
	});

});
