const Pool = require('pg').Pool
const pool = new Pool({
  user: 'postgres',
  host: 'localhost',
  database: 'callcenter',
  password: '1289',
  port: 5432,
})

const getCalls = (request, response) => {
    pool.query('SELECT c.nombre, count(ll.idllamada) FROM llamada ll,campana c WHERE ll.idcampana=c.idcampana GROUP BY c.nombre', (error, results) => {
      if (error) {
        throw error
      }
      response.status(200).json(results.rows)
    })
  }

module.exports={
    getCalls
}