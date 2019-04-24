/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import servidor.execoes.PilotoNaoExisteException;
import servidor.model.Jogador;
import servidor.model.Mensagem;
import servidor.util.Command;

/**
 *
 * @author Teeu Guima
 */
public class ControllerDeTratamento {
    private static ControllerDeTratamento controll;
    private ServidorFacade sf;
    
    public ControllerDeTratamento(){
        this.sf = new ServidorFacade();
    }
    public static ControllerDeTratamento getInstance(){
        if(controll == null){
            controll = new ControllerDeTratamento();
        }
        return controll;
    }
    
    private void enviarResposta(Socket cliente, Mensagem msg){
        try {
            ObjectOutputStream os = new ObjectOutputStream(cliente.getOutputStream());
            os.writeObject(msg);
            os.flush();
            cliente.close();
        } catch (IOException e) {
        
            e.printStackTrace();
        }
    }
    
    public void cadastrarJogador(Socket cliente, Mensagem msg) throws PilotoNaoExisteException{
        ArrayList<Jogador> parts = (ArrayList<Jogador>) msg.getObject();
        
        for(int i=0; i <= parts.size(); i++){
            Jogador jgd = parts.get(i);
            sf.CadastrarJogador(jgd.getCarro().getTag(), jgd.getPiloto().getNome());
            sf.cadastrarCarro(jgd.getCarro().getTag(), jgd.getCarro().getCor(), jgd.getPiloto().getEquipe().getNome());
            sf.cadastrarEquipe(jgd.getPiloto().getEquipe().getNome());
            sf.cadastrarPiloto(jgd.getPiloto().getNome(), jgd.getPiloto().getFoto());
        }
        
    }
    
    public void cadastrarCarro(Socket cliente, Mensagem msg){
        String[] obj = (String[]) msg.getObject();
        
        if(sf.cadastrarCarro(obj[0], obj[1], obj[2])){
            String status = "Carro Cadastrado";
            Mensagem msgResposta = new Mensagem(Command.CadCarro, status);
            this.enviarResposta(cliente, msgResposta);
        }else{
            String status = "Erro no cadastro";
            Mensagem msgResposta = new Mensagem(Command.CadCarro, status);
            this.enviarResposta(cliente, msgResposta);
        }
            
    }
}

