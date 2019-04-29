/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensor;

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

    public void lançaTags() throws IOException, ClassNotFoundException {
        transm.recebeMensagem();

        Mensagem msg = (Mensagem) transm.dadoRecebido();

        switch (msg.getCommand()) {
            case ComecarPartida:

                cronometro.comecar();
                while (true) {
                    while (this.count <= this.tempo) {
                        count++;
                    }
                    if (count == this.tempo) {
                        Random num = new Random();
                        TagColetada tag = new TagColetada(tags[num.nextInt(4)], cronometro.getCronometro());
                        Mensagem msg1 = new Mensagem(Command.EnviarTags, tags, Solicitante.Sensor);
                        transm.enviaMensagem(msg);
                        this.count = 0;
                    }
                    break;
                }
        }
        

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Sensor sensor = new Sensor();
        try {
            sensor.lançaTags();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
