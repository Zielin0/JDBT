package xyz.zielinus.jdbt.commands.impl.misc;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import xyz.zielinus.jdbt.commands.Command;

public class TestCommand extends Command {
    public TestCommand() {
        super("test", Category.MISC, false, "t", "tst");
    }

    @Override
    public void execute(JDA client, Message message, String[] args) {
        message.getChannel().sendMessage("Test Command Works!").queue();
    }
}
