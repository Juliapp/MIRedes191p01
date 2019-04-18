package clientCad;

import clientCad.util.Console;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import clienteCad.controllers.ControladorCorrida;
import clienteCad.controllers.ControladorDeDados;
import clienteCad.controllers.ControladorFactory;
import clienteCad.model.Carro;
import clienteCad.model.Piloto;
import clienteCad.model.Equipe;
import java.util.Iterator;
import clienteCad.CadastroFacade.CadFacade;
import clienteCad.model.Command;
import clienteCad.model.Mensagem;
import clienteCad.model.Participante;

public class Client0001 {

    String opc = "N";
    ControladorCorrida cc;
    CadFacade cf;
    ControladorDeDados cdd;

    private Client0001() {
        this.cc = new ControladorCorrida();
        this.cf = new CadFacade();
        this.cdd = cf.getController();
    }

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

    public int menuPrincipal() throws IOException {
        int opc;
        System.out.println("Menu Internet dos Brinquedos");
        System.out.println("1- Realizar Cadastro de Carros\n"
                + "2- Realizar Cadastro de Participantes"
                + "3- Iniciar Partida");
        opc = Console.readInt();
        return opc;
    }

    public int cadastroCarros() throws IOException {
        String op;
        System.out.println("Infome a tag do carro(ID)!");
        String tag = Console.readString();

        System.out.println("Informe a cor do carro!");
        String cor = Console.readString();

        System.out.println("Informe a equipe pertencente!");
        String equipe = Console.readString();

        Equipe e = this.cf.cadastrarEquipe(equipe);

        Carro c = this.cf.cadastrarCarro(tag, cor, e);

        boolean existe = cf.getCarros().contains(c);
        if (existe == true) {
            System.out.println("Cadastrado");
        }

        System.out.println("Deseja cadastrar novamente? S/N");
        op = Console.readString();
        if (op.equals("S")) {
            return 1;
        } else {
            return 0;
        }

    }

    public void iteraArrayCarros() {
        Carro c;
        int count = 1;
        Iterator<Carro> iterCars = cf.getCarros().iterator();
        while (iterCars.hasNext()) {
            c = iterCars.next();
            System.out.println(count + c.getCor());
            count++;
        }
    }

    public int cadastroParticipantes() throws IOException {
        String op;
        System.out.println("Informe o seu nome:");
        String nome = Console.readString();

        Piloto p = cf.cadastrarPiloto(nome, null);
        System.out.println("Escolha o seu carro inserindo a cor!");
        iteraArrayCarros();

        String corCarro = Console.readString();

        cc.adicionaParticipantes(p, cdd.getCarroPorCor(corCarro));
        System.out.println("Deseja cadastrar novamente? S/N");
        op = Console.readString();
        if (op.equals("S")) {
            return 1;
        } else {
            return 0;
        }

    }

    public void enviarCadParticipantes(Socket socket) throws IOException {

        Object obj = (Object) cc.getParticipantes();
        Mensagem msg = new Mensagem(Command.CadParticipante, obj);

        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        os.writeObject(msg);
        os.flush();
        
        os.close();
        socket.close();

    }
    
    public void percorreParticipantes(){ //Esse método vai ser introduzido no outro cliente!!!
        Iterator<Participante> iter_Part = cc.getParticipantes().iterator();
        while(iter_Part.hasNext()){
            Participante part = (Participante) iter_Part.next();
            Carro c = part.getCarro();
            Piloto p = part.getPiloto();
            Equipe e = p.getEquipe();
            System.out.println("------------------------------------------------------------------");
            System.out.println("Nome:"+p.getNome()+ "Equipe:"+ e.getNome() + "Carro:"+ c.getCor());
            System.out.println("------------------------------------------------------------------");
        }
    }

    public int iniciaPartida() {
        String op;
        System.out.println("Participantes da Corrida:");
        percorreParticipantes();
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Client0001 client = new Client0001();
        Socket socket = new Socket("localhost", 5555);
        int repeat = 0;

        do {
            int controle = client.menuPrincipal();
            switch (controle) {

                case 1:
                    do {
                        repeat = client.cadastroCarros();
                    } while (repeat == 1);
                    break;

                case 2:
                    do {
                        repeat = client.cadastroParticipantes();
                    } while (repeat == 1);
                    break;

            }
        } while (repeat == 0);

    }
    /*System.out.println("Realizar novo cadastro?\n" + "S/N");
            opcao = Console.readString();
            
            //} while (opcao.equals('S'));
     */ /*
        System.out.println("Bem vindo cliente");
        
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