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

    console.log(dispositivo, tipoDispositivo, modeloDispositivo, andarDispositivo);

    cadastrarDevice(dispositivo, andarDispositivo, modeloDispositivo, res);
});

function cadastrarDevice(name, description, model, res) {
    console.log("Função cadstrar DDevice");
    verificarIdDevice(name)
        .then(resultado => {

            let criar = !resultado;
            console.log(`criar: ${criar}`);

            if (criar) {
                var stringSql = `insert into Device (name, description, model) values ('${name}', '${description}', '${model}')`;


                Database.query(stringSql).then(resultado => {
                    res.status(200).send("ok");
                    console.log("Dispositivo Cadastrado!");
                });
            } else {
                res.status(200).send("Não Ok")
            }
        })
}

function adicionarTipo(nome) {
    let querystring = `Insert into DeviceType where name = ''${name} `;
    return new Promisse((resolve, reject) => {
        Database.query(querystring).then(results => {
            let existe = results.recordsets[0].length > 0;
            resolve(existe);
            console.log("Dispositivo cadastrado!");

        }).catch(error => {
            reject(error);
        });
    });
}


function adicionarServidor() {

}

//Função que verifica se o e-mail já esta cadastrado no Banco de Dados
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

//Função que verifica se o dispositivo já está cadastrado
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
