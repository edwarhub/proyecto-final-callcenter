const Express = require("express");
const BodyParser = require("body-parser");
const MongoClient = require("mongodb").MongoClient;
const CONNECTION_URL = "mongodb://192.168.0.4:27017/";
const DATABASE_NAME = "callcenterdb";


var app = Express();
app.use(BodyParser.json());
app.use(BodyParser.urlencoded({ extended: true }));
var database;

app.use((req, res, next) => {
    res.header('Access-Control-Allow-Origin', '*'); // Habilito los CORS para cualquier url
    next();
  });

app.get("/agentes", (request, response) => {
    database.collection("agentes2").find({}).toArray((error, result) => {
        if(error) {
            return response.status(500).send(error);
        }
        response.send(result);
    });
});

app.get("/llamadas", (request, response) => {
    database.collection("llamadas2").find({}).limit(5).toArray((error, result) => {
        if(error) {
            return response.status(500).send(error);
        }
        response.send(result);
    });
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