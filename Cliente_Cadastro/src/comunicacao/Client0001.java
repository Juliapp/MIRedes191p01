package comunicacao;

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
import clienteCad.model.Jogador;
import java.net.InetAddress;
import java.util.ArrayList;

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

    public int menuPrincipal(Socket socket) throws IOException {
        int opc;
        System.out.println("Menu Internet dos Brinquedos");
        System.out.println("1- Realizar Cadastro de Carros\n"
                + "2- Realizar Cadastro de Participantes"
                + "3- Iniciar Partida");
        opc = Console.readInt();
        return opc;
    }

    public int cadastroCarros(Socket socket) throws IOException, ClassNotFoundException {
        String op;
        System.out.println("Infome a tag do carro(ID)!");
        String tag = Console.readString();

        System.out.println("Informe a cor do carro!");
        String cor = Console.readString();

        System.out.println("Informe a equipe pertencente!");
        String equipe = Console.readString();

        String[] obj = {tag, cor, equipe};

        Mensagem msg = new Mensagem(Command.CadCarro, obj, Solicitante.ClienteCad);

        enviaMensagem(socket, msg);

        System.out.println("Deseja cadastrar novamente? S/N");
        op = Console.readString();
        if (op.equals("S")) {
            return 1;
        } else {
            return 0;
        }

    }

    public void iteraArrayCarros(Socket socket) throws IOException, ClassNotFoundException {

        Mensagem msg = new Mensagem(Command.IterarCarros, null, Solicitante.ClienteCad);
        ArrayList<Carro> carros = (ArrayList<Carro>) solicitaMensagem(socket, msg);

        int count = 1;
        while (carros.iterator().hasNext()) {
            Carro c = (Carro) carros.iterator().next();
            System.out.println(count + c.getTag() + c.getCor() + c.getEquipe().getNome());
            count++;
        }

    }

    public int cadastroJogadores(Socket socket) throws IOException, ClassNotFoundException {
        String op;
        System.out.println("Informe o seu nome:");
        String nome = Console.readString();

        System.out.println("Escolha o seu carro inserindo a cor!");
        //iteraArrayCarros();

        String numCarro = Console.readString();
        iteraArrayCarros(socket);

        String[] obj = {numCarro, nome};

        System.out.println("Deseja cadastrar novamente? S/N");
        op = Console.readString();
        if (op.equals("S")) {
            return 1;
        } else {
            return 0;
        }

    }

    public void enviaMensagem(Socket socket, Mensagem obj) throws IOException, ClassNotFoundException {

        Object objeto = (Object) obj;

        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

        os.writeObject(objeto);
        os.flush();

        System.out.println(is.readUTF());
        os.close();
        is.close();
        socket.close();

    }

    public Object solicitaMensagem(Socket socket, Mensagem msg) throws IOException, ClassNotFoundException {
        Object objeto = (Object) msg;

        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

        os.writeObject(objeto);
        os.flush();

        return is.readObject();
    }

    public void percorreParticipantes() { //Esse método vai ser introduzido no outro cliente!!!
        Iterator<Jogador> iter_Part = cc.getParticipantes().iterator();
        while (iter_Part.hasNext()) {
            Jogador part = (Jogador) iter_Part.next();
            Carro c = part.getCarro();
            Piloto p = part.getPiloto();
            Equipe e = p.getEquipe();
            System.out.println("------------------------------------------------------------------");
            System.out.println("Nome:" + p.getNome() + "Equipe:" + e.getNome() + "Carro:" + c.getCor());
            System.out.println("------------------------------------------------------------------");
        }
    }

    public int iniciaPartida() {
        String op;
        System.out.println("Participantes da Corrida:");
        percorreParticipantes();
        return 0;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Client0001 client = new Client0001();
        try {
            int repeat = 0;
            //Ta dando Erroooooo
            do {
                InetAddress ip = InetAddress.getByName("localhost");
                Socket socket = new Socket(ip, 5555);
                int controle = client.menuPrincipal(socket);
                switch (controle) {

                    case 1:
                        do {
                            repeat = client.cadastroCarros(socket);
                        } while (repeat == 1);
                        break;

                    case 2:
                        do {
                            repeat = client.cadastroJogadores(socket);
                        } while (repeat == 1);
                        break;

                }
            } while (repeat == 0);
        } catch (Exception e) {
        }

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
