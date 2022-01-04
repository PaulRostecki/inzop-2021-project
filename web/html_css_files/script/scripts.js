function navbar(ref){
    nav = document.getElementById('nav-grabber');
    $('.navbar-collapse').toggleClass('show');
    $(nav).toggleClass('nav-bgc');
    $('.navbar-toggler-icon').toggleClass('aft');
    $('.navbar-toggler-icon').toggleClass('bfr');
    $('.navbar-toggler-icon').toggleClass('none');
}

function toggleSidebar(ref){
    $('.menu').toggleClass('active');
    $('.container').toggleClass('container-move');
    $('.container').toggleClass('body-disappear');
    $('.navbar-toggler-icon').toggleClass('aft');
    $('.navbar-toggler-icon').toggleClass('bfr');
    $('.navbar-toggler-icon').toggleClass('none');
  }