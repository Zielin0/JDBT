package xyz.zielinus.jdbt.commands;

import lombok.Data;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;

@Data
public abstract class Command {

    protected final String name;
    protected final Category category;
    protected final boolean ownerOnly;
    protected final String[] aliases;

    protected Command(String name, Category category, boolean ownerOnly, String... aliases) {
        this.name = name;
        this.category = category;
        this.ownerOnly = ownerOnly;
        this.aliases = aliases;
    }

    public void execute(JDA client, Message message, String[] args) {}


    public enum Category {
        ADMIN, INFO, MISC, OWNER;
    }
}
