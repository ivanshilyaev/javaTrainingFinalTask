function errorMessage(element, message) {
    show(message, function () {
        element.focus()
    });
}