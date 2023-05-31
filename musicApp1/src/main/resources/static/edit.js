const editPopup = document.getElementsByClassName('content_container');
const editMenu = document.getElementsByClassName('content_container2');
const editBtn = document.getElementsByClassName('edit_btn');
const moveCover = document.querySelector('.content_container3');
// const addContent = document.getElementsByClassName('cover');

const index = editPopup.length;

console.log(index);
console.log(editPopup[0]);

for (let i = 0; i < editPopup.length; i++) {
    editPopup[i].addEventListener('click', ()=> {
        console.log('click');
        editPopup[i].classList.add('not_active');
        editMenu[i].classList.add('active');
    });
    
    // if (i === index - 1) {
    //     editPopup[i].insertAdjacentHTML('afterend', addCode);
    //     console.log('add');
    // }
};

const addContent = document.querySelector('.add_box');
console.log(addContent);
addContent.addEventListener('click', ()=> {
    console.log('click add');
    moveCover.classList.toggle('active');
});



for (let i = 0; i < editBtn.length; i++) {
    editBtn[i].addEventListener('click', ()=> {
        console.log('click more');
        editPopup[i].classList.remove('not_active');
        editMenu[i].classList.remove('active');
    });
};