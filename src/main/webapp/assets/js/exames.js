const c80 = document.querySelector(".column-80-content")
const btnAdd = document.querySelector(".add-med button")
const exame = document.querySelector("#exame")
const cls = document.querySelector(".clone-content .select")
btnAdd.addEventListener("click", () =>{
    let clone = exame.cloneNode(true)
    cls.appendChild(clone)
})




