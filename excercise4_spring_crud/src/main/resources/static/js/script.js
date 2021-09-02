function checkForm(form) {
    if(!form.agree.checked) {
        alert("Please indicate that you agree to take vaccine");
        form.agree.focus();
        return false;
    }
    return true;
}