package servidor.model;

import java.io.Serializable;
import servidor.util.Command;

public class Mensagem implements Serializable {
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
