package patterns.main;

import patterns.core.command.Invoker;
import patterns.core.command.commandimpl.MouseClick;
import patterns.core.command.commandimpl.MousePress;

public class CommandTest {
    public static void main(String[] args) {
        Invoker invoker = new Invoker(new MouseClick());
        invoker.runCommand();

        Invoker invoker2 = new Invoker(new MousePress());
        invoker2.runCommand();
    }
}
