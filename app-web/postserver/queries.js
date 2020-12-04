const Pool = require('pg').Pool
const pool = new Pool({
  user: 'fjmnzmtxkilgdp',
  host: 'ec2-3-220-222-72.compute-1.amazonaws.com',
  database: 'df6j9nho0c0u9i',
  password: 'dbb4eb5de049f503e3f31914ff0a4b48a3abf9725b9225114530c57dd4ff88d6',
  port: 5432,
})

const getCalls = (request, response) => {
    pool.query('SELECT c.nombre, count(ll.idllamada) FROM llamada ll,campana c WHERE ll.idcampana=c.idcampana GROUP BY c.nombre ORDER BY c.count DESC LIMIT 5', (error, results) => {
      if (error) {
        throw error
      }
      response.status(200).json(results.rows)
    })
  }

module.exports={
    getCalls
}