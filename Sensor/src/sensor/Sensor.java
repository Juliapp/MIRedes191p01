/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensor;

import comunicacao.Command;
import comunicacao.Cronometro;
import comunicacao.Mensagem;
import comunicacao.Solicitante;
import comunicacao.Transmissao;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import model.TagColetada;

/**
 *
 * @author Teeu Guima
 */
public class Sensor {

    private final int tempo = 10000;
    private String[] tags = {"EPC00000", "EPC00001", "EPC00002", "EPC00003"};
    private int count = 0;
    private Transmissao transm;
    private Cronometro cronometro;

    public Sensor() {
        this.transm = new Transmissao();
        this.cronometro = new Cronometro();
    }

    public boolean verificaPermissao() throws IOException, ClassNotFoundException {
        transm.enviaMensagem(new Mensagem(Command.StatusCorrida, null, Solicitante.Sensor));
        if ((boolean) transm.dadoRecebido() == false) {
            System.out.println("Deu Erro!");
        } else {
            System.out.println("Passou Carai!!!");
        }
        return (boolean) transm.dadoRecebido();
    }

    public void lançaTags() throws IOException, ClassNotFoundException {
        Random num = new Random();
        String[] ordem = new String[3]; //Cria um array para colocar uma ordem nas tags
        for (int i = 0; i <= tags.length; i++) {
            ordem[i] = tags[num.nextInt(3)]; //Adiciona a tag pré-cadastrada com uma posição aleatória!
            TagColetada tag = new TagColetada(ordem[i], cronometro.getCurrentTime()); //Cria o objeto TagColetada pra obter o tempo exato do cronometro
            Mensagem msg = new Mensagem(Command.EnviarTags, tag, Solicitante.Sensor); //Cria o objeto Mensagem pra enviar pro servidor as informações coletadas do sensor!
            transm.enviaMensagem(msg);
        }
        if ((boolean) transm.dadoRecebido() == true) {
            System.out.println("Tag Coletada pelo servidor!");
        }
    }

    public boolean observador() throws ClassNotFoundException, IOException, InterruptedException {
        boolean status;

        do {
            Thread.sleep(5000);
            status = verificaPermissao();
            System.out.println("Enviando Tags.......");

        } while (status == false);
        return status;

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Sensor sensor = new Sensor();

        try {
            //O laço termina se a permissão for true, ou seja ter dado a largada na corrida

            while (sensor.observador() == true) {
                sensor.cronometro.comecar(); //Começa a contagem!
                while (true) {
                    Thread.sleep(40000); //Espera 10 segs pra enviar as tags
                    sensor.lançaTags(); //Chama o método que enviar para o servidor as tags!
                    System.out.println("Tags enviadas.......");
                }
            }

        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
