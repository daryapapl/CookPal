// Script used for sidebar
$(document).ready(function(){

  $('.renameCategoryButton').click(function(e){
    e.stopPropagation();
    $('.inputRenameCategory').addClass('visibleInputRenameCategory');
    $('.categoryDetails').addClass('shiftCategoryDetails');
  });


  $('.inputRenameCategory').keypress(function(e) {
    if (e.which == 13) {
      e.preventDefault();
      $('.renameCategoryForm').submit();
    }
  });


  $('.addNewCategoryButton').click(function(e){
    e.stopPropagation();
    $('.inputAddNewCategory').addClass('visibleInputAddNewCategory');
  });


  $('.inputAddNewCategory').keypress(function(e) {
    if (e.which == 13) {
      e.preventDefault();
      $('.addNewCategoryForm').submit();
    }
  });


});
