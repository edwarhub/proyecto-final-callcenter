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
    console.log(Array(5).fill([1,2,3]).flat())
    var xlabel=[]
    var values=[]
    llamadas.forEach(llamada=>{
        xlabel.push(llamada.nombre)
        values.push(llamada.count)
    })
    drawChart(xlabel,values);
    
  };

  drawChart=(xlabel,values)=>{
    var colores=Array(6).fill(['#FFA32F',"#FFEC21","#378AFF","#F54F52","#93F03B"]).flat()
    var temp=document.getElementById("chart");
    
    temp.remove();
    var temp2=document.getElementById("divid");
    var ele=document.createElement('canvas');
    ele.setAttribute("id","chart")
    temp2.append(ele);
    //var tipo=document.getElementById('graficos').value;
    var tipo="bar";
    var canvas=document.getElementById('chart');
    var ctx=canvas.getContext('2d');
    var myChart = new Chart(ctx, {
        type: tipo,
        data: {
            labels:xlabel,
            datasets: [{
                label: 'Llamadas',
                data: values,
                backgroundColor: colores,
                borderColor:  colores,
                borderWidth: 1
            }]
        },
    });

  }
