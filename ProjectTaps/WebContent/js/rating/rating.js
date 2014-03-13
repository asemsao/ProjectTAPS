$(function() {
	$('#example-a').barrating();

	$('#example-b').barrating('show', {
		readonly : true
	});

	$('#example-c, #example-d').barrating('show', {
		showValues : true,
		showSelectedRating : false
	});

	$('#example-e').barrating('show', {
		initialRating : 'A',
		showValues : true,
		showSelectedRating : false,
		onSelect : function(value, text) {
			alert('Selected rating: ' + value);
		}
	});

	$('#example-f').barrating({
		showSelectedRating : false
	});

	$('#example-g').barrating('show', {
		showSelectedRating : true,
		reverse : true
	});
	
	$('#rating-kiri').barrating({
		showSelectedRating : true,
		showValues: false,
		initialRating : '0',
		reverse : true,
		onSelect : function(value, text) {
			$('div.star-hider p').empty();
			$('div.star-hider p').append("<p>&nbsp;Your current value : " + value + "</p>");
			$('div.rating-kiri').hide();
			$('div.rating-tengah').hide();
			$('div.rating-kanan').hide();
			$('#edit-star-btn').show();
		}
	});
	
	$('#rating-tengah').barrating({
		showSelectedRating : true,
		showValues: false,
		initialRating : '0',
		onSelect : function(value, text) {
			$('div.star-hider p').empty();
			$('div.star-hider p').append("<p>&nbsp;Your current value : " + value + "</p>");
			$('div.rating-kiri').hide();
			$('div.rating-tengah').hide();
			$('div.rating-kanan').hide();
			$('#edit-star-btn').show();
		}
	});
	
	$('#rating-kanan').barrating({
		showSelectedRating : true,
		showValues: false,
		initialRating : '0',
		onSelect : function(value, text) {
			$('div.star-hider p').empty();
			$('div.star-hider p').append("<p>&nbsp;Your current value : " + value + "</p>");
			$('div.rating-kiri').hide();
			$('div.rating-tengah').hide();
			$('div.rating-kanan').hide();
			$('#edit-star-btn').show();
		}
	});
	
	$('#edit-star-btn').click(function() {
		$('div.rating-kiri').show();
		$('div.rating-tengah').show();
		$('div.rating-kanan').show();
		$(this).hide();
	});
	
});
