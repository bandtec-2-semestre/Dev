function logoff() {
    sessionStorage.removeItem('idClient');
    sessionStorage.removeItem('name');


    window.location.href = 'login.html';
}

function verificarAutenticacao() {
    var nome = sessionStorage.name;
    var id = sessionStorage.idClient;

    if (nome == undefined && id == undefined) {
        location.href = 'login.html';
    }
}