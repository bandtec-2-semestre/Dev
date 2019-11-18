const express = require('express');
const router = express.Router();
const Database = require('../Database');
const config = require('../config');

router.post('/', (req, res, next) => {
    var idCliente = req.body.idCliente;

    carregaComboSistema(res, idCliente);
});

//Função que faz a busca do sistema no Banco
function carregaComboSistema(res, clientID) {
    let querystring = `Select * from Server where FK_client  = ${clientID}`;
    return new Promise((resolve, reject) => {
        Database.query(querystring).then(results => {

            let existe = results.recordsets[0].length > 0;

            resolve(existe);
            console.log(results);
            res.send(results.recordset);
        }).catch(error => {
            console.log(error);
        });
    });
}

router.post('/consultaTotalDispositivos', (req, res, next) => {
    var idCliente = req.body.idCliente;

    sistemaDispositivos(res, idCliente);
});

function sistemaDispositivos(res, clientID) {
    let querystring = `SELECT s.idServer, count(idDevice) as totalDevices FROM Server as s inner join Device ON fk_server = s.idServer WHERE s.FK_client = ${clientID} group by s.idServer`;
    return new Promise((resolve, reject) => {
        Database.query(querystring).then(results => {

            let existe = results.recordsets[0].length > 0;

            resolve(existe);
            console.log(results);
            res.send(results.recordset);
        }).catch(error => {
            console.log(error);
        });
    });
}

module.exports = router;
