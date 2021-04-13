const btnAdd = document.querySelector(".add-med button")
const medDes = document.querySelector(".med-des")
const cl = document.querySelector(".clone-content")
const selectInput = cl.querySelector(".select")
const btnRemove = document.querySelector(".btn-remove")
const text = document.querySelector("textarea")

btnAdd.addEventListener("click", () =>{
    let clone = medDes.cloneNode(true)
    const cloneSelectInput = clone.querySelectorAll(".select input")
    const cloneText = clone.querySelector("textarea")
    cloneSelectInput[0].value = ""
    cloneSelectInput[1].value = ""
    cloneSelectInput[2].value = ""
    cloneText.value = ""  
    cl.appendChild(clone)

    const btnRemoveClone = clone.querySelectorAll(".remove-container .btn-remove")
    btnRemoveClone.forEach(function(btn){
        btn.onclick = function(){
            clone.style.display = "none"
        }
    })
})

text.onkeyup = () =>{
    if(event.keyCode === 13) {
        let clone = medDes.cloneNode(true)
        const cloneSelectInput = clone.querySelectorAll(".select input")
        const cloneText = clone.querySelector("textarea")
        cloneSelectInput[0].value = ""
        cloneSelectInput[1].value = ""
        cloneSelectInput[2].value = "" 
        cloneText.value = ""
        cl.appendChild(clone)
    
        
        const btnRemoveClone = clone.querySelectorAll(".remove-container .btn-remove")
        btnRemoveClone.forEach(function(btn){
            btn.onclick = function(){
                clone.style.display = "none"
            }
        })
    }
 
}









