//Change URL from options
const select = document.getElementById("professional-select");
select.onchange = changeUrl
function changeUrl() {
    let selectValue = select.value;
    if(selectValue == "paciente") {
        document.location.href = "cadastro-paciente.html"
    } else if(selectValue == "comercio") {
        document.location.href = "cadastro-comercio.html"
    } else {
        document.location.href = "cadastro-profissional.html"
    }
}


//Validate btn
const btnSubmit = document.querySelector(".btn");
const checkbox = document.querySelector("#check")

checkbox.addEventListener("click", validateBtn)
function validateBtn() {
    let checked = checkbox.checked;
    if(checked) {
        btnSubmit.disabled = false
    } else {
        btnSubmit.disabled = true
    }
}

const cepBox = document.querySelector("#cep");
const ufBox = document.querySelector("#uf")
const cidadeBox = document.querySelector("#cidade")
const bairroBox = document.querySelector("#bairro")
const enderecoBox = document.querySelector("#endereco")

document.body.onclick = IsEmpty
function IsEmpty() {
    if (cepBox.value === "") {
        ufBox.value = ""
        cidadeBox.value = ""
        bairroBox.value = "" 
        enderecoBox.value = ""
    }
  }




