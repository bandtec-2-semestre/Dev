const express = require('express');
const router = express.Router();
const Database = require('../Database');
const config = require('../config');

router.post('/', (req, res, next) => {

    idUsuario = req.body.codUsuario;
    empresa = req.body.nomeEmpresa;
    representante = reeq.body.representante;
    cnpj = req.body.cnpj;
    email = req.body.email;
    // telefone = req.body.phone;
    senha = req.body.password;

    console.log(idUsuario, representante, empresa, cnpj, email, senha);

    updateEmpresa(representante, empresa, cnpj, email, senha, res);
});


function updateEmpresa(idClient, representante, empresa, cnpj, email, pswd, req, res) {

    var cdCliente = { idCliente: sessionStorage.idClient }
    idCliente.value = cdCliente;

    console.log("Chegou pra buscar Empresa");
    let stringSqlClient = `SELECT * FROM Client WHERE idClient = '${cdClient}'`;

    Database.query(stringSqlClient).then(resultado => {
        resultado = resultado.recordsets[0];


        if (req.body.nomeEmpresa != clientResult[0].nomeEmpresa || representante != clientResult[0].representante || cnpj != clientResult[0].cnpj || email != clientResult[0].email || password != clientResult[0].senha) {
            let stringSqlUpdateClient = `UPDATE Client SET compName = '${empresa}', name = '${representante}', cnpj = '${cnpj}',phone = '${telefone}', email = '${email}', pswd = '${pswd}' where idClient = '${idClient}'`;

            Database.query(stringSqlUpdateClient).then(results => {
                console.log("update empresa");
                let resultado = results.recordsets[0];

                resolve(resultado);
                console.log("empresa verificada");

            }).catch(error => {
                res.status(200).send('erro');
            });

        } else {
            console.log("Dados iguais");
            console.log("Usuario Update errado");


        }
    });


}
module.exports = router;
