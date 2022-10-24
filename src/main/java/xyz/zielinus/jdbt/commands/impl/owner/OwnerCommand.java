package xyz.zielinus.jdbt.commands.impl.owner;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import xyz.zielinus.jdbt.commands.Command;

public class OwnerCommand extends Command {
    public OwnerCommand() {
        super("owner", Category.OWNER, true);
    }

    @Override
    public void execute(JDA client, Message message, String... args) {
        message.reply("Owner Command Works!").queue();
    }
}
