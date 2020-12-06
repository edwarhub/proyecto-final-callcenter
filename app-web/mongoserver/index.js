const Express = require("express");
const BodyParser = require("body-parser");
const { request } = require("express");
const MongoClient = require("mongodb").MongoClient;
const CONNECTION_URL = "mongodb://192.168.0.4:27017/";
const DATABASE_NAME = "callcenterdb";
const COLECCION = "llamadas2"

var app = Express();
app.use(BodyParser.json());
app.use(BodyParser.urlencoded({ extended: true }));
var database;

app.use((req, res, next) => {
    res.header('Access-Control-Allow-Origin', '*'); // Habilito los CORS para cualquier url
    next();
});

app.get("/agentes", (request, response) => {
    database.collection("agentes").find({}).toArray((error, result) => {
        if (error) {
            return response.status(500).send(error);
        }
        response.send(result);
    });
});

app.get("/" + COLECCION, async(request, response) => {
    /*database.collection(COLECCION).count().toArray((error, result) => {

        if (error) {
            return response.status(500).send(error);
        }
        response.send(result);
    });*/
    //var l=await database.collection(COLECCION).count()
    var l=await database.collection(COLECCION).find({'campana.idcampana':1}).count()
    response.send(l.toString())
});

app.get("/llamadascampana", (request, response) => {
    database.collection(COLECCION).mapReduce(
        /*function(){
            var valores={
                nombre:this.campana.nombre,
                contador:1,		
            };
            emit(this.campana.idcampana,valores);
        },
        function(keys,values){
            var reduced={
                name:values[0].nombre,
                count:0
            }
            for(var i=0;i<values.length;i++){
                reduced.count+=1;
            }
            return reduced;
        },*/

        function () {
            emit({ idcampana: this.campana.idcampana, nombre: this.campana.nombre }, 1);
        },
        function (objCampana, countCalls) {
            return Array.sum(countCalls);
        },
        { out: "llamadascampana" }
    )
    database.collection("llamadascampana").find({}).toArray((error, result) => {
        if (error) {
            return response.status(500).send(error);
        }
        response.send(result);
    });
});

app.get("/duracionpromedio", (request, response) => {
    database.collection(COLECCION).mapReduce(
        function () {
            var valores = {
                nombre: this.campana.nombre,
                segundos: this.duracion_seg,
            };
            emit(this.campana.idcampana, valores);
        },
        function (keys, values) {
            var reduced = {
                name: values[0].nombre,
                promedio: 0
            }
            var total = 0
            for (var i = 0; i < values.length; i++) {
                total += values[i].segundos;
            }
            reduced.promedio = parseFloat((total / values.length) / 60).toFixed(2);
            return reduced;
        },
        { out: "duracionpromedio" }

    )
    database.collection("duracionpromedio").find({}).toArray((error, result) => {
        if (error) {
            return response.status(500).send(error);
        }
        response.send(result);
    });
})

app.get("/llamadasmeses", (request, response) => {
    database.collection(COLECCION).mapReduce(
        function () {
            var mes = this.fecha.substring(5, 7);
            var campana = this.campana.idcampana;
            var valores = {
                nombre: this.campana.nombre,
                contador: 1
            };

            emit({ campana, mes }, valores);
        },
        function (keys, values) {
            var reduced = {
                name: values[0].nombre,
                llamadas: 0
            }
            for (var i = 0; i < values.length; i++) {
                reduced.llamadas += values[i].contador;
            }
            return reduced;
        },
        { out: "llamadasmeses" }
    )
    database.collection("llamadasmeses").find({}).toArray((error, result) => {
        if (error) {
            return response.status(500).send(error);
        }
        response.send(result);
    });
})

app.listen(3001, () => {
    MongoClient.connect(CONNECTION_URL, { useNewUrlParser: true }, (error, client) => {
        if (error) {
            throw error;
        }
        database = client.db(DATABASE_NAME);
        console.log("Connected to `" + DATABASE_NAME + "`!");
    });
});