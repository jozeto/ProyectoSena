// Este código espera a que el documento HTML se cargue completamente antes de mostrar el mensaje.
document.addEventListener("DOMContentLoaded", function() {
    // Selecciona el elemento del mensaje y agrega la clase "show" para animarlo.
    const mensaje = document.querySelector(".container");
    mensaje.classList.add("show");
});
