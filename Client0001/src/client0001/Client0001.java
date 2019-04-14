package client0001;

import br.uefs.ecomp.internetdosbrinquedos.util.Console;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import cliente1.controllers.ControladorCorrida;
import cliente1.controllers.ControladorDeDados;
import cliente1.controllers.ControladorFactory;
import cliente1.model.Carro;
import cliente1.model.Piloto;
import cliente1.model.Equipe;
import java.util.Iterator;

public class Client0001 {

    String opc = "N";

    private int voltarMenu(String opc) {
        this.opc = opc;
        if (opc.equals('S')) {
            return 1;
        } else {
            return -1;
        }
    }

    public String getOpc() {
        return opc;
    }
    
    

    public static void main(String[] args) throws IOException {
        Client0001 client = new Client0001();
        ControladorCorrida cc = new ControladorCorrida();
        ControladorDeDados cdd = new ControladorDeDados();
        ControladorFactory ccf = new ControladorFactory() {
        };

        int opc;
        String op;
        do {

            System.out.println("Menu Internet dos Brinquedos");
            System.out.println("1- Realizar Cadastro de Carros\n"
                    + "2- Realizar Cadastro de Participantes"
                    + "3- Iniciar Partida");
            opc = Console.readInt();

            switch (opc) {

                case 1:
                    do {
                        System.out.println("Infome a tag do carro(ID)!");
                        String tag = Console.readString();

                        System.out.println("Informe a cor do carro!");
                        String cor = Console.readString();

                        System.out.println("Informe a equipe pertencente!");
                        String equipe = Console.readString();
                        
                        Equipe e = cdd.addEquipe(equipe);

                        Carro c = cdd.addCarros(tag, cor, e);
                        
                        System.out.println("Deseja cadastrar novamente? S/N");
                       op = Console.readString();
                       client.voltarMenu(op);

                    } while (client.getOpc().equals(op));
                    break;
                case 2:
                    do {
                        System.out.println("Informe o seu nome:");
                        String nome = Console.readString();

                        Piloto p = cdd.addPiloto(nome,null);
                        System.out.println("Escolha o seu carro!");
                        Iterator iter_Cars = cdd.itCarro();
                        int count = 0;
                        while (iter_Cars.hasNext()) {
                            Carro c = (Carro) iter_Cars.next();
                            System.out.println(count + 1 + " - " + c.getCor());
                            count++;
                        }
                        String corCarro = Console.readString();

                        if (cdd.getCarroPorCor(corCarro) != null) {
                            System.out.println("Funfou!!!");
                        }

                        cc.adicionaParticipantes(p, cdd.getCarroPorCor(corCarro));
                        System.out.println("Deseja cadastrar novamente? S/N");
                        op = Console.readString();
                        break;
                    } while (client.voltarMenu(op) == 1);

            }

        } while (client.getOpc().equals("N"));
    }

    /*System.out.println("Realizar novo cadastro?\n" + "S/N");
            opcao = Console.readString();
            
            //} while (opcao.equals('S'));
     */
 /*
        System.out.println("Bem vindo cliente");
        Socket socket = new Socket("localhost", 5555);
        System.out.println("Cliente conectado");
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Ok");
        Object obj = (Object) controll.cadastrarUsuario("Mateus", null);
        os.writeObject(obj);
        System.out.println("Enviando Informações");

        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        Participante returnMessage = (Participante) is.readObject();
        System.out.println("return Message is=" + returnMessage.getNome());
        socket.close();
     */
}
