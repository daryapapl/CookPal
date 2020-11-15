
$(document).ready(function(){

  //make input area visible when rename category button is clicked
  $('.renameCategoryButton').click(function(e){
    e.stopPropagation();
    $('.inputRenameCategory').addClass('visibleInputRenameCategory');
    $('.categoryDetails').addClass('shiftCategoryDetails');
  });

  // submit rename category form when Enter is pressed
  $('.inputRenameCategory').keypress(function(e) {
    if (e.which == 13) {
      e.preventDefault();
      $('.renameCategoryForm').submit();
    }
  });

  //make input area visible when add new category button is clicked
  $('.addNewCategoryButton').click(function(e){
    e.stopPropagation();
    $('.inputAddNewCategory').addClass('visibleInputAddNewCategory');
  });

  // submit add new category form when Enter is pressed
  $('.inputAddNewCategory').keypress(function(e) {
    if (e.which == 13) {
      e.preventDefault();
      $('.addNewCategoryForm').submit();
    }
  });


});
