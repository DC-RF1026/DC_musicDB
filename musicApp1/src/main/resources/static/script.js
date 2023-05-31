const wrapper = document.querySelector('.wrapper');
const loginLink = document.querySelector('.login_link');
const registerLink = document.querySelector('.register_link');
// console.log("hello");
const btnPopup = document.querySelector('.btnLogin_popup');
const iconClose = document.querySelector('.icon_close');

registerLink.addEventListener('click', ()=> {
    wrapper.classList.add('active');
    // console.log('active');
});

loginLink.addEventListener('click', ()=> {
    wrapper.classList.remove('active');
    // console.log('active');
});

btnPopup.addEventListener('click', ()=> {
    wrapper.classList.add('active_popup');
    // console.log('active');
});

iconClose.addEventListener('click', ()=> {
    wrapper.classList.remove('active_popup');
    // console.log('active');
});