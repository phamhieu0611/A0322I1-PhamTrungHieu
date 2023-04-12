// validation form login
const inputUsername = document.querySelector(".input-login-username");
const inputPassword = document.querySelector(".input-login-password");
const btnLogin = document.querySelector(".login__signInButton");

// validation form login
btnLogin.addEventListener("click", (e) => {
    e.preventDefault();
    if (inputUsername.value === "" || inputPassword.value === "") {
        alert("vui lòng không để trống");
    }if (inputUsername.value === "admin" && inputPassword.value === "admin123") {
        alert("Đăng Nhập quyền Admin Thành Công");
        window.location.href = "admin.html";
    } else {
        const user = JSON.parse(localStorage.getItem(inputUsername.value));
        if (user.username === inputUsername.value &&
            user.password === inputPassword.value) {
            alert("Đăng Nhập Thành Công");
            window.location.href = "index.html";
        } else {
            alert("Đăng Nhập Thất Bại");
        }
    }
});

//remember me
function setcookie() {
    var userName = inputUsername.value;
    var password = inputPassword.value;

    document.cookie = "myusername="+userName+";path://localhost/63342/";
    document.cookie = "mypassword="+password+";path://localhost/63342/";
}

function getcookiedata() {
    var username = getcookie('myusername');
    var password = getcookie('mypassword');
    inputUsername.value = username;
    inputPassword.value = password;
    console.log(document.cookie);
}

function getcookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++){
        var c = ca[i];
        while(c.charAt(0) == ' ') {
            c = c.substring(1);
        } if (c.indexOf(name == 0)) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function google() {
    let google = "http://accounts.google.com/o/oauth2/v2/auth";
    let form = document.createElement('form');
    form.setAttribute('method', 'GET');
    form.setAttribute('action', google);

    let params = {
        "client_id":"",
        "redirect_uri":"",
        "response_type":"token",
        "score":"http://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/youtube.readonly",
        "include_granted_scopes":"true",
        'state':'pass-through-value'
    }
}
