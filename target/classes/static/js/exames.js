(function(){
const c80 = document.querySelector(".column-80-content")
const btnAdd = document.querySelector(".add-med button")
const exame = document.querySelector("#exame")
const exameInput = document.querySelector("#exame input")
const btnRemove = document.querySelector(".btn-remove")
const cloneContent = document.querySelector(".clone-content")

btnAdd.addEventListener("click", () =>{
    const cls = document.createElement("div")
    cls.className = "select"
    cloneContent.appendChild(cls)

    let cloneExame = exame.cloneNode(true)
    cls.appendChild(cloneExame)

    const clsBtn  = cls.querySelectorAll(".btn-remove")
    clsBtn.forEach(function(btn){
        btn.onclick = function() {
            cloneExame.remove()
        }
    })


    if(exameInput.value !== "") {
        clsInput[0].value = ""
    }
})

btnRemove.addEventListener("click", () =>{
    exameInput.value = ""
})


})()