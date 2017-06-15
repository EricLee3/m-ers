/* 페이징 */
function pagingContent() {
	  $('table.paginated').each(function() {
	    var currentPage = 0;
	    var numPerPage = 5;
	    var $table = $(this);

	     $table.find('.boardTitle').hide()
	       .slice(currentPage * numPerPage,
	         (currentPage + 1) * numPerPage)
	       .show();

		$table.bind('repaginate', function() {

			$table.find('.boardTitle').hide();		      
	      $(".boardTitle")
	    	.slice(currentPage * numPerPage,
	          (currentPage + 1) * numPerPage)
	        .show();

			$('.pager').remove();
		    var numRows = $(".boardTitle").length;
		    var numPages = Math.ceil(numRows / numPerPage);
		    var $pager = $('<div class="pager"></div>');
		    for (var page = 0; page < numPages; page++) {		    	
		    	if(page > 0){
					  $('<span class="page-number"></span>').text("  |  ").appendTo($pager);
		    	}
					$('<span class="page-number"></span>').text(" " + (page + 1) + " ")
				    .bind('click', {newPage: page}, function(event) {
				          currentPage = event.data['newPage'];
				          $(".rowContent_tr").remove();
					      $table.find('.boardTitle').hide();
					      $(".boardTitle")
					    	.slice(currentPage * numPerPage,
					          (currentPage + 1) * numPerPage)
					        .show();
				          $(this).addClass('active').siblings().removeClass('active');   
				        }).appendTo($pager).addClass('clickable');

		    }
		    $pager.insertAfter($table).find('span.page-number:first').addClass('active');
		    $('<p style="height:30px;"></p>').insertAfter($table);
	    });
		   $table.trigger('repaginate');
	  });
}	

/* 페이징2 */
function pagingContent2() {
  $('#content_table2').each(function() {
    var currentPage = 0;
    var numPerPage = 3;
    var $table = $('#content_table2');

     $table.find('tbody tr').hide()
       .slice(currentPage * numPerPage, (currentPage + 1) * numPerPage)
       .show();

 $table.bind('repaginate2', function() {

  $table.find('tbody tr').hide()
     .slice(currentPage * numPerPage, (currentPage + 1) * numPerPage)
        .show();
  $('.pager2').remove();
     var numPages = Math.ceil(numRows / numPerPage);
     var $pager2 = $('<div class="pager2"></div>');
     for (var page = 0; page < numPages; page++) {       
      if(page > 0){
      $('<span class="page-number2"></span>').text(" | ").appendTo($pager2);
      }
    $('<span class="page-number2"></span>').text(" " + (page + 1) + " ")
       .bind('click', {newPage: page}, function(event) {
             currentPage = event.data['newPage'];
             $(".rowContent_tr").remove();
          $table.find('tbody tr').hide()
         .slice(currentPage * numPerPage,
              (currentPage + 1) * numPerPage)
            .show();
             $(this).addClass('active').siblings().removeClass('active');   
           }).appendTo($pager2).addClass('clickable');

     }
     $pager2.insertAfter($table).find('span.page-number2:first').addClass('active');
     $('<p style="height:30px;"></p>').insertAfter($table);
    });
    $table.trigger('repaginate2');
  });
}
