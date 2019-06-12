$(function() {
        
  $('.list-group-item').on('click', function() {
    $('.fa', this)
      .toggleClass('fa fa-angle-right')
      .toggleClass('fa fa-angle-down');
  });

});