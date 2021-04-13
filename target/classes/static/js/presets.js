//Change URL from options
const selectPresets = document.querySelector(".select select");
selectPresets.onchange = changeUrlPresets
function changeUrlPresets() {
    let selectPresetsValue = selectPresets.value;
    if(selectPresetsValue == "exames") {
        document.location.href = "presets-exames.html"
    } else {
        document.location.href = "presets.html"
    }
}