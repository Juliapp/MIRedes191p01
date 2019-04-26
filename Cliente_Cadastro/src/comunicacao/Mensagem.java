package comunicacao;

import java.io.Serializable;

public class Mensagem implements Serializable {

    private static final long serialVersionUID = 1L;
    private Command command;
    private Object object;

    public Mensagem(Command command, Object object) {
        this.command = command;
        this.object = object;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
