const express = require('express');
const router = express.Router();
const Database = require('../Database');
const config = require('../config');

router.post('/', (req, res, next) => {
    var sistema = req.body.idDispositivo;
    idUsuario = req.body.codUsuario;
    idClient = req.body.idClient;

    empresa = req.body.nomeEmpresa;
    representante = reeq.body.representante;
    cnpj = req.body.cnpj;
    email = req.body.email;
    telefone = req.body.telefone;
    senha = req.body.password;
    updateEmpresa(representante, empresa, cnpj, email, telefone, senha, res);
    carregaTabela(sistema, res);
});

router.post('/consultarCliente', (req, res, next) => {

    let querystring = `SELECT Client.idClient, Client.name, Client.compName, email, phone, pswd FROM where idClient = ${idClient};`;
    return new Promise((resolve, reject) => {
        Database.query(querystring).then(results => {

            let existe = results.recordsets[0].length > 0;

            resolve(existe);
            console.log(results);
            res.send(results.recordset);
        }).catch(error => {
            reject(error);
        });
    });
});

function updateEmpresa(idClient, representante, empresa, cnpj, email, pswd, req, res) {

    let querystring = `UPDATE Client SET  name = '${representante}', compName = '${empresa}', cnpj = '${cnpj}', phone = '${telefone}', email = '${email}', pswd = '${pswd}' where idClient = '${idCliente}'`;
    return new Promise((resolve, reject) => {
        Database.query(querystring).then(results => {
            res.sendStatus(201);
        }).catch(error => {
            res.status(500).send(error);
        });
    });

}
//FUNÇÃO PRA CARREGAR OS DADOS NA TBELA
function carregaTabela(selecionado, res) {

    let querystring = `UPDATE FROM Server where idSever = ${selecionado}`;
    return new Promise((resolve, reject) => {
        Database.query(querystring).then(results => {

            res.sendStatus(201);
        }).catch(error => {
            res.status(500).send(error);
        });
    });
}
module.exports = router;
