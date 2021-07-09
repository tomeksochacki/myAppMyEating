function validate() {
    var login = document.getElementById("login-field");
    var password = document.getElementById("password-field");

    var flag = true;

    if(login.value.length < 3) {
        login.style.background = "#e62249";
        flag = false;
    } else {
        login.style.background = "#ffffff";
    }

    if(password.value.length <3) {
        password.style.background = "#e62249";
        flag = false;
    } else {
        password.style.background = "#ffffff";
    }

    return flag;
}