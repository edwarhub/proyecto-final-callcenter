const { request, response } = require('express')

const Pool = require('pg').Pool
const pool = new Pool({
  user: 'desarrollo',
  host: 'localhost',
  database: 'jcoctelDB-bi',
  password: 'desarrollo123',
  port: 5432,
})


const getLlamadas=(request,response)=>{
  pool.query("SELECT count(*) FROM llamada WHERE idcampana =1", (error, results) => {
    if (error) {
      throw error
    }
    response.status(200).json(results.rows)
  })
}

const getAgentes=(request,response)=>{
  pool.query("SELECT idagente,nombres || ' ' || apellidos as nombre,numdocumento,email FROM agente,persona WHERE agente.idpersona=persona.idpersona", (error, results) => {
    if (error) {
      throw error
    }
    response.status(200).json(results.rows)
  })
}

const getLlamadascampana=(request,response)=>{
  pool.query("SELECT nombre,COUNT(*) FROM llamada as l,campana as c where l.idcampana=c.idcampana GROUP BY c.idcampana",(error,results)=>{
    if (error) {
      throw error
    }
    response.status(200).json(results.rows)
  })
}

const getLlamadasmeses=(request,response)=>{
  pool.query("SELECT nombre,EXTRACT(MONTH FROM fecha_ini) as meses,COUNT(*) FROM llamada as l,campana as c where l.idcampana=c.idcampana GROUP BY c.idcampana,EXTRACT(MONTH FROM fecha_ini)",(error,results)=>{
    if (error) {
      throw error
    }
    response.status(200).json(results.rows)
  })
}

module.exports={
    getLlamadascampana,
    getLlamadasmeses,
    getLlamadas,
    getAgentes,
    getLlamadas
}