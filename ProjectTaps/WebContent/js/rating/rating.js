$(function() {
	var currentStar = $("#star").val();
	var kiri = 0;
	var tengah = 0;
	var kanan = 0;
	if (currentStar > 0) {
		if (currentStar > 5) {
			currentStar = 5;
		}
		kanan = currentStar + "";
	} else if (currentStar < 0) {
		kiri = currentStar + '';
	} else if (currentStar == 0) {
		tengah = currentStar + "";
	}

	$('#rating-kiri')
			.barrating(
					{
						showSelectedRating : false,
						showValues : false,
						initialRating : kiri + '',
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
						showSelectedRating : false,
						showValues : false,
						initialRating : tengah + '',
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
						showSelectedRating : false,
						showValues : false,
						initialRating : kanan + '',
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
