package patterns.core.command.commandimpl;

import patterns.core.command.Command;

public class MouseClick implements Command {
    @Override
    public void execute() {
        System.out.println("mouse click");
    }
}
