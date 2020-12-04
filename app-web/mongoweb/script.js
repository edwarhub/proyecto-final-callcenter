const url="http://localhost:3001"


function getagentes(){
    fetch(url+'/agentes')
    .then(
        response => response.json())  
    .then(
        agentes => showAgentes(agentes)
        )    
    .catch(
        err => console.log('Request Failed', err)); 
}

showAgentes=(agentes)=>{

    var padre=document.getElementById("divid");
    agentes.forEach(agente => {
        padre.innerHTML+="Nombre: "+ agente.nombre+" Email: "+agente.email+"<br/>";
        console.log(agente.nombre)
    });
  };


