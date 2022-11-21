package xyz.zielinus.jdbt.events.impl;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
import xyz.zielinus.jdbt.Main;
import xyz.zielinus.jdbt.commands.Command;
import xyz.zielinus.jdbt.events.Event;

public class MessageEvent extends Event {
    public MessageEvent(JDA bot) {
        super("messageCreate", bot);
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String messageRaw = event.getMessage().getContentRaw();
        if (event.getAuthor().isBot()) return;
        if (messageRaw.startsWith(Main.commandManager.getPrefix())) {
            if (!(messageRaw.split(Main.commandManager.getPrefix()).length > 0)) return;

            String commandName = messageRaw.split(Main.commandManager.getPrefix())[1].split(" ")[0];
            String[] args = messageRaw.split(" ");

            Command command = Main.commandManager.getCommandByName(commandName) == null ? Main.commandManager.getCommandByAlias(commandName) : Main.commandManager.getCommandByName(commandName);

            if (command == null) return;

            if (command.isOwnerOnly() && !event.getAuthor().getId().equals(Main.getOwnerID())) {
                event.getMessage().reply("❌ This is a **ownerOnly** command").queue();
                return;
            }

            command.execute(bot, event.getMessage(), args);
        }

    }
}
