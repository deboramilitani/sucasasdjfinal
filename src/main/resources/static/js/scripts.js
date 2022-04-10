/*!
* Start Bootstrap - Business Casual v7.0.3 (https://startbootstrap.com/theme/business-casual)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-business-casual/blob/master/LICENSE)
*/
// Highlights current date on contact page
window.addEventListener('DOMContentLoaded', event => {
    const listHoursArray = document.body.querySelectorAll('.list-hours li');
    listHoursArray[new Date().getDay()].classList.add(('today'));
})




function abrirModal(){
		document.getElementById('modal').style.top="0";
		document.getElementById('modal').style.display="block";
}
function fecharModal(){
		document.getElementById('modal').style.top="-100%";
}
