window.addEventListener('load', () => {
    const loginForm = window.document.getElementById("login-form");
    setTimeout(() =>{
        loginForm.classList.add('visible');
        loginForm['email'].focus();
    },500);
});