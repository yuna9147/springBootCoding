function checkData(selector,message){
    const $element = $(selector);

    if($element.val().trim() === ""){
    alert(`${message}입력해 주세요`);
    $element.val("");
    $element.focus();
    return false;
    }
    return true;
}

const actionProcess = (selector, method, action ) =>{
    const $form = $(selector);
    $form.attr({
    "method":method,
    "action":action
    });
    $form.submit();
};

const resetProcess = (selector) =>{
    const $form = $(selector);
    $form[0].reset();
};



function chkData(selector, message) {
    const element = document.querySelector(selector);
    const value = element.value.trim();

    if (value === "" || value === "0") {
        alert(`${message} 입력해 주세요.`);
        element.value = "";
        element.focus();
        return false;
    }
    return true;
}

const formSubmit = (selector, method, action) => {
    const form = document.getElementById(selector);
    form.method = method;
    form.action = action;
    form.submit();
}

const formReset = (selector) => {
    const form = document.getElementById(selector);
    form.reset();
}

const locationProcess = (url) => {
    location.href = url;
}