const express = require('express')
const bodyParser = require('body-parser')
const app = express()
const db = require('./queries')
const port = 3000

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

app.get('/llamadascampana', db.getCalls)

  app.listen(port, () => {
    console.log(`App running on port ${port}.`)
  })

