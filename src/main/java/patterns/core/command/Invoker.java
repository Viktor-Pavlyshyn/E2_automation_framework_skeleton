package patterns.core.command;

public class Invoker {
    Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void runCommand (){
        command.execute();
    }
}
