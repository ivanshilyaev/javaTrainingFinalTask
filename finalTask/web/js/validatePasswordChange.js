function validateChangePassword(form) {
    if (form["new_password"].value !== form["new_password_again"].value) {
        errorMessage(form["new_password"],
            "Значения в полях<BR>«Новый пароль»<BR>и<BR>«Новый пароль ещё раз»<BR>не совпадают!");
        return false;
    }
    return true;
}