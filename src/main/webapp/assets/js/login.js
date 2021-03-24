const inputs = document.querySelectorAll(".input-login");
const btnLogin = document.querySelectorAll(".btn-login");

btnLogin[0].onclick = validateInput;

function validateInput() {
    if(inputs[0].value == "" && inputs[1].value == "") {
        alert("Preencha os campos corretamente")
    } else if (inputs[0].value == "" || inputs[1].value == "") {
        alert("Preencha o campo vazio")
    }
}
