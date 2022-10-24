package xyz.zielinus.jdbt;

import lombok.Getter;
import lombok.SneakyThrows;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import xyz.zielinus.jdbt.commands.CommandManager;
import xyz.zielinus.jdbt.events.Event;
import xyz.zielinus.jdbt.events.EventManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {

    @Getter
    public static JDA bot;

    @Getter
    private static String ownerID;

    static Collection<GatewayIntent> intents = new ArrayList<>(Arrays.asList(
            GatewayIntent.GUILD_MEMBERS,
            GatewayIntent.GUILD_BANS,
            GatewayIntent.GUILD_EMOJIS_AND_STICKERS,
            GatewayIntent.GUILD_WEBHOOKS,
            GatewayIntent.GUILD_INVITES,
            GatewayIntent.GUILD_VOICE_STATES,
            GatewayIntent.GUILD_PRESENCES,
            GatewayIntent.GUILD_MESSAGES,
            GatewayIntent.GUILD_MESSAGE_REACTIONS,
            GatewayIntent.GUILD_MESSAGE_TYPING,
            GatewayIntent.DIRECT_MESSAGES,
            GatewayIntent.DIRECT_MESSAGE_REACTIONS,
            GatewayIntent.DIRECT_MESSAGE_TYPING,
            GatewayIntent.MESSAGE_CONTENT
    ));

    public static CommandManager commandManager;

    @SneakyThrows
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        commandManager =  new CommandManager("!");

        System.out.println("Welcome To Java Discord Bot Template");
        System.out.println("By: Zielino");

        if (args.length < 2) {
            throw new Exception("Usage: jdbt.jar <token> <ownerID>");
        }

        String token = args[0];
        ownerID = args[1];

        bot = JDABuilder.createDefault(token)
                .enableIntents(intents)
                .build();

        commandManager.registerCommands();

        eventManager.registerEvents(bot);
        for (Event e : eventManager.getEvents()) {
            bot.addEventListener(e);
        }
    }

}
