
package securit.logs;

import java.io.File;
import java.util.Date;

public class Diretorio {

    public void criarDiretorio() {

        //Váriaveis
        File diretorio;

        Date data;
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        data = new Date();

        //Inicializando a váriavel diretorio criando a instancia  da classe File e passando como paraemtro o local de criação
        diretorio = new File("");

        //Chamando o metodo mkdir que cria diretorios da classe Diretorio
        diretorio.mkdir();

        //Confdição que verifica a existência de um diretorio
        if (!diretorio.exists()) {

            if (!data.equals(diretorio.lastModified())) {
                //Inicializando a váriavel diretorio criando a instancia  da classe File e passando como parametro o Local de criação
                diretorio = new File("C:\\RegistroLog" + data.getMonth());

                //Chamando o metodo mkdir que cria diretorios da classe Diretorio
                diretorio.mkdir();
            }

         
                }
            }
        }
    

