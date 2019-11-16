const express = require('express');
const router = express.Router();
const Database = require('../Database');
const config = require('../config');

router.post('/', (req, res, next) => {

    //Pegando os valores dos inputs do formulário de cadastro
    var dispositivo = req.body.nomeDispositivo;
    var tipoDispositivo = req.body.tipoDispositivo
    var modeloDispositivo = req.body.modeloDispositivo;
    var andarDispositivo = req.body.localDispositivo + " " + req.body.salaDispositivo;
    var nomeSistema = req.body.nomeSistema;

console.log(nomeSistema);
    console.log(dispositivo, tipoDispositivo, modeloDispositivo, andarDispositivo);
    cadastrarDevice(dispositivo, andarDispositivo, modeloDispositivo, nomeSistema, res);
});

function cadastrarDevice(name, description, model, nomeSistema, res) {
    console.log("Função cadstrar DDevice");
    verificarIdDevice(name)
        .then(resultado => {
            let criar = !resultado;
            console.log(`criar: ${criar}`);
            adicionarServidor(nomeSistema);
            var idSistema = buscarIdSistema();
            if (criar) {
                var stringSql = `insert into Device (name, description, model, idServer) values ('${name}', '${description}', '${model}', '${idServer}')`;
                Database.query(stringSql).then(resultado => {
                    res.status(200).send("ok");
                    console.log("Dispositivo Cadastrado!");
                });
            } else {
                res.status(200).send("Não Ok")
            }
        }).catch(error => {
            console.log(error);
        });
}

function adicionarTipo(name) {
    let querystring = `Insert into DeviceType (name) values ('${name}') `;
    return new Promise((resolve, reject) => {
        Database.query(querystring).then(results => {
            let existe = results.recordsets[0].length > 0;
            resolve(existe);
            console.log("Dispositivo cadastrado!");

        }).catch(error => {
            reject(error);
        });
    });
}
function buscarIdSistema() {
    let querystring = `SELECT  Server.idServer FROM SERVER ORDER BY idServer DESC limit 1`;
    return new Promise((resolve, reject) => {
        Database.query(querystring).then(results => {
            let existe = results.recordsets[0].ultimo;
            resolve(existe);
            console.log('a' + existe);
        });
    });

}
function adicionarServidor(name) {
    console.log("Sistema indo!");

    let querystring = `Insert into Server (idServer , name, FK_client) values (null, '${name}', 1)`;
    return new Promise((resolve, reject) => {
        Database.query(querystring).then(results => {
            let existe = results.recordsets[0].length > 0;
            resolve(existe);
            console.log("Sistema cadastrado!");

        }).catch(error => {
            reject(error);
        });
    });
}

//FUNÇÃO QUE VERIFICA SE O DISPOSITIVO JÁ ESTÁ CADASTRADO NO SISTEMA
function verificarIdDevice(name) {
    console.log("Chegou no verificar Device");
    let querystring = `Select * from Device where name = '${name}'`;
    return new Promise((resolve, reject) => {
        Database.query(querystring).then(results => {

            let existe = results.recordsets[0].length > 0;

            resolve(existe);
            console.log("Informações verificadas!");
        }).catch(error => {
            reject(error);
        });
    });
}

module.exports = router;
