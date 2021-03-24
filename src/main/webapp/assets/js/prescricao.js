const btnAdd = document.querySelector(".add-med button")
const medDes = document.querySelector(".med-des")
const cl = document.querySelector(".clone-content")
btnAdd.addEventListener("click", () =>{
    let clone = medDes.cloneNode(true)
    cl.appendChild(clone)
})




