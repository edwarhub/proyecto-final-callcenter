const url="http://localhost:3000"


function getllamadas(){
    fetch(url+'/llamadascampana')
    .then(
        response => response.json())  
    .then(
        llamadas => showLlamadas(llamadas)
        )    
    .catch(
        err => console.log('Request Failed', err)); 
}

showLlamadas=(llamadas)=>{
    const llamadasdiv = document.getElementById("llamadasid")
    llamadas.forEach(llamada => {
    const llamadasele = document.createElement("p");
    llamadasele.innerText = `Campaña: ${llamada.nombre} Cantidad: ${llamada.count}`;
    llamadasdiv.append(llamadasele);
  });
}