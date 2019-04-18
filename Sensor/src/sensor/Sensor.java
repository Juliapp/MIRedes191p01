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

/**
 *
 * @author Teeu Guima
 */
public class Sensor {

    private final int tempo = 10000;
    private String[] tags = {"EPC00000", "EPC00001", "EPC00002", "EPC00003"};

    public static void main(String[] args) throws IOException {
        Sensor sensor = new Sensor();
        Socket socket = new Socket("localhost", 5555);
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        boolean repeat = true;
        do {
            int count = 0;
            while (count <= sensor.tempo) {
                count++;
            }
            if (count == sensor.tempo) {
                System.out.println(count);
                os.writeObject(sensor.tags);
                os.close();
                socket.close();
            }
        } while (repeat);
    }

}
