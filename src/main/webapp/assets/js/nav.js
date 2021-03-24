//Responsive navbar 
const navLinks = document.querySelector(".nav-links");
const hamb = document.querySelector("i.hamb");

hamb.addEventListener("click", () => {
    navLinks.classList.toggle("menu-mobile")
})

