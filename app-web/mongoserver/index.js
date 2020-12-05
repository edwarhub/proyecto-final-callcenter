const Express = require("express");
const BodyParser = require("body-parser");
const { request } = require("express");
const MongoClient = require("mongodb").MongoClient;
const CONNECTION_URL = "mongodb://localhost:27017/";
const DATABASE_NAME = "callmongo";


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
        if(error) {
            return response.status(500).send(error);
        }
        response.send(result);
    });
});

app.get("/llamadas", (request, response) => {
    database.collection("llamadas").find({}).limit(5).toArray((error, result) => {
        if(error) {
            return response.status(500).send(error);
        }
        response.send(result);
    });
});

app.get("/llamadascampana",(request,response)=>{
    database.collection("llamadas").mapReduce(
        function(){
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
        },
        { out: { inline: 1 } },
        function (err, result) {
            response.send(result);
        }
    )
});

app.listen(3001, () => {
    MongoClient.connect(CONNECTION_URL, { useNewUrlParser: true }, (error, client) => {
        if(error) {
            throw error;
        }
        database = client.db(DATABASE_NAME);
        console.log("Connected to `" + DATABASE_NAME + "`!");
    });
});