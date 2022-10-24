package xyz.zielinus.jdbt.events.impl;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import org.jetbrains.annotations.NotNull;
import xyz.zielinus.jdbt.events.Event;

public class ReadyEvent extends Event {
    public ReadyEvent(JDA bot) {
        super("onReady", bot);
    }

    @Override
    public void onReady(@NotNull net.dv8tion.jda.api.events.session.ReadyEvent event) {
        bot.getPresence().setActivity(Activity.of(Activity.ActivityType.WATCHING, "github/Zielin0/JDBT"));
        System.out.println(bot.getSelfUser().getAsTag() + " is now Online!");
    }
}
