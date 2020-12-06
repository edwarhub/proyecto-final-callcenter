const express = require('express')
const bodyParser = require('body-parser')
const app = express()
const db = require('./queries')
const PORT = process.env.PORT || 3000

app.use(bodyParser.json())
app.use(
  bodyParser.urlencoded({
    extended: true,
  })
)

app.use((req, res, next) => {
  res.header('Access-Control-Allow-Origin', '*'); // Habilito los CORS para cualquier url
  next();
});

app.get('/', (request, response) => {
    response.json({ info: 'Node.js, Express, and Postgres API' })
  })

app.get('/agentes', db.getAgentes)  
app.get('/llamadascampana', db.getLlamadascampana)
app.get('/llamadasmeses', db.getLlamadasmeses)
app.get('/llamadas', db.getLlamadasmeses)
app.get('/llamadascount', db.getLlamadas)

  app.listen(PORT, () => {
    console.log(`App running on port ${PORT}.`)
  })

