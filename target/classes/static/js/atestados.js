//Change URL from options
const selectAtestado = document.querySelector(".presets select");
selectAtestado.onchange = changeUrlAtestados
function changeUrlAtestados() {
    let selectAtestadoValue = selectAtestado.value;
    if(selectAtestadoValue == "dias") {
        document.location.href = "atestados-dias.html"
    } else if(selectAtestadoValue == "livre") {
        document.location.href = "atestados-livre.html"
    } else {
        document.location.href = "atestados.html"
    }
}