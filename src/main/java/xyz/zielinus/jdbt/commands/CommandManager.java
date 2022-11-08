package xyz.zielinus.jdbt.commands;

import lombok.Getter;
import lombok.Setter;
import xyz.zielinus.jdbt.commands.impl.misc.TestCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    @Getter
    private final List<Command> commands;

    @Getter
    @Setter
    private String prefix;

    public CommandManager(String prefix) {
        this.commands = new ArrayList<>();

        this.prefix = prefix;
    }

    public void registerCommand(Command command) {
        commands.add(command);
    }

    public void registerCommands() {
        registerCommand(new TestCommand());
    }

    public Command getCommand(String name) {
        for (Command command : commands) {
            if (command.getName().equalsIgnoreCase(name))
                return command;
        }
        return null;
    }

}
