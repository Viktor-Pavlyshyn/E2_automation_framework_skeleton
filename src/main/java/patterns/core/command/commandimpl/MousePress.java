package patterns.core.command.commandimpl;

import patterns.core.command.Command;

public class MousePress implements Command {
    @Override
    public void execute() {
        System.out.println("mouse press");
    }
}
