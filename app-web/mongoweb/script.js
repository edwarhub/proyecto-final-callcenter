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

function getllamadascampana(){
    fetch(url+'/llamadascampana')
    .then(
        response => response.json())  
    .then(
        agentes => showCampanas(agentes)
        )    
    .catch(
        err => console.log('Request Failed', err)); 
}

function getduracionpromedio(){
    fetch(url+'/duracionpromedio')
    .then(
        response => response.json())  
    .then(
        duracion => showDuracion(duracion)
        )    
    .catch(
        err => console.log('Request Failed', err)); 
}

function getllamadasmeses(){
    fetch(url+'/llamadasmeses')
    .then(
        response => response.json())  
    .then(
        agentes => showCampanas(agentes)
        )    
    .catch(
        err => console.log('Request Failed', err)); 
}


showDuracion=(duracion)=>{
    var xlabel=[]
    var values=[]
    duracion.forEach(d=>{
        xlabel.push(d.value.name)
        values.push(d.value.promedio)
    })
    drawChart(xlabel,values,"line")
}



showCampanas=(campanas)=>{
    var xlabel=[]
    var values=[]
    campanas.forEach(campana=>{
        xlabel.push(campana.value.name)
        values.push(campana.value.count)
    })
    drawChart(xlabel,values,"bar");

}



drawChart=(xlabel,values,tipo)=>{
    var temp=document.getElementById("chart");
    var colores=Array(6).fill(['#FFA32F',"#FFEC21","#378AFF","#F54F52","#93F03B"]).flat()
    temp.remove();
    var temp2=document.getElementById("divid");
    var ele=document.createElement('canvas');
    ele.setAttribute("id","chart")
    temp2.append(ele);
    var canvas=document.getElementById('chart');
    var ctx=canvas.getContext('2d');
    if(tipo!='line'){
        var myChart = new Chart(ctx, {
            type: tipo,
            data: {
                labels:xlabel,
                datasets: [{
                    label: 'Llamadas por Campaña',
                    data: values,
                    backgroundColor: colores,
                    borderColor:  colores,
                    borderWidth: 1
                }]
            },
        });
    }else{
        var myChart = new Chart(ctx, {
            type: tipo,
            data: {
                labels:xlabel,
                datasets: [{
                    label: 'Duración promedio de la llamada en minutos',
                    data: values,
                    backgroundColor: colores,
                    borderColor:  colores,
                    borderWidth: 1,
                    pointRadius:5
                }]
            },
            options:{
                showLines:false,
                legend: {
                    labels: {
                      boxWidth: 0,
                    }
                },
            }
        });
    }
    
}

showAgentes=(agentes)=>{
    var padre=document.getElementById("divid");
    agentes.forEach(agente => {
        padre.innerHTML+="Nombre: "+ agente.nombre+" Email: "+agente.email+"<br/>";
        console.log(agente.nombre)
    });
  };


