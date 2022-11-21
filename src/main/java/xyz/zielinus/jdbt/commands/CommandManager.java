package xyz.zielinus.jdbt.commands;

import lombok.Getter;
import lombok.Setter;
import xyz.zielinus.jdbt.commands.impl.misc.TestCommand;

import java.util.HashMap;

public class CommandManager {

    @Getter
    private final HashMap<String[], Command> commands;

    @Getter
    @Setter
    private String prefix;

    public CommandManager(String prefix) {
        this.commands = new HashMap<>();

        this.prefix = prefix;
    }

    public void registerCommand(Command command) {
        commands.put(command.aliases ,command);
    }

    public void registerCommands() {
        registerCommand(new TestCommand());
    }

    public Command getCommandByName(String name) {
        for (Command command : commands.values()) {
            if (command.getName().equalsIgnoreCase(name))
                return command;
        }
        return null;
    }

    public Command getCommandByAlias(String alias) {
        for (Command command : commands.values()) {
            for (String al : command.aliases) {
                if (al.equalsIgnoreCase(alias))
                    return command;
            }
        }
        return null;
    }

}
