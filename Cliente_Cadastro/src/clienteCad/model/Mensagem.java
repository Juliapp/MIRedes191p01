package clienteCad.model;

public class Mensagem {
    public Command command;
    public Object object;

    public Mensagem(Command command, Object object) {
        this.command = command;
        this.object = object;
    }
}
